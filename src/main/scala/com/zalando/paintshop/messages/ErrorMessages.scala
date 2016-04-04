package com.zalando.paintshop.messages

object ErrorMessages {
  val UNEXPECTED_EOF_ERROR_MESSAGE: String = "Unexpected end of file."

  def notNumberErrorMessage(name: String, line: (String, Int)): String =
    "%s should be a number on line %d: [%s].".format(name, line._2, line._1)

  def invalidNumberPairsErrorMessage(line: (String, Int)): String =
    "Number of customer pairs is invalid on line %d: [%s].".format(line._2, line._1)

  def nonNumericPairsErrorMessage(line: (String, Int)): String =
    "Customer pairs [%s] should be a numbers on line %d.".format(line._1, line._2)

  def moreThanOneMatteErrorMessage(line: (String, Int)): String =
    "More than one matte color for customer on line %d: [%s].".format(line._2, line._1)

  def invalidFinishCodeErrorMessage(line: (String, Int)): String =
    "Finish code should be 0 (glossy) or 1 (matte) on line %d: [%s].".format(line._2, line._1)

  def invalidColorCodeErrorMessage(numColors: Int, line: (String, Int)): String =
    "Color code should be in the range 1..%d on line %d: [%s].".format(numColors, line._2, line._1)
}

