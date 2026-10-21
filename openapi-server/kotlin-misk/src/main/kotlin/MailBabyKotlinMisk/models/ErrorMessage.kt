package MailBabyKotlinMisk.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ErrorMessage(
    /** The HTTP-style status code associated with the error. */
    val code: kotlin.Int,
    /** A human-readable description of the error. */
    val message: kotlin.String
)
