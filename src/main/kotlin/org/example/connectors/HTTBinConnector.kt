package org.example.connectors

import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Value

@Bean
class HTTBinConnector(
    @Value("\${clients.httpbin.call1}")
    private var call: String
                ): GenericConnector {

  override fun  returnCall():String{
      return call
  }

  override fun  returnSomethingViaGet():String{
        return call
    }
}