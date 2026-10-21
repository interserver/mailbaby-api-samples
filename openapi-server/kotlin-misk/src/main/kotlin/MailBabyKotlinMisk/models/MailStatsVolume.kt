package MailBabyKotlinMisk.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MailStatsVolume(
    /** Message counts keyed by destination (envelope &#x60;to&#x60;) email address. */
    val to: kotlin.collections.Map<kotlin.String, kotlin.Int>? = null,
    /** Message counts keyed by sender (envelope &#x60;from&#x60;) email address. */
    val from: kotlin.collections.Map<kotlin.String, kotlin.Int>? = null,
    /** Message counts keyed by originating client IP address. */
    val ip: kotlin.collections.Map<kotlin.String, kotlin.Int>? = null
)
