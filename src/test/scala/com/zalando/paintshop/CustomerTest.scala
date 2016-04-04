package com.zalando.paintshop

import com.zalando.paintshop.utils.TestHelper
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

import scala.collection.immutable.BitSet

class CustomerTest extends FlatSpec with Matchers with BeforeAndAfter {

  val FIRST_COLOR_MATTE_SECOND_COLOR_GLOSSY_CUSTOMER = Customer(BitSet(0), Some(1))
  val ALL_COLORS_GLOSSY_BATCHES = BitSet()
  val FIRST_COLOR_MATTE_BATCHES = BitSet(0)
  val FIRST_TWO_COLORS_MATTE_BATCHES = BitSet(0, 1)

  "Customer" should "be satisfied by all glossy batches" in {
    FIRST_COLOR_MATTE_SECOND_COLOR_GLOSSY_CUSTOMER.isBatchesSatisfactory(ALL_COLORS_GLOSSY_BATCHES) should be (true)
  }

  "Customer" should "be satisfied by two first color matte batches" in {
    FIRST_COLOR_MATTE_SECOND_COLOR_GLOSSY_CUSTOMER.isBatchesSatisfactory(FIRST_TWO_COLORS_MATTE_BATCHES) should be (true)
  }

  "Customer" should "not be satisfied by first color matte batches" in {
    FIRST_COLOR_MATTE_SECOND_COLOR_GLOSSY_CUSTOMER.isBatchesSatisfactory(FIRST_COLOR_MATTE_BATCHES) should be (false)
  }

  "Customer" should "be equal" in {
    TestHelper.SOME_CUSTOMER should be (TestHelper.SOME_CUSTOMER_TWIN)
  }

  "Customer" should "not be equal" in {
    TestHelper.SOME_CUSTOMER should not be TestHelper.SOME_OTHER_CUSTOMER
  }

}

