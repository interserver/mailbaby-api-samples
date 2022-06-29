
package org.openapitools.client.model


case class GetMailOrders401Response (
    _code: String,
    _message: String
)
object GetMailOrders401Response {
    def toStringBody(var_code: Object, var_message: Object) =
        s"""
        | {
        | "code":$var_code,"message":$var_message
        | }
        """.stripMargin
}
