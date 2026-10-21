import { EmailAddressesTypes } from './email-addresses-types';
import { MailAttachment } from './mail-attachment';
import { EmailAddressTypes } from './email-address-types';


/**
 * Request body for `POST /mail/advsend`.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (`from`, `to`, `replyto`, `cc`, `bcc`) each accept either a plain RFC 822 string (e.g. `\"Joe <joe@example.com>\"` or a comma-separated list) or a structured array of `{\"email\": \"...\", \"name\": \"...\"}` objects.  HTML detection is automatic based on whether `body` contains HTML tags.
 */
export interface SendMailAdv { 
  /**
   * The subject line of the email.
   */
  subject: string;
  /**
   * The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.
   */
  body: string;
  /**
   * The sender address.  Accepts a plain email string, an RFC 822 named string (`\"Name <email>\"`), or a `{\"email\": \"...\", \"name\": \"...\"}` object.
   */
  'from': EmailAddressTypes;
  /**
   * One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.
   */
  to: EmailAddressesTypes;
  /**
   * Optional.  One or more addresses to set as the `Reply-To` header. When recipients reply to the message their email client will address the reply to these addresses instead of `from`.
   */
  replyto?: EmailAddressesTypes;
  /**
   * Optional.  Carbon-copy recipients.  These addresses are listed in the `Cc` header and are visible to all recipients.
   */
  cc?: EmailAddressesTypes;
  /**
   * Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.
   */
  bcc?: EmailAddressesTypes;
  /**
   * Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name.
   */
  attachments?: Array<MailAttachment>;
  /**
   * Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.
   */
  id?: number;
}

