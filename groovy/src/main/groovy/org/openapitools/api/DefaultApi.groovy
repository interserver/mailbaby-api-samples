package org.openapitools.api;

import org.openapitools.api.ApiUtils
import org.openapitools.model.ErrorResponse
import org.openapitools.model.ErrorResposne
import org.openapitools.model.GenericResponse
import org.openapitools.model.MailLog
import org.openapitools.model.MailOrder
import org.openapitools.model.SendMail

class DefaultApi {
    String basePath = "https://api.mailbaby.net"
    String versionPath = ""
    ApiUtils apiUtils = new ApiUtils();

    def getMailById ( Long id, Closure onSuccess, Closure onFailure)  {
        String resourcePath = "/mail/${id}"

        // params
        def queryParams = [:]
        def headerParams = [:]
        def bodyParams
        def contentType

        // verify required params are set
        if (id == null) {
            throw new RuntimeException("missing required params id")
        }





        apiUtils.invokeApi(onSuccess, onFailure, basePath, versionPath, resourcePath, queryParams, headerParams, bodyParams, contentType,
                    "GET", "",
                    MailOrder.class )

    }

    def getMailOrders ( Closure onSuccess, Closure onFailure)  {
        String resourcePath = "/mail"

        // params
        def queryParams = [:]
        def headerParams = [:]
        def bodyParams
        def contentType






        apiUtils.invokeApi(onSuccess, onFailure, basePath, versionPath, resourcePath, queryParams, headerParams, bodyParams, contentType,
                    "GET", "array",
                    MailOrder.class )

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

    def placeMailOrder ( MailOrder mailOrder, Closure onSuccess, Closure onFailure)  {
        String resourcePath = "/mail/order"

        // params
        def queryParams = [:]
        def headerParams = [:]
        def bodyParams
        def contentType




        contentType = 'application/json';
        bodyParams = mailOrder


        apiUtils.invokeApi(onSuccess, onFailure, basePath, versionPath, resourcePath, queryParams, headerParams, bodyParams, contentType,
                    "POST", "",
                    null )

    }

    def sendAdvMailById ( Long id, SendMail sendMail, Closure onSuccess, Closure onFailure)  {
        String resourcePath = "/mail/${id}/advsend"

        // params
        def queryParams = [:]
        def headerParams = [:]
        def bodyParams
        def contentType

        // verify required params are set
        if (id == null) {
            throw new RuntimeException("missing required params id")
        }
        // verify required params are set
        if (sendMail == null) {
            throw new RuntimeException("missing required params sendMail")
        }



        contentType = 'application/json';
        bodyParams = sendMail


        apiUtils.invokeApi(onSuccess, onFailure, basePath, versionPath, resourcePath, queryParams, headerParams, bodyParams, contentType,
                    "POST", "",
                    GenericResponse.class )

    }

    def sendMailById ( Long id, String subject, String body, String to, String toName, String from, String fromName, Closure onSuccess, Closure onFailure)  {
        String resourcePath = "/mail/${id}/send"

        // params
        def queryParams = [:]
        def headerParams = [:]
        def bodyParams
        def contentType

        // verify required params are set
        if (id == null) {
            throw new RuntimeException("missing required params id")
        }

        if (subject != null) {
            queryParams.put("subject", subject)
        }
        if (body != null) {
            queryParams.put("body", body)
        }
        if (to != null) {
            queryParams.put("to", to)
        }
        if (toName != null) {
            queryParams.put("toName", toName)
        }
        if (from != null) {
            queryParams.put("from", from)
        }
        if (fromName != null) {
            queryParams.put("fromName", fromName)
        }




        apiUtils.invokeApi(onSuccess, onFailure, basePath, versionPath, resourcePath, queryParams, headerParams, bodyParams, contentType,
                    "POST", "",
                    GenericResponse.class )

    }

    def validateMailOrder ( Closure onSuccess, Closure onFailure)  {
        String resourcePath = "/mail/order"

        // params
        def queryParams = [:]
        def headerParams = [:]
        def bodyParams
        def contentType






        apiUtils.invokeApi(onSuccess, onFailure, basePath, versionPath, resourcePath, queryParams, headerParams, bodyParams, contentType,
                    "GET", "",
                    null )

    }

    def viewMailLogById ( Long id, String searchString, Integer skip, Integer limit, Closure onSuccess, Closure onFailure)  {
        String resourcePath = "/mail/${id}/log"

        // params
        def queryParams = [:]
        def headerParams = [:]
        def bodyParams
        def contentType

        // verify required params are set
        if (id == null) {
            throw new RuntimeException("missing required params id")
        }

        if (searchString != null) {
            queryParams.put("searchString", searchString)
        }
        if (skip != null) {
            queryParams.put("skip", skip)
        }
        if (limit != null) {
            queryParams.put("limit", limit)
        }




        apiUtils.invokeApi(onSuccess, onFailure, basePath, versionPath, resourcePath, queryParams, headerParams, bodyParams, contentType,
                    "GET", "array",
                    MailLog.class )

    }

}
