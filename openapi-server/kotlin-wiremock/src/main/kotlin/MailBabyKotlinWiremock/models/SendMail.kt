@file:Suppress(
    "RemoveRedundantQualifierName",
    "unused",
)

package MailBabyKotlinWiremock.models

import com.fasterxml.jackson.annotation.JsonProperty

data class SendMail(
    @field:JsonProperty("to")
    val to: SendMailTo,

    @field:JsonProperty("from")
    val from: kotlin.String,

    @field:JsonProperty("subject")
    val subject: kotlin.String,

    @field:JsonProperty("body")
    val body: kotlin.String,

    @field:JsonProperty("id")
    val id: kotlin.Long? = null,

)
