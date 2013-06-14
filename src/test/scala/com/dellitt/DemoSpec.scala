package com.dellitt

import org.specs2.mutable.SpecificationWithJUnit

class DemoSpec extends SpecificationWithJUnit {

    "generated finagle service" should {

        "server and client" in {
            val server = DemoServer.build()

            val client = DemoClient.build(server.localAddress)

            client.hi("Albert").onSuccess(m => { println(m) })
            client.hi("Frank").onSuccess(m => { println(m + "\n") })

            true should equalTo(true)
        }
    }
}
