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
import MailBabyKotlinMisk.models.DenyRuleRecord
import MailBabyKotlinMisk.models.EmailAddressParam
import MailBabyKotlinMisk.models.ErrorMessage
import MailBabyKotlinMisk.models.GenericResponse
import MailBabyKotlinMisk.models.MailBlocks

/**
* @TODO("Fill out implementation")
*/
@Singleton
class BlockingApiAction @Inject constructor(
) : WebAction {

    @Post("/mail/rules")
    @Description("Create a deny rule to block a sender, domain, destination, or prefix")
    @RequestContentType(MediaTypes.APPLICATION_FORM_URLENCODED, MediaTypes.APPLICATION_JSON)
    @ResponseContentType(MediaTypes.APPLICATION_JSON)
    @LogRequestResponse(bodySampling = 1.0, errorBodySampling = 1.0)
    fun addRule(
        @QueryParam(value = "type") type: kotlin.String , 
        @QueryParam(value = "data") `data`: kotlin.String , 
        @QueryParam(value = "user") user: kotlin.String? 
    ): GenericResponse {
        TODO()
    }

    @Delete("/mail/rules/{ruleId}")
    @Description("Delete a deny rule by its numeric ruleId")
    @ResponseContentType(MediaTypes.APPLICATION_JSON)
    @LogRequestResponse(bodySampling = 1.0, errorBodySampling = 1.0)
    fun deleteRule(
        @PathParam("ruleId") ruleId: kotlin.Int
    ): GenericResponse {
        TODO()
    }

    @Post("/mail/blocks/delete")
    @Description("Delist an email address from the spam-filter block lists")
    @RequestContentType(MediaTypes.APPLICATION_JSON, MediaTypes.APPLICATION_FORM_URLENCODED)
    @ResponseContentType(MediaTypes.APPLICATION_JSON)
    @LogRequestResponse(bodySampling = 1.0, errorBodySampling = 1.0)
    fun delistBlock(
        @Valid @RequestBody emailAddressParam: EmailAddressParam
    ): GenericResponse {
        TODO()
    }

    @Get("/mail/blocks")
    @Description("List addresses currently flagged by spam-filter block lists")
    @ResponseContentType(MediaTypes.APPLICATION_JSON)
    @LogRequestResponse(bodySampling = 1.0, errorBodySampling = 1.0)
    fun getMailBlocks(
    ): MailBlocks {
        TODO()
    }

    @Get("/mail/rules")
    @Description("List custom deny rules (sender / domain / destination / prefix)")
    @ResponseContentType(MediaTypes.APPLICATION_JSON)
    @LogRequestResponse(bodySampling = 1.0, errorBodySampling = 1.0)
    fun getRules(
    ): kotlin.collections.List<DenyRuleRecord> {
        TODO()
    }
}
