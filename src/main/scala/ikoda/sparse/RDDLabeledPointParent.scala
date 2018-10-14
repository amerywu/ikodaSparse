package ikoda.sparse

import java.io.File
import java.util.UUID

import ikoda.IKodaMLException
import ikoda.utilobjects.{SparkConfProviderWithStreaming, UtilFunctions}
import ikoda.utils.TicToc
import org.apache.spark.ml.feature.LabeledPoint
import org.apache.spark.mllib
import org.apache.spark.partial.BoundedDouble
//import org.apache.spark.ml.feature.LabeledPoint


import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame}

import scala.collection.mutable


/**
  * @groupname dp Data Attributes
  * @groupname load Loading and Saving
  * @groupname cpt Data Computation
  * @groupname man Data Manipulation
  *
  *
  * @param ilp
  */
@SerialVersionUID(12345237L)
abstract class RDDLabeledPointParent(ilp:LpData)  extends  Serializable with UtilFunctions with SparkConfProviderWithStreaming
{



  private [sparse] var columnCountOffset:Int = 0

  /**
    * Estimated row count with 5000 millisecond window for calculation
    * @group dp
    */
  lazy val rowCountEstimate:Double = rowCountEstimate(5000)

  /**
    * Precise row count
    * @group dp
    */
  lazy val rowCount:Long = rowCountCollected()

  protected [sparse] var path:String="."


  private [sparse] def repartitionRddOnEstimate(): RDD[(LabeledPoint,Int,String)] =
  {
    val countApprox:BoundedDouble=ilp.dataRDD.countApprox(30000,0.95).getFinalValue()
    logger.debug("confidence "+countApprox.confidence)
    countApprox.confidence match
    {
      case x if(x>0.9) =>
        val size:Double=countApprox.mean
        logger.debug("Estimated row count is "+size)
        size match
        {
          case x if (x <= 1000) =>
            ilp.dataRDD.repartition(10)
          case x if (x > 1000 && x <= 10000) =>
            ilp.dataRDD.repartition((size/100).toInt )
          case x if (x > 10000 && x <= 1000000) =>
            ilp.dataRDD.repartition((size/1000).toInt )
          case x if (x > 1000000) =>
            ilp.dataRDD.repartition((size/5000).toInt )
        }
      case _ => ilp.dataRDD.repartition(2000)
    }
  }

  private [sparse] def clear(): Unit =
  {
    ilp.dataRDD.unpersist()
  }

  def lpHash(labeledPoint: LabeledPoint): Int =
  {
    (labeledPoint.label+labeledPoint.features.toSparse.values.mkString(",")+labeledPoint.features.toSparse.indices.mkString(",")).hashCode
  }

  private [sparse] def lpDebugString(labeledPoint: LabeledPoint): String =
  {
    labeledPoint.label+labeledPoint.features.toSparse.values.mkString(",")+labeledPoint.features.toSparse.indices.mkString(",")+"    "+lpHash(labeledPoint)
  }


  /**
    * Returns column count, row count, target count and number of partitions
    * @group dp
    * @return
    */
  def info():String =
  {
    val sb:mutable.StringBuilder=new mutable.StringBuilder()
    sb.append(s"\n${ilp.name}")
    sb.append(s"\nRows (Estimated): ${rowCountEstimate}")
    sb.append(s"\nColumns: ${columnCount}  - $columnCountOffset = ${columnCount-columnCountOffset}")
    sb.append(s"\nTargets: ${getTargets().size}")
    sb.append(s"\n Partitions: ${ilp.dataRDD.partitions.size}")
    sb.toString
  }




  private def rowCountEstimate(timeOut:Long): Double =
  {
    val countApprox:BoundedDouble=ilp.dataRDD.countApprox(timeOut,0.90).getFinalValue()

    logger.debug("confidence "+countApprox.confidence)
    countApprox.confidence match
    {
      case x if(x>0.9) =>
        logger.debug("Estimated row count is "+countApprox.mean)
        countApprox.mean

      case _ => logger.debug("Failed to get estimate")
        -1.0
    }
  }

  /**
    * True if there are no features/columns in the column map
    * @group dp
    * @return
    */
  def isEmpty(): Boolean =
  {
    ilp.columnHeadMap.isEmpty
  }

  ////////////////Function Definitions
  type FTDoubleDouble_Double = (Double, Double) => Double

  /**
    * Function definition
    * @group cpt
    */
  val _dividedBy: FTDoubleDouble_Double =
  {
    _ / _.toDouble
  }

  /**
    * Function definition
    * @group cpt
    */
  def _multipliedBy: FTDoubleDouble_Double =
  {
    _ * _.toDouble
  }


  /**
    * Maps a copy of all data in current RDDLabeledPoint
    * @group dp
    * @return
    */
  def copy(): RDDLabeledPoint =
  {
    val data = sparseData().map(r => r)
    new RDDLabeledPoint(data,copyColumnMap,copyTargetMap,getName())
  }
  /**
    * Maps a copy of the Target Map
    * @group dp
    * @return
    */
  def copyTargetMap: Map[String,Double] =
  {
    ilp.targetMap.map{case (k,v) => (k -> v)}
  }

  /**
    * Maps a copy of the Column  Map
    * @group dp
    * @return
    */
  def copyColumnMap: mutable.ListMap[Int, ColumnHeadTuple] =
  {
    ilp.columnHeadMap.map{

      c=> c._1 ->   c._2
    }
  }
  /**
    * Targets as text -> numeric
    * @group dp
    * @return
    */
  def getTargets(): Map[String,Double] =
  {
    ilp.targetMap

  }

  /**
    * The top n rows as a String
    * @group dp
    * @return
    */
  def show(rows:Int): String =
  {
    val sb:StringBuilder=new mutable.StringBuilder()
    sb.append("\n")
    ilp.dataRDD.take(rows).foreach
    {
      r=>
      sb.append("Uuid:")
        sb.append(r._3)
        sb.append(" | ")
        sb.append("Hash: ")
        sb.append(r._2)
        sb.append(" | ")
        sb.append("Label: ")
        sb.append(r._1.label)
        sb.append(" | ")
        sb.append("Indices: [")
        sb.append(r._1.features.toSparse.indices.mkString(","))
        sb.append("] | ")
        sb.append("Values: {")
        sb.append(r._1.features.toSparse.values.mkString(","))
        sb.append("} \n")

    }
    sb.append("\n")
    sb.toString()
  }





  /**
    * The value specified at a given index of a LabeledPoint
    * @group dp
    * @return
    */
  def getCellValue(lp:LabeledPoint,colIdx:Int): Option[Double] =
  {
    try
    {
      val map: mutable.HashMap[Int, Double] = new mutable.HashMap[Int, Double]()
      lp.features.toSparse.indices.zipWithIndex.foreach
      { r => map.put(r._1, lp.features.toSparse.values(r._2)) }
      map.get(colIdx)
    }
    catch
      {
        case e:Exception => None
      }

  }
  private [sparse] def getOptionValueOrThrowException[A](oa: Option[A]) = oa.getOrElse(throw new RuntimeException("Can't get Option"))

  /**
    * The user defined name of this dataset.
    * @group dp
    * @return
    */
  def getName(): String =
  {
    ilp.name
  }


  /***
    * Returns RDD[org.apache.spark.mllib.regression.LabeledPoint] for older versions of Spark machine learning
    * @group man
    * @throws ikoda.IKodaMLException
    * @return
    */
  @throws(classOf[IKodaMLException])
  def convertToMLLibPackageRDD(): RDD[org.apache.spark.mllib.regression.LabeledPoint] =
  {
    try
    {
      lpData().map
      {
        lp =>
          val mlVec = mllib.linalg.Vectors.fromML(lp.features)
          new org.apache.spark.mllib.regression.LabeledPoint(lp.label,mlVec)
      }

    }
    catch
    {
      case e: Exception =>
        logger.error(s"${ilp.name}")
        throw new Exception(s"${ilp.name} : ${e.getMessage}",e)
    }
  }



  private [sparse] def makeFullPath( dir:String, file:String): String=
  {
    if(dir.endsWith(File.separator))
      {
        dir+file
      }
    else
      {
        dir+File.separator+file
      }
  }




  /**
    * The name, i.e., text value, of a target specified by its numeric value
    * @group dp
    * @return
    */
  @throws(classOf[Exception])
  def getTargetName(targetId:Double): String =
  {
    try
    {
      val map=ilp.targetMap.map(_.swap)
      map.getOrElse(targetId,s"UNKNOWN_${targetId}")
    }
    catch
    {
      case e: Exception =>
      {
        logger.error(s"${ilp.name}")
        throw new Exception(s"${ilp.name} : ${e.getMessage}", e)
      }
    }
  }


  /**
    * The number of distinct targets/labels in the data set
    * @group dp
    * @return
    */
  def targetCount():Int=
  {
    ilp.targetMap.size
  }


  /**
    * Returns the numeric value of a label from its text value
    * @group dp
    * @return
    */
  @throws(classOf[Exception])
  def getTargetId(targetName:String): Option[Double] =
  {
    try
    {

      ilp.targetMap.get(targetName)
 
    }
    catch
    {
      
      case e: Exception =>
      {
        logger.error(s"${ilp.name}")
        throw new Exception(s"${ilp.name} : ${e.getMessage}", e)
      }
    }
  }

  /**
    * Creates a UUID if the given input is invalid, otherwise converts the input to UUID
    * @group dp
    * @return
    */
  def getOrCreateUUID(strUUID:String):UUID=
  {
    strUUID match
      {
      case x if(Option(x).isEmpty) => UUID.randomUUID()
      case x if (x.length <12) => UUID.randomUUID()
      case _ => UUID.fromString(strUUID)
    }
  }

  private [sparse] def createUUID():UUID=
  {
    UUID.randomUUID()
  }








  /**
    * the actual number of columns/features with at least one active value in the dataset
    * @group dp
    * @return
    */
  def columnCountFromDataRDD(): Long =
  {

    val result=repartitionRddOnEstimate().flatMap
    {
      row => row._1.features.toSparse.indices
    }.distinct()

     result.count


  }

  /**
    * Returns the numeric value of a label from its text value
    * @group dp
    * @return
    */
  private def rowCountCollected(): Long =
  {
    val tt:TicToc=new TicToc
    tt.tic("rowCountCollected")
    val count=lpData().map(r => r.label).count()
    logger.debug(tt.toc("rowCountCollected"))
    count
  }

  /**
    * A set of columns/features that represents all features that have at least one active value in the dataset
    * @group dp
    * @return
    */
  def columnsFromDataRDD(): Set[Int] =
  {
    val tt:TicToc=new TicToc
    logger.debug(tt.tic("columnsFromDataRDD"))


    val colMap=sparseData().flatMap
    {
      row => row._1.features.toSparse.indices
    }.distinct.collect().toSet

    logger.debug(tt.toc("columnsFromDataRDD"))
    colMap


  }


  /**
    * Repartiions the RDD data
    * @group man
    * @param partitions
    */
  def  repartition(partitions:Int):Unit=
  {

     ilp.dataRDD.repartition(partitions)

  }






  /**
    * Number of columns in the column map. This may or may not == columnsFromDataRDD.size depending
    * on whether data was validated when loaded and whether or not rows have been removed
    * @group dp
    * @return
    */
  def columnCount: Int =
  {
   // logger.debug(columnHeadMap.values.map(ch => ch.stringLabel).toList.sorted.mkString(","))
    ilp.columnHeadMap.size
  }

  /**
    * The max index value in the column map. This may be higher than the actual column count if columns have been removed from the data
    * @group dp
    * @return
    */
  def columnMaxIndex: Int=
  {
     ilp.columnHeadMap.size ==0 match
       {
       case true => 0
       case false => ilp.columnHeadMap.keySet.max
     }
  }

  /**
    * The max numeric value of the targets
    * @group dp
    * @return
    */
  def targetMaxValue: Double=
  {
    ilp.targetMap.size ==0 match
    {
      case true => 0
      case false => ilp.targetMap.values.max
    }
  }


  /**
    * The row ids for every row of the dataset
    * @group dp
    * @return
    */
  @throws(classOf[IKodaMLException])
  def getRowIds:Seq[String]=
  {
    try
    {
      ilp.dataRDD.map(r=> r._3).collect()
    }
    catch
    {
      case e:Exception => throw new IKodaMLException(s"${ilp.name} getRowCount ${e.getMessage}",e)
    }
  }


  /**
    * The row id and label for every row in the data set
    * @group dp
    * @return
    */
  @throws(classOf[IKodaMLException])
  def getRowIdAndLabel:Seq[(String,Double)]=
  {
    try
    {
      ilp.dataRDD.map(r=> (r._3,r._1.label)).collect()
    }
    catch
    {
      case e:Exception => throw new IKodaMLException(s"${ilp.name} getRowCount ${e.getMessage}",e)
    }
  }


  /**
    * Gets the column/feature text value from the given numeric index
    * @group dp
    * @return
    */
  def getColumnName(colIndex: Int): String =
  {
    ilp.columnHeadMap.nonEmpty match {
      case true =>
        val o: Option[ColumnHeadTuple] = ilp.columnHeadMap.values.find (ch => ch.numericLabel == colIndex)
        if (o.isDefined)
        {
           o.get.stringLabel
        }
        else {
        "Not Found"
        }
      case false => "Not Found"
    }
  }

  /**
    * Gets the column/feature text value as Option from the given numeric index
    * @group dp
    * @return
    */
  def getColumnNameAsOption(colIndex: Int): Option[String] =
  {
    ilp.columnHeadMap.nonEmpty match {
      case true =>
        val o: Option[ColumnHeadTuple] = ilp.columnHeadMap.values.find (ch => ch.numericLabel == colIndex)
        if (o.isDefined)
        {
          Some(o.get.stringLabel)
        }
        else {
          None
        }
      case false => None
    }
  }

  /**
    * Map Int -> String for each column index and its text value
    * @group dp
    * @return
    */
  def columnIndexNameMap(): Map[Int,String] =
  {
    ilp.columnHeadMap.nonEmpty match {
      case true => ilp.columnHeadMap.map(e => e._1 -> e._2.stringLabel).toMap

      case false => mutable.HashMap[Int,String]().toMap
    }
  }

  /**
    * Gets the column/feature index for a given column/feature name
    * Returns -1 if column not found
    * suppressWarnings = true to prevent logging "not found" column indices
    *
    * @group dp
    * @return
    */
  def getColumnIndex(colName:String, suppressWarnings:Boolean=false): Int =
  {
    ilp.columnHeadMap.nonEmpty match
    {
      case true=>


        val o: Option[ColumnHeadTuple] = ilp.columnHeadMap.values.find (ch => ch.stringLabel == colName)

        if (o.isDefined) {
        o.get.numericLabel
        }
        else {
        if (! suppressWarnings) {
        logger.warn (s"Column Index not found for $colName")

        }
        - 1
    }
      case false =>
        logger.warn (s"Empty map")
        -1
    }
  }

  /**
    * Gets the columns/features text values as one csv String
    *
    * @group dp
    * @return
    */
  def columnHeadsAsString(): String =
  {
    

    ilp.columnHeadMap.values.map(ch => ch.stringLabel).toList.sorted.mkString(",")
  }

  /**
    * Gets the columns/features text values as List[String]
    *
    * @group dp
    * @return
    */
  def columnHeadsStringList(): List[String] =
  {
    
    ilp.columnHeadMap.values.map(ch => ch.stringLabel).toList
  }
  /**
    * Columns/features text values as List[ColumnHeadTuple]
    *
    * @group dp
    * @return
    */
  def columnHeads(): List[ColumnHeadTuple] =
  {
    
    
    ilp.columnHeadMap.values.toList
  }



  /**
    * The full dataset along with each rowId and hashcode
    * @group dp
    * @return
    */
  def sparseData(): RDD[(LabeledPoint,Int,String)] =
  {
    ilp.dataRDD
  }

  /**
    * The full dataset as RDD[LabeledPoint]. RowIds not included
    * @group dp
    * @return
    */
  def lpData(): RDD[LabeledPoint] =
  {
    ilp.dataRDD.map(r=>r._1)
  }





  
}