
package org.openapitools.client.model


case class MailStatsTypeVolume (
    /* Message counts keyed by destination (envelope `to`) email address. */
    _to: Option[Map[String, Integer]],
    /* Message counts keyed by sender (envelope `from`) email address. */
    _from: Option[Map[String, Integer]],
    /* Message counts keyed by originating client IP address. */
    _ip: Option[Map[String, Integer]]
)
object MailStatsTypeVolume {
    def toStringBody(var_to: Object, var_from: Object, var_ip: Object) =
        s"""
        | {
        | "to":$var_to,"from":$var_from,"ip":$var_ip
        | }
        """.stripMargin
}
