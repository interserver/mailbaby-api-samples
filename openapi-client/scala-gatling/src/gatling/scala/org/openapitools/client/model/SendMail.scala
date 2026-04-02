
package org.openapitools.client.model


case class SendMail (
    _to: SendMailTo,
    /* The sender address.  This is used as both the `From` header and the `Reply-To` header automatically.  Must be a valid email address authorized for your mail order. */
    _from: String,
    /* The subject line of the email. */
    _subject: String,
    /* The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`. */
    _body: String,
    /* Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`. */
    _id: Option[Long]
)
object SendMail {
    def toStringBody(var_to: Object, var_from: Object, var_subject: Object, var_body: Object, var_id: Object) =
        s"""
        | {
        | "to":$var_to,"from":$var_from,"subject":$var_subject,"body":$var_body,"id":$var_id
        | }
        """.stripMargin
}
