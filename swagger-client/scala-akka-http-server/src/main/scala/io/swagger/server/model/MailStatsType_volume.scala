package io.swagger.server.model


/**
 * Top-500 breakdown of message counts grouped by source IP, destination address, and sender address within the selected `time` window.
 *
 * @param to Message counts keyed by destination (envelope `to`) email address.
 * @param from Message counts keyed by sender (envelope `from`) email address.
 * @param ip Message counts keyed by originating client IP address.
 */
case class MailStatsType_volume (
  to: Option[Map[String, Int]],
  from: Option[Map[String, Int]],
  ip: Option[Map[String, Int]]
)

