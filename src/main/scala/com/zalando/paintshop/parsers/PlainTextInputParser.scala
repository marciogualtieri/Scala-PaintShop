package com.zalando.paintshop.parsers

import com.zalando.paintshop.constants.FieldNames
import com.zalando.paintshop.enumerations.Finish
import com.zalando.paintshop.exceptions.InputParserException
import com.zalando.paintshop.{Customer, TestCase}
import com.zalando.paintshop.iterators.InputIterator
import scala.collection.immutable.BitSet

import com.zalando.paintshop.messages.ErrorMessages._

trait PlainTextInputParser extends InputParser {
  def parse(inputIterator: InputIterator): Array[TestCase] = {
    val numTestCases = parseInt(inputIterator, "Number of test cases")
    var testCases = Array[TestCase]()
    (1 to numTestCases).foreach { _ =>
      val numColors = parseInt(inputIterator, FieldNames.NUMBER_COLORS)
      val numCustomers = parseInt(inputIterator, "Number of customers")
      var customers = Array[Customer]()
      (1 to numCustomers).foreach { _ =>
        customers = customers :+ parseCustomer(inputIterator, numColors)
      }
      testCases = testCases :+ TestCase(numColors, customers)
    }
    testCases
  }

  private def parseCustomer(inputIterator: InputIterator, numColors: Int): Customer = {
    val line = inputIterator.readLine
    val pairs = toPairArray(numColors, line)
    val glossies = filterGlossies(pairs)
    val matte = filterMatte(pairs)
    new Customer(BitSet(glossies: _*), matte)
  }

  private def filterGlossies(pairs: Array[(Int, Int)]): Array[Int] = {
    pairs.filter(pair => isPairGlossy(pair)).map { case Tuple2(color, finish) => color }
  }

  private def filterMatte(pairs: Array[(Int, Int)]): Option[Int] = {
    val mattes = pairs.filter(pair => isPairMatte(pair)).map { case Tuple2(color, finish) => color }
    if (mattes.length == 1) Some(mattes(0)) else None
  }

  private def isPairGlossy(pair: (Int, Int)): Boolean = {
    val (_, finish) = pair
    Finish(finish) == Finish.GLOSSY
  }

  private def isPairMatte(pair: (Int, Int)): Boolean = {
    val (_, finish) = pair
    Finish(finish) == Finish.MATTE
  }

  private def toPairArray(numColors: Int, line: (String, Int)): Array[(Int, Int)] = {
    val customer = toArray(line)
    try {
      val partitionedArray = partitionArrayIntoSizeAndPairs(customer)
      validatePartitionedArray(partitionedArray, numColors, line)
      val (_, pairs) = partitionedArray
      pairs
    } catch {
      case e: MatchError => throw new InputParserException(invalidNumberPairsErrorMessage(line))
    }
  }

  private def partitionArrayIntoSizeAndPairs(customer: Array[Int]): (Int, Array[(Int, Int)]) = {
    val size = customer(0)
    val pairs = customer.drop(1).grouped(2).map { case Array(color, finish) => (color - 1, finish) }.toArray
    (size, pairs)
  }

  private def validatePartitionedArray(customer: (Int, Array[(Int, Int)]), numColors: Int, line: (String, Int)) = {
    val (size, pairs) = customer
    if (hasInvalidNumberOfPairs(pairs, size))
      throw InputParserException(invalidNumberPairsErrorMessage(line))
    if (hasInvalidFinishCodes(pairs))
      throw InputParserException(invalidFinishCodeErrorMessage(line))
    if (hasInvalidColorCodes(pairs, numColors))
      throw InputParserException(invalidColorCodeErrorMessage(numColors, line))
    if(hasMoreThanOneMatte(pairs))
        throw InputParserException(moreThanOneMatteErrorMessage(line))
  }

  private def hasMoreThanOneMatte(pairs: Array[(Int, Int)]): Boolean = {
    pairs.count(pair => isPairMatte(pair)) > 1
  }

  private def hasInvalidNumberOfPairs(pairs: Array[(Int, Int)], size: Int): Boolean = {
    size != pairs.length
  }

  private def hasInvalidFinishCodes(pairs: Array[(Int, Int)]): Boolean = {
    pairs.forall(pair => !Finish.isValidFinishCode(pair._2))
  }

  private def hasInvalidColorCodes(pairs: Array[(Int, Int)], numColors: Int): Boolean = {
    pairs.forall(pair => 0 > pair._1 || pair._1 > numColors - 1)
  }

  private def toArray(line: (String, Int)): Array[Int] = {
    val (value, _) = line
    try {
      value.split("\\s").map(_.toInt)
    } catch {
      case e: NumberFormatException => throw InputParserException(nonNumericPairsErrorMessage(line))
    }
  }

  private def parseInt(inputIterator: InputIterator, name: String): Int = {
    val line = inputIterator.readLine
    val (value, _) = line
    try {
      value.toInt
    } catch {
      case e: NumberFormatException => throw InputParserException(notNumberErrorMessage(name, line))
    }
  }
}