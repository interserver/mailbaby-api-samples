@file:Suppress(
    "RemoveRedundantQualifierName",
    "UnusedImport",
    "unused",
)

package MailBabyKotlinWiremock.apis

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.tomakehurst.wiremock.client.MappingBuilder
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder
import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.matching.StringValuePattern
import MailBabyKotlinWiremock.models.*

/**
 * WireMock stub request builder.
 */
open class HistoryApiStubs(private val objectMapper: ObjectMapper) {

    /**
     * Construct a stub for the operation getStats.
     *
     * @param time query parameter time pattern.
     * @param configurer configurer for the [MappingBuilder], allowing for arbitrary changes.
     * @return A [GetStatsStubBuilder] to configure the response, and the final [MappingBuilder].
     */
    fun getStats(time: StringValuePattern? = null, configurer: MappingBuilder.() -> MappingBuilder = { this }): GetStatsStubBuilder =
        GetStatsStubBuilder(objectMapper, get(urlPathTemplate("/mail/stats"))
            .apply { time?.let { withQueryParam("time", it) } }
            .configurer()
        )

    /**
     * Construct a stub for the operation viewMailLog.
     *
     * @param id query parameter id pattern.
     * @param origin query parameter origin pattern.
     * @param mx query parameter mx pattern.
     * @param from query parameter from pattern.
     * @param to query parameter to pattern.
     * @param subject query parameter subject pattern.
     * @param mailid query parameter mailid pattern.
     * @param messageId query parameter messageId pattern.
     * @param replyto query parameter replyto pattern.
     * @param headerfrom query parameter headerfrom pattern.
     * @param delivered query parameter delivered pattern.
     * @param skip query parameter skip pattern.
     * @param limit query parameter limit pattern.
     * @param startDate query parameter startDate pattern.
     * @param endDate query parameter endDate pattern.
     * @param sort query parameter sort pattern.
     * @param dir query parameter dir pattern.
     * @param groupby query parameter groupby pattern.
     * @param configurer configurer for the [MappingBuilder], allowing for arbitrary changes.
     * @return A [ViewMailLogStubBuilder] to configure the response, and the final [MappingBuilder].
     */
    fun viewMailLog(id: StringValuePattern? = null, origin: StringValuePattern? = null, mx: StringValuePattern? = null, from: StringValuePattern? = null, to: StringValuePattern? = null, subject: StringValuePattern? = null, mailid: StringValuePattern? = null, messageId: StringValuePattern? = null, replyto: StringValuePattern? = null, headerfrom: StringValuePattern? = null, delivered: StringValuePattern? = null, skip: StringValuePattern? = null, limit: StringValuePattern? = null, startDate: StringValuePattern? = null, endDate: StringValuePattern? = null, sort: StringValuePattern? = null, dir: StringValuePattern? = null, groupby: StringValuePattern? = null, configurer: MappingBuilder.() -> MappingBuilder = { this }): ViewMailLogStubBuilder =
        ViewMailLogStubBuilder(objectMapper, get(urlPathTemplate("/mail/log"))
            .apply { id?.let { withQueryParam("id", it) } }
            .apply { origin?.let { withQueryParam("origin", it) } }
            .apply { mx?.let { withQueryParam("mx", it) } }
            .apply { from?.let { withQueryParam("from", it) } }
            .apply { to?.let { withQueryParam("to", it) } }
            .apply { subject?.let { withQueryParam("subject", it) } }
            .apply { mailid?.let { withQueryParam("mailid", it) } }
            .apply { messageId?.let { withQueryParam("messageId", it) } }
            .apply { replyto?.let { withQueryParam("replyto", it) } }
            .apply { headerfrom?.let { withQueryParam("headerfrom", it) } }
            .apply { delivered?.let { withQueryParam("delivered", it) } }
            .apply { skip?.let { withQueryParam("skip", it) } }
            .apply { limit?.let { withQueryParam("limit", it) } }
            .apply { startDate?.let { withQueryParam("startDate", it) } }
            .apply { endDate?.let { withQueryParam("endDate", it) } }
            .apply { sort?.let { withQueryParam("sort", it) } }
            .apply { dir?.let { withQueryParam("dir", it) } }
            .apply { groupby?.let { withQueryParam("groupby", it) } }
            .configurer()
        )
}
