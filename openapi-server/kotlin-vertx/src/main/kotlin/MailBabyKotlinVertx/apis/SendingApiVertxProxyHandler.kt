package MailBabyKotlinVertx.apis

import io.vertx.core.Vertx
import io.vertx.core.eventbus.Message
import io.vertx.core.json.JsonObject
import io.vertx.ext.web.api.OperationRequest
import io.vertx.ext.web.api.OperationResponse
import io.vertx.ext.web.api.generator.ApiHandlerUtils
import io.vertx.serviceproxy.ProxyHandler
import io.vertx.serviceproxy.ServiceException
import io.vertx.serviceproxy.ServiceExceptionMessageCodec
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import io.vertx.kotlin.coroutines.dispatcher
import io.vertx.core.json.Json
import io.vertx.core.json.JsonArray
import com.google.gson.reflect.TypeToken
import com.google.gson.Gson
import MailBabyKotlinVertx.models.EmailAddressTypes
import MailBabyKotlinVertx.models.EmailAddressesTypes
import MailBabyKotlinVertx.models.ErrorMessage
import MailBabyKotlinVertx.models.GenericResponse
import MailBabyKotlinVertx.models.MailAttachment
import MailBabyKotlinVertx.models.SendMailRaw
import MailBabyKotlinVertx.models.SendMailTo

class SendingApiVertxProxyHandler(private val vertx: Vertx, private val service: SendingApi, topLevel: Boolean, private val timeoutSeconds: Long) : ProxyHandler() {
    private lateinit var timerID: Long
    private var lastAccessed: Long = 0
    init {
        try {
            this.vertx.eventBus().registerDefaultCodec(ServiceException::class.java,
            ServiceExceptionMessageCodec())
        } catch (ex: IllegalStateException) {}

        if (timeoutSeconds != (-1).toLong() && !topLevel) {
            var period = timeoutSeconds * 1000 / 2
            if (period > 10000) {
                period = 10000
            }
            this.timerID = vertx.setPeriodic(period) { this.checkTimedOut(it) }
        } else {
            this.timerID = -1
        }
        accessed()
    }
    private fun checkTimedOut(id: Long) {
        val now = System.nanoTime()
        if (now - lastAccessed > timeoutSeconds * 1000000000) {
            close()
        }
    }

    override fun close() {
        if (timerID != (-1).toLong()) {
            vertx.cancelTimer(timerID)
        }
        super.close()
    }

    private fun accessed() {
        this.lastAccessed = System.nanoTime()
    }
    override fun handle(msg: Message<JsonObject>) {
        try {
            val json = msg.body()
            val action = msg.headers().get("action") ?: throw IllegalStateException("action not specified")
            accessed()
            val contextSerialized = json.getJsonObject("context") ?: throw IllegalStateException("Received action $action without OperationRequest \"context\"")
            val context = OperationRequest(contextSerialized)
            when (action) {
        
                "rawMail" -> {
                    val params = context.params
                    val sendMailRawParam = ApiHandlerUtils.searchJsonObjectInJson(params,"body")
                    if (sendMailRawParam == null) {
                        throw IllegalArgumentException("sendMailRaw is required")
                    }
                    val sendMailRaw = Gson().fromJson(sendMailRawParam.encode(), SendMailRaw::class.java)
                    GlobalScope.launch(vertx.dispatcher()){
                        val result = service.rawMail(sendMailRaw,context)
                        val payload = JsonObject(Json.encode(result.payload)).toBuffer()
                        val res = OperationResponse(result.statusCode,result.statusMessage,payload,result.headers)
                        msg.reply(res.toJson())
                    }.invokeOnCompletion{
                        it?.let{ throw it }
                    }
                }
        
                "sendAdvMail" -> {
                    val params = context.params
                    val subject = ApiHandlerUtils.searchStringInJson(params,"subject")
                    if(subject == null){
                        throw IllegalArgumentException("subject is required")
                    }
                    val body = ApiHandlerUtils.searchStringInJson(params,"body")
                    if(body == null){
                        throw IllegalArgumentException("body is required")
                    }
                    val fromParam = ApiHandlerUtils.searchJsonObjectInJson(params,"from")
                    if (fromParam == null) {
                        throw IllegalArgumentException("from is required")
                    }
                    val from = Gson().fromJson(fromParam.encode(), EmailAddressTypes::class.java)
                    val toParam = ApiHandlerUtils.searchJsonObjectInJson(params,"to")
                    if (toParam == null) {
                        throw IllegalArgumentException("to is required")
                    }
                    val to = Gson().fromJson(toParam.encode(), EmailAddressesTypes::class.java)
                    val replytoParam = ApiHandlerUtils.searchJsonObjectInJson(params,"replyto")
                    val replyto = if(replytoParam ==null) null else Gson().fromJson(replytoParam.encode(), EmailAddressesTypes::class.java)
                    val ccParam = ApiHandlerUtils.searchJsonObjectInJson(params,"cc")
                    val cc = if(ccParam ==null) null else Gson().fromJson(ccParam.encode(), EmailAddressesTypes::class.java)
                    val bccParam = ApiHandlerUtils.searchJsonObjectInJson(params,"bcc")
                    val bcc = if(bccParam ==null) null else Gson().fromJson(bccParam.encode(), EmailAddressesTypes::class.java)
                    val attachmentsParam = ApiHandlerUtils.searchJsonArrayInJson(params,"attachments")
                    val attachments:kotlin.Array<MailAttachment>? = if(attachmentsParam == null) null
                            else Gson().fromJson(attachmentsParam.encode(),
                            , object : TypeToken<kotlin.collections.List<MailAttachment>>(){}.type)
                    val id = ApiHandlerUtils.searchLongInJson(params,"id")
                    GlobalScope.launch(vertx.dispatcher()){
                        val result = service.sendAdvMail(subject,body,from,to,replyto,cc,bcc,attachments,id,context)
                        val payload = JsonObject(Json.encode(result.payload)).toBuffer()
                        val res = OperationResponse(result.statusCode,result.statusMessage,payload,result.headers)
                        msg.reply(res.toJson())
                    }.invokeOnCompletion{
                        it?.let{ throw it }
                    }
                }
        
                "sendMail" -> {
                    val params = context.params
                    val toParam = ApiHandlerUtils.searchJsonObjectInJson(params,"to")
                    if (toParam == null) {
                        throw IllegalArgumentException("to is required")
                    }
                    val to = Gson().fromJson(toParam.encode(), SendMailTo::class.java)
                    val from = ApiHandlerUtils.searchStringInJson(params,"from")
                    val from = ApiHandlerUtils.searchStringInJson(params,"from")
                    if(from == null){
                        throw IllegalArgumentException("from is required")
                    }
                    val subject = ApiHandlerUtils.searchStringInJson(params,"subject")
                    if(subject == null){
                        throw IllegalArgumentException("subject is required")
                    }
                    val body = ApiHandlerUtils.searchStringInJson(params,"body")
                    if(body == null){
                        throw IllegalArgumentException("body is required")
                    }
                    val id = ApiHandlerUtils.searchLongInJson(params,"id")
                    GlobalScope.launch(vertx.dispatcher()){
                        val result = service.sendMail(to,from,subject,body,id,context)
                        val payload = JsonObject(Json.encode(result.payload)).toBuffer()
                        val res = OperationResponse(result.statusCode,result.statusMessage,payload,result.headers)
                        msg.reply(res.toJson())
                    }.invokeOnCompletion{
                        it?.let{ throw it }
                    }
                }
        
            }
        }catch (t: Throwable) {
            msg.reply(ServiceException(500, t.message))
            throw t
        }
    }
}
