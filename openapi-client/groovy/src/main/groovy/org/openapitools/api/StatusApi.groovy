package org.openapitools.api;

import org.openapitools.api.ApiUtils

class StatusApi {
    String basePath = "https://api.mailbaby.net"
    String versionPath = ""
    ApiUtils apiUtils = new ApiUtils();

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

}
