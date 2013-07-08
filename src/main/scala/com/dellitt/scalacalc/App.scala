package com.dellitt.scalacalc

import com.dellitt.scalacalc.builders.CalculatorServiceBuilder

object Application extends App {

    new CalculatorServiceBuilder().build.start()

    println("Calculator service successfully started")
}