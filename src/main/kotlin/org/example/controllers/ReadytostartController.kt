package org.example.controllers

import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import org.example.models.getresponse.BinResponse
import org.example.services.Service
import org.reactivestreams.Publisher
import reactor.core.publisher.Mono
import java.util.Objects

@Controller("/readytostart")
class ReadytostartController(service: Service) {

    val miService = service

    @Get(uri = "/", produces = ["application/json"])
    suspend fun index(): String {
        return miService.getValue()
    }

    @Get(uri = "/high", produces = ["application/json"])
   suspend fun high(): HttpResponse<BinResponse?>? {
        return HttpResponse.ok (miService.returnFromHighLevel())
    }

    @Get(uri = "/low", produces = ["application/json"])
    suspend fun low():  HttpResponse<BinResponse> {
        return HttpResponse.ok (miService.returnFromLowLevel())
    }
}
