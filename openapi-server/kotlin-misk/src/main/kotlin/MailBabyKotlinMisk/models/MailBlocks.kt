package MailBabyKotlinMisk.models

import MailBabyKotlinMisk.models.MailBlockClickHouse
import MailBabyKotlinMisk.models.MailBlockRspamd
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MailBlocks(
    /** Messages flagged by the &#x60;LOCAL_BL_RCPT&#x60; rspamd rule in the last 5 days. These are messages sent to recipients on a local block list. */
    val local: kotlin.collections.List<MailBlockClickHouse>,
    /** Messages flagged by the &#x60;MBTRAP&#x60; rspamd rule in the last 5 days. These triggered MailBaby&#39;s honeypot / trap address detection. */
    val mbtrap: kotlin.collections.List<MailBlockClickHouse>,
    /** Senders whose messages contained spam-indicative subjects (containing &#x60;@&#x60;, &#x60;smtp&#x60;, &#x60;socks4&#x60;, or &#x60;socks5&#x60;) with more than 4 occurrences of the same subject in the last 3 days. */
    val subject: kotlin.collections.List<MailBlockRspamd>
)
