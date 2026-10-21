package org.openapitools.server.model


/**
 * = MailStatsType =
 *
 * Account usage statistics returned by `GET /mail/stats`.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.
 *
 * @param time The time window these `received`, `sent`, and `volume` statistics cover. for example: ''null''
 * @param usage Total messages accepted during the current billing cycle.  Used to calculate the `cost` value. for example: ''null''
 * @param currency The ISO 4217 currency code for this account (e.g. `USD`). for example: ''null''
 * @param cost Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails). for example: ''null''
 * @param received Count of messages accepted by the relay within the selected `time` window. Includes messages still in queue. for example: ''null''
 * @param sent Count of messages successfully delivered to the destination MX within the selected `time` window.  Will be ≤ `received`. for example: ''null''
 * @param volume  for example: ''null''
*/
final case class MailStatsType (
  time: Option[String] = None,
  usage: Option[Int] = None,
  currency: Option[String] = None,
  cost: Option[Double] = None,
  received: Option[Int] = None,
  sent: Option[Int] = None,
  volume: Option[MailStatsVolume] = None
)

