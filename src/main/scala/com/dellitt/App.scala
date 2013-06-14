package com.dellitt

import com.twitter.finagle.builder.{Server, ClientBuilder, ServerBuilder}
import com.twitter.finagle.thrift.{ThriftClientFramedCodec, ThriftServerFramedCodec}
import com.twitter.util.Future
import java.net.{SocketAddress, InetSocketAddress}
import java.util.concurrent.atomic.AtomicInteger
import org.apache.thrift.protocol.TBinaryProtocol
import com.dellitt.thrift.Hello

object DemoClient {

    def build(address: SocketAddress) = {
        val clientService = ClientBuilder()
            .hosts(Seq(address))
            .codec(ThriftClientFramedCodec())
            .hostConnectionLimit(1)
            .build()

        new Hello.FinagledClient(clientService)
    }
}

object DemoServer {

    private val idCounter: AtomicInteger = new AtomicInteger(0)

    class HelloServiceImpl extends Hello.FutureIface {
        def hi(name:String): Future[String] = {
            val id = idCounter.incrementAndGet()

            Future.value("Hello " + name + " (message: " + id + ")")
        }
    }

    def build() = {
        val serverService = new Hello.FinagledService(new HelloServiceImpl, new TBinaryProtocol.Factory())

        ServerBuilder()
            .codec(ThriftServerFramedCodec())
            .name("binary_service")
            .bindTo(new InetSocketAddress(0))
            .build(serverService)
    }
}
