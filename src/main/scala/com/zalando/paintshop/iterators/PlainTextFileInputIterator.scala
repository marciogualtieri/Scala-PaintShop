package com.zalando.paintshop.iterators

import java.io.{File, FileNotFoundException}

import com.zalando.paintshop.exceptions.InputIteratorException
import com.zalando.paintshop.messages.ErrorMessages

import scala.io.Source

class PlainTextFileInputIterator(val file: File) extends InputIterator {
  val iterator = Source.fromFile(file).getLines()
  var lineNumber = 0

  override def readLine: (String, Int) = {
    try {
      lineNumber += 1
      (iterator.next, lineNumber)
    } catch {
      case e: NoSuchElementException => throw InputIteratorException(ErrorMessages.UNEXPECTED_EOF_ERROR_MESSAGE)
    }
  }

  override def toList: List[String] = {
    iterator.toList
  }
}

object PlainTextFileInputIterator {
  def apply(fileNameAndPath: String): InputIterator = {
    try {
      new PlainTextFileInputIterator(new File(fileNameAndPath))
    } catch {
      case e: FileNotFoundException => throw InputIteratorException(e)
    }
  }

  def apply(file: File): InputIterator = new PlainTextFileInputIterator(file)
}