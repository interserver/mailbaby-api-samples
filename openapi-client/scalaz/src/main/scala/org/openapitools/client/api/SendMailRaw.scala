package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import SendMailRaw._

case class SendMailRaw (
  /* The entire email contents */
  rawEmail: String,
/* Optional order id */
  id: Option[Integer])

object SendMailRaw {
  import DateTimeCodecs._

  implicit val SendMailRawCodecJson: CodecJson[SendMailRaw] = CodecJson.derive[SendMailRaw]
  implicit val SendMailRawDecoder: EntityDecoder[SendMailRaw] = jsonOf[SendMailRaw]
  implicit val SendMailRawEncoder: EntityEncoder[SendMailRaw] = jsonEncoderOf[SendMailRaw]
}
