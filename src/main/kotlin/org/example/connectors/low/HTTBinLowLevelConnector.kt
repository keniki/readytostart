package org.example.connectors.low

import io.micronaut.context.annotation.Value
import io.micronaut.http.HttpHeaders
import io.micronaut.http.HttpRequest
import io.micronaut.http.MediaType
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.uri.UriBuilder
import io.micronaut.reactor.http.client.ReactorHttpClient
import jakarta.inject.Singleton
import org.example.annotations.AllOpen
import org.example.models.getresponse.BinResponse
import java.net.URI

@Singleton
@AllOpen
class HTTBinLowLevelConnector(
    @Value("\${clients.httpbin.call1}")
    private var call: String,
    @param:Client(id = "github") private val httpClient: ReactorHttpClient
                ): GenericConnector {

    private val uri: URI = UriBuilder.of(call)
//        .path(configuration.organization)
//        .path(configuration.repo)
//        .path("releases")
        .build()
  override suspend fun returnUrl():String{
      return call
  }

  override suspend fun  returnSomethingViaGet(): BinResponse {
      return httpClient.retrieve( HttpRequest.GET<BinResponse>(uri)
          .header(HttpHeaders.USER_AGENT, "Micronaut HTTP Client")
          .header(HttpHeaders.ACCEPT, "application/json")
          .contentType(MediaType.APPLICATION_HAL_JSON_TYPE), BinResponse::class.java)
          .onErrorStop().blockFirst() ?: BinResponse(origin="Error")

    }
}