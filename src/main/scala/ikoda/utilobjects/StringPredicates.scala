package ikoda.utilobjects

trait StringPredicates
{
  protected def stringEquals(required:String)(input:String) = input == required
  protected def stringStartsWith(required:String)(input:String) = input.startsWith(required)
  protected def stringContains(required:String)(input:String) = input.contains(required)



  protected def andStr(predicates:Seq[String => Boolean])(input:String) = predicates.forall(predicate => predicate(input))
  protected def orStr(predicates:Seq[String => Boolean])(input:String) = predicates.exists(predicate => predicate(input))
}
