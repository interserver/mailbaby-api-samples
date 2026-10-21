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

@MiskTest(startService = true)
internal class StatusApiTest {

    @Suppress("unused")
    @MiskTestModule
    private val module = MiskTestModule()

    @Inject private lateinit var statusApi: StatusApiAction

    /**
     * To test StatusApiAction.pingServer
     */
    @Test
    fun `should handle pingServer`() {
        val response: kotlin.String = statusApi.pingServer()
    }
}
