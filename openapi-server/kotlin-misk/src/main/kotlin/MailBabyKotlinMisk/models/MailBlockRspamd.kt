package MailBabyKotlinMisk.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MailBlockRspamd(
    /** The sender email address.  Pass this value as &#x60;email&#x60; to &#x60;POST /mail/blocks/delete&#x60; to delist the sender. */
    val from: kotlin.String,
    /** The suspicious subject pattern that triggered the block. */
    val subject: kotlin.String
)
