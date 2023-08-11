package org.example.models.getresponse

import com.example.example.Args
import com.google.gson.annotations.SerializedName
import io.micronaut.context.annotation.Bean
import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable

@Bean
@Introspected
@Serdeable
data class BinResponse (

  @SerializedName("args"        ) var args          : Args?    = Args(),
  @SerializedName("headers"     ) var headers       : Headers? = Headers(),
  @SerializedName("origin"      ) var origin        : String?  = null,
  @SerializedName("url"         ) var url           : String?  = null,
  @SerializedName("serviceField") var serviceField  : String?  = "",
  @SerializedName("connectorField") var connectorField  : String?  = "",


  )