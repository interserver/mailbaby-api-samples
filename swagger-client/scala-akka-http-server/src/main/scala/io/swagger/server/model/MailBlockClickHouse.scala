package io.swagger.server.model


/**
 * = Root Type for MailBlockClickHouse =
 *
 * A block entry from the clickhouse mailblocks server.
 *
 * @param date 
 * @param from 
 * @param messageId 
 * @param subject 
 * @param to 
 */
case class MailBlockClickHouse (
  date: date,
  from: String,
  messageId: String,
  subject: String,
  to: String
)

