package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import Body1._

case class Body1 (
  /* The Contact whom is the primary recipient of this email. */
  to: Option[String],
/* The contact whom is the this email is from. */
  from: Option[String],
/* The subject or title of the email */
  subject: Option[String],
/* The main email contents. */
  body: Option[String])

object Body1 {
  import DateTimeCodecs._

  implicit val Body1CodecJson: CodecJson[Body1] = CodecJson.derive[Body1]
  implicit val Body1Decoder: EntityDecoder[Body1] = jsonOf[Body1]
  implicit val Body1Encoder: EntityEncoder[Body1] = jsonEncoderOf[Body1]
}
