package org.example.services

import io.micronaut.context.annotation.Bean
import org.example.connectors.high.HighLevelApiClient
import org.example.connectors.low.GenericConnector
import org.example.models.getresponse.BinResponse

@Bean
class ServiceImpl(val connector: GenericConnector,
                  private val githubApiClient: HighLevelApiClient,
                  private val binApiClient: GenericConnector
                  ) : Service {
    override suspend fun getValue(): String {
        return connector.returnUrl()
    }


    override suspend fun returnFromHighLevel(): BinResponse =
        doBizLogic(githubApiClient.fetchReturned("valueFromConnector"))


    private fun doBizLogic(fetchReturned: BinResponse): BinResponse {
        val someValue = "Value calculated in the service layer"
        fetchReturned.serviceField = someValue
        return fetchReturned
    }

    override suspend fun returnFromLowLevel(): BinResponse =
        doBizLogic(binApiClient.returnSomethingViaGet())

}