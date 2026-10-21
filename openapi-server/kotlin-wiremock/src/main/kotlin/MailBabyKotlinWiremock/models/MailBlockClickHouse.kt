@file:Suppress(
    "RemoveRedundantQualifierName",
    "unused",
)

package MailBabyKotlinWiremock.models

import com.fasterxml.jackson.annotation.JsonProperty

data class MailBlockClickHouse(
    @field:JsonProperty("date")
    val date: java.time.LocalDate,

    @field:JsonProperty("from")
    val from: kotlin.String,

    @field:JsonProperty("subject")
    val subject: kotlin.String,

    @field:JsonProperty("to")
    val to: kotlin.String,

    @field:JsonProperty("messageId")
    val messageId: kotlin.String? = null,

)
