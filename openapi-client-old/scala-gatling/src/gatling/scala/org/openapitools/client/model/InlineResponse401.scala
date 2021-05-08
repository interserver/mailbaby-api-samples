
package org.openapitools.client.model


case class InlineResponse401 (
    _code: String,
    _message: String
)
object InlineResponse401 {
    def toStringBody(var_code: Object, var_message: Object) =
        s"""
        | {
        | "code":$var_code,"message":$var_message
        | }
        """.stripMargin
}
