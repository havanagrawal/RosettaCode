/**
 * @author Havan
 */

package smallones

object AmicablePairs extends App {
  def sumOfProperDivisors(n: Int) = (1 until n).filter(n % _ == 0).sum
  
  val n = 20000
  
  val sumOfDivisors = (1 to n).map(x => x -> sumOfProperDivisors(x)).toMap
  
  val amicablePairs = sumOfDivisors.filter{pair => 
    pair._1 < pair._2 &&
    pair._1 == sumOfDivisors.getOrElse(pair._2, 0)
  }
  
  amicablePairs.foreach(println)
}