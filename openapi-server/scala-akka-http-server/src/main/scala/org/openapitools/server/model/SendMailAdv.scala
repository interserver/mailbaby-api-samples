package org.openapitools.server.model


/**
 * = SendMailAdv =
 *
 * Request body for `POST /mail/advsend`.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (`from`, `to`, `replyto`, `cc`, `bcc`) each accept either a plain RFC 822 string (e.g. `\"Joe <joe@example.com>\"` or a comma-separated list) or a structured array of `{\"email\": \"...\", \"name\": \"...\"}` objects.  HTML detection is automatic based on whether `body` contains HTML tags.
 *
 * @param subject The subject line of the email. for example: ''Your Package has been Delivered!''
 * @param body The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`. for example: ''The package you ordered on 2021-01-23 has been delivered.''
 * @param from The sender address.  Accepts a plain email string, an RFC 822 named string (`\"Name <email>\"`), or a `{\"email\": \"...\", \"name\": \"...\"}` object. for example: ''null''
 * @param to One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects. for example: ''null''
 * @param replyto Optional.  One or more addresses to set as the `Reply-To` header. When recipients reply to the message their email client will address the reply to these addresses instead of `from`. for example: ''null''
 * @param cc Optional.  Carbon-copy recipients.  These addresses are listed in the `Cc` header and are visible to all recipients. for example: ''null''
 * @param bcc Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header. for example: ''null''
 * @param attachments Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name. for example: ''null''
 * @param id Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`. for example: ''5000''
*/
final case class SendMailAdv (
  subject: String,
  body: String,
  from: EmailAddressTypes,
  to: EmailAddressesTypes,
  replyto: Option[EmailAddressesTypes] = None,
  cc: Option[EmailAddressesTypes] = None,
  bcc: Option[EmailAddressesTypes] = None,
  attachments: Option[Seq[MailAttachment]] = None,
  id: Option[Long] = None
)

