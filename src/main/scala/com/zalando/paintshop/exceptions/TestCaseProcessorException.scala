package com.zalando.paintshop.exceptions

class TestCaseProcessorException(message: String) extends Exception(message)

object TestCaseProcessorException {
  def apply(message: String): TestCaseProcessorException = new TestCaseProcessorException(message)
}

