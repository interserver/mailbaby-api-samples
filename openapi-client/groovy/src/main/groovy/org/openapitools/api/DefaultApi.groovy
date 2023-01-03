package org.openapitools.api;

import org.openapitools.api.ApiUtils
import org.openapitools.model.GenericResponse
import org.openapitools.model.GetMailOrders200ResponseInner
import org.openapitools.model.GetMailOrders401Response
import org.openapitools.model.MailLog
import org.openapitools.model.SendMailAdv

class DefaultApi {
    String basePath = "https://api.mailbaby.net"
    String versionPath = ""
    ApiUtils apiUtils = new ApiUtils();

    def getMailOrders ( Closure onSuccess, Closure onFailure)  {
        String resourcePath = "/mail"

        // params
        def queryParams = [:]
        def headerParams = [:]
        def bodyParams
        def contentType






        apiUtils.invokeApi(onSuccess, onFailure, basePath, versionPath, resourcePath, queryParams, headerParams, bodyParams, contentType,
                    "GET", "array",
                    GetMailOrders200ResponseInner.class )

    }

    def pingServer ( Closure onSuccess, Closure onFailure)  {
        String resourcePath = "/ping"

        // params
        def queryParams = [:]
        def headerParams = [:]
        def bodyParams
        def contentType






        apiUtils.invokeApi(onSuccess, onFailure, basePath, versionPath, resourcePath, queryParams, headerParams, bodyParams, contentType,
                    "GET", "",
                    null )

    }

    def sendAdvMail ( SendMailAdv sendMailAdv, Closure onSuccess, Closure onFailure)  {
        String resourcePath = "/mail/advsend"

        // params
        def queryParams = [:]
        def headerParams = [:]
        def bodyParams
        def contentType

        // verify required params are set
        if (sendMailAdv == null) {
            throw new RuntimeException("missing required params sendMailAdv")
        }



        contentType = 'application/json';
        bodyParams = sendMailAdv


        apiUtils.invokeApi(onSuccess, onFailure, basePath, versionPath, resourcePath, queryParams, headerParams, bodyParams, contentType,
                    "POST", "",
                    GenericResponse.class )

    }

    def sendMail ( String to, String from, String subject, String body, Closure onSuccess, Closure onFailure)  {
        String resourcePath = "/mail/send"

        // params
        def queryParams = [:]
        def headerParams = [:]
        def bodyParams
        def contentType

        // verify required params are set
        if (to == null) {
            throw new RuntimeException("missing required params to")
        }
        // verify required params are set
        if (from == null) {
            throw new RuntimeException("missing required params from")
        }
        // verify required params are set
        if (subject == null) {
            throw new RuntimeException("missing required params subject")
        }
        // verify required params are set
        if (body == null) {
            throw new RuntimeException("missing required params body")
        }




        contentType = 'application/x-www-form-urlencoded';
        bodyParams = [:]
        bodyParams.put("to", to)
        bodyParams.put("from", from)
        bodyParams.put("subject", subject)
        bodyParams.put("body", body)

        apiUtils.invokeApi(onSuccess, onFailure, basePath, versionPath, resourcePath, queryParams, headerParams, bodyParams, contentType,
                    "POST", "",
                    GenericResponse.class )

    }

    def viewMailLog ( Long id, String search, Integer skip, Integer limit, Long startDate, Long endDate, Closure onSuccess, Closure onFailure)  {
        String resourcePath = "/mail/log"

        // params
        def queryParams = [:]
        def headerParams = [:]
        def bodyParams
        def contentType


        if (id != null) {
            queryParams.put("id", id)
        }
        if (search != null) {
            queryParams.put("search", search)
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




        apiUtils.invokeApi(onSuccess, onFailure, basePath, versionPath, resourcePath, queryParams, headerParams, bodyParams, contentType,
                    "GET", "",
                    MailLog.class )

    }

}
