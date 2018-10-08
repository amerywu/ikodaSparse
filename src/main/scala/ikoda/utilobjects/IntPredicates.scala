package ikoda.utilobjects

trait IntPredicates
{
  def intEquals(required:Int)(input:Int) = input == required
  def intGT(required:Int)(input:Int) = input > required
  def intLT(required:Int)(input:Int) = input < required

  
  
  
  def andInt(predicates:Seq[Int => Boolean])(input:Int) = predicates.forall(predicate => predicate(input))
  def orInt(predicates:Seq[Int => Boolean])(input:Int) = predicates.exists(predicate => predicate(input))
}
