package ikoda.sparse

case class ColumnHeadTuple(numericLabel:Int, stringLabel:String) extends Ordered[ColumnHeadTuple]
{

  override def toString: String = numericLabel +" -> "+stringLabel
  override def compare(that: ColumnHeadTuple): Int = (this.numericLabel.toInt) compare (that.numericLabel.toInt)
  
  
}
