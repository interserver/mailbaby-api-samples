@file:Suppress(
    "RemoveRedundantQualifierName",
    "unused",
)

package MailBabyKotlinWiremock.models

import com.fasterxml.jackson.annotation.JsonProperty

data class SendMailRaw(
    @field:JsonProperty("raw_email")
    val rawEmail: kotlin.String,

    @field:JsonProperty("id")
    val id: kotlin.Long? = null,

)
