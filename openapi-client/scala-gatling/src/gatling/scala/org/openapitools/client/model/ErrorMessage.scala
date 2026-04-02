
package org.openapitools.client.model


case class ErrorMessage (
    /* The HTTP-style status code associated with the error. */
    _code: Integer,
    /* A human-readable description of the error. */
    _message: String
)
object ErrorMessage {
    def toStringBody(var_code: Object, var_message: Object) =
        s"""
        | {
        | "code":$var_code,"message":$var_message
        | }
        """.stripMargin
}
