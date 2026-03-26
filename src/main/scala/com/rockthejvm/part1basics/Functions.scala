package com.rockthejvm.part1basics

object Functions {
  // a function is actually always one expression (with or without the curly braces)
  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  val aFunctionInvocation = aFunction("Scala", 999999)

  // 2 styles when no arguments
  def aNoArgFunction(): Int = 45
  def aParameterlessFunction: Int = 45

  // functions can be recursive
  def stringConcatenation(str: String, n: Int): String = {
    if (n == 0) ""
    else if (n == 1) str
    else str + stringConcatenation(str, n - 1)
  }

  val scalax3 = stringConcatenation("Scala", 3)

  // "void" functions
  def aVoidFunction(aString: String): Unit =
    println(aString)

  def computeDoubleStringWithSideEffect(aString: String): String = {
    aVoidFunction(aString) // Unit
    aString + aString // meaningful value
  }  // it is discouraged to have side effects

  def aBigFunction(n: Int): Int = {
    // small, auxiliary functions inside
    def aSmallerFunction(a: Int, b: Int): Int = a + b
    aSmallerFunction(n, n+1)
  }

  /**
   * Exercises
   * 1. A greeting function (name, age) => "Hi my name is $name and I am $age years old."
   * 2. Factorial function n => 1 * 2 * 3 * .. * n
   * 3. Fibonacci function
   *    fib(1) = 1
   *    fib(2) = 1
   *    fib(3) = 1 + 1
   *    fib(n) = fib(n-1) + fib(n-2)
   * 4. tests if a number is prime
   */

  def greeting(name: String, age: Int): String = {
    s"Hi my name is $name and I am $age years old."
  }

  def factorial(n: Int): Int = {
    if (n <= 0) 0
    else if (n == 1) 1
    else n * factorial(n - 1)
  }

  def fibonacci(n: Int): Int = {
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)
    isPrimeUntil(n / 2)  // integer division
  }

  def main(args: Array[String]): Unit = {
    println(greeting("Julien", 42))
    println(factorial(5))
    println(fibonacci(4))
    println(isPrime(7))
  }
}
