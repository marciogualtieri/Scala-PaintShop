package com.zalando.paintshop.parsers

import com.zalando.paintshop.exceptions.InputParserException
import com.zalando.paintshop.iterators.{InputIterator, PlainTextFileInputIterator}
import com.zalando.paintshop.utils.{ConcreteInputParser, TestHelper}
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class PlainTextInputParserTest extends FlatSpec with Matchers with BeforeAndAfter {

  "Input parser" should "parse plain text input into test cases" in {
    val inputParser = ConcreteInputParser()
    val inputIterator = PlainTextFileInputIterator(TestHelper.SUCCESS_INPUT_FILE)
    inputParser.parse(inputIterator) should be(TestHelper.TEST_CASES)
  }

  "Input parser" should "throw an exception when number of test cases is not a number" in {
    val inputParser = ConcreteInputParser()
    val inputIterator = PlainTextFileInputIterator(TestHelper.NUMBER_TEST_CASES_NOT_A_NUMBER_INPUT_FILE)
    verifyInputParserException(inputParser, inputIterator, TestHelper.NUMBER_TEST_CASES_NOT_A_NUMBER_MESSAGE)
  }

  "Input parser" should "throw an exception when number of colors is not a number" in {
    val inputParser = ConcreteInputParser()
    val inputIterator = PlainTextFileInputIterator(TestHelper.NUMBER_COLORS_NOT_A_NUMBER_INPUT_FILE)
    verifyInputParserException(inputParser, inputIterator, TestHelper.NUMBER_COLORS_NOT_A_NUMBER_MESSAGE)
  }

  "Input parser" should "throw an exception when number of customers is not a number" in {
    val inputParser = ConcreteInputParser()
    val inputIterator = PlainTextFileInputIterator(TestHelper.NUMBER_CUSTOMERS_NOT_A_NUMBER_INPUT_FILE)
    verifyInputParserException(inputParser, inputIterator, TestHelper.NUMBER_CUSTOMERS_NOT_A_NUMBER_MESSAGE)
  }

  "Input parser" should "throw an exception when customer has non numeric pairs" in {
    val inputParser = ConcreteInputParser()
    val inputIterator = PlainTextFileInputIterator(TestHelper.CUSTOMER_PAIRS_NOT_NUMBERS_INPUT_FILE)
    verifyInputParserException(inputParser, inputIterator, TestHelper.CUSTOMER_PAIRS_NOT_NUMBERS_MESSAGE)
  }

  "Input parser" should "throw an exception when customer has wrong number of pairs" in {
    val inputParser = ConcreteInputParser()
    val inputIterator = PlainTextFileInputIterator(TestHelper.MORE_THAN_ONE_MATTE_COLOR_INPUT_FILE)
    verifyInputParserException(inputParser, inputIterator, TestHelper.MORE_THAN_ONE_MATTE_COLOR_MESSAGE)
  }

  "Input parser" should "throw an exception when customer has invalid color" in {
    val inputParser = ConcreteInputParser()
    val inputIterator = PlainTextFileInputIterator(TestHelper.INVALID_COLOR_INPUT_FILE)
    verifyInputParserException(inputParser, inputIterator, TestHelper.INVALID_COLOR_INPUT_MESSAGE)
  }

  "Input parser" should "throw an exception when customer has invalid finish" in {
    val inputParser = ConcreteInputParser()
    val inputIterator = PlainTextFileInputIterator(TestHelper.INVALID_FINISH_INPUT_FILE)
    verifyInputParserException(inputParser, inputIterator, TestHelper.INVALID_FINISH_INPUT_MESSAGE)
  }

  private def verifyInputParserException(inputParser: InputParser, inputIterator: InputIterator, message: String) = {
    val thrown = intercept[InputParserException] {
      inputParser.parse(inputIterator)
    }
    thrown.getMessage should be(message)
  }
}

