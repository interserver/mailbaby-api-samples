import { MailLogEntry } from './mail-log-entry';


/**
 * Paginated mail log response returned by `GET /mail/log`.  Contains the full matched count (`total`) plus a page of `MailLogEntry` records.  Use `skip` and `limit` to page through large result sets.
 */
export interface MailLog { 
  /**
   * Total number of log entries that match the supplied filters, regardless of `skip` and `limit`.  Use this to calculate the number of pages: `ceil(total / limit)`.
   */
  total: number;
  /**
   * The `skip` value used for this page (echoed from the request).
   */
  skip: number;
  /**
   * The `limit` value used for this page (echoed from the request).
   */
  limit: number;
  emails: Array<MailLogEntry>;
}

