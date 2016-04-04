package com.zalando.paintshop.processors

import com.zalando.paintshop.{Customer, TestCase}
import com.zalando.paintshop.exceptions.TestCaseProcessorException

import scala.collection.immutable.BitSet

/**
  * Process test cases and find its solutions.
  */
trait TestCaseProcessor {

  def process(testCases: Array[TestCase]): Array[Option[BitSet]] = {
    return testCases.map(processTestCase)
  }

  private def processTestCase(testCase: TestCase): Option[BitSet] = {
    val batches = scala.collection.mutable.BitSet()
    try {
      while (!isBatchesFixed(batches, testCase.customers)) {
      }
    }
    catch {
      case e: TestCaseProcessorException => {
        return None
      }
    }
    return Option(BitSet(batches.toArray:_*))
  }

  private def isBatchesFixed(batches: scala.collection.mutable.BitSet, customers: Array[Customer]): Boolean = {
    var fixed = true
    for (customer <- customers) {
      if (!customer.isBatchesSatisfactory(batches)) {
        attemptToFixBatchesBySettingMatteColor(batches, customer)
        fixed = false
      }
    }
    fixed
  }

  private def attemptToFixBatchesBySettingMatteColor(batches: scala.collection.mutable.BitSet, customer: Customer) = {
    if (customer.matte.isDefined)
      batches += customer.matte.get
    else throw TestCaseProcessorException("Batches cannot be fixed.")
  }
}

