package MailBabyKotlinVertx.apis

import MailBabyKotlinVertx.models.DenyRuleRecord
import MailBabyKotlinVertx.models.EmailAddressParam
import MailBabyKotlinVertx.models.ErrorMessage
import MailBabyKotlinVertx.models.GenericResponse
import MailBabyKotlinVertx.models.MailBlocks
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


interface BlockingApi  {
    fun init(vertx:Vertx,config:JsonObject)
    /* addRule
     * Create a deny rule to block a sender, domain, destination, or prefix */
    suspend fun addRule(type:kotlin.String?,&#x60;data&#x60;:kotlin.String?,user:kotlin.String?,context:OperationRequest):Response<GenericResponse>
    /* deleteRule
     * Delete a deny rule by its numeric ruleId */
    suspend fun deleteRule(ruleId:kotlin.Int?,context:OperationRequest):Response<GenericResponse>
    /* delistBlock
     * Delist an email address from the spam-filter block lists */
    suspend fun delistBlock(emailAddressParam:EmailAddressParam?,context:OperationRequest):Response<GenericResponse>
    /* getMailBlocks
     * List addresses currently flagged by spam-filter block lists */
    suspend fun getMailBlocks(context:OperationRequest):Response<MailBlocks>
    /* getRules
     * List custom deny rules (sender / domain / destination / prefix) */
    suspend fun getRules(context:OperationRequest):Response<kotlin.Array<DenyRuleRecord>>
    companion object {
        const val address = "BlockingApi-service"
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
            for (m in BlockingApi::class.java.methods) {
                val methodName = m.name
                val op = operations[methodName]
                if (op != null) {
                    val method = op::class.java.getDeclaredMethod("mountRouteToService",String::class.java,String::class.java)
                    method.isAccessible = true
                    method.invoke(op,address,methodName)
                }
            }
            routerFactory.mountServiceInterface(BlockingApi::class.java, address)
            return routerFactory
        }
    }
}
