package com.zalando.paintshop.processors

import com.zalando.paintshop.utils.{ConcretePlainTextOutputFormatter, TestHelper, ConcreteTestCaseProcessor}
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class PlainTextOutputFormatterTest extends FlatSpec with Matchers with BeforeAndAfter with TestHelper {

  "Output formatter" should "return list of formatted solutions" in {
    val outputFormatter = new ConcretePlainTextOutputFormatter()
    val outputs = outputFormatter.format(TestCases, Solutions)
    outputs should be (Outputs)
  }
}

