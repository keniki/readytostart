package org.example.connectors.low

import org.example.models.getresponse.BinResponse
import reactor.core.publisher.Mono

interface GenericConnector {
    suspend fun returnSomethingViaGet(): BinResponse
    suspend fun returnUrl(): String
}
