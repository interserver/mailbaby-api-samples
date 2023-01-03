package io.swagger.server.model


/**
 * Mail log records
 *
 * @param total total number of mail log entries for example: ''10234''
 * @param skip number of emails skipped in listing for example: ''0''
 * @param limit number of emails to return for example: ''100''
 * @param emails 
 */
case class MailLog (
  total: Int,
  skip: Int,
  limit: Int,
  emails: List[MailLogEntry]
)

