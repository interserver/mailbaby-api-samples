
package org.openapitools.client.model


case class SendMailAdvFrom (
    /* The email address */
    _email: String,
    /* Optional contact name */
    _name: Option[String]
)
object SendMailAdvFrom {
    def toStringBody(var_email: Object, var_name: Object) =
        s"""
        | {
        | "email":$var_email,"name":$var_name
        | }
        """.stripMargin
}