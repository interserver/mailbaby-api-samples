
package org.openapitools.client.model


case class SendMailAdvCcInner (
    /* The email address */
    _email: String,
    /* (optional) Name to use for the CC contact. */
    _name: Option[String]
)
object SendMailAdvCcInner {
    def toStringBody(var_email: Object, var_name: Object) =
        s"""
        | {
        | "email":$var_email,"name":$var_name
        | }
        """.stripMargin
}
