package org.openapitools.api;

import org.openapitools.api.ApiUtils
import org.openapitools.model.ErrorResponse
import org.openapitools.model.GenericResponse
import org.openapitools.model.MailLog
import org.openapitools.model.MailOrder
import org.openapitools.model.SendMail

class DefaultApi {
    String basePath = "https://api.mailbaby.net"
    String versionPath = ""
    ApiUtils apiUtils = new ApiUtils();

    def getMailOrders ( Long id, Closure onSuccess, Closure onFailure)  {
        String resourcePath = "/mail"

        // params
        def queryParams = [:]
        def headerParams = [:]
        def bodyParams
        def contentType


        if (id != null) {
            queryParams.put("id", id)
        }




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

    def sendAdvMailById ( SendMail sendMail, Closure onSuccess, Closure onFailure)  {
        String resourcePath = "/mail/advsend"

        // params
        def queryParams = [:]
        def headerParams = [:]
        def bodyParams
        def contentType

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

    def sendMailById ( SendMail sendMail, Closure onSuccess, Closure onFailure)  {
        String resourcePath = "/mail/send"

        // params
        def queryParams = [:]
        def headerParams = [:]
        def bodyParams
        def contentType

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
        String resourcePath = "/mail/log"

        // params
        def queryParams = [:]
        def headerParams = [:]
        def bodyParams
        def contentType


        if (id != null) {
            queryParams.put("id", id)
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
