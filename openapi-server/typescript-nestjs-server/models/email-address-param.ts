

/**
 * A single email address parameter used as the body of `POST /mail/blocks/delete`.
 */
export interface EmailAddressParam { 
  /**
   * The email address to delist from all block lists.
   */
  email: string;
}

