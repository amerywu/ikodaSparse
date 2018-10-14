package ikoda.utilobjects

trait IntPredicates
{
  protected def intEquals(required:Int)(input:Int) = input == required
  protected def intGT(required:Int)(input:Int) = input > required
  protected def intLT(required:Int)(input:Int) = input < required




  protected def andInt(predicates:Seq[Int => Boolean])(input:Int) = predicates.forall(predicate => predicate(input))
  protected def orInt(predicates:Seq[Int => Boolean])(input:Int) = predicates.exists(predicate => predicate(input))
}
