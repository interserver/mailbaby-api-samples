package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import MailContact._

case class MailContact (
  /* The email address */
  email: String,
/* Optional contact name */
  name: Option[String])

object MailContact {
  import DateTimeCodecs._

  implicit val MailContactCodecJson: CodecJson[MailContact] = CodecJson.derive[MailContact]
  implicit val MailContactDecoder: EntityDecoder[MailContact] = jsonOf[MailContact]
  implicit val MailContactEncoder: EntityEncoder[MailContact] = jsonEncoderOf[MailContact]
}
