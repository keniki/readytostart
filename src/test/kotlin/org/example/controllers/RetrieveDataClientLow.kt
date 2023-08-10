package org.example.controllers

import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import org.example.models.getresponse.BinResponse

@Client("/readytostart/low")
interface RetrieveDataClientLow {

    @Get
    fun retrieveLow():io.micronaut.http.HttpResponse<BinResponse>
}