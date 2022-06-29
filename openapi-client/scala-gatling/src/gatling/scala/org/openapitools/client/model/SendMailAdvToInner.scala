
package org.openapitools.client.model


case class SendMailAdvToInner (
    /* The email address */
    _email: String,
    /* (optional) Name to use for the destination contact. */
    _name: Option[String]
)
object SendMailAdvToInner {
    def toStringBody(var_email: Object, var_name: Object) =
        s"""
        | {
        | "email":$var_email,"name":$var_name
        | }
        """.stripMargin
}
