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
import MailBabyKotlinMisk.models.DateOrTimestamp
import MailBabyKotlinMisk.models.ErrorMessage
import MailBabyKotlinMisk.models.MailLog
import MailBabyKotlinMisk.models.MailStatsType

/**
* @TODO("Fill out implementation")
*/
@Singleton
class HistoryApiAction @Inject constructor(
) : WebAction {

    @Get("/mail/stats")
    @Description("Account usage, cost, and volume statistics for a time window")
    @ResponseContentType(MediaTypes.APPLICATION_JSON)
    @LogRequestResponse(bodySampling = 1.0, errorBodySampling = 1.0)
    fun getStats(
         @QueryParam(value = "time") time: kotlin.String
    ): MailStatsType {
        TODO()
    }

    @Get("/mail/log")
    @Description("Query the mail delivery log (filterable, paginated)")
    @ResponseContentType(MediaTypes.APPLICATION_JSON)
    @LogRequestResponse(bodySampling = 1.0, errorBodySampling = 1.0)
    fun viewMailLog(
         @QueryParam(value = "id") id: kotlin.Long?, 
         @QueryParam(value = "origin") origin: kotlin.String?, 
         @QueryParam(value = "mx") mx: kotlin.String?, 
         @QueryParam(value = "from") from: kotlin.String?, 
         @QueryParam(value = "to") to: kotlin.String?, 
         @QueryParam(value = "subject") subject: kotlin.String?, 
         @QueryParam(value = "mailid") mailid: kotlin.String?, 
         @QueryParam(value = "messageId") messageId: kotlin.String?, 
         @QueryParam(value = "replyto") replyto: kotlin.String?, 
         @QueryParam(value = "headerfrom") headerfrom: kotlin.String?, 
         @QueryParam(value = "delivered") delivered: kotlin.Int?, 
         @QueryParam(value = "skip") skip: kotlin.Int, 
         @QueryParam(value = "limit") limit: kotlin.Int, 
         startDate: DateOrTimestamp?, 
         endDate: DateOrTimestamp?, 
         @QueryParam(value = "sort") sort: kotlin.String, 
         @QueryParam(value = "dir") dir: kotlin.String, 
         @QueryParam(value = "groupby") groupby: kotlin.String
    ): MailLog {
        TODO()
    }
}
