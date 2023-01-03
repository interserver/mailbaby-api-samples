package io.swagger.server.model


/**
 * An Email Contact
 *
 * @param email The email address for example: ''records@company.com''
 * @param name (optional) Name to use for the BCC contact. for example: ''Records Department''
 */
case class SendMailAdv_bcc (
  email: String,
  name: Option[String]
)

