package com.zalando.paintshop.utils

import com.zalando.paintshop.constants.FieldNames
import com.zalando.paintshop.{TestCase, Customer}

import scala.collection.immutable.BitSet
import com.zalando.paintshop.messages.ErrorMessages._

object TestHelper {

  private val fistColorMatteCustomer = new Customer(BitSet(), Some(0))
  private val fistAndSecondColorGlossyCustomer = new Customer(BitSet(0, 1), None)
  private val fifthColorGlossyCustomer = new Customer(BitSet(4), None)
  private val fistColorGlossyCustomer = new Customer(BitSet(0), None)

  private val firstTestCase = new TestCase(5, Array(fistColorMatteCustomer, fistAndSecondColorGlossyCustomer,
    fifthColorGlossyCustomer))
  private val secondTestCase = new TestCase(1, Array(fistColorGlossyCustomer, fistColorMatteCustomer))

  val TEST_CASES = Array(firstTestCase, secondTestCase)
  val SOLUTIONS = Array(Some(BitSet(0)), None)
  val OUTPUTS = List("Case #1: 1 0 0 0 0", "Case #2: IMPOSSIBLE")

  val SOME_CUSTOMER = Customer(BitSet(0, 1, 2), Some(3))
  val SOME_CUSTOMER_TWIN = Customer(BitSet(0, 1, 2), Some(3))
  val SOME_OTHER_CUSTOMER = Customer(BitSet(3, 4, 5), Some(6))

  val SUCCESS_INPUT_FILE = "src/test/resources/inputs/success.txt"
  val NON_EXISTENT_FILE: String = "i/do/not.exist"
  val UNEXPECTED_EOF_INPUT_FILE = "src/test/resources/inputs/unexpected_end_of_file.txt"
  val NUMBER_TEST_CASES_NOT_A_NUMBER_INPUT_FILE = "src/test/resources/inputs/number_test_cases_not_a_number.txt"
  val NUMBER_COLORS_NOT_A_NUMBER_INPUT_FILE = "src/test/resources/inputs/number_colors_not_a_number.txt"
  val NUMBER_CUSTOMERS_NOT_A_NUMBER_INPUT_FILE = "src/test/resources/inputs/number_customers_not_a_number.txt"
  val CUSTOMER_PAIRS_NOT_NUMBERS_INPUT_FILE = "src/test/resources/inputs/customer_pairs_not_numbers.txt"
  val INCORRECT_NUMBER_OF_PAIRS_INPUT_FILE = "src/test/resources/inputs/incorrect_number_of_pairs.txt"
  val MORE_THAN_ONE_MATTE_COLOR_INPUT_FILE =
    "src/test/resources/inputs/customer_with_more_than_one_matte_color.txt"
  val INVALID_COLOR_INPUT_FILE = "src/test/resources/inputs/invalid_color_code.txt"
  val INVALID_FINISH_INPUT_FILE = "src/test/resources/inputs/invalid_finish_code.txt"

  val LINES = scala.io.Source.fromFile(SUCCESS_INPUT_FILE).getLines.toList
  val INPUT_FILE_DOES_NOT_EXIST_MESSAGE = "%s (No such file or directory)".format(NON_EXISTENT_FILE)
  val NUMBER_TEST_CASES_NOT_A_NUMBER_MESSAGE = notNumberErrorMessage(FieldNames.NUMBER_TEST_CASES, ("X", 1))
  val NUMBER_COLORS_NOT_A_NUMBER_MESSAGE = notNumberErrorMessage(FieldNames.NUMBER_COLORS, ("X", 2))
  val NUMBER_CUSTOMERS_NOT_A_NUMBER_MESSAGE = notNumberErrorMessage(FieldNames.NUMBER_CUSTOMERS, ("X", 3))
  val CUSTOMER_PAIRS_NOT_NUMBERS_MESSAGE = nonNumericPairsErrorMessage(("2 1 0 X 0", 5))
  val INCORRECT_NUMBER_OF_PAIRS_MESSAGE = invalidNumberPairsErrorMessage(("2 1 1", 4))
  val MORE_THAN_ONE_MATTE_COLOR_MESSAGE = moreThanOneMatteErrorMessage(("2 1 1 2 1", 5))
  val INVALID_COLOR_INPUT_MESSAGE = invalidColorCodeErrorMessage(5, ("1 6 1", 4))
  val INVALID_FINISH_INPUT_MESSAGE = invalidFinishCodeErrorMessage(("1 1 3"), 4)
}

