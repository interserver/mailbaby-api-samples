
package org.openapitools.client.model


case class MailBlocks (
    /* Messages flagged by the `LOCAL_BL_RCPT` rspamd rule in the last 5 days. These are messages sent to recipients on a local block list. */
    _local: List[MailBlockClickHouse],
    /* Messages flagged by the `MBTRAP` rspamd rule in the last 5 days. These triggered MailBaby's honeypot / trap address detection. */
    _mbtrap: List[MailBlockClickHouse],
    /* Senders whose messages contained spam-indicative subjects (containing `@`, `smtp`, `socks4`, or `socks5`) with more than 4 occurrences of the same subject in the last 3 days. */
    _subject: List[MailBlockRspamd]
)
object MailBlocks {
    def toStringBody(var_local: Object, var_mbtrap: Object, var_subject: Object) =
        s"""
        | {
        | "local":$var_local,"mbtrap":$var_mbtrap,"subject":$var_subject
        | }
        """.stripMargin
}
