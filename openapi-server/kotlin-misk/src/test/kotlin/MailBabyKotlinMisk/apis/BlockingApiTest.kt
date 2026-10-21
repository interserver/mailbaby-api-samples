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
import MailBabyKotlinMisk.models.DenyRuleRecord
import MailBabyKotlinMisk.models.EmailAddressParam
import MailBabyKotlinMisk.models.ErrorMessage
import MailBabyKotlinMisk.models.GenericResponse
import MailBabyKotlinMisk.models.MailBlocks

@MiskTest(startService = true)
internal class BlockingApiTest {

    @Suppress("unused")
    @MiskTestModule
    private val module = MiskTestModule()

    @Inject private lateinit var blockingApi: BlockingApiAction

    /**
     * To test BlockingApiAction.addRule
     */
    @Test
    fun `should handle addRule`() {
        val type = TODO()
        val `data` = TODO()
        val user = TODO()
        val response: GenericResponse = blockingApi.addRule(type, `data`, user)
    }

    /**
     * To test BlockingApiAction.deleteRule
     */
    @Test
    fun `should handle deleteRule`() {
        val ruleId = TODO()
        val response: GenericResponse = blockingApi.deleteRule(ruleId)
    }

    /**
     * To test BlockingApiAction.delistBlock
     */
    @Test
    fun `should handle delistBlock`() {
        val emailAddressParam = TODO()
        val response: GenericResponse = blockingApi.delistBlock(emailAddressParam)
    }

    /**
     * To test BlockingApiAction.getMailBlocks
     */
    @Test
    fun `should handle getMailBlocks`() {
        val response: MailBlocks = blockingApi.getMailBlocks()
    }

    /**
     * To test BlockingApiAction.getRules
     */
    @Test
    fun `should handle getRules`() {
        val response: kotlin.collections.List<DenyRuleRecord> = blockingApi.getRules()
    }
}
