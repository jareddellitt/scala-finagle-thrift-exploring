package com.dellitt.scalacalc

import com.dellitt.scalacalc.builders.CalculatorServiceBuilder

object Application extends App {
    val server = new CalculatorServiceBuilder().build
}