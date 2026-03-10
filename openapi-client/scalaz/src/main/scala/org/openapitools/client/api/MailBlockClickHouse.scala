package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate

import MailBlockClickHouse._

case class MailBlockClickHouse (
  /* The date the block event was recorded. */
  date: LocalDate,
/* The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it. */
  from: String,
/* The `Subject` header of the blocked message. */
  subject: String,
/* The serialized list of recipients of the blocked message. */
  to: String,
/* The `Message-ID` header of the blocked message, or `null` if not present. */
  messageId: Option[String])

object MailBlockClickHouse {
  import DateTimeCodecs._

  implicit val MailBlockClickHouseCodecJson: CodecJson[MailBlockClickHouse] = CodecJson.derive[MailBlockClickHouse]
  implicit val MailBlockClickHouseDecoder: EntityDecoder[MailBlockClickHouse] = jsonOf[MailBlockClickHouse]
  implicit val MailBlockClickHouseEncoder: EntityEncoder[MailBlockClickHouse] = jsonEncoderOf[MailBlockClickHouse]
}
