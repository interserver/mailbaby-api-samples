@file:Suppress(
    "RemoveRedundantQualifierName",
    "unused",
)

package MailBabyKotlinWiremock.models

import com.fasterxml.jackson.annotation.JsonProperty

data class DenyRuleRecord(
    @field:JsonProperty("type")
    val type: kotlin.String,

    @field:JsonProperty("data")
    val `data`: kotlin.String,

    @field:JsonProperty("id")
    val id: kotlin.String,

    @field:JsonProperty("created")
    val created: java.time.OffsetDateTime,

    @field:JsonProperty("user")
    val user: kotlin.String? = null,

)
