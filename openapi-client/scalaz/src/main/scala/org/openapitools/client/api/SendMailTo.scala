package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import SendMailTo._

case class SendMailTo (
  
object SendMailTo {
  import DateTimeCodecs._

  implicit val SendMailToCodecJson: CodecJson[SendMailTo] = CodecJson.derive[SendMailTo]
  implicit val SendMailToDecoder: EntityDecoder[SendMailTo] = jsonOf[SendMailTo]
  implicit val SendMailToEncoder: EntityEncoder[SendMailTo] = jsonEncoderOf[SendMailTo]
}
