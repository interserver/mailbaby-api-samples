
package org.openapitools.client.model


case class ErrorMessage (
    /* The response code associated with the error. */
    _code: Integer,
    /* The details or description of the error. */
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
