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
import MailBabyKotlinMisk.models.MailOrder
import MailBabyKotlinMisk.models.MailOrderDetail

@MiskTest(startService = true)
internal class ServicesApiTest {

    @Suppress("unused")
    @MiskTestModule
    private val module = MiskTestModule()

    @Inject private lateinit var servicesApi: ServicesApiAction

    /**
     * To test ServicesApiAction.getMailOrderById
     */
    @Test
    fun `should handle getMailOrderById`() {
        val id = TODO()
        val response: MailOrderDetail = servicesApi.getMailOrderById(id)
    }

    /**
     * To test ServicesApiAction.getMailOrders
     */
    @Test
    fun `should handle getMailOrders`() {
        val response: kotlin.collections.List<MailOrder> = servicesApi.getMailOrders()
    }
}
