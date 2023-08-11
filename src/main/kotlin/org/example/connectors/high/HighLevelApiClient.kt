package org.example.connectors.high

import io.micronaut.http.HttpHeaders.ACCEPT
import io.micronaut.http.HttpHeaders.USER_AGENT
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Header
import io.micronaut.http.annotation.Headers
import io.micronaut.http.annotation.QueryValue
import io.micronaut.http.client.annotation.Client
import org.example.models.getresponse.BinResponse

@Client(id = "\${clients.httpbin.getCall}")
//@Client(id = "https://httpbin.org/get")
@Headers(
    Header(name = USER_AGENT, value = "Micronaut HTTP Client"),
    Header(name = ACCEPT, value = "application/vnd.github.v3+json, application/json")
)
interface  HighLevelApiClient {

    @Get("/")
    fun fetchReturned(
        @QueryValue("param") parameter: String
    ): BinResponse
}