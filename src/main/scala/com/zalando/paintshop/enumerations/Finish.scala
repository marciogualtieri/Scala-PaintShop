package com.zalando.paintshop.enumerations

object Finish extends Enumeration {
  type Finish = Value
  val GLOSSY = Value(0)
  val MATTE = Value(1)

  def isValidFinishCode(code: Int): Boolean = {
    try {
      Finish(code)
      true
    } catch {
      case e: NoSuchElementException => false
    }
  }

  def isGlossy(code: Int): Boolean = {
    isValidFinishCode(code) && Finish(code) == GLOSSY
  }
}
