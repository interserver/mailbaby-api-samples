package io.swagger.server.model


/**
 * = MailStatsVolume =
 *
 * Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.
 *
 * @param to Message counts keyed by destination (envelope `to`) email address.
 * @param from Message counts keyed by sender (envelope `from`) email address.
 * @param ip Message counts keyed by originating client IP address.
 */
case class MailStatsVolume (
  to: Option[Map[String, Int]],
  from: Option[Map[String, Int]],
  ip: Option[Map[String, Int]]
)

