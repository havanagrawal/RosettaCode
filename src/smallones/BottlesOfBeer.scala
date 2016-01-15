

package smallones/**
 * @author Havan
 */
object BottlesOfBeer extends App {
  val line1 = "bottles of beer on the wall"
  val line2 = "bottles of beer"
  val line3 = "Take one down, pass it around"
  val n = 99

  (n to 0 by -1).foreach { noOfBottles =>
    noOfBottles match {
      case 0 => println(s"No more ${line1}, \nno more ${line2}\nGo to the store and buy some more,\n$n $line1")
      case _ => println(s"$noOfBottles ${line1},\n$noOfBottles $line2\n$line3\n${noOfBottles - 1} $line1\n")
    }
  }
}