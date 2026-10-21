package MailBabyKotlinMisk.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MailAttachment(
    /** The filename shown to recipients (e.g. &#x60;report.pdf&#x60;, &#x60;invoice.xlsx&#x60;). */
    val filename: kotlin.String,
    /** The file contents as a base64-encoded string.  Decode this to retrieve the original binary file. */
    val `data`: kotlin.ByteArray
)
