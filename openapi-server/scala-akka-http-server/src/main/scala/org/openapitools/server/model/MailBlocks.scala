package org.openapitools.server.model


/**
 * = MailBlocks =
 *
 * The complete set of blocked addresses and message patterns returned by `GET /mail/blocks`. Three independent block sources are combined into one response. Use `POST /mail/blocks/delete` with a `from` address from any entry to delist it.
 *
 * @param local Messages flagged by the `LOCAL_BL_RCPT` rspamd rule in the last 5 days. These are messages sent to recipients on a local block list. for example: ''null''
 * @param mbtrap Messages flagged by the `MBTRAP` rspamd rule in the last 5 days. These triggered MailBaby's honeypot / trap address detection. for example: ''null''
 * @param subject Senders whose messages contained spam-indicative subjects (containing `@`, `smtp`, `socks4`, or `socks5`) with more than 4 occurrences of the same subject in the last 3 days. for example: ''null''
*/
final case class MailBlocks (
  local: Seq[MailBlockClickHouse],
  mbtrap: Seq[MailBlockClickHouse],
  subject: Seq[MailBlockRspamd]
)

