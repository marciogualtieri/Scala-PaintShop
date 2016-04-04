package com.zalando.paintshop.utils

import com.zalando.paintshop.formatters.SimpleOutputFormatter

class ConcreteSimpleOutputFormatter extends SimpleOutputFormatter

object ConcreteSimpleOutputFormatter {
  def apply(): SimpleOutputFormatter = new ConcreteSimpleOutputFormatter
}