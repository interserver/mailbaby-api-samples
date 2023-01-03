package io.swagger.server.model


/**
 * An Email Contact
 *
 * @param email The email address for example: ''johndoe@isp.com''
 * @param name (optional) Name to use for the destination contact. for example: ''John Doe''
 */
case class SendMailAdv_to (
  email: String,
  name: Option[String]
)

