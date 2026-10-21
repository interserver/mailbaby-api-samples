@file:Suppress(
    "RemoveRedundantQualifierName",
    "unused",
)

package MailBabyKotlinWiremock.models

import com.fasterxml.jackson.annotation.JsonProperty

data class MailStatsVolume(
    @field:JsonProperty("to")
    val to: kotlin.collections.Map<kotlin.String, kotlin.Int>? = null,

    @field:JsonProperty("from")
    val from: kotlin.collections.Map<kotlin.String, kotlin.Int>? = null,

    @field:JsonProperty("ip")
    val ip: kotlin.collections.Map<kotlin.String, kotlin.Int>? = null,

)
