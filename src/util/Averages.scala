package util

import scala.util.Try
import scala.math._

/**
 * @author Havan
 */
object Averages {
  def avg(firstArg: Double, restArgs: Double*) = {
    (firstArg + restArgs.sum)/(restArgs.size + 1)
  }
  
  def avg(nums: List[Double]): Double = {
    nums.sum/nums.size
  }

  def avgOfAngles(angles: List[Double]): Double = {
    val n = angles.size
    val wrappedAngles = angles.map(_ % 360).map(angle => if (angle < 0) angle + 360 else angle)
    
    val anglesInRadians = wrappedAngles.map(toRadians)
    
    val sumOfSines = anglesInRadians.map(sin).sum
    val sumOfCosines = anglesInRadians.map(cos).sum
    
    val meanAngle = toDegrees(atan(sumOfSines/sumOfCosines))
    if (abs(meanAngle) < 1E-10) 0
    else meanAngle
  }
}