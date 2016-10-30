package com.zalando.paintshop.app

import java.io.File

import com.zalando.paintshop.utils.TestHelper
import org.scalatest.{Matchers, BeforeAndAfter, FlatSpec}

class PaintShopTest extends FlatSpec with Matchers with BeforeAndAfter with TestHelper {

  "Paint shop" should "should return solutions for success input" in {
    val outputs = PaintShop.execute(new File(SuccessInputFile))
    outputs should be(Outputs)
  }
}

