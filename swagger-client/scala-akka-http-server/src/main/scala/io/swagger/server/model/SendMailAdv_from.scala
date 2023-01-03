package io.swagger.server.model


/**
 * The information to use for the From address in the email. from.
 *
 * @param email The email address for example: ''business@company.com''
 * @param name (optional) Name to use for the sending contact. for example: ''The Man''
 */
case class SendMailAdv_from (
  email: String,
  name: Option[String]
)

