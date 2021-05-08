
package org.openapitools.client.model


case class SendMailAdv (
    /* The subject or title of the email */
    _subject: String,
    /* The main email contents. */
    _body: String,
    /* The contact whom is the this email is from. */
    _from: List[SendMailAdvFrom],
    /* The Contact whom is the primary recipient of this email. */
    _to: List[MailContact],
    /* The ID of the Mail order within our system to use as the Mail Account. */
    _id: Long,
    /* Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address. */
    _replyto: Option[List[MailContact]],
    /* Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. */
    _cc: Option[List[MailContact]],
    /* Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. */
    _bcc: Option[List[MailContact]],
    /* Optional file attachments to include in the email */
    _attachments: Option[List[MailAttachment]]
)
object SendMailAdv {
    def toStringBody(var_subject: Object, var_body: Object, var_from: Object, var_to: Object, var_id: Object, var_replyto: Object, var_cc: Object, var_bcc: Object, var_attachments: Object) =
        s"""
        | {
        | "subject":$var_subject,"body":$var_body,"from":$var_from,"to":$var_to,"id":$var_id,"replyto":$var_replyto,"cc":$var_cc,"bcc":$var_bcc,"attachments":$var_attachments
        | }
        """.stripMargin
}
