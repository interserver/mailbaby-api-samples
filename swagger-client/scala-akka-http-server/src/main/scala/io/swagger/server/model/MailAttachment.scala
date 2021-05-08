package io.swagger.server.model


/**
 * A File attachment for an email
 *
 * @param filename Optional filename to specify for the attachment. for example: ''company_logo.png''
 * @param data Contents of the attached file
 */
case class MailAttachment (
  filename: Option[String],
  data: byte[]
)

