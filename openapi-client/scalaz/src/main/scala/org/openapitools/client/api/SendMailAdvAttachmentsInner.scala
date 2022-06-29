package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.io.File

import SendMailAdvAttachmentsInner._

case class SendMailAdvAttachmentsInner (
  /* Contents of the attached file (must be base64 encoded) */
  data: File,
/* (optional) Filename to specify for the attachment. */
  filename: Option[String])

object SendMailAdvAttachmentsInner {
  import DateTimeCodecs._

  implicit val SendMailAdvAttachmentsInnerCodecJson: CodecJson[SendMailAdvAttachmentsInner] = CodecJson.derive[SendMailAdvAttachmentsInner]
  implicit val SendMailAdvAttachmentsInnerDecoder: EntityDecoder[SendMailAdvAttachmentsInner] = jsonOf[SendMailAdvAttachmentsInner]
  implicit val SendMailAdvAttachmentsInnerEncoder: EntityEncoder[SendMailAdvAttachmentsInner] = jsonEncoderOf[SendMailAdvAttachmentsInner]
}
