

/**
 * An email contact with an optional display name.  Used in structured address fields (`from`, `to`, `cc`, `bcc`, `replyto`) in `SendMailAdv`.
 */
export interface EmailAddressName { 
  /**
   * The email address.
   */
  email: string;
  /**
   * Optional display name shown to recipients (e.g. in the `From:` header).
   */
  name?: string;
}

