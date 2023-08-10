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
/* The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com. */
  data: String,
/* The deny rule Id number. */
  id: Integer,
/* the date the rule was created. */
  created: OffsetDateTime,
/* Mail account username that will be tied to this rule.  If not specified the first active mail order will be used. */
  user: Option[String])

object DenyRuleRecord {
  import DateTimeCodecs._
  sealed trait `Type`
  case object Domain extends `Type`
  case object Email extends `Type`
  case object Startswith extends `Type`

  object `Type` {
    def to`Type`(s: String): Option[`Type`] = s match {
      case "Domain" => Some(Domain)
      case "Email" => Some(Email)
      case "Startswith" => Some(Startswith)
      case _ => None
    }

    def from`Type`(x: `Type`): String = x match {
      case Domain => "Domain"
      case Email => "Email"
      case Startswith => "Startswith"
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
