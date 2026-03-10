
package org.openapitools.client.model


case class DenyRuleNew (
    /* The type of deny rule. */
    _type: String,
    /* The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`. */
    _data: String,
    /* Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`. */
    _user: Option[String]
)
object DenyRuleNew {
    def toStringBody(var_type: Object, var_data: Object, var_user: Object) =
        s"""
        | {
        | "type":$var_type,"data":$var_data,"user":$var_user
        | }
        """.stripMargin
}
