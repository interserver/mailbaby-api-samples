
package org.openapitools.client.model


case class MailStatsType (
    /* The time window these `received`, `sent`, and `volume` statistics cover. */
    _time: Option[String],
    /* Total messages accepted during the current billing cycle.  Used to calculate the `cost` value. */
    _usage: Option[Integer],
    /* The ISO 4217 currency code for this account (e.g. `USD`). */
    _currency: Option[String],
    /* Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails). */
    _cost: Option[Double],
    /* Count of messages accepted by the relay within the selected `time` window. Includes messages still in queue. */
    _received: Option[Integer],
    /* Count of messages successfully delivered to the destination MX within the selected `time` window.  Will be ≤ `received`. */
    _sent: Option[Integer],
    _volume: Option[MailStatsVolume]
)
object MailStatsType {
    def toStringBody(var_time: Object, var_usage: Object, var_currency: Object, var_cost: Object, var_received: Object, var_sent: Object, var_volume: Object) =
        s"""
        | {
        | "time":$var_time,"usage":$var_usage,"currency":$var_currency,"cost":$var_cost,"received":$var_received,"sent":$var_sent,"volume":$var_volume
        | }
        """.stripMargin
}
