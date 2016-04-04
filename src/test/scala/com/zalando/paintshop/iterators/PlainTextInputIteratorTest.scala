package com.zalando.paintshop.iterators

import com.zalando.paintshop.exceptions.InputIteratorException
import com.zalando.paintshop.messages.ErrorMessages
import com.zalando.paintshop.utils.TestHelper
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class PlainTextInputIteratorTest extends FlatSpec with Matchers with BeforeAndAfter {

  "Iterator" should "should return all file lines" in {
    val inputIterator = PlainTextFileInputIterator(TestHelper.SUCCESS_FROM_SPEC_INPUT_FILE)
    val lines = inputIterator.toList
    lines.toList should be(TestHelper.LINES)
  }

  "Iterator" should "should return correct line numbers" in {
    val inputIterator = PlainTextFileInputIterator(TestHelper.SUCCESS_FROM_SPEC_INPUT_FILE)
    inputIterator.readLine should be(("2", 1))
    inputIterator.readLine should be(("5", 2))
    inputIterator.readLine should be(("3", 3))
  }

  "Input iterator" should "throw an exception when file does not exist" in {
    val thrown = intercept[InputIteratorException] {
      PlainTextFileInputIterator(TestHelper.NON_EXISTENT_FILE)
    }
    thrown.getMessage should be(TestHelper.INPUT_FILE_DOES_NOT_EXIST_MESSAGE)
  }

  "Input iterator" should "throw an exception when file ends unexpectedly" in {
    val thrown = intercept[InputIteratorException] {
      val inputIterator = PlainTextFileInputIterator(TestHelper.UNEXPECTED_EOF_INPUT_FILE)
      inputIterator.readLine
    }
    thrown.getMessage should be(ErrorMessages.UNEXPECTED_EOF_ERROR_MESSAGE)
  }
}