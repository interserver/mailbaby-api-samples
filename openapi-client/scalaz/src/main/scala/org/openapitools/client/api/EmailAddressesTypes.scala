package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import EmailAddressesTypes._

case class EmailAddressesTypes (
  
object EmailAddressesTypes {
  import DateTimeCodecs._

  implicit val EmailAddressesTypesCodecJson: CodecJson[EmailAddressesTypes] = CodecJson.derive[EmailAddressesTypes]
  implicit val EmailAddressesTypesDecoder: EntityDecoder[EmailAddressesTypes] = jsonOf[EmailAddressesTypes]
  implicit val EmailAddressesTypesEncoder: EntityEncoder[EmailAddressesTypes] = jsonEncoderOf[EmailAddressesTypes]
}
