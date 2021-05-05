package io.swagger.server.model


/**
 * = Email details =
 *
 * Details for an Email
 *
 * @param to The Contact whom is the primary recipient of this email. for example: ''johndoe@company.com''
 * @param from The contact whom is the this email is from. for example: ''johndoe@company.com''
 * @param subject The subject or title of the email for example: ''Your Package has been Delivered!''
 * @param body The main email contents. for example: ''The package you ordered on 2021-01-23 has been delivered. If the package is broken into many pieces, please blaim someone else.
''
 */
case class SendMail (
  to: Option[String],
  from: Option[String],
  subject: Option[String],
  body: Option[String]
)

