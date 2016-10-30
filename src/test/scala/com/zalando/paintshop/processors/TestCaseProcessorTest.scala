package com.zalando.paintshop.processors

import com.zalando.paintshop.utils.{ConcreteTestCaseProcessor, TestHelper}
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class TestCaseProcessorTest extends FlatSpec with Matchers with BeforeAndAfter with TestHelper {

  "Test case processor" should "return solutions for each test case" in {
    val testCaseProcessor = new ConcreteTestCaseProcessor()
    testCaseProcessor.process(TestCases) should be(Solutions)
  }
}

