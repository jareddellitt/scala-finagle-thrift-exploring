package com.dellitt.scalacalc.services

import com.dellitt.thrift.Calculator
import com.twitter.util.Future

class CalculatorServiceImpl extends Calculator.FutureIface {

    def add(first:Long, second:Long): Future[Long] = Future.value(first + second)

    def subtract(first:Long, second:Long): Future[Long] = Future.value(first - second)

    def multiply(first:Long, second:Long): Future[Long] = Future.value(first * second)

    def divide(first:Long, second:Long): Future[Long] = Future.value(first / second)
}
