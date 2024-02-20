package org.openapitools.api;

import org.openapitools.api.ApiUtils
import org.openapitools.model.DenyRuleRecord
import org.openapitools.model.ErrorMessage
import org.openapitools.model.GenericResponse
import org.openapitools.model.MailBlocks

class BlockingApi {
    String basePath = "https://api.mailbaby.net"
    String versionPath = ""
    ApiUtils apiUtils = new ApiUtils();

    def addRule ( String type, String data, String user, Closure onSuccess, Closure onFailure)  {
        String resourcePath = "/mail/rules"

        // params
        def queryParams = [:]
        def headerParams = [:]
        def bodyParams
        def contentType

        // verify required params are set
        if (type == null) {
            throw new RuntimeException("missing required params type")
        }
        // verify required params are set
        if (data == null) {
            throw new RuntimeException("missing required params data")
        }




        contentType = 'application/x-www-form-urlencoded';
        bodyParams = [:]
        bodyParams.put("user", user)
        bodyParams.put("type", type)
        bodyParams.put("data", data)

        apiUtils.invokeApi(onSuccess, onFailure, basePath, versionPath, resourcePath, queryParams, headerParams, bodyParams, contentType,
                    "POST", "",
                    GenericResponse.class )

    }

    def deleteRule ( Integer ruleId, Closure onSuccess, Closure onFailure)  {
        String resourcePath = "/mail/rules/${ruleId}"

        // params
        def queryParams = [:]
        def headerParams = [:]
        def bodyParams
        def contentType

        // verify required params are set
        if (ruleId == null) {
            throw new RuntimeException("missing required params ruleId")
        }





        apiUtils.invokeApi(onSuccess, onFailure, basePath, versionPath, resourcePath, queryParams, headerParams, bodyParams, contentType,
                    "DELETE", "",
                    GenericResponse.class )

    }

    def delistBlock ( String body, Closure onSuccess, Closure onFailure)  {
        String resourcePath = "/mail/blocks/delete"

        // params
        def queryParams = [:]
        def headerParams = [:]
        def bodyParams
        def contentType

        // verify required params are set
        if (body == null) {
            throw new RuntimeException("missing required params body")
        }



        contentType = 'application/json';
        bodyParams = body


        apiUtils.invokeApi(onSuccess, onFailure, basePath, versionPath, resourcePath, queryParams, headerParams, bodyParams, contentType,
                    "POST", "",
                    GenericResponse.class )

    }

    def getMailBlocks ( Closure onSuccess, Closure onFailure)  {
        String resourcePath = "/mail/blocks"

        // params
        def queryParams = [:]
        def headerParams = [:]
        def bodyParams
        def contentType






        apiUtils.invokeApi(onSuccess, onFailure, basePath, versionPath, resourcePath, queryParams, headerParams, bodyParams, contentType,
                    "GET", "",
                    MailBlocks.class )

    }

    def getRules ( Closure onSuccess, Closure onFailure)  {
        String resourcePath = "/mail/rules"

        // params
        def queryParams = [:]
        def headerParams = [:]
        def bodyParams
        def contentType






        apiUtils.invokeApi(onSuccess, onFailure, basePath, versionPath, resourcePath, queryParams, headerParams, bodyParams, contentType,
                    "GET", "array",
                    DenyRuleRecord.class )

    }

}
