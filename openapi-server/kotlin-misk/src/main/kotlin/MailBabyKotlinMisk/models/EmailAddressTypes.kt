package MailBabyKotlinMisk.models

import MailBabyKotlinMisk.models.EmailAddressName
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EmailAddressTypes(
    /** The email address. */
    val email: kotlin.String,
    /** Optional display name shown to recipients (e.g. in the &#x60;From:&#x60; header). */
    val name: kotlin.String? = null
)
