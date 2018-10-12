package ikoda.sparse

import java.io.{BufferedWriter, File, FileWriter}
import java.util.UUID

import ikoda.IKodaMLException
import ikoda.utilobjects.{DataFrameUtils, UtilFunctions}
import ikoda.utils.TicToc
import org.apache.spark.ml.feature.LabeledPoint
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, SparkSession}

import scala.collection.immutable.{ListMap, SortedMap}
import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.collection.{immutable, mutable}
import scala.util.Try

class RDDLabeledPointInterface(ilp:LpData) extends RDDLabeledPointInternalOperations(ilp) with UtilFunctions
{
  @throws(classOf[IKodaMLException])
  private [sparse] def soAddColumn( col: Seq[CellTuple], colName: String): RDDLabeledPoint =
  {
    try
    {
      val newColumnMap = internalAddColumnHead1(colName)
      val colIndex:Int=newColumnMap.find(e=>e._2.stringLabel == colName).get._2.numericLabel

      val newCol: Array[CellTuple] = col.map
      {
        ct => new CellTuple(colIndex, ct.label, ct.value, ct.rowId, ct.rowPos)
      }.toArray



      val columnMap: immutable.SortedMap[Int, Seq[CellTuple]] = transformColAsRowRddToTreeMap(transformLabeledPointRDDToColumnsRdd())
      var mutableColumnMap: mutable.HashMap[Int, Seq[CellTuple]] = mutable.HashMap[Int, Seq[CellTuple]](
        columnMap.toSeq: _*
      )
      mutableColumnMap.put(colIndex, newCol)

      val maxCol=newColumnMap.keySet.max+1
      logger.debug(getColumnHeads().mkString("\n"))
      logger.debug(newColumnMap.mkString("\n"))





      val data=transformColumnsMapToLabeledPointRDD(spark, mutableColumnMap.toMap, allowRowCountChange = true, maxColumnIdxo = Some(maxCol+2))
      new RDDLabeledPoint(new LpData(Some(data),Some(newColumnMap),Some(copyTargetMap),Some(ilp.name)))

    }
    catch
    {

      case e: Exception =>
      {
        logger.error(s"$ilp.name")
        logger.error(e.getMessage, e)
        throw e;
      }
    }
  }

  private [sparse] def soCleanLowerCaseColumns1(): RDDLabeledPoint =
  {
    cleanLowerCaseColumns1()
  }

  @throws(classOf[IKodaMLException])
  private [sparse] def soMergeTargets(oldnew:Map[Double,Double]): RDDLabeledPoint =
  {
    try
    {
      val newLabelMap: mutable.HashMap[Double, Double] = new mutable.HashMap()
      val oldnewb=spark.sparkContext.broadcast(oldnew)

      val newdata:RDD[(LabeledPoint,Int,String)] = sparseData.map
      {
        r =>

          val currentLabel: Double = r._1.label
          currentLabel match
          {
            case x if (oldnewb.value.get(x).isDefined) =>
              (new LabeledPoint(oldnewb.value.get(x).get, r._1.features), r._2, r._3)
            case _ => r
          }

      }
      val newtargetmap=ilp.targetMap.filter(e=> !(oldnew.keySet.contains(e._2)))
      new RDDLabeledPoint(newdata,copyColumnMap,newtargetmap,ilp.name)
    }
    catch
      {

        case e: Exception =>
          logger.error(s"${ilp.name}", e)
          throw IKodaMLException(e.getMessage, e)
      }
  }

  @throws(classOf[IKodaMLException])
  private [sparse] def soMergeTarget1( oldTargetIdx: Double, newTargetIdx: Double): RDDLabeledPoint =
  {
    try
    {
      val oldTargetIdxb=spark.sparkContext.broadcast(oldTargetIdx)
      val newTargetIdxb=spark.sparkContext.broadcast(newTargetIdx)

      val newdata:RDD[(LabeledPoint,Int,String)] = sparseData.map
      {
        r =>

          val currentLabel: Double = r._1.label
          currentLabel match
          {
            case x if x == oldTargetIdxb.value =>
              val newtrgt=newTargetIdxb.value
              (new LabeledPoint(newtrgt, r._1.features), r._2, r._3)
            case _ => r
          }
      }
      val newtargetmap=ilp.targetMap.filter(e=> !(e._2 == oldTargetIdx))
      new RDDLabeledPoint(newdata,copyColumnMap,newtargetmap,ilp.name)
    }
    catch
    {

      case e: Exception =>
        logger.error(s"${ilp.name}", e)
        throw IKodaMLException(e.getMessage, e)
    }
  }


  @throws(classOf[IKodaMLException])
  private [sparse] def soColStDevs(): Map[Int, CellTuple] =
  {
    try
    {

      val colRdd:RDD[(Int,Seq[CellTuple])]=transformLabeledPointRDDToColumnsRdd()
      colRdd.map
      {

        case (colidx, ctSeq) =>

          import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics

          val stats = new DescriptiveStatistics

          ctSeq.foreach
          {
            colCellTuple: CellTuple =>
              stats.addValue(colCellTuple.value)
          }
          val t2=Tuple2(colidx, CellTuple(colidx, 0, stats.getStandardDeviation, createUUID(), 0))
          stats.clear()
          t2
      }.collect().toMap
    }
    catch
    {

      case e: Exception =>
        logger.error(s"${ilp.name}")
        throw IKodaMLException(e.getMessage, e)
    }
  }


  @throws(classOf[IKodaMLException])
  private [sparse] def soColSums(): Map[Int, CellTuple] =
  {
    try
    {
      val rddColAsRow:RDD[(Int,Seq[CellTuple])]=transformLabeledPointRDDToColumnsRdd
      rddColAsRow.map
      {
        case (colidx, ct) =>
          var sum: Double = 0
          ct.foreach
          {
            colCellTuple: CellTuple =>
              sum += colCellTuple.value

          }
          (colidx, CellTuple(colidx, 0, sum, createUUID(), 0))
      }.collect().toMap
    }
    catch
    {
      case e: Exception =>
        logger.error(s"${ilp.name}")
        throw IKodaMLException(e.getMessage, e)
    }
  }


  @throws(classOf[IKodaMLException])
  private [sparse] def soProportionOfColumnWithValues(ignoreCol: String = ""): Seq[(Int, Double)] =
  {
    try
    {
      val mapOfColumns: RDD[(Int, Seq[CellTuple])] = transformLabeledPointRDDToColumnsRdd()
      val sb: StringBuilder = new StringBuilder

      val colCount: Int = getColumnCount
      val rCount: Double = 1.0
      val rowCount = rCount.toInt
      mapOfColumns.map
      {
        colCellArray =>
          val proportion: Double = colCellArray._2.length.toDouble / rCount
          sb.append(s"col : ${colCellArray._1} | vc: ${colCellArray._2.length} rc: ${rCount}  pptn: $proportion")
          (colCellArray._1, proportion)

      }.collect

    }
    catch
    {

      case e: Exception =>
        logger.error(s"${ilp.name}")
        throw IKodaMLException(e.getMessage, e)
    }
  }


  @throws(classOf[IKodaMLException])
  private [sparse] def soColMedian(): Map[Int, CellTuple] =
  {
    try
    {
      val mapOfColumns: RDD[(Int, Seq[CellTuple])] = transformLabeledPointRDDToColumnsRdd()

      val mapForColMedians: Map[Int, CellTuple] =mapOfColumns.map
      {

        colAsRow =>


          val columnValues: Seq[Double] = colAsRow._2.map(cct => cct.value)
          val sortedValues: Seq[Double] = columnValues.sorted
          val median: Double = sortedValues(sortedValues.length / 2)
          logger.trace("col median "+median)
          (colAsRow._1, CellTuple(colAsRow._1, 0, median, createUUID(), 0))
      }.collect.toMap
      logger.trace(s"Returning ${mapForColMedians.size} entries" )
      mapForColMedians
    }
    catch
    {

      case e: Exception =>
        logger.error(s"${ilp.name}")
        throw IKodaMLException(e.getMessage, e)
    }
  }




  @throws(classOf[IKodaMLException])
  private [sparse] def soColumnCellOnColumnConstant1(operation: FTDoubleDouble_Double, constants: Map[Int, CellTuple]): RDDLabeledPoint =
  {
    try
    {
      val rddColAsRow:RDD[(Int,Seq[CellTuple])]=transformLabeledPointRDDToColumnsRdd

      if (ilp.columnHeadMap.size != constants.size)
      {
        logger.warn(
          "WARNING: sparseOperationColumnCellOnColumnConstant the rdd column count does not equal the constants " +
            "columns count."
        )
      }
      val rddOfNewColumns:RDD[(Int,Seq[CellTuple])]=rddColAsRow.map
      {
        case (colidx,seqCellTuple) =>
          val constant: CellTuple = constants.getOrElse(colidx, CellTuple(-111, -111, -111, UUID.randomUUID(), -111))
          if (constant.colIndex == -111 && constant.label == -111)
          {
            throw IKodaMLException(s"No constant available for column number $colidx ")
          }

          if (seqCellTuple.isEmpty)
          {
            throw IKodaMLException(s"No column found for index $colidx")
          }
          (colidx, rddLabeledPointColumnOperation(seqCellTuple, constant, operation))
      }
      val newdata=transformColumnsRddToLabeledPointRDD1(spark, rddOfNewColumns)
      new RDDLabeledPoint(newdata,ilp.columnHeadMap,ilp.targetMap,ilp.name)
    }
    catch
    {
      case e: Exception =>
      {
        logger.error(s"${ilp.name} : ${e.getMessage}")
        throw IKodaMLException(e.getMessage, e)
      }
    }
  }

  @throws(classOf[IKodaMLException])
  private [sparse] def soInverseDocumentFrequency(): RDDLabeledPoint =
  {
    try
    {
      val rddColAsRow:RDD[(Int,Seq[CellTuple])]=transformLabeledPointRDDToColumnsRdd
      val colSums=soColSums()
      val corpusTotal=rowCount

      def calculateIDF(seqCt:Seq[CellTuple],idf:Double): Seq[CellTuple] =
      {
        seqCt.map
        {
          ct=> CellTuple(ct.colIndex, ct.label, idf*ct.value , ct.rowId, ct.rowPos)
        }
      }


      if (rowCountEstimate != colSums.size)
      {
        logger.warn(
          "WARNING: soInverseDocumentFrequency the rdd column count does not equal the constants " +
            "columns count."
        )
      }
      val rddOfNewColumns:RDD[(Int,Seq[CellTuple])]=rddColAsRow.map
      {
        case (colidx,seqCellTuple) =>
          val constanto: Option[CellTuple] = colSums.get(colidx)


          if (constanto.isEmpty)
          {
            throw IKodaMLException(s"No constant available for column number $colidx ")
          }
          val idf:Double=scala.math.log(corpusTotal.toDouble / constanto.get.value)
          if (seqCellTuple.isEmpty)
          {
            throw IKodaMLException(s"No column found for index $colidx")
          }
          (colidx, calculateIDF(seqCellTuple,idf))
      }

      val newData=transformColumnsRddToLabeledPointRDD1(spark, rddOfNewColumns)
      new RDDLabeledPoint(newData,ilp.columnHeadMap,ilp.targetMap,ilp.name)

    }
    catch
      {
        case e: Exception =>
        {
          logger.error(s"${ilp.name}")

          logger.error(s"${ilp.name} : ${e.getMessage}")
          throw IKodaMLException(e.getMessage, e)
        }
      }
  }


  @throws(classOf[IKodaMLException])
  private [sparse] def soCountRowsByTarget(): RDD[(Double,Int)] =
  {
    try
    {
      val rdd1:RDD[(Double,Int)]=ilp.dataRDD.map
      {
        case (r) => (r._1.label,1)
      }
      rdd1.groupBy(e=>e._1).map(e=> (e._1,e._2.toSeq.length))

    }
    catch
    {

      case e: Exception =>
        logger.error("sparseOperationCountRowsByTargetCollected " + e.getMessage, e)
        throw IKodaMLException(e.getMessage, e)
    }

  }

  @throws(classOf[IKodaMLException])
  private [sparse] def soReduceToTargetBySum1(): RDDLabeledPoint =
  {
    try
    {
      val colMap:RDD[(Int,Seq[CellTuple])] = transformLabeledPointRDDToColumnsRdd()


      val newLpArray:Array[LabeledPoint]=ilp.targetMap.map
      {
        label =>
          val x:scala.collection.Map[Int,Double]=colMap.filter(c => c._2 == label._2).map(e=>e._1 -> e._2.map(ct => ct.value).sum ).collectAsMap()
          val t = scala.collection.immutable.TreeMap(x.toArray:_*)
          newLabeledPoint(label._2,t.keySet.toArray,t.values.toArray)
      }.toArray


      val newLpRDD:RDD[(LabeledPoint,Int,String)]=spark.sparkContext.parallelize(newLpArray).map(lp=> (lp,lpHash(lp),createUUID.toString))
      new RDDLabeledPoint(newLpRDD,copyColumnMap,copyTargetMap,ilp.name)


    }
    catch
      {

        case e: Exception =>
          logger.error(s"${ilp.name}")
          throw IKodaMLException(e.getMessage, e)
      }
  }







  @throws(classOf[IKodaMLException])
  private [sparse] def soCountRowsByTargetCollected(): Map[Double,Int] =
  {
    try
    {

      val rdd1:RDD[(Double,Int)]=ilp.dataRDD.map
      {
        case (r) => (r._1.label,1)
      }
      rdd1.groupBy(e=>e._1).map(e=> (e._1,e._2.toSeq.length)).collectAsMap().toMap

    }
    catch
    {

      case e: Exception =>
        logger.error("soCountRowsByTargetCollected " + e.getMessage, e)
        throw IKodaMLException(e.getMessage, e)
    }

  }

  @throws(classOf[IKodaMLException])
  private [sparse] def soDichotomizeTargetOrOther( label: Double, stringLabel: String)
  : Option[RDDLabeledPoint] =
  {
    try
    {
      val dataByLabel: RDD[(LabeledPoint, Int, String)] = ilp.dataRDD
      val lpByLabelQueue: mutable.Queue[(LabeledPoint, Int, String)] = mutable.Queue(dataByLabel.collect().toSeq: _*)
      val otherLabel: Double = 0.0

      if (dataByLabel.filter(r => r._1.label == label).isEmpty)
      {
        logger.trace(ilp.targetMap.mkString("\n"))
        logger.warn("No rows for label " + stringLabel)
        Option(null)
      }
      else
      {

        val updatedLpByLabelArray: ArrayBuffer[(LabeledPoint, Int, String)] = new ArrayBuffer[(LabeledPoint, Int,
          String)]()

        while (lpByLabelQueue.length > 0)
        {
          val rowCurr: (LabeledPoint, Int, String) = lpByLabelQueue.dequeue()
          val labelCurr = rowCurr._1.label
          if (!labelCurr.equals(label))
          {
            val lp = new LabeledPoint(otherLabel, rowCurr._1.features)
            updatedLpByLabelArray += Tuple3(lp, rowCurr._2, rowCurr._3)
          }
          else
          {
            updatedLpByLabelArray += Tuple3(new LabeledPoint(1.0, rowCurr._1.features), rowCurr._2, rowCurr._3)
          }
        }
        val newlabelmap: mutable.HashMap[String, Double] = new mutable.HashMap()
        newlabelmap.put(stringLabel, 1.0)
        newlabelmap.put("OTHER", otherLabel)
        val newRDD: RDD[(LabeledPoint, Int, String)] = spark.sparkContext.parallelize(updatedLpByLabelArray)
        Some(new RDDLabeledPoint(newRDD,copyColumnMap,newlabelmap.toMap,ilp.name))

      }
    }
    catch
    {

      case e: Exception =>
        logger.error(s"${ilp.name}", e)
        throw IKodaMLException(e.getMessage, e)
    }
  }



  @throws(classOf[IKodaMLException])
  private [sparse] def soEvenProportionPerTarget1(): RDDLabeledPoint =
  {
    try
    {
      val labelRdd: RDD[(Double, Int)] = soCountRowsByTarget().filter(e => e._2>0)
      val labelCount=labelRdd.groupBy(x=>x._1).count



      if (labelCount > 2)
      {
        internalEvenProportionPerTargetMultivariate1(labelRdd.collect)
      }
      else
      {
        internalEvenProportionPerTargetBivariate1( labelRdd)
      }
    }
    catch
    {

      case e: Exception =>
        logger.error(s"${ilp.name}", e)
        throw IKodaMLException(e.getMessage, e)
    }
  }


  @throws(classOf[IKodaMLException])
  private [sparse] def soRenameTargetsInNumeriOrder1(): RDDLabeledPoint =
  {
    try
    {
      var count: Double = 0

      def incrementLabel(): Double =
      {
        count = count + 1
        count
      }

      val oldnewmap:Map[Double,Double]=ilp.targetMap.map
      {
        e=> (e._2,incrementLabel())
      }


     val oldnewmapb = spark.sparkContext.broadcast(oldnewmap)


      val newdata: RDD[(LabeledPoint, Int, String)] = sparseData().map
      {
        r =>


          var labelCurrO: Option[Double] = oldnewmapb.value.get(r._1.label)
          val newlabel:Double=labelCurrO.isDefined match
          {
            case true=> labelCurrO.get

            case _ => -1.0
          }
          (new LabeledPoint(newlabel, r._1.features), r._2, r._3)
      }

      val newtargetmap: Map[String, Double] = ilp.targetMap.map
      {
        e =>
          val stringValue: String = getTargetName(e._2)
          val numericValueo:Option[Double] = oldnewmap.get(e._2)
          val numericValue:Double= numericValueo.isDefined match
            {
            case true=> numericValueo.get
            case _ => -1.0
          }
          (stringValue, numericValue)
      }

      new RDDLabeledPoint(newdata,copyColumnMap,newtargetmap,ilp.name)
    }
    catch
    {

      case e: Exception =>
        logger.error(s"${ilp.name}", e)
        throw IKodaMLException(e.getMessage, e)
    }
  }


  @throws(classOf[IKodaMLException])
  private [sparse] def soRemoveDuplicateRows1(): RDDLabeledPoint =
  {
    try
    {
      val newdata: RDD[(LabeledPoint, Int, String)] = sparseData().map
      {
        r =>
          (s"${r._1.features.toSparse.indices.mkString("")}${
            r._1.features.toSparse.values.mkString("")
          } ${r._1.label}",r)
      }.reduceByKey{case (x,y)=> if(x._1.hashCode()>y._1.hashCode()) x else y}.map
      {
        e=>(e._2._1,e._2._2,e._2._3)
      }

      new RDDLabeledPoint(newdata,copyColumnMap,copyTargetMap,ilp.name)
    }
    catch
    {

      case e: Exception =>
        logger.error(s"${ilp.name}", e)
        throw IKodaMLException(e.getMessage, e)
    }
  }




  @throws(classOf[IKodaMLException])
  private def soGetRowsContainingColIdxUnchangedSchema(colIdxSet: Set[Int]): Option[RDDLabeledPoint] =
  {
    try
    {
      logger.trace("looking for " + colIdxSet)
      val newdata = ilp.dataRDD.filter(r => colIdxSet.subsetOf(r._1.features.toSparse.indices.toSet))
      logger.info("Sparse out row count " + rowCount)

      if (rowCount == 0)
      {
        logger.warn("sparseOperationGetRowsContainingColIdx: Retrieved row count of 0")
        None
      }
      else
      {
        val sparseOut: RDDLabeledPoint = new RDDLabeledPoint(newdata,copyColumnMap,copyTargetMap,ilp.name)
        Option(sparseOut)
      }
    }
    catch
    {
      case e: Exception =>
        logger.error(s"${ilp.name}")
        logger.error(e.getMessage, e)
        throw e;
    }
  }


  @throws(classOf[IKodaMLException])
  private [sparse] def soGetRowsContainingColIdxAndMatchesLabelUnchangedSchema(colIdxSet: Set[Int], labelo: Option[Double])
  : Option[RDDLabeledPoint] =
  {
    try
    {
      if (labelo.isDefined)
      {
        soGetRowsContainingColIdxAndMatchesLabelUnchangedSchema(colIdxSet, labelo.get)
      }
      else
      {
        soGetRowsContainingColIdxUnchangedSchema(colIdxSet)
      }
    }
    catch
    {
      case e: Exception =>
        logger.error(s"${ilp.name}")
        logger.error(e.getMessage, e)
        throw e;
    }
  }

  @throws(classOf[IKodaMLException])
  private def soGetRowsContainingColIdxAndMatchesLabelUnchangedSchema(colIdxSet: Set[Int], label: Double)
  : Option[RDDLabeledPoint] =
  {
    try
    {
      val newdata = ilp.dataRDD.filter(
        r => colIdxSet.subsetOf(r._1.features.toSparse.indices.toSet) && r._1.label == label
      )
      if (newdata.count == 0)
      {
        None
      }
      else
      {
        val sparseOut: RDDLabeledPoint = new RDDLabeledPoint(newdata,copyColumnMap,copyTargetMap,ilp.name)

        Some(sparseOut)
      }
    }
    catch
    {
      case e: Exception =>
        logger.error(s"${ilp.name}")
        logger.error(e.getMessage, e)
        throw e;
    }
  }



  @throws(classOf[IKodaMLException])
  private [sparse] def soRandomSubsetWithColumnRealignment(proportion: Double): RDDLabeledPoint =
  {
    try
    {
      if (proportion > 0.999)
      {
        throw IKodaMLException("Proportion must be less than 1")
      }
      val exclude: Double = 1 - proportion
      logger.info(info)
      logger.info(s"sProportions. Keep: $proportion Drop: $exclude")
      val splits = sparseData().randomSplit(Array(proportion, exclude))
      val keep: RDD[(LabeledPoint, Int, String)] = splits(0)

      logger.info(s"Keeping ${keep.count} rows")
      val tuple:Tuple2[mutable.ListMap[Int, ColumnHeadTuple], mutable.HashMap[Int, Int]] = internalSubsetColumnHeads(keep.map(r => r._1).collect())
      val newdata = internalSubsetColumnIndices1(keep, tuple._1, tuple._2)
      val newRDDLP: RDDLabeledPoint = new RDDLabeledPoint(newdata,tuple._1,copyTargetMap,ilp.name)
      newRDDLP
    }
    catch
    {

      case e: Exception =>
        logger.error(s"${ilp.name}", e)
        throw IKodaMLException(e.getMessage, e)
    }
  }



  @throws(classOf[IKodaMLException])
  private [sparse] def soRandomSubset(proportion: Double): RDDLabeledPoint =
  {
    try
    {
      if (proportion > 0.999)
      {
        throw IKodaMLException("Proportion must be less than 1")
      }
      val exclude: Double = 1 - proportion

      val splits = sparseData().randomSplit(Array(proportion, exclude))
      val keep: RDD[(LabeledPoint, Int, String)] = splits(0)

      logger.info(s"Keeping ${keep.count} rows")

      val newRDDLP: RDDLabeledPoint = new RDDLabeledPoint(keep,copyColumnMap,copyTargetMap,ilp.name)

      newRDDLP
    }
    catch
      {

        case e: Exception =>
          logger.error(s"${ilp.name}", e)
          throw IKodaMLException(e.getMessage, e)
      }
  }

  @throws(classOf[IKodaMLException])
  private [sparse] def lpSampleDebug(proportion:Double): String =
  {

    try
    {
      val subsett = Try(soRandomSubset(proportion))
      val sb:StringBuilder = new StringBuilder()
      subsett.isSuccess match
        {
        case true =>

          val tempMap:Seq[String]=subsett.get.lpData().collect().map
          {
            lp => sb.append("\n")
              sb.append(lpDebugString(lp))
              sb.append(" : ")
              sb.append(lpHash(lp))
              sb.append("")
              sb.toString()
          }
          tempMap.mkString(" | ")

        case false => "Failed to retrieve subset."
      }
    }
    catch
      {

        case e: Exception =>
          logger.error(s"${ilp.name}", e)
          throw IKodaMLException(e.getMessage, e)
      }
  }


  @throws(classOf[IKodaMLException])
  private [sparse] def soSubsetByTarget( label: Double, stringLabel: String): Option[RDDLabeledPoint] =
  {
    try
    {
      val lpByLabelRdd: RDD[(LabeledPoint, Int, String)] = ilp.dataRDD.filter(r => r._1.label == label)
      if (lpByLabelRdd.isEmpty)
      {
        logger.warn("No rows for label " + stringLabel)
        Option(null)
      }
      else
      {
        val tuple = internalSubsetColumnHeads(lpByLabelRdd.map(r => r._1).collect().toArray)
        val updatedLpByLabelRdd = internalSubsetColumnIndices1(lpByLabelRdd, tuple._1, tuple._2)
        val newlabelmap: Map[String, Double] = immutable.HashMap(stringLabel -> label)
        val newRDDLP: RDDLabeledPoint = new RDDLabeledPoint(updatedLpByLabelRdd,tuple._1,newlabelmap,ilp.name)
        Option(newRDDLP)
      }
    }
    catch
    {
      case e: Exception =>
        logger.error(s"${ilp.name}", e)
        throw IKodaMLException(e.getMessage, e)
    }
  }



  @throws(classOf[IKodaMLException])
  private [sparse] def soRemoveColumns1( columnIndices: mutable.Queue[Int]): RDDLabeledPoint =
  {
    var sortedQ: mutable.Queue[Int] = columnIndices.filter(idx => idx >=0)
    sortedQ.size match {

      case x if(x>0) => internalRemoveColumns1 (sortedQ)
      case _ => val sparseOut=new RDDLabeledPoint(ilp)
        sparseOut.columnCountOffset=columnCountOffset
        sparseOut
    }
  }


  @throws(classOf[IKodaMLException])
  private [sparse] def soRemoveColumnsDistributed( columnIndices: Set[Int]): RDDLabeledPoint =
  {

    soRemoveColumnsDistributed(columnIndices,true)

  }


  @throws(classOf[IKodaMLException])
  private [sparse] def soRemoveColumnsDistributed( columnIndices: Set[Int],failOnError:Boolean): RDDLabeledPoint =
  {

    columnIndices.size match {

      case x if(x>0) => internalRemoveColumns2 (columnIndices,failOnError)
      case _ => val sparseOut=new RDDLabeledPoint(ilp)
        sparseOut.columnCountOffset=columnCountOffset
        sparseOut
    }
  }

  @throws(classOf[IKodaMLException])
  private [sparse] def soResetColumnIndices( ): RDDLabeledPoint =
  {
      internalResetColumnIndices2()
  }


  @throws(classOf[IKodaMLException])
  private [sparse] def soRemoveRowsByLabels1( labelsToRemove: Seq[Double]): RDDLabeledPoint =
  {
    try
    {
     internalRemoveRowsByLabels1(labelsToRemove)
    }
    catch
    {
      case e: Exception =>
        logger.error(s"${ilp.name}")
        throw IKodaMLException(e.getMessage, e)
    }
  }

  @throws(classOf[IKodaMLException])
  private [sparse] def soRemoveRowsByHashcode( hcToRemove: Seq[Int]): RDDLabeledPoint =
  {
    try
    {
      internalRemoveRowsByHashcode(hcToRemove)
    }
    catch
      {
        case e: Exception =>
          logger.error(s"${ilp.name}")
          throw IKodaMLException(e.getMessage, e)
      }
  }

  @throws(classOf[IKodaMLException])
  private [sparse] def soRowSums(): mutable.HashMap[Double, CellTuple] =
  {
    try
    {
      var i = 0

      val mapForCol = ilp.dataRDD.map
      {
        case (r) =>
          i = i + 1
          var sum: Double = 0

          r._1.features.toSparse.values.foreach
          {
            case (d) => sum += d
          }

          val cell: CellTuple = CellTuple(
            r._1.features.toSparse.values.length + 1, r._1.label.toInt, sum,
            getOrCreateUUID(r._3), i
          )
          r._1.label -> cell

      }.collect().toMap
      mutable.HashMap[Double, CellTuple](mapForCol.toSeq: _*)

    }
    catch
    {
      case e: Exception =>
        logger.error(s"${ilp.name}")
        throw IKodaMLException(e.getMessage, e)
    }

  }

  @throws(classOf[IKodaMLException])
  private [sparse] def soTermFrequencyNormalization(): RDDLabeledPoint =
  {
    try
    {
      var i = 0

      val newData:RDD[(LabeledPoint,Int,String)] = ilp.dataRDD.map
      {
        case (r) =>
          val length=r._1.features.toSparse.indices.length
          val newVals:Seq[Double]=r._1.features.toSparse.values.map
          {
            v=> v / length
          }

          val newlp = newLabeledPoint(r._1.label, r._1.features.toSparse.indices, newVals.toArray)
          (newlp,r._2,r._3)
      }

      new RDDLabeledPoint(newData,copyColumnMap,copyTargetMap,getName())
    }
    catch
      {

        case e: Exception =>


          logger.error(s"${ilp.name}")
          throw IKodaMLException(e.getMessage, e)

      }

  }


  @throws(classOf[IKodaMLException])
  private [sparse] def soRowCellOnRowConstant1( operation: FTDoubleDouble_Double, constants: mutable
  .HashMap[Double, CellTuple]): RDDLabeledPoint =
  {
    try
    {
      val mapForCol: mutable.HashMap[Double, CellTuple] = mutable.HashMap()

      var newRDDArray: ArrayBuffer[LabeledPoint] = ArrayBuffer[LabeledPoint]()



      val newRDD: RDD[(LabeledPoint, Int, String)] = ilp.dataRDD.map
      {
        r =>
          (rddLabeledPointRowOperation(r._1, operation, constants), r._2, r._3)

      }
      new RDDLabeledPoint(newRDD,copyColumnMap,copyTargetMap,ilp.name)
    }
    catch
    {

      case e: Exception =>

        logger.error(s"${ilp.name}")
        throw IKodaMLException(e.getMessage, e)

    }
  }

  private [sparse] def diagnostics(): String =
  {
    try
    {
      val sb: StringBuilder = new mutable.StringBuilder()
      val columnMap: SortedMap[Int, Seq[CellTuple]] = transformColAsRowRddToTreeMap(transformLabeledPointRDDToColumnsRdd)
      if (columnMap.size == ilp.columnHeadMap.size)
      {
        sb.append("\nActual Column Count to Column Map Count: OK")
      }
      else
      {
        sb.append("\nActual Column Count to Column Map Count: FAIL")
        sb.append(s"\n\tColumn Mismatch for Columns: ${ilp.columnHeadMap.keySet.diff(columnMap.keySet).mkString(",")}")
      }

      val targetMap: Map[Double, Int] = soCountRowsByTargetCollected()
      val ftm = targetMap.filter(e => e._2 > 0)
      if (ftm.size == ilp.targetMap.size)
      {
        sb.append("\nActual Target Count to Target Map Count: OK")
      }
      else
      {
        sb.append("\nActual Target Count to Target Map Count: FAIL")
        sb.append(s"\n\tTarget Mismatch for Targets: ${ilp.targetMap.values.toSet.diff(ftm.keySet).mkString(",")}")
      }
      sb.toString()
    }
    catch
    {
      case e: Exception => e.getMessage + "\n"+stackTraceString(e)
    }

  }

  private [sparse] def trimPathSlash(inpath:String): String=
  {
    if(inpath.endsWith("/"))
    {
      inpath.substring(0,inpath.length-1)
    }
    else
    {
      inpath
    }
  }

  @throws(classOf[Exception])
  private [sparse] def printSparseLocally( fileName: String, inpath: String, truncateAt:Int): Unit =
  {
    try
    {

      var newPath:String=trimPathSlash(inpath)
      var pathAndFile:String=s"$newPath${File.separator}${fileName}"

      printLocal(s"${pathAndFile}-targetMap.txt",targetMapAsString())
      printLocal(s"${pathAndFile}-columnMap.txt",columnMapAsString())
      printLocal(s"${pathAndFile}.libsvm",libSVMFileAsString(truncateAt))

      val columnMap=ilp.columnHeadMap
      val data = lpData().collect


    }
    catch
      {
        case e: Exception =>
        {
          logger.error(s"${ilp.name} ${e.getMessage}",e)

          throw new Exception(s"Name: ${ilp.name} Message: ${e.getMessage}", e)
        }
      }

  }





  @throws(classOf[Exception])
  private [sparse] def printSparse( fileName: String, inpath: String,coalesce:Boolean=false): Unit =
  {
    try
    {

      var newPath=trimPathSlash(inpath)


      DataFrameUtils.deletePartition(s"$newPath${File.separator}${
        fileName
      }-targetMap")

      logger.info(s"Saving TargetMap $newPath${File.separator}${fileName}-targetMap")
      val rddout:RDD[String] = spark.sparkContext.parallelize(ilp.targetMap.map(e=> s"${e._1},${e._2}" ).toSeq)
      rddout.saveAsTextFile(s"$newPath${File.separator}${
        fileName
      }-targetMap")


      val addOneToIndex: ListBuffer[ColumnHeadTuple] = ListBuffer();
      ilp.columnHeadMap.values.foreach
      {
        cht => addOneToIndex += ColumnHeadTuple(cht.numericLabel + 1, cht.stringLabel)
      }

      val columnHeadRDD:RDD[String] = spark.sparkContext.parallelize(addOneToIndex.toList.sorted.map(cht=> s"${cht.numericLabel},${cht.stringLabel}"))


      DataFrameUtils.deletePartition(s"$newPath${File.separator}${
        fileName
      }-columnMap")

      logger.info(s"Saving ColumnMap $newPath${File.separator}${fileName}-columnMap")
      columnHeadRDD.saveAsTextFile(s"$newPath${File.separator}${
        fileName
      }-columnMap")


      DataFrameUtils.deletePartition(s"$newPath${File.separator}${
        fileName
      }")

      logger.info(s"Saving data $newPath${File.separator}${fileName}")


      val sparseOut=internalCheckColumnOrder().convertToMLLibPackageRDD()

      /********use df format when upgrade spark************/
      val sparseOuttoprint:RDD[org.apache.spark.mllib.regression.LabeledPoint]=coalesce match
        {

        case true=> sparseOut.coalesce(1)
        case false => sparseOut
      }



      logger.info("Partitons: "+sparseOuttoprint.partitions.size)
      MLUtils.saveAsLibSVMFile(sparseOuttoprint,s"$newPath${File.separator}${fileName}")

    }
    catch
    {
      case e: Exception =>
      {
        logger.error(s"${ilp.name} ${e.getMessage}",e)

        throw new Exception(s"Name: ${ilp.name} Message: ${e.getMessage}", e)
      }
    }

  }


  @throws (classOf[IKodaMLException])
  private [sparse] def validateSparseDataSchemaMatch(sparse1: RDDLabeledPoint):Boolean=
  {
    try
    {
      logger.debug(s"Column Count in sparse0 is ${getColumnCount}")
      logger.debug(s"Column Count in sparse1 is ${sparse1.getColumnCount}")
      require(getColumnCount==sparse1.getColumnCount)

      var  pass:Boolean = false

      var colIndex:Int=sparse1.getColumnCount-4

      logger.debug( s"sparse0: ${getColumnName(colIndex)} \n      " +
        s"sparse1: ${getColumnName(colIndex)} \n      " +
        s"sparse index ${colIndex}")


      if(getColumnName(colIndex)==sparse1.getColumnName(colIndex))
      {
        pass=true
      }
      else
      {
        logger.warn("\n\nassertColumnNamesMatch 1 FAILED\n\n")
        pass=false
      }

      require(pass)



      colIndex=sparse1.getColumnCount/2

      logger.debug( s"sparse0: ${getColumnName(colIndex)} \n      " +
        s"sparse1: ${getColumnName(colIndex)} \n      " +
        s"sparse index ${colIndex}")
      if(getColumnName(colIndex)==sparse1.getColumnName(colIndex))
      {
        pass=true
      }
      else
      {
        logger.warn("\n\nassertColumnNamesMatch 1 FAILED\n\n")
        pass=false
      }

      require(pass)



      colIndex=3
      logger.debug( s"sparse0: ${getColumnName(colIndex)} \n      " +
        s"sparse1: ${getColumnName(colIndex)} \n      " +
        s"sparse index ${colIndex}")
      if(getColumnName(colIndex)==sparse1.getColumnName(colIndex))
      {
        pass=true
      }
      else
      {
        logger.warn("\n\nassertColumnNamesMatch 1 FAILED\n\n")
        pass=false
      }

      if(getTargets().size==sparse1.getTargets().size)
      {
        pass=true
      }
      else {
        logger.warn("\n\ntarget count FAILED\n\n")
        pass = false
      }
      require(pass)
      pass
    }
    catch
      {
        case e:Exception =>
          logger.error(e.getMessage(),e)

          throw new IKodaMLException(e.getMessage,e)
      }
  }

}
