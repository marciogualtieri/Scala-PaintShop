package com.zalando.paintshop.processors

import com.zalando.paintshop.formatters.PlainTextOutputFormatter
import com.zalando.paintshop.utils.TestHelper
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class PlainTextOutputFormatterTest extends FlatSpec with Matchers with BeforeAndAfter with TestHelper with PlainTextOutputFormatter {

  "Output formatter" should "return list of formatted solutions" in {
    format(TestCases, Solutions) should be (Outputs)
  }
}

