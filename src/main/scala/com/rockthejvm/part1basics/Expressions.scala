package com.rockthejvm.part1basics

object Expressions {

  // expressions are structures that can be evaluated to a value
  val meaningOfLife = 40 + 2

  // mathematical expressions: +, -, *, /, bitwise |, &, <<, >>, >>>
  val mathExpression = 2+3*4

  // comparison expressions: <, <=, >, >=, ==, !=
  val equalityTest = 1 == 2

  // boolean expressions: !, ||, &&
  val nonEqualityTest = !equalityTest

  // instructions (imperative programming) vs expressions (scala)
  // expressions are evaluated, instructions are executed
  // we think in terms of expressions

  // ifs are expressions
  val aCondition = true
  val anIfexpression = if (aCondition) 45 else 99

  // code blocks (one big expression)
  val aCodeBlock = {
    // local values
    val localValue = 78
    // expressions...
    // last expression = value of the block
    localValue + 54
  }

  // everything is an expression

  /**
   * Exercise:
   *  Without running the code, what do yout hink these values will print out ?
   * @param args
   */
  // 1
  val someValue = {
    2 < 3
  } // true

  // 2
  val someOtherValue = {
    if (someValue) 239 else 986
    42
  } // 42

  // 3
  val yetAnotherValue = println("Scala") // will print "Scala" to the console, and returns a type "Unit"
  val theUnit: Unit = () // the only possible value of Unit is ()

  def main(args: Array[String]): Unit = {
    println(yetAnotherValue)
  }
}
