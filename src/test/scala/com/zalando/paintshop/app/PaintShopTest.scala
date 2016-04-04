package com.zalando.paintshop.app

import java.io.File

import com.zalando.paintshop.utils.TestHelper
import org.scalatest.{Matchers, BeforeAndAfter, FlatSpec}

class PlainTextInputIteratorTest extends FlatSpec with Matchers with BeforeAndAfter {

  "Paint shop" should "should return solutions for success input" in {
    val outputs = PaintShop.execute(new File(TestHelper.SUCCESS_INPUT_FILE))
    outputs should be(TestHelper.OUTPUTS)
  }
}

