package MailBabyKotlinVertx.apis

import MailBabyKotlinVertx.models.ErrorMessage
import MailBabyKotlinVertx.models.MailOrder
import MailBabyKotlinVertx.models.MailOrderDetail
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


interface ServicesApi  {
    fun init(vertx:Vertx,config:JsonObject)
    /* getMailOrderById
     * Get one mail order&#39;s full detail including SMTP password */
    suspend fun getMailOrderById(id:kotlin.Long?,context:OperationRequest):Response<MailOrderDetail>
    /* getMailOrders
     * List your provisioned mail orders (sending accounts) */
    suspend fun getMailOrders(context:OperationRequest):Response<kotlin.Array<MailOrder>>
    companion object {
        const val address = "ServicesApi-service"
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
            for (m in ServicesApi::class.java.methods) {
                val methodName = m.name
                val op = operations[methodName]
                if (op != null) {
                    val method = op::class.java.getDeclaredMethod("mountRouteToService",String::class.java,String::class.java)
                    method.isAccessible = true
                    method.invoke(op,address,methodName)
                }
            }
            routerFactory.mountServiceInterface(ServicesApi::class.java, address)
            return routerFactory
        }
    }
}
