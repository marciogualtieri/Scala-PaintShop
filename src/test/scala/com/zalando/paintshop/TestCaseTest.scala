package com.zalando.paintshop

import com.zalando.paintshop.utils.TestHelper
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class TestCaseTest extends FlatSpec with Matchers with BeforeAndAfter {

  val SOME_TEST_CASE = TestCase(1, Array(TestHelper.SOME_CUSTOMER))
  val SOME_TEST_CASE_TWIN = TestCase(1, Array(TestHelper.SOME_CUSTOMER_TWIN))
  val SOME_OTHER_TEST_CASE = TestCase(1, Array(TestHelper.SOME_OTHER_CUSTOMER))

  "Test case" should "be equal" in {
    SOME_TEST_CASE should be (SOME_TEST_CASE_TWIN)
  }

  "Test case" should "not be equal" in {
    SOME_TEST_CASE should not be (SOME_OTHER_TEST_CASE)
  }
}

