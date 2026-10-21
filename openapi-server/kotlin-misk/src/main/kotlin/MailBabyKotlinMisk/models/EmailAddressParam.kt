package MailBabyKotlinMisk.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EmailAddressParam(
    /** The email address to delist from all block lists. */
    val email: kotlin.String
)
