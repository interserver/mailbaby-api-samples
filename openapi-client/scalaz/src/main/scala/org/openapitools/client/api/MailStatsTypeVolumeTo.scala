package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import MailStatsTypeVolumeTo._

case class MailStatsTypeVolumeTo (
  clientdomainCom: Option[Integer],
usersiteNet: Option[Integer],
salescompanyCom: Option[Integer],
clientanothersiteCom: Option[Integer])

object MailStatsTypeVolumeTo {
  import DateTimeCodecs._

  implicit val MailStatsTypeVolumeToCodecJson: CodecJson[MailStatsTypeVolumeTo] = CodecJson.derive[MailStatsTypeVolumeTo]
  implicit val MailStatsTypeVolumeToDecoder: EntityDecoder[MailStatsTypeVolumeTo] = jsonOf[MailStatsTypeVolumeTo]
  implicit val MailStatsTypeVolumeToEncoder: EntityEncoder[MailStatsTypeVolumeTo] = jsonEncoderOf[MailStatsTypeVolumeTo]
}
