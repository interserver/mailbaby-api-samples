package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import MailOrder._

case class MailOrder (
  /* The unique numeric ID of the mail order.  Used as the `id` parameter on sending calls, log queries, and stats queries. */
  id: Integer,
/* The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send. */
  status: String,
/* The SMTP AUTH username for this order, always in the format `mb<id>`. Use together with the password from `GET /mail/{id}` to authenticate directly against `relay.mailbaby.net:25` if needed. */
  username: String,
/* Optional human-readable note associated with the order. */
  comment: Option[String])

object MailOrder {
  import DateTimeCodecs._

  implicit val MailOrderCodecJson: CodecJson[MailOrder] = CodecJson.derive[MailOrder]
  implicit val MailOrderDecoder: EntityDecoder[MailOrder] = jsonOf[MailOrder]
  implicit val MailOrderEncoder: EntityEncoder[MailOrder] = jsonEncoderOf[MailOrder]
}
