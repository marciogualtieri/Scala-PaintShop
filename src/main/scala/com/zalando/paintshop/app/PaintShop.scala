package com.zalando.paintshop.app

import java.io.{PrintWriter, File}

import com.zalando.paintshop.formatters.SimpleOutputFormatter
import com.zalando.paintshop.iterators.PlainTextFileInputIterator
import com.zalando.paintshop.parsers.PlainTextInputParser
import com.zalando.paintshop.processors.TestCaseProcessor
import scopt.OptionParser
import compat.Platform.currentTime

case class CliArgsConfig(input: File = null, output: File = null)

/**
  * Main command-line application.
  */
object PaintShop extends PlainTextInputParser with TestCaseProcessor with SimpleOutputFormatter {

  private val BENCHMARK_OUTPUT_FORMAT = "\nTotal processing time: %d ms\n"

  def main(args: Array[String]) {
    val cliArguments = parseCliArguments(args)
    cliArguments match {
      case Some(config) =>
        val inputIterator = PlainTextFileInputIterator(config.input)
        val testCases = parse(inputIterator)
        val startTime = currentTime
        val batches = process(testCases)
        val endTime = currentTime
        println(BENCHMARK_OUTPUT_FORMAT.format(endTime - startTime))
        val outputs = format(testCases, batches)
        if(config.output != null) outputToFile(outputs, config.output)
        else outputToConsole(outputs)
      case None =>
    }
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
