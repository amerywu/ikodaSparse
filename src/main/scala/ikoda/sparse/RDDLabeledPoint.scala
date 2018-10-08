package ikoda.sparse

import java.io.File
import java.util.UUID

import grizzled.slf4j.Logging
import ikoda.IKodaMLException
import ikoda.utilobjects.DataFrameUtils
import ikoda.utils.TicToc
import org.apache.spark.ml.feature.LabeledPoint
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.rdd.RDD

import scala.collection.immutable.SortedMap
import scala.collection.{immutable, mutable}
import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.util.Try

class RDDLabeledPoint(ilp:LpData) extends RDDLabeledPointInterface(ilp)
{

  def this()
  {
    this(new LpData(None,None,None,None))
  }

  def this(dataRDD: RDD[(LabeledPoint,Int,String)], columnHeadMap: mutable.ListMap[Int, ColumnHeadTuple], datadict:Map[String,Double], name:String)
  {
    this(new LpData(Some(dataRDD),Some(columnHeadMap),Some(datadict),Some(name)))
  }

}



object RDDLabeledPoint extends Logging
{

  type FTDoubleDouble_Double = (Double, Double) => Double

  private def logError(r:Try[RDDLabeledPoint]): Unit =
  {
    logger.error(r.failed.get.getMessage,r.failed.get)
  }

  private def processResult(r:Try[RDDLabeledPoint]):Option[RDDLabeledPoint]=
  {
    r.isSuccess match
  {
    case true => Some(r.get)
    case false => logError(r)
        None

  }

  }


  def soAddColumn(sparse0:RDDLabeledPoint, col: Seq[CellTuple], colName: String): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soAddColumn(col,colName)))

  }

  def soCleanLowerCaseColumns1(sparse0:RDDLabeledPoint): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soCleanLowerCaseColumns1()))
  }

  @throws(classOf[IKodaMLException])
  def soMergeTargets(sparse0:RDDLabeledPoint, oldnew:Map[Double,Double]): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soMergeTargets(oldnew)))
  }

  @throws(classOf[IKodaMLException])
  def soMergeTarget1(sparse0:RDDLabeledPoint, oldTargetIdx: Double, newTargetIdx: Double): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soMergeTarget1(oldTargetIdx,newTargetIdx)))
  }


  @throws(classOf[IKodaMLException])
  def soColStDevs(sparse0:RDDLabeledPoint): Map[Int, CellTuple] =
  {
    sparse0.soColStDevs()
  }


  @throws(classOf[IKodaMLException])
  def soColSums(sparse0:RDDLabeledPoint): Map[Int, CellTuple] =
  {
    sparse0.soColSums()
  }


  @throws(classOf[IKodaMLException])
  def soProportionOfColumnWithValues(sparse0:RDDLabeledPoint, ignoreCol: String = ""): Seq[(Int, Double)] =
  {
    sparse0.soProportionOfColumnWithValues(ignoreCol)
  }


  @throws(classOf[IKodaMLException])
  def soColMedian(sparse0:RDDLabeledPoint): Map[Int, CellTuple] =
  {
      sparse0.soColMedian()
  }





  def soColumnCellOnColumnConstant1(sparse0:RDDLabeledPoint,operation: FTDoubleDouble_Double, constants: Map[Int, CellTuple]): Option[RDDLabeledPoint] =
  {

    processResult(Try(sparse0.soColumnCellOnColumnConstant1(operation,constants)))
  }


  @throws(classOf[IKodaMLException])
  def soInverseDocumentFrequency(sparse0:Option[RDDLabeledPoint]): Option[RDDLabeledPoint] =
  {
    sparse0.isDefined match
      {
      case true => soInverseDocumentFrequency(sparse0.get)
      case _ => logger.warn("No data for IDF")
        None
    }
  }

  @throws(classOf[IKodaMLException])
  def soInverseDocumentFrequency(sparse0:RDDLabeledPoint): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soInverseDocumentFrequency()))
  }



  def soCountRowsByTarget(sparse0:RDDLabeledPoint): RDD[(Double,Int)] =
  {
      sparse0.soCountRowsByTarget()

  }

  @throws(classOf[IKodaMLException])
  def soReduceToTargetBySum1(sparse0:RDDLabeledPoint): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soReduceToTargetBySum1()))
  }







  @throws(classOf[IKodaMLException])
  def soCountRowsByTargetCollected(sparse0:RDDLabeledPoint): Map[Double,Int] =
  {

       sparse0.soCountRowsByTargetCollected()
  }

  @throws(classOf[IKodaMLException])
  def soDichotomizeTargetOrOther( sparse0:RDDLabeledPoint,label: Double, stringLabel: String)
  : Option[RDDLabeledPoint] =
  {
     sparse0.soDichotomizeTargetOrOther(label,stringLabel)
  }




  def soEvenProportionPerTarget1(sparse0:RDDLabeledPoint): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soEvenProportionPerTarget1()))
  }



  def soRenameTargetsInNumeriOrder1(sparse0:RDDLabeledPoint): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soRenameTargetsInNumeriOrder1()))
  }


  def soRemoveDuplicateRows1(sparse0:RDDLabeledPoint): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soRemoveDuplicateRows1()))
  }







  @throws(classOf[IKodaMLException])
  def soGetRowsContainingColIdxAndMatchesLabelUnchangedSchema(sparse0:RDDLabeledPoint,colIdxSet: Set[Int], labelo: Option[Double]): Option[RDDLabeledPoint] =
  {
        sparse0.soGetRowsContainingColIdxAndMatchesLabelUnchangedSchema(colIdxSet,labelo)
  }






  def soRandomSubsetWithColumnRealignment(sparse0:RDDLabeledPoint,proportion: Double): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soRandomSubsetWithColumnRealignment(proportion)))
  }

  def soRandomSubset(sparse0:RDDLabeledPoint,proportion: Double): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soRandomSubset(proportion)))
  }

  def lpSampleDebug(sparse0:RDDLabeledPoint,proportion:Double): String =
  {
    sparse0.lpSampleDebug(proportion)

  }

  def soSubsetByTarget( sparse0:RDDLabeledPoint, label: Double, stringLabel: String): Option[RDDLabeledPoint] =
  {
     sparse0.soSubsetByTarget(label,stringLabel)
  }

  def soRemoveColumns1(sparse0:RDDLabeledPoint, columnIndices: mutable.Queue[Int]): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soRemoveColumns1(columnIndices)))
  }

  def soRemoveColumnsDistributed(sparse0:RDDLabeledPoint, columnIndices: Set[Int]): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soRemoveColumnsDistributed(columnIndices,true)))
  }

  def soRemoveColumnsDistributed( sparse0:RDDLabeledPoint, columnIndices: Set[Int],failOnError:Boolean): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soRemoveColumnsDistributed(columnIndices,failOnError)))

  }

  def soResetColumnIndices( sparse0:RDDLabeledPoint): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soResetColumnIndices()))
  }

  def soResetColumnIndices( sparse0:Option[RDDLabeledPoint]): Option[RDDLabeledPoint] =
  {
    sparse0.isDefined match {
      case true=>soResetColumnIndices(sparse0.get)
      case false=> logger.warn("No data for reset column indices")
        None
    }
  }

  def soRemoveRowsByLabels1( sparse0:RDDLabeledPoint,labelsToRemove: Seq[Double]): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soRemoveRowsByLabels1(labelsToRemove)))
  }

  def soRemoveRowsByHashcode( sparse0:RDDLabeledPoint, hcToRemove: Seq[Int]): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soRemoveRowsByHashcode(hcToRemove)))
  }

  def soRowSums(sparse0:RDDLabeledPoint): mutable.HashMap[Double, CellTuple] =
  {

     sparse0.soRowSums()
  }


  def soTermFrequencyNormalization(sparse0:Option[RDDLabeledPoint]): Option[RDDLabeledPoint] =
  {
    sparse0.isDefined match
      {
      case true=> soTermFrequencyNormalization(sparse0)
      case _ => logger.warn("No data for term frequency")
        None
    }
  }

  def soTermFrequencyNormalization(sparse0:RDDLabeledPoint): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soTermFrequencyNormalization()))

  }


  def soRowCellOnRowConstant1(sparse0:RDDLabeledPoint, operation: FTDoubleDouble_Double, constants: mutable.HashMap[Double, CellTuple]): Option[RDDLabeledPoint] =
  {
     processResult(Try(sparse0.soRowCellOnRowConstant1(operation,constants)))
  }

  def diagnostics(sparse0:RDDLabeledPoint): String =
  {
    sparse0.diagnostics()

  }

  @throws(classOf[Exception])
  def printSparseLocally(sparse0:RDDLabeledPoint, fileName: String, inpath: String): Unit =
  {

       sparse0.printSparseLocally(fileName,inpath)
  }

  @throws(classOf[Exception])
  def printSparseLocally(sparse0:Option[RDDLabeledPoint], fileName: String, inpath: String): Unit =
  {
    sparse0.isDefined match {
      case true=>
        sparse0.get.printSparseLocally (fileName, inpath)
      case _ => logger.warn("No Data, Did NOT print to "+inpath)
    }
  }

  @throws(classOf[Exception])
  def printSparse( sparse0:RDDLabeledPoint,fileName: String, inpath: String,coalesce:Boolean=false): Unit =
  {
      sparse0.printSparse(fileName,inpath,coalesce)

  }


  @throws (classOf[IKodaMLException])
  def validateSparseDataSchemaMatch(sparse0:RDDLabeledPoint,sparse1: RDDLabeledPoint):Boolean=
  {
    sparse0.validateSparseDataSchemaMatch(sparse1)
  }
}