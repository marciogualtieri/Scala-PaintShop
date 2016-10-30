package com.zalando.paintshop.utils

import com.zalando.paintshop.{TestCase, Customer}
import com.zalando.paintshop.constants.FieldNames
import com.zalando.paintshop.messages.ErrorMessages._
import org.apache.commons.io.FilenameUtils
import org.apache.commons.lang.SystemUtils

import scala.collection.immutable.BitSet

trait TestHelper {

  private val FirstColorMatteCustomer = new Customer(BitSet(), Some(0))
  private val FirstAndSecondColorGlossyCustomer = new Customer(BitSet(0, 1), None)
  private val FifthColorGlossyCustomer = new Customer(BitSet(4), None)
  private val FistColorGlossyCustomer = new Customer(BitSet(0), None)

  private val firstTestCase = new TestCase(5, Array(FirstColorMatteCustomer, FirstAndSecondColorGlossyCustomer,
    FifthColorGlossyCustomer))
  private val secondTestCase = new TestCase(1, Array(FistColorGlossyCustomer, FirstColorMatteCustomer))

  val TestCases = Array(firstTestCase, secondTestCase)
  val Solutions = Array(Some(BitSet(0)), None)
  val Outputs = List("Case #1: 1 0 0 0 0", "Case #2: IMPOSSIBLE")

  val FirstColorGlossySecondColorMatteCustomer = Customer(BitSet(0), Some(1))
  val AllColorGlossyBatches = BitSet()
  val FirstColorMatteBatches = BitSet(0)
  val FirstTwoColorsMatteBatches = BitSet(0, 1)

  val SomeCustomer = Customer(BitSet(0, 1, 2), Some(3))
  val SomeCustomerTwin = Customer(BitSet(0, 1, 2), Some(3))
  val SomeOtherCustomer = Customer(BitSet(3, 4, 5), Some(6))

  val SuccessInputFile = FilenameUtils.separatorsToSystem("src/test/resources/inputs/success.txt")
  val NonExistentFile = FilenameUtils.separatorsToSystem("i/do/not.exist")
  val UnexpectedEofEndOfFile =
    FilenameUtils.separatorsToSystem("src/test/resources/inputs/unexpected_end_of_file.txt")
  val NumberTestCasesNotANumberInputFile =
    FilenameUtils.separatorsToSystem("src/test/resources/inputs/number_test_cases_not_a_number.txt")
  val NumberColorsNotANumberInputFile =
    FilenameUtils.separatorsToSystem("src/test/resources/inputs/number_colors_not_a_number.txt")
  val NumberCustomersNotANumberInputFile =
    FilenameUtils.separatorsToSystem("src/test/resources/inputs/number_customers_not_a_number.txt")
  val CustomerPairsNotNumbersInputFile =
    FilenameUtils.separatorsToSystem("src/test/resources/inputs/customer_pairs_not_numbers.txt")
  val IncorrectNumberOfPairsInputFile =
    FilenameUtils.separatorsToSystem("src/test/resources/inputs/incorrect_number_of_pairs.txt")
  val MoreThanOneMatteColorInputFile =
    FilenameUtils.separatorsToSystem("src/test/resources/inputs/customer_with_more_than_one_matte_color.txt")
  val InvalidColorInputFile =
    FilenameUtils.separatorsToSystem("src/test/resources/inputs/invalid_color_code.txt")
  val InvalidFinishInputFile =
    FilenameUtils.separatorsToSystem("src/test/resources/inputs/invalid_finish_code.txt")

  val Lines = scala.io.Source.fromFile(SuccessInputFile).getLines.toList

  private val InputFileDoesNotExistWindowsMessage = "%s (The system cannot find the path specified)"
    .format(NonExistentFile)
  private val InputFileDoesNotExistUnixMessage = "%s (No such file or directory)"
    .format(NonExistentFile)

  val InputFileDoesNotExistMessage = if (SystemUtils.IS_OS_WINDOWS) InputFileDoesNotExistWindowsMessage
  else InputFileDoesNotExistUnixMessage

  val NumberTestCasesNotANumberMessage = notNumberErrorMessage(FieldNames.NUMBER_TEST_CASES, ("X", 1))
  val NumberColorsNotANumberMessage = notNumberErrorMessage(FieldNames.NUMBER_COLORS, ("X", 2))
  val NumberCustomersNotANumberMessage = notNumberErrorMessage(FieldNames.NUMBER_CUSTOMERS, ("X", 3))
  val CustomerPairsNotNumbersMessage = nonNumericPairsErrorMessage(("2 1 0 X 0", 5))
  val IncorrectNumberOfPairsMessage = invalidNumberPairsErrorMessage(("2 1 1", 4))
  val MoreThanOneMatteColorMessage = moreThanOneMatteErrorMessage(("2 1 1 2 1", 5))
  val InvalidColorInputMessage = invalidColorCodeErrorMessage(5, ("1 6 1", 4))
  val InvalidFinishInputMessage = invalidFinishCodeErrorMessage(("1 1 3"), 4)
}

