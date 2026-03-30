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

    val charlesDickens = new Writer("Charles", "Dickens", 1812)
    val charlesDickensImpostor = new Writer("Charles", "Dickens", 2021)
    val novel = new Novel("Great Expectations", 1861, charlesDickens)
    val newEdition = novel.copy(1871)

    println(charlesDickens.fullName)
    println(novel.authorAge)
    println(novel.isWrittenBy(charlesDickens))
    println(novel.isWrittenBy(charlesDickensImpostor))
    println(newEdition.authorAge)
  }
}

class Writer(firstName: String, lastName: String, val yearOfBirth: Int) {
  def fullName: String = firstName + " " + lastName
}

class Novel(title: String, yearOfRelease: Int, author: Writer) {
  def authorAge: Int = this.yearOfRelease - author.yearOfBirth
  def isWrittenBy(author: Writer): Boolean = this.author == author
  def copy(newYear: Int): Novel = new Novel(title, newYear, author)
}

class Counter(count: Int = 0) {
  def increment(): Counter = {
    new Counter(count + 1)
  }

  def decrement(): Counter =
    if (count == 0) this
    else new Counter(count - 1)

  def increment(n: Int): Counter = {
    if (n <= 0) this
    else increment().increment(n - 1)  // vulnerable to stack overflows
  }

  def decrement(n: Int): Counter = {
    if (n <= 0) this
    else decrement().decrement(n - 1)
  }

  def print(): Unit =
    println(s"Current count: $count")
}
