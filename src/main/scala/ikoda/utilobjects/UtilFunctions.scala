package ikoda.utilobjects

import java.io._

import grizzled.slf4j.Logging
import ikoda.IKodaMLException
import ikoda.sparse.RDDLabeledPoint
import ikoda.utils.{IDGenerator, Spreadsheet}

import scala.collection.immutable.SortedMap
import scala.util.Try

trait UtilFunctions extends Logging
{
  @throws(classOf[IKodaMLException])
  protected   def getOrThrow(so:Option[RDDLabeledPoint]):RDDLabeledPoint=
  {
    so.getOrElse(throw new IKodaMLException("Failed"))
  }


  @throws(classOf[IKodaMLException])
  protected   def getOrThrow(so:Try[RDDLabeledPoint]):RDDLabeledPoint=
  {
    so.getOrElse(throw new IKodaMLException("Failed"))
  }

  protected def stackTraceString(e:Throwable):String=
  {
    val sw = new StringWriter
    e.printStackTrace(new PrintWriter(sw))
    sw.toString
  }

  protected   def printLocal(path:String,text:String): Unit =
  {
    try
    {
      val file = new File(path)
      val bw = new BufferedWriter(new FileWriter(file))
      bw.write(text)
      bw.close()
    }
    catch
      {
        case e: Exception =>
        {
          logger.error(s" ${e.getMessage}",e)

          throw new Exception(s"${e.getMessage}", e)
        }
      }
  }

  @throws
  protected def breakPathToDirAndFile(path: String): (String, String) =
  {
    try
    {
      val dirName: String = path.substring(0, path.lastIndexOf(File.separator))
      val fileName: String = path.substring(path.lastIndexOf(File.separator))
      (dirName, fileName)
    }
    catch
    {
      case e: Exception => throw IKodaMLException(e.getMessage, e)
    }
  }

  protected def getListOfSubDirectories(dir: String): List[String] =
  {
    val d = new File(dir)
    if (d.exists && d.isDirectory)
    {
      d.listFiles.filter(_.isDirectory).map(f => f.getAbsolutePath.toString).toList
    }
    else
    {
      List[String]()
    }
  }

  protected def getListOfSubDirectoriesOlderThan(dir: String, age: Long): List[String] =
  {
    val d = new File(dir)
    if (d.exists && d.isDirectory)
    {
      d.lastModified()
      d.listFiles.filter(_.isDirectory).filter(_.lastModified() < age).map(f => f.getAbsolutePath.toString).toList
    }
    else
    {
      List[String]()
    }
  }


  protected def getListOfFiles(dir: String): List[String] =
  {
    val d = new File(dir)
    if (d.exists && d.isDirectory)
    {
      d.listFiles.filter(_.isFile).map(f => f.getAbsolutePath.toString).toList
    }
    else
    {
      List[String]()
    }
  }

  protected  def showMemoryUsage: Unit =
  {

    val mb = 1024 * 1024
    val runtime = Runtime.getRuntime
    val sb: StringBuilder = new StringBuilder
    sb.append("\n------")
    sb.append("\nMemory Used: " + String.valueOf((runtime.totalMemory - runtime.freeMemory) / mb))
    sb.append("\nMemory Free: " + String.valueOf(runtime.freeMemory / mb))
    sb.append("\nMemory Total: " + String.valueOf(runtime.totalMemory / mb))
    sb.append("\nMemory Max: " + String.valueOf(runtime.maxMemory / mb))
    sb.append("\n------")
    logger.info(sb)
  }


  protected  def showMemoryUsage(name: String): Unit =
  {
    val mb = 1024 * 1024
    val runtime = Runtime.getRuntime
    val sb: StringBuilder = new StringBuilder
    sb.append("\n------")
    sb.append(name)
    sb.append("------")
    sb.append("\nMemory Used: " + String.valueOf((runtime.totalMemory - runtime.freeMemory) / mb))
    sb.append("\nMemory Free: " + String.valueOf(runtime.freeMemory / mb))
    sb.append("\nMemory Total: " + String.valueOf(runtime.totalMemory / mb))
    sb.append("\nMemory Max: " + String.valueOf(runtime.maxMemory / mb))
    sb.append("\n------")
    logger.info(sb)
  }


  protected def extractDouble(expectedNumber: Any): Option[Double] =
  {

    try
    {
      expectedNumber match
      {

        case i: Int => Some(i.toDouble)
        case l: Long => Some(l.toDouble)
        case d: Double => Some(d)
        case s: String => Try(s.toString.toDouble).toOption
        case _ => None

      }
    }
    catch
      {
        case e:Exception => logger.warn (e.getMessage,e)
          Some(-1)
      }
  }



  protected def stripDecimalPlace(s: Option[String]): String =
  {
    if (s.nonEmpty)
    {
      val str: String = s.get
      str match
      {
        case x if (x.contains(".")) => x.substring(0, x.indexOf(".")).replace(".", "")
        case _ => str
      }
    }
    else
    {
      logger.warn("stripDecimalPlace NULL input: " + s)
      ""
    }
  }

  protected def keySpaceCleanName(keySpaceName: String): Option[String] =
  {
    val keySpaceNameo = Option(keySpaceName)
    if (keySpaceNameo.isDefined)
    {
      Option(keySpaceName.toLowerCase().replaceAll("[^A-Za-z0-9 ]", ""))

    }
    else
    {
      None
    }
  }



  protected def extractLong(expectedNumber: Any): Option[Long] = expectedNumber match
  {
    case i: Int => Some(i.toLong)
    case l: Long => Some(l)
    case d: Double => Some(d.toLong)
    case s: String => Try(stripDecimalPlace(Option(s.trim)).toLong).toOption
    case _ => None
  }

  protected def extractString(expectedString: Any): Option[String] = expectedString match
  {
    case i: Int => Some(i.toString)
    case l: Long => Some(l.toString)
    case d: Double => Some(d.toString)
    case s: String => Some(s.toString)
    case x if (Option(x).isEmpty) => Some("|null|")
    case _ => Some(expectedString.toString)
  }

  protected def sum[T: Numeric](x: List[T]): T =
  {
    if (x.isEmpty) implicitly[Numeric[T]].zero
    else implicitly[Numeric[T]].plus(x.head, sum(x.tail))
  }


  protected def printHashMapToCsv(m:Map[String,String],name:String, path:String): Unit =
  {
    Spreadsheet.getInstance().initCsvSpreadsheet(name,path)
    m.foreach
    {
      e=>
        val id=IDGenerator.getInstance().nextID()
        Spreadsheet.getInstance().getCsvSpreadSheet(name).addCell(id, "key",e._1)
        Spreadsheet.getInstance().getCsvSpreadSheet(name).addCell(id, "value",e._2)
    }
    Spreadsheet.getInstance().getCsvSpreadSheet(name).printCsvFinal()
  }


}
