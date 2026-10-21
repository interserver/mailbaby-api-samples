package MailBabyKotlinVertx.apis

import MailBabyKotlinVertx.models.EmailAddressTypes
import MailBabyKotlinVertx.models.EmailAddressesTypes
import MailBabyKotlinVertx.models.ErrorMessage
import MailBabyKotlinVertx.models.GenericResponse
import MailBabyKotlinVertx.models.MailAttachment
import MailBabyKotlinVertx.models.SendMailRaw
import MailBabyKotlinVertx.models.SendMailTo
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


interface SendingApi  {
    fun init(vertx:Vertx,config:JsonObject)
    /* rawMail
     * Send a pre-built RFC 822 message verbatim (preserves DKIM) */
    suspend fun rawMail(sendMailRaw:SendMailRaw?,context:OperationRequest):Response<GenericResponse>
    /* sendAdvMail
     * Send email with multiple recipients, CC/BCC, attachments, named contacts */
    suspend fun sendAdvMail(subject:kotlin.String?,body:kotlin.String?,from:EmailAddressTypes?,to:EmailAddressesTypes?,replyto:EmailAddressesTypes?,cc:EmailAddressesTypes?,bcc:EmailAddressesTypes?,attachments:kotlin.Array<MailAttachment>?,id:kotlin.Long?,context:OperationRequest):Response<GenericResponse>
    /* sendMail
     * Send a simple email (single recipient, plain or HTML) */
    suspend fun sendMail(to:SendMailTo?,from:kotlin.String?,subject:kotlin.String?,body:kotlin.String?,id:kotlin.Long?,context:OperationRequest):Response<GenericResponse>
    companion object {
        const val address = "SendingApi-service"
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
            for (m in SendingApi::class.java.methods) {
                val methodName = m.name
                val op = operations[methodName]
                if (op != null) {
                    val method = op::class.java.getDeclaredMethod("mountRouteToService",String::class.java,String::class.java)
                    method.isAccessible = true
                    method.invoke(op,address,methodName)
                }
            }
            routerFactory.mountServiceInterface(SendingApi::class.java, address)
            return routerFactory
        }
    }
}
