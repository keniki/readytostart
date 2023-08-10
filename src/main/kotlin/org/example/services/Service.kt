package org.example.services

import org.example.models.getresponse.BinResponse
import org.reactivestreams.Publisher
import reactor.core.publisher.Mono
import java.util.Objects


interface Service {

    suspend fun getValue (): String
    suspend fun returnFromHighLevel(): BinResponse
    suspend fun returnFromLowLevel(): BinResponse

}