package com.zalando.paintshop.parsers

import com.zalando.paintshop.exceptions.InputParserException
import com.zalando.paintshop.iterators.{InputIterator, PlainTextFileInputIterator}
import com.zalando.paintshop.utils.TestHelper
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class PlainTextInputParserTest extends FlatSpec with Matchers with BeforeAndAfter  with TestHelper
  with PlainTextInputParser {

  "Input parser" should "parse plain text input into test cases" in {
    val inputIterator = PlainTextFileInputIterator(SuccessInputFile)
    parse(inputIterator) should be(TestCases)
  }

  "Input parser" should "throw an exception when number of test cases is not a number" in {
    val inputIterator = PlainTextFileInputIterator(NumberTestCasesNotANumberInputFile)
    verifyInputParserException(inputIterator, NumberTestCasesNotANumberMessage)
  }

  "Input parser" should "throw an exception when number of colors is not a number" in {
    val inputIterator = PlainTextFileInputIterator(NumberColorsNotANumberInputFile)
    verifyInputParserException(inputIterator, NumberColorsNotANumberMessage)
  }

  "Input parser" should "throw an exception when number of customers is not a number" in {
    val inputIterator = PlainTextFileInputIterator(NumberCustomersNotANumberInputFile)
    verifyInputParserException(inputIterator, NumberCustomersNotANumberMessage)
  }

  "Input parser" should "throw an exception when customer has non numeric pairs" in {
    val inputIterator = PlainTextFileInputIterator(CustomerPairsNotNumbersInputFile)
    verifyInputParserException(inputIterator, CustomerPairsNotNumbersMessage)
  }

  "Input parser" should "throw an exception when customer has wrong number of pairs" in {
    val inputIterator = PlainTextFileInputIterator(MoreThanOneMatteColorInputFile)
    verifyInputParserException(inputIterator, MoreThanOneMatteColorMessage)
  }

  "Input parser" should "throw an exception when customer has invalid color" in {
    val inputIterator = PlainTextFileInputIterator(InvalidColorInputFile)
    verifyInputParserException(inputIterator, InvalidColorInputMessage)
  }

  "Input parser" should "throw an exception when customer has invalid finish" in {
    val inputIterator = PlainTextFileInputIterator(InvalidFinishInputFile)
    verifyInputParserException(inputIterator, InvalidFinishInputMessage)
  }

  private def verifyInputParserException(inputIterator: InputIterator, message: String) = {
    val thrown = intercept[InputParserException] {
      parse(inputIterator)
    }
    thrown.getMessage should be(message)
  }
}

