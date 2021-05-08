
package org.openapitools.client.model


case class ErrorResponse (
    _code: String,
    _message: String
)
object ErrorResponse {
    def toStringBody(var_code: Object, var_message: Object) =
        s"""
        | {
        | "code":$var_code,"message":$var_message
        | }
        """.stripMargin
}
