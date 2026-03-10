package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import GenericResponse._

case class GenericResponse (
  /* Always `\"ok\"` on success. */
  status: Option[String],
/* Operation-specific result string.  For send operations this is the relay transaction ID (e.g. `185caa69ff7000f47c`) which can be used as the `mailid` parameter in `GET /mail/log`.  For create operations this is the new record's numeric ID.  For delete operations this is a human-readable confirmation. */
  text: Option[String])

object GenericResponse {
  import DateTimeCodecs._

  implicit val GenericResponseCodecJson: CodecJson[GenericResponse] = CodecJson.derive[GenericResponse]
  implicit val GenericResponseDecoder: EntityDecoder[GenericResponse] = jsonOf[GenericResponse]
  implicit val GenericResponseEncoder: EntityEncoder[GenericResponse] = jsonEncoderOf[GenericResponse]
}
