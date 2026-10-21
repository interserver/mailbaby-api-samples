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
import MailBabyKotlinMisk.models.ErrorMessage
import MailBabyKotlinMisk.models.MailOrder
import MailBabyKotlinMisk.models.MailOrderDetail

/**
* @TODO("Fill out implementation")
*/
@Singleton
class ServicesApiAction @Inject constructor(
) : WebAction {

    @Get("/mail/{id}")
    @Description("Get one mail order's full detail including SMTP password")
    @ResponseContentType(MediaTypes.APPLICATION_JSON)
    @LogRequestResponse(bodySampling = 1.0, errorBodySampling = 1.0)
    fun getMailOrderById(
        @PathParam("id") id: kotlin.Long
    ): MailOrderDetail {
        TODO()
    }

    @Get("/mail")
    @Description("List your provisioned mail orders (sending accounts)")
    @ResponseContentType(MediaTypes.APPLICATION_JSON)
    @LogRequestResponse(bodySampling = 1.0, errorBodySampling = 1.0)
    fun getMailOrders(
    ): kotlin.collections.List<MailOrder> {
        TODO()
    }
}
