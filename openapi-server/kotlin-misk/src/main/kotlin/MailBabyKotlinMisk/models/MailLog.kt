package MailBabyKotlinMisk.models

import MailBabyKotlinMisk.models.MailLogEntry
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MailLog(
    /** Total number of log entries that match the supplied filters, regardless of &#x60;skip&#x60; and &#x60;limit&#x60;.  Use this to calculate the number of pages: &#x60;ceil(total / limit)&#x60;. */
    val total: kotlin.Int,
    /** The &#x60;skip&#x60; value used for this page (echoed from the request). */
    val skip: kotlin.Int,
    /** The &#x60;limit&#x60; value used for this page (echoed from the request). */
    val limit: kotlin.Int,
    val emails: kotlin.collections.List<MailLogEntry>
)
