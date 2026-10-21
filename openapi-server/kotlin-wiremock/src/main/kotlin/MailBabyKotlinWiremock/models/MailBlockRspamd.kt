@file:Suppress(
    "RemoveRedundantQualifierName",
    "unused",
)

package MailBabyKotlinWiremock.models

import com.fasterxml.jackson.annotation.JsonProperty

data class MailBlockRspamd(
    @field:JsonProperty("from")
    val from: kotlin.String,

    @field:JsonProperty("subject")
    val subject: kotlin.String,

)
