package io.swagger.server.model


/**
 * Details for an Email
 *
 * @param to The Contact whom is the primary recipient of this email.
 * @param from The contact whom is the this email is from.
 * @param subject The subject or title of the email
 * @param body The main email contents.
 */
case class SendMail (
  to: String,
  from: String,
  subject: String,
  body: String
)

