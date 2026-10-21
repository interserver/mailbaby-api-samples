@file:Suppress(
    "RemoveRedundantQualifierName",
    "unused",
)

package MailBabyKotlinWiremock.models

import com.fasterxml.jackson.annotation.JsonProperty

data class GenericResponse(
    @field:JsonProperty("status")
    val status: kotlin.String,

    @field:JsonProperty("text")
    val text: kotlin.String,

)
