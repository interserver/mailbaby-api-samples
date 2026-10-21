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
import MailBabyKotlinMisk.models.EmailAddressTypes
import MailBabyKotlinMisk.models.EmailAddressesTypes
import MailBabyKotlinMisk.models.ErrorMessage
import MailBabyKotlinMisk.models.GenericResponse
import MailBabyKotlinMisk.models.MailAttachment
import MailBabyKotlinMisk.models.SendMailRaw
import MailBabyKotlinMisk.models.SendMailTo

@MiskTest(startService = true)
internal class SendingApiTest {

    @Suppress("unused")
    @MiskTestModule
    private val module = MiskTestModule()

    @Inject private lateinit var sendingApi: SendingApiAction

    /**
     * To test SendingApiAction.rawMail
     */
    @Test
    fun `should handle rawMail`() {
        val sendMailRaw = TODO()
        val response: GenericResponse = sendingApi.rawMail(sendMailRaw)
    }

    /**
     * To test SendingApiAction.sendAdvMail
     */
    @Test
    fun `should handle sendAdvMail`() {
        val subject = TODO()
        val body = TODO()
        val from = TODO()
        val to = TODO()
        val replyto = TODO()
        val cc = TODO()
        val bcc = TODO()
        val attachments = TODO()
        val id = TODO()
        val response: GenericResponse = sendingApi.sendAdvMail(subject, body, from, to, replyto, cc, bcc, attachments, id)
    }

    /**
     * To test SendingApiAction.sendMail
     */
    @Test
    fun `should handle sendMail`() {
        val to = TODO()
        val from = TODO()
        val subject = TODO()
        val body = TODO()
        val id = TODO()
        val response: GenericResponse = sendingApi.sendMail(to, from, subject, body, id)
    }
}
