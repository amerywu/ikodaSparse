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
import org.apache.spark.sql.Dataset

import scala.collection.immutable.{Queue, SortedMap}
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


  def loadLibSvmLocal(inpth: String, validateColumns:Boolean=true): Try[RDDLabeledPoint] =
  {

    Try(new RDDLabeledPoint().loadLibSvmLocal( inpth))
  }


  def loadLibSvm(fileName: String, path: String, validateColumns:Boolean=false): Try[RDDLabeledPoint] =
  {
    Try(new RDDLabeledPoint().loadLibSvm(fileName,path,validateColumns))
  }

  def loadLibSvmFromHelper(data:Dataset[(LabeledPoint,Int,String)], columns:mutable.ListMap[Int,ColumnHeadTuple], targets:Map[String,Double], datasetName:String, validateCompleteness:Boolean=false): Try[RDDLabeledPoint] =
  {
    Try(new RDDLabeledPoint().loadLibSvmFromHelper(data,columns,targets,datasetName,validateCompleteness))
  }


  def addColumn(sparse0:RDDLabeledPoint, col: Seq[CellTuple], colName: String): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soAddColumn(col,colName)))

  }

  def cleanLowerCaseColumns(sparse0:RDDLabeledPoint): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soCleanLowerCaseColumns1()))
  }

  @throws(classOf[IKodaMLException])
  def soMergeTargets(sparse0:RDDLabeledPoint, oldnew:Map[Double,Double]): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soMergeTargets(oldnew)))
  }

  @throws(classOf[IKodaMLException])
  def mergeTarget(sparse0:RDDLabeledPoint, oldTargetIdx: Double, newTargetIdx: Double): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soMergeTarget1(oldTargetIdx,newTargetIdx)))
  }


  @throws(classOf[IKodaMLException])
  def colStDevs(sparse0:RDDLabeledPoint): Map[Int, CellTuple] =
  {
    sparse0.soColStDevs()
  }


  @throws(classOf[IKodaMLException])
  def colSums(sparse0:RDDLabeledPoint): Map[Int, CellTuple] =
  {
    sparse0.soColSums()
  }


  @throws(classOf[IKodaMLException])
  def proportionOfColumnWithValues(sparse0:RDDLabeledPoint, ignoreCol: String = ""): Seq[(Int, Double)] =
  {
    sparse0.soProportionOfColumnWithValues(ignoreCol)
  }


  @throws(classOf[IKodaMLException])
  def colMedian(sparse0:RDDLabeledPoint): Map[Int, CellTuple] =
  {
      sparse0.soColMedian()
  }





  def columnCellOnColumnConstant(sparse0:RDDLabeledPoint,operation: FTDoubleDouble_Double, constants: Map[Int, CellTuple]): Option[RDDLabeledPoint] =
  {

    processResult(Try(sparse0.soColumnCellOnColumnConstant1(operation,constants)))
  }


  @throws(classOf[IKodaMLException])
  def inverseDocumentFrequency(sparse0:Option[RDDLabeledPoint]): Option[RDDLabeledPoint] =
  {
    sparse0.isDefined match
      {
      case true => inverseDocumentFrequency(sparse0.get)
      case _ => logger.warn("No data for IDF")
        None
    }
  }

  @throws(classOf[IKodaMLException])
  def inverseDocumentFrequency(sparse0:RDDLabeledPoint): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soInverseDocumentFrequency()))
  }



  def countRowsByTarget(sparse0:RDDLabeledPoint): RDD[(Double,Int)] =
  {
      sparse0.soCountRowsByTarget()

  }

  @throws(classOf[IKodaMLException])
  def reduceToTargetBySum1(sparse0:RDDLabeledPoint): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soReduceToTargetBySum1()))
  }







  @throws(classOf[IKodaMLException])
  def countRowsByTargetCollected(sparse0:RDDLabeledPoint): Map[Double,Int] =
  {

       sparse0.soCountRowsByTargetCollected()
  }

  @throws(classOf[IKodaMLException])
  def dichotomizeTargetOrOther( sparse0:RDDLabeledPoint,label: Double, stringLabel: String)
  : Option[RDDLabeledPoint] =
  {
     sparse0.soDichotomizeTargetOrOther(label,stringLabel)
  }




  def evenProportionPerTarget(sparse0:RDDLabeledPoint): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soEvenProportionPerTarget1()))
  }



  def renameTargetsInNumeriOrder1(sparse0:RDDLabeledPoint): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soRenameTargetsInNumeriOrder1()))
  }


  def removeDuplicateRows(sparse0:RDDLabeledPoint): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soRemoveDuplicateRows1()))
  }







  @throws(classOf[IKodaMLException])
  def getRowsContainingColIdxAndMatchesLabelUnchangedSchema(sparse0:RDDLabeledPoint,colIdxSet: Set[Int], labelo: Option[Double]): Option[RDDLabeledPoint] =
  {
        sparse0.soGetRowsContainingColIdxAndMatchesLabelUnchangedSchema(colIdxSet,labelo)
  }






  def randomSubsetWithColumnRealignment(sparse0:RDDLabeledPoint,proportion: Double): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soRandomSubsetWithColumnRealignment(proportion)))
  }

  def randomSubset(sparse0:RDDLabeledPoint,proportion: Double): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soRandomSubset(proportion)))
  }

  def sampleDebug(sparse0:RDDLabeledPoint,proportion:Double): String =
  {
    sparse0.lpSampleDebug(proportion)

  }

  def subsetByTarget( sparse0:RDDLabeledPoint, label: Double, stringLabel: String): Option[RDDLabeledPoint] =
  {
     sparse0.soSubsetByTarget(label,stringLabel)
  }

  def removeColumns(sparse0:RDDLabeledPoint, columnIndices: mutable.Queue[Int]): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soRemoveColumns1(columnIndices)))
  }

  def removeColumns(sparse0:RDDLabeledPoint, columnIndices: Set[Int]): Option[RDDLabeledPoint] =
  {
    val q:mutable.Queue[Int]=new mutable.Queue[Int]()
    q ++ columnIndices

    processResult(Try(sparse0.soRemoveColumns1(q)))
  }


  def removeColumnsDistributed(sparse0:RDDLabeledPoint, columnIndices: Set[Int]): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soRemoveColumnsDistributed(columnIndices,true)))
  }

  def removeColumnsDistributed( sparse0:RDDLabeledPoint, columnIndices: Set[Int],failOnError:Boolean): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soRemoveColumnsDistributed(columnIndices,failOnError)))

  }

  def resetColumnIndices( sparse0:RDDLabeledPoint): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soResetColumnIndices()))
  }

  def resetColumnIndices( sparse0:Option[RDDLabeledPoint]): Option[RDDLabeledPoint] =
  {
    sparse0.isDefined match {
      case true=>resetColumnIndices(sparse0.get)
      case false=> logger.warn("No data for reset column indices")
        None
    }
  }

  def removeRowsByLabels( sparse0:RDDLabeledPoint,labelsToRemove: Seq[Double]): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soRemoveRowsByLabels1(labelsToRemove)))
  }

  def removeRowsByHashcode( sparse0:RDDLabeledPoint, hcToRemove: Seq[Int]): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soRemoveRowsByHashcode(hcToRemove)))
  }

  def rowSums(sparse0:RDDLabeledPoint): mutable.HashMap[Double, CellTuple] =
  {

     sparse0.soRowSums()
  }


  def termFrequencyNormalization(sparse0:Option[RDDLabeledPoint]): Option[RDDLabeledPoint] =
  {
    sparse0.isDefined match
      {
      case true=> termFrequencyNormalization(sparse0.get)
      case _ => logger.warn("No data for term frequency")
        None
    }
  }

  def termFrequencyNormalization(sparse0:RDDLabeledPoint): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soTermFrequencyNormalization()))

  }


  def rowCellOnRowConstant1(sparse0:RDDLabeledPoint, operation: FTDoubleDouble_Double, constants: mutable.HashMap[Double, CellTuple]): Option[RDDLabeledPoint] =
  {
     processResult(Try(sparse0.soRowCellOnRowConstant1(operation,constants)))
  }

  def diagnostics(sparse0:RDDLabeledPoint): String =
  {
    sparse0.diagnostics()

  }

  @throws(classOf[Exception])
  def printSparseLocally(sparse0:RDDLabeledPoint, fileName: String, inpath: String, truncateAt:Int=0): Unit =
  {

       sparse0.printSparseLocally(fileName,inpath,truncateAt)
  }

  @throws(classOf[Exception])
  def printSparseLocally(sparse0:Option[RDDLabeledPoint], fileName: String, inpath: String, truncateAt:Option[Int]): Unit =
  {
    sparse0.isDefined match {
      case true=>
        sparse0.get.printSparseLocally (fileName, inpath,truncateAt.getOrElse(0))
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