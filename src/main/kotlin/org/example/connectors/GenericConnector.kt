package org.example.connectors

import org.example.models.getresponse.BinResponse
import reactor.core.publisher.Mono

interface GenericConnector {
    fun returnSomethingViaGet(): Mono<BinResponse>
    fun returnUrl(): String
}
