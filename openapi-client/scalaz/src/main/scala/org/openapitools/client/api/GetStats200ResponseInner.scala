package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import GetStats200ResponseInner._

case class GetStats200ResponseInner (
  id: Integer,
status: String,
username: String,
password: Option[String],
comment: Option[String])

object GetStats200ResponseInner {
  import DateTimeCodecs._

  implicit val GetStats200ResponseInnerCodecJson: CodecJson[GetStats200ResponseInner] = CodecJson.derive[GetStats200ResponseInner]
  implicit val GetStats200ResponseInnerDecoder: EntityDecoder[GetStats200ResponseInner] = jsonOf[GetStats200ResponseInner]
  implicit val GetStats200ResponseInnerEncoder: EntityEncoder[GetStats200ResponseInner] = jsonEncoderOf[GetStats200ResponseInner]
}
