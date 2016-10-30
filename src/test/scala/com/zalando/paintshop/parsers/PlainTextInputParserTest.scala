package com.zalando.paintshop.parsers

import com.zalando.paintshop.exceptions.InputParserException
import com.zalando.paintshop.iterators.{InputIterator, PlainTextFileInputIterator}
import com.zalando.paintshop.utils.{ConcreteInputParser, TestHelper}
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class PlainTextInputParserTest extends FlatSpec with Matchers with BeforeAndAfter  with TestHelper {

  "Input parser" should "parse plain text input into test cases" in {
    val inputParser = ConcreteInputParser()
    val inputIterator = PlainTextFileInputIterator(SuccessInputFile)
    inputParser.parse(inputIterator) should be(TestCases)
  }

  "Input parser" should "throw an exception when number of test cases is not a number" in {
    val inputParser = ConcreteInputParser()
    val inputIterator = PlainTextFileInputIterator(NumberTestCasesNotANumberInputFile)
    verifyInputParserException(inputParser, inputIterator, NumberTestCasesNotANumberMessage)
  }

  "Input parser" should "throw an exception when number of colors is not a number" in {
    val inputParser = ConcreteInputParser()
    val inputIterator = PlainTextFileInputIterator(NumberColorsNotANumberInputFile)
    verifyInputParserException(inputParser, inputIterator, NumberColorsNotANumberMessage)
  }

  "Input parser" should "throw an exception when number of customers is not a number" in {
    val inputParser = ConcreteInputParser()
    val inputIterator = PlainTextFileInputIterator(NumberCustomersNotANumberInputFile)
    verifyInputParserException(inputParser, inputIterator, NumberCustomersNotANumberMessage)
  }

  "Input parser" should "throw an exception when customer has non numeric pairs" in {
    val inputParser = ConcreteInputParser()
    val inputIterator = PlainTextFileInputIterator(CustomerPairsNotNumbersInputFile)
    verifyInputParserException(inputParser, inputIterator, CustomerPairsNotNumbersMessage)
  }

  "Input parser" should "throw an exception when customer has wrong number of pairs" in {
    val inputParser = ConcreteInputParser()
    val inputIterator = PlainTextFileInputIterator(MoreThanOneMatteColorInputFile)
    verifyInputParserException(inputParser, inputIterator, MoreThanOneMatteColorMessage)
  }

  "Input parser" should "throw an exception when customer has invalid color" in {
    val inputParser = ConcreteInputParser()
    val inputIterator = PlainTextFileInputIterator(InvalidColorInputFile)
    verifyInputParserException(inputParser, inputIterator, InvalidColorInputMessage)
  }

  "Input parser" should "throw an exception when customer has invalid finish" in {
    val inputParser = ConcreteInputParser()
    val inputIterator = PlainTextFileInputIterator(InvalidFinishInputFile)
    verifyInputParserException(inputParser, inputIterator, InvalidFinishInputMessage)
  }

  private def verifyInputParserException(inputParser: InputParser, inputIterator: InputIterator, message: String) = {
    val thrown = intercept[InputParserException] {
      inputParser.parse(inputIterator)
    }
    thrown.getMessage should be(message)
  }
}

