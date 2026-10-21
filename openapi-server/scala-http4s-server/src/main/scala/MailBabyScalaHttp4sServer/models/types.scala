package MailBabyScalaHttp4sServer.models

import java.time._

import io.circe.refined._
import io.circe.syntax._
import io.circe.{ Decoder, Encoder }
import io.circe.generic.semiauto.{ deriveDecoder, deriveEncoder }

import eu.timepit.refined.api.Refined
import eu.timepit.refined.boolean.And
import eu.timepit.refined.collection.MaxSize
import eu.timepit.refined.collection.MinSize
import eu.timepit.refined.string.MatchesRegex
import java.time.LocalDate
import java.time.ZonedDateTime

/**
* A date/time value accepted as either a Unix timestamp (integer seconds since epoch) or a date string parseable by `strtotime()` (e.g. `2024-01-15`, `last monday`).
*/
sealed trait DateOrTimestamp
object DateOrTimestamp {
  import io.circe.{ Decoder, Encoder }
  import io.circe.syntax._
  import cats.syntax.functor._

// no discriminator
  implicit val dateOrTimestampEncoder: Encoder[DateOrTimestamp] = Encoder.instance {
    case `long`: Long => `long`.asJson
    case string: String => string.asJson
  }

  implicit val dateOrTimestampDecoder: Decoder[DateOrTimestamp] =
    List[Decoder[DateOrTimestamp]](
      Decoder[Long].widen,
      Decoder[String].widen,
  ).reduceLeft(_ or _)
}


/**
* 
* @param id The numeric ID of the deny rule, as a string.  Pass this as `ruleId` to `DELETE /mail/rules/{ruleId}` to remove the rule.
* @param created The timestamp when the rule was created.
*/

case class DenyRuleMetadata(
  id: String,
  created: ZonedDateTime
)
object DenyRuleMetadata {
  implicit val encoderDenyRuleMetadata: Encoder[DenyRuleMetadata] = deriveEncoder[DenyRuleMetadata].mapJson(_.dropNullValues)
  implicit val decoderDenyRuleMetadata: Decoder[DenyRuleMetadata] = deriveDecoder[DenyRuleMetadata]
}

/**
* The fields required to create a new email deny rule via `POST /mail/rules`. The `type` controls what `data` is matched against: - `email` — exact sender address match - `domain` — all senders from a domain - `destination` — exact recipient address match - `startswith` — sender local-part prefix match (alphanumeric + `+_.-` only)
* @param `type` The matching strategy for this rule.  `email` blocks an exact sender address, `domain` blocks all senders at a domain, `destination` blocks an exact recipient address, and `startswith` blocks any sender whose local-part begins with the given prefix.
* @param data The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`.
* @param user Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`.
*/

case class DenyRuleNew(
  `type`: String,
  data: String,
  user: Option[String]
)
object DenyRuleNew {
  implicit val encoderDenyRuleNew: Encoder[DenyRuleNew] = deriveEncoder[DenyRuleNew].mapJson(_.dropNullValues)
  implicit val decoderDenyRuleNew: Decoder[DenyRuleNew] = deriveDecoder[DenyRuleNew]
}

/**
* A complete deny rule record as returned by `GET /mail/rules`.  Combines the rule definition fields (`DenyRuleNew`) with server-assigned metadata (`id` and `created`).  The `id` value is required by `DELETE /mail/rules/{ruleId}`.
* @param id The numeric ID of the deny rule, as a string.  Pass this as `ruleId` to `DELETE /mail/rules/{ruleId}` to remove the rule.
* @param created The timestamp when the rule was created.
* @param `type` The matching strategy for this rule.  `email` blocks an exact sender address, `domain` blocks all senders at a domain, `destination` blocks an exact recipient address, and `startswith` blocks any sender whose local-part begins with the given prefix.
* @param data The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`.
* @param user Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`.
*/

case class DenyRuleRecord(
  id: String,
  created: ZonedDateTime,
  `type`: String,
  data: String,
  user: Option[String]
)
object DenyRuleRecord {
  implicit val encoderDenyRuleRecord: Encoder[DenyRuleRecord] = deriveEncoder[DenyRuleRecord].mapJson(_.dropNullValues)
  implicit val decoderDenyRuleRecord: Decoder[DenyRuleRecord] = deriveDecoder[DenyRuleRecord]
}

/**
* An email contact with an optional display name.  Used in structured address fields (`from`, `to`, `cc`, `bcc`, `replyto`) in `SendMailAdv`.
* @param email The email address.
* @param name Optional display name shown to recipients (e.g. in the `From:` header).
*/

case class EmailAddressName(
  email: String,
  name: Option[String]
) extends EmailAddressTypes
object EmailAddressName {
  implicit val encoderEmailAddressName: Encoder[EmailAddressName] = deriveEncoder[EmailAddressName].mapJson(_.dropNullValues)
  implicit val decoderEmailAddressName: Decoder[EmailAddressName] = deriveDecoder[EmailAddressName]
}

/**
* A single email address parameter used as the body of `POST /mail/blocks/delete`.
* @param email The email address to delist from all block lists.
*/

case class EmailAddressParam(
  email: String
)
object EmailAddressParam {
  implicit val encoderEmailAddressParam: Encoder[EmailAddressParam] = deriveEncoder[EmailAddressParam].mapJson(_.dropNullValues)
  implicit val decoderEmailAddressParam: Decoder[EmailAddressParam] = deriveDecoder[EmailAddressParam]
}

/**
* A flexible single email address that accepts either a plain address string, an RFC 822 named-address string (`\"Name <email>\"`), or a structured contact object.
* @param email The email address.
* @param name Optional display name shown to recipients (e.g. in the `From:` header).
*/
sealed trait EmailAddressTypes
object EmailAddressTypes {
  import io.circe.{ Decoder, Encoder }
  import io.circe.syntax._
  import cats.syntax.functor._

// no discriminator
  implicit val emailAddressTypesEncoder: Encoder[EmailAddressTypes] = Encoder.instance {
    case emailAddressName: EmailAddressName => emailAddressName.asJson
    case string: String => string.asJson
  }

  implicit val emailAddressTypesDecoder: Decoder[EmailAddressTypes] =
    List[Decoder[EmailAddressTypes]](
      Decoder[EmailAddressName].widen,
      Decoder[String].widen,
  ).reduceLeft(_ or _)
}


/**
* A flexible email address list that accepts either a plain RFC 822 string or a structured array of contact objects.  When a string is provided it is parsed as a comma-separated list of RFC 822 addresses (supporting the `\"Name <email>\"` and bare `email` formats).  When an array is provided each entry must have at least an `email` field with an optional `name` field.
*/
sealed trait EmailAddressesTypes
object EmailAddressesTypes {
  import io.circe.{ Decoder, Encoder }
  import io.circe.syntax._
  import cats.syntax.functor._

// no discriminator
  implicit val emailAddressesTypesEncoder: Encoder[EmailAddressesTypes] = Encoder.instance {
    case list_EmailAddressName: List[EmailAddressName] => list_EmailAddressName.asJson
    case string: String => string.asJson
  }

  implicit val emailAddressesTypesDecoder: Decoder[EmailAddressesTypes] =
    List[Decoder[EmailAddressesTypes]](
      Decoder[List[EmailAddressName]].widen,
      Decoder[String].widen,
  ).reduceLeft(_ or _)
}


/**
* The response body returned when an error occurs.
* @param code The HTTP-style status code associated with the error.
* @param message A human-readable description of the error.
*/

case class ErrorMessage(
  code: Int,
  message: String
)
object ErrorMessage {
  implicit val encoderErrorMessage: Encoder[ErrorMessage] = deriveEncoder[ErrorMessage].mapJson(_.dropNullValues)
  implicit val decoderErrorMessage: Decoder[ErrorMessage] = deriveDecoder[ErrorMessage]
}

/**
* Standard success response returned by write operations (send, add rule, delete, etc.).  The `status` field is always `\"ok\"` on success.  The `text` field carries operation-specific data — for sending calls it contains the relay transaction ID; for create calls it contains the new record's ID; for delete calls it contains a confirmation string.
* @param status Always `\"ok\"` on success.
* @param text Operation-specific result string.  For send operations this is the relay transaction ID (e.g. `185caa69ff7000f47c`) which can be used as the `mailid` parameter in `GET /mail/log`.  For create operations this is the new record's numeric ID.  For delete operations this is a human-readable confirmation.
*/

case class GenericResponse(
  status: String,
  text: String
)
object GenericResponse {
  implicit val encoderGenericResponse: Encoder[GenericResponse] = deriveEncoder[GenericResponse].mapJson(_.dropNullValues)
  implicit val decoderGenericResponse: Decoder[GenericResponse] = deriveDecoder[GenericResponse]
}

/**
* A file attachment for use with `POST /mail/advsend`.  The file content must be base64-encoded.  The `filename` is shown to recipients in their email client.
* @param filename The filename shown to recipients (e.g. `report.pdf`, `invoice.xlsx`).
* @param data The file contents as a base64-encoded string.  Decode this to retrieve the original binary file.
*/

case class MailAttachment(
  filename: String,
  data: ByteArray
)
object MailAttachment {
  implicit val encoderMailAttachment: Encoder[MailAttachment] = deriveEncoder[MailAttachment].mapJson(_.dropNullValues)
  implicit val decoderMailAttachment: Decoder[MailAttachment] = deriveDecoder[MailAttachment]
}

/**
* A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (`LOCAL_BL_RCPT` or `MBTRAP`). The `from` address can be passed to `POST /mail/blocks/delete` to delist it.
* @param date The date the block event was recorded.
* @param from The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it.
* @param subject The `Subject` header of the blocked message.
* @param to The serialized list of recipients of the blocked message.
* @param messageId The `Message-ID` header of the blocked message, or `null` if not present.
*/

case class MailBlockClickHouse(
  date: LocalDate,
  from: String,
  subject: String,
  to: String,
  messageId: Option[String]
)
object MailBlockClickHouse {
  implicit val encoderMailBlockClickHouse: Encoder[MailBlockClickHouse] = deriveEncoder[MailBlockClickHouse].mapJson(_.dropNullValues)
  implicit val decoderMailBlockClickHouse: Decoder[MailBlockClickHouse] = deriveDecoder[MailBlockClickHouse]
}

/**
* A block pattern sourced from the rspamd database.  Represents a sender whose recent messages contained suspicious subject lines (e.g. containing relay/proxy strings) repeated more than 4 times in the last 3 days. The `from` address can be passed to `POST /mail/blocks/delete` to delist it.
* @param from The sender email address.  Pass this value as `email` to `POST /mail/blocks/delete` to delist the sender.
* @param subject The suspicious subject pattern that triggered the block.
*/

case class MailBlockRspamd(
  from: String,
  subject: String
)
object MailBlockRspamd {
  implicit val encoderMailBlockRspamd: Encoder[MailBlockRspamd] = deriveEncoder[MailBlockRspamd].mapJson(_.dropNullValues)
  implicit val decoderMailBlockRspamd: Decoder[MailBlockRspamd] = deriveDecoder[MailBlockRspamd]
}

/**
* The complete set of blocked addresses and message patterns returned by `GET /mail/blocks`. Three independent block sources are combined into one response. Use `POST /mail/blocks/delete` with a `from` address from any entry to delist it.
* @param local Messages flagged by the `LOCAL_BL_RCPT` rspamd rule in the last 5 days. These are messages sent to recipients on a local block list.
* @param mbtrap Messages flagged by the `MBTRAP` rspamd rule in the last 5 days. These triggered MailBaby's honeypot / trap address detection.
* @param subject Senders whose messages contained spam-indicative subjects (containing `@`, `smtp`, `socks4`, or `socks5`) with more than 4 occurrences of the same subject in the last 3 days.
*/

case class MailBlocks(
  local: List[MailBlockClickHouse],
  mbtrap: List[MailBlockClickHouse],
  subject: List[MailBlockRspamd]
)
object MailBlocks {
  implicit val encoderMailBlocks: Encoder[MailBlocks] = deriveEncoder[MailBlocks].mapJson(_.dropNullValues)
  implicit val decoderMailBlocks: Decoder[MailBlocks] = deriveDecoder[MailBlocks]
}

/**
* Paginated mail log response returned by `GET /mail/log`.  Contains the full matched count (`total`) plus a page of `MailLogEntry` records.  Use `skip` and `limit` to page through large result sets.
* @param total Total number of log entries that match the supplied filters, regardless of `skip` and `limit`.  Use this to calculate the number of pages: `ceil(total / limit)`.
* @param skip The `skip` value used for this page (echoed from the request).
* @param limit The `limit` value used for this page (echoed from the request).
* @param emails 
*/

case class MailLog(
  total: Int,
  skip: Int,
  limit: Int,
  emails: List[MailLogEntry]
)
object MailLog {
  implicit val encoderMailLog: Encoder[MailLog] = deriveEncoder[MailLog].mapJson(_.dropNullValues)
  implicit val decoderMailLog: Decoder[MailLog] = deriveDecoder[MailLog]
}

/**
* A single email record in the mail log.  Combines data from the message store (envelope metadata), the queue release table (delivery status and response), and the sender delivery table (MX routing details).  Key field relationships with other API calls: - The `id` field matches the `mailid` query parameter on `GET /mail/log` and   the `text` field of a successful send response. - The `from` address can be passed to `POST /mail/blocks/delete` to delist a   flagged sender. - The `user` field is the SMTP username (e.g. `mb5658`) corresponding to the   `username` field in `GET /mail` / `GET /mail/{id}`.
* @param Underscoreid Internal auto-increment database row ID.  Not meaningful outside the API.
* @param id The relay-assigned mail ID (18–19 hex characters).  This is the value returned as `text` by the sending endpoints and accepted as the `mailid` filter on `GET /mail/log`.
* @param from SMTP envelope `MAIL FROM` address (may differ from the `From:` header).
* @param to SMTP envelope `RCPT TO` address.
* @param created Human-readable creation timestamp in `YYYY-MM-DD HH:MM:SS` format.
* @param time Unix timestamp of message acceptance.  Corresponds to the `startDate` and `endDate` filter parameters on `GET /mail/log`.
* @param user The SMTP AUTH username used to submit the message (e.g. `mb5658`). Corresponds to the `username` field in `GET /mail` orders.
* @param transtype SMTP transaction type negotiated with the relay (e.g. `ESMTPSA`).
* @param origin IP address of the client that submitted the message to the relay. Corresponds to the `origin` filter parameter on `GET /mail/log`.
* @param `interface` Relay interface name that accepted the message (e.g. `feeder`).
* @param subject The `Subject` header value, if available.
* @param messageId The `Message-ID` header value, if present.  Can be used with the `messageId` filter on `GET /mail/log` for subsequent lookups.
* @param sendingZone The sending zone assigned by the relay for outbound delivery.
* @param bodySize Size of the message body in bytes.
* @param seq Sequence index of this recipient in a multi-recipient message. Starts at 1.
* @param delivered Delivery status flag.  `1` = successfully delivered to destination MX. `0` = queued, deferred, or failed.  `null` = delivery not yet attempted. Corresponds to the `delivered` filter parameter on `GET /mail/log`.
* @param code The SMTP response code from the destination MX server (e.g. `250` for success, `550` for permanent failure).
* @param response The SMTP response string received from the destination MX server upon delivery attempt (e.g. `\"250 2.0.0 Ok queued as C91D83E128C\"`).
* @param recipient The specific recipient address this delivery record is for.
* @param domain The destination domain.  Corresponds to the `mx` filter parameter (which matches `mxHostname`, not `domain`) on `GET /mail/log`.
* @param locked Whether the queue entry is currently locked for delivery processing.
* @param lockTime Millisecond-precision timestamp of the last queue lock acquisition.
* @param assigned The relay server node assigned to deliver this message.
* @param queued ISO 8601 timestamp when the message was placed into the delivery queue.
* @param mxHostname The MX hostname the relay connected to for delivery.  Corresponds to the `mx` filter parameter on `GET /mail/log`.
*/

case class MailLogEntry(
  Underscoreid: Int,
  id: Refined[String, MinSize[18] And MaxSize[19]],
  from: String,
  to: String,
  created: String,
  time: Int,
  user: String,
  transtype: String,
  origin: String,
  `interface`: String,
  subject: Option[String],
  messageId: Option[String],
  sendingZone: Option[String],
  bodySize: Option[Int],
  seq: Option[Int],
  delivered: Option[Int],
  code: Option[Int],
  response: Option[String],
  recipient: Option[String],
  domain: Option[String],
  locked: Option[Int],
  lockTime: Option[String],
  assigned: Option[String],
  queued: Option[String],
  mxHostname: Option[String]
)
object MailLogEntry {
  implicit val encoderMailLogEntry: Encoder[MailLogEntry] = deriveEncoder[MailLogEntry].mapJson(_.dropNullValues)
  implicit val decoderMailLogEntry: Decoder[MailLogEntry] = deriveDecoder[MailLogEntry]
}

/**
* A mail service order record.  Each order represents one provisioned sending account with a dedicated SMTP username.  The `id` is the numeric identifier used across most API calls.  The `username` is always `mb<id>` and is the SMTP AUTH username for `relay.mailbaby.net`.
* @param id The unique numeric ID of the mail order.  Used as the `id` parameter on sending calls, log queries, and stats queries.
* @param status The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send.
* @param username The SMTP AUTH username for this order, always in the format `mb<id>`. Use together with the password from `GET /mail/{id}` to authenticate directly against `relay.mailbaby.net:25` if needed.
* @param comment Optional human-readable note associated with the order.  Only present in the response when the order has a non-empty comment.
*/

case class MailOrder(
  id: Int,
  status: String,
  username: Refined[String, MatchesRegex["^mb\\d+$"]],
  comment: Option[String]
)
object MailOrder {
  implicit val encoderMailOrder: Encoder[MailOrder] = deriveEncoder[MailOrder].mapJson(_.dropNullValues)
  implicit val decoderMailOrder: Decoder[MailOrder] = deriveDecoder[MailOrder]
}

/**
* Extended mail order record including the current SMTP password.  Returned by `GET /mail/{id}`.  The `username` and `password` fields can be used to authenticate directly against `relay.mailbaby.net:25` via SMTP AUTH if you prefer to send via a native SMTP client rather than the REST API.
* @param id The unique numeric ID of the mail order.  Used as the `id` parameter on sending calls, log queries, and stats queries.
* @param status The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send.
* @param username The SMTP AUTH username for this order, always in the format `mb<id>`. Use together with the password from `GET /mail/{id}` to authenticate directly against `relay.mailbaby.net:25` if needed.
* @param password The current SMTP AUTH password for this mail order.  Use with the `username` field to authenticate against `relay.mailbaby.net:25`.
* @param comment Optional human-readable note associated with the order.  Only present in the response when the order has a non-empty comment.
*/

case class MailOrderDetail(
  id: Int,
  status: String,
  username: Refined[String, MatchesRegex["^mb\\d+$"]],
  password: String,
  comment: Option[String]
)
object MailOrderDetail {
  implicit val encoderMailOrderDetail: Encoder[MailOrderDetail] = deriveEncoder[MailOrderDetail].mapJson(_.dropNullValues)
  implicit val decoderMailOrderDetail: Decoder[MailOrderDetail] = deriveDecoder[MailOrderDetail]
}

/**
* 
* @param password The current SMTP AUTH password for this mail order.  Use with the `username` field to authenticate against `relay.mailbaby.net:25`.
*/

case class MailOrderPassword(
  password: String
)
object MailOrderPassword {
  implicit val encoderMailOrderPassword: Encoder[MailOrderPassword] = deriveEncoder[MailOrderPassword].mapJson(_.dropNullValues)
  implicit val decoderMailOrderPassword: Decoder[MailOrderPassword] = deriveDecoder[MailOrderPassword]
}

/**
* Account usage statistics returned by `GET /mail/stats`.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.
* @param time The time window these `received`, `sent`, and `volume` statistics cover.
* @param usage Total messages accepted during the current billing cycle.  Used to calculate the `cost` value.
* @param currency The ISO 4217 currency code for this account (e.g. `USD`).
* @param cost Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails).
* @param received Count of messages accepted by the relay within the selected `time` window. Includes messages still in queue.
* @param sent Count of messages successfully delivered to the destination MX within the selected `time` window.  Will be ≤ `received`.
* @param volume 
*/

case class MailStatsType(
  time: Option[String],
  usage: Option[Int],
  currency: Option[String],
  cost: Option[Double],
  received: Option[Int],
  sent: Option[Int],
  volume: Option[MailStatsVolume]
)
object MailStatsType {
  implicit val encoderMailStatsType: Encoder[MailStatsType] = deriveEncoder[MailStatsType].mapJson(_.dropNullValues)
  implicit val decoderMailStatsType: Decoder[MailStatsType] = deriveDecoder[MailStatsType]
}

/**
* Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.
* @param to Message counts keyed by destination (envelope `to`) email address.
* @param from Message counts keyed by sender (envelope `from`) email address.
* @param ip Message counts keyed by originating client IP address.
*/

case class MailStatsVolume(
  to: Option[Map[String, Int]],
  from: Option[Map[String, Int]],
  ip: Option[Map[String, Int]]
)
object MailStatsVolume {
  implicit val encoderMailStatsVolume: Encoder[MailStatsVolume] = deriveEncoder[MailStatsVolume].mapJson(_.dropNullValues)
  implicit val decoderMailStatsVolume: Decoder[MailStatsVolume] = deriveDecoder[MailStatsVolume]
}

/**
* Request body for `POST /mail/send`.  Sends a simple single-recipient message. HTML detection is automatic — if `body` contains HTML tags the message is sent as `text/html`; otherwise as `text/plain`.  The `from` address is automatically set as both the `From` and `Reply-To` headers.  For multiple recipients, CC/BCC, attachments, or per-field Reply-To control, use `POST /mail/advsend` instead.
* @param to 
* @param from The sender address.  This is used as both the `From` header and the `Reply-To` header automatically.  Must be a valid email address authorized for your mail order.
* @param subject The subject line of the email.
* @param body The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.
* @param id Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.
*/

case class SendMail(
  to: SendMailTo,
  from: String,
  subject: String,
  body: String,
  id: Option[Long]
)
object SendMail {
  implicit val encoderSendMail: Encoder[SendMail] = deriveEncoder[SendMail].mapJson(_.dropNullValues)
  implicit val decoderSendMail: Decoder[SendMail] = deriveDecoder[SendMail]
}

/**
* Request body for `POST /mail/advsend`.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (`from`, `to`, `replyto`, `cc`, `bcc`) each accept either a plain RFC 822 string (e.g. `\"Joe <joe@example.com>\"` or a comma-separated list) or a structured array of `{\"email\": \"...\", \"name\": \"...\"}` objects.  HTML detection is automatic based on whether `body` contains HTML tags.
* @param subject The subject line of the email.
* @param body The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.
* @param from The sender address.  Accepts a plain email string, an RFC 822 named string (`\"Name <email>\"`), or a `{\"email\": \"...\", \"name\": \"...\"}` object.
* @param to One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.
* @param replyto Optional.  One or more addresses to set as the `Reply-To` header. When recipients reply to the message their email client will address the reply to these addresses instead of `from`.
* @param cc Optional.  Carbon-copy recipients.  These addresses are listed in the `Cc` header and are visible to all recipients.
* @param bcc Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.
* @param attachments Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name.
* @param id Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.
*/

case class SendMailAdv(
  subject: String,
  body: String,
  from: EmailAddressTypes,
  to: EmailAddressesTypes,
  replyto: Option[EmailAddressesTypes],
  cc: Option[EmailAddressesTypes],
  bcc: Option[EmailAddressesTypes],
  attachments: Option[List[MailAttachment]],
  id: Option[Long]
)
object SendMailAdv {
  implicit val encoderSendMailAdv: Encoder[SendMailAdv] = deriveEncoder[SendMailAdv].mapJson(_.dropNullValues)
  implicit val decoderSendMailAdv: Decoder[SendMailAdv] = deriveDecoder[SendMailAdv]
}

/**
* Request body for `POST /mail/rawsend`.  Accepts a complete RFC 822 message (all headers and body) as a verbatim string.  The relay injects it without modification, preserving any existing `DKIM-Signature` header intact.  The `From`, `To`, `Cc`, and `Bcc` addresses are extracted from the message headers automatically — you do not need to specify them separately.
* @param rawUnderscoreemail The complete RFC 822 email message including all headers and the body. Must include at minimum `From`, `To`, `Subject`, `Date`, and `MIME-Version` headers.  DKIM signatures in the `DKIM-Signature` header are transmitted verbatim and will pass verification at the destination.
* @param id Optional numeric ID of the mail order to use for SMTP authentication. If omitted the first active order on your account is used.  Valid IDs are returned by `GET /mail`.
*/

case class SendMailRaw(
  rawUnderscoreemail: String,
  id: Option[Long]
)
object SendMailRaw {
  implicit val encoderSendMailRaw: Encoder[SendMailRaw] = deriveEncoder[SendMailRaw].mapJson(_.dropNullValues)
  implicit val decoderSendMailRaw: Decoder[SendMailRaw] = deriveDecoder[SendMailRaw]
}

/**
* The primary recipient address for a simple send request. Accepts a single email address string or an array of email address strings for multiple recipients.
*/
sealed trait SendMailTo
object SendMailTo {
  import io.circe.{ Decoder, Encoder }
  import io.circe.syntax._
  import cats.syntax.functor._

// no discriminator
  implicit val sendMailToEncoder: Encoder[SendMailTo] = Encoder.instance {
    case list_String: List[String] => list_String.asJson
    case string: String => string.asJson
  }

  implicit val sendMailToDecoder: Decoder[SendMailTo] =
    List[Decoder[SendMailTo]](
      Decoder[List[String]].widen,
      Decoder[String].widen,
  ).reduceLeft(_ or _)
}


