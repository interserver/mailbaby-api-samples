
package org.openapitools.client.model


case class SendMailAdv (
    /* The subject line of the email. */
    _subject: String,
    /* The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`. */
    _body: String,
    /* The sender address.  Accepts a plain email string, an RFC 822 named string (`\"Name <email>\"`), or a `{\"email\": \"...\", \"name\": \"...\"}` object. */
    _from: EmailAddressTypes,
    /* One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects. */
    _to: EmailAddressesTypes,
    /* Optional.  One or more addresses to set as the `Reply-To` header. When recipients reply to the message their email client will address the reply to these addresses instead of `from`. */
    _replyto: Option[EmailAddressesTypes],
    /* Optional.  Carbon-copy recipients.  These addresses are listed in the `Cc` header and are visible to all recipients. */
    _cc: Option[EmailAddressesTypes],
    /* Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header. */
    _bcc: Option[EmailAddressesTypes],
    /* Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name. */
    _attachments: Option[List[MailAttachment]],
    /* Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`. */
    _id: Option[Long]
)
object SendMailAdv {
    def toStringBody(var_subject: Object, var_body: Object, var_from: Object, var_to: Object, var_replyto: Object, var_cc: Object, var_bcc: Object, var_attachments: Object, var_id: Object) =
        s"""
        | {
        | "subject":$var_subject,"body":$var_body,"from":$var_from,"to":$var_to,"replyto":$var_replyto,"cc":$var_cc,"bcc":$var_bcc,"attachments":$var_attachments,"id":$var_id
        | }
        """.stripMargin
}
