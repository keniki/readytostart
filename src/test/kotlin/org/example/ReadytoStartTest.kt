package org.example
import com.example.example.Args
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import jakarta.inject.Inject
import kotlinx.coroutines.runBlocking
import org.example.connectors.low.GenericConnector
import org.example.models.getresponse.BinResponse
import org.example.models.getresponse.Headers
import org.junit.jupiter.api.Disabled
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

@MicronautTest
class ReadyToStartTest {

    @Inject
    lateinit var application: EmbeddedApplication<*>

    @Inject
    @field:Client("/readytostart")
    lateinit var client: HttpClient //FIXME this might have to change to reactor?

    @Test
    fun testItWorks() {
        Assertions.assertTrue(application.isRunning)
    }

    @Test
    @Disabled
    fun testInternalCall()  {
        val expectedValue = "https://httpbin.org/get"
        val response : io.micronaut.http.HttpResponse<String>? =
            client.toBlocking().exchange("/", String::class.java)
        Assertions.assertEquals(HttpStatus.OK, response?.status)
        Assertions.assertEquals(expectedValue, response?.body?.get())
    }

    @MockBean(GenericConnector::class)
    fun  genericConnector(): GenericConnector {
        return mock(GenericConnector::class.java)
    }
    @Inject
    lateinit var genericConnector: GenericConnector

    @Test
    fun testLowLevelCall()  {
        runBlocking {
                // Configure mock behavior
                val expectedResponse = BinResponse( Args("param"), Headers("mocked", ""), "origin", "url")
                `when`(genericConnector.returnSomethingViaGet()).thenReturn(expectedResponse)

                val response2 =  genericConnector.returnSomethingViaGet()


                //Assertions.assertEquals(HttpStatus.OK, response?.status)
                Assertions.assertEquals(expectedResponse,  response2)
        }
    }



}
