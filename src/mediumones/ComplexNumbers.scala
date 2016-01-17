/**
 * @author Havan
 */

package mediumones

import util.Complex

object ComplexNumbers extends App {
  val c = Complex(2, 4)
  val d = Complex(2, 3)
  val e = Complex(4, 5)
  val origin = Complex(0, 0)
  
  println(c)
  println(c.conjugate)
  println(c.inverse)
  println(d * e)
  println(Complex(4, 2)/Complex(3, -1))
  println(origin)
  println(origin.conjugate)
  println(origin.inverse)
}