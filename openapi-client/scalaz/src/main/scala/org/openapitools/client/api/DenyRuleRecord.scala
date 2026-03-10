package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime

import DenyRuleRecord._

case class DenyRuleRecord (
  /* The type of deny rule. */
  `type`: `Type`,
/* The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`. */
  data: String,
/* The numeric ID of the deny rule, as a string.  Pass this as `ruleId` to `DELETE /mail/rules/{ruleId}` to remove the rule. */
  id: String,
/* The timestamp when the rule was created. */
  created: OffsetDateTime,
/* Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`. */
  user: Option[String])

object DenyRuleRecord {
  import DateTimeCodecs._
  sealed trait `Type`
  case object Domain extends `Type`
  case object Email extends `Type`
  case object Startswith extends `Type`
  case object Destination extends `Type`

  object `Type` {
    def to`Type`(s: String): Option[`Type`] = s match {
      case "Domain" => Some(Domain)
      case "Email" => Some(Email)
      case "Startswith" => Some(Startswith)
      case "Destination" => Some(Destination)
      case _ => None
    }

    def from`Type`(x: `Type`): String = x match {
      case Domain => "Domain"
      case Email => "Email"
      case Startswith => "Startswith"
      case Destination => "Destination"
    }
  }

  implicit val `Type`EnumEncoder: EncodeJson[`Type`] =
    EncodeJson[`Type`](is => StringEncodeJson(`Type`.from`Type`(is)))

  implicit val `Type`EnumDecoder: DecodeJson[`Type`] =
    DecodeJson.optionDecoder[`Type`](n => n.string.flatMap(jStr => `Type`.to`Type`(jStr)), "`Type` failed to de-serialize")

  implicit val DenyRuleRecordCodecJson: CodecJson[DenyRuleRecord] = CodecJson.derive[DenyRuleRecord]
  implicit val DenyRuleRecordDecoder: EntityDecoder[DenyRuleRecord] = jsonOf[DenyRuleRecord]
  implicit val DenyRuleRecordEncoder: EntityEncoder[DenyRuleRecord] = jsonEncoderOf[DenyRuleRecord]
}
