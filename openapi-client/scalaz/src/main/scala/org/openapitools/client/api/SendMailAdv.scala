package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import SendMailAdv._

case class SendMailAdv (
  /* The subject or title of the email */
  subject: String,
/* The main email contents. */
  body: String,
from: EmailAddressTypes,
to: EmailAddressesTypes,
replyto: Option[EmailAddressesTypes],
cc: Option[EmailAddressesTypes],
bcc: Option[EmailAddressesTypes],
/* (optional) File attachments to include in the email.  The file contents must be base64 encoded! */
  attachments: Option[List[MailAttachment]],
/* (optional)  ID of the Mail order within our system to use as the Mail Account. */
  id: Option[Long])

object SendMailAdv {
  import DateTimeCodecs._

  implicit val SendMailAdvCodecJson: CodecJson[SendMailAdv] = CodecJson.derive[SendMailAdv]
  implicit val SendMailAdvDecoder: EntityDecoder[SendMailAdv] = jsonOf[SendMailAdv]
  implicit val SendMailAdvEncoder: EntityEncoder[SendMailAdv] = jsonEncoderOf[SendMailAdv]
}
