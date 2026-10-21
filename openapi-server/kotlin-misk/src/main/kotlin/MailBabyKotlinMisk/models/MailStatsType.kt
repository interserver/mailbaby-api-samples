package MailBabyKotlinMisk.models

import MailBabyKotlinMisk.models.MailStatsVolume
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MailStatsType(
    /** The time window these &#x60;received&#x60;, &#x60;sent&#x60;, and &#x60;volume&#x60; statistics cover. */
    val time: kotlin.String? = Time.OneHour,
    /** Total messages accepted during the current billing cycle.  Used to calculate the &#x60;cost&#x60; value. */
    val usage: kotlin.Int? = null,
    /** The ISO 4217 currency code for this account (e.g. &#x60;USD&#x60;). */
    val currency: kotlin.String? = null,
    /** Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails). */
    val cost: kotlin.Double? = null,
    /** Count of messages accepted by the relay within the selected &#x60;time&#x60; window. Includes messages still in queue. */
    val received: kotlin.Int? = null,
    /** Count of messages successfully delivered to the destination MX within the selected &#x60;time&#x60; window.  Will be ≤ &#x60;received&#x60;. */
    val sent: kotlin.Int? = null,
    val volume: MailStatsVolume? = null
)
