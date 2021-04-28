package io.swagger.server.model


/**
 * An Email Contact
 *
 * @param email The email address for example: ''johndoe@company.com''
 * @param name Optional contact name for example: ''John Doe''
 */
case class MailContact (
  email: String,
  name: Option[String]
)

