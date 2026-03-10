
package org.openapitools.client.model


case class EmailAddressParam (
    /* The email address to delist from all block lists. */
    _email: String
)
object EmailAddressParam {
    def toStringBody(var_email: Object) =
        s"""
        | {
        | "email":$var_email
        | }
        """.stripMargin
}
