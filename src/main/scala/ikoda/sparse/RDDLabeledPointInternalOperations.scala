package ikoda.sparse

import java.util.UUID

import ikoda.IKodaMLException
import ikoda.utilobjects.UtilFunctions
import ikoda.utils.TicToc
import org.apache.spark
import org.apache.spark.broadcast.Broadcast
import org.apache.spark.ml.feature.LabeledPoint
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.types._
import org.apache.spark.sql.{DataFrame, Row, SparkSession}

import scala.collection.immutable.{ListMap, TreeMap}
import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.collection.{immutable, mutable}
import scala.util.Try

class RDDLabeledPointInternalOperations(ilp:LpData) extends RDDLabeledPointDataLoader(ilp) with UtilFunctions
{


  def doubleDividedByDouble(d1: Double, d2: Double): Double =
  {
    if (d2 == 0)
    {
      0.toDouble
    }
    else
    {
      d1 / d2.toDouble
    }
  }



  @throws(classOf[IKodaMLException])
  private [sparse] def rddLabeledPointColumnOperation(
                                      oneColumnOldValues: Seq[CellTuple], constant: CellTuple,
                                      operation: FTDoubleDouble_Double
                                    ): Seq[CellTuple] =
  {
    try
    {
      val oneColumnNewValues: ArrayBuffer[CellTuple] = ArrayBuffer()
      oneColumnOldValues.foreach
      {
        colCell =>
          if (colCell.colIndex != constant.colIndex)
          {
            throw IKodaMLException(s"column indexes confused !! ${colCell.colIndex}   &   ${constant.colIndex}")
          }
          val newValue = operation(colCell.value, constant.value)
          oneColumnNewValues += CellTuple(colCell.colIndex, colCell.label, newValue, colCell.rowId, colCell.rowPos)
      }
      oneColumnNewValues
    }
    catch
    {

      case e: Exception =>

        logger.error(s"${ilp.name}")
        throw IKodaMLException(e.getMessage, e)

    }
  }




  private [sparse] def castColumnTo(df: DataFrame, cn: String, tpe: DataType): DataFrame =
  {

    df.withColumn(
      cn, df(cn).cast(tpe)

    )
  }





  @throws(classOf[IKodaMLException])
  private [sparse] def rddLabeledPointRowOperation(lp: LabeledPoint, operation: FTDoubleDouble_Double, constants: mutable.HashMap[Double, CellTuple]): LabeledPoint =
  {
    try
    {
      val constantTuple: CellTuple = constants.getOrElse(lp.label, CellTuple(-1, -1, -1, UUID.randomUUID(), -1))
      if (constantTuple.label < 0)
      {
        throw IKodaMLException(s"No label with value ${lp.label} found. Missing rows in constants?")
      }
      else if (constantTuple.label != lp.label)
      {
        throw IKodaMLException(s"Label with value ${lp.label} Does not match label for constant ${constantTuple.label}")
      }


      var valuesArray: ArrayBuffer[Double] = ArrayBuffer[Double]()
      lp.features.toSparse.values.foreach
      {
        v =>
          val newCellValue = operation(v, constantTuple.value)
          valuesArray += newCellValue


      }

      if (lp.features.toSparse.indices.length != valuesArray.length)
      {
        throw IKodaMLException(
          s"original row cellcount  ${lp.features.toSparse.indices.length} does not equal new count ${
            valuesArray
              .length
          }"
        )
      }


      newLabeledPoint(lp.label, lp.features.toSparse.indices, valuesArray.toArray)

    }
    catch
    {

      case e: Exception =>

        logger.error(s"${ilp.name}")
        logger.error(s"${ilp.name} : ${e.getMessage}", e)
        throw IKodaMLException(e.getMessage, e)

    }
  }


  private [sparse]  def internalShiftColumns(index: Int, columnIndexTransformation: mutable.ListBuffer[(Int, ColumnHeadTuple)])
  : mutable.ListBuffer[(Int, ColumnHeadTuple)] =
  {
    val o: Option[(Int, ColumnHeadTuple)] = columnIndexTransformation.find(t => t._2.numericLabel == index)
    val columnIndexTransformationNew: mutable.ListBuffer[(Int, ColumnHeadTuple)] = new ListBuffer
    //logger.trace(s"columnIndexTransformation ${columnIndexTransformation.size}")
    if (o.isDefined)
    {

      columnIndexTransformation -= o.get
    }
    else
    {
      throw IKodaMLException("shiftColumns Column Index not found")
    }
    //logger.trace(s"columnIndexTransformation after removing ${columnIndexTransformation.size}")
    //val sb:StringBuilder=new mutable.StringBuilder()
    columnIndexTransformation.sortBy(_._1).zipWithIndex.foreach
    {
      case (tuple, zipidx) =>


        columnIndexTransformation -= tuple
        //sb.append(s"Old col: ${tuple._1}. New col: ${tuple._1-1}\n")
        columnIndexTransformationNew += new Tuple2[Int, ColumnHeadTuple](zipidx, tuple._2)


    }
    //logger.trace(sb)
    columnIndexTransformationNew
  }




  @throws(classOf[IKodaMLException])
  private [sparse] def internalRemoveColumnHead1(index: Int, colMap:mutable.ListMap[Int,ColumnHeadTuple], failOnError:Boolean): Unit =
  {
    try
    {
      val o: Option[ColumnHeadTuple] = colMap.remove(index)

      if (!o.isDefined)
      {
        failOnError match {
          case true => throw IKodaMLException (s"Could not remove column head with index $index")
          case false => logger.info(s"Of possible concern: Could not remove column head with index $index.")
        }
      }
    }
    catch
    {

      case e: Exception =>
        logger.error(s"${ilp.name}")
        logger.error(s"${ilp.name} : ${e.getMessage}", e)
        throw e;
    }
  }

  @throws(classOf[IKodaMLException])
  private [sparse]  def internalAddColumnHead1(colName: String): mutable.ListMap[Int,ColumnHeadTuple] =
  {
    try
    {
      val newColumnHeadMap=copyColumnMap
      val newColIndex: Int = columnMaxIndex+1
      val cht: ColumnHeadTuple = ColumnHeadTuple(newColIndex, colName)
      if(newColumnHeadMap.get(newColIndex).isEmpty)
      {
        newColumnHeadMap.put(newColIndex, cht)
      }
      else
      {
        throw new IKodaMLException("Column with idx "+newColIndex+" is already defined")
      }
      newColumnHeadMap
    }
    catch
    {
      case e: Exception =>
        logger.error(s"${ilp.name}")
        logger.error(e.getMessage, e)
        throw e;
    }
  }



  private def internalGetMinAndMaxCountForTarget(labelRdd: RDD[(Double, Int)]): ((Int,Double),(Int,Double)) =
  {
    try {
      val sqlContext = spark.sqlContext
      import sqlContext.implicits._


      val labelDf = labelRdd.toDF("l", "c")

      val labelDFSorted: DataFrame = labelDf.sort($"c".desc)
      val rMax: Row = labelDFSorted.first
      var maxCount: Int = rMax.getInt(1)
      val maxLabel: Double = rMax.getDouble(0)
      val rMin: Row = labelDf.sort($"c".asc).first
      var minCount: Int = rMin.getInt(1)
      val minLabel: Double = rMin.getDouble(0)
      ((minCount,minLabel),(maxCount,maxLabel))
    }
    catch
      {
        case e:Exception=>throw IKodaMLException(e.getMessage,e)
      }
  }


  @throws(classOf[IKodaMLException])
  private [sparse] def internalEvenProportionPerTargetBivariate1( labelRdd: RDD[(Double, Int)]): RDDLabeledPoint =
  {
    try
    {



      val tt: TicToc = new TicToc



      logger.debug(tt.tic("internalEvenProportionPerTargetBivariate get min max"))
      val minmax=internalGetMinAndMaxCountForTarget(labelRdd)
      var minCount: Int = minmax._1._1
      val minLabel: Double = minmax._1._2
      var maxCount: Int = minmax._2._1
      val maxLabel: Double = minmax._2._2


      logger.debug(tt.toc("internalEvenProportionPerTargetBivariate get min max"))
      logger.debug(s"Max count is $maxCount. Min count is $minCount.")
      logger.debug(tt.tic("internalEvenProportionPerTargetBivariate get median"))

      val arrList: Array[Int] = labelRdd.flatMap(r => List(r._2)).collect()
      scala.util.Sorting.quickSort(arrList)

      val median: Double = arrList(arrList.length / 2)
      logger.debug(tt.toc("internalEvenProportionPerTargetBivariate get median"))
      logger.debug("median " + median)
      logger.debug(tt.tic("internalEvenProportionPerTargetBivariate even"))

      maxCount > (minCount * 3) match
      {

        case true=>
        val newMaxCount = minCount * 3
        logger.debug(s"New max count is $newMaxCount. ")
        var counter = 0

          val rddlittle=sparseData.filter(r => r._1.label==minLabel )
          val rddbig=sparseData().filter(r => r._1.label==maxLabel).sample(false, newMaxCount, System.nanoTime.toInt)
          val newdata=rddlittle.union(rddbig)






        new RDDLabeledPoint(newdata,copyColumnMap,copyTargetMap,getName())

        case false => new RDDLabeledPoint(ilp)
      }
    }
    catch
    {
      case e: Exception => throw IKodaMLException(e.getMessage, e)
    }
  }



  @throws(classOf[IKodaMLException])
  private [sparse] def validateLabeledPointOperation(
                                     operation: FTDoubleDouble_Double, oldlp: LabeledPoint, newlp: LabeledPoint,
                                     constant: Double
                                   ): Unit =
  {
    try
    {
      if (oldlp.features.toSparse.indices.length == 0)
      {
        logger.warn(s"validateLabeledPointOperation Empty Data")
        return
      }
      var spacing: Int = 1
      if (oldlp.features.toSparse.indices.length > 100)
      {
        spacing = oldlp.features.toSparse.indices.length / 100
      }
      var count = spacing

      //logger.debug(s"LabelledPoint size is ${oldlp.features.toSparse.indices.size}")
      while (count < oldlp.features.toSparse.indices.length)
      {
        if (oldlp.features.toSparse.indices(count) != newlp.features.toSparse.indices(count))
        {
          throw IKodaMLException(
            s"VALIDATION FAILED INPUT INDEX ${
              oldlp.features.toSparse.indices(
                count
              )
            } DOES NOT EQUAL ${newlp.features.toSparse.indices(count)}"
          )

        }
        else
        {
          val validatedResult: Double = operation(oldlp.features.toSparse.values(count), constant)
          if (validatedResult != newlp.features.toSparse.values(count))
          {
            throw IKodaMLException(
              s"VALIDATION FAILED VALIDATED RESULT $validatedResult   ${newlp.features.toSparse.values(count)}"
            )
          }
        }
        count += spacing
      }

    }
    catch
    {

      case e: Exception =>

        logger.error(s"${ilp.name}")
        logger.error(e.getMessage, e)
        throw IKodaMLException(e.getMessage, e)

    }
  }

  private def pRemoveLabelsFromTargetMap(labelsToRemove: Seq[Double]): Map[String,Double]=
  {
    copyTargetMap.filter(label => !labelsToRemove.contains(label._2))
  }

  @throws(classOf[IKodaMLException])
  private [sparse] def internalRemoveRowsByLabels1( labelsToRemove: Seq[Double]): RDDLabeledPoint =
  {
    try
    {
      logger.debug(s"sparseOperationRemoveRowsByLabels RDD started with (estimated) ${rowCountEstimate} rows")
      logger.debug(s"sparseOperationRemoveRowsByLabels Removing labels: ${labelsToRemove.mkString(", ")}")
      val tempRDD: RDD[(LabeledPoint, Int, String)] = ilp.dataRDD.filter(r => !labelsToRemove.contains(r._1.label))

      //val sparse1=internalResetColumnIndices1(tempRDD,copyColumnMap)
      val targetMapNew = getTargets().filter(t => !labelsToRemove.contains(t._2) )
      val sparseOut= new RDDLabeledPoint(tempRDD,copyColumnMap,targetMapNew,getName())

      logger.info(sparseOut.info)
      sparseOut
    }
    catch
      {
        case e: Exception =>
          logger.error(s"${ilp.name}")
          throw IKodaMLException(e.getMessage, e)
      }
  }







  @throws(classOf[IKodaMLException])
  private [sparse] def internalRemoveRowsByHashcode( hashcodesToRemove: Seq[Int]): RDDLabeledPoint =
  {
    try
    {
      logger.debug(s"internalRemoveRowsByHashcode RDD started with (estimated) ${rowCountEstimate} rows")
      logger.debug(s"internalRemoveRowsByHashcode Removing labels: ${hashcodesToRemove.mkString(", ")}")
      val tempRDD: RDD[(LabeledPoint, Int, String)] = ilp.dataRDD.filter(r => !hashcodesToRemove.contains(r._2))


      val sparseOut= new RDDLabeledPoint(tempRDD,copyColumnMap,copyTargetMap,getName())
      logger.debug(s"internalRemoveRowsByHashcode RDD ended with (estimated) ${sparseOut.rowCountEstimate} rows")

      logger.info(sparseOut.info)
      sparseOut
    }
    catch
      {
        case e: Exception =>
          logger.error(s"${ilp.name}")
          throw IKodaMLException(e.getMessage, e)
      }
  }

  private def validateColumnRDD(newColRdd:RDD[(Int,Seq[CellTuple])])
  {
    try
    {
      /////validation
      val tt: TicToc = new TicToc
      logger.debug(tt.tic("validateColumnRDD"))
      newColRdd.take(50).foreach
      {
        case (col, seqct) => seqct.foreach
          {
            ct=> if(ct.colIndex != col)
              {
                logger.error(s"Column Mismatch on column $col and cell ${ct.colIndex} with label ${ct.label}")
                logger.error(ct.toString)
                throw new IKodaMLException(s"Column Mismatch on column $col and cell ${ct.colIndex} with label ${ct.label}" )

              }
          }
      }
      logger.debug("PASSED: validateColumnRDD")
      logger.debug(tt.toc("validateColumnRDD"))
    }
    catch
      {
        case e:Exception => throw new IKodaMLException(e.getMessage,e)
      }
  }



  @throws(classOf[IKodaMLException])
  private [sparse]   def internalResetColumnIndices2(): RDDLabeledPoint =
  {
    internalResetColumnIndices2(sparseData(),ilp.columnHeadMap)
  }


  @throws(classOf[IKodaMLException])
  private [sparse]   def internalResetColumnIndices2( incomingData:RDD[(LabeledPoint,Int,String)], incomingColMap:mutable.ListMap[Int,ColumnHeadTuple]): RDDLabeledPoint =
  {
    val tt: TicToc = new TicToc
    logger.info(tt.tic("internalResetColumnIndices2"))

    val sortedColumnHeads=ListMap(incomingColMap.toSeq.sortBy(_._2.stringLabel):_*)

    val oldnewcolmap:Map[Int,Int]=sortedColumnHeads.map
    {
      r => r._2
    }.zipWithIndex.map
    {
      case(cht,zidx) => (cht.numericLabel,zidx)
    }.toMap

    val oldnewcolmapb:Broadcast[Map[Int,Int]] = spark.sparkContext.broadcast(oldnewcolmap)

    logger.info(tt.tic("rebuilding column map"))

    val newRowRDD:RDD[(LabeledPoint,Int,String)] = incomingData.map
    {
      r=>
        val featureMap:mutable.HashMap[Int,Double] = new mutable.HashMap[Int,Double]()
        r._1.features.toSparse.indices.zipWithIndex.map
        {
          case (idx,z) => featureMap.put(oldnewcolmapb.value.get(idx).get,r._1.features.toSparse.values(z))
        }
        val alignedSorted = scala.collection.immutable.TreeMap(featureMap.toArray: _*)
        val newlp=newLabeledPoint(r._1.label, alignedSorted.keySet.toArray, alignedSorted.values.toArray)
        (newlp,r._2,r._3)
    }

    logger.info(tt.toc("rebuilding column map"))

    logger.info(tt.tic("rebuilding column heads"))
    val newColHeads:Map[Int,ColumnHeadTuple]=oldnewcolmap.map
    {
      case (old,newc) =>
        val colNameo=incomingColMap.get(old)
        colNameo.isDefined match
        {
          case true=>  (newc, new ColumnHeadTuple(newc,colNameo.get.stringLabel))
          case false => throw new IKodaMLException(s"Column head not found for original index of $old")
        }

    }.toMap

    logger.info(tt.toc("rebuilding column heads"))
    val newcolmap= mutable.ListMap(newColHeads.toSeq:_*)

    logger.info(tt.toc("internalResetColumnIndices2"))
    new RDDLabeledPoint(newRowRDD,newcolmap,copyTargetMap,ilp.name)
  }



  private def pReorderLabeledPoint(lp:LabeledPoint): LabeledPoint =
  {
    val aligned: Map[Int, Double] =
      lp.features.toSparse.indices.zipWithIndex.map
      {
        case (idx,z)=> (idx, lp.features.toSparse.values(z))
      }.toMap
    val alignedSorted = scala.collection.immutable.TreeMap(aligned.toArray: _*)
    newLabeledPoint(lp.label, alignedSorted.keySet.toArray, alignedSorted.values.toArray)
  }

  @throws(classOf[IKodaMLException])
  private [sparse]   def internalCheckColumnOrder(): RDDLabeledPoint =
  {
    var rddOut:RDD[(LabeledPoint,Int,String)]=sparseData().map
    {
      r=>
        var lastidx=0
        var pass=true
        r._1.features.toSparse.indices.zipWithIndex.map
        {

          case(idx,z)=>
            if(idx <= lastidx)
              {
                   pass=false
              }
            lastidx=idx
        }
        pass match
          {
          case true => (r._1,r._2,r._3)
          case false => (pReorderLabeledPoint(r._1),r._2,r._3)
        }
    }
    new RDDLabeledPoint(rddOut,copyColumnMap,copyTargetMap,getName())
  }


  @throws(classOf[IKodaMLException])
  private [sparse] def internalSubsetColumnIndices1(
                                   lpByLabel: RDD[(LabeledPoint, Int, String)], newColumnHead: mutable.ListMap[Int,
    ColumnHeadTuple], oldNewColumnHeads: mutable.HashMap[Int, Int]
                                 ): RDD[(LabeledPoint, Int, String)] =
  {
    try
    {
      lpByLabel.map
      {
        r =>

          val newIdxArray: ListBuffer[Int] = new ListBuffer[Int]
          r._1.features.toSparse.indices.foreach
          {
            idx =>
              val newidxO: Option[Int] = oldNewColumnHeads.get(idx)
              if (newidxO.isDefined)
              {
                newIdxArray += newidxO.get
              }
              else
              {
                throw IKodaMLException(s"internalSubsetColumnIndices Original column index not found at idx $idx")
              }

          }
          (newLabeledPoint(r._1.label, newIdxArray.toArray, r._1.features.toSparse.values),
            r._2,
            r._3
          )
      }
    }
    catch
    {
      case e: Exception => throw IKodaMLException(e.getMessage, e)
    }
  }


  @throws(classOf[IKodaMLException])
  private [sparse] def internalSubsetColumnHeads(lpByLabelArray: Array[LabeledPoint]): (mutable.ListMap[Int, ColumnHeadTuple], mutable.HashMap[Int, Int]) =
  {
    try
    {
      val newColumnHead: mutable.ListMap[Int, ColumnHeadTuple] = new mutable.ListMap()
      val oldNewColumnHeads: mutable.HashMap[Int, Int] = new mutable.HashMap()
      var colCount: Int = 0
      lpByLabelArray.foreach
      {
        lp =>
          lp.features.toSparse.indices.foreach
          {
            idx =>
              val oldChtO: Option[ColumnHeadTuple] = ilp.columnHeadMap.get(idx)
              if (oldChtO.isDefined)
              {
                val newidxO: Option[Int] = oldNewColumnHeads.get(idx)
                if (newidxO.isEmpty)
                {
                  oldNewColumnHeads.put(idx, colCount)
                  val newcht = ColumnHeadTuple(colCount, oldChtO.get.stringLabel)
                  newColumnHead.put(colCount, newcht)
                  colCount = colCount + 1
                }
              }
              else
              {
                throw IKodaMLException(s"internalSubsetColumns Original columnHead not found at idx $idx")
              }
          }
      }
      Tuple2(newColumnHead, oldNewColumnHeads)
    }
    catch
    {
      case e: Exception => throw IKodaMLException(e.getMessage, e)
    }
  }

  @throws(classOf[IKodaMLException])
  private def pproportionForReduction(labelsToReduceArray: Array[(Double, Int)],median:Double): Map[Double, Double] =
  {
    try
    {
      labelsToReduceArray.map
      {
        case (label, count) =>
          var proportionToRemove: Double = (median.toDouble / count.toDouble) * 10
          if (proportionToRemove < 1)
          {
            proportionToRemove = 1
          }

          logger.info(
            s"${getTargetName(label)} - $label with proportionToRemove of $proportionToRemove from total of $count"
          )
          new Tuple2[Double, Double](label, proportionToRemove)
      }.toMap
    }
    catch
      {
        case e:Exception=>throw new IKodaMLException(e.getMessage,e )
      }
  }

  @throws(classOf[IKodaMLException])
  private def preduceParts(proportionForReductionByLabel: Map[Double, Double],labelRdd: Array[(Double, Int)] ): Array[Array[(LabeledPoint, Int, String)]] =
  {
    try
    {
      labelRdd.map
      {
        kv =>
          val targetToReduceO: Option[Double] = proportionForReductionByLabel.get(kv._1)

          val lpByLabelrdd: RDD[(LabeledPoint, Int, String)] = ilp.dataRDD.filter(r => r._1.label == kv._1)

          if (targetToReduceO.isDefined)
          {
            val splits = lpByLabelrdd.randomSplit(Array(targetToReduceO.get.toInt, 10 - targetToReduceO.get.toInt))
            splits(0).collect
          }
          else
          {
            lpByLabelrdd.collect
          }
      }
    }
    catch
    {
      case e:Exception=>throw new IKodaMLException(e.getMessage,e )
    }
  }

  @throws(classOf[IKodaMLException])
  private def pRemoveUnreferencedColumnHeads(extantColumnsInRdd:Set[Int]): mutable.ListMap[Int,ColumnHeadTuple] =
  {
    val seq=(ilp.columnHeadMap.filter(r=> extantColumnsInRdd.contains(r._1))).toSeq
    mutable.ListMap(seq:_*)
  }

  @throws(classOf[IKodaMLException])
  private [sparse]  def internalEvenProportionPerTargetMultivariate1(labelArray: Array[(Double, Int)]): RDDLabeledPoint =
  {
    try
    {
      logger.debug("internalEvenProportionPerTargetMultivariate")
      val arrList: Array[Int] = labelArray.flatMap(r => List(r._2))
      scala.util.Sorting.quickSort(arrList)
      val median: Double = arrList(arrList.length / 2)

      val labelsToReduceRdd: Array[(Double, Int)] = labelArray.filter(kv => kv._2 > median)


      logger.debug(s"MEDIAN = $median")


      val proportionForReductionByLabel: Map[Double, Double] = pproportionForReduction(labelsToReduceRdd,median)

      logger.debug(s"proportionForReductionByLabel ${proportionForReductionByLabel.mkString("\n")}")

      val reducedpartsRDDList: Array[Array[(LabeledPoint, Int, String)]] = preduceParts(proportionForReductionByLabel,labelArray)

      val newArray:Array[(LabeledPoint, Int, String)]=reducedpartsRDDList.length > 1 match {
        case true =>reducedpartsRDDList.tail.foldLeft (reducedpartsRDDList.head) { (e1, e2) => e1 ++ e2}
        case false=>
          logger.warn(s"\n\n!Nothing to do. ${reducedpartsRDDList.length} in reducedpartsRDDList!\n\n")
          sparseData().collect()
      }
      logger.info("")

      //val sparseOut:RDDLabeledPoint=internalResetColumnIndices1(spark.sparkContext.parallelize(newArray),copyColumnMap)
      new RDDLabeledPoint(spark.sparkContext.parallelize(newArray),copyColumnMap,copyTargetMap,getName())

    }
    catch
    {
      case e: Exception => throw IKodaMLException(e.getMessage, e)
    }
  }

  @throws(classOf[IKodaMLException])
  private def pValidateBeforeRemoval(originalColumnCount:Int): Unit =
  {
    try
    {
      val originalColumnHeadCount = ilp.columnHeadMap.size

      logger.info(
        s"${ilp.name} \n\n originalColumnCount =${originalColumnCount+columnCountOffset} originalColumnHeadCount $originalColumnHeadCount"
      )
      logger.info("column offset "+columnCountOffset)
      logger.info("originalColumnCount "+ originalColumnCount)
      if((originalColumnCount+columnCountOffset) != originalColumnHeadCount)
      {
        validateColumnCount()
      }
      require((originalColumnCount+columnCountOffset) == originalColumnHeadCount)
    }
    catch
      {
        case e:Exception => throw new IKodaMLException(e.getMessage,e)
      }
  }


  @throws(classOf[IKodaMLException])
  private def pValidateAfterRemoval(finalColumnHeadMap:mutable.ListMap[Int,ColumnHeadTuple],finalColumnMap:mutable.ListMap[Int,Seq[CellTuple]] ): Unit =
  {
    try
    {
      if ((finalColumnMap.size+columnCountOffset) != finalColumnHeadMap.size) {
        throw IKodaMLException(
          s"Column Head to Column mismatch after removal. Column Head Map count: ${finalColumnHeadMap.size}.  Actual columns" +
            s" count: ${finalColumnMap.size}"
        )
      }

      val validationError: Array[LabeledPoint] = lpData.filter(lp=>lp.features.toSparse.indices.length > 0).filter(lp => lp.features.toSparse.indices.min < 0).collect()
      if (validationError.size > 0) {
        throw IKodaMLException(
          s"Column index is less than zero. Columns are: ${validationError(0).features.toSparse.indices.mkString(",")}.  Actual columns" +
            s" count: ${finalColumnMap.size}"
        )
      }
    }
    catch
      {
        case e:Exception => throw new IKodaMLException(e.getMessage,e)
      }
  }

  @throws(classOf[IKodaMLException])
  private def pRemoveColumns (mutableColumnMap: mutable.ListMap[Int, Seq[CellTuple]],tempColumnHeadMap:mutable.ListMap[Int,ColumnHeadTuple],sortedQ: mutable.Queue[Int]): Unit =
  {
    try
    {
      //logger.debug(tempColumnHeadMap.mkString("    |    "))
      //logger.debug(mutableColumnMap.keySet.mkString("   +    "))


      while (sortedQ.nonEmpty)
      {
        val index = sortedQ.dequeue()
        if(index >=0) {


          internalRemoveColumnHead1(index, tempColumnHeadMap,true)
          internalRemoveColumn(index, mutableColumnMap)
        }
      }
    }
    catch
      {
        case e:Exception => throw new IKodaMLException(e.getMessage,e)
      }
  }

  protected def pResetCellTupleSeqColIdx(cellTupSeq:Seq[CellTuple],newidx:Int, oldidx:Int): Seq[CellTuple] =
  {
    cellTupSeq.map{

      ct=>
        require(ct.colIndex==oldidx)
        new CellTuple(newidx,ct.label,ct.value,ct.rowId,ct.rowPos)
    }
  }


  @throws(classOf[IKodaMLException])
  private [sparse] def internalRemoveColumns1( columnIndices: mutable.Queue[Int], validateColumns:Boolean=false): RDDLabeledPoint =
  {
    try {

      var sortedQ: mutable.Queue[Int] = columnIndices.filter(idx => idx >=0).sorted
      val tempColumnHeadMap:mutable.ListMap[Int,ColumnHeadTuple]=copyColumnMap


      val columnMap: immutable.SortedMap[Int, Seq[CellTuple]] = transformColAsRowRddToTreeMap(transformLabeledPointRDDToColumnsRdd())
      val originalColumnCount = columnMap.size
      val originalQueueSize = sortedQ.length


      if(validateColumns) {
        pValidateBeforeRemoval(originalColumnCount)
      }


      var mutableColumnMap: mutable.ListMap[Int, Seq[CellTuple]] = mutable.ListMap[Int, Seq[CellTuple]](
        columnMap.toSeq.sortWith(_._1 < _._1):_*
      )

      logger.debug("converted to mutableColumnMap ")

      pRemoveColumns(mutableColumnMap,tempColumnHeadMap,sortedQ)

      logger.debug("removed columns")

      if (mutableColumnMap.size != (originalColumnCount - originalQueueSize)) {
        throw IKodaMLException(
          s"Column count mismatch after removal. Is ${mutableColumnMap.size}.  Expected ${
            originalColumnCount -
              originalQueueSize
          }"
        )
      }
      val maxColIdx=tempColumnHeadMap.keySet.max+1
      val data = transformColumnsMapToLabeledPointRDD(spark, mutableColumnMap.toMap,  allowRowCountChange = true, maxColumnIdxo=Some(maxColIdx))

      logger.debug(s"Original Column Count was $originalColumnCount")
      logger.debug(s"Offset is $columnCountOffset")
      logger.debug(s"New Column Count is ${mutableColumnMap.size}")
      logger.trace(s"mutableColumnMap size ${mutableColumnMap.size}")
      logger.trace(s"ColumnHeadMap size ${ilp.columnHeadMap.size}")

      if(validateColumns) {
        pValidateAfterRemoval(tempColumnHeadMap, mutableColumnMap)
      }
      val sparseOut=new RDDLabeledPoint(data, tempColumnHeadMap, copyTargetMap, ilp.name)
      sparseOut.columnCountOffset=columnCountOffset
      sparseOut
    }
    catch
      {
        case e:Exception =>
          logger.error(e.getMessage,e)
          throw new IKodaMLException(e.getMessage,e)
      }
  }


  @throws(classOf[IKodaMLException])
  private [sparse] def internalRemoveColumns2( columnIndices: Set[Int],failOnError:Boolean=true): RDDLabeledPoint =
  {
    try {
      val tt = new TicToc
      logger.info(tt.tic("\n\n----------------\nRemoving Columns Distributed\n\n----------------\n"))
      tt.tic("internalRemoveColumns2")
      logger.debug(info)

      pRemoveUnreferencedColumnHeads(columnsFromDataRDD)

      val tempColumnHeadMap:mutable.ListMap[Int,ColumnHeadTuple]=pRemoveUnreferencedColumnHeads(columnsFromDataRDD)
      val columnRDD: RDD[(Int, Seq[CellTuple])] = transformLabeledPointRDDToColumnsRdd()
      val rddOut=columnRDD.filter(r => !columnIndices.contains(r._1))



      columnIndices.foreach(idx=> internalRemoveColumnHead1(idx,tempColumnHeadMap,failOnError))


      logger.debug("removed columns")


      val data = transformColumnsRddToLabeledPointRDD1(spark, rddOut,  allowRowCountChange = true)

      val sparseOut=new RDDLabeledPoint(data, tempColumnHeadMap, copyTargetMap, ilp.name)
      sparseOut.columnCountOffset=columnCountOffset

      val ccrdd=sparseOut.columnCountFromDataRDD()
      val ccchm=tempColumnHeadMap.size

      logger.info("Column count from RDD: "+ccrdd)
      logger.info("Column head count: "+ccchm)
      logger.info(sparseOut.info)
      require(ccrdd == (ccchm + columnCountOffset))
        logger.info(tt.toc("internalRemoveColumns2"))
      logger.info("\n\n----------------\nRemoving Columns Done\n\n----------------\n")

      sparseOut
    }
    catch
      {
        case e:Exception =>
          logger.error(e.getMessage,e)
          throw new IKodaMLException(e.getMessage,e)
      }

  }


  protected def plowerCaseColumnHeads:RDDLabeledPoint=
    {
          val newcolmap=ilp.columnHeadMap.map
          {
            e1 => (e1._1 -> new ColumnHeadTuple(e1._1, e1._2.stringLabel.toLowerCase.replaceAll("[^a-zA-Z0-9-_]", "")))
          }
      new RDDLabeledPoint(ilp.dataRDD,newcolmap,copyTargetMap,ilp.name)
    }

  @throws(classOf[IKodaMLException])
  private [sparse] def cleanLowerCaseColumns1(): RDDLabeledPoint =
  {
    try
    {
      val tempmap: mutable.HashMap[String, ColumnHeadTuple] = new mutable.HashMap[String, ColumnHeadTuple]()
      val q: mutable.Queue[Int] = new mutable.Queue[Int]()
      ilp.columnHeadMap.foreach
      {
        e =>
          val ov = tempmap.get(e._2.stringLabel.toLowerCase().replaceAll("[^a-zA-Z0-9-_]", ""))
          ov.isDefined match
          {
            case true =>
              //logger.debug("Removing " + e._2.stringLabel)
              q += e._1
            case _ =>

              tempmap.put(e._2.stringLabel.toLowerCase().replaceAll("[^a-zA-Z0-9-_]", ""), e._2)
          }
      }

      logger.info("cleanLowerCaseColumns Removing " + q.size + " columns")
      q.size match {
        case x if (x>0)=>internalRemoveColumns1 (q).plowerCaseColumnHeads
        case _ => this.plowerCaseColumnHeads
      }


    }
    catch
    {
      case e: Exception =>throw new IKodaMLException(e.getMessage, e)
    }
  }




  @throws(classOf[IKodaMLException])
  def dummyRow()
  : Option[RDDLabeledPoint] =
  {
    try
    {

      val labeledPointArrayBuffer: ArrayBuffer[(LabeledPoint, Int, String)] = new ArrayBuffer[(LabeledPoint, Int,
        String)]()
      val other = "OTHER"

      val colArray: Array[Int] = Array(1, 2)
      val valArray: Array[Double] = Array(1.0, 1.0)
      val label: Double = 1.0
      val lp = new LabeledPoint(label, org.apache.spark.ml.linalg.Vectors.sparse(
        2, colArray, valArray))
      val uuid: String = UUID.randomUUID().toString
      val row: Array[Tuple3[LabeledPoint, Int, String]] = Array(Tuple3(lp, lp.hashCode(), uuid))
      val datadict = immutable.HashMap[String, Double]("xxdummyxx" -> 1.0)
      val columnHeadMap = copyColumnMap

      val dataRDD = spark.sparkContext.parallelize(row)
      val newRDDLP:RDDLabeledPoint = new RDDLabeledPoint(dataRDD,columnHeadMap,datadict,ilp.name)


      Option(newRDDLP)


    }
    catch
    {
      case e: Exception =>
      {
        logger.error(s"${ilp.name}", e)
        throw IKodaMLException(s"${ilp.name} : ${e.getMessage}", e)
      }
    }
  }



  @throws(classOf[IKodaMLException])
  private [sparse] def internalRemoveColumn( index: Int, columnMap: mutable.ListMap[Int, Seq[CellTuple]]): Unit =
  {
    try
    {
      if (index > -1)
      {
        val oRemoved: Option[Seq[CellTuple]] = columnMap.remove(index)
        if (!oRemoved.isDefined)
        {
          throw IKodaMLException(s"Could not remove column with index $index")
        }
      }
      else
      {
        throw IKodaMLException(s"Column Index $index cannot exist")
      }
    }
    catch
    {
      case e: Exception =>
        logger.error(s"Error while trying to remove ${index} which is registered in columnHeadMap as ${Try(ilp.columnHeadMap.get(index))}")
        logger.error(s"${ilp.name}")
        logger.error(e.getMessage, e)
        throw e;
    }
  }



  private [sparse] def containsDecimalPlaces(rows:Int): Boolean =
  {


    val tfsq:Seq[Boolean] =ilp.dataRDD.take(rows).flatMap
    {
      r=> val tfseq:Seq[Boolean]=r._1.features.toSparse.values.map(v=>v % 1 == 0)

        tfseq
    }

    tfsq.contains(false) match
    {
      case true => true
      case _ =>false
    }

  }

  private def formatOutput(truncateAt:Int):Boolean=
  {
    truncateAt >0 match
      {
      case true => containsDecimalPlaces(10)


      case false => false
    }
  }

  private [sparse] def libSVMFileAsString(truncateAt:Int):String= {

    val sparse0=internalCheckColumnOrder()
    val dp:String=s"%1.${truncateAt}f"
    logger.debug(dp)

    val rows:Array[String]= formatOutput(truncateAt) match
      {
      case true=>

        def truncateValue(value:Double):String=
        {
            dp.format(value)
        }


        sparse0.lpData().map { case LabeledPoint(label, features) =>
          val sb = new StringBuilder(label.toString)
          features.foreachActive { case (i, v) =>
            sb += ' '
            sb ++= s"${i + 1}:"+truncateValue(v)
          }
          sb.mkString
        }.collect()
      case false =>
        sparse0.lpData().map { case LabeledPoint(label, features) =>
          val sb = new StringBuilder(label.toString)
          features.foreachActive { case (i, v) =>
            sb += ' '
            sb ++= s"${i + 1}:$v"
          }
          sb.mkString
        }.collect()
    }



    val sbOut:mutable.StringBuilder=new mutable.StringBuilder()
    rows.foreach(r=>sbOut.append(r + "\n"))
    sbOut.toString()
  }


  /**
    * A csv format String textValue/numericValue
    * @group dp
    * @return
    */
  def targetMapAsString(): String =
  {
    try {
      val targetMap = ilp.targetMap
      val sb:StringBuilder=new mutable.StringBuilder()
      targetMap.foreach
      {
        e=>
          sb.append(e._1)
          sb.append(",")
          sb.append(e._2)
          sb.append("\n")


      }
      sb.toString()

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


  /**
    * Returns csv numericLabel,testLabel
    * @group dp
    * @param offset
    * @return
    */
  def columnMapAsString(offset:Int=1): String =
  {
    try {

      val colMap:ListMap[Int,ColumnHeadTuple] = ListMap(ilp.columnHeadMap.toSeq.sortBy(_._1):_*)

      val sb:StringBuilder=new mutable.StringBuilder()
      colMap.foreach
      {
        case (idx,cht)=>
          sb.append(cht.numericLabel+offset)
          sb.append(",")
          sb.append(cht.stringLabel)
          sb.append("\n")


      }
      sb.toString()

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

  private[sparse] def computeNumFeatures(idxArray: Array[Array[Int]]): Int = {
    idxArray.map { indices =>
      indices.length >0 match {
        case true => indices.max
        case false =>0
      }
    }.reduce(math.max) + 1
  }
}
