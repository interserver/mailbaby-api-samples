package io.swagger.server.model


/**
 * = Root Type for RawMail =
 *
 * Raw Email Object
 *
 * @param raw_email The entire email contents
 * @param id Optional order id
 */
case class SendMailRaw (
  raw_email: String,
  id: Option[Int]
)

