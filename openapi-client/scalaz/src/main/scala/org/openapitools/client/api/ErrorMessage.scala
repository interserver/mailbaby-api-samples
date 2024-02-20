package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ErrorMessage._

case class ErrorMessage (
  /* The response code associated with the error. */
  code: Integer,
/* The details or description of the error. */
  message: String)

object ErrorMessage {
  import DateTimeCodecs._

  implicit val ErrorMessageCodecJson: CodecJson[ErrorMessage] = CodecJson.derive[ErrorMessage]
  implicit val ErrorMessageDecoder: EntityDecoder[ErrorMessage] = jsonOf[ErrorMessage]
  implicit val ErrorMessageEncoder: EntityEncoder[ErrorMessage] = jsonEncoderOf[ErrorMessage]
}
