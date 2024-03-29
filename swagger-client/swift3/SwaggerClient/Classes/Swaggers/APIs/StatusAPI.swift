//
// StatusAPI.swift
//
// Generated by swagger-codegen
// https://github.com/swagger-api/swagger-codegen
//

import Foundation
import Alamofire


open class StatusAPI: APIBase {
    /**
     Checks if the server is running
     - parameter completion: completion handler to receive the data and the error objects
     */
    open class func pingServer(completion: @escaping ((_ error: ErrorResponse?) -> Void)) {
        pingServerWithRequestBuilder().execute { (response, error) -> Void in
            completion(error)
        }
    }


    /**
     Checks if the server is running
     - GET /ping
     - API Key:
       - type: apiKey X-API-KEY 
       - name: apiKeyAuth
     - returns: RequestBuilder<Void> 
     */
    open class func pingServerWithRequestBuilder() -> RequestBuilder<Void> {
        let path = "/ping"
        let URLString = SwaggerClientAPI.basePath + path
        let parameters: [String:Any]? = nil

        let url = URLComponents(string: URLString)

        let requestBuilder: RequestBuilder<Void>.Type = SwaggerClientAPI.requestBuilderFactory.getBuilder()

        return requestBuilder.init(method: "GET", URLString: (url?.string ?? URLString), parameters: parameters, isBody: false)
    }

}
