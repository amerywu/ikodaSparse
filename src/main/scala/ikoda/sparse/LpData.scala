package ikoda.sparse

import org.apache.spark.ml.feature.LabeledPoint
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

import scala.collection.mutable

@SerialVersionUID(678456432L)
class LpData(dataRDDo: Option[RDD[(LabeledPoint,Int,String)]], columnHeadMapo: Option[mutable.ListMap[Int, ColumnHeadTuple]], targetmapo:Option[Map[String,Double]], nameo:Option[String] ) extends Serializable
{


  lazy val dataRDD:RDD[(LabeledPoint,Int,String)] =
    dataRDDo.isDefined match {
      case true=>dataRDDo.get
      case false => SparkSession.getActiveSession.get.sparkContext.emptyRDD[(LabeledPoint,Int,String)]
    }
  lazy val  columnHeadMap:mutable.ListMap[Int, ColumnHeadTuple]=
    columnHeadMapo.isDefined match
  {
      case true=> columnHeadMapo.get
      case false=> new mutable.ListMap[Int, ColumnHeadTuple]()
    }
  lazy val targetMap:Map[String,Double]=
    targetmapo.isDefined match
      {
      case true => targetmapo.get
      case false => new mutable.HashMap[String,Double]().toMap
    }

  lazy val name:String=
    nameo.isDefined match
      {
      case true => nameo.get
      case false => "unnamed"
    }


}
