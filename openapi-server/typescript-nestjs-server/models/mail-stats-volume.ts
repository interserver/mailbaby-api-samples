

/**
 * Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.
 */
export interface MailStatsVolume { 
  /**
   * Message counts keyed by destination (envelope `to`) email address.
   */
  to?: { [key: string]: number; };
  /**
   * Message counts keyed by sender (envelope `from`) email address.
   */
  'from'?: { [key: string]: number; };
  /**
   * Message counts keyed by originating client IP address.
   */
  ip?: { [key: string]: number; };
}

