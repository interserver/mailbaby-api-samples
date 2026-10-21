package MailBabyKotlinMisk.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MailBlockClickHouse(
    /** The date the block event was recorded. */
    val date: java.time.LocalDate,
    /** The SMTP envelope sender (&#x60;MAIL FROM&#x60;) address of the blocked message. Pass this value as &#x60;email&#x60; to &#x60;POST /mail/blocks/delete&#x60; to delist it. */
    val from: kotlin.String,
    /** The &#x60;Subject&#x60; header of the blocked message. */
    val subject: kotlin.String,
    /** The serialized list of recipients of the blocked message. */
    val to: kotlin.String,
    /** The &#x60;Message-ID&#x60; header of the blocked message, or &#x60;null&#x60; if not present. */
    val messageId: kotlin.String? = null
)
