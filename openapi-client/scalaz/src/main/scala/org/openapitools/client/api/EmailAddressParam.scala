package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import EmailAddressParam._

case class EmailAddressParam (
  /* The email address to delist from all block lists. */
  email: String)

object EmailAddressParam {
  import DateTimeCodecs._

  implicit val EmailAddressParamCodecJson: CodecJson[EmailAddressParam] = CodecJson.derive[EmailAddressParam]
  implicit val EmailAddressParamDecoder: EntityDecoder[EmailAddressParam] = jsonOf[EmailAddressParam]
  implicit val EmailAddressParamEncoder: EntityEncoder[EmailAddressParam] = jsonEncoderOf[EmailAddressParam]
}
