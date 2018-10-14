package ikoda.sparse

import java.util.UUID

import ikoda.IKodaMLException
import ikoda.utilobjects.DataFrameUtils
import ikoda.utils.{LabelValuesTuple, LibSvmProcessor, TicToc}
import org.apache.spark.ml.feature.LabeledPoint
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.types._
import org.apache.spark.sql.{DataFrame, Row, SparkSession}

import scala.collection.JavaConverters._
import scala.collection.immutable.{ListMap, SortedMap, TreeMap}
import scala.collection.mutable.{ArrayBuffer, HashMap, ListBuffer}
import scala.collection.{breakOut, immutable, mutable}

/**
  * @groupname dp Data Attributes
  * @groupname load Loading and Saving
  * @groupname cpt Data Computation
  * @groupname man Data Manipulation
  *
  *
  * @param ilp
  */
class RDDLabeledPointTransformations(ilp:LpData) extends RDDLabeledPointParent(ilp)
{

  /**
    *
    * @param colIndices
    * @param colValues
    * @throws ikoda.IKodaMLException
    * @return
    */
  @throws(classOf[IKodaMLException])
  private [sparse] def internalSortColumns(colIndices:Seq[Int],colValues:Seq[Double]): Tuple2[Seq[Int],Seq[Double]] =
  {
    try
    {
      val asMap:Map[Int,Double]=colIndices.zipWithIndex.map
      {
        case (colIdx, posIdx) =>
        {
          (colIdx,colValues(posIdx))
        }
      }.toMap

      val alignedSorted:TreeMap[Int,Double] = scala.collection.immutable.TreeMap(asMap.toArray:_*)
      Tuple2(alignedSorted.keySet.toSeq,alignedSorted.values.toSeq)
    }
    catch
      {
        case e:Exception => throw new IKodaMLException(e.getMessage,e)
      }
  }

  private [sparse] def internalSortColumns(lp: LabeledPoint):Option[LabeledPoint] = {
    try {
      val aligned: Map[Int, Double] =
        lp.features.toSparse.indices.zipWithIndex.map {
          case (colidx, zidx) =>
            colidx -> lp.features.toSparse.values(zidx)
        }.toMap

      val alignedSorted = scala.collection.immutable.TreeMap(aligned.toArray: _*)

      alignedSorted.size == lp.features.toSparse.values.length match {
        case true => Some(newLabeledPoint(lp.label,alignedSorted.keySet.toArray, alignedSorted.values.toArray))
        case false =>
          logger.warn("\n\nWARN: Column <-> Value Mismatch\nColumns: " + alignedSorted.size + "\nValues: " + lp.features.toSparse.values.length)
          None
      }
    }
    catch {
      case e: Exception => throw IKodaMLException(e.getMessage, e)
    }
  }

  private [sparse] def newLabeledPoint(label:Double, indices:Array[Int], values:Array[Double]): LabeledPoint =
  {
    new LabeledPoint(label,org.apache.spark.ml.linalg.Vectors.sparse(columnMaxIndex+1,indices,values))
  }

  private [sparse] def newLabeledPoint(label:Double,  featureCount:Int,indices:Array[Int], values:Array[Double]): LabeledPoint =
  {
    new LabeledPoint(label,org.apache.spark.ml.linalg.Vectors.sparse(featureCount,indices,values))
  }

  /**
    * @group man
    * @return
    */
  def transformRDDToDataFrame(): DataFrame =
  {
    val sqlContext = spark.sqlContext
    import sqlContext.implicits._
    lpData().map(lp=>(lp.label,lp.features))toDF("label", "features")
  }


  @throws(classOf[IKodaMLException])
  private [sparse] def transformColumnsMapToLabeledPointRDD(
                                          spark: SparkSession,
                                          columnsMap: Map[Int, Seq[CellTuple]],
                                          oldNewColumnIndexMap: Map[Int, Int] = HashMap[Int, Int]().toMap,
                                          allowRowCountChange: Boolean,
                                          maxColumnIdxo:Option[Int] = None
                                        ): RDD[(LabeledPoint,Int,String)] =
  {

    try
    {

      logger.debug("max column o"+maxColumnIdxo)
      val maxColumnIdx = maxColumnIdxo.isDefined match
      {
        case true =>
          logger.debug("max column set to "+maxColumnIdxo.get)
          maxColumnIdxo.get

        case false => columnMaxIndex
      }

      val newRowsMap: mutable.HashMap[UUID, mutable.HashMap[Int, CellTuple]] = transformColumnMapToRowMap(
        columnsMap, oldNewColumnIndexMap, allowRowCountChange
      )

      logger.debug(columnsMap.keySet.mkString(", "))
      val dataArray: Array[(LabeledPoint, Int, String)] = newRowsMap.map
      {
        row =>
          val indices: ListBuffer[Int] = ListBuffer()
          val label: Double = row._2.toList.head._2.label
          val uuid: UUID = row._2.toList.head._2.rowId
          val values: ListBuffer[Double] = ListBuffer()
          val rowValues: mutable.HashMap[Int, CellTuple] = row._2
          val sortedMap: immutable.TreeMap[Int, CellTuple] = immutable.TreeMap(rowValues.toSeq: _*)

          sortedMap.toArray.foreach
          {
            cellTuple =>
              indices += cellTuple._2.colIndex
              values += cellTuple._2.value
              if (cellTuple._2.colIndex != cellTuple._1)
              {
                throw IKodaMLException(
                  s"colIndex of celltuple ${cellTuple._2.colIndex} does not match index of row hashmap ${cellTuple._1}"
                )
              }
              if (cellTuple._2.label != label)
              {
                throw IKodaMLException(
                  s"label of celltuple ${cellTuple._2.label} does not match label of exemplar $label"
                )
              }
          }
          val lp: LabeledPoint = newLabeledPoint(label, maxColumnIdx, indices.toArray, values.toArray)


          (lp, lp.hashCode(), uuid.toString)

      }.toArray
      spark.sparkContext.parallelize(dataArray)

    }
    catch
    {
      case e: Exception =>

        logger.error(s"${ilp.name}")

        throw e

    }
  }




  @throws(classOf[IKodaMLException])
  private [sparse] def transformColumnMapToRowMap(
                                columnsMap: Map[Int, Seq[CellTuple]],
                                oldNewColumnIndexMap: Map[Int, Int] = mutable.HashMap[Int, Int]().toMap,
                                allowRowCountChange: Boolean = false
                              ): mutable.HashMap[UUID, mutable.HashMap[Int, CellTuple]] =
  {
    try
    {


      val newRowsMap: mutable.HashMap[UUID, mutable.HashMap[Int, CellTuple]] = mutable.HashMap()
      val originalRDDsize: Long = ilp.dataRDD.count()
      columnsMap.keys.foreach
      {
        key =>
          val cellTupleByColumnSeq: Seq[CellTuple] = columnsMap.getOrElse(key, ArrayBuffer())
          if (cellTupleByColumnSeq.isEmpty)
          {
            throw IKodaMLException(s"No column found with index $key")
          }
          val sortedCellTupleByColumnSeq = cellTupleByColumnSeq.sorted
          sortedCellTupleByColumnSeq.foreach
          {
            cell =>
              var columnIndex: Int = cell.colIndex
              require(key == cell.colIndex)
              if (oldNewColumnIndexMap.nonEmpty)
              {
                columnIndex = getOptionValueOrThrowException(oldNewColumnIndexMap.get(columnIndex))
                val ct = CellTuple(columnIndex, cell.label, cell.value, cell.rowId, cell.rowPos)
                newRowsMap.getOrElseUpdate(cell.rowId, new mutable.HashMap[Int, CellTuple]()).put(columnIndex, ct)
              }
              else
              {
                newRowsMap.getOrElseUpdate(cell.rowId, new mutable.HashMap[Int, CellTuple]()).put(columnIndex, cell)
              }


          }

      }


      if (newRowsMap.size != originalRDDsize)
      {
        if (allowRowCountChange)
        {
          logger.warn(s"Row size change. Was $originalRDDsize, but now ${newRowsMap.size}")
        }
        else
        {
          throw IKodaMLException(s"Row size mismatch. Was $originalRDDsize, but now ${newRowsMap.size}")
        }
      }
      newRowsMap
    }
    catch
    {

      case e: Exception =>

        logger.error(s"${ilp.name}")
        throw IKodaMLException(s"${ilp.name} : ${e.getMessage}", e)

    }
  }




  @throws(classOf[IKodaMLException])
  private [sparse] def transformColumnsRddToLabeledPointRDD1(
                                          spark: SparkSession,
                                          columnsRDD: RDD[(Int, Seq[CellTuple])],
                                          oldNewColumnIndexMap: Map[Int, Int]= HashMap[Int, Int]().toMap,
                                          allowRowCountChange: Boolean = false
                                        ): RDD[(LabeledPoint,Int,String)] =
  {

    try
    {

      val maxCol:Int = columnsRDD.map(r=>r._1).sum().toInt +1

      val rdd1:RDD[(UUID, CellTuple)]= columnsRDD.flatMap
      {
        case(colId, seqCellTuple) =>
          if(oldNewColumnIndexMap.nonEmpty)
          {
            val columnIndex = getOptionValueOrThrowException(oldNewColumnIndexMap.get(colId))
            seqCellTuple.map(ct => (ct.rowId, new CellTuple(columnIndex,ct.label,ct.value,ct.rowId,-1)))
          }
          else
          {
            seqCellTuple.map(ct => (ct.rowId, ct))
          }
      }

      val rdd2:RDD[(UUID,Seq[CellTuple])]=rdd1.groupBy(e =>e._1).map(e=>(e._1,e._2.map(f => f._2).toSeq))

      rdd2.map
      {
        case e=>

          val map= TreeMap[Int,Double](e._2.map(ct => (ct.colIndex, ct.value)):_*)
          val idxArray:Array[Int] = map.keySet.toSeq.toArray
          val valArray:Array[Double] = map.values.toSeq.toArray
          val lp=newLabeledPoint(e._2(0).label, idxArray, valArray)
          (lp,lp.hashCode(),e._1.toString)
      }
    }
    catch
    {
      case e: Exception =>

        logger.error(s"${ilp.name}")

        throw e

    }
  }



  @throws(classOf[IKodaMLException])
  private def transformColumnsToThisSchema(newColumnHeadMap:mutable.ListMap[Int,ColumnHeadTuple], sparseToConvert:RDDLabeledPoint): mutable.HashMap[Int,Int] = {
    try {
      logger.debug("transformColumnsToThisSchema 1")
      val thisMap: Map[String, Int] = newColumnHeadMap.map
      {
        col=> col._2.stringLabel -> col._2.numericLabel
      }.toMap
      logger.debug("transformColumnsToThisSchema 2")
      val thatThisMap:mutable.HashMap[Int,Int]= new mutable.HashMap[Int,Int]()

      var currentMax:Int = -1;
      logger.debug("transformColumnsToThisSchema 3")
      sparseToConvert.columnHeads().foreach
      {
        cht=> thisMap.getOrElse(cht.stringLabel,-1) match
        {
          case x if(x >= 0) =>

            thatThisMap.put(cht.numericLabel,thisMap.get(cht.stringLabel).get)
          case _ =>

            currentMax=currentMax >=0 match
            {
              case true=>
                currentMax=currentMax+1
                newColumnHeadMap.put(currentMax, new ColumnHeadTuple(currentMax,cht.stringLabel))

                thatThisMap.put(cht.numericLabel,currentMax)
                currentMax


              case false => val max =newColumnHeadMap.keySet.max+1


                newColumnHeadMap.put(max, new ColumnHeadTuple(max,cht.stringLabel))
                thatThisMap.put(cht.numericLabel,max)
                max
            }
        }
      }
      logger.debug("transformColumnsToThisSchema 4")
      thatThisMap

    }
    catch {
      case e: Exception => throw new IKodaMLException(e.getMessage, e)
    }
  }


  /**
    * Matches the label numeric values in sparseToConvert with the labels in this RDDLabeledPoint
    * @group man
    * @param sparseToConvert
    * @param newTargetMap
    * @throws ikoda.IKodaMLException
    * @return
    */
  @throws(classOf[IKodaMLException])
  def transformLabelToThisSchema(sparseToConvert:RDDLabeledPoint,newTargetMap:mutable.HashMap[String,Double]):Map[Double,Double]=
  {
    try
    {
      var currentMax:Double=this.targetMaxValue
      logger.debug("transformLabelToThisSchema 1")
      sparseToConvert.getTargets().map
      {
         e =>
           val idxo:Option[Double]=this.getTargetId(e._1)
           idxo.isDefined match
           {
             case true =>
               newTargetMap.put(e._1,idxo.get)
               e._2 -> idxo.get
             case false =>
               currentMax = currentMax+1
               newTargetMap.put(e._1,currentMax)
               e._2 -> currentMax
           }
       }

    }
    catch
    {
      case e:Exception => throw new IKodaMLException(e.getMessage,e)
    }
  }


  /**
    * Converts from ikoda.utils.CsvSpreadheet to RDDLabeledPoint
    * @group man
    * @param spark
    * @param libsvmProcessor
    * @throws ikoda.IKodaMLException
    * @return
    */
  @throws(classOf[IKodaMLException])
  def transformLibSvmProcessorToRDDLabeledPoint(spark: SparkSession, libsvmProcessor: LibSvmProcessor): RDDLabeledPoint =
  {
    try
    {
      val arr: Array[String] = Array()
      val lvtList: mutable.Buffer[LabelValuesTuple] = libsvmProcessor.generateLibSvmRows(arr).asScala
      val lvtQueue: scala.collection.mutable.Queue[LabelValuesTuple] = scala.collection.mutable.Queue(lvtList: _*)
      libsvmProcessor.clearData()
      ilp.columnHeadMap.clear()
      val javaColMap = libsvmProcessor.generateLibSvmColumnMap(arr).asScala
      val invertedColMap = javaColMap.map(_.swap)
      val lpb: ArrayBuffer[(LabeledPoint, Int, String)] = new ArrayBuffer[(LabeledPoint, Int, String)]()
      val newcolmap=new mutable.ListMap[Int,ColumnHeadTuple]()


      //val llp:List[LabeledPoint]=lvtList.map
      while (lvtQueue.nonEmpty)
      {
        var positionsArray: ArrayBuffer[Int] = ArrayBuffer[Int]()
        var valuesArray: ArrayBuffer[Double] = ArrayBuffer[Double]()

        val rowlvt: LabelValuesTuple = lvtQueue.dequeue()

        val label: Double = rowlvt.getTarget
        rowlvt.getSparseMap.asScala.foreach
        {
          case (i, v) =>
            positionsArray += i
            valuesArray += v
            newcolmap.put(i, ColumnHeadTuple(i, invertedColMap(i)))
        }


        val lp: LabeledPoint = newLabeledPoint(label,positionsArray.toArray, valuesArray.toArray)



        lpb += Tuple3(lp, lp.hashCode(), createUUID().toString)

      }
      logger.info(ilp.columnHeadMap.mkString(" || "))
      showMemoryUsage("after llp")
      val data = spark.sparkContext.parallelize(lpb.toSeq)
      val datadict=internalCreataDataDict(libsvmProcessor)
      new RDDLabeledPoint(data,newcolmap,datadict,libsvmProcessor.getName)
    }
    catch
    {
      case e: Exception =>
        logger.error(s"${ilp.name}", e)
        throw IKodaMLException(s"${ilp.name} : ${e.getMessage}", e)

    }
  }





  @throws(classOf[IKodaMLException])
  private [sparse] def transformRowToLabeledPoint(rowIn: Row, fieldNameSeq: Seq[String], targetColumnName: String, totalColCount:Int): Option[LabeledPoint] =
  {
    try
    {
      val values: Map[String, Any] = rowIn.getValuesMap(fieldNameSeq)
      val sortedValuesMap = ListMap(values.toSeq.sortBy(_._1): _*)
      var positionsArray: ArrayBuffer[Int] = ArrayBuffer[Int]()
      var valuesArray: ArrayBuffer[Double] = ArrayBuffer[Double]()
      var currentPosition: Int = 0
      val label: Int = rowIn.getAs(targetColumnName + "_Target")


      def extractDouble(x: Any): Option[Double] = x match
      {
        case n: java.lang.Number => Some(n.doubleValue())
        case _ => None
      }

      System.out.print(".")
      sortedValuesMap.foreach
      {
        kv =>

          val value: Double = extractDouble(kv._2).getOrElse(0)

          if (value > 0)
          {
            valuesArray += value;
            positionsArray += currentPosition
          }
          currentPosition = currentPosition + 1;
      }
      System.out.print(".")
      if (positionsArray.size == 0)
      {
        logger.warn(s"Empty row...")
        None
      }
      else
      {

        new Some(newLabeledPoint(label,  positionsArray.toArray, valuesArray.toArray))
      }
    }
    catch
    {
      case ex: Exception =>
      {
        logger.error(s"${ilp.name}")
        throw IKodaMLException(s"${ilp.name} : ${ex.getMessage}", ex)
      }
    }
  }


  /**
    * Converts from ikoda.utils.CsvSpreadheet to RDDLabeledPoint while mainatining the row indices and label indices of this RDDLabeledPoint
    * @group man
    *
    *
    * @param libsvmProcessor
    * @throws ikoda.IKodaMLException
    * @return
    */


  @throws(classOf[IKodaMLException])
  def transformToRDDLabeledPointWithSchemaMatchingThis(libsvmProcessor: LibSvmProcessor)
  : RDDLabeledPoint =
  {
    try
    {
      val arr: Array[String] = Array()
      val lvtList: mutable.Buffer[LabelValuesTuple] = libsvmProcessor.generateLibSvmRows(arr).asScala
      var positionsArray: ArrayBuffer[Int] = ArrayBuffer[Int]()
      var valuesArray: ArrayBuffer[Double] = ArrayBuffer[Double]()
      /** string,int ****/
      val javaColMap = libsvmProcessor.generateLibSvmColumnMap(arr).asScala
      val invertedColMap = javaColMap.map(_.swap)
      val llp: List[(LabeledPoint, Int, String)] = lvtList.map
      {
        rowlvt =>
          val label: Double = rowlvt.getTarget
          rowlvt.getSparseMap.asScala.foreach
          {
            case (cellidx, cellvalue) =>

              val colName: String = invertedColMap(cellidx)
              val newColIdx = getColumnIndex(colName,true)
              if (newColIdx >= 0)
              {
                positionsArray += newColIdx
                valuesArray += cellvalue
              }
          }

          val tuple:Tuple2[Seq[Int],Seq[Double]]=internalSortColumns(positionsArray,valuesArray)

          val lp = newLabeledPoint(label,tuple._1.toArray, tuple._2.toArray)
          (lp, lp.hashCode(), createUUID().toString)

      }.toList


      val newdata: RDD[(LabeledPoint, Int, String)] = spark.sparkContext.parallelize(llp)


      val newcolumnHeadMap:mutable.ListMap[Int,ColumnHeadTuple] = copyColumnMap
      val newdatadict = copyTargetMap
      val sparseOut: RDDLabeledPoint = new RDDLabeledPoint(newdata,newcolumnHeadMap,newdatadict,libsvmProcessor.getName)
      sparseOut
    }
    catch
      {

        case e: Exception =>


          logger.error(s"${ilp.name}", e)
          throw IKodaMLException(s"${ilp.name} : ${e.getMessage}", e)

      }
  }


  /**
    * Converts sparseToConvert so that column and label indices match this
    * @group man
    * @param sparseToConvert
    * @throws ikoda.IKodaMLException
    * @return
    */
  @throws(classOf[IKodaMLException])
  def transformToRDDLabeledPointWithSchemaMatchingThis(sparseToConvert: RDDLabeledPoint)
  : Option[RDDLabeledPoint] =
  {
    try
    {
      logger.debug("\n\ntransformToRDDLabeledPointWithMatchingSchema\n\n")
      logger.debug(s"Incoming data : ${sparseToConvert.info}")


      isEmpty() match {
        case true => Some(sparseToConvert)
        case false =>

          val thisThatTargets: mutable.HashMap[Double, Double] =  new mutable.HashMap[Double,Double]()

          val newTargetMap:mutable.HashMap[String,Double]=new mutable.HashMap[String,Double]()
          logger.debug("transformToRDDLabeledPointWithSchemaMatchingThis 1")
          val newColumnHeadMap:mutable.ListMap[Int,ColumnHeadTuple]=copyColumnMap
          logger.debug("transformToRDDLabeledPointWithSchemaMatchingThis 2")
          val thatThisMap=transformColumnsToThisSchema(newColumnHeadMap,sparseToConvert)
          val thatThisMapb=spark.sparkContext.broadcast(thatThisMap)
          val maxCol=thatThisMap.values.max +1
          val maxColb=spark.sparkContext.broadcast(maxCol)
          logger.debug("transformToRDDLabeledPointWithSchemaMatchingThis 3")
          val newTargetMapb=spark.sparkContext.broadcast(transformLabelToThisSchema(sparseToConvert,newTargetMap))

          logger.debug("transformToRDDLabeledPointWithSchemaMatchingThis 4")
          val lpRDD: RDD[(LabeledPoint, Int, String)] = sparseToConvert.sparseData().map {
            r =>
              val newLabelIdx: Double = newTargetMapb.value.get(r._1.label).get

              val lpMap:Map[Int,Double]=r._1.features.toSparse.indices.zipWithIndex.map {
                case (colIdx, arrayIdx) =>
                  val value = r._1.features.toSparse.values(arrayIdx)
                  val newColIdx:Int = thatThisMapb.value.get(colIdx).get
                  newColIdx ->value
              }.toMap

              val sortedTuple = internalSortColumns(lpMap.keySet.toArray, lpMap.values.toArray)

              val lp = newLabeledPoint(newLabelIdx, maxColb.value,sortedTuple._1.toArray, sortedTuple._2.toArray)

              Tuple3(lp, lp.hashCode(), r._3)
          }
          logger.debug("transformToRDDLabeledPointWithSchemaMatchingThis 5")


          ///////////////////////////////////////////
          //logger.debug(newColumnHeadMap.mkString("     qp     "))
          //val colmaptemp=transformColAsRowRddToTreeMap( transformLabeledPointRDDToColumnsRdd(lpRDD))
          //logger.debug(colmaptemp.keySet.mkString("     pq       "    ))
          //////////////////////////////////////////////



          val newRDDLP = new RDDLabeledPoint(lpRDD, newColumnHeadMap, newTargetMap.toMap, ilp.name)
          val offset=newRDDLP.columnCount-sparseToConvert.columnCount
          if(offset>0) {
            newRDDLP.columnCountOffset =offset
          }
          logger.debug("columnCountOffset "+columnCountOffset)
          logger.debug("Transformed Data "+newRDDLP.info())
          Option(newRDDLP)
      }

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

  private [sparse]  def internalCreataDataDict(libsvmProcessor: LibSvmProcessor): Map[String, Double] =
  {
    libsvmProcessor.getTargetMap.asScala.map
    {
      t =>
        (t._1, t._2.toDouble)

    }.toMap
  }





  private [sparse] def transformColAsRowRddToTreeMap(colAsRowRdd:RDD[(Int,Seq[CellTuple])]): SortedMap[Int,Seq[CellTuple]] =
  {
    val tt:TicToc=new TicToc
    logger.trace(tt.tic("transformColAsRowRddToTreeMap"))
    val tmap=SortedMap(colAsRowRdd.collectAsMap().toSeq:_*)

    logger.trace("transformColAsRowRddToTreeMap colMap size: "+tmap.size)
    logger.trace(tt.toc("transformColAsRowRddToTreeMap"))
    tmap
  }



  @throws(classOf[IKodaMLException])
  private [sparse] def transformLabeledPointRDDToColumnsRdd(): RDD[(Int,Seq[CellTuple])] =
  {
    transformLabeledPointRDDToColumnsRdd(ilp.dataRDD)
  }

  @throws(classOf[IKodaMLException])
  private [sparse]  def transformLabeledPointRDDToColumnsRdd(rddData:RDD[(LabeledPoint,Int,String)]): RDD[(Int,Seq[CellTuple])] =
  {
    try
    {

      rddData.flatMap
      {
        case (r) =>
          val uuid: java.util.UUID = getOrCreateUUID(r._3)
          r._1.features.toSparse.indices.zipWithIndex.map
          {
            case (colIdx, zidx) =>
              val label: Int = r._1.label.toInt
              val value: Double = r._1.features.toSparse.values(zidx)
              (colIdx, CellTuple(colIdx, label, value, uuid, zidx))
          }
      }.groupBy(e => e._1)
        .map
      {
        e =>
           e._2.foreach(tuple => require(tuple._1 == e._1))
          (e._1, e._2.map(tuple => tuple._2).toSeq)
      }

    }
    catch
    {
      case e:Exception => throw new IKodaMLException(e.getMessage,e)
    }
  }




}
