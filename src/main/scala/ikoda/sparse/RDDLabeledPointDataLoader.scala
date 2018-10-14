package ikoda.sparse

import java.io.File
import java.util.UUID

import ikoda.utilobjects.DataFrameUtils
import ikoda.utils.TicToc
import org.apache.spark.SparkContext
import org.apache.spark.ml.feature.LabeledPoint
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.Dataset

import scala.collection.mutable
import scala.util.Try

/**
  * @groupname dp Data Attributes
  * @groupname load Loading and Saving
  * @groupname cpt Data Computation
  * @groupname man Data Manipulation
  *
  *
  * @param ilp
  */
class RDDLabeledPointDataLoader(ilp:LpData) extends RDDLabeledPointTransformations(ilp)
{

  @throws(classOf[Exception])
  private def loadColumnHeaders( path: String, isPj: Boolean = false): mutable.ListMap[Int,ColumnHeadTuple] =
  {
    try
    {
      var tempStr = path
      if (isPj)
      {
        tempStr = s"${truncateFilename(tempStr)}-columnMap.txt"
      }
      else
      {
        tempStr = s"${tempStr}-columnMap"
      }

      logger.debug(s"loadColumnHeaders $tempStr")
      val datamap: mutable.HashMap[String, Int] = mutable.HashMap()
      val rddString: RDD[String] = spark.sparkContext.textFile(s"${tempStr}")

      logger.debug(s" column (rdd format) size ${rddString.count()}")

      var count:Int=0
      val data = rddString.filter(s=>s.isEmpty==false).map
      {
        record =>
        val a = record.stripPrefix("ColumnHeadTuple(").stripSuffix(")").split(",")
        val k = a(0).toInt - 1
        val v = a(1)
        count=count+1
        (k, v)
      }
      if(data.isEmpty())
      {
        logger.warn("\n\nNO DATA IN COLUMN MAP\n\n\n")
      }
      val hm = data.collect().toMap
      val newcolmap=hm.keySet.map
      {
        k =>
          (k, new ColumnHeadTuple(k, hm.get(k).get))
      }
       mutable.ListMap[Int,ColumnHeadTuple](newcolmap.toSeq:_*)
    }
    catch
    {
      case e: Exception =>
      {
        logger.error(s"${ilp.name}")
        logger.error(s"Could not load columnHeadMap: ${e.getMessage}", e)
        throw new Exception(e)
      }
    }
  }



  @throws(classOf[Exception])
  private [sparse] def loadLibSvm(fileName: String, inpath: String, validateColumns:Boolean=false): RDDLabeledPoint =
  {
    try
    {
      path=inpath


      val name=fileName


      logger.info("Loading Target Map.")
      val newtargetmap=loadTargetMap( fileName, path)
      logger.debug("\n"+newtargetmap.mkString("\n"))
      logger.info("Loading Column Heads.")
      val newcolheads=loadColumnHeaders(fileName, path)


      logger.info(s"Loading LibSvm Data. $path${File.separator}${fileName}")

      val df= spark.read.format("libsvm").option("numFeatures", newcolheads.size).load(s"$path${File.separator}${fileName}_data_sparse")
      logger.info(DataFrameUtils.showString(df,5))

      val newdata:RDD[(LabeledPoint,Int,String)] = df.rdd.map
      {

        //r//ow => LabeledPoint(row.getDouble(0), row(4).asInstanceOf[Vector])
        r=> (LabeledPoint(r.getDouble(0), r(1).asInstanceOf[org.apache.spark.ml.linalg.Vector]),0,UUID.randomUUID().toString)
      }


      val sparseout=new RDDLabeledPoint(newdata,newcolheads,newtargetmap,name)
      logger.info(sparseout.info())
      if(validateColumns) {
        sparseout.validateColumnCount
      }
      sparseout
    }
    catch
    {
      case e: Exception =>
        logger.error(s"${ilp.name}")
        debugLibsvmFailure(spark.sparkContext,s"$path${File.separator}${fileName}")
        throw new Exception(s"${ilp.name} : ${e.getMessage}",e)
    }
  }


  @throws(classOf[Exception])
  private [sparse] def  loadLibSvmFromHelper(data:Dataset[(LabeledPoint,Int,String)], columns:mutable.ListMap[Int,ColumnHeadTuple], targets:Map[String,Double], datasetName:String, validateCompleteness:Boolean=false): RDDLabeledPoint =
  {
    try
    {
      val newData=data.rdd
      val name=datasetName
      logger.info("Loading Target Map.")
      val newtargets=targets
      logger.info("Loading Column Heads.")
      val newcolheads=columns
      val sparseout=new RDDLabeledPoint(newData,newcolheads,newtargets,name)
      logger.info(sparseout.info)
      if(validateCompleteness) {
        sparseout.validateColumnCount
      }
      sparseout
    }
    catch
    {
      case e: Exception =>
        logger.error(s"${ilp.name}")
        throw new Exception(s"${ilp.name} : ${e.getMessage}",e)
    }
  }


  @throws(classOf[Exception])
  private [sparse] def loadLibSvmFromHelper1(data:RDD[LabeledPoint], columns:mutable.ListMap[Int,ColumnHeadTuple], targets:Map[String,Double], datasetName:String, validateCompleteness:Boolean=false): RDDLabeledPoint =
  {
    try
    {

      val name=datasetName
      logger.info("Loading Target Map.")
      val newtargets=targets

      val dd:RDD[(LabeledPoint,Int,String)]=data.map{lp =>
        (lp,
          s"${lp.label}${lp.features.toSparse.indices}${lp.features.toSparse.values}".hashCode,
          createUUID().toString)}

      logger.info("Loading Column Heads.")
      val newcolheads=columns
      val sparseout=new RDDLabeledPoint(dd,newcolheads,newtargets,name)
      logger.info(sparseout.info)
      if(validateCompleteness) {
        sparseout.validateColumnCount
      }
      sparseout
    }
    catch
      {
        case e: Exception =>
          logger.error(s"${ilp.name}")
          throw new Exception(s"${ilp.name} : ${e.getMessage}",e)
      }
  }



  @throws(classOf[Exception])
  private [sparse] def loadLibSvmSchemaFromHelper1(columns:mutable.ListMap[Int,ColumnHeadTuple], targets:Map[String,Double],datasetName:String): RDDLabeledPoint =
  {
    try
    {
      val name=datasetName
      logger.info("Loading Target Map.")
      val newtargets=targets
      logger.info("Loading Column Heads.")
      val newcolmap=columns
      val sparseout=new RDDLabeledPoint(new LpData(None,Some(newcolmap),Some(newtargets),Some(name)))
      logger.info("loadLibSvmSchemaFromHelper1"+sparseout.info+" \n"+sparseout.getTargets().mkString(" | "))
      sparseout
    }
    catch
    {
      case e: Exception =>
        logger.error(s"${ilp.name}")
        throw new Exception(s"${ilp.name} : ${e.getMessage}",e)
    }
  }



  @throws(classOf[Exception])
  private def loadColumnHeaders( fileName: String, path: String): mutable.ListMap[Int,ColumnHeadTuple] =
  {
    try
    {
      loadColumnHeaders( s"$path${File.separator}${fileName}")
    }
    catch
    {
      case e: Exception =>
      {
        logger.error(s"${ilp.name}")
        logger.error(s"Could not load columnHeadMap: ${e.getMessage}", e)
        throw new Exception(s"${ilp.name} : ${e.getMessage}", e)
      }
    }
  }



  private [sparse] def truncateFilename(fn:String):String=
  {
    if (fn.toUpperCase.endsWith(".TXT"))
    {
      fn.substring(0, fn.length - 4)

    }
    else if (fn.toUpperCase.endsWith(".LIBSVM"))
    {
      fn.substring(0, fn.length - 7)
    }
    else
    {
      fn
    }
  }


  @throws(classOf[Exception])
  private [sparse] def loadLibSvmLocal(inpth: String, validateColumns:Boolean=true): RDDLabeledPoint =
  {
    try
    {
      path=inpth
      if (!path.toLowerCase().contains(".libsvm"))
      {
        path=path+".libsvm".trim
      }

      logger.debug(s"path $path")
      val newtargetmap=loadTargetMap( path, true)
      val newcolmap=loadColumnHeaders( path,true)
      val df=spark.read.format("libsvm").option("numFeatures", newcolmap.size).load( path)
      logger.info("Loaded")
      logger.debug(DataFrameUtils.showString(df,10))
        val newdata:RDD[(LabeledPoint,Int,String)] = df.rdd.map
        {
          r =>
            (LabeledPoint(r.getDouble(0), r(1).asInstanceOf[org.apache.spark.ml.linalg.Vector]),r.hashCode(),UUID.randomUUID().toString)

        }



      val sparseout=new RDDLabeledPoint(newdata,newcolmap,newtargetmap,path)
      logger.info(sparseout.info)
      if(validateColumns) {
        sparseout.validateColumnCount
      }
      sparseout
    }
    catch
    {

      case e: Exception =>
      {

        logger.error(s"$path")
        debugLibsvmFailure(spark.sparkContext,path)
        throw new Exception(s"$path : ${e.getMessage}", e)
      }
    }
  }

  @throws(classOf[Exception])
  private [sparse] def loadSchemaLocal(inpth: String): RDDLabeledPoint =
  {
    try
    {
      var path:String=inpth
      val name=inpth
      if (!path.toLowerCase().contains(".libsvm"))
      {
        path=path+".libsvm".trim
      }

      logger.info(s"path $path")
      val newtargetmap=loadTargetMap( path, true)
      val newcolheads=loadColumnHeaders( path,true)
      new RDDLabeledPoint(new LpData(None,Some(newcolheads),Some(newtargetmap),Some(name)))
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



  @throws(classOf[Exception])
  private [sparse] def loadSchema1( fileName: String, path: String): RDDLabeledPoint =
  {
    try
    {
      val name=fileName
      val newtargetmap=loadTargetMap( fileName, path)

      val newcolmap=loadColumnHeaders( fileName, path)
     new RDDLabeledPoint(new LpData(None,Some(newcolmap),Some(newtargetmap),Some(name)))
    }
    catch
    {

      case e: Exception =>
        logger.error(s"${ilp.name}")
        throw new Exception(s"${ilp.name} : ${e.getMessage}",e)
    }
  }

  @throws(classOf[Exception])
  private def loadTargetMap( fileName: String, path: String): Map[String,Double] =
  {
    try
    {
      loadTargetMap(s"$path${File.separator}${fileName}")
    }
    catch
    {
      case e: Exception =>
      {
        logger.error(s"${ilp.name}")
        logger.error(s"Could not load Label Names: ${e.getMessage}", e)
        throw new Exception(s"${ilp.name} : ${e.getMessage}", e)
      }
    }
  }

  @throws(classOf[Exception])
  private def loadTargetMap(path: String, isPj: Boolean = false): Map[String,Double] =
  {
    logger.info("loadTargetMap path: "+path)
    var tempStr = path
    if (isPj)
    {
      if (path.toUpperCase.endsWith(".TXT"))
      {
        tempStr = path.substring(0, path.length - 4)

      }
      else if (path.toUpperCase.endsWith(".LIBSVM"))
      {
        tempStr = path.substring(0, path.length - 7)
      }
      tempStr = s"${tempStr}-targetMap.txt"
    }
    else
    {
      tempStr = s"${tempStr}-targetMap"
    }

    logger.debug("tempStr: "+tempStr)
    val rddString: RDD[String] = spark.sparkContext.textFile(tempStr)


    rddString.filter(s=> s.isEmpty==false).map
    { record =>

      val a = record.stripPrefix("(").stripSuffix(")").split(",")
      val k = a(0)
      val v = a(1).toDouble
      (k, v)
    }.collect().toMap

  }

  private def debugLibsvmFailure(sc:SparkContext,path:String): Unit =
  {

    logger.error(s"Error thrown when opening $path")
    val failedrdd:RDD[String]=sc.textFile(path, 1)
      .map(_.trim)
      .filter(line => !(line.isEmpty || line.startsWith("#")))
    var count:Int=0
    failedrdd.foreach
    {
      line =>
        count = count + 1
        val items = line.split(' ')
        val labelo =scala.util.control.Exception.allCatch.opt(items.head.toDouble)
        if(labelo.isEmpty)
        {
          logger.error(s"Label error on line $count")
        }
        items.tail.filter(_.nonEmpty).foreach
        {
          item =>
            val indexAndValue = item.split(':')
            val indexo:Option[Int] = scala.util.control.Exception.allCatch.opt(indexAndValue(0).toInt - 1) // Convert 1-based indices to 0-based.
          val valueo = scala.util.control.Exception.allCatch.opt(indexAndValue(1).toDouble)
            if(indexo.isEmpty || valueo.isEmpty)
            {
              logger.error(s"Idx or Value error on line $count")
            }
        }
    }
  }


  @throws
  def validateColumnCount(): Unit =
  {


    val tt=new TicToc()
    logger.debug(tt.tic("validateColumnCount"))
    val originalColumnCount = columnCountFromDataRDD

    val originalColumnHeadCount = ilp.columnHeadMap.size
    logger.info(s"columnHeadMap: ${ilp.columnHeadMap.size} - colMap: ${originalColumnCount}")
    if((originalColumnCount+columnCountOffset) < originalColumnHeadCount)
    {
      logger.warn("VALIDATION FAILED originalColumnCount < originalColumnHeadCount")


      val colRdd:RDD[(Int,Seq[CellTuple])]=transformLabeledPointRDDToColumnsRdd()



      val sb:StringBuilder=new StringBuilder()

      ilp.columnHeadMap.keySet.diff(colRdd.map(e=>e._1).collect().toSet).foreach
      {
        col =>
          sb.append("\nLost Column. Id = ")
          sb.append(col)
          sb.append(" Column Title = ")
          sb.append(ilp.columnHeadMap.get(col).get)
      }
      logger.warn("Missing: "+sb.toString())

    }
    else if(originalColumnHeadCount < (originalColumnCount+columnCountOffset))
    {
      val sb1:StringBuilder=new StringBuilder()
      logger.warn("VALIDATION FAILED originalColumnHeadCount < originalColumnCount")
      val colRdd:RDD[(Int,Seq[CellTuple])]=transformLabeledPointRDDToColumnsRdd()

      (colRdd.map(e=>e._1).collect().toSet).diff(ilp.columnHeadMap.keySet).foreach
      {
        col=>
          sb1.append("\nLost Column. Id = ")
          sb1.append(col)
      }
      logger.warn("Missing: "+sb1.toString())

    }



    logger.debug(tt.toc("validateColumnCount"))
    require((originalColumnCount+columnCountOffset) == originalColumnHeadCount)
  }

}
