package ikoda

import java.io.File
import java.util.UUID

import grizzled.slf4j.Logging
import ikoda.sparse.{CellTuple, RDDLabeledPoint}
import ikoda.utilobjects.{DataFrameUtils, SparkConfProviderWithStreaming, UtilFunctions}
import ikoda.utils.{SSm, Spreadsheet, TicToc}
import org.apache.spark.sql.SparkSession
import org.scalatest._

import scala.collection.immutable.SortedMap
import scala.collection.mutable


class TinyTest extends FlatSpec with Logging with SparkConfProviderWithStreaming with UtilFunctions{


   lazy val sparse=openTiny

/****************  ***********************/


  "Tiny Test" should "open a libsvm file" in {


    openTiny
  }

  "Tiny Test" should "reorder columns" in {


    reorderColumns()
  }



  it should "save locally" in
    {
      saveLocalTest()
    }



  it should "convert to df" in
    {
      convertToDF()
    }

  it should "convert to term frequency" in
    {
      tf()
    }

  it should "convert to tf-idf" in
    {
      tfidf()
    }

  it should "open locally" in
    {
      loadLocalTest()
    }


  it should "reset indices" in
    {
      resetIndicesTest()
    }

  it should "find the median value for each row" in
    {
      medianTest()
    }

  it should "map out " in
    {
      mapOut()
    }


  it should "add a column in " in
    {
      addColumnTest
    }

  it should "change a label " in
    {
      changeLabelTest()
    }

  it should "calculate standard deviation for each column" in
    {
      colStDevTest()
    }

  it should "sum each column" in
    {
      colSumTest()
    }

  it should "perform an operation on each column" in
    {
      colOperationTest()
    }

  it should "aggregate by label" in
    {
      labelCountTest()
    }

  it should "even the proportion of columns" in
    {
      evenLabelProportionTest()
    }

  it should "find rows containing a given column vakue" in
    {
      getRowsContainingCols()
    }

  it should "getProportion of Columns that have a non zero value" in
    {
      getProportionOfColumnsWithValues()
    }
  it should "reduce to label by aggregation" in
    {
      reduce()
    }

  it should "get a random subset" in
    {
      getProportionRandomSubset()
    }

  it should "remove columns" in
    {
      removeColumns()
    }

  it should "remove columns distributed" in
    {
      removeColumnsDistributed()
    }

  it should "merge schemas" in
    {
      mergeSchemas()
    }
  it should "make hashs" in
    {
      lpHash()
    }

  it should "convert to ml package lp" in
    {
      convertToMLPackage()
    }
  /********************************/
  /******
  it should "merge schemas from csv" in
    {
      mergeSchemasFromCSV()
    }  ************/


  it should "close spark" in
    {
      closeSpark()
    }

  def medianTest(): Unit =
  {
    val result: Map[Int, CellTuple] = RDDLabeledPoint.colMedian(sparse)
    logger.debug("medianTest\n" + result.mkString(" || "))
    assert(result.get(2).get.value == 3)
    assert(result.get(3).get.value == 4)
  }


  def saveLocalTest(): Unit =
  {
    logger.debug("saveLocalTest ")
    RDDLabeledPoint.printSparseLocally(sparse,"savedLocal",s"${new File(".").getAbsolutePath}${File.separator}unitTestOutput",5)
    logger.debug("saved\n")
  }

  def loadLocalTest(): Unit =
  {
    logger.debug("loadLocalTest ")
    val t=RDDLabeledPoint.loadLibSvmLocal(s"${new File(".").getAbsolutePath}${File.separator}unitTestOutput${File.separator}savedLocal")
    val sparse1:RDDLabeledPoint=t.isSuccess match
    {
      case true=> t.get
      case _ => logger.error(t.failed.get.getMessage,t.failed.get)
        throw new IKodaMLException(t.failed.get.getMessage)
    }
    logger.debug("loadLocalTest\n"+sparse1.info())
  }

  def reorderColumns(): Unit =
  {
    val out=sparse.lpData().map
    {
      lp=>
        val map=SortedMap((lp.features.toSparse.indices zip lp.features.toSparse.values):_*)
        (map.keySet.toArray,map.values.toArray)
    }

    logger.info(out.collect().mkString("\n"))
  }

  def resetIndicesTest(): Unit =
  {
    logger.debug("loadLocalTest ")
    val sparse1=RDDLabeledPoint.loadLibSvmLocal(s"${new File(".").getAbsolutePath}${File.separator}unitTestOutput${File.separator}savedLocal").get
    logger.debug("loadLocalTest\n"+sparse1.info())
    val sparse2=RDDLabeledPoint.removeColumnsDistributed(sparse1,Set(1,3,5))
    val sparse3=RDDLabeledPoint.resetColumnIndices(sparse2.get).get
    RDDLabeledPoint.printSparseLocally(sparse3,"savedLocalReset",s"${new File(".").getAbsolutePath}${File.separator}unitTestOutput")
    var colIdx=0
    sparse3.columnHeads()
  }



  def mapOut(): Unit =
  {
    try{

      val m:mutable.HashMap[Int,String]=new mutable.HashMap[Int,String]()
      m.put(1,"sssss")
      m.put(2,"ghfd")
      m.put(3,"dfsa")
      m.put(4,"fhjgsdf")
      printHashMapToCsv(m.map(e=>e._1.toString -> e._2).toMap,"mapout",s"${new File(".").getAbsolutePath}${File.separator}unitTestOutput")

    }
    catch
      {
        case ex: Exception =>
        {

          logger.error(s"There has been an Exception. Message is ${ex.getMessage} and ${ex}")
          throw (ex)
        }
      }
  }


  def tf(): Unit =
  {
    try{
      logger.debug("term frequency ")
      val sparse1=RDDLabeledPoint.termFrequencyNormalization(sparse).get
      RDDLabeledPoint.printSparseLocally(sparse1,"tf",s"${new File(".").getAbsolutePath}${File.separator}unitTestOutput")
    }
    catch
      {
        case ex: Exception =>
        {

          logger.error(s"There has been an Exception. Message is ${ex.getMessage} and ${ex}")
          throw (ex)
        }
      }
  }

  def tfidf(): Unit =
  {
    try{
      logger.debug("term frequency ")
      val sparse1=RDDLabeledPoint.termFrequencyNormalization(sparse)
      val sparse2=RDDLabeledPoint.inverseDocumentFrequency(sparse1)
      RDDLabeledPoint.printSparseLocally(sparse2,"tfidf",s"${new File(".").getAbsolutePath}${File.separator}unitTestOutput",Some(3))
    }
    catch
      {
        case ex: Exception =>
        {

          logger.error(s"There has been an Exception. Message is ${ex.getMessage} and ${ex}")
          throw (ex)
        }
      }


  }



  @throws(classOf[Exception])
  def openTiny: RDDLabeledPoint =
  {
    try
    {
      val  sparseout=RDDLabeledPoint.loadLibSvmLocal( "./unitTestInput/tiny.libsvm").get
      assert(sparseout.rowCount >0 )
      sparseout

    }
    catch
      {
        case ex: Exception =>
        {

          logger.error(s"There has been an Exception. Message is ${ex.getMessage} and ${ex}")
          throw (ex)
        }
      }
  }


  def addColumnTest(): Unit =
  {
    val tt: TicToc = new TicToc

    logger.debug(tt.tic("copy sparse"))
    val sparse1 = sparse.copy()
    logger.debug(tt.toc("copy sparse"))

    logger.debug(tt.tic("addColumnTest"))
    val colIndex = sparse1.columnCount


    val rowids = sparse1.getRowIdAndLabel
    logger.debug("rowids\n" + rowids.mkString("="))
    val rnd = scala.util.Random
    val col: Seq[CellTuple] = rowids.zipWithIndex.map
    {
      r =>

        CellTuple(colIndex, r._1._2, rnd.nextDouble(), UUID.fromString(r._1._1), r._2)
    }

    val sparseout1=RDDLabeledPoint.addColumn(sparse1, col, "new col").get
    logger.debug(tt.toc("addColumnTest"))
    logger.debug(tt.tic("addColumnTest print"))
    logger.debug("Row Count: "+sparseout1.sparseData().count)
    RDDLabeledPoint.printSparse( sparse1,"tiny-addColumn", "./unitTestOutput", true)
    logger.debug(tt.toc("addColumnTest print"))
    logger.debug(
      "asserting: " + sparseout1.lpData().filter(lp => lp.features.toSparse.indices.contains(10)).take(1).toSeq.length)
    assert(sparseout1.lpData().filter(lp => lp.features.toSparse.indices.contains(10)).take(1).toSeq.length > 0)
  }


  def changeLabelTest(): Unit =
  {
    try
    {
      val tt: TicToc = new TicToc


      val sparse1 = sparse.copy()

      logger.debug(tt.tic("changeLabelTest"))
      val sparseOut=RDDLabeledPoint.mergeTarget(sparse1, 2.0, 7.0).get
      logger.debug(tt.toc("changeLabelTest"))

      logger.debug(tt.tic("changeLabelTest print"))
      RDDLabeledPoint.printSparse( sparseOut,"tiny-changeLabelTest", "./unitTestOutput", true)
      logger.debug(tt.toc("changeLabelTest print"))
      assert(sparseOut.lpData().filter(lp => lp.label.equals(2.0)).take(1).length == 0)
      assert(sparseOut.lpData().filter(lp => lp.label.equals(7.0)).take(1).length > 0)
    }
    catch
      {
        case e: Exception =>
          logger.error(e.getMessage, e)
          fail(e.getMessage)
      }
  }


  def colStDevTest(): Unit =
  {
    try
    {

      val tt: TicToc = new TicToc


      val sparse1 = sparse.copy()
      val colIndex = sparse1.columnCount
      val rowids = sparse1.getRowIdAndLabel
      val rnd = scala.util.Random
      val col: Seq[CellTuple] = rowids.zipWithIndex.map
      {
        r =>

          CellTuple(colIndex, r._1._2, rnd.nextDouble(), UUID.fromString(r._1._1), r._2)
      }

      val sparseout1=RDDLabeledPoint.addColumn(sparse1, col, "new col").get

      logger.debug(tt.tic("colStDevTest"))
      val result = RDDLabeledPoint.colStDevs(sparseout1)
      logger.debug(tt.toc("colStDevTest"))
      logger.debug("colStDevTest\n" + result.mkString("\n"))
      logger.debug("result.get(0).get.value " + result.get(0).get.value)
      assert(result.get(0).get.value.toString.contains("4.472135"))
    }
    catch
      {
        case e: Exception =>
          logger.error(e.getMessage, e)
          fail(e.getMessage)
      }

  }

  def colSumTest(): Unit =
  {
    try
    {
      val tt: TicToc = new TicToc


      val sparse1 = sparse.copy()

      logger.debug(tt.tic("colSumTest"))
      val result = RDDLabeledPoint.colSums(sparse1)
      logger.debug(tt.toc("colSumTest"))
      logger.debug("colSumTest\n" + result.mkString("\n"))
      assert(result.get(0).get.value == 120)
    }
    catch
      {
        case e: Exception =>
          logger.error(e.getMessage, e)
          fail(e.getMessage)
      }

  }

  def colOperationTest(): Unit =
  {
    try
    {
      val tt: TicToc = new TicToc


      val sparse1 = sparse.copy()


      val colSumsMap0: Map[Int, CellTuple] = RDDLabeledPoint.colSums(sparse1)
      logger.debug(colSumsMap0.keySet.toSeq.sorted.toString())

      logger.debug(tt.tic("colOperationTest"))
      val sparseOut=RDDLabeledPoint.columnCellOnColumnConstant( sparse1,sparse1._dividedBy, colSumsMap0).get
      logger.debug(tt.toc("colOperationTest"))

      logger.debug(tt.tic("colOperationTest print"))
      RDDLabeledPoint.printSparse(sparseOut, "tiny-colOperationTest", "./unitTestOutput", true)
      logger.debug(tt.toc("colOperationTest print"))
    }
    catch
      {
        case e: Exception =>
          logger.error(e.getMessage, e)
          fail(e.getMessage)
      }

  }

  def labelCountTest(): Unit =
  {
    try
    {
      val tt: TicToc = new TicToc
      val sparse1 = sparse.copy()
      logger.debug(tt.tic("labelCountTest"))
      val labelCountMap: Map[Double, Int] = RDDLabeledPoint.countRowsByTargetCollected(sparse1)
      logger.debug(tt.toc("labelCountTest"))
      logger.debug("labelCountMap \n" + labelCountMap.mkString("\n"))
    }
    catch
      {
        case e: Exception =>
          logger.error(e.getMessage, e)
          fail(e.getMessage)
      }
  }


  type FTDoubleDouble_Double = (Double, Double) => Double
  val _dividedBy: FTDoubleDouble_Double =
  {
    _ / _
  }


  def evenLabelProportionTest(): Unit =
  {
    try
    {
      val tt: TicToc = new TicToc

      val sparse1: RDDLabeledPoint = new RDDLabeledPoint
      val t=RDDLabeledPoint.loadLibSvmLocal( "./unitTestInput/lltiny.libsvm")
      val sparse2:RDDLabeledPoint=t.isSuccess match
        {
        case true=> t.get
        case false => logger.error(t.failed.get.getMessage,t.failed.get)
          throw new IKodaMLException(t.failed.get.getMessage)
      }
      logger.debug("BEFORE\n" + RDDLabeledPoint.countRowsByTarget(sparse2).collect().mkString("\n"))

      logger.debug(tt.tic("evenLabelProportionTest"))
      val sparseout=RDDLabeledPoint.evenProportionPerTarget(sparse2).get
      logger.debug(tt.toc("evenLabelProportionTest"))
      logger.debug("AFTER\n" + RDDLabeledPoint.countRowsByTarget(sparseout).collect.mkString("\n"))
    }
    catch
      {
        case e: Exception =>
          logger.error(e.getMessage, e)
          fail(e.getMessage)
      }
  }


  def getRowsContainingCols(): Unit =
  {

    try
    {
      val tt: TicToc = new TicToc
      val sparse1 = sparse.copy()
      logger.debug(tt.tic("getRowsContainingCols1"))
      val result1: Option[RDDLabeledPoint] = RDDLabeledPoint.getRowsContainingColIdxAndMatchesLabelUnchangedSchema(sparse1,Set(3, 4),
        None)
      logger.debug(tt.toc("getRowsContainingCols1"))
      logger.debug("resu1t \n" + result1.get.sparseData().collect().mkString("\n"))
      assert(result1.get.sparseData().filter(e =>e._1.features.toSparse.values(0)==13).collect().size==0)
      logger.debug(tt.tic("getRowsContainingCols2"))
      val result2: Option[RDDLabeledPoint] = RDDLabeledPoint.getRowsContainingColIdxAndMatchesLabelUnchangedSchema(sparse1,Set(3, 4), Some(3.0))
      logger.debug(tt.toc("getRowsContainingCols2"))

      logger.debug("resu1t \n" + result2.get.sparseData().collect().mkString("\n"))
      assert(result2.get.sparseData().filter(e =>e._1.features.toSparse.values(0)==10).collect().size==0)
      assert(result2.get.sparseData().filter(e =>e._1.features.toSparse.values(0)==7).collect().size==1)
    }
    catch
      {
        case e: Exception =>
          logger.error(e.getMessage, e)
          fail(e.getMessage)
      }
  }

  def getProportionOfColumnsWithValues(): Unit =
  {

    try
    {
      val tt: TicToc = new TicToc
      val sparse1 = sparse.copy()
      logger.debug(tt.tic("getProprtionOfColumnsWithValues"))
      val result1: Seq[(Int,Double)] = RDDLabeledPoint.proportionOfColumnWithValues(sparse1)
      logger.debug(tt.toc("getProprtionOfColumnsWithValues"))
      logger.debug("resu1t \n" + result1.mkString("\n"))
    }
    catch
      {
        case e: Exception =>
          logger.error(e.getMessage, e)
          fail(e.getMessage)
      }
  }

  def getProportionRandomSubset(): Unit =
  {

    try
    {
      val tt: TicToc = new TicToc
      val sparse1 = sparse.copy()
      logger.debug(tt.tic("getProportionRandomSubset"))
      logger.debug(sparse1.info)
      val sparseOut = RDDLabeledPoint.randomSubset(sparse1,0.2)
      logger.debug(tt.toc("getProportionRandomSubset"))
      logger.debug("resu1t size: " + sparseOut.get.rowCount)
      assert(sparseOut.get.rowCount<6)




    }
    catch
      {
        case e: Exception =>
          logger.error(e.getMessage, e)
          fail(e.getMessage)
      }
  }

  def reduce(): Unit =
  {

    try
    {
      val tt: TicToc = new TicToc
      val sparse1 = sparse.copy()
      logger.debug(tt.tic("reduce"))
      val sparseOut = RDDLabeledPoint.reduceToTargetBySum1(sparse1).get
      logger.debug(tt.toc("reduce"))
      logger.debug("resu1t size: " + sparseOut.rowCount)
      logger.debug(sparseOut.info)
      logger.debug(sparseOut.lpData().collect().mkString("\n"))

    }
    catch
      {
        case e: Exception =>
          logger.error(e.getMessage, e)
          fail(e.getMessage)
      }
  }


  def removeColumns(): Unit =
  {

    try
    {
      val tt: TicToc = new TicToc
      val sparse1 = sparse.copy()
      logger.debug(tt.tic("\n+++++++++++++++\nremoveColumns\n+++++++++++++++\n"))

      logger.debug(sparse1.info)
      val q:mutable.Queue[Int]=new mutable.Queue[Int]
      q += 4
      q += 0
      q += 2
      val sparseOut = RDDLabeledPoint.removeColumnsCollected(sparse1,q).get
      logger.debug(tt.toc("\n+++++++++++++++\nremoveColumns\n+++++++++++++++\n"))
      logger.debug(sparseOut.info)
      logger.debug("resu1t size: " + sparseOut.rowCount)
      logger.debug(sparseOut.info)
      logger.debug(sparseOut.lpData().collect().mkString("\n"))

    }
    catch
      {
        case e: Exception =>
          logger.error(e.getMessage, e)
          fail(e.getMessage)
      }
  }


  def removeColumnsDistributed(): Unit =
  {

    try
    {
      val tt: TicToc = new TicToc
      val sparse1 = sparse.copy()
      logger.debug(tt.tic("\n+++++++++++++++\nremoveColumns distributed\n+++++++++++++++\n"))

      val countOriginal=sparse1.columnCountFromDataRDD()
      logger.debug(sparse1.info)
      val s:Set[Int]=Set(4,3,1)

      val sparseOut = RDDLabeledPoint.removeColumnsDistributed(sparse1,s).get
      logger.debug(tt.toc("\n+++++++++++++++\nremoveColumns distributed\n+++++++++++++++\n"))
      logger.debug(sparseOut.info)


      logger.debug(sparseOut.info)
      logger.debug(sparseOut.lpData().collect().mkString("\n"))
      assert((countOriginal - 3) == sparseOut.columnCountFromDataRDD())

    }
    catch
      {
        case e: Exception =>
          logger.error(e.getMessage, e)
          fail(e.getMessage)
      }
  }

  def mergeSchemas(): Unit =
  {
    try
    {
      val tt: TicToc = new TicToc
      val sparse1 = sparse.copy()
      val sparse0: RDDLabeledPoint = new RDDLabeledPoint


      val t=RDDLabeledPoint.loadLibSvmLocal( "./unitTestInput/lltiny.libsvm")
      val sparse2:RDDLabeledPoint=t.isSuccess match
      {
        case true=> t.get
        case false => logger.error(t.failed.get.getMessage,t.failed.get)
          throw new IKodaMLException(t.failed.get.getMessage)
      }



      logger.debug(tt.tic("\n+++++++++++++++\nmergeSchemas\n+++++++++++++++\n"))

      logger.debug(sparse1.info)
      logger.debug(sparse2.info)
      logger.debug("sparse1 Column Heads\n"+sparse1.columnHeads().mkString("\n"))
      logger.debug("sparse2 Column Heads\n"+sparse2.columnHeads().mkString(" \n --"))
      val sparseOut = sparse1.transformToRDDLabeledPointWithSchemaMatchingThis(sparse2).get
      logger.debug(tt.toc("\n+++++++++++++++\nmergeSchemas\n+++++++++++++++\n"))
      logger.debug(sparseOut.info)
      logger.debug("sparseOut resu1t size: " + sparseOut.rowCount)

      logger.debug("sparseOut Column Heads\n"+sparseOut.columnHeads().mkString("\n"))
      logger.debug("sparseOut Targets\n"+sparseOut.getTargets().mkString("\n"))
      logger.debug(tt.tic("\n+++++++++++++++\nmergeSchemas1\n+++++++++++++++\n"))
      assert(sparseOut.getColumnIndex("z3")==11)
      val q = new mutable.Queue[Int]()
      q += sparseOut.getColumnIndex("col7")
      RDDLabeledPoint.removeColumnsCollected(sparseOut,q)
      logger.debug(tt.toc("\n+++++++++++++++\nmergeSchemas1\n+++++++++++++++\n"))


    }
    catch
      {
        case e: Exception =>
          logger.error(e.getMessage, e)
          fail(e.getMessage)
      }
  }


  def lpHash(): Unit =
  {
    try
    {
      val tt: TicToc = new TicToc
      val sparse1 = sparse.copy()

      val hash1:Set[Int]=sparse1.lpData().map
      {
        lp=> (lp.label+lp.features.toSparse.values.mkString(",")+lp.features.toSparse.indices.mkString(",")).hashCode
      }.collect.toSet


      val sparse2=openTiny
      val hash2:Set[Int]=sparse2.lpData().map
      {
        lp=> (lp.label+lp.features.toSparse.values.mkString(",")+lp.features.toSparse.indices.mkString(",")).hashCode
      }.collect.toSet

      val difference=hash2.diff(hash1)
      assert(difference.isEmpty)
      val difference1=hash1.diff(hash2)
      assert(difference1.isEmpty)
      logger.debug("\n"+hash2.mkString("\n"))
      logger.debug("\n|n"+hash1.mkString("\n"))





    }
    catch
      {
        case e: Exception =>
          logger.error(e.getMessage, e)
          fail(e.getMessage)
      }
  }



  def mergeSchemasFromCSV(): Unit =
  {

    try
    {
      val tt: TicToc = new TicToc
      val sparse1 = sparse.copy()

      Spreadsheet.getInstance().initLibsvm2("sparse2",SSm.getAppLogger,"aa_label","./unitTestInput")
      Spreadsheet.getInstance().getLibSvmProcessor("sparse2").loadLibsvmPJ("lltiny")
      logger.debug(tt.tic("mergeSchemas"))

      logger.debug(sparse1.info)

      logger.debug("sparse1 Column Heads\n"+sparse1.columnHeads().mkString("\n"))
      logger.debug("sparse2 Column Heads\n"+Spreadsheet.getInstance().getLibSvmProcessor("sparse2").getColumnHeadings)
      val sparseOut = sparse1.transformToRDDLabeledPointWithSchemaMatchingThis(Spreadsheet.getInstance().getLibSvmProcessor("sparse2"))
      logger.debug(tt.toc("mergeSchemas"))
      logger.debug(sparseOut.info)
      logger.debug("sparseOut resu1t size: " + sparseOut.rowCount)

      logger.debug("sparseOut Column Heads"+sparseOut.columnHeads().mkString("\n"))
      assert(sparseOut.getColumnIndex("col7")==8)


    }
    catch
      {
        case e: Exception =>
          logger.error(e.getMessage, e)
          fail(e.getMessage)
      }
  }

  def convertToMLPackage(): Unit =
  {

    try
    {
      val tt: TicToc = new TicToc
      val sparse1 = sparse.copy()
      logger.debug(tt.tic("convertToMLPackage"))
      val mlpackageRDD = sparse1.convertToMLLibPackageRDD()
      logger.debug(tt.toc("convertToMLPackage"))
      logger.debug("mlpackageRDD label"+mlpackageRDD.take(1)(0).label+" indices: "+mlpackageRDD.take(1)(0).features.toSparse.indices.mkString(","))


    }
    catch
      {
        case e: Exception =>
          logger.error(e.getMessage, e)
          fail(e.getMessage)
      }
  }
  def convertToDF(): Unit =
  {

    try
    {
      val tt: TicToc = new TicToc
      val sparse1 = sparse.copy()
      logger.debug(tt.tic("convertToDF"))
      val df = sparse1.transformRDDToDataFrame()
      logger.debug(tt.toc("convertToDF"))
      logger.debug(DataFrameUtils.showString(df,8))


    }
    catch
      {
        case e: Exception =>
          logger.error(e.getMessage, e)
          fail(e.getMessage)
      }
  }


  def closeSpark(): Unit =
  {

    try
    {
      logger.debug("Closing spark")


        killSparkStreamingContext
      clearSession
        spark.close()


    }
    catch
      {
        case e: Exception =>
          logger.error(e.getMessage, e)
          fail(e.getMessage)
      }
  }
}

