
package org.openapitools.client.model


case class RawMail (
    /* The entire email contents */
    _rawEmail: String
)
object RawMail {
    def toStringBody(var_rawEmail: Object) =
        s"""
        | {
        | "rawEmail":$var_rawEmail
        | }
        """.stripMargin
}
