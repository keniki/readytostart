package org.example.services

import io.micronaut.context.annotation.Bean
import org.example.connectors.GenericConnector
import org.example.connectors.HighLevelApiClient
import org.example.models.getresponse.BinResponse
import org.reactivestreams.Publisher
import reactor.core.publisher.Mono
import java.util.Objects

@Bean
class ServiceImpl(val connector: GenericConnector,
                  private val githubApiClient: HighLevelApiClient,
                  private val binApiClient: GenericConnector
                  ) : Service {
    override fun getValue(): String {
        return connector.returnUrl()
    }


    override fun returnFromHighLevel(): Publisher<BinResponse?>? {
        return githubApiClient.fetchReturned()
    }

    override fun returnFromLowLevel(): Mono<BinResponse> {
        return  binApiClient.returnSomethingViaGet()
    }
}