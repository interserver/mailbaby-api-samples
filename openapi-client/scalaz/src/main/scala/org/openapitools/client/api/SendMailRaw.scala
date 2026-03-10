package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import SendMailRaw._

case class SendMailRaw (
  /* The complete RFC 822 email message including all headers and the body. Must include at minimum `From`, `To`, `Subject`, `Date`, and `MIME-Version` headers.  DKIM signatures in the `DKIM-Signature` header are transmitted verbatim and will pass verification at the destination. */
  raw_email: String,
/* Optional numeric ID of the mail order to use for SMTP authentication. If omitted the first active order on your account is used.  Valid IDs are returned by `GET /mail`. */
  id: Option[Long])

object SendMailRaw {
  import DateTimeCodecs._

  implicit val SendMailRawCodecJson: CodecJson[SendMailRaw] = CodecJson.derive[SendMailRaw]
  implicit val SendMailRawDecoder: EntityDecoder[SendMailRaw] = jsonOf[SendMailRaw]
  implicit val SendMailRawEncoder: EntityEncoder[SendMailRaw] = jsonEncoderOf[SendMailRaw]
}
