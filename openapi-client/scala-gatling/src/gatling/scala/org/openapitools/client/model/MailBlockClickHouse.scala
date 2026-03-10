
package org.openapitools.client.model

import java.time.LocalDate

case class MailBlockClickHouse (
    /* The date the block event was recorded. */
    _date: LocalDate,
    /* The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it. */
    _from: String,
    /* The `Subject` header of the blocked message. */
    _subject: String,
    /* The serialized list of recipients of the blocked message. */
    _to: String,
    /* The `Message-ID` header of the blocked message, or `null` if not present. */
    _messageId: Option[String]
)
object MailBlockClickHouse {
    def toStringBody(var_date: Object, var_from: Object, var_subject: Object, var_to: Object, var_messageId: Object) =
        s"""
        | {
        | "date":$var_date,"from":$var_from,"subject":$var_subject,"to":$var_to,"messageId":$var_messageId
        | }
        """.stripMargin
}
