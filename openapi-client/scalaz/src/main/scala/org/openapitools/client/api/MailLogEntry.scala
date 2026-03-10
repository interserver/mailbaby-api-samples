package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import MailLogEntry._

case class MailLogEntry (
  /* Internal auto-increment database row ID.  Not meaningful outside the API. */
  _id: Integer,
/* The relay-assigned mail ID (18–19 hex characters).  This is the value returned as `text` by the sending endpoints and accepted as the `mailid` filter on `GET /mail/log`. */
  id: String,
/* SMTP envelope `MAIL FROM` address (may differ from the `From:` header). */
  from: String,
/* SMTP envelope `RCPT TO` address. */
  to: String,
/* Human-readable creation timestamp in `YYYY-MM-DD HH:MM:SS` format. */
  created: String,
/* Unix timestamp of message acceptance.  Corresponds to the `startDate` and `endDate` filter parameters on `GET /mail/log`. */
  time: Integer,
/* The SMTP AUTH username used to submit the message (e.g. `mb5658`). Corresponds to the `username` field in `GET /mail` orders. */
  user: String,
/* SMTP transaction type negotiated with the relay (e.g. `ESMTPSA`). */
  transtype: String,
/* IP address of the client that submitted the message to the relay. Corresponds to the `origin` filter parameter on `GET /mail/log`. */
  origin: String,
/* Relay interface name that accepted the message (e.g. `feeder`). */
  interface: String,
/* The `Subject` header value, if available. */
  subject: Option[String],
/* The `Message-ID` header value, if present.  Can be used with the `messageId` filter on `GET /mail/log` for subsequent lookups. */
  messageId: Option[String],
/* The sending zone assigned by the relay for outbound delivery. */
  sendingZone: Option[String],
/* Size of the message body in bytes. */
  bodySize: Option[Integer],
/* Sequence index of this recipient in a multi-recipient message. Starts at 1. */
  seq: Option[Integer],
/* Delivery status flag.  `1` = successfully delivered to destination MX. `0` = queued, deferred, or failed.  `null` = delivery not yet attempted. Corresponds to the `delivered` filter parameter on `GET /mail/log`. */
  delivered: Option[Integer],
/* The SMTP response string received from the destination MX server upon delivery attempt (e.g. `\"250 2.0.0 Ok queued as C91D83E128C\"`). */
  response: Option[String],
/* The specific recipient address this delivery record is for. */
  recipient: Option[String],
/* The destination domain.  Corresponds to the `mx` filter parameter (which matches `mxHostname`, not `domain`) on `GET /mail/log`. */
  domain: Option[String],
/* Whether the queue entry is currently locked for delivery processing. */
  locked: Option[Integer],
/* Millisecond-precision timestamp of the last queue lock acquisition. */
  lockTime: Option[String],
/* The relay server node assigned to deliver this message. */
  assigned: Option[String],
/* ISO 8601 timestamp when the message was placed into the delivery queue. */
  queued: Option[String],
/* The MX hostname the relay connected to for delivery.  Corresponds to the `mx` filter parameter on `GET /mail/log`. */
  mxHostname: Option[String])

object MailLogEntry {
  import DateTimeCodecs._

  implicit val MailLogEntryCodecJson: CodecJson[MailLogEntry] = CodecJson.derive[MailLogEntry]
  implicit val MailLogEntryDecoder: EntityDecoder[MailLogEntry] = jsonOf[MailLogEntry]
  implicit val MailLogEntryEncoder: EntityEncoder[MailLogEntry] = jsonEncoderOf[MailLogEntry]
}
