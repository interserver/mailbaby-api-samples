package io.swagger.server.model


/**
 * = MailStatsType =
 *
 * Account usage statistics returned by `GET /mail/stats`.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.
 *
 * @param time The time window these `received`, `sent`, and `volume` statistics cover.
 * @param usage Total messages accepted during the current billing cycle.  Used to calculate the `cost` value.
 * @param currency The ISO 4217 currency code for this account (e.g. `USD`).
 * @param cost Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails).
 * @param received Count of messages accepted by the relay within the selected `time` window. Includes messages still in queue.
 * @param sent Count of messages successfully delivered to the destination MX within the selected `time` window.  Will be ≤ `received`.
 * @param volume 
 */
case class MailStatsType (
  time: Option[String],
  usage: Option[Int],
  currency: Option[String],
  cost: Option[Double],
  received: Option[Int],
  sent: Option[Int],
  volume: Option[MailStatsType_volume]
)

