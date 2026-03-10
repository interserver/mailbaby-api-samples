
package org.openapitools.client.model


case class MailOrderDetail (
    /* The unique numeric ID of the mail order.  Used as the `id` parameter on sending calls, log queries, and stats queries. */
    _id: Integer,
    /* The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send. */
    _status: String,
    /* The SMTP AUTH username for this order, always in the format `mb<id>`. Use together with the password from `GET /mail/{id}` to authenticate directly against `relay.mailbaby.net:25` if needed. */
    _username: String,
    /* The current SMTP AUTH password for this mail order.  Use with the `username` field to authenticate against `relay.mailbaby.net:25`. */
    _password: String,
    /* Optional human-readable note associated with the order. */
    _comment: Option[String]
)
object MailOrderDetail {
    def toStringBody(var_id: Object, var_status: Object, var_username: Object, var_password: Object, var_comment: Object) =
        s"""
        | {
        | "id":$var_id,"status":$var_status,"username":$var_username,"password":$var_password,"comment":$var_comment
        | }
        """.stripMargin
}
