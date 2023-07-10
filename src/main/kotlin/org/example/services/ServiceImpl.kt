package org.example.services

import io.micronaut.context.annotation.Bean
import org.example.connectors.GenericConnector
import org.example.connectors.HighLevelApiClient
import org.example.models.getresponse.BinResponse
import org.reactivestreams.Publisher
import java.util.Objects

@Bean
class ServiceImpl(val connector: GenericConnector,
                  private val githubApiClient: HighLevelApiClient
                  ) : Service {
    override fun getValue(): String {
        return connector.returnCall()
    }


    override fun returnFromHighLevel(): Publisher<BinResponse?>? {
        return githubApiClient.fetchReturned()
    }
}