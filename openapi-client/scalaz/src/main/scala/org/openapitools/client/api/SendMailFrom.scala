package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import SendMailFrom._

case class SendMailFrom (
  /* The email address */
  email: String,
/* Optional contact name */
  name: Option[String])

object SendMailFrom {
  import DateTimeCodecs._

  implicit val SendMailFromCodecJson: CodecJson[SendMailFrom] = CodecJson.derive[SendMailFrom]
  implicit val SendMailFromDecoder: EntityDecoder[SendMailFrom] = jsonOf[SendMailFrom]
  implicit val SendMailFromEncoder: EntityEncoder[SendMailFrom] = jsonEncoderOf[SendMailFrom]
}
