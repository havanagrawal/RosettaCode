package smallones

/**
 * @author Havan
 */
object AverageTest extends App {
  
  import util.Averages._
  
  println(avg(0))
  println(avg(1, 2, 3, 4))
  println(avg(List(2.0, 3, 1, 10, 4)))
  println(avg(List.empty))
  
  println(avgOfAngles(List(10, 350)))
  println(avgOfAngles(List(90, 180, 270, 360)))
  println(avgOfAngles(List(10, 20, 30)))
  
}