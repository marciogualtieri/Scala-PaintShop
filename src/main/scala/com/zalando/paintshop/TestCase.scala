package com.zalando.paintshop

class TestCase(val numColors: Int, val customers: Array[Customer]) {
  override def toString: String = {
    "TestCase{numColors=%d, customers=[%s]}".format(numColors, customers.mkString(", "))
  }

  override def equals(that: Any): Boolean =
    that match {
      case that: TestCase => that.numColors == numColors &&
        that.customers.deep == customers.deep
      case _ => false
    }
}

object TestCase {
  def apply(numColors: Int, customers: Array[Customer]): TestCase = new TestCase(numColors, customers)
}
