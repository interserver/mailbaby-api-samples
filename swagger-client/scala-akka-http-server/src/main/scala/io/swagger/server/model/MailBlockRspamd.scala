package io.swagger.server.model


/**
 * = MailBlockRspamd =
 *
 * A block pattern sourced from the rspamd database.  Represents a sender whose recent messages contained suspicious subject lines (e.g. containing relay/proxy strings) repeated more than 4 times in the last 3 days. The `from` address can be passed to `POST /mail/blocks/delete` to delist it.
 *
 * @param from The sender email address.  Pass this value as `email` to `POST /mail/blocks/delete` to delist the sender. for example: ''user@domain.com''
 * @param subject The suspicious subject pattern that triggered the block. for example: ''Test email''
 */
case class MailBlockRspamd (
  from: String,
  subject: String
)

