package smallones

/**
 * @author Havan
 */
object PerfectAbundantDeficient extends App {
  
  def classify(sumOfDivisors: Int, n: Int) =
    if (sumOfDivisors < n) "Deficient"
    else if (sumOfDivisors > n) "Abundant"
    else "Perfect"
  
  def sumOfProperDivisors(n: Int) = (1 until n).toList.filter(n % _ == 0).sum 
  
  val time = System.nanoTime  
  
  val n = 20000
  val classified = (1 to n).toList.par.groupBy { n => classify(sumOfProperDivisors(n), n) }
  
  val totalTime = (System.nanoTime - time)/1000000000
  println(s"Time taken: $totalTime")
  
  classified.foreach(x => println(x._1 + "\t" + x._2.size))
  
}