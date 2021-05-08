package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import InlineResponse401._

case class InlineResponse401 (
  code: String,
message: String)

object InlineResponse401 {
  import DateTimeCodecs._

  implicit val InlineResponse401CodecJson: CodecJson[InlineResponse401] = CodecJson.derive[InlineResponse401]
  implicit val InlineResponse401Decoder: EntityDecoder[InlineResponse401] = jsonOf[InlineResponse401]
  implicit val InlineResponse401Encoder: EntityEncoder[InlineResponse401] = jsonEncoderOf[InlineResponse401]
}
