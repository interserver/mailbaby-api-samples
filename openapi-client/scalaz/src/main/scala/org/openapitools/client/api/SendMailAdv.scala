package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import SendMailAdv._

case class SendMailAdv (
  /* The subject line of the email. */
  subject: String,
/* The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`. */
  body: String,
/* The sender address.  Accepts a plain email string, an RFC 822 named string (`\"Name <email>\"`), or a `{\"email\": \"...\", \"name\": \"...\"}` object. */
  from: EmailAddressTypes,
/* One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects. */
  to: EmailAddressesTypes,
/* Optional.  One or more addresses to set as the `Reply-To` header. When recipients reply to the message their email client will address the reply to these addresses instead of `from`. */
  replyto: Option[EmailAddressesTypes],
/* Optional.  Carbon-copy recipients.  These addresses are listed in the `Cc` header and are visible to all recipients. */
  cc: Option[EmailAddressesTypes],
/* Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header. */
  bcc: Option[EmailAddressesTypes],
/* Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name. */
  attachments: Option[List[MailAttachment]],
/* Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`. */
  id: Option[Long])

object SendMailAdv {
  import DateTimeCodecs._

  implicit val SendMailAdvCodecJson: CodecJson[SendMailAdv] = CodecJson.derive[SendMailAdv]
  implicit val SendMailAdvDecoder: EntityDecoder[SendMailAdv] = jsonOf[SendMailAdv]
  implicit val SendMailAdvEncoder: EntityEncoder[SendMailAdv] = jsonEncoderOf[SendMailAdv]
}
