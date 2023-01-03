package io.swagger.server.model


/**
 * An Email Contact
 *
 * @param email The email address for example: ''support@company.com''
 * @param name (optional) Name to use for the sending contact. for example: ''Support Staff''
 */
case class SendMailAdv_replyto (
  email: String,
  name: Option[String]
)

