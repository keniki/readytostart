package org.example.services

import org.example.models.getresponse.BinResponse


interface Service {

    suspend fun getValue (): String
    suspend fun returnFromHighLevel(): BinResponse
    suspend fun returnFromLowLevel(): BinResponse

}