
package org.openapitools.client.model


case class MailOrder (
    _id: Integer,
    _status: String,
    _username: String,
    _password: Option[String],
    _comment: Option[String]
)
object MailOrder {
    def toStringBody(var_id: Object, var_status: Object, var_username: Object, var_password: Object, var_comment: Object) =
        s"""
        | {
        | "id":$var_id,"status":$var_status,"username":$var_username,"password":$var_password,"comment":$var_comment
        | }
        """.stripMargin
}
