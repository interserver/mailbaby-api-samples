@file:Suppress(
    "RemoveRedundantQualifierName",
    "unused",
)

package MailBabyKotlinWiremock.models

import com.fasterxml.jackson.annotation.JsonProperty

data class MailLogEntry(
    @field:JsonProperty("_id")
    val id: kotlin.Int,

    @field:JsonProperty("id")
    val id: kotlin.String,

    @field:JsonProperty("from")
    val from: kotlin.String,

    @field:JsonProperty("to")
    val to: kotlin.String,

    @field:JsonProperty("created")
    val created: kotlin.String,

    @field:JsonProperty("time")
    val time: kotlin.Int,

    @field:JsonProperty("user")
    val user: kotlin.String,

    @field:JsonProperty("transtype")
    val transtype: kotlin.String,

    @field:JsonProperty("origin")
    val origin: kotlin.String,

    @field:JsonProperty("interface")
    val `interface`: kotlin.String,

    @field:JsonProperty("subject")
    val subject: kotlin.String? = null,

    @field:JsonProperty("messageId")
    val messageId: kotlin.String? = null,

    @field:JsonProperty("sendingZone")
    val sendingZone: kotlin.String? = null,

    @field:JsonProperty("bodySize")
    val bodySize: kotlin.Int? = null,

    @field:JsonProperty("seq")
    val seq: kotlin.Int? = null,

    @field:JsonProperty("delivered")
    val delivered: kotlin.Int? = null,

    @field:JsonProperty("code")
    val code: kotlin.Int? = null,

    @field:JsonProperty("response")
    val response: kotlin.String? = null,

    @field:JsonProperty("recipient")
    val recipient: kotlin.String? = null,

    @field:JsonProperty("domain")
    val domain: kotlin.String? = null,

    @field:JsonProperty("locked")
    val locked: kotlin.Int? = null,

    @field:JsonProperty("lockTime")
    val lockTime: kotlin.String? = null,

    @field:JsonProperty("assigned")
    val assigned: kotlin.String? = null,

    @field:JsonProperty("queued")
    val queued: kotlin.String? = null,

    @field:JsonProperty("mxHostname")
    val mxHostname: kotlin.String? = null,

)
