package MailBabyKotlinSpring.models

import java.util.Objects
import MailBabyKotlinSpring.models.EmailAddressTypes
import MailBabyKotlinSpring.models.EmailAddressesTypes
import MailBabyKotlinSpring.models.MailAttachment
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
 * Request body for `POST /mail/advsend`.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (`from`, `to`, `replyto`, `cc`, `bcc`) each accept either a plain RFC 822 string (e.g. `\"Joe <joe@example.com>\"` or a comma-separated list) or a structured array of `{\"email\": \"...\", \"name\": \"...\"}` objects.  HTML detection is automatic based on whether `body` contains HTML tags.
 * @param subject The subject line of the email.
 * @param body The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.
 * @param from The sender address.  Accepts a plain email string, an RFC 822 named string (`\"Name <email>\"`), or a `{\"email\": \"...\", \"name\": \"...\"}` object.
 * @param to One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.
 * @param replyto Optional.  One or more addresses to set as the `Reply-To` header. When recipients reply to the message their email client will address the reply to these addresses instead of `from`.
 * @param cc Optional.  Carbon-copy recipients.  These addresses are listed in the `Cc` header and are visible to all recipients.
 * @param bcc Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.
 * @param attachments Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name.
 * @param id Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.
 */
data class SendMailAdv(

    @Schema(example = "Your Package has been Delivered!", required = true, description = "The subject line of the email.")
    @param:JsonProperty("subject", required = true)
    @get:JsonProperty("subject", required = true) val subject: kotlin.String,

    @Schema(example = "The package you ordered on 2021-01-23 has been delivered.", required = true, description = "The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.")
    @param:JsonProperty("body", required = true)
    @get:JsonProperty("body", required = true) val body: kotlin.String,

    @field:Valid
    @Schema(required = true, description = "The sender address.  Accepts a plain email string, an RFC 822 named string (`\"Name <email>\"`), or a `{\"email\": \"...\", \"name\": \"...\"}` object.")
    @param:JsonProperty("from", required = true)
    @get:JsonProperty("from", required = true) val from: EmailAddressTypes,

    @field:Valid
    @Schema(required = true, description = "One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.")
    @param:JsonProperty("to", required = true)
    @get:JsonProperty("to", required = true) val to: EmailAddressesTypes,

    @field:Valid
    @Schema(description = "Optional.  One or more addresses to set as the `Reply-To` header. When recipients reply to the message their email client will address the reply to these addresses instead of `from`.")
    @param:JsonProperty("replyto")
    @get:JsonProperty("replyto") val replyto: EmailAddressesTypes? = null,

    @field:Valid
    @Schema(description = "Optional.  Carbon-copy recipients.  These addresses are listed in the `Cc` header and are visible to all recipients.")
    @param:JsonProperty("cc")
    @get:JsonProperty("cc") val cc: EmailAddressesTypes? = null,

    @field:Valid
    @Schema(description = "Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.")
    @param:JsonProperty("bcc")
    @get:JsonProperty("bcc") val bcc: EmailAddressesTypes? = null,

    @field:Valid
    @Schema(description = "Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name.")
    @param:JsonProperty("attachments")
    @get:JsonProperty("attachments") val attachments: kotlin.collections.List<MailAttachment>? = null,

    @Schema(example = "5000", description = "Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.")
    @param:JsonProperty("id")
    @get:JsonProperty("id") val id: kotlin.Long? = null
) {

}

