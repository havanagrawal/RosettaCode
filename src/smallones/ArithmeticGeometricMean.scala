/**
 * @author Havan
 */

package smallones

import scala.math._
import scala.annotation.tailrec
import scala.collection.mutable.Buffer

object ArithmeticGeometricMean extends App {

  def avg(nums: Double*) = nums.sum / nums.size

  def agm(a: Double, g: Double, eps: Double): Double = {
    def improve(ag: (Double, Double)) = (avg(ag._1, ag._2), sqrt(ag._1 * ag._2))

    def isGoodEnough(ag: (Double, Double)) = abs(ag._1 - ag._2) < eps

    @tailrec
    def iter(ag: (Double, Double)): (Double, Double) = {
      if (isGoodEnough(ag)) ag
      else iter(improve(ag))
    }

    val res = iter((a, g))
    avg(res._1, res._2)
  }

  val arg = agm(1, (1.0 / sqrt(2)), 1e-10)
  println(arg)
}