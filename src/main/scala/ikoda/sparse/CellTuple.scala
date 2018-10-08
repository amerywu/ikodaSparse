package ikoda.sparse

import grizzled.slf4j.Logging

case class CellTuple(colIndex: Int, label: Double, value: Double , rowId:java.util.UUID, rowPos:Int) extends Ordered[CellTuple] with Logging
{
  
  
  override def compare(that: CellTuple): Int = (this.colIndex) compare (that.colIndex)
  
  override def toString: String = s"col:${colIndex} - label:${label} - value:${value} - rowId:${rowId}\n"
}
