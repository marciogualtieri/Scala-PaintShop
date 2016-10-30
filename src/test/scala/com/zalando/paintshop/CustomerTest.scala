package com.zalando.paintshop

import com.zalando.paintshop.utils.TestHelper
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

import scala.collection.immutable.BitSet

class CustomerTest extends FlatSpec with Matchers with BeforeAndAfter with TestHelper {



  "Customer" should "be satisfied by all glossy batches" in {
    FirstColorGlossySecondColorMatteCustomer.isBatchesSatisfactory(AllColorGlossyBatches) should be (true)
  }

  "Customer" should "be satisfied by two first color matte batches" in {
    FirstColorGlossySecondColorMatteCustomer.isBatchesSatisfactory(FirstTwoColorsMatteBatches) should be (true)
  }

  "Customer" should "not be satisfied by first color matte batches" in {
    FirstColorGlossySecondColorMatteCustomer.isBatchesSatisfactory(FirstColorMatteBatches) should be (false)
  }

  "Customer" should "be equal" in {
    SomeCustomer should be (SomeCustomerTwin)
  }

  "Customer" should "not be equal" in {
    SomeCustomer should not be SomeOtherCustomer
  }

}

