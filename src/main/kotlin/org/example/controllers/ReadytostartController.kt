package org.example.controllers

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import org.example.models.getresponse.BinResponse
import org.example.services.Service
import org.reactivestreams.Publisher
import java.util.Objects

@Controller("/readytostart")
class ReadytostartController(service: Service) {

    val miService = service

    @Get(uri = "/", produces = ["application/json"])
    fun index(): String {
        return miService.getValue()
    }

    @Get(uri = "/high", produces = ["application/json"])
    fun high(): Publisher<BinResponse?>? {
        return miService.returnFromHighLevel()
    }
}
