package MailBabyKotlinSpring.models

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.DecimalMax
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Email
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size
import javax.validation.Valid
import io.swagger.v3.oas.annotations.media.Schema

/**
 * Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.
 * @param to Message counts keyed by destination (envelope `to`) email address.
 * @param from Message counts keyed by sender (envelope `from`) email address.
 * @param ip Message counts keyed by originating client IP address.
 */
data class MailStatsVolume(

    @Schema(description = "Message counts keyed by destination (envelope `to`) email address.")
    @param:JsonProperty("to")
    @get:JsonProperty("to") val to: kotlin.collections.Map<kotlin.String, kotlin.Int>? = null,

    @Schema(description = "Message counts keyed by sender (envelope `from`) email address.")
    @param:JsonProperty("from")
    @get:JsonProperty("from") val from: kotlin.collections.Map<kotlin.String, kotlin.Int>? = null,

    @Schema(description = "Message counts keyed by originating client IP address.")
    @param:JsonProperty("ip")
    @get:JsonProperty("ip") val ip: kotlin.collections.Map<kotlin.String, kotlin.Int>? = null
) {

}

