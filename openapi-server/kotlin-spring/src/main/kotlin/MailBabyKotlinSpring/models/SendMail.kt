package MailBabyKotlinSpring.models

import java.util.Objects
import MailBabyKotlinSpring.models.SendMailTo
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
 * Request body for `POST /mail/send`.  Sends a simple single-recipient message. HTML detection is automatic — if `body` contains HTML tags the message is sent as `text/html`; otherwise as `text/plain`.  The `from` address is automatically set as both the `From` and `Reply-To` headers.  For multiple recipients, CC/BCC, attachments, or per-field Reply-To control, use `POST /mail/advsend` instead.
 * @param to 
 * @param from The sender address.  This is used as both the `From` header and the `Reply-To` header automatically.  Must be a valid email address authorized for your mail order.
 * @param subject The subject line of the email.
 * @param body The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.
 * @param id Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.
 */
data class SendMail(

    @field:Valid
    @Schema(required = true, description = "")
    @param:JsonProperty("to", required = true)
    @get:JsonProperty("to", required = true) val to: SendMailTo,

    @get:Email
    @Schema(example = "janedoe@company.com", required = true, description = "The sender address.  This is used as both the `From` header and the `Reply-To` header automatically.  Must be a valid email address authorized for your mail order.")
    @param:JsonProperty("from", required = true)
    @get:JsonProperty("from", required = true) val from: kotlin.String,

    @Schema(example = "Attention Client", required = true, description = "The subject line of the email.")
    @param:JsonProperty("subject", required = true)
    @get:JsonProperty("subject", required = true) val subject: kotlin.String,

    @Schema(example = "This is an email to inform you that something noteworthy happened.", required = true, description = "The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.")
    @param:JsonProperty("body", required = true)
    @get:JsonProperty("body", required = true) val body: kotlin.String,

    @Schema(example = "2604", description = "Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.")
    @param:JsonProperty("id")
    @get:JsonProperty("id") val id: kotlin.Long? = null
) {

}

