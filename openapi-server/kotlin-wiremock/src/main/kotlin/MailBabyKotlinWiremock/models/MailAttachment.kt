@file:Suppress(
    "RemoveRedundantQualifierName",
    "unused",
)

package MailBabyKotlinWiremock.models

import com.fasterxml.jackson.annotation.JsonProperty

data class MailAttachment(
    @field:JsonProperty("filename")
    val filename: kotlin.String,

    @field:JsonProperty("data")
    val `data`: kotlin.ByteArray,

)
