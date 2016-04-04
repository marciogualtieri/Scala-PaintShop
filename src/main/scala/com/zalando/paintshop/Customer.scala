package com.zalando.paintshop

import scala.collection.BitSet

class Customer(val glossies: BitSet, val matte: Option[Int]) {

  def isBatchesSatisfactory(batches: BitSet): Boolean = {
    satisfiedGlossyColors(batches) > 0 || isMatteColorSatisfied(batches)
  }

  def satisfiedGlossyColors(batches: BitSet): Int = {
    val satisfiedColorBits = (batches & glossies) ^ glossies
    satisfiedColorBits.count(satisfiedColorBits(_) == true)
  }

  def isMatteColorSatisfied(batches: BitSet): Boolean = {
    matte.isDefined && batches(matte.get)
  }

  override def toString: String = {
    "Customer{glossies=%s, matte=%s}".format(glossies, matte)
  }

  override def equals(that: Any): Boolean =
    that match {
      case that: Customer => that.glossies == glossies &&
        that.matte == matte
      case _ => false
    }
}

object Customer {
  def apply(glossies: BitSet, matte: Option[Int]): Customer = new Customer(glossies, matte)
}