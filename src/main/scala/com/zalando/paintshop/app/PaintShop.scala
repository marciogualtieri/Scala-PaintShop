package com.zalando.paintshop.app

import java.io.{PrintWriter, File}

import com.zalando.paintshop.TestCase
import com.zalando.paintshop.formatters.PlainTextOutputFormatter
import com.zalando.paintshop.iterators.PlainTextFileInputIterator
import com.zalando.paintshop.parsers.PlainTextInputParser
import com.zalando.paintshop.processors.TestCaseProcessor
import scopt.OptionParser
import compat.Platform.currentTime
import scala.collection.immutable.BitSet

case class CliArgsConfig(input: File = null, output: File = null)

/**
  * Main command-line application.
  */
object PaintShop extends PlainTextInputParser with TestCaseProcessor with PlainTextOutputFormatter {

  private val BENCHMARK_OUTPUT_FORMAT = "\nTotal processing time: %d ms\n"

  def main(args: Array[String]) {
    val cliArguments = parseCliArguments(args)
    cliArguments match {
      case Some(config) =>
        try {
          val outputs = execute(config.input)
          if (config.output != null) outputToFile(outputs, config.output)
          else outputToConsole(outputs)
        } catch {
          case e: Throwable => println(e.getMessage)
        }
      case None =>
    }
  }

  def execute(file: File): List[String] = {
    val inputIterator = PlainTextFileInputIterator(file)
    val testCases = parse(inputIterator)
    val solutions = processTestCasesWithBenchmarking(testCases)
    format(testCases, solutions)
  }

  def processTestCasesWithBenchmarking(testCases: Array[TestCase]): Array[Option[BitSet]] = {
    val startTime = currentTime
    val batches = process(testCases)
    val endTime = currentTime
    println(BENCHMARK_OUTPUT_FORMAT.format(endTime - startTime))
    batches
  }

  def outputToFile(outputs: List[String], file: File) = {
    val writer = new PrintWriter(file)
    try {
      outputs.foreach { output => writer.write(output + "\n") }
    } finally {
      writer.close()
    }
  }

  def outputToConsole(outputs: List[String]) = {
    outputs.foreach { output => println(output) }
  }

  def parseCliArguments(args: Array[String]): Option[CliArgsConfig] = {
    val parser = new OptionParser[CliArgsConfig](this.getClass.getCanonicalName) {
      arg[File]("<input file>") action { (x, c) =>
        c.copy(input = x) } text "Name of the input file containing test cases."

      opt[File]('o', "output-file") valueName "<file>" action { (x, c) =>
        c.copy(output = x) } text "Name of the output file. If not provided will print output to console."

      help("help") text "prints this help text"
    }
    parser.parse(args, CliArgsConfig())
  }
}
