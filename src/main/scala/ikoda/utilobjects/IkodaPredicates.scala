package ikoda.utilobjects

object IkodaPredicates extends IntPredicates with StringPredicates
{


  
  
  
  def and[A](predicates:Seq[A => Boolean])(input:A) = predicates.forall(predicate => predicate(input))
  def or[A](predicates:Seq[A => Boolean])(input:A) = predicates.exists(predicate => predicate(input))
}
