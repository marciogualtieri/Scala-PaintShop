package com.zalando.paintshop.exceptions

class InputIteratorException(message: String, exception: Exception) extends Exception(message, exception) {
  def this(message: String) = this(message, null)
  def this(exception: Exception) = this(exception.getMessage, exception)
}

object InputIteratorException {
  def apply(message: String): InputIteratorException = new InputIteratorException(message)
  def apply(exception: Exception): InputIteratorException = new InputIteratorException(exception)
}