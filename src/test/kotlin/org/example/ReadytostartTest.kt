package org.example
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import jakarta.inject.Inject
import java.net.http.HttpResponse

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

}
