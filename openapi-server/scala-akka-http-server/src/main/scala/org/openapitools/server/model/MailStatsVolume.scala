package org.openapitools.server.model


/**
 * = MailStatsVolume =
 *
 * Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.
 *
 * @param to Message counts keyed by destination (envelope `to`) email address. for example: ''null''
 * @param from Message counts keyed by sender (envelope `from`) email address. for example: ''null''
 * @param ip Message counts keyed by originating client IP address. for example: ''null''
*/
final case class MailStatsVolume (
  to: Option[Map[String, Int]] = None,
  from: Option[Map[String, Int]] = None,
  ip: Option[Map[String, Int]] = None
)

