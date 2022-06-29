package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import SendMailAdvBccInner._

case class SendMailAdvBccInner (
  /* The email address */
  email: String,
/* (optional) Name to use for the BCC contact. */
  name: Option[String])

object SendMailAdvBccInner {
  import DateTimeCodecs._

  implicit val SendMailAdvBccInnerCodecJson: CodecJson[SendMailAdvBccInner] = CodecJson.derive[SendMailAdvBccInner]
  implicit val SendMailAdvBccInnerDecoder: EntityDecoder[SendMailAdvBccInner] = jsonOf[SendMailAdvBccInner]
  implicit val SendMailAdvBccInnerEncoder: EntityEncoder[SendMailAdvBccInner] = jsonEncoderOf[SendMailAdvBccInner]
}
