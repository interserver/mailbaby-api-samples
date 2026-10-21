package MailBabyKotlinMisk.apis

import misk.testing.MiskTestModule
import jakarta.inject.Inject
import misk.testing.MiskTest
import org.junit.jupiter.api.Test
import misk.web.HttpCall
import misk.web.PathParam
import misk.web.QueryParam
import misk.web.RequestBody
import misk.web.RequestHeader
import MailBabyKotlinMisk.models.ErrorMessage
import MailBabyKotlinMisk.models.MailLog
import MailBabyKotlinMisk.models.MailStatsType

@MiskTest(startService = true)
internal class HistoryApiTest {

    @Suppress("unused")
    @MiskTestModule
    private val module = MiskTestModule()

    @Inject private lateinit var historyApi: HistoryApiAction

    /**
     * To test HistoryApiAction.getStats
     */
    @Test
    fun `should handle getStats`() {
        val time = TODO()
        val response: MailStatsType = historyApi.getStats(time)
    }

    /**
     * To test HistoryApiAction.viewMailLog
     */
    @Test
    fun `should handle viewMailLog`() {
        val id = TODO()
        val origin = TODO()
        val mx = TODO()
        val from = TODO()
        val to = TODO()
        val subject = TODO()
        val mailid = TODO()
        val messageId = TODO()
        val replyto = TODO()
        val headerfrom = TODO()
        val delivered = TODO()
        val skip = TODO()
        val limit = TODO()
        val startDate = TODO()
        val endDate = TODO()
        val sort = TODO()
        val dir = TODO()
        val groupby = TODO()
        val response: MailLog = historyApi.viewMailLog(id, origin, mx, from, to, subject, mailid, messageId, replyto, headerfrom, delivered, skip, limit, startDate, endDate, sort, dir, groupby)
    }
}
