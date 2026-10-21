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
import MailBabyKotlinVertx.models.ErrorMessage
import MailBabyKotlinVertx.models.MailLog
import MailBabyKotlinVertx.models.MailStatsType

class HistoryApiVertxProxyHandler(private val vertx: Vertx, private val service: HistoryApi, topLevel: Boolean, private val timeoutSeconds: Long) : ProxyHandler() {
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
        
                "getStats" -> {
                    val params = context.params
                    val time = ApiHandlerUtils.searchStringInJson(params,"time")
                    GlobalScope.launch(vertx.dispatcher()){
                        val result = service.getStats(time,context)
                        val payload = JsonObject(Json.encode(result.payload)).toBuffer()
                        val res = OperationResponse(result.statusCode,result.statusMessage,payload,result.headers)
                        msg.reply(res.toJson())
                    }.invokeOnCompletion{
                        it?.let{ throw it }
                    }
                }
        
                "viewMailLog" -> {
                    val params = context.params
                    val id = ApiHandlerUtils.searchLongInJson(params,"id")
                    val origin = ApiHandlerUtils.searchStringInJson(params,"origin")
                    val mx = ApiHandlerUtils.searchStringInJson(params,"mx")
                    val from = ApiHandlerUtils.searchStringInJson(params,"from")
                    val from = ApiHandlerUtils.searchStringInJson(params,"from")
                    val to = ApiHandlerUtils.searchStringInJson(params,"to")
                    val to = ApiHandlerUtils.searchStringInJson(params,"to")
                    val subject = ApiHandlerUtils.searchStringInJson(params,"subject")
                    val mailid = ApiHandlerUtils.searchStringInJson(params,"mailid")
                    val messageId = ApiHandlerUtils.searchStringInJson(params,"messageId")
                    val replyto = ApiHandlerUtils.searchStringInJson(params,"replyto")
                    val replyto = ApiHandlerUtils.searchStringInJson(params,"replyto")
                    val headerfrom = ApiHandlerUtils.searchStringInJson(params,"headerfrom")
                    val headerfrom = ApiHandlerUtils.searchStringInJson(params,"headerfrom")
                    val delivered = ApiHandlerUtils.searchIntegerInJson(params,"delivered")
                    val skip = ApiHandlerUtils.searchIntegerInJson(params,"skip")
                    val limit = ApiHandlerUtils.searchIntegerInJson(params,"limit")
                    val startDate = ApiHandlerUtils.searchStringInJson(params,"startDate")
                    val endDate = ApiHandlerUtils.searchStringInJson(params,"endDate")
                    val sort = ApiHandlerUtils.searchStringInJson(params,"sort")
                    val dir = ApiHandlerUtils.searchStringInJson(params,"dir")
                    val groupby = ApiHandlerUtils.searchStringInJson(params,"groupby")
                    GlobalScope.launch(vertx.dispatcher()){
                        val result = service.viewMailLog(id,origin,mx,from,to,subject,mailid,messageId,replyto,headerfrom,delivered,skip,limit,startDate,endDate,sort,dir,groupby,context)
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
