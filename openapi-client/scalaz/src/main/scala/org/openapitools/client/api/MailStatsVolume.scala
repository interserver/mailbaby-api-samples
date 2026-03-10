package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import MailStatsVolume._

case class MailStatsVolume (
  /* Message counts keyed by destination (envelope `to`) email address. */
  to: Option[Map[String, Integer]],
/* Message counts keyed by sender (envelope `from`) email address. */
  from: Option[Map[String, Integer]],
/* Message counts keyed by originating client IP address. */
  ip: Option[Map[String, Integer]])

object MailStatsVolume {
  import DateTimeCodecs._

  implicit val MailStatsVolumeCodecJson: CodecJson[MailStatsVolume] = CodecJson.derive[MailStatsVolume]
  implicit val MailStatsVolumeDecoder: EntityDecoder[MailStatsVolume] = jsonOf[MailStatsVolume]
  implicit val MailStatsVolumeEncoder: EntityEncoder[MailStatsVolume] = jsonEncoderOf[MailStatsVolume]
}
