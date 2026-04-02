package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import MailOrderDetail._

case class MailOrderDetail (
  /* The unique numeric ID of the mail order.  Used as the `id` parameter on sending calls, log queries, and stats queries. */
  id: Integer,
/* The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send. */
  status: Status,
/* The SMTP AUTH username for this order, always in the format `mb<id>`. Use together with the password from `GET /mail/{id}` to authenticate directly against `relay.mailbaby.net:25` if needed. */
  username: String,
/* The current SMTP AUTH password for this mail order.  Use with the `username` field to authenticate against `relay.mailbaby.net:25`. */
  password: String,
/* Optional human-readable note associated with the order.  Only present in the response when the order has a non-empty comment. */
  comment: Option[String])

object MailOrderDetail {
  import DateTimeCodecs._
  sealed trait Status
  case object Active extends Status
  case object Canceled extends Status

  object Status {
    def toStatus(s: String): Option[Status] = s match {
      case "Active" => Some(Active)
      case "Canceled" => Some(Canceled)
      case _ => None
    }

    def fromStatus(x: Status): String = x match {
      case Active => "Active"
      case Canceled => "Canceled"
    }
  }

  implicit val StatusEnumEncoder: EncodeJson[Status] =
    EncodeJson[Status](is => StringEncodeJson(Status.fromStatus(is)))

  implicit val StatusEnumDecoder: DecodeJson[Status] =
    DecodeJson.optionDecoder[Status](n => n.string.flatMap(jStr => Status.toStatus(jStr)), "Status failed to de-serialize")

  implicit val MailOrderDetailCodecJson: CodecJson[MailOrderDetail] = CodecJson.derive[MailOrderDetail]
  implicit val MailOrderDetailDecoder: EntityDecoder[MailOrderDetail] = jsonOf[MailOrderDetail]
  implicit val MailOrderDetailEncoder: EntityEncoder[MailOrderDetail] = jsonEncoderOf[MailOrderDetail]
}
