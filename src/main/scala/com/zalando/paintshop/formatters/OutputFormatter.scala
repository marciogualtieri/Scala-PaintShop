package com.zalando.paintshop.formatters

import com.zalando.paintshop.TestCase

import scala.collection.immutable.BitSet

trait OutputFormatter {
  def format(testCases: Array[TestCase], batchesArray: Array[BitSet]): List[String]
}