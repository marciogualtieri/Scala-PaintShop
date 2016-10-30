package com.zalando.paintshop

import com.zalando.paintshop.utils.TestHelper
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class TestCaseTest extends FlatSpec with Matchers with BeforeAndAfter with TestHelper {

  val SomeTestCase = TestCase(1, Array(SomeCustomer))
  val SomeTestCaseTwin = TestCase(1, Array(SomeCustomerTwin))
  val SomeOtherTestCase = TestCase(1, Array(SomeOtherCustomer))

  "Test case" should "be equal" in {
    SomeTestCase should be (SomeTestCaseTwin)
  }

  "Test case" should "not be equal" in {
    SomeTestCase should not be (SomeOtherTestCase)
  }
}

