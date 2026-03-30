package com.rockthejvm.part2oop

import scala.language.postfixOps

object MethodNotation {
  class Person(val name: String, age: Int, favoriteMovie: String) {
    infix def likes(movie: String): Boolean =
      movie == favoriteMovie

    infix def +(person: Person): String =
      s"${this.name} is hanging out with ${person.name}"

    // in Scala 3, no need of the 'infix' keyword
    infix def !!(progLanguage: String): String =
      s"$name wonders how can $progLanguage be so cool!"

    // prefix position
    // unary ops: -, +, ~, !
    def unary_- : String =
      s"$name's alter ego"

    def isAlive: Boolean = true

    def apply(): String =
      s"Hi, my name is $name and I really enjoy $favoriteMovie"
  }

  val mary = new Person("Mary", 34, "Inception")
  val john = new Person("John", 36, "Fight Club")

  val negativeOne = -1

  def main(args: Array[String]): Unit = {
    println(mary.likes("Fight Club"))

    // Infix notation - available for methods with ONE arguments
    println(mary likes "Fight Club") // identical to previous line

    // "operator"
    println(mary + john)
    println(mary.+(john)) // identical
    println(2 + 3)
    println(2.+(3)) // same
    println(mary !! "Scala")

    // prefix position
    println(-mary)
    println(mary.unary_-)

    // postfix notation
    println(mary.isAlive)
    println(mary isAlive)  // discouraged

    // apply is special
    println(mary.apply())
    println(mary())  // same as above
  }

}
