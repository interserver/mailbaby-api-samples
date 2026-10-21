@file:Suppress(
    "RemoveRedundantQualifierName",
    "unused",
)

package MailBabyKotlinWiremock.models

import com.fasterxml.jackson.annotation.JsonProperty

data class MailLog(
    @field:JsonProperty("total")
    val total: kotlin.Int,

    @field:JsonProperty("skip")
    val skip: kotlin.Int,

    @field:JsonProperty("limit")
    val limit: kotlin.Int,

    @field:JsonProperty("emails")
    val emails: kotlin.collections.List<MailLogEntry>,

)
