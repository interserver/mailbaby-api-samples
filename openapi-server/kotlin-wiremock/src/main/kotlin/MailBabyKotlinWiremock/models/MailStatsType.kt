@file:Suppress(
    "RemoveRedundantQualifierName",
    "unused",
)

package MailBabyKotlinWiremock.models

import com.fasterxml.jackson.annotation.JsonProperty

data class MailStatsType(
    @field:JsonProperty("time")
    val time: kotlin.String? = Time.OneHour,

    @field:JsonProperty("usage")
    val usage: kotlin.Int? = null,

    @field:JsonProperty("currency")
    val currency: kotlin.String? = null,

    @field:JsonProperty("cost")
    val cost: kotlin.Double? = null,

    @field:JsonProperty("received")
    val received: kotlin.Int? = null,

    @field:JsonProperty("sent")
    val sent: kotlin.Int? = null,

    @field:JsonProperty("volume")
    val volume: MailStatsVolume? = null,

)
