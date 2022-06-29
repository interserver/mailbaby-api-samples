package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import MailLogEntry._

case class MailLogEntry (
  /* internal db id */
  id: Integer,
/* mail id */
  id: String,
/* from address */
  from: String,
/* to address */
  to: String,
/* email subject */
  subject: String,
/* message id */
  messageId: String,
/* creation date */
  created: String,
/* creation timestamp */
  time: Integer,
/* user account */
  user: String,
/* transaction type */
  transtype: String,
/* transaction host */
  transhost: String,
/* origin host */
  originhost: String,
/* origin ip */
  origin: String,
/* interface name */
  interface: String,
/* date processed */
  date: String,
/* sending zone */
  sendingZone: String,
/* email body size in bytes */
  bodySize: Integer,
/* md5 sum of the email */
  sourceMd5: String,
/* delivery sequency */
  seq: Integer,
/* to address domain */
  domain: String,
/* email receiver address */
  recipient: String,
/* locked status */
  locked: Integer,
/* lock timestamp */
  lockTime: Integer,
/* assigned server */
  assigned: String,
/* queued timestamp */
  queued: String,
/* lock id */
  lock: String,
/* logger */
  logger: String,
/* mx port number */
  mxPort: Integer,
/* connection key */
  connectionKey: String,
/* mx hostname */
  mxHostname: String,
/* body hash */
  sentBodyHash: String,
/* sent body size in bytes */
  sentBodySize: Integer,
/* md5 checksum matching result */
  md5Match: Integer)

object MailLogEntry {
  import DateTimeCodecs._

  implicit val MailLogEntryCodecJson: CodecJson[MailLogEntry] = CodecJson.derive[MailLogEntry]
  implicit val MailLogEntryDecoder: EntityDecoder[MailLogEntry] = jsonOf[MailLogEntry]
  implicit val MailLogEntryEncoder: EntityEncoder[MailLogEntry] = jsonEncoderOf[MailLogEntry]
}
