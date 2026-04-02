package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import DateOrTimestamp._

case class DateOrTimestamp (
  
object DateOrTimestamp {
  import DateTimeCodecs._

  implicit val DateOrTimestampCodecJson: CodecJson[DateOrTimestamp] = CodecJson.derive[DateOrTimestamp]
  implicit val DateOrTimestampDecoder: EntityDecoder[DateOrTimestamp] = jsonOf[DateOrTimestamp]
  implicit val DateOrTimestampEncoder: EntityEncoder[DateOrTimestamp] = jsonEncoderOf[DateOrTimestamp]
}
