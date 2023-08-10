package io.swagger.server.model


/**
 * = Root Type for MailBlockRspamd =
 *
 * This is a block entry from the rspamd block list.
 *
 * @param from 
 * @param subject 
 */
case class MailBlockRspamd (
  from: String,
  subject: String
)

