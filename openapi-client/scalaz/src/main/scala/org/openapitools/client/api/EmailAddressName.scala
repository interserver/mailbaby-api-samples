package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import EmailAddressName._

case class EmailAddressName (
  /* The email address. */
  email: String,
/* Optional display name shown to recipients (e.g. in the `From:` header). */
  name: Option[String])

object EmailAddressName {
  import DateTimeCodecs._

  implicit val EmailAddressNameCodecJson: CodecJson[EmailAddressName] = CodecJson.derive[EmailAddressName]
  implicit val EmailAddressNameDecoder: EntityDecoder[EmailAddressName] = jsonOf[EmailAddressName]
  implicit val EmailAddressNameEncoder: EntityEncoder[EmailAddressName] = jsonEncoderOf[EmailAddressName]
}
