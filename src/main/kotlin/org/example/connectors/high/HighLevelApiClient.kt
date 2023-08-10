package org.example.connectors.high

import io.micronaut.http.HttpHeaders.ACCEPT
import io.micronaut.http.HttpHeaders.USER_AGENT
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Header
import io.micronaut.http.annotation.Headers
import io.micronaut.http.client.annotation.Client
import org.example.models.getresponse.BinResponse
import org.reactivestreams.Publisher;
import java.util.Objects

@Client(id = "https://httpbin.org/get?param=returned")
@Headers(
    Header(name = USER_AGENT, value = "Micronaut HTTP Client"),
    Header(name = ACCEPT, value = "application/vnd.github.v3+json, application/json")
)
interface  HighLevelApiClient {

    @Get("/")
    fun fetchReturned(): BinResponse
}