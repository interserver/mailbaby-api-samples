package io.swagger.server.model


/**
 * An Email Contact
 *
 * @param email The email address for example: ''janedoe@isp.com''
 * @param name (optional) Name to use for the CC contact. for example: ''Jane Doe''
 */
case class SendMailAdv_cc (
  email: String,
  name: Option[String]
)

