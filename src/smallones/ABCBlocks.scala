/**
 * @author Havan
 */

package smallones


class Block(letter1: Char, letter2: Char) {
  def hasLetter(letter: Char) = letter1 == letter || letter2 == letter
}

object Block {
  def apply(letter1: Char, letter2: Char) = new Block(letter1, letter2)
}

object ABCBlocks extends App {
  val allBlocks = Set[Block](Block('B', 'O'),
    Block('X', 'K'),
    Block('D', 'Q'),
    Block('C', 'P'),
    Block('N', 'A'),
    Block('G', 'T'),
    Block('R', 'E'),
    Block('T', 'G'),
    Block('Q', 'D'),
    Block('F', 'S'),
    Block('J', 'W'),
    Block('H', 'U'),
    Block('V', 'I'),
    Block('A', 'N'),
    Block('O', 'B'),
    Block('E', 'R'),
    Block('F', 'S'),
    Block('L', 'Y'),
    Block('P', 'C'),
    Block('Z', 'M'))

  def canSpellThisWord(word: String, allBlocks: Set[Block]): Boolean = {
    if (word.isEmpty) true
    else if (word.length > allBlocks.size) false
    else {
      val firstLetter = word.head 
      val hasThisLetter = allBlocks.filter(_.hasLetter(firstLetter))
      
      if (!hasThisLetter.isEmpty) {
        hasThisLetter.par.map{usedBlock =>  
          canSpellThisWord(word.tail, allBlocks - usedBlock)}
        .foldLeft(false)((a, b) => a || b)
      }
      else false
    }
  }
  
  for (word <- io.Source.stdin.getLines) 
    println(canSpellThisWord(word.toUpperCase, allBlocks))
}
