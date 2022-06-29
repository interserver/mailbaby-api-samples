package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import GetMailOrders200ResponseInner._

case class GetMailOrders200ResponseInner (
  id: Integer,
status: String,
username: String,
password: Option[String],
comment: Option[String])

object GetMailOrders200ResponseInner {
  import DateTimeCodecs._

  implicit val GetMailOrders200ResponseInnerCodecJson: CodecJson[GetMailOrders200ResponseInner] = CodecJson.derive[GetMailOrders200ResponseInner]
  implicit val GetMailOrders200ResponseInnerDecoder: EntityDecoder[GetMailOrders200ResponseInner] = jsonOf[GetMailOrders200ResponseInner]
  implicit val GetMailOrders200ResponseInnerEncoder: EntityEncoder[GetMailOrders200ResponseInner] = jsonEncoderOf[GetMailOrders200ResponseInner]
}
