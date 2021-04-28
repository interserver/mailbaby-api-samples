
package org.openapitools.client.model


case class GenericResponse (
    _status: Option[String],
    _statusText: Option[String]
)
object GenericResponse {
    def toStringBody(var_status: Object, var_statusText: Object) =
        s"""
        | {
        | "status":$var_status,"statusText":$var_statusText
        | }
        """.stripMargin
}
