package com.rockthejvm.part2oop

object OOBasics {

  // classes
  class Person(val name: String, age: Int = 0) { // constructor signature
    // fields
    val allCaps = name.toUpperCase()

    // methods
    def greet(name: String): String =
      s"${this.name} says: Hi, $name"  // here, $name is the parameter (closest) !

    // signature differs
    // OVERLOADING
    def greet(): String =
      s"Hi, everyone, my name is $name"  // here, $name refers to the constructor value (closest) !

    // defining auxiliary constructor
    def this(name: String) =
      this(name, 0)  // refers to the upper constructor

    // another aux constructor
    def this() =
      this("Jane Doe")

    // not super useful since you can pass constructor default arguments, so don't use aux constructors
  }

  val aPerson: Person = new Person("John", 26)
  val john = aPerson.name // class parameter != field class Person(name: String, age: Int) VS class Person(val name: String, age: Int)
  val johnYelling = aPerson.allCaps
  val johnSayHiToDaniel = aPerson.greet("Daniel")

  def main(args: Array[String]): Unit = {
    println(johnSayHiToDaniel)
    println(aPerson.greet())
  }
}
