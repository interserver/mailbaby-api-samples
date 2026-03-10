package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import MailBlocks._

case class MailBlocks (
  /* Messages flagged by the `LOCAL_BL_RCPT` rspamd rule in the last 5 days. These are messages sent to recipients on a local block list. */
  local: List[MailBlockClickHouse],
/* Messages flagged by the `MBTRAP` rspamd rule in the last 5 days. These triggered MailBaby's honeypot / trap address detection. */
  mbtrap: List[MailBlockClickHouse],
/* Senders whose messages contained spam-indicative subjects (containing `@`, `smtp`, `socks4`, or `socks5`) with more than 4 occurrences of the same subject in the last 3 days. */
  subject: List[MailBlockRspamd])

object MailBlocks {
  import DateTimeCodecs._

  implicit val MailBlocksCodecJson: CodecJson[MailBlocks] = CodecJson.derive[MailBlocks]
  implicit val MailBlocksDecoder: EntityDecoder[MailBlocks] = jsonOf[MailBlocks]
  implicit val MailBlocksEncoder: EntityEncoder[MailBlocks] = jsonEncoderOf[MailBlocks]
}
