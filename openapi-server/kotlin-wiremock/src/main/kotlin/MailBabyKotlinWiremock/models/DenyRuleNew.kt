@file:Suppress(
    "RemoveRedundantQualifierName",
    "unused",
)

package MailBabyKotlinWiremock.models

import com.fasterxml.jackson.annotation.JsonProperty

data class DenyRuleNew(
    @field:JsonProperty("type")
    val type: kotlin.String,

    @field:JsonProperty("data")
    val `data`: kotlin.String,

    @field:JsonProperty("user")
    val user: kotlin.String? = null,

)
