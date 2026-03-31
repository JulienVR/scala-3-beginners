package com.rockthejvm.practice

import scala.annotation.tailrec
import scala.runtime.Nothing$

// singly linked list
// [1,2,3] = [1] -> [2] -> [3] -> |
abstract class LList {
  def head: Int
  def tail: LList
  def isEmpty: Boolean
  def add(element: Int): LList

  override def toString: String = super.toString
}

class Empty extends LList {
  override def head: Int = throw new NoSuchElementException
  override def tail: LList = throw new NoSuchElementException
  override def isEmpty: Boolean = true
  override def add(element: Int): LList = new Cons(element, this)
  override def toString: String = "|"
}

class Cons(override val head: Int, override val tail: LList) extends LList {
  override def isEmpty: Boolean = false
  override def add(element: Int): LList = new Cons(element, this)

  //  override def toString: String = s"$head -> ${this.tail.toString()}"
  override def toString: String = {
    @tailrec
    def concatenateElements(remainder: LList, acc: String): String =
      if (remainder.isEmpty) acc
      else concatenateElements(remainder.tail, s"$acc, ${remainder.head}")

    s"[${concatenateElements(this.tail, s"$head")}]"
  }
}

object LListTest {
  def main(args: Array[String]): Unit = {
    val list1 =  new Cons(2, new Cons(1, new Empty))
    println(list1.toString())

    val list2 = (new Empty).add(1).add(2)
    println(list2.toString())
  }
}
