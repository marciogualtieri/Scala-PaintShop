package com.zalando.paintshop.parsers

import com.zalando.paintshop.TestCase
import com.zalando.paintshop.iterators.InputIterator

trait InputParser {
  def parse(inputIterator: InputIterator): Array[TestCase]
}