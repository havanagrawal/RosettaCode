/**
 * @author Havan
 */

package smallones

import scala.collection.{ mutable => mut }
import scala.collection.{ immutable => immut }
import util.Timer
import scala.annotation.tailrec

object AlmostPrimes extends App {
  /**
   * Generate primes upto (inclusive) n
   * using Eratosthenes' Sieve
   * 
   * It should be noted that this function does NOT generate the first n primes
   * But all primes up till n
   * 
   * @param n The number till which primes will be generated 
   */
  def generatePrimes(n: Int) = {
    val isPrime = new Array[Boolean](n + 1)

    (2 to n).foreach {isPrime(_) = true}

    (2 to n).foreach { i =>
      if (isPrime(i)) {
        (2 * i to n by i).foreach {
          isPrime(_) = false
        }
      }
    }
    (1 to n).filter(isPrime)
  }
  
  /**
   * Generates first n k-almost primes
   */
  def kAlmostPrimes(n: Int, k: Int) = {
    val nativePrimeSet = generatePrimes(n * n)
    def helper(n: Int, k: Int): Seq[Int] = {
      if (k == 1) nativePrimeSet.take(n)
      else {
        helper(n, k - 1).flatMap { x =>
          nativePrimeSet.map(x * _)
        }.toSet.toList.sortWith(_ < _).take(n)
      }
    }
    helper(n, k)
  }
  
  val n = 15
  val maxK = 10
  
  println("k\tk-Almost Primes")
  (1 to maxK).foreach {k => 
    println(s"$k\t${kAlmostPrimes(n, k).mkString(",")}")
  }
  
}