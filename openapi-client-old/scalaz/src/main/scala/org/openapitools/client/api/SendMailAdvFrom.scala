package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import SendMailAdvFrom._

case class SendMailAdvFrom (
  /* The email address */
  email: String,
/* Optional contact name */
  name: Option[String])

object SendMailAdvFrom {
  import DateTimeCodecs._

  implicit val SendMailAdvFromCodecJson: CodecJson[SendMailAdvFrom] = CodecJson.derive[SendMailAdvFrom]
  implicit val SendMailAdvFromDecoder: EntityDecoder[SendMailAdvFrom] = jsonOf[SendMailAdvFrom]
  implicit val SendMailAdvFromEncoder: EntityEncoder[SendMailAdvFrom] = jsonEncoderOf[SendMailAdvFrom]
}
