
package org.openapitools.client.model


case class GenericResponse (
    _status: Option[String],
    _text: Option[String]
)
object GenericResponse {
    def toStringBody(var_status: Object, var_text: Object) =
        s"""
        | {
        | "status":$var_status,"text":$var_text
        | }
        """.stripMargin
}
