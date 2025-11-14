package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import EmailAddressTypes._

case class EmailAddressTypes (
  /* The email address. */
  email: String,
/* Name to use for the sending contact. */
  name: Option[String])

object EmailAddressTypes {
  import DateTimeCodecs._

  implicit val EmailAddressTypesCodecJson: CodecJson[EmailAddressTypes] = CodecJson.derive[EmailAddressTypes]
  implicit val EmailAddressTypesDecoder: EntityDecoder[EmailAddressTypes] = jsonOf[EmailAddressTypes]
  implicit val EmailAddressTypesEncoder: EntityEncoder[EmailAddressTypes] = jsonEncoderOf[EmailAddressTypes]
}
