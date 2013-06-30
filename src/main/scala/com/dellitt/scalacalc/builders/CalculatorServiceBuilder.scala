package com.dellitt.scalacalc.builders

import com.dellitt.thrift.Calculator
import org.apache.thrift.protocol.TBinaryProtocol
import com.twitter.finagle.builder.ServerBuilder
import com.twitter.finagle.thrift.ThriftServerFramedCodec
import java.net.InetSocketAddress
import com.dellitt.scalacalc.services.CalculatorServiceImpl

class CalculatorServiceBuilder {

    def build = {
        val serverService = new Calculator.FinagledService(new CalculatorServiceImpl(), new TBinaryProtocol.Factory())

        ServerBuilder()
            .codec(ThriftServerFramedCodec())
            .name("calculator-service")
            .bindTo(new InetSocketAddress(10000))
            .build(serverService)
    }
}
