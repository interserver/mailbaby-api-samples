package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import MailStatsType._

case class MailStatsType (
  /* The time window these `received`, `sent`, and `volume` statistics cover. */
  time: Option[Time],
/* Total messages accepted during the current billing cycle.  Used to calculate the `cost` value. */
  usage: Option[Integer],
/* The ISO 4217 currency code for this account (e.g. `USD`). */
  currency: Option[String],
/* Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails). */
  cost: Option[Double],
/* Count of messages accepted by the relay within the selected `time` window. Includes messages still in queue. */
  received: Option[Integer],
/* Count of messages successfully delivered to the destination MX within the selected `time` window.  Will be ≤ `received`. */
  sent: Option[Integer],
volume: Option[MailStatsVolume])

object MailStatsType {
  import DateTimeCodecs._
  sealed trait Time
  case object All extends Time
  case object Billing extends Time
  case object Month extends Time
  case object `7d` extends Time
  case object `24h` extends Time
  case object Day extends Time
  case object `1h` extends Time

  object Time {
    def toTime(s: String): Option[Time] = s match {
      case "All" => Some(All)
      case "Billing" => Some(Billing)
      case "Month" => Some(Month)
      case "`7d`" => Some(`7d`)
      case "`24h`" => Some(`24h`)
      case "Day" => Some(Day)
      case "`1h`" => Some(`1h`)
      case _ => None
    }

    def fromTime(x: Time): String = x match {
      case All => "All"
      case Billing => "Billing"
      case Month => "Month"
      case `7d` => "`7d`"
      case `24h` => "`24h`"
      case Day => "Day"
      case `1h` => "`1h`"
    }
  }

  implicit val TimeEnumEncoder: EncodeJson[Time] =
    EncodeJson[Time](is => StringEncodeJson(Time.fromTime(is)))

  implicit val TimeEnumDecoder: DecodeJson[Time] =
    DecodeJson.optionDecoder[Time](n => n.string.flatMap(jStr => Time.toTime(jStr)), "Time failed to de-serialize")

  implicit val MailStatsTypeCodecJson: CodecJson[MailStatsType] = CodecJson.derive[MailStatsType]
  implicit val MailStatsTypeDecoder: EntityDecoder[MailStatsType] = jsonOf[MailStatsType]
  implicit val MailStatsTypeEncoder: EntityEncoder[MailStatsType] = jsonEncoderOf[MailStatsType]
}
