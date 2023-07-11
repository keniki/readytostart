package org.example
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
    @Client("/readytostart")
    lateinit var client: HttpClient

    @Test
    fun testItWorks() {
        Assertions.assertTrue(application.isRunning)
    }


    @Test
    fun testInternalCall() {

       var response : io.micronaut.http.HttpResponse<String.Companion>? =
           client.toBlocking().exchange("/", String.javaClass)
        if (response != null) {
            println("response " + response.status)
        }
        Assertions.assertTrue(application.isRunning)
    }

}
