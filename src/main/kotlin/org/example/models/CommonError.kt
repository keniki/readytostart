package org.example.models

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class CommonError(var message : String? = null, var code : Int?)
