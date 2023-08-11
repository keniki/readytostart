package com.example.example

import com.google.gson.annotations.SerializedName
import io.micronaut.context.annotation.Bean
import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable

@Bean
@Introspected
@Serdeable
data class Args (

  @SerializedName("param" ) var param : String? = null

)