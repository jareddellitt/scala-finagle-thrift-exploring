package com.dellitt.scalacalc

import org.specs2.mutable.SpecificationWithJUnit
import com.twitter.util.Await
import com.dellitt.scalacalc.builders.CalculatorServiceBuilder
import com.dellitt.scalacalc.builders.CalculatorClientBuilder
import java.net.InetSocketAddress

class CalculatorSpec extends SpecificationWithJUnit {

    "calculator service" should {
        val server = new CalculatorServiceBuilder().build
        server.start()

        val client = new CalculatorClientBuilder().build(new InetSocketAddress(server.thriftPort))

        "produce the correct sum when add is called" in {
            Await result client.add(20, 9) should equalTo(29)
        }

        "produce the correct difference when subtract is called" in {
            Await result client.subtract(20, 9) should equalTo(11)
        }

        "produce the correct product when multiply is called" in {
            Await result client.multiply(20, 9) should equalTo(180)
        }

        "produce the correct quotient when divide is called" in {
            Await result client.divide(180, 9) should equalTo(20)
        }
    }
}
