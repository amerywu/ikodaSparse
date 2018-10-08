package ikoda.utilobjects

import java.io.File
import java.sql.{Date, Timestamp}

import grizzled.slf4j.Logging
import ikoda.ColumnNamePredicates._
import ikoda.IKodaMLException
import ikoda.utils.{Spreadsheet, TicToc}
import org.apache.commons.lang3.StringUtils
import org.apache.spark.sql._
import org.apache.spark.sql.catalyst.util.DateTimeUtils
import org.apache.spark.sql.functions.col
import org.apache.spark.sql.types.{DataType, StructField}

import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object DataFrameUtils extends Logging with Serializable with SparkConfProviderWithStreaming
{
  
  @throws(classOf[Exception])
  def dropAllColumnsExcept(df: DataFrame, keepList: ListBuffer[String]): DataFrame =
  {
    try
    {
      
      val dropList: ArrayBuffer[String] = ArrayBuffer()
      logger.debug(s"keeplist is ${keepList.mkString(" ^ ")}")
      df.schema.fieldNames.foreach
      {
        f =>
          if (!keepList.contains(f))
          {
            dropList += f
          }
      }
      logger.debug(s"dropAllColumnsExcept removingcols: ${dropList.mkString("--")}")
      val dfr = df.drop(dropList.toSeq: _*)
      logger.debug(s"dropAllColumnsExcept remaining cols: ${dfr.schema.fieldNames.mkString(",")}")
      dfr
      
      
    }
    catch
    {
      case e: Exception =>
        logger.error(e.getMessage, e)
        throw new Exception(e)
    }
  }

  
  def columnSums(spark: SparkSession, df: DataFrame): Seq[Long] =
  {
    val sqlContext = spark.sqlContext
    import org.apache.spark.sql.functions._
    
    logger.debug(s"Dropping string fields")
    val dfNoStringFields: DataFrame = dropStringFields(df)
    logger.debug(s"String fields dropped ${dfNoStringFields.schema.fieldNames.mkString(" | ")}")
    
    
    dfNoStringFields.select(dfNoStringFields.columns.map(c => sum(col(c)).alias(c)): _*).first.toSeq.asInstanceOf[Seq[Long]]
  }
  
  @throws(classOf[Exception])
  def deleteColumnsWhereColTotalLessThanMedian(spark: SparkSession, df: DataFrame, pkColumn: String = "A_RowId", ignoreColumns: Seq[String] = Seq()): DataFrame =
  {
    try
    {
      
      
      val sqlContext = spark.sqlContext
      import org.apache.spark.sql.functions._
      
      logger.debug(s"Dropping string fields")
      val dfNoStringFields: DataFrame = dropStringFields(df)
      logger.debug(s"String fields dropped ${dfNoStringFields.schema.fieldNames.mkString(" | ")}")
      
      
      val sums: Seq[Long] = dfNoStringFields.select(dfNoStringFields.columns.map(c => sum(col(c)).alias(c)): _*).first.toSeq.asInstanceOf[Seq[Long]]
      
      
      logger.debug(s"sums ${sums}")
      val med = median(sums)
      logger.info(s"deleteColumnsWhereColTotalLessThanMedian median is $med")
      
      val cols_keep = sums.zipWithIndex.filter(_._1 >= med).map(_._2)
      logger.debug(s"cols_keep ${cols_keep}")
      
      logger.info(s"Removing ${sums.length - cols_keep.length} columns")
      //Finally, we map these indices inside a select() statement:
      
      val dfReduced: DataFrame = dfNoStringFields.select(cols_keep map dfNoStringFields.columns map col: _*)
      logger.debug(s"dfReduced ${dfReduced.schema.fieldNames.mkString(" # ")}")
      if (ignoreColumns.length > 0)
      {
        
        val list: ListBuffer[String] = ListBuffer()
        list ++= ignoreColumns
        list ++= Seq(pkColumn)
        
        val dfKeptColumns = dropAllColumnsExcept(df, list)
        dfReduced.join(dfKeptColumns, Seq(pkColumn))
      }
      else
      {
        dfReduced
      }
      
      
    }
    catch
    {
      case e: Exception =>
      {
        logger.error(e.getMessage, e)
        throw new Exception(e)
      }
      
    }
  }
  
  def dropStringFields(df: DataFrame): DataFrame =
  {
    val fields: Seq[String] = df.schema.fields filter
      {
        x =>
          x.dataType match
          {
            case x: org.apache.spark.sql.types.StringType => true
            case _ => false
          }
      } map
      { x => x.name }
    logger.debug(s"String fields is of length  ${fields.length} : ${fields}")
    if (fields.length > 0)
    {
      logger.debug(s"dropping ")
      val dfOut=df.drop(fields: _*)
      logger.debug(s"dropStringFields rows ${dfOut.count()}")
      dfOut
    }
    else
    {
      logger.debug(s"dropStringFields rows ${df.count()}")
      df
    }
  }
  
  def median(seq: Seq[Long]): Long =
  {
    //In order if you are not sure that 'seq' is sorted
    val sortedSeq = seq.sortWith(_ < _)
    
    if (seq.size % 2 == 1) sortedSeq(sortedSeq.size / 2)
    else
    {
      val (up, down) = sortedSeq.splitAt(seq.size / 2)
      (up.last + down.head) / 2
    }
  }
  
  
  @throws(classOf[Exception])
  def saveToPjCsv(df: DataFrame, fileName: String, outputDir: String, maxFileRowCount:Int=100000): Unit =
  {
    try
    {
      val tt: TicToc = new TicToc()
      
      logger.info(tt.tic("df saveToPjCsv"))
      //logger.info(s"schema ${df.schema}")
      //logger.info(s" schema field names ${df.schema.fieldNames.toSeq}")
      logger.info(s" schema field names count${df.schema.fieldNames.toSeq.length}")
      // val dftemp:DataFrame=df.r
      var count: Int = 0
      var block:Int=0
      val dfsize: Long = df.count()
      Spreadsheet.getInstance().initCsvSpreadsheet(s"${fileName}_$block",outputDir)
     
      
      var blank:String="";
      df.collect().foreach
      {
        row =>

          val valuesMap: Map[String, Any] = row.getValuesMap(df.schema.fieldNames.toSeq)
          
          
          valuesMap.foreach
          {
            
            
            vme =>
              
              var value: String = blank
              nullHandler(vme._2) match
              {
                case Some(s) => value = s
                case None => value
              }
              
              Spreadsheet.getInstance().getCsvSpreadSheet(s"${fileName}_$block").addCell(
                count,
                vme._1,
                value
              );
          }
          count = count + 1
          if(count > maxFileRowCount)
            {
              logger.info(s"Csv Compiled. Saving to $outputDir+${File.separator}$fileName.csv")
  
              Spreadsheet.getInstance().getCsvSpreadSheet(s"${fileName}_$block").printCsvOverwrite(s"${fileName}_$block" + ".csv")
              block = block+1
              Spreadsheet.getInstance().initCsvSpreadsheet(s"${fileName}_$block",outputDir)
              count=0;
              

            }
      }
      logger.info(s"Csv Compiled. Saving to $outputDir+${File.separator}$fileName.csv")

      Spreadsheet.getInstance().getCsvSpreadSheet(s"${fileName}_$block").printCsvOverwrite(s"${fileName}_$block" + ".csv")
      logger.info(tt.toc())
    }
    catch
    {
      case e: Exception =>
      {
        logger.error(s"ERROR SAVING ${e.getMessage}", e)
        throw new Exception(e)
      }
    }
  }
  
  
  @throws(classOf[Exception])
  def saveToPjCsv(map: mutable.Map[Any, Any], fileName: String, outputDir: String): Unit =
  {
    try
    {
      logger.info("map saveToPjCsv")
      
      
      Spreadsheet.getInstance().initCsvSpreadsheet(fileName,outputDir)
      map.foreach
      {
        
        
        vme =>
          var value: String = ""
          nullHandler(vme._2) match
          {
            case Some(s) => value = s
            case None => value
          }
          
          
          Spreadsheet.getInstance().getCsvSpreadSheet(fileName).addCell(
            vme._1.toString,
            vme._1.toString,
            value
          );
      }
      logger.info(s"Csv Compiled. Saving to $outputDir ${File.separator}$fileName.csv")
      Spreadsheet.getInstance().getCsvSpreadSheet(fileName).printCsvOverwrite(fileName + ".csv")
      
    }
    catch
    {
      case e: Exception =>
      {
        logger.error(s"ERROR SAVING ${e.getMessage}", e)
        throw new Exception(e)
      }
      
    }
  }
  
  
  def nullHandler(obj: Any): Option[String] =
  {
    try
    {
      Some(obj.toString)
    }
    catch
    {
      case ex: Exception => None
    }
  }
  
  @throws(classOf[Exception])
  def rowSum(df: DataFrame): DataFrame =
  {
    try
    {
      
      logger.info("Summing Each Row")
      
      df.na.fill(0).withColumn("rowSums", getNumericFields(df).reduce(_ + _))
    }
    catch
    {
      case e: Exception =>
      {
        logger.error(e.getMessage, e)
        throw new Exception(e)
      }
     
    }
  }
  
  @throws(classOf[Exception])
  def getNumericFields(df: DataFrame): Seq[Column] =
  {
    try
    {
      val colarray: ArrayBuffer[Column] = ArrayBuffer()
      df.schema.fields filter
        {
          x =>
            x.dataType match
            {
              case x: org.apache.spark.sql.types.DoubleType => true
              case y: org.apache.spark.sql.types.LongType => true
              case z: org.apache.spark.sql.types.IntegerType => true
              case w: org.apache.spark.sql.types.FloatType => true
              case _ => false
            }
        } map
        { x => colarray += col(x.name) }
      colarray.toSeq
    }
    catch
    {
      case e: Exception =>
      {
        logger.error(e.getMessage, e)
        throw new Exception(e)
      }
      
    }
  }
  
  def deleteColumnNamesStartingWith(df: DataFrame, colName: String): DataFrame =
  {
    val colsToDeleteSeq: Seq[String] = df.schema.filter(f => f.name.startsWith(colName)).map(f => f.name)
    
    
    df.drop(colsToDeleteSeq: _*)
  }
  
  def deleteColumnNamesStartingWith(df: DataFrame, colNames: Array[String]): DataFrame =
  {
    
    val predicates: ArrayBuffer[StructField => Boolean] = ArrayBuffer()
    colNames.foreach(s => predicates += colNameStartsWith(s))
    val combined = or(predicates.toSeq)(_)
    val colsToDeleteSeq: Seq[String] = df.schema.filter(combined).map(f => f.name)
    
    logger.info(s"colsToDeleteSeq ${colsToDeleteSeq}")
    df.drop(colsToDeleteSeq: _*)
  }
  
  def deleteColumnNamesContaining(df: DataFrame, colName: String): DataFrame =
  {
    val colsToDeleteSeq: Seq[String] = df.schema.filter(f => f.name.contains(colName)).map(f => f.name)
    
    
    df.drop(colsToDeleteSeq: _*)
  }
  
  def openFile(spark: SparkSession, path: String): DataFrame =
  {
    spark.read.option("header", "true").option("inferSchema", "true").csv(path)
  }



  def showString(df:DataFrame,_numRows: Int=5, truncate: Int = 20): String = {
    val numRows = _numRows.max(0)
    val takeResult = df.toDF().take(numRows + 1)
    val hasMoreData = takeResult.length > numRows
    val data = takeResult.take(numRows)

    lazy val timeZone =
      DateTimeUtils.getTimeZone(spark.sessionState.conf.sessionLocalTimeZone)

    // For array values, replace Seq and Array with square brackets
    // For cells that are beyond `truncate` characters, replace it with the
    // first `truncate-3` and "..."
    val rows: Seq[Seq[String]] = df.schema.fieldNames.toSeq +: data.map { row =>
      row.toSeq.map { cell =>
        val str = cell match {
          case null => "null"
          case binary: Array[Byte] => binary.map("%02X".format(_)).mkString("[", " ", "]")
          case array: Array[_] => array.mkString("[", ", ", "]")
          case seq: Seq[_] => seq.mkString("[", ", ", "]")
          case d: Date =>
            DateTimeUtils.dateToString(DateTimeUtils.fromJavaDate(d))
          case ts: Timestamp =>
            DateTimeUtils.timestampToString(DateTimeUtils.fromJavaTimestamp(ts), timeZone)
          case _ => cell.toString
        }
        if (truncate > 0 && str.length > truncate) {
          // do not show ellipses for strings shorter than 4 characters.
          if (truncate < 4) str.substring(0, truncate)
          else str.substring(0, truncate - 3) + "..."
        } else {
          str
        }
      }: Seq[String]
    }

    val sb = new StringBuilder
    val numCols = df.schema.fieldNames.length

    // Initialise the width of each column to a minimum value of '3'
    val colWidths = Array.fill(numCols)(3)

    // Compute the width of each column
    for (row <- rows) {
      for ((cell, i) <- row.zipWithIndex) {
        colWidths(i) = math.max(colWidths(i), cell.length)
      }
    }

    // Create SeparateLine
    val sep: String = colWidths.map("-" * _).addString(sb, "+", "+", "+\n").toString()

    // column names
    rows.head.zipWithIndex.map { case (cell, i) =>
      if (truncate > 0) {
        StringUtils.leftPad(cell, colWidths(i))
      } else {
        StringUtils.rightPad(cell, colWidths(i))
      }
    }.addString(sb, "|", "|", "|\n")

    sb.append(sep)

    // data
    rows.tail.map {
      _.zipWithIndex.map { case (cell, i) =>
        if (truncate > 0) {
          StringUtils.leftPad(cell.toString, colWidths(i))
        } else {
          StringUtils.rightPad(cell.toString, colWidths(i))
        }
      }.addString(sb, "|", "|", "|\n")
    }

    sb.append(sep)

    // For Data that has more than "numRows" records
    if (hasMoreData) {
      val rowsString = if (numRows == 1) "row" else "rows"
      sb.append(s"only showing top $numRows $rowsString\n")
    }

    sb.toString()
  }

  
  def debugDataFrame(df: DataFrame): String =
  {
    val sb: StringBuilder = new StringBuilder
    df.show
    
    val f4: Seq[String] = df.schema.fieldNames
    
    
    sb.append("\n")
    sb.append("Column Count: ")
    sb.append(f4.length)
    sb.append("\n")
    sb.append("Row Count: ")
    sb.append(df.count())
    sb.append("\n")
    sb.append("\n")
    sb.append("Columns:")
    sb.append("\n")
    
    
    df.schema.foreach
    {
      sf =>
        sb.append(sf.name)
        sb.append(" : ")
        sb.append(sf.dataType)
        sb.append("  ||  ")
      
      
    }
    
    
    sb.toString()
    
  }
  
  @throws(classOf[Exception])
  def proportionalizeColumns(df: DataFrame, columnToProportionalize: String, columnWithConstant: String, ignoreColumns: Seq[String] = Seq()): DataFrame =
  {
    try
    {
      import org.apache.spark.sql.functions._
      
      
      logger.info(s"columnToProportionalize $columnToProportionalize } ")
      if (columnToProportionalize == columnWithConstant)
      {
        df
      }
      else if (ignoreColumns.contains(columnToProportionalize))
           {
             df.withColumn(s"${columnToProportionalize}_n", col(columnToProportionalize))
           }
      else
      {
        logger.info("processing")
        df.withColumn(s"${columnToProportionalize}_n", col(columnToProportionalize) / col(columnWithConstant))
      }
    }
    catch
    {
      case e: Exception => logger.error(s"There has been an Exception. Message is ${e.getMessage} and ${e}")
        df
    }
  }
  
  def groupBy(spark: SparkSession, columnName: String, df: DataFrame): DataFrame =
  {
    val sqlContext = spark.sqlContext
    
    val dfGrouped: DataFrame = df.groupBy(df.col(columnName)).sum()

    val colNamesReset: Seq[String] = dfGrouped.schema.fieldNames.map(n => if (n != columnName) n.substring(4, n.length - 1)else n)
    logger.debug(s"DONE GROUPING")
    dfGrouped.toDF(colNamesReset: _*)
    
  }
  
  def join(dfLeft: DataFrame, dfRight: DataFrame, onColumn: String): DataFrame =
  {
    dfLeft.join(dfRight, Seq(onColumn))
    
    
  }

  def logRows(df:DataFrame, proportion:Double):Unit=
  {
    logRows(df,proportion,"unnamed")
  }

  def logRows(df:DataFrame, proportion:Double, name:String):Unit=
  {


    if(logger.isDebugEnabled)
    {
      val sb:StringBuilder=new mutable.StringBuilder()
      sb.append("\n\n\n\n---------"+name+"-------------\n\n")
      val splits = df.randomSplit(Array(proportion, 1 - proportion))
      splits(0).collect().toArray.foreach(
        r => sb.append("\n\n" + r.getValuesMap(df.schema.fieldNames).mkString("\n")))
      sb.append("\n\n\n\n----------------------\n\n")
      logger.debug(sb)
    }
  }

  
  def deletePartition(path: String): Unit =
  {
    val hadoopConf = new org.apache.hadoop.conf.Configuration()
    val hdfs = org.apache.hadoop.fs.FileSystem.get(hadoopConf)
    logger.info(s"Deleting $path")
    try
    {
      hdfs.delete(new org.apache.hadoop.fs.Path(path), true)
      println("....deleted....")
    }
    catch
    {
      case ex: Exception =>
      {
        logger.debug(s"There has been an Exception during deletion. Message is ${ex.getMessage} and ${ex}")
        
      }
    }
  }

  def movePartitionLocal(pathOld: String, pathNew:String): Unit =
  {
    val hadoopConf = new org.apache.hadoop.conf.Configuration()
    val hdfs = org.apache.hadoop.fs.FileSystem.get(hadoopConf)

    logger.info(s"Moving $pathOld to $pathNew")


    try
    {

      val b=hdfs.moveFromLocalFile(new org.apache.hadoop.fs.Path(pathOld),new org.apache.hadoop.fs.Path(pathNew))
      logger.debug(s"Moving status: $b")

    }
    catch
    {
      case ex: Exception =>
      {
        logger.debug(s"There has been an Exception renamePartition $pathOld to $pathNew. Message is ${ex.getMessage} and ${ex}")

      }
    }
  }

  @throws(classOf[IKodaMLException])
  def renamePartition(pathOld: String, pathNew:String):Unit=
  {
    try
    {
      renamePartition1(new org.apache.hadoop.fs.Path(pathOld), new org.apache.hadoop.fs.Path(pathNew))
    }
    catch
      {
        case e:Exception => throw new IKodaMLException(e.getMessage,e)
      }
  }

  def renamePartition1(pathOld: org.apache.hadoop.fs.Path, pathNew:org.apache.hadoop.fs.Path): Unit =
  {
    val hadoopConf = new org.apache.hadoop.conf.Configuration()
    val hdfs = org.apache.hadoop.fs.FileSystem.get(hadoopConf)



    logger.info(s"Renaming $pathOld to $pathNew")


    try
    {

      val b=hdfs.rename(pathOld, pathNew)
      logger.debug(s"Rename status: $b")

      println("....moved....")
    }
    catch
      {
        case ex: Exception =>
        {
          logger.debug(s"There has been an Exception renamePartition $pathOld to $pathNew. Message is ${ex.getMessage} and ${ex}")

        }
      }
  }
  
  
  def castColumnTo(df: DataFrame, cn: String, tpe: DataType): DataFrame =
  {
    
    //println("castColumnTo")
    df.withColumn(cn, df(cn).cast(tpe)
    
    )
  }
  
  
  
  def listFiles(dir: String):Seq[File] = {
    val d = new File(dir)
    if (d.exists && d.isDirectory) {
      d.listFiles.filter(_.isFile)
    } else {
      Seq[File]()
    }
  }
  
  
  
  @throws(classOf[IKodaMLException])
  def mergeAndSaveCsv(spark:SparkSession, outputDir:String,  inputDir: String, inputFileCoreName:String, joinColumn:String): Unit =
  {
    try
    {



      deletePartition(outputDir+File.separator+inputFileCoreName+"_MERGED.csv")
      val scalaSeq:Seq[File]= listFiles(inputDir).filter(_.getName.contains(inputFileCoreName))
      
      logger.debug(s"scalaSeq ${scalaSeq.mkString(",")}")
      
      val dfSeq:Seq[DataFrame] = scalaSeq
        .map(file => DataFrameUtils.openFile(spark, s"${inputDir+File.separator+file.getName}").drop("A_RowId"))

      val dfOut:DataFrame=doJoin(spark,dfSeq,joinColumn)
      
      logger.debug(s"cols ${dfOut.schema.fieldNames.length}")
      logger.debug(s"rows ${dfOut.count()}")
     
      DataFrameUtils.saveToPjCsv(dfOut,inputFileCoreName+"_MERGED",outputDir)
    }
    catch
    {
      case e:Exception => throw new Exception(e)
    }
  }
  
  @throws
  private def doJoinForReal(spark:SparkSession,df1:DataFrame, df2:DataFrame,joinColumn:String): DataFrame =
  {
    try
    {

      logger.debug(s"row count df1 ${df1.count()}")
      logger.debug(s"row count df2 ${df2.count()}")
      logger.debug(s"joinColumn $joinColumn")
      val df2noStrings:DataFrame=DataFrameUtils.dropStringFields(df2)
      logger.debug(df1.schema.fieldNames.mkString(" -1- "))
      logger.debug(df2noStrings.schema.fieldNames.mkString(" -2- "))
      df1.join(df2noStrings, Seq(joinColumn), "right_outer")
    }
    catch
    {
      case e:Exception => throw new Exception(e)
    }
  }
  
  
  
  @throws
  private def doJoin(spark:SparkSession,dfList:Seq[DataFrame],joinColumn:String): DataFrame =
  {
    try
    {
      
      logger.debug("doJoin")
      val buffer:scala.collection.mutable.Queue[DataFrame]=dfList.to[scala.collection.mutable.Queue]
      var dfHead:DataFrame=buffer.dequeue()
      
      while(buffer.size>0)
      {
        val df1=buffer.dequeue()
        dfHead = doJoinForReal(spark, dfHead, df1, joinColumn)
        logger.debug(s"dfHead row count ${dfHead.count}")
      }
      
      logger.debug("Final DF "+dfHead.schema.fieldNames.mkString(","))
      dfHead
      

      
      
    }
    catch
    {
      case e:Exception => throw new Exception(e)
    }
  }

  
  
}
