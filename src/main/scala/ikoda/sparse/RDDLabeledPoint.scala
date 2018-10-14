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



/**
  * @groupname dp Data Attributes
  * @groupname load Loading and Saving
  * @groupname cpt Data Computation
  * @groupname man Data Manipulation
  *
  *
  * @param ilp
  */

class RDDLabeledPoint(ilp:LpData) extends RDDLabeledPointInterface(ilp)
{

  /**
    *  Create an empty RDDLabeledPoint
    */
  def this()
  {
    this(new LpData(None,None,None,None))
  }

  /**
    * Create an RDDLabeledPoint instance with data passed into constructor.
    * dataRDD: RDD[(LabeledPoint,Int,String)],
    * columnHeadMap: mutable.ListMap[Int, ColumnHeadTuple],
    * datadict:Map[String,Double],
    * name:String
    *
    * @param dataRDD
    * @param columnHeadMap
    * @param datadict
    * @param name
    */
  def this(dataRDD: RDD[(LabeledPoint,Int,String)], columnHeadMap: mutable.ListMap[Int, ColumnHeadTuple], datadict:Map[String,Double], name:String)
  {
    this(new LpData(Some(dataRDD),Some(columnHeadMap),Some(datadict),Some(name)))
  }

}


/**
  * @groupname dp Data Attributes
  * @groupname load Loading and Saving
  * @groupname cpt Data Computation
  * @groupname man Data Manipulation
  *
  *
  *
  */
object RDDLabeledPoint extends Logging
{

  type FTDoubleDouble_Double = (Double, Double) => Double

  /**
    *
    * @param r
    */
  private def logError(r:Try[RDDLabeledPoint]): Unit =
  {
    logger.error(r.failed.get.getMessage,r.failed.get)
  }

  /**
    *
    * @param r
    * @return
    */
  private def processResult(r:Try[RDDLabeledPoint]):Option[RDDLabeledPoint]=
  {
    r.isSuccess match
  {
    case true => Some(r.get)
    case false => logError(r)
        None
  }

  }



  /**
    * Loads the column map and target map from local drive but NOT the data.
    * @group load
    * @return
    */
  def loadSchemaLocal(inpth: String): Try[RDDLabeledPoint] =
  {
    Try(new RDDLabeledPoint().loadSchemaLocal(inpth))
  }
  /**
    * Loads the column map and target map from hadoop but NOT the data.
    * @group load
    * @return
    */
  @throws(classOf[Exception])
  def loadSchema1( fileName: String, path: String): Try[RDDLabeledPoint] =
  {
      Try(new RDDLabeledPoint().loadSchema1(fileName,path))
  }

  /**
    * Loads the column map and target map input variables.
    * @group load
    * @return
    */
  @throws(classOf[Exception])
  def loadLibSvmSchemaFromHelper1(columns:mutable.ListMap[Int,ColumnHeadTuple], targets:Map[String,Double],datasetName:String): Try[RDDLabeledPoint] =
  {
    Try(new RDDLabeledPoint().loadLibSvmSchemaFromHelper1(columns,targets,datasetName))
  }


  /**
    * Loads libsvm data from local path. Companion files for column map and target map are expected
    * See documentation for explanation
    * validateColumns (optional), if true, checks that column count in the column map matches total column/feature count in the LabeledPoint data
    * @group load
    * @param inpth
    * @param validateColumns
    * @return
    */
  def loadLibSvmLocal(inpth: String, validateColumns:Boolean=true): Try[RDDLabeledPoint] =
  {

    Try(new RDDLabeledPoint().loadLibSvmLocal( inpth))
  }

  /**
    * Loads libsvm data from hadoop path. Companion files for column map and target map are expected
    * See documentation for explanation
    * validateColumns (optional), if true, checks that column count in the column map matches total column/feature count in the LabeledPoint data
    *
    * @group load
    * @param fileName
    * @param path
    * @param validateColumns
    * @return
    */
  def loadLibSvm(fileName: String, path: String, validateColumns:Boolean=false): Try[RDDLabeledPoint] =
  {
    Try(new RDDLabeledPoint().loadLibSvm(fileName,path,validateColumns))
  }

  /**
    * Loads libsvm data passed in as a DataSet and companion maps for column names and target names
    * The dataset name is a convenience parameter for tracking your data
    * validateCompleteness (optional), if true, checks that column count in the column map matches total column/feature count in the LabeledPoint data
    *
    * data:Dataset[(LabeledPoint,Int,String)],
    * columns:mutable.ListMap[Int,ColumnHeadTuple],
    * targets:Map[String,Double],
    * datasetName:String,
    * validateCompleteness:Boolean=false
    *
    * See documentation for explanation
    * @group load
    * @param data
    * @param columns
    * @param targets
    * @param datasetName
    * @param validateCompleteness
    * @return
    */
  def loadLibSvmFromHelper(data:Dataset[(LabeledPoint,Int,String)], columns:mutable.ListMap[Int,ColumnHeadTuple], targets:Map[String,Double], datasetName:String, validateCompleteness:Boolean=false): Try[RDDLabeledPoint] =
  {
    Try(new RDDLabeledPoint().loadLibSvmFromHelper(data,columns,targets,datasetName,validateCompleteness))
  }

  /**
  * Loads libsvm data passed in as a DataSet and companion maps for column names and target names
  * The dataset name is a convenience parameter for tracking your data
  * validateCompleteness (optional), if true, checks that column count in the column map matches total column/feature count in the LabeledPoint data
  * Refer to documentation for explanation
    *
    *
  * @group load
  * @param data
  * @param columns
  * @param targets
  * @param datasetName
  * @param validateCompleteness
  * @return
  */
  def loadLibSvmFromHelper1(data:RDD[(LabeledPoint)], columns:mutable.ListMap[Int,ColumnHeadTuple], targets:Map[String,Double], datasetName:String, validateCompleteness:Boolean=false): Try[RDDLabeledPoint] =
  {
    Try(new RDDLabeledPoint().loadLibSvmFromHelper1(data,columns,targets,datasetName,validateCompleteness))
  }




  /**
    * Add a column  to the dataset. The number of CellTupls must much the number of rows in the dataset
    * @group man
    * @param sparse0
    * @param col
    * @param colName
    * @return
    */
  def addColumn(sparse0:RDDLabeledPoint, col: Seq[CellTuple], colName: String): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soAddColumn(col,colName)))

  }

  /**
    * Utility method prepares column names to meet Cassandra conventions for column names
    * @group man
    * @param sparse0
    * @return
    */
  def cleanLowerCaseColumns(sparse0:RDDLabeledPoint): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soCleanLowerCaseColumns1()))
  }

  /**
    * Merge targets. The old target will be renamed to match the new target
    * @group man
    * @param sparse0
    * @param oldnew
    * @throws ikoda.IKodaMLException
    * @return
    */
  @throws(classOf[IKodaMLException])
  def soMergeTargets(sparse0:RDDLabeledPoint, oldnew:Map[Double,Double]): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soMergeTargets(oldnew)))
  }

  /**
    * Merge two targets so the old target is replaced with the new target
    * @group man
    * @param sparse0
    * @param oldTargetIdx
    * @param newTargetIdx
    * @throws ikoda.IKodaMLException
    * @return
    */
  @throws(classOf[ikoda.IKodaMLException])
  def mergeTarget(sparse0:RDDLabeledPoint, oldTargetIdx: Double, newTargetIdx: Double): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soMergeTarget1(oldTargetIdx,newTargetIdx)))
  }

  /**
    * The standard deviation for each column
    * @group cpt
    * @param sparse0
    * @throws ikoda.IKodaMLException
    * @return
    */
  @throws(classOf[IKodaMLException])
  def colStDevs(sparse0:RDDLabeledPoint): Map[Int, CellTuple] =
  {
    sparse0.soColStDevs()
  }

  /**
    * The column sum for each column
    * @group cpt
    * @param sparse0
    * @throws ikoda.IKodaMLException
    * @return
    */
  @throws(classOf[IKodaMLException])
  def colSums(sparse0:RDDLabeledPoint): Map[Int, CellTuple] =
  {
    sparse0.soColSums()
  }

  /**
    * The proportion of non-zero values in each column
    * @group cpt
    * @param sparse0
    * @param ignoreCol
    * @throws ikoda.IKodaMLException
    * @return
    */
  @throws(classOf[IKodaMLException])
  def proportionOfColumnWithValues(sparse0:RDDLabeledPoint, ignoreCol: String = ""): Seq[(Int, Double)] =
  {
    sparse0.soProportionOfColumnWithValues(ignoreCol)
  }

  /**
    * Returns the median value for every column
    * @group cpt
    * @param sparse0
    * @throws ikoda.IKodaMLException
    * @return
    */
  @throws(classOf[IKodaMLException])
  def colMedian(sparse0:RDDLabeledPoint): Map[Int, CellTuple] =
  {
      sparse0.soColMedian()
  }


  /**
    * See documentation. The map holds a constant (e.g., column sum) for every column. The operation method specifies a function to be performed on each cell in each column with the constant as the second parameter in the method
    *
    * @group cpt
    * @param sparse0
    * @param operation
    * @param constants
    * @return
    */
  def columnCellOnColumnConstant(sparse0:RDDLabeledPoint,operation: FTDoubleDouble_Double, constants: Map[Int, CellTuple]): Option[RDDLabeledPoint] =
  {

    processResult(Try(sparse0.soColumnCellOnColumnConstant1(operation,constants)))
  }

  /**
    * Takes sparse data that has already been normalized using termFrequencyNormalization. Performs inverse document frequency
    * @group cpt
    * @param sparse0
    * @throws ikoda.IKodaMLException
    * @return
    */
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
  /**
    * Takes sparse data that has already been normalized using termFrequencyNormalization. Performs inverse document frequency
    * @group cpt
    * @param sparse0
    * @throws ikoda.IKodaMLException
    * @return
    */
  @throws(classOf[IKodaMLException])
  def inverseDocumentFrequency(sparse0:RDDLabeledPoint): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soInverseDocumentFrequency()))
  }


  /**
    * The number of rows assigned to each target/label
    * @group cpt
    * @param sparse0
    * @return
    */
  def countRowsByTarget(sparse0:RDDLabeledPoint): RDD[(Double,Int)] =
  {
      sparse0.soCountRowsByTarget()

  }

  /**
    * Reduces all rows for a give target/label to a single row by summing the values for each column/feature
    * @group cpt
    * @param sparse0
    * @throws ikoda.IKodaMLException
    * @return
    */
  @throws(classOf[IKodaMLException])
  def reduceToTargetBySum1(sparse0:RDDLabeledPoint): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soReduceToTargetBySum1()))
  }


  /**
    * counts number of rows per target. Data is collected to driver before executing
    * @group cpt
    * @param sparse0
    * @throws ikoda.IKodaMLException
    * @return
    */
  @throws(classOf[IKodaMLException])
  def countRowsByTargetCollected(sparse0:RDDLabeledPoint): Map[Double,Int] =
  {

       sparse0.soCountRowsByTargetCollected()
  }

  /**
    * Resets the label for all rows to OTHER except for the label specified as an input parameter
    * @group man
    * @param sparse0
    * @param label
    * @param stringLabel
    * @throws ikoda.IKodaMLException
    * @return
    */
  @throws(classOf[IKodaMLException])
  def dichotomizeTargetOrOther( sparse0:RDDLabeledPoint,label: Double, stringLabel: String)
  : Option[RDDLabeledPoint] =
  {
     sparse0.soDichotomizeTargetOrOther(label,stringLabel)
  }


  /**
    * Reduces the number of rows for over-represented labels/categories. Rows are randomly removed from
    * which belong to a category with rows above the median row count per target. All categories with a row count
    * above the median row count per category are reduced to approximate the median row count
    * @group man
    * @param sparse0
    * @return
    */
  def evenProportionPerTarget(sparse0:RDDLabeledPoint): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soEvenProportionPerTarget1()))
  }


  /**
    * Renames targets in numeric order
    * @group man
    * @param sparse0
    * @return
    */
  def renameTargetsInNumericOrder(sparse0:RDDLabeledPoint): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soRenameTargetsInNumeriOrder1()))
  }

  /**
    * Removes all duplicate rows
    * @group man
    * @param sparse0
    * @return
    */
  def removeDuplicateRows(sparse0:RDDLabeledPoint): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soRemoveDuplicateRows1()))
  }


  /**
    *
    *
    * A dataset of rows that have an active value for a specified column/feature. If the label is None
    * all rows are returned, otherwise the subset is also by label/target
    * @group dp
    * @param sparse0
    * @param colIdxSet
    * @param labelo
    * @throws ikoda.IKodaMLException
    * @return
    */
  @throws(classOf[IKodaMLException])
  def getRowsContainingColIdxAndMatchesLabelUnchangedSchema(sparse0:RDDLabeledPoint,colIdxSet: Set[Int], labelo: Option[Double]): Option[RDDLabeledPoint] =
  {
        sparse0.soGetRowsContainingColIdxAndMatchesLabelUnchangedSchema(colIdxSet,labelo)
  }


  /**
    * Returns a random subset with columns reassigned to sequential order
    * @group man
    * @param sparse0
    * @param proportion
    * @return
    */
  def randomSubsetWithColumnRealignment(sparse0:RDDLabeledPoint,proportion: Double): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soRandomSubsetWithColumnRealignment(proportion)))
  }

  /**
    * Returns a random subset
    * @group man
    * @param sparse0
    * @param proportion
    * @return
    */
  def randomSubset(sparse0:RDDLabeledPoint,proportion: Double): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soRandomSubset(proportion)))
  }

  /**
    * A print out of a certain propertion of the dataset
    * @group dp
    * @param sparse0
    * @param proportion
    * @return
    */
  def sampleDebug(sparse0:RDDLabeledPoint,proportion:Double): String =
  {
    sparse0.lpSampleDebug(proportion)

  }

  /**
    * A subset including all rows for the specified label/target
    * @group man
    * @param sparse0
    * @param label
    * @param stringLabel
    * @return
    */
  def subsetByTarget( sparse0:RDDLabeledPoint, label: Double, stringLabel: String): Option[RDDLabeledPoint] =
  {
     sparse0.soSubsetByTarget(label,stringLabel)
  }

  /**
    * Removes columns/features from the dataset. Column indices are not re-aligned after column removal
    * @deprecated
    * @param sparse0
    * @param columnIndices
    * @return
    */
  def removeColumnsCollected(sparse0:RDDLabeledPoint, columnIndices: mutable.Queue[Int]): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soRemoveColumns1(columnIndices)))
  }

  /**
    * Removes columns/features from the dataset. Column indices are not re-aligned after column removal
    * @deprecated
    * @param sparse0
    * @param columnIndices
    * @return
    */
  def removeColumnsCollected(sparse0:RDDLabeledPoint, columnIndices: Set[Int]): Option[RDDLabeledPoint] =
  {
    val q:mutable.Queue[Int]=new mutable.Queue[Int]()
    q ++ columnIndices

    processResult(Try(sparse0.soRemoveColumns1(q)))
  }

  /**
    * Removes columns/features from the dataset. Column indices are not re-aligned after column removal
    * @group man
    * @param sparse0
    * @param columnIndices
    * @return
    */
  def removeColumnsDistributed(sparse0:RDDLabeledPoint, columnIndices: Set[Int]): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soRemoveColumnsDistributed(columnIndices,true)))
  }

  /**
    * Removes columns/features from the dataset. Column indices are not re-aligned after column removal.
    * If failOnError == true, the method returns None when it encounters an invalid column/feature. Otherwise, the
    * invalid column index is ignored
    * @group man
    * @param sparse0
    * @param columnIndices
    * @param failOnError
    * @return
    */
  def removeColumnsDistributed( sparse0:RDDLabeledPoint, columnIndices: Set[Int],failOnError:Boolean): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soRemoveColumnsDistributed(columnIndices,failOnError)))

  }

  /**
    * Resets column indices in ascending numeric order
    * @group man
    * @param sparse0
    * @return
    */
  def resetColumnIndices( sparse0:RDDLabeledPoint): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soResetColumnIndices()))
  }

  /**
    * Resets column indices in ascending numeric order
    * @group man
    * @param sparse0
    * @return
    */
  def resetColumnIndices( sparse0:Option[RDDLabeledPoint]): Option[RDDLabeledPoint] =
  {
    sparse0.isDefined match {
      case true=>resetColumnIndices(sparse0.get)
      case false=> logger.warn("No data for reset column indices")
        None
    }
  }

  /**
    * Removes all rows assigned to the labels specified in labelsToRemove
    * @group man
    * @param sparse0
    * @param labelsToRemove
    * @return
    */
  def removeRowsByLabels( sparse0:RDDLabeledPoint,labelsToRemove: Seq[Double]): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soRemoveRowsByLabels1(labelsToRemove)))
  }

  /**
    * Removes all rows  with hashcodes specified in hcToRemove. (Useful to remove duplicate rows)
    * @group man
    * @param sparse0
    * @param hcToRemove
    * @return
    */
  def removeRowsByHashcode( sparse0:RDDLabeledPoint, hcToRemove: Seq[Int]): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soRemoveRowsByHashcode(hcToRemove)))
  }

  /**
    * A row sum value for each row
    * @group cpt
    * @param sparse0
    * @return
    */
  def rowSums(sparse0:RDDLabeledPoint): mutable.HashMap[Double, CellTuple] =
  {

     sparse0.soRowSums()
  }

  /**
    * The first step in a TF-IDF computation
    * @group cpt
    * @param sparse0
    * @return
    */
  def termFrequencyNormalization(sparse0:Option[RDDLabeledPoint]): Option[RDDLabeledPoint] =
  {
    sparse0.isDefined match
      {
      case true=> termFrequencyNormalization(sparse0.get)
      case _ => logger.warn("No data for term frequency")
        None
    }
  }

  /**
    * The first step in a TF-IDF computation
    * @group cpt
    * @param sparse0
    * @return
    */
  def termFrequencyNormalization(sparse0:RDDLabeledPoint): Option[RDDLabeledPoint] =
  {
    processResult(Try(sparse0.soTermFrequencyNormalization()))

  }

  /**
    * Performs a computation on every cell in every row, with a unique constant for each row provided as an input parameter
    * @group cpt
    * @param sparse0
    * @param operation
    * @param constants
    * @return
    */
  def rowCellOnRowConstant1(sparse0:RDDLabeledPoint, operation: FTDoubleDouble_Double, constants: mutable.HashMap[Double, CellTuple]): Option[RDDLabeledPoint] =
  {
     processResult(Try(sparse0.soRowCellOnRowConstant1(operation,constants)))
  }

  /**
    * Reports on differences between the labeled point data and data in the column map and target map
    * @group dp
    * @param sparse0
    * @return
    */
  def diagnostics(sparse0:RDDLabeledPoint): String =
  {
    sparse0.diagnostics()

  }

  /**
    * Saves data to a local file system.
    * @group load
    * @param sparse0
    * @param fileName
    * @param inpath
    * @param truncateAt The number of decimal points to keep in the output (Truncated, not rounded)
    * @throws java.lang.Exception
    */
  @throws(classOf[Exception])
  def printSparseLocally(sparse0:RDDLabeledPoint, fileName: String, inpath: String, truncateAt:Int=0): Unit =
  {

       sparse0.printSparseLocally(fileName,inpath,truncateAt)
  }

  /**
    * Saves data to a local file system
    * @group load
    * @param sparse0
    * @param fileName
    * @param inpath
    * @param truncateAt The number of decimal points to keep in the output (Truncated, not rounded)
    * @throws java.lang.Exception
    */
  @throws(classOf[Exception])
  def printSparseLocally(sparse0:Option[RDDLabeledPoint], fileName: String, inpath: String, truncateAt:Option[Int]): Unit =
  {
    sparse0.isDefined match {
      case true=>
        sparse0.get.printSparseLocally (fileName, inpath,truncateAt.getOrElse(0))
      case _ => logger.warn("No Data, Did NOT print to "+inpath)
    }
  }

  /**
    * Saves data to a local file system.
    * @group load
    * @param sparse0
    * @param fileName
    * @param inpath
    * @param coalesce
    * @throws java.lang.Exception
    */
  @throws(classOf[Exception])
  def printSparse( sparse0:RDDLabeledPoint,fileName: String, inpath: String,coalesce:Boolean=false): Unit =
  {
      sparse0.printSparse(fileName,inpath,coalesce)

  }


  /**
    * Saves data to Hadoop
    * @group load
    * @param sparse0
    * @param sparse1
    * @throws ikoda.IKodaMLException
    * @return
    */
  @throws (classOf[IKodaMLException])
  def validateSparseDataSchemaMatch(sparse0:RDDLabeledPoint,sparse1: RDDLabeledPoint):Boolean=
  {
    sparse0.validateSparseDataSchemaMatch(sparse1)
  }
}