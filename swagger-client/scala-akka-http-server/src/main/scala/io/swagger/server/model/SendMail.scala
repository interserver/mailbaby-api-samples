package io.swagger.server.model


/**
 * Details for an Email
 *
 * @param id The ID of the Mail order within our system to use as the Mail Account.
 * @param from 
 * @param to The Contact whom is the primary recipient of this email.
 * @param subject The subject or title of the email for example: ''Your Package has been Delivered!''
 * @param body The main email contents. for example: ''The package you ordered on 2021-01-23 has been delivered. If the package is broken into many pieces, please blaim someone else.
''
 * @param replyto Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address.
 * @param cc Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.
 * @param bcc Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.
 * @param attachments Optional file attachments to include in the email
 */
case class SendMail (
  id: Long,
  from: MailContact,
  to: List[MailContact],
  subject: String,
  body: String,
  replyto: Option[List[MailContact]],
  cc: Option[List[MailContact]],
  bcc: Option[List[MailContact]],
  attachments: Option[List[MailAttachment]]
)
