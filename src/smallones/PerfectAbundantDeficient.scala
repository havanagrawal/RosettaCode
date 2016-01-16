/**
 * @author Havan
 */

package smallones

object PerfectAbundantDeficient extends App {
  
  def classify(sumOfDivisors: Int, n: Int) =
    if (sumOfDivisors < n) "Deficient"
    else if (sumOfDivisors > n) "Abundant"
    else "Perfect"
  
  def sumOfProperDivisors(n: Int) = (1 until n).filter(n % _ == 0).sum  
  
  val n = 20000
  val classified = (1 to n).toList.par.groupBy { n => classify(sumOfProperDivisors(n), n) }
  
  classified.foreach(x => println(x._1 + "\t" + x._2.size))
  
}