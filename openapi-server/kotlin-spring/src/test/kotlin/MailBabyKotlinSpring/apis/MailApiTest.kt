package MailBabyKotlinSpring.apis

import MailBabyKotlinSpring.models.DateOrTimestamp
import MailBabyKotlinSpring.models.DenyRuleRecord
import MailBabyKotlinSpring.models.EmailAddressParam
import MailBabyKotlinSpring.models.EmailAddressTypes
import MailBabyKotlinSpring.models.EmailAddressesTypes
import MailBabyKotlinSpring.models.ErrorMessage
import MailBabyKotlinSpring.models.GenericResponse
import MailBabyKotlinSpring.models.MailAttachment
import MailBabyKotlinSpring.models.MailBlocks
import MailBabyKotlinSpring.models.MailLog
import MailBabyKotlinSpring.models.MailOrder
import MailBabyKotlinSpring.models.MailOrderDetail
import MailBabyKotlinSpring.models.MailStatsType
import MailBabyKotlinSpring.models.SendMailRaw
import MailBabyKotlinSpring.models.SendMailTo
import org.junit.jupiter.api.Test
import org.springframework.http.ResponseEntity

class MailApiTest {

    private val api: MailApiController = MailApiController()

    /**
     * To test MailApiController.addRule
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun addRuleTest() {
        val type: kotlin.String = TODO()
        val `data`: kotlin.String = TODO()
        val user: kotlin.String? = TODO()
        
        
        val response: ResponseEntity<GenericResponse> = api.addRule(type, `data`, user)

        // TODO: test validations
    }

    /**
     * To test MailApiController.deleteRule
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun deleteRuleTest() {
        val ruleId: kotlin.Int = TODO()
        
        
        val response: ResponseEntity<GenericResponse> = api.deleteRule(ruleId)

        // TODO: test validations
    }

    /**
     * To test MailApiController.delistBlock
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun delistBlockTest() {
        val emailAddressParam: EmailAddressParam = TODO()
        
        
        val response: ResponseEntity<GenericResponse> = api.delistBlock(emailAddressParam)

        // TODO: test validations
    }

    /**
     * To test MailApiController.getMailBlocks
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun getMailBlocksTest() {
        
        
        val response: ResponseEntity<MailBlocks> = api.getMailBlocks()

        // TODO: test validations
    }

    /**
     * To test MailApiController.getMailOrderById
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun getMailOrderByIdTest() {
        val id: kotlin.Long = TODO()
        
        
        val response: ResponseEntity<MailOrderDetail> = api.getMailOrderById(id)

        // TODO: test validations
    }

    /**
     * To test MailApiController.getMailOrders
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun getMailOrdersTest() {
        
        
        val response: ResponseEntity<List<MailOrder>> = api.getMailOrders()

        // TODO: test validations
    }

    /**
     * To test MailApiController.getRules
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun getRulesTest() {
        
        
        val response: ResponseEntity<List<DenyRuleRecord>> = api.getRules()

        // TODO: test validations
    }

    /**
     * To test MailApiController.getStats
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun getStatsTest() {
        val time: kotlin.String = TODO()
        
        
        val response: ResponseEntity<MailStatsType> = api.getStats(time)

        // TODO: test validations
    }

    /**
     * To test MailApiController.rawMail
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun rawMailTest() {
        val sendMailRaw: SendMailRaw = TODO()
        
        
        val response: ResponseEntity<GenericResponse> = api.rawMail(sendMailRaw)

        // TODO: test validations
    }

    /**
     * To test MailApiController.sendAdvMail
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun sendAdvMailTest() {
        val subject: kotlin.String = TODO()
        val body: kotlin.String = TODO()
        val from: EmailAddressTypes = TODO()
        val to: EmailAddressesTypes = TODO()
        val replyto: EmailAddressesTypes? = TODO()
        val cc: EmailAddressesTypes? = TODO()
        val bcc: EmailAddressesTypes? = TODO()
        val attachments: kotlin.collections.List<MailAttachment>? = TODO()
        val id: kotlin.Long? = TODO()
        
        
        val response: ResponseEntity<GenericResponse> = api.sendAdvMail(subject, body, from, to, replyto, cc, bcc, attachments, id)

        // TODO: test validations
    }

    /**
     * To test MailApiController.sendMail
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun sendMailTest() {
        val to: SendMailTo = TODO()
        val from: kotlin.String = TODO()
        val subject: kotlin.String = TODO()
        val body: kotlin.String = TODO()
        val id: kotlin.Long? = TODO()
        
        
        val response: ResponseEntity<GenericResponse> = api.sendMail(to, from, subject, body, id)

        // TODO: test validations
    }

    /**
     * To test MailApiController.viewMailLog
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun viewMailLogTest() {
        val id: kotlin.Long? = TODO()
        val origin: kotlin.String? = TODO()
        val mx: kotlin.String? = TODO()
        val from: kotlin.String? = TODO()
        val to: kotlin.String? = TODO()
        val subject: kotlin.String? = TODO()
        val mailid: kotlin.String? = TODO()
        val messageId: kotlin.String? = TODO()
        val replyto: kotlin.String? = TODO()
        val headerfrom: kotlin.String? = TODO()
        val delivered: kotlin.Int? = TODO()
        val skip: kotlin.Int = TODO()
        val limit: kotlin.Int = TODO()
        val startDate: DateOrTimestamp? = TODO()
        val endDate: DateOrTimestamp? = TODO()
        val sort: kotlin.String = TODO()
        val dir: kotlin.String = TODO()
        val groupby: kotlin.String = TODO()
        
        
        val response: ResponseEntity<MailLog> = api.viewMailLog(id, origin, mx, from, to, subject, mailid, messageId, replyto, headerfrom, delivered, skip, limit, startDate, endDate, sort, dir, groupby)

        // TODO: test validations
    }
}
