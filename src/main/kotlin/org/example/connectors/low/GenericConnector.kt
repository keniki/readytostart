package org.example.connectors.low

import org.example.models.getresponse.BinResponse

interface GenericConnector {
    suspend fun returnSomethingViaGet(): BinResponse
    suspend fun returnUrl(): String
}
