package com.zalando.paintshop.processors

import com.zalando.paintshop.utils.{ConcreteSimpleOutputFormatter, TestHelper, ConcreteTestCaseProcessor}
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class SimpleOutputFormatterTest extends FlatSpec with Matchers with BeforeAndAfter {

  "Output formatter" should "return list of formatted solutions" in {
    val outputFormatter = new ConcreteSimpleOutputFormatter()
    val outputs = outputFormatter.format(TestHelper.TEST_CASES, TestHelper.SOLUTIONS)
    outputs should be (TestHelper.OUTPUTS)
  }
}

