
package org.openapitools.client.model


case class SendMailRaw (
    /* The entire email contents */
    _rawEmail: String,
    /* Optional order id */
    _id: Option[Integer]
)
object SendMailRaw {
    def toStringBody(var_rawEmail: Object, var_id: Object) =
        s"""
        | {
        | "rawEmail":$var_rawEmail,"id":$var_id
        | }
        """.stripMargin
}
