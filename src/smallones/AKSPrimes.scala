/**
 * @author Havan
 */

package smallones

import scala.collection.{mutable => mut}

object AKSPrimes extends App {
  
  val nCrCache: mut.Map[(BigInt, BigInt), BigInt] = mut.Map.empty[(BigInt, BigInt), BigInt]
  
  def nCr(n: BigInt, r: BigInt): BigInt = {
    nCrCache.getOrElse((n, r), { 
      val ncr = 
        if (n == r) BigInt(1)
        else if (r == 1) n 
        else nCr(n - 1, r) + nCr(n - 1, r - 1)
      
      nCrCache.put((n, r), ncr)
      ncr
    })
  }
  
  def getCoefficients(p: Int): Seq[BigInt] = (1 to p).map(nCr(p, _))
  
  def isPrime(p: Int): Boolean = {
    val coeff = getCoefficients(p)
    coeff.slice(1, coeff.size).forall {_ % p == 0}
  }
  
  (2 to 50).foreach(x => println(x + "\t" + isPrime(x)))
}