package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import SendMailAdvToInner._

case class SendMailAdvToInner (
  /* The email address */
  email: String,
/* (optional) Name to use for the destination contact. */
  name: Option[String])

object SendMailAdvToInner {
  import DateTimeCodecs._

  implicit val SendMailAdvToInnerCodecJson: CodecJson[SendMailAdvToInner] = CodecJson.derive[SendMailAdvToInner]
  implicit val SendMailAdvToInnerDecoder: EntityDecoder[SendMailAdvToInner] = jsonOf[SendMailAdvToInner]
  implicit val SendMailAdvToInnerEncoder: EntityEncoder[SendMailAdvToInner] = jsonEncoderOf[SendMailAdvToInner]
}
