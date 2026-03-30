package com.rockthejvm.part2oop

object AbstractDataTypes {

  abstract class Animal {
    val creatureType: String  // abstract
    def eat(): Unit
    // non-abstract fields ('val') / methods ('def') is allowed in abstract classes
    def preferredMeal: String = "anything" // "accessor methods" = methods without args or parentheses
  }

  // not legal: cannot instantiate an abstract class
  // val anAnimal: Animal = new Animal

  // non-abstract classes must implement the abstract fields/methods
  class Dog extends Animal {
    override val creatureType: String = "domestic"
    override def eat(): Unit = println("crunching this bone")
    // overriding is legal for everything
    override val preferredMeal: String = "bones" // overriding accessor method with a field
  }

  val aDog: Animal = new Dog

  // traits (similar to interface in Java, may or may not contain implementation)
  trait Carnivore {  // traits can have constructor args
    def eat(animal: Animal): Unit
  }

  class TRex extends Carnivore {
    override def eat(animal: Animal): Unit = println("I'm a T-Rex, I eat animals")
  }

  // practical difference
  // only one class inheritance
  // but multiple traits inheritance is possible
  trait ColdBlood

  class Crocodile extends Animal with Carnivore with ColdBlood {
    override val creatureType: String = "croc"
    override def eat(): Unit = println("I'm a croc, I just crunch stuff")
    override def eat(animal: Animal): Unit = println("croc eating animal")
  }

  /*
  philosophical difference between abstract classes and traits
  - abstract classes are THINGS
  - traits are BEHAVIORS
   */

  /*
  Classes hierarchy in Scala (see screenshot)

  Any
    AnyRef
      All classes we write (they extend AnyRef)
        scala.Null (the null reference) (null extends all the classes we write)
    AnyVal
      Int, Boolean, Char ... (they extend AnyVal)

        scala.Nothing (under any type in Scala)
   */

  val aNonExistentAnimal: Animal = null
  val anInt: Int = throw new NullPointerException()

  def main(args: Array[String]): Unit = {

  }
}
