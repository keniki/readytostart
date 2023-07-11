package org.example.models.getresponse

import com.google.gson.annotations.SerializedName
import io.micronaut.context.annotation.Bean
import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable

@Bean
@Introspected
@Serdeable
data class Headers (

//  @SerializedName("Accept"                    ) var Accept                    : String? = null,
//  @SerializedName("Accept-Encoding"           ) var Accept-Encoding           : String? = null,
//  @SerializedName("Accept-Language"           ) var Accept-Language           : String? = null,
  @SerializedName("Dnt"                       ) var dnt                       : String? = null,
  @SerializedName("Host"                      ) var host                      : String? = null,
//  @SerializedName("Sec-Ch-Ua"                 ) var Sec-Ch-Ua                 : String? = null,
//  @SerializedName("Sec-Ch-Ua-Mobile"          ) var Sec-Ch-Ua-Mobile          : String? = null,
//  @SerializedName("Sec-Ch-Ua-Platform"        ) var Sec-Ch-Ua-Platform        : String? = null,
//  @SerializedName("Sec-Fetch-Dest"            ) var Sec-Fetch-Dest            : String? = null,
//  @SerializedName("Sec-Fetch-Mode"            ) var Sec-Fetch-Mode            : String? = null,
//  @SerializedName("Sec-Fetch-Site"            ) var Sec-Fetch-Site            : String? = null,
//  @SerializedName("Sec-Fetch-User"            ) var Sec-Fetch-User            : String? = null,
//  @SerializedName("Upgrade-Insecure-Requests" ) var Upgrade-Insecure-Requests : String? = null,
//  @SerializedName("User-Agent"                ) var User-Agent                : String? = null,
//  @SerializedName("X-Amzn-Trace-Id"           ) var X-Amzn-Trace-Id           : String? = null

)