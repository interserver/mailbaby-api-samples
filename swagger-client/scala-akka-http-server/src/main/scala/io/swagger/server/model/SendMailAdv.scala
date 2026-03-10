package io.swagger.server.model


/**
 * = SendMailAdv =
 *
 * Request body for `POST /mail/advsend`.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (`from`, `to`, `replyto`, `cc`, `bcc`) each accept either a plain RFC 822 string (e.g. `\"Joe <joe@example.com>\"` or a comma-separated list) or a structured array of `{\"email\": \"...\", \"name\": \"...\"}` objects.  HTML detection is automatic based on whether `body` contains HTML tags.
 *
 * @param subject The subject line of the email. for example: ''Your Package has been Delivered!''
 * @param body The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`. for example: ''The package you ordered on 2021-01-23 has been delivered.''
 * @param from 
 * @param to 
 * @param replyto 
 * @param cc 
 * @param bcc 
 * @param attachments Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name.
 * @param id Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`. for example: ''5000''
 */
case class SendMailAdv (
  subject: String,
  body: String,
  from: EmailAddressTypes,
  to: EmailAddressesTypes,
  replyto: Option[EmailAddressesTypes],
  cc: Option[EmailAddressesTypes],
  bcc: Option[EmailAddressesTypes],
  attachments: Option[List[MailAttachment]],
  id: Option[Long]
)

