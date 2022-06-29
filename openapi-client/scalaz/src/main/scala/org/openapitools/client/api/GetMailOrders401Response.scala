package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import GetMailOrders401Response._

case class GetMailOrders401Response (
  code: String,
message: String)

object GetMailOrders401Response {
  import DateTimeCodecs._

  implicit val GetMailOrders401ResponseCodecJson: CodecJson[GetMailOrders401Response] = CodecJson.derive[GetMailOrders401Response]
  implicit val GetMailOrders401ResponseDecoder: EntityDecoder[GetMailOrders401Response] = jsonOf[GetMailOrders401Response]
  implicit val GetMailOrders401ResponseEncoder: EntityEncoder[GetMailOrders401Response] = jsonEncoderOf[GetMailOrders401Response]
}
