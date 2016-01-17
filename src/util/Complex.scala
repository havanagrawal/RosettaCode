package util

import scala.math._

/**
 * @author Havan
 */
class Complex(val real: Double, val imag: Double) {
  def +(that: Complex) = Complex(this.real + that.real, this.imag + that.imag)

  def unary_- = Complex(-this.real, -this.imag)

  def -(that: Complex) = this + (-that)

  def *(that: Complex) =
    Complex(
      this.real * that.real - this.imag * that.imag,
      this.real * that.imag + this.imag * that.real)

  def /(that: Complex): Complex = (this * that.conjugate) / that.absSquare

  def /(num: Double): Complex = Complex(this.real / num, this.imag / num)

  lazy val conjugate = Complex(this.real, -this.imag)

  private lazy val absSquare = real * real + imag * imag
  lazy val abs = sqrt(absSquare)

  lazy val inverse = this.conjugate / absSquare

  override def toString() = {
    val sign =
      if (imag < 0) " - "
      else " + "

    real + sign + math.abs(imag) + "i"
  }
}

object Complex {
  def apply(r: Double, i: Double) = new Complex(r, i)
  def apply(r: Double) = new Complex(r, 0)
  
  lazy val ORIGIN = Complex(0, 0)
}