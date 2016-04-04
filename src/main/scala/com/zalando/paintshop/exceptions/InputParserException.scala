package com.zalando.paintshop.exceptions

class InputParserException(message: String, exception: Exception) extends Exception(message, exception) {
  def this(message: String) = this(message, null)
}

object InputParserException {
  def apply(message: String): InputParserException = new InputParserException(message)

  def apply(message: String, exception: Exception): InputParserException = new InputParserException(message, exception)
}