package org.example.connectors

import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Value
import io.micronaut.core.type.Argument
import io.micronaut.http.HttpHeaders
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.uri.UriBuilder
import jakarta.inject.Singleton
import org.example.models.getresponse.BinResponse
import reactor.core.publisher.Mono
import java.net.URI

@Singleton
class HTTBinLowLevelConnector(
    @Value("\${clients.httpbin.call1}")
    private var call: String,
    @param:Client(id = "github") private val httpClient: HttpClient
                ): GenericConnector {

    private val uri: URI = UriBuilder.of(call)
//        .path(configuration.organization)
//        .path(configuration.repo)
//        .path("releases")
        .build()
  override fun  returnUrl():String{

      return call
  }

  override fun  returnSomethingViaGet(): Mono<BinResponse> {
      val req: HttpRequest<*> = HttpRequest.GET<Any>(uri)
          .header(HttpHeaders.USER_AGENT, "Micronaut HTTP Client")
          .header(HttpHeaders.ACCEPT, "application/json")
      return Mono.from(httpClient.retrieve(req, BinResponse::class.java))
    }
}