package MailBabyKotlinVertx.apis

import MailBabyKotlinVertx.models.DateOrTimestamp
import MailBabyKotlinVertx.models.ErrorMessage
import MailBabyKotlinVertx.models.MailLog
import MailBabyKotlinVertx.models.MailStatsType
import io.vertx.core.Vertx
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import com.github.wooyme.openapi.Response
import io.vertx.ext.web.api.OperationRequest
import io.vertx.kotlin.ext.web.api.contract.openapi3.OpenAPI3RouterFactory
import io.vertx.serviceproxy.ServiceBinder
import io.vertx.ext.web.handler.CookieHandler
import io.vertx.ext.web.handler.SessionHandler
import io.vertx.ext.web.sstore.LocalSessionStore
import java.util.List
import java.util.Map


interface HistoryApi  {
    fun init(vertx:Vertx,config:JsonObject)
    /* getStats
     * Account usage, cost, and volume statistics for a time window */
    suspend fun getStats(time:kotlin.String?,context:OperationRequest):Response<MailStatsType>
    /* viewMailLog
     * Query the mail delivery log (filterable, paginated) */
    suspend fun viewMailLog(id:kotlin.Long?,origin:kotlin.String?,mx:kotlin.String?,from:kotlin.String?,to:kotlin.String?,subject:kotlin.String?,mailid:kotlin.String?,messageId:kotlin.String?,replyto:kotlin.String?,headerfrom:kotlin.String?,delivered:kotlin.Int?,skip:kotlin.Int?,limit:kotlin.Int?,startDate:DateOrTimestamp?,endDate:DateOrTimestamp?,sort:kotlin.String?,dir:kotlin.String?,groupby:kotlin.String?,context:OperationRequest):Response<MailLog>
    companion object {
        const val address = "HistoryApi-service"
        suspend fun createRouterFactory(vertx: Vertx,path:String): io.vertx.ext.web.api.contract.openapi3.OpenAPI3RouterFactory {
            val routerFactory = OpenAPI3RouterFactory.createAwait(vertx,path)
            routerFactory.addGlobalHandler(CookieHandler.create())
            routerFactory.addGlobalHandler(SessionHandler.create(LocalSessionStore.create(vertx)))
            routerFactory.setExtraOperationContextPayloadMapper{
                JsonObject().put("files",JsonArray(it.fileUploads().map { it.uploadedFileName() }))
            }
            val opf = routerFactory::class.java.getDeclaredField("operations")
            opf.isAccessible = true
            val operations = opf.get(routerFactory) as Map<String, Any>
            for (m in HistoryApi::class.java.methods) {
                val methodName = m.name
                val op = operations[methodName]
                if (op != null) {
                    val method = op::class.java.getDeclaredMethod("mountRouteToService",String::class.java,String::class.java)
                    method.isAccessible = true
                    method.invoke(op,address,methodName)
                }
            }
            routerFactory.mountServiceInterface(HistoryApi::class.java, address)
            return routerFactory
        }
    }
}
