package org.example.services

import io.micronaut.context.annotation.Bean
import org.example.connectors.low.GenericConnector
import org.example.connectors.high.HighLevelApiClient
import org.example.models.getresponse.BinResponse

@Bean
class ServiceImpl(val connector: GenericConnector,
                  private val githubApiClient: HighLevelApiClient,
                  private val binApiClient: GenericConnector
                  ) : Service {
    override suspend fun getValue(): String {
        return connector.returnUrl()
    }


    override suspend fun returnFromHighLevel(): BinResponse {
        return githubApiClient.fetchReturned()
    }

    override suspend fun returnFromLowLevel(): BinResponse {
        return  binApiClient.returnSomethingViaGet()
    }
}