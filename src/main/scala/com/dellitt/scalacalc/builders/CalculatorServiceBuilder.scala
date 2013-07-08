package com.dellitt.scalacalc.builders

import com.dellitt.scalacalc.services.CalculatorServiceImpl
import com.dellitt.thrift.Calculator.ThriftServer

class CalculatorServiceBuilder {

    def build: CalculatorServiceImpl with ThriftServer = new CalculatorServiceImpl with ThriftServer {
        val thriftPort: Int = 10000
        val serverName: String = "calculator-service"
    }
}
