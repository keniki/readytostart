package org.example.services

import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import kotlinx.coroutines.runBlocking
import org.example.connectors.high.HighLevelApiClient
import org.example.models.getresponse.BinResponse
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito

@MicronautTest
class ServicesTest {

    @MockBean(HighLevelApiClient::class)
    fun  fetchReturned(): HighLevelApiClient = Mockito.mock(HighLevelApiClient::class.java)

    @Inject
    private lateinit var highLevelApiClientMock: HighLevelApiClient

    @Inject
    lateinit var service: Service

    @Test
    fun `testing valid high level service call`()  {
        runBlocking {
            val mockBinResponse = BinResponse(origin = "mock")

            Mockito.`when`(
                highLevelApiClientMock.fetchReturned("valueFromConnector")
            ).thenReturn(mockBinResponse)

             val response = service.returnFromHighLevel()

            assert(response.origin == "mock")
            assertEquals(response.serviceField, "Value calculated in the service layer")

        }

    }
}