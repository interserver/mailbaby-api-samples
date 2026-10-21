package MailBabyKotlinSpring.models

import java.util.Objects
import MailBabyKotlinSpring.models.MailStatsVolume
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
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
 * Account usage statistics returned by `GET /mail/stats`.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.
 * @param time The time window these `received`, `sent`, and `volume` statistics cover.
 * @param usage Total messages accepted during the current billing cycle.  Used to calculate the `cost` value.
 * @param currency The ISO 4217 currency code for this account (e.g. `USD`).
 * @param cost Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails).
 * @param received Count of messages accepted by the relay within the selected `time` window. Includes messages still in queue.
 * @param sent Count of messages successfully delivered to the destination MX within the selected `time` window.  Will be ≤ `received`.
 * @param volume 
 */
data class MailStatsType(

    @Schema(description = "The time window these `received`, `sent`, and `volume` statistics cover.")
    @param:JsonProperty("time")
    @get:JsonProperty("time") val time: MailStatsType.Time? = Time.OneHour,

    @Schema(description = "Total messages accepted during the current billing cycle.  Used to calculate the `cost` value.")
    @param:JsonProperty("usage")
    @get:JsonProperty("usage") val usage: kotlin.Int? = null,

    @Schema(description = "The ISO 4217 currency code for this account (e.g. `USD`).")
    @param:JsonProperty("currency")
    @get:JsonProperty("currency") val currency: kotlin.String? = null,

    @Schema(description = "Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails).")
    @param:JsonProperty("cost")
    @get:JsonProperty("cost") val cost: kotlin.Double? = null,

    @Schema(description = "Count of messages accepted by the relay within the selected `time` window. Includes messages still in queue.")
    @param:JsonProperty("received")
    @get:JsonProperty("received") val received: kotlin.Int? = null,

    @Schema(description = "Count of messages successfully delivered to the destination MX within the selected `time` window.  Will be ≤ `received`.")
    @param:JsonProperty("sent")
    @get:JsonProperty("sent") val sent: kotlin.Int? = null,

    @field:Valid
    @Schema(description = "")
    @param:JsonProperty("volume")
    @get:JsonProperty("volume") val volume: MailStatsVolume? = null
) {

    /**
    * The time window these `received`, `sent`, and `volume` statistics cover.
    * Values: All,Billing,Month,SevenDays,TwentyFourHours,Day,OneHour,unknown_default_open_api
    */
    enum class Time(@get:JsonValue val value: kotlin.String) {

        All("all"),
        Billing("billing"),
        Month("month"),
        SevenDays("7d"),
        TwentyFourHours("24h"),
        Day("day"),
        OneHour("1h"),
        unknown_default_open_api("unknown_default_open_api");
    
        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Time {
                return values().firstOrNull{ it.value == value }
                                ?: unknown_default_open_api
            }
        }
    }

}

