package com.dellitt.scalacalc.builders

import java.net.SocketAddress
import com.dellitt.thrift.Calculator
import com.twitter.finagle.builder.ClientBuilder
import com.twitter.finagle.thrift.ThriftClientFramedCodec

class CalculatorClientBuilder {

    def build(address: SocketAddress):Calculator.FutureIface = {
        val service = ClientBuilder()
            .hosts(Seq(address))
            .codec(ThriftClientFramedCodec())
            .hostConnectionLimit(1)
            .build()

        new Calculator.FinagledClient(service)
    }
}
