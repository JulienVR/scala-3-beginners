package com.rockthejvm.part1basics

object StringOps {

  val aString: String = "Hello, I am learning Scala"

  // string functions
  val secondChar = aString.charAt(1)
  val firstWord = aString.substring(0, 5) // "Hello"
  val words = aString.split(" ") // Array("Hello", "I", "am", "learning", "Scala")
  val startWithHello = aString.startsWith("Hello") // true
  val allDashes = aString.replace(' ', '-')
  val allUppercase = aString.toUpperCase() // also toLowerCase
  val nChars = aString.length

  // other functions
  val reversed = aString.reverse
  val aBunchOfChars = aString.take(10)

  // parse to numeric
  val numberAsString = "2"
  val number = numberAsString.toInt

  // interpolation
  val name = "Alice"
  val age = 12
  val greeting_v1 = "Hello, I'm " + name + " and I'm " + age + " years old."
  val greeting_v2 = s"Hello, I'm $name and I'm $age years old."
  val greeting_v3 = s"Hello, I'm $name and I'm ${age + 1} years old."

  // f-interpolation
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minutes." // -> "... eat 1.20 burger ..."

  // raw interpolation
  val escapes = raw"This is a \n newline" // no line break with the "raw"

  def main(args: Array[String]): Unit = {
    println(escapes)
  }
}
