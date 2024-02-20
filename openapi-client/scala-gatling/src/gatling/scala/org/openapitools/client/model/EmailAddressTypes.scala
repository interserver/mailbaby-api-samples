
package org.openapitools.client.model


case class EmailAddressTypes (
    /* The email address. */
    _email: String,
    /* Name to use for the sending contact. */
    _name: Option[String]
)
object EmailAddressTypes {
    def toStringBody(var_email: Object, var_name: Object) =
        s"""
        | {
        | "email":$var_email,"name":$var_name
        | }
        """.stripMargin
}
