package com.zalando.paintshop.utils

import com.zalando.paintshop.parsers.{InputParser, PlainTextInputParser}

class ConcreteInputParser extends PlainTextInputParser

object ConcreteInputParser {
  def apply(): InputParser = new ConcreteInputParser
}