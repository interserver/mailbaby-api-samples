package org.openapitools.api;

import org.openapitools.api.ApiUtils
import org.openapitools.model.ErrorMessage
import org.openapitools.model.MailOrder

class ServicesApi {
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
                    MailOrder.class )

    }

}
