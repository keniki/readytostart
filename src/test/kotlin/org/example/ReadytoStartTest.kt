package org.example
import com.example.example.Args
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import kotlinx.coroutines.runBlocking
import org.example.connectors.low.GenericConnector
import org.example.models.getresponse.BinResponse
import org.example.models.getresponse.Headers
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

@MicronautTest
class ReadyToStartTest {

    @Inject
    lateinit var application: EmbeddedApplication<*>

    @Inject
    @field:Client("/readytostart")
    lateinit var client: HttpClient

    @Test
    fun testItWorks() {
        Assertions.assertTrue(application.isRunning)
    }


    @MockBean(GenericConnector::class)
    fun  genericConnector(): GenericConnector {
        return mock(GenericConnector::class.java)
    }
    @Inject
    lateinit var genericConnector: GenericConnector

    @Test
    @Disabled("this is testing nothing")
    fun testLowLevelCall()  {
        runBlocking {
                val expectedResponse = BinResponse( Args("param"), Headers("mocked", ""), "origin", "url")
                `when`(genericConnector.returnSomethingViaGet()).thenReturn(expectedResponse)

                val response =  genericConnector.returnSomethingViaGet()

             Assertions.assertEquals(expectedResponse,  response)
        }
    }



}
