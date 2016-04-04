package com.zalando.paintshop.iterators

trait InputIterator {
  def readLine: (String, Int)
  def toList: List[String]
}