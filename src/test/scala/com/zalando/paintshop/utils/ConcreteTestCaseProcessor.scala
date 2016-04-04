package com.zalando.paintshop.utils

import com.zalando.paintshop.processors.TestCaseProcessor

class ConcreteTestCaseProcessor extends TestCaseProcessor

object ConcreteTestCaseProcessor {
  def apply(): TestCaseProcessor = new ConcreteTestCaseProcessor
}