package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import SendMail._

case class SendMail (
  to: SendMailTo,
/* The sender address.  This is used as both the `From` header and the `Reply-To` header automatically.  Must be a valid email address authorized for your mail order. */
  from: String,
/* The subject line of the email. */
  subject: String,
/* The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`. */
  body: String,
/* Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`. */
  id: Option[Long])

object SendMail {
  import DateTimeCodecs._

  implicit val SendMailCodecJson: CodecJson[SendMail] = CodecJson.derive[SendMail]
  implicit val SendMailDecoder: EntityDecoder[SendMail] = jsonOf[SendMail]
  implicit val SendMailEncoder: EntityEncoder[SendMail] = jsonEncoderOf[SendMail]
}
