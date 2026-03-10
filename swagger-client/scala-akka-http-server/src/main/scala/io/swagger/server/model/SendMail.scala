package io.swagger.server.model


/**
 * = SendMail =
 *
 * Request body for `POST /mail/send`.  Sends a simple single-recipient message. HTML detection is automatic — if `body` contains HTML tags the message is sent as `text/html`; otherwise as `text/plain`.  The `from` address is automatically set as both the `From` and `Reply-To` headers.  For multiple recipients, CC/BCC, attachments, or per-field Reply-To control, use `POST /mail/advsend` instead.
 *
 * @param to 
 * @param from The sender address.  This is used as both the `From` header and the `Reply-To` header automatically.  Must be a valid email address authorized for your mail order. for example: ''janedoe@company.com''
 * @param subject The subject line of the email. for example: ''Attention Client''
 * @param body The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`. for example: ''This is an email to inform you that something noteworthy happened.''
 * @param id Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`. for example: ''2604''
 */
case class SendMail (
  to: SendMailTo,
  from: String,
  subject: String,
  body: String,
  id: Option[Long]
)

