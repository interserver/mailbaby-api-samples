package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.io.File

import MailAttachment._

case class MailAttachment (
  /* Optional filename to specify for the attachment. */
  filename: Option[String],
/* Contents of the attached file */
  data: File)

object MailAttachment {
  import DateTimeCodecs._

  implicit val MailAttachmentCodecJson: CodecJson[MailAttachment] = CodecJson.derive[MailAttachment]
  implicit val MailAttachmentDecoder: EntityDecoder[MailAttachment] = jsonOf[MailAttachment]
  implicit val MailAttachmentEncoder: EntityEncoder[MailAttachment] = jsonEncoderOf[MailAttachment]
}
