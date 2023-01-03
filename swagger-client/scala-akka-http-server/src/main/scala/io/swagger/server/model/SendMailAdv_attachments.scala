package io.swagger.server.model


/**
 * A File attachment for an email
 *
 * @param filename (optional) Filename to specify for the attachment. for example: ''company_logo.png''
 * @param data Contents of the attached file (must be base64 encoded)
 */
case class SendMailAdv_attachments (
  filename: Option[String],
  data: byte[]
)

