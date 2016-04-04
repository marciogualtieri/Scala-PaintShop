package com.zalando.paintshop.utils

import com.zalando.paintshop.formatters.PlainTextOutputFormatter

class ConcretePlainTextOutputFormatter extends PlainTextOutputFormatter

object ConcretePlainTextOutputFormatter {
  def apply(): PlainTextOutputFormatter = new ConcretePlainTextOutputFormatter
}