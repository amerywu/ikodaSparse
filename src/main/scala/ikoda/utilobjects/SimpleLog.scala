package ikoda.utilobjects

import java.io.{BufferedWriter, File, FileWriter}
import java.util.Calendar

import better.files._
import grizzled.slf4j.Logging


trait SimpleLog extends Logging
{
  

  
  var logFile: String = new File(".").getCanonicalPath
  val startTime:Long=System.currentTimeMillis()
  
  def initSimpleLog(path: String, fileName: String): Unit =
  {
    logFile = path + File.separator + fileName
    
    val dir: better.files.File = path.toFile.createIfNotExists(true, true)
  }
  
  def timestamp(line:String): String=
  {
    line.replace("\n","").trim.startsWith("**") match
      {
      case true => line
      case false =>
        val now = Calendar.getInstance()
        val currentMin = now.get(Calendar.MINUTE)
        val currentHour = now.get(Calendar.HOUR_OF_DAY)
        s"$currentHour:$currentMin: "+line
    }

  }


  def newBlock(line:String): String =
  {
    line.startsWith("**") match
      {
      case true => "\n\n"+line
      case _ => line
    }
  }

  def    addLine(line: String): Unit =
  {
    
    try
    {
      if(line.trim().replace("\n","").startsWith("*"))
        {
          logger.info(line)
        }
      if(logger.isDebugEnabled)
      {
        logger.debug("simplelog " + line)
      }
      val writer = new FileWriter(logFile, true)
      
      val bw = new BufferedWriter(writer)

      val lineout=newBlock(timestamp(line))
      try
      {
        bw.write(lineout)
        bw.write("\n")
        bw.flush()
      }
      catch
      {
        
        case e: Exception => System.out.print(e.getMessage)
      }
      finally
      {
        
        bw.close()
        
      }
    }
    catch
    {
      case e: Exception => System.out.print(e.getMessage)
    }
    
    
  }
  
  
  def clearLogFile(): Unit =
  {
    if (new File(logFile).exists())
    {
      new File(logFile).delete()
    }
  }


  
}
