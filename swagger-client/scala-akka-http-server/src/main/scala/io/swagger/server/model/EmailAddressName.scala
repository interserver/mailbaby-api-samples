package io.swagger.server.model


/**
 * = EmailAddressName =
 *
 * An email contact with an optional display name.  Used in structured address fields (`from`, `to`, `cc`, `bcc`, `replyto`) in `SendMailAdv`.
 *
 * @param email The email address. for example: ''user@domain.com''
 * @param name Optional display name shown to recipients (e.g. in the `From:` header). for example: ''John Smith''
 */
case class EmailAddressName (
  email: String,
  name: Option[String]
)

