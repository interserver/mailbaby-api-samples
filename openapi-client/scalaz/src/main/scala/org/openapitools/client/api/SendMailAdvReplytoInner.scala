package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import SendMailAdvReplytoInner._

case class SendMailAdvReplytoInner (
  /* The email address */
  email: String,
/* (optional) Name to use for the sending contact. */
  name: Option[String])

object SendMailAdvReplytoInner {
  import DateTimeCodecs._

  implicit val SendMailAdvReplytoInnerCodecJson: CodecJson[SendMailAdvReplytoInner] = CodecJson.derive[SendMailAdvReplytoInner]
  implicit val SendMailAdvReplytoInnerDecoder: EntityDecoder[SendMailAdvReplytoInner] = jsonOf[SendMailAdvReplytoInner]
  implicit val SendMailAdvReplytoInnerEncoder: EntityEncoder[SendMailAdvReplytoInner] = jsonEncoderOf[SendMailAdvReplytoInner]
}
