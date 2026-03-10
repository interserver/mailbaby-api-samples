package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import MailAttachment._

case class MailAttachment (
  /* The filename shown to recipients (e.g. `report.pdf`, `invoice.xlsx`). */
  filename: String,
/* The file contents as a base64-encoded string.  Decode this to retrieve the original binary file. */
  data: ByteArray)

object MailAttachment {
  import DateTimeCodecs._

  implicit val MailAttachmentCodecJson: CodecJson[MailAttachment] = CodecJson.derive[MailAttachment]
  implicit val MailAttachmentDecoder: EntityDecoder[MailAttachment] = jsonOf[MailAttachment]
  implicit val MailAttachmentEncoder: EntityEncoder[MailAttachment] = jsonEncoderOf[MailAttachment]
}
