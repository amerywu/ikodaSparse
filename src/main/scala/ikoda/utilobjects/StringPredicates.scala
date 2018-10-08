package ikoda.utilobjects

trait StringPredicates
{
  def stringEquals(required:String)(input:String) = input == required
  def stringStartsWith(required:String)(input:String) = input.startsWith(required)
  def stringContains(required:String)(input:String) = input.contains(required)
  
  
  
  def andStr(predicates:Seq[String => Boolean])(input:String) = predicates.forall(predicate => predicate(input))
  def orStr(predicates:Seq[String => Boolean])(input:String) = predicates.exists(predicate => predicate(input))
}
