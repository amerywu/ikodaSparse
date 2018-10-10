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

@SerialVersionUID(12345237L)
abstract class RDDLabeledPointParent(ilp:LpData)  extends  Serializable with UtilFunctions with SparkConfProviderWithStreaming
{


  private [sparse] val defaultPartitionSize:Int=1000
  private [sparse] var columnCountOffset:Int = 0


  protected [sparse] var path:String="."

  def labeledPointRdd ():RDD[LabeledPoint]=
  {
    ilp.dataRDD.map
    {
      r => r._1
    }
  }



  def repartitionRddOnEstimate(): RDD[(LabeledPoint,Int,String)] =
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

  def clear(): Unit =
  {
    ilp.dataRDD.unpersist()
  }

  def lpHash(labeledPoint: LabeledPoint): Int =
  {
    (labeledPoint.label+labeledPoint.features.toSparse.values.mkString(",")+labeledPoint.features.toSparse.indices.mkString(",")).hashCode
  }

  def lpDebugString(labeledPoint: LabeledPoint): String =
  {
    labeledPoint.label+labeledPoint.features.toSparse.values.mkString(",")+labeledPoint.features.toSparse.indices.mkString(",")+"    "+lpHash(labeledPoint)
  }


  def info():String =
  {
    val sb:mutable.StringBuilder=new mutable.StringBuilder()
    sb.append(s"\n${ilp.name}")
    sb.append(s"\nRows (Estimated): ${getRowCountEstimate}")
    sb.append(s"\nColumns: ${getColumnCount}  - $columnCountOffset = ${getColumnCount-columnCountOffset}")
    sb.append(s"\nTargets: ${getTargets().size}")
    sb.append(s"\n Partitions: ${ilp.dataRDD.partitions.size}")
    sb.toString
  }


  def getRowCountEstimate(): Double =
  {
    getRowCountEstimate(5000)

  }

  def getRowCountEstimate(timeOut:Long): Double =
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

  def isEmpty(): Boolean =
  {
    ilp.columnHeadMap.isEmpty
  }

  ////////////////Function Definitions
  type FTDoubleDouble_Double = (Double, Double) => Double

  val _dividedBy: FTDoubleDouble_Double =
  {
    _ / _.toDouble
  }


  val _multipliedBy: FTDoubleDouble_Double =
  {
    _ * _.toDouble
  }




  def copy(): RDDLabeledPoint =
  {
    val data = sparseData().map(r => r)
    new RDDLabeledPoint(data,copyColumnMap,copyTargetMap,getName())
  }

  def copyTargetMap: Map[String,Double] =
  {
    ilp.targetMap.map{case (k,v) => (k -> v)}
  }

  def copyColumnMap: mutable.ListMap[Int, ColumnHeadTuple] =
  {
    ilp.columnHeadMap.map{

      c=> c._1 ->   c._2
    }
  }

  def getTargets(): Map[String,Double] =
  {
    ilp.targetMap

  }


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
  def getOptionValueOrThrowException[A](oa: Option[A]) = oa.getOrElse(throw new RuntimeException("Can't get Option"))

  def getName(): String =
  {
    ilp.name
  }


  
  
  
  @throws(classOf[Exception])
  def getMLPackageLabeledPointsAsDataframe(): DataFrame =
  {
    try
    {
      val spark=getSparkSession()
      import spark.implicits._
      val mlLpArray:Array[org.apache.spark.ml.feature.LabeledPoint]=labeledPointRdd.collect().map
      {
        lp =>
    
          val mlVec: org.apache.spark.ml.linalg.Vector = lp.features
          new org.apache.spark.ml.feature.LabeledPoint(lp.label,mlVec)
  
      }
      val trainingData=spark.sparkContext.parallelize(mlLpArray)
      trainingData.toDF()
     
    }
    catch
    {
      
      case e: Exception =>
        logger.error(s"${ilp.name}")
        throw new Exception(s"${ilp.name} : ${e.getMessage}",e)
    }
  }
  
  @throws(classOf[IKodaMLException])
  def convertToMLLibPackageRDD(): RDD[org.apache.spark.mllib.regression.LabeledPoint] =
  {
    try
    {
      val mlLpArray:Array[org.apache.spark.mllib.regression.LabeledPoint]=labeledPointRdd.collect().map
      {
        lp =>
          val mlVec = mllib.linalg.Vectors.fromML(lp.features)
          new org.apache.spark.mllib.regression.LabeledPoint(lp.label,mlVec)
      }
      spark.sparkContext.parallelize(mlLpArray)
    }
    catch
    {
      case e: Exception =>
        logger.error(s"${ilp.name}")
        throw new Exception(s"${ilp.name} : ${e.getMessage}",e)
    }
  }
  


  def makeFullPath( dir:String, file:String): String=
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
  
  
  
  def targetCount():Int=
  {
    ilp.targetMap.size
  }
  
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


  def getOrCreateUUID(strUUID:String):UUID=
  {
    strUUID match
      {
      case x if(Option(x).isEmpty) => UUID.randomUUID()
      case x if (x.length <12) => UUID.randomUUID()
      case _ => UUID.fromString(strUUID)
    }
  }

  def createUUID():UUID=
  {
    UUID.randomUUID()
  }









  def columnCountFromDataRDD(): Long =
  {
    val tt:TicToc=new TicToc
    logger.debug(tt.tic("columnCountFromDataRDD 1"))


    val result=repartitionRddOnEstimate().flatMap
    {
      row => row._1.features.toSparse.indices
    }.distinct()
    logger.debug(tt.toc("columnCountFromDataRDD 1"))
    logger.debug(tt.tic("columnCountFromDataRDD 2"))
    val count=result.count
    logger.debug(tt.toc("columnCountFromDataRDD 2"))
    count

  }

  def getRowCountCollected(): Long =
  {
    val tt:TicToc=new TicToc
    tt.tic("getRowCountCollected")
    val count=lpData().map(r => r.label).count()
    logger.debug(tt.toc("getRowCountCollected"))
    count
  }

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



  
  def  repartition(partitions:Int):Unit=
  {

     ilp.dataRDD.repartition(partitions)

  }
  

  



  
  def getColumnCount: Int =
  {
   // logger.debug(columnHeadMap.values.map(ch => ch.stringLabel).toList.sorted.mkString(","))
    ilp.columnHeadMap.size
  }

  def getColumnMaxIndex: Int=
  {
     ilp.columnHeadMap.size ==0 match
       {
       case true => 0
       case false => ilp.columnHeadMap.keySet.max
     }
  }


  def getTargetMaxValue: Double=
  {
    ilp.targetMap.size ==0 match
    {
      case true => 0
      case false => ilp.targetMap.values.max
    }
  }
  


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

  def getColumnIndexNameMap(): Map[Int,String] =
  {
    ilp.columnHeadMap.nonEmpty match {
      case true => ilp.columnHeadMap.map(e => e._1 -> e._2.stringLabel).toMap

      case false => mutable.HashMap[Int,String]().toMap
    }
  }
  
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

  
  def columnHeadsAsString(): String =
  {
    

    ilp.columnHeadMap.values.map(ch => ch.stringLabel).toList.sorted.mkString(",")
  }
  
  def columnHeadsStringList(): List[String] =
  {
    
    ilp.columnHeadMap.values.map(ch => ch.stringLabel).toList
  }
  
  def getColumnHeads(): List[ColumnHeadTuple] =
  {
    
    
    ilp.columnHeadMap.values.toList
  }



  
  def sparseData(): RDD[(LabeledPoint,Int,String)] =
  {
    ilp.dataRDD
  }

  def lpData(): RDD[LabeledPoint] =
  {
    ilp.dataRDD.map(r=>r._1)
  }





  
}