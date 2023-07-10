package org.example.controllers

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.HttpStatus
import jakarta.inject.Inject
import org.example.services.Service
import org.example.services.ServiceImpl

@Controller("/readytostart")
class ReadytostartController(service: Service) {

    val miService = service

    @Get(uri="/", produces=["application/json"])
    fun index(): String {

        return miService.getValue()
    }
}