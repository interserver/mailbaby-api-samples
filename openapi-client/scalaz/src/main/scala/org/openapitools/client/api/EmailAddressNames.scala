package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import scala.collection.mutable.ListBuffer

import EmailAddressNames._

case class EmailAddressNames (
  
object EmailAddressNames {
  import DateTimeCodecs._

  implicit val EmailAddressNamesCodecJson: CodecJson[EmailAddressNames] = CodecJson.derive[EmailAddressNames]
  implicit val EmailAddressNamesDecoder: EntityDecoder[EmailAddressNames] = jsonOf[EmailAddressNames]
  implicit val EmailAddressNamesEncoder: EntityEncoder[EmailAddressNames] = jsonEncoderOf[EmailAddressNames]
}
