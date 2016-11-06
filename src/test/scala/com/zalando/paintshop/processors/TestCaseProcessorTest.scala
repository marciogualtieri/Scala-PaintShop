package com.zalando.paintshop.processors

import com.zalando.paintshop.utils.TestHelper
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class TestCaseProcessorTest extends FlatSpec with Matchers with BeforeAndAfter with TestHelper with TestCaseProcessor {

  "Test case processor" should "return solutions for each test case" in {
    process(TestCases) should be (Solutions)
  }
}

