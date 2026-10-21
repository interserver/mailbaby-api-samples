package MailBabyKotlinSpring.models

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.DecimalMax
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Email
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size
import javax.validation.Valid
import io.swagger.v3.oas.annotations.media.Schema

/**
 * A single email record in the mail log.  Combines data from the message store (envelope metadata), the queue release table (delivery status and response), and the sender delivery table (MX routing details).  Key field relationships with other API calls: - The `id` field matches the `mailid` query parameter on `GET /mail/log` and   the `text` field of a successful send response. - The `from` address can be passed to `POST /mail/blocks/delete` to delist a   flagged sender. - The `user` field is the SMTP username (e.g. `mb5658`) corresponding to the   `username` field in `GET /mail` / `GET /mail/{id}`.
 * @param id Internal auto-increment database row ID.  Not meaningful outside the API.
 * @param id The relay-assigned mail ID (18–19 hex characters).  This is the value returned as `text` by the sending endpoints and accepted as the `mailid` filter on `GET /mail/log`.
 * @param from SMTP envelope `MAIL FROM` address (may differ from the `From:` header).
 * @param to SMTP envelope `RCPT TO` address.
 * @param created Human-readable creation timestamp in `YYYY-MM-DD HH:MM:SS` format.
 * @param time Unix timestamp of message acceptance.  Corresponds to the `startDate` and `endDate` filter parameters on `GET /mail/log`.
 * @param user The SMTP AUTH username used to submit the message (e.g. `mb5658`). Corresponds to the `username` field in `GET /mail` orders.
 * @param transtype SMTP transaction type negotiated with the relay (e.g. `ESMTPSA`).
 * @param origin IP address of the client that submitted the message to the relay. Corresponds to the `origin` filter parameter on `GET /mail/log`.
 * @param `interface` Relay interface name that accepted the message (e.g. `feeder`).
 * @param subject The `Subject` header value, if available.
 * @param messageId The `Message-ID` header value, if present.  Can be used with the `messageId` filter on `GET /mail/log` for subsequent lookups.
 * @param sendingZone The sending zone assigned by the relay for outbound delivery.
 * @param bodySize Size of the message body in bytes.
 * @param seq Sequence index of this recipient in a multi-recipient message. Starts at 1.
 * @param delivered Delivery status flag.  `1` = successfully delivered to destination MX. `0` = queued, deferred, or failed.  `null` = delivery not yet attempted. Corresponds to the `delivered` filter parameter on `GET /mail/log`.
 * @param code The SMTP response code from the destination MX server (e.g. `250` for success, `550` for permanent failure).
 * @param response The SMTP response string received from the destination MX server upon delivery attempt (e.g. `\"250 2.0.0 Ok queued as C91D83E128C\"`).
 * @param recipient The specific recipient address this delivery record is for.
 * @param domain The destination domain.  Corresponds to the `mx` filter parameter (which matches `mxHostname`, not `domain`) on `GET /mail/log`.
 * @param locked Whether the queue entry is currently locked for delivery processing.
 * @param lockTime Millisecond-precision timestamp of the last queue lock acquisition.
 * @param assigned The relay server node assigned to deliver this message.
 * @param queued ISO 8601 timestamp when the message was placed into the delivery queue.
 * @param mxHostname The MX hostname the relay connected to for delivery.  Corresponds to the `mx` filter parameter on `GET /mail/log`.
 */
data class MailLogEntry(

    @Schema(example = "103172", required = true, description = "Internal auto-increment database row ID.  Not meaningful outside the API.")
    @param:JsonProperty("_id", required = true)
    @get:JsonProperty("_id", required = true) val id: kotlin.Int,

    @get:Size(min=18,max=19)
    @Schema(example = "17c7eda538e0005d03", required = true, description = "The relay-assigned mail ID (18–19 hex characters).  This is the value returned as `text` by the sending endpoints and accepted as the `mailid` filter on `GET /mail/log`.")
    @param:JsonProperty("id", required = true)
    @get:JsonProperty("id", required = true) val id: kotlin.String,

    @Schema(example = "person@mysite.com", required = true, description = "SMTP envelope `MAIL FROM` address (may differ from the `From:` header).")
    @param:JsonProperty("from", required = true)
    @get:JsonProperty("from", required = true) val from: kotlin.String,

    @Schema(example = "client@isp.com", required = true, description = "SMTP envelope `RCPT TO` address.")
    @param:JsonProperty("to", required = true)
    @get:JsonProperty("to", required = true) val to: kotlin.String,

    @Schema(example = "2021-10-14 08:50:10", required = true, description = "Human-readable creation timestamp in `YYYY-MM-DD HH:MM:SS` format.")
    @param:JsonProperty("created", required = true)
    @get:JsonProperty("created", required = true) val created: kotlin.String,

    @Schema(example = "1634215809", required = true, description = "Unix timestamp of message acceptance.  Corresponds to the `startDate` and `endDate` filter parameters on `GET /mail/log`.")
    @param:JsonProperty("time", required = true)
    @get:JsonProperty("time", required = true) val time: kotlin.Int,

    @Schema(example = "mb5658", required = true, description = "The SMTP AUTH username used to submit the message (e.g. `mb5658`). Corresponds to the `username` field in `GET /mail` orders.")
    @param:JsonProperty("user", required = true)
    @get:JsonProperty("user", required = true) val user: kotlin.String,

    @Schema(example = "ESMTPSA", required = true, description = "SMTP transaction type negotiated with the relay (e.g. `ESMTPSA`).")
    @param:JsonProperty("transtype", required = true)
    @get:JsonProperty("transtype", required = true) val transtype: kotlin.String,

    @Schema(example = "199.231.189.154", required = true, description = "IP address of the client that submitted the message to the relay. Corresponds to the `origin` filter parameter on `GET /mail/log`.")
    @param:JsonProperty("origin", required = true)
    @get:JsonProperty("origin", required = true) val origin: kotlin.String,

    @Schema(example = "feeder", required = true, description = "Relay interface name that accepted the message (e.g. `feeder`).")
    @param:JsonProperty("interface", required = true)
    @get:JsonProperty("interface", required = true) val `interface`: kotlin.String,

    @Schema(example = "sell 0.005 shares", description = "The `Subject` header value, if available.")
    @param:JsonProperty("subject")
    @get:JsonProperty("subject") val subject: kotlin.String? = null,

    @Schema(example = "<vmiLEebsuCbSpUxD7oN3REpaN4VbN6BrdCAbNKIrdAo@relay0.mailbaby.net>", description = "The `Message-ID` header value, if present.  Can be used with the `messageId` filter on `GET /mail/log` for subsequent lookups.")
    @param:JsonProperty("messageId")
    @get:JsonProperty("messageId") val messageId: kotlin.String? = null,

    @Schema(example = "interserver", description = "The sending zone assigned by the relay for outbound delivery.")
    @param:JsonProperty("sendingZone")
    @get:JsonProperty("sendingZone") val sendingZone: kotlin.String? = null,

    @Schema(example = "63", description = "Size of the message body in bytes.")
    @param:JsonProperty("bodySize")
    @get:JsonProperty("bodySize") val bodySize: kotlin.Int? = null,

    @Schema(example = "1", description = "Sequence index of this recipient in a multi-recipient message. Starts at 1.")
    @param:JsonProperty("seq")
    @get:JsonProperty("seq") val seq: kotlin.Int? = null,

    @Schema(example = "1", description = "Delivery status flag.  `1` = successfully delivered to destination MX. `0` = queued, deferred, or failed.  `null` = delivery not yet attempted. Corresponds to the `delivered` filter parameter on `GET /mail/log`.")
    @param:JsonProperty("delivered")
    @get:JsonProperty("delivered") val delivered: kotlin.Int? = null,

    @Schema(example = "250", description = "The SMTP response code from the destination MX server (e.g. `250` for success, `550` for permanent failure).")
    @param:JsonProperty("code")
    @get:JsonProperty("code") val code: kotlin.Int? = null,

    @Schema(example = "250 2.0.0 Ok queued as C91D83E128C", description = "The SMTP response string received from the destination MX server upon delivery attempt (e.g. `\"250 2.0.0 Ok queued as C91D83E128C\"`).")
    @param:JsonProperty("response")
    @get:JsonProperty("response") val response: kotlin.String? = null,

    @Schema(example = "client@isp.com", description = "The specific recipient address this delivery record is for.")
    @param:JsonProperty("recipient")
    @get:JsonProperty("recipient") val recipient: kotlin.String? = null,

    @Schema(example = "interserver.net", description = "The destination domain.  Corresponds to the `mx` filter parameter (which matches `mxHostname`, not `domain`) on `GET /mail/log`.")
    @param:JsonProperty("domain")
    @get:JsonProperty("domain") val domain: kotlin.String? = null,

    @Schema(example = "1", description = "Whether the queue entry is currently locked for delivery processing.")
    @param:JsonProperty("locked")
    @get:JsonProperty("locked") val locked: kotlin.Int? = null,

    @Schema(example = "1634215818533", description = "Millisecond-precision timestamp of the last queue lock acquisition.")
    @param:JsonProperty("lockTime")
    @get:JsonProperty("lockTime") val lockTime: kotlin.String? = null,

    @Schema(example = "relay1", description = "The relay server node assigned to deliver this message.")
    @param:JsonProperty("assigned")
    @get:JsonProperty("assigned") val assigned: kotlin.String? = null,

    @Schema(example = "2021-10-14T12:50:15.487Z", description = "ISO 8601 timestamp when the message was placed into the delivery queue.")
    @param:JsonProperty("queued")
    @get:JsonProperty("queued") val queued: kotlin.String? = null,

    @Schema(example = "mx.j.is.cc", description = "The MX hostname the relay connected to for delivery.  Corresponds to the `mx` filter parameter on `GET /mail/log`.")
    @param:JsonProperty("mxHostname")
    @get:JsonProperty("mxHostname") val mxHostname: kotlin.String? = null
) {

}

