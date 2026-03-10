package io.swagger.server.model


/**
 * = MailLog =
 *
 * Paginated mail log response returned by `GET /mail/log`.  Contains the full matched count (`total`) plus a page of `MailLogEntry` records.  Use `skip` and `limit` to page through large result sets.
 *
 * @param total Total number of log entries that match the supplied filters, regardless of `skip` and `limit`.  Use this to calculate the number of pages: `ceil(total / limit)`. for example: ''10234''
 * @param skip The `skip` value used for this page (echoed from the request). for example: ''0''
 * @param limit The `limit` value used for this page (echoed from the request). for example: ''100''
 * @param emails 
 */
case class MailLog (
  total: Int,
  skip: Int,
  limit: Int,
  emails: List[MailLogEntry]
)

