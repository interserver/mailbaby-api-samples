package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime

import DenyRuleRecordAllOf._

case class DenyRuleRecordAllOf (
  /* The deny rule Id number. */
  id: Integer,
/* the date the rule was created. */
  created: OffsetDateTime)

object DenyRuleRecordAllOf {
  import DateTimeCodecs._

  implicit val DenyRuleRecordAllOfCodecJson: CodecJson[DenyRuleRecordAllOf] = CodecJson.derive[DenyRuleRecordAllOf]
  implicit val DenyRuleRecordAllOfDecoder: EntityDecoder[DenyRuleRecordAllOf] = jsonOf[DenyRuleRecordAllOf]
  implicit val DenyRuleRecordAllOfEncoder: EntityEncoder[DenyRuleRecordAllOf] = jsonEncoderOf[DenyRuleRecordAllOf]
}
