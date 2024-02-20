package io.swagger.server.model


/**
 * = SendMailAdv =
 *
 * Details for an Email
 *
 * @param subject The subject or title of the email for example: ''Your Package has been Delivered!''
 * @param body The main email contents. for example: ''The package you ordered on 2021-01-23 has been delivered. If the package is broken into many pieces, please blaim someone else.''
 * @param from 
 * @param to 
 * @param replyto 
 * @param cc 
 * @param bcc 
 * @param attachments (optional) File attachments to include in the email.  The file contents must be base64 encoded! for example: ''[
        {
            "filename": "text.txt",
            "data": "base64_encoded_contents"
        }
]''
 * @param id (optional)  ID of the Mail order within our system to use as the Mail Account. for example: ''5000''
 */
case class SendMailAdv (
  subject: String,
  body: String,
  from: EmailAddressTypes,
  to: EmailAddressesTypes,
  replyto: Option[EmailAddressesTypes],
  cc: Option[EmailAddressesTypes],
  bcc: Option[EmailAddressesTypes],
  attachments: Option[List[MailAttachment]],
  id: Option[Long]
)

