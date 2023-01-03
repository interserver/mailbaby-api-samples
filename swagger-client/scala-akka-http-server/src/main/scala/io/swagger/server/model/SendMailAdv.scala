package io.swagger.server.model


/**
 * = Email details =
 *
 * Details for an Email
 *
 * @param subject The subject or title of the email for example: ''Your Package has been Delivered!''
 * @param body The main email contents. for example: ''The package you ordered on 2021-01-23 has been delivered. If the package is broken into many pieces, please blaim someone else.''
 * @param from 
 * @param to A list of destionation email addresses to send this to
 * @param replyto (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address.
 * @param cc (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.
 * @param bcc (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.
 * @param attachments (optional) File attachments to include in the email.  The file contents must be base64 encoded!
 * @param id (optional)  ID of the Mail order within our system to use as the Mail Account. for example: ''5000''
 */
case class SendMailAdv (
  subject: String,
  body: String,
  from: SendMailAdv_from,
  to: List[SendMailAdv_to],
  replyto: Option[List[SendMailAdv_replyto]],
  cc: Option[List[SendMailAdv_cc]],
  bcc: Option[List[SendMailAdv_bcc]],
  attachments: Option[List[SendMailAdv_attachments]],
  id: Option[Long]
)

