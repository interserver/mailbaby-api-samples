
package org.openapitools.client.model

import java.time.OffsetDateTime

case class DenyRuleRecord (
    /* The type of deny rule. */
    _type: String,
    /* The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`. */
    _data: String,
    /* The numeric ID of the deny rule, as a string.  Pass this as `ruleId` to `DELETE /mail/rules/{ruleId}` to remove the rule. */
    _id: String,
    /* The timestamp when the rule was created. */
    _created: OffsetDateTime,
    /* Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`. */
    _user: Option[String]
)
object DenyRuleRecord {
    def toStringBody(var_type: Object, var_data: Object, var_id: Object, var_created: Object, var_user: Object) =
        s"""
        | {
        | "type":$var_type,"data":$var_data,"id":$var_id,"created":$var_created,"user":$var_user
        | }
        """.stripMargin
}
