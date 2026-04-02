
package org.openapitools.client.model


case class EmailAddressName (
    /* The email address. */
    _email: String,
    /* Optional display name shown to recipients (e.g. in the `From:` header). */
    _name: Option[String]
)
object EmailAddressName {
    def toStringBody(var_email: Object, var_name: Object) =
        s"""
        | {
        | "email":$var_email,"name":$var_name
        | }
        """.stripMargin
}
