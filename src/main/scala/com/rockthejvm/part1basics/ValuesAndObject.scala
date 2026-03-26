package com.rockthejvm.part1basics

object ValuesAndObject {

  // values
  val meaningOfLife: Int = 42

  // reassigning is not allowed !
  // meaningOfLife = 45

  // type inference
  val anInteger = 67 // : Int is optional

  // common types
  val aBoolean: Boolean = false
  val aChar: Char = 'a'  // single quotes
  val anInt: Int = 78  // 4 bytes
  val aShort: Short = 5136  // 2 bytes
  val aLong: Long = 541694239L // 8 bytes
  val aFloat: Float = 2.4f  // 4 bytes
  val aDouble: Double = 3.14  // 8 bytes

  // string
  val aString: String = "Scala"  // double quotes

  def main(args: Array[String]): Unit = {

  }
}
