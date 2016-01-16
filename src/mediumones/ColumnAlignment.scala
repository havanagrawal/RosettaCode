/**
 * @author Havan
 */

package mediumones

import scala.io.Source
import java.io.File
import scala.annotation.tailrec

object ColumnAlignment extends App {

  private object AlignmentMode {
    val LEFT = 0
    val CENTER = 1
    val RIGHT = 2
    
    val AllModes = List(LEFT, CENTER, RIGHT)
  }

  def repeat(character: Char, n: Int) = character.toString * n

  def padWords(words: Array[String], desiredLength: Int, mode: Int): Array[String] = mode match {
    case AlignmentMode.LEFT => words.map { word =>
      word + repeat(' ', desiredLength - word.length)
    }
    case AlignmentMode.RIGHT => words.map { word =>
      repeat(' ', desiredLength - word.length) + word
    }
    case AlignmentMode.CENTER => words.map { word =>
      val totalPad = (desiredLength - word.length)
      val padLeft = totalPad / 2
      val padRight = totalPad - padLeft
      repeat(' ', padLeft) + word + repeat(' ', padRight)
    }
  }

  val path = "res/columnfile.txt"
  val lines = Source.fromFile(new File(path)).getLines

  val splitByDollar = lines.map(_.split('$')).toArray

  val lengthOfLongestWord = splitByDollar.flatten.map(_.size).max
  val widthOfColumn = lengthOfLongestWord + 1

  val alignments = AlignmentMode.AllModes.map{mode => 
    splitByDollar.map(padWords(_, widthOfColumn, mode))
  }

  println("Left aligned:")
  alignments(AlignmentMode.LEFT).foreach { line => println(line.mkString("|")) }

  println("\nCenter aligned:")
  alignments(AlignmentMode.CENTER).foreach { line => println(line.mkString("|")) }

  println("\nRight aligned:")
  alignments(AlignmentMode.RIGHT).foreach { line => println(line.mkString("|")) }
}

