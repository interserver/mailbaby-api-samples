@file:Suppress(
    "RemoveRedundantQualifierName",
    "unused",
)

package MailBabyKotlinWiremock.models

import com.fasterxml.jackson.annotation.JsonProperty

data class EmailAddressName(
    @field:JsonProperty("email")
    val email: kotlin.String,

    @field:JsonProperty("name")
    val name: kotlin.String? = null,

)
