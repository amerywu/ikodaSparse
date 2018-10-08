package ikoda

import grizzled.slf4j.Logging
import org.apache.spark.sql.types.StructField

object ColumnNamePredicates extends Logging
{
  
  def colNameContains(value: String)(sf: StructField) = sf.name.contains(value)
  
  def colNameStartsWith(value: String)(sf: StructField): Boolean =
  {
    val b: Boolean = sf.name.startsWith(value)
    //logger.info(s"colNameStartsWith ${value}  for ${sf.name} is ${b}")
    b
    
    
  }
  
  def colNameEquals(value: String)(sf: StructField): Boolean =
  {
    val b: Boolean = sf.name == value
    //logger.info(s"colNameStartsWith ${value}  for ${sf.name} is ${b}")
    b
    
    
  }
  
  def colNameDoesNotEqual(value: String)(sf: StructField): Boolean =
  {
    val b: Boolean = sf.name != value
    logger.info(s"colNameDoesNotEqual ${value}  for ${sf.name} is ${b}")
    b
    
    
  }
  
  def and(predicates: Seq[StructField => Boolean])(sf: StructField) = predicates.forall(predicate => predicate(sf))
  
  def or(predicates: Seq[StructField => Boolean])(sf: StructField) = predicates.exists(predicate => predicate(sf))
}
