
package org.openapitools.client.model


case class SendMailRaw (
    /* The complete RFC 822 email message including all headers and the body. Must include at minimum `From`, `To`, `Subject`, `Date`, and `MIME-Version` headers.  DKIM signatures in the `DKIM-Signature` header are transmitted verbatim and will pass verification at the destination. */
    _raw_email: String,
    /* Optional numeric ID of the mail order to use for SMTP authentication. If omitted the first active order on your account is used.  Valid IDs are returned by `GET /mail`. */
    _id: Option[Long]
)
object SendMailRaw {
    def toStringBody(var_raw_email: Object, var_id: Object) =
        s"""
        | {
        | "raw_email":$var_raw_email,"id":$var_id
        | }
        """.stripMargin
}
