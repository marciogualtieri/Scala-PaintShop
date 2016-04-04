package com.zalando.paintshop.formatters

import com.zalando.paintshop.TestCase

import scala.collection.immutable.BitSet

/**
  * Formats the solution (BitSet array) into plain text output lines.
  */
trait PlainTextOutputFormatter {

  private val OUTPUT_FORMAT: String = "Case #%d: %s"

  def format(testCases: Array[TestCase], batchesArray: Array[Option[BitSet]]): List[String] =  {
    val solutionsWithIndex = (testCases zip batchesArray).zipWithIndex
    solutionsWithIndex.map {
      case ((t: TestCase, b: Option[BitSet]), i: Int) => formatSolution(t, b, i + 1)
    }.toList
  }

  private def formatSolution(testCase: TestCase, batches: Option[BitSet], index: Int): String = {
    if (batches.isDefined)
      OUTPUT_FORMAT.format(index, formatBits(batches, testCase.numColors))
    else
      OUTPUT_FORMAT.format(index, "IMPOSSIBLE")
  }

  private def formatBits(bitSet: Option[BitSet], numBits: Int): String = {
    (0 until numBits).map(index => formatBit(index, bitSet.get)).toList.mkString(" ")
  }

  private def formatBit(index: Int, bitSet: BitSet): String = {
    if (bitSet(index)) "1" else "0"
  }
}

