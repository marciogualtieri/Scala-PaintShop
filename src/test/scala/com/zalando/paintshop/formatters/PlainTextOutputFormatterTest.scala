package com.zalando.paintshop.processors

import com.zalando.paintshop.utils.{ConcretePlainTextOutputFormatter, TestHelper, ConcreteTestCaseProcessor}
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class PlainTextOutputFormatterTest extends FlatSpec with Matchers with BeforeAndAfter {

  "Output formatter" should "return list of formatted solutions" in {
    val outputFormatter = new ConcretePlainTextOutputFormatter()
    val outputs = outputFormatter.format(TestHelper.TEST_CASES, TestHelper.SOLUTIONS)
    outputs should be (TestHelper.OUTPUTS)
  }
}

