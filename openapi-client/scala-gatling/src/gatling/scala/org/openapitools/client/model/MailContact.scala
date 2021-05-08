
package org.openapitools.client.model


case class MailContact (
    /* The email address */
    _email: String,
    /* Optional contact name */
    _name: Option[String]
)
object MailContact {
    def toStringBody(var_email: Object, var_name: Object) =
        s"""
        | {
        | "email":$var_email,"name":$var_name
        | }
        """.stripMargin
}
