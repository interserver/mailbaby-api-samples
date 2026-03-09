
package org.openapitools.client.model


case class SendMailRaw (
    /* The entire email contents */
    _raw_email: String,
    /* Optional order id */
    _id: Option[Integer]
)
object SendMailRaw {
    def toStringBody(var_raw_email: Object, var_id: Object) =
        s"""
        | {
        | "raw_email":$var_raw_email,"id":$var_id
        | }
        """.stripMargin
}
