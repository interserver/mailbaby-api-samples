@file:Suppress(
    "RemoveRedundantQualifierName",
    "unused",
)

package MailBabyKotlinWiremock.models

import com.fasterxml.jackson.annotation.JsonProperty

data class EmailAddressParam(
    @field:JsonProperty("email")
    val email: kotlin.String,

)
