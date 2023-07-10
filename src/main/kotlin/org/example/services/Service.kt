package org.example.services

import org.example.models.getresponse.BinResponse
import org.reactivestreams.Publisher
import java.util.Objects


interface Service {

    fun getValue (): String
    fun returnFromHighLevel(): Publisher<BinResponse?>?
}