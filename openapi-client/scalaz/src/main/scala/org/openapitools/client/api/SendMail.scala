package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import SendMail._

case class SendMail (
  /* The subject or title of the email */
  subject: String,
/* The main email contents. */
  body: String,
from: MailContact,
/* The Contact whom is the primary recipient of this email. */
  to: List[MailContact],
/* The ID of the Mail order within our system to use as the Mail Account. */
  id: Long,
/* Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address. */
  replyto: Option[List[MailContact]],
/* Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. */
  cc: Option[List[MailContact]],
/* Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. */
  bcc: Option[List[MailContact]],
/* Optional file attachments to include in the email */
  attachments: Option[List[MailAttachment]])

object SendMail {
  import DateTimeCodecs._

  implicit val SendMailCodecJson: CodecJson[SendMail] = CodecJson.derive[SendMail]
  implicit val SendMailDecoder: EntityDecoder[SendMail] = jsonOf[SendMail]
  implicit val SendMailEncoder: EntityEncoder[SendMail] = jsonEncoderOf[SendMail]
}
