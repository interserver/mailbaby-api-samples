@file:Suppress(
    "RemoveRedundantQualifierName",
    "unused",
)

package MailBabyKotlinWiremock.models

import com.fasterxml.jackson.annotation.JsonProperty

data class SendMailAdv(
    @field:JsonProperty("subject")
    val subject: kotlin.String,

    @field:JsonProperty("body")
    val body: kotlin.String,

    @field:JsonProperty("from")
    val from: EmailAddressTypes,

    @field:JsonProperty("to")
    val to: EmailAddressesTypes,

    @field:JsonProperty("replyto")
    val replyto: EmailAddressesTypes? = null,

    @field:JsonProperty("cc")
    val cc: EmailAddressesTypes? = null,

    @field:JsonProperty("bcc")
    val bcc: EmailAddressesTypes? = null,

    @field:JsonProperty("attachments")
    val attachments: kotlin.collections.List<MailAttachment>? = null,

    @field:JsonProperty("id")
    val id: kotlin.Long? = null,

)
