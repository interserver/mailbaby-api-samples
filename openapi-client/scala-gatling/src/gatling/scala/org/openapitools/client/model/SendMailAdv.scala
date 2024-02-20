
package org.openapitools.client.model


case class SendMailAdv (
    /* The subject or title of the email */
    _subject: String,
    /* The main email contents. */
    _body: String,
    _from: EmailAddressTypes,
    _to: EmailAddressesTypes,
    _replyto: Option[EmailAddressesTypes],
    _cc: Option[EmailAddressesTypes],
    _bcc: Option[EmailAddressesTypes],
    /* (optional) File attachments to include in the email.  The file contents must be base64 encoded! */
    _attachments: Option[List[MailAttachment]],
    /* (optional)  ID of the Mail order within our system to use as the Mail Account. */
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
