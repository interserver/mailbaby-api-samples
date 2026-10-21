package MailBabyKotlinMisk.apis

import jakarta.inject.Inject
import jakarta.inject.Singleton
import jakarta.validation.Valid
import jakarta.validation.constraints.DecimalMax
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import misk.web.actions.WebAction
import misk.web.interceptors.LogRequestResponse
import misk.web.Delete
import misk.web.Description
import misk.web.Get
import misk.web.HttpCall
import misk.web.Patch
import misk.web.PathParam
import misk.web.Post
import misk.web.Put
import misk.web.QueryParam
import misk.web.RequestBody
import misk.web.RequestContentType
import misk.web.RequestHeader
import misk.web.Response
import misk.web.ResponseContentType
import misk.web.mediatype.MediaTypes
import MailBabyKotlinMisk.models.EmailAddressTypes
import MailBabyKotlinMisk.models.EmailAddressesTypes
import MailBabyKotlinMisk.models.ErrorMessage
import MailBabyKotlinMisk.models.GenericResponse
import MailBabyKotlinMisk.models.MailAttachment
import MailBabyKotlinMisk.models.SendMailRaw
import MailBabyKotlinMisk.models.SendMailTo

/**
* @TODO("Fill out implementation")
*/
@Singleton
class SendingApiAction @Inject constructor(
) : WebAction {

    @Post("/mail/rawsend")
    @Description("Send a pre-built RFC 822 message verbatim (preserves DKIM)")
    @RequestContentType(MediaTypes.APPLICATION_JSON, MediaTypes.FORM_DATA)
    @ResponseContentType(MediaTypes.APPLICATION_JSON)
    @LogRequestResponse(bodySampling = 1.0, errorBodySampling = 1.0)
    fun rawMail(
        @Valid @RequestBody sendMailRaw: SendMailRaw
    ): GenericResponse {
        TODO()
    }

    @Post("/mail/advsend")
    @Description("Send email with multiple recipients, CC/BCC, attachments, named contacts")
    @RequestContentType(MediaTypes.APPLICATION_FORM_URLENCODED, MediaTypes.APPLICATION_JSON)
    @ResponseContentType(MediaTypes.APPLICATION_JSON)
    @LogRequestResponse(bodySampling = 1.0, errorBodySampling = 1.0)
    fun sendAdvMail(
        @QueryParam(value = "subject") subject: kotlin.String , 
        @QueryParam(value = "body") body: kotlin.String , 
        @RequestPart(value = "from") from: EmailAddressTypes , 
        @RequestPart(value = "to") to: EmailAddressesTypes , 
        @RequestPart(value = "replyto") replyto: EmailAddressesTypes? , 
        @RequestPart(value = "cc") cc: EmailAddressesTypes? , 
        @RequestPart(value = "bcc") bcc: EmailAddressesTypes? , 
        @QueryParam(value = "attachments") attachments: kotlin.collections.List<MailAttachment>? , 
        @QueryParam(value = "id") id: kotlin.Long? 
    ): GenericResponse {
        TODO()
    }

    @Post("/mail/send")
    @Description("Send a simple email (single recipient, plain or HTML)")
    @RequestContentType(MediaTypes.APPLICATION_FORM_URLENCODED, MediaTypes.APPLICATION_JSON)
    @ResponseContentType(MediaTypes.APPLICATION_JSON)
    @LogRequestResponse(bodySampling = 1.0, errorBodySampling = 1.0)
    fun sendMail(
        @RequestPart(value = "to") to: SendMailTo , 
        @QueryParam(value = "from") from: kotlin.String , 
        @QueryParam(value = "subject") subject: kotlin.String , 
        @QueryParam(value = "body") body: kotlin.String , 
        @QueryParam(value = "id") id: kotlin.Long? 
    ): GenericResponse {
        TODO()
    }
}
