package org.openapitools.server.model

import java.time.LocalDate

/**
 * = MailBlockClickHouse =
 *
 * A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (`LOCAL_BL_RCPT` or `MBTRAP`). The `from` address can be passed to `POST /mail/blocks/delete` to delist it.
 *
 * @param date The date the block event was recorded. for example: ''Sun Aug 06 20:00:00 EDT 2023''
 * @param from The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it. for example: ''user@domain.com''
 * @param subject The `Subject` header of the blocked message. for example: ''Test Email''
 * @param to The serialized list of recipients of the blocked message. for example: ''['client@site.com']''
 * @param messageId The `Message-ID` header of the blocked message, or `null` if not present. for example: ''pFaRqFUEWkucjhTuIzYuoAgWU@domain.com''
*/
final case class MailBlockClickHouse (
  date: LocalDate,
  from: String,
  subject: String,
  to: String,
  messageId: Option[String] = None
)

