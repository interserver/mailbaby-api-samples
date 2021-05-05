package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import Body._

case class Body (
  /* The Contact whom is the primary recipient of this email. */
  to: Option[String],
/* The contact whom is the this email is from. */
  from: Option[String],
/* The subject or title of the email */
  subject: Option[String],
/* The main email contents. */
  body: Option[String])

object Body {
  import DateTimeCodecs._

  implicit val BodyCodecJson: CodecJson[Body] = CodecJson.derive[Body]
  implicit val BodyDecoder: EntityDecoder[Body] = jsonOf[Body]
  implicit val BodyEncoder: EntityEncoder[Body] = jsonEncoderOf[Body]
}
