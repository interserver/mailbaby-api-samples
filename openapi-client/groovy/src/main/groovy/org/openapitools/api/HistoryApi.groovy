package org.openapitools.api;

import org.openapitools.api.ApiUtils
import org.openapitools.model.ErrorMessage
import org.openapitools.model.MailLog
import org.openapitools.model.MailStatsType

class HistoryApi {
    String basePath = "https://api.mailbaby.net"
    String versionPath = ""
    ApiUtils apiUtils = new ApiUtils();

    def getStats ( String time, Closure onSuccess, Closure onFailure)  {
        String resourcePath = "/mail/stats"

        // params
        def queryParams = [:]
        def headerParams = [:]
        def bodyParams
        def contentType


        if (time != null) {
            queryParams.put("time", time)
        }




        apiUtils.invokeApi(onSuccess, onFailure, basePath, versionPath, resourcePath, queryParams, headerParams, bodyParams, contentType,
                    "GET", "",
                    MailStatsType.class )

    }

    def viewMailLog ( Long id, String origin, String mx, String from, String to, String subject, String mailid, Integer skip, Integer limit, Long startDate, Long endDate, String replyto, String headerfrom, String delivered, Closure onSuccess, Closure onFailure)  {
        String resourcePath = "/mail/log"

        // params
        def queryParams = [:]
        def headerParams = [:]
        def bodyParams
        def contentType


        if (id != null) {
            queryParams.put("id", id)
        }
        if (origin != null) {
            queryParams.put("origin", origin)
        }
        if (mx != null) {
            queryParams.put("mx", mx)
        }
        if (from != null) {
            queryParams.put("from", from)
        }
        if (to != null) {
            queryParams.put("to", to)
        }
        if (subject != null) {
            queryParams.put("subject", subject)
        }
        if (mailid != null) {
            queryParams.put("mailid", mailid)
        }
        if (skip != null) {
            queryParams.put("skip", skip)
        }
        if (limit != null) {
            queryParams.put("limit", limit)
        }
        if (startDate != null) {
            queryParams.put("startDate", startDate)
        }
        if (endDate != null) {
            queryParams.put("endDate", endDate)
        }
        if (replyto != null) {
            queryParams.put("replyto", replyto)
        }
        if (headerfrom != null) {
            queryParams.put("headerfrom", headerfrom)
        }
        if (delivered != null) {
            queryParams.put("delivered", delivered)
        }




        apiUtils.invokeApi(onSuccess, onFailure, basePath, versionPath, resourcePath, queryParams, headerParams, bodyParams, contentType,
                    "GET", "",
                    MailLog.class )

    }

}
