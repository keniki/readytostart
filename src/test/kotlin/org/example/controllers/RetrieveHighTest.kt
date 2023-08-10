package org.example.controllers

import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import kotlinx.coroutines.runBlocking
import org.example.models.getresponse.BinResponse
import org.example.services.Service
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock


@MicronautTest
class RetrieveHighTest {
    @MockBean(Service::class)
    fun  returnFromHighLevel(): Service = mock(Service::class.java)


    @Inject
    lateinit var service: Service

    @Inject
    lateinit var retrieveDataClientHigh: RetrieveDataClientHigh
    @Test
    fun validRequest(){
        runBlocking {

        val mockBinResponse = BinResponse(origin = "mock")
        Mockito.`when`(
            service.returnFromHighLevel()

        ).thenReturn(mockBinResponse)
        val response = retrieveDataClientHigh.retrieveHigh()

        assertEquals(response.body().origin, "mock")
    }

    }
}