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
import org.example.connectors.GenericConnector
import org.example.connectors.HTTBinLowLevelConnector
import org.example.models.getresponse.BinResponse
import org.example.models.getresponse.Headers
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import reactor.core.publisher.Mono

@MicronautTest
class ReadytostartTest {

    @Inject
    lateinit var application: EmbeddedApplication<*>

    @Inject
    @field:Client("/readytostart")
    lateinit var client: HttpClient

    @Test
    fun testItWorks() {
        Assertions.assertTrue(application.isRunning)
    }

    @Test
    fun testInternalCall()  {
        val expectedValue = "https://httpbin.org/get"
        val response : io.micronaut.http.HttpResponse<String>? =
            client.toBlocking().exchange("/", String::class.java)
        Assertions.assertEquals(HttpStatus.OK, response?.status)
        Assertions.assertEquals(expectedValue, response?.body?.get())
    }

//    @MockBean(GenericConnector::class)
//    fun genericConnector(): GenericConnector{
//        return mock(HTTBinLowLevelConnector::class.java)
//    }
    //@Inject
    @MockBean
    lateinit var genericConnector: GenericConnector
    @Test
    fun testLowLevelCall()  {
        val expectedValue = "https://httpbin.org/get"


        //val dependencyMock: HTTBinLowLevelConnector = mock(HTTBinLowLevelConnector::class.java)

        // Configure mock behavior
        val expectedResponse = BinResponse( Args("param"), Headers("", ""), "origin", "url")
        `when`(genericConnector.returnSomethingViaGet()).thenReturn(Mono.just(expectedResponse))


       // val myClass = HTTBinLowLevelConnector("https://httpbin.org/get",client)

        val response2 =  genericConnector.returnSomethingViaGet()
        //val response : io.micronaut.http.HttpResponse<String>? =
        //    client.toBlocking().exchange("/low", String::class.java)

        //Assertions.assertEquals(HttpStatus.OK, response?.status)
        Assertions.assertEquals(expectedResponse,  response2.block().url)
    }



}
