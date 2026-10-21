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
import MailBabyKotlinVertx.models.DenyRuleRecord
import MailBabyKotlinVertx.models.EmailAddressParam
import MailBabyKotlinVertx.models.ErrorMessage
import MailBabyKotlinVertx.models.GenericResponse
import MailBabyKotlinVertx.models.MailBlocks

class BlockingApiVertxProxyHandler(private val vertx: Vertx, private val service: BlockingApi, topLevel: Boolean, private val timeoutSeconds: Long) : ProxyHandler() {
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
        
                "addRule" -> {
                    val params = context.params
                    val type = ApiHandlerUtils.searchStringInJson(params,"type")
                    if(type == null){
                        throw IllegalArgumentException("type is required")
                    }
                    val &#x60;data&#x60; = ApiHandlerUtils.searchStringInJson(params,"data")
                    if(&#x60;data&#x60; == null){
                        throw IllegalArgumentException("&#x60;data&#x60; is required")
                    }
                    val user = ApiHandlerUtils.searchStringInJson(params,"user")
                    GlobalScope.launch(vertx.dispatcher()){
                        val result = service.addRule(type,&#x60;data&#x60;,user,context)
                        val payload = JsonObject(Json.encode(result.payload)).toBuffer()
                        val res = OperationResponse(result.statusCode,result.statusMessage,payload,result.headers)
                        msg.reply(res.toJson())
                    }.invokeOnCompletion{
                        it?.let{ throw it }
                    }
                }
        
                "deleteRule" -> {
                    val params = context.params
                    val ruleId = ApiHandlerUtils.searchIntegerInJson(params,"ruleId")
                    if(ruleId == null){
                        throw IllegalArgumentException("ruleId is required")
                    }
                    GlobalScope.launch(vertx.dispatcher()){
                        val result = service.deleteRule(ruleId,context)
                        val payload = JsonObject(Json.encode(result.payload)).toBuffer()
                        val res = OperationResponse(result.statusCode,result.statusMessage,payload,result.headers)
                        msg.reply(res.toJson())
                    }.invokeOnCompletion{
                        it?.let{ throw it }
                    }
                }
        
                "delistBlock" -> {
                    val params = context.params
                    val emailAddressParamParam = ApiHandlerUtils.searchJsonObjectInJson(params,"body")
                    if (emailAddressParamParam == null) {
                        throw IllegalArgumentException("emailAddressParam is required")
                    }
                    val emailAddressParam = Gson().fromJson(emailAddressParamParam.encode(), EmailAddressParam::class.java)
                    GlobalScope.launch(vertx.dispatcher()){
                        val result = service.delistBlock(emailAddressParam,context)
                        val payload = JsonObject(Json.encode(result.payload)).toBuffer()
                        val res = OperationResponse(result.statusCode,result.statusMessage,payload,result.headers)
                        msg.reply(res.toJson())
                    }.invokeOnCompletion{
                        it?.let{ throw it }
                    }
                }
        
                "getMailBlocks" -> {
                }
        
                "getRules" -> {
                }
        
            }
        }catch (t: Throwable) {
            msg.reply(ServiceException(500, t.message))
            throw t
        }
    }
}
