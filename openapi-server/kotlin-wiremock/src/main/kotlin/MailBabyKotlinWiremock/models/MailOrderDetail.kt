@file:Suppress(
    "RemoveRedundantQualifierName",
    "unused",
)

package MailBabyKotlinWiremock.models

import com.fasterxml.jackson.annotation.JsonProperty

data class MailOrderDetail(
    @field:JsonProperty("id")
    val id: kotlin.Int,

    @field:JsonProperty("status")
    val status: kotlin.String,

    @field:JsonProperty("username")
    val username: kotlin.String,

    @field:JsonProperty("password")
    val password: kotlin.String,

    @field:JsonProperty("comment")
    val comment: kotlin.String? = null,

)
