//
// DefaultAPI.swift
//
// Generated by swagger-codegen
// https://github.com/swagger-api/swagger-codegen
//

import Foundation
import Alamofire


open class DefaultAPI {
    /**
     Gets mail order information by id

     - parameter _id: (path) User ID 
     - parameter completion: completion handler to receive the data and the error objects
     */
    open class func getMailById(_id: Int64, completion: @escaping ((_ data: MailOrder?,_ error: Error?) -> Void)) {
        getMailByIdWithRequestBuilder(_id: _id).execute { (response, error) -> Void in
            completion(response?.body, error)
        }
    }


    /**
     Gets mail order information by id
     - GET /mail/{id}

     - API Key:
       - type: apiKey X-API-KEY 
       - name: apiKeyAuth
     - API Key:
       - type: apiKey X-API-LOGIN 
       - name: apiLoginAuth
     - API Key:
       - type: apiKey X-API-PASS 
       - name: apiPasswordAuth
     - examples: [{contentType=application/json, example={
  "password" : "guest123",
  "comment" : "main mail account",
  "id" : 1234,
  "status" : "active",
  "username" : "mb1234"
}}]
     - parameter _id: (path) User ID 

     - returns: RequestBuilder<MailOrder> 
     */
    open class func getMailByIdWithRequestBuilder(_id: Int64) -> RequestBuilder<MailOrder> {
        var path = "/mail/{id}"
        let _idPreEscape = "\(_id)"
        let _idPostEscape = _idPreEscape.addingPercentEncoding(withAllowedCharacters: .urlPathAllowed) ?? ""
        path = path.replacingOccurrences(of: "{id}", with: _idPostEscape, options: .literal, range: nil)
        let URLString = SwaggerClientAPI.basePath + path
        let parameters: [String:Any]? = nil
        let url = URLComponents(string: URLString)


        let requestBuilder: RequestBuilder<MailOrder>.Type = SwaggerClientAPI.requestBuilderFactory.getBuilder()

        return requestBuilder.init(method: "GET", URLString: (url?.string ?? URLString), parameters: parameters, isBody: false)
    }
    /**
     displays a list of mail service orders

     - parameter completion: completion handler to receive the data and the error objects
     */
    open class func getMailOrders(completion: @escaping ((_ data: MailOrders?,_ error: Error?) -> Void)) {
        getMailOrdersWithRequestBuilder().execute { (response, error) -> Void in
            completion(response?.body, error)
        }
    }


    /**
     displays a list of mail service orders
     - GET /mail
     - 

     - API Key:
       - type: apiKey X-API-KEY 
       - name: apiKeyAuth
     - API Key:
       - type: apiKey X-API-LOGIN 
       - name: apiLoginAuth
     - API Key:
       - type: apiKey X-API-PASS 
       - name: apiPasswordAuth
     - examples: [{contentType=application/json, example=[ {
  "password" : "guest123",
  "comment" : "main mail account",
  "id" : 1234,
  "status" : "active",
  "username" : "mb1234"
}, {
  "password" : "guest123",
  "comment" : "main mail account",
  "id" : 1234,
  "status" : "active",
  "username" : "mb1234"
} ]}]

     - returns: RequestBuilder<MailOrders> 
     */
    open class func getMailOrdersWithRequestBuilder() -> RequestBuilder<MailOrders> {
        let path = "/mail"
        let URLString = SwaggerClientAPI.basePath + path
        let parameters: [String:Any]? = nil
        let url = URLComponents(string: URLString)


        let requestBuilder: RequestBuilder<MailOrders>.Type = SwaggerClientAPI.requestBuilderFactory.getBuilder()

        return requestBuilder.init(method: "GET", URLString: (url?.string ?? URLString), parameters: parameters, isBody: false)
    }
    /**
     Checks if the server is running

     - parameter completion: completion handler to receive the data and the error objects
     */
    open class func pingServer(completion: @escaping ((_ data: Void?,_ error: Error?) -> Void)) {
        pingServerWithRequestBuilder().execute { (response, error) -> Void in
            if error == nil {
                completion((), error)
            } else {
                completion(nil, error)
            }
        }
    }


    /**
     Checks if the server is running
     - GET /ping
     - 


     - returns: RequestBuilder<Void> 
     */
    open class func pingServerWithRequestBuilder() -> RequestBuilder<Void> {
        let path = "/ping"
        let URLString = SwaggerClientAPI.basePath + path
        let parameters: [String:Any]? = nil
        let url = URLComponents(string: URLString)


        let requestBuilder: RequestBuilder<Void>.Type = SwaggerClientAPI.requestBuilderFactory.getNonDecodableBuilder()

        return requestBuilder.init(method: "GET", URLString: (url?.string ?? URLString), parameters: parameters, isBody: false)
    }
    /**
     places a mail order

     - parameter body: (body) Inventory item to add (optional)
     - parameter completion: completion handler to receive the data and the error objects
     */
    open class func placeMailOrder(body: MailOrder? = nil, completion: @escaping ((_ data: Void?,_ error: Error?) -> Void)) {
        placeMailOrderWithRequestBuilder(body: body).execute { (response, error) -> Void in
            if error == nil {
                completion((), error)
            } else {
                completion(nil, error)
            }
        }
    }


    /**
     places a mail order
     - POST /mail/order

     - API Key:
       - type: apiKey X-API-KEY 
       - name: apiKeyAuth
     - API Key:
       - type: apiKey X-API-LOGIN 
       - name: apiLoginAuth
     - API Key:
       - type: apiKey X-API-PASS 
       - name: apiPasswordAuth
     - parameter body: (body) Inventory item to add (optional)

     - returns: RequestBuilder<Void> 
     */
    open class func placeMailOrderWithRequestBuilder(body: MailOrder? = nil) -> RequestBuilder<Void> {
        let path = "/mail/order"
        let URLString = SwaggerClientAPI.basePath + path
        let parameters = JSONEncodingHelper.encodingParameters(forEncodableObject: body)
        let url = URLComponents(string: URLString)


        let requestBuilder: RequestBuilder<Void>.Type = SwaggerClientAPI.requestBuilderFactory.getNonDecodableBuilder()

        return requestBuilder.init(method: "POST", URLString: (url?.string ?? URLString), parameters: parameters, isBody: true)
    }
    /**
     Sends an Email

     - parameter _id: (path) User ID 
     - parameter subject: (query)  (optional)
     - parameter body: (query)  (optional)
     - parameter to: (query)  (optional)
     - parameter from: (query)  (optional)
     - parameter completion: completion handler to receive the data and the error objects
     */
    open class func sendMailById(_id: Int64, subject: String? = nil, body: String? = nil, to: String? = nil, from: String? = nil, completion: @escaping ((_ data: GenericResponse?,_ error: Error?) -> Void)) {
        sendMailByIdWithRequestBuilder(_id: _id, subject: subject, body: body, to: to, from: from).execute { (response, error) -> Void in
            completion(response?.body, error)
        }
    }


    /**
     Sends an Email
     - POST /mail/{id}/send

     - API Key:
       - type: apiKey X-API-KEY 
       - name: apiKeyAuth
     - API Key:
       - type: apiKey X-API-LOGIN 
       - name: apiLoginAuth
     - API Key:
       - type: apiKey X-API-PASS 
       - name: apiPasswordAuth
     - examples: [{contentType=application/json, example={
  "status_text" : "The command completed successfully.",
  "status" : "ok"
}}]
     - parameter _id: (path) User ID 
     - parameter subject: (query)  (optional)
     - parameter body: (query)  (optional)
     - parameter to: (query)  (optional)
     - parameter from: (query)  (optional)

     - returns: RequestBuilder<GenericResponse> 
     */
    open class func sendMailByIdWithRequestBuilder(_id: Int64, subject: String? = nil, body: String? = nil, to: String? = nil, from: String? = nil) -> RequestBuilder<GenericResponse> {
        var path = "/mail/{id}/send"
        let _idPreEscape = "\(_id)"
        let _idPostEscape = _idPreEscape.addingPercentEncoding(withAllowedCharacters: .urlPathAllowed) ?? ""
        path = path.replacingOccurrences(of: "{id}", with: _idPostEscape, options: .literal, range: nil)
        let URLString = SwaggerClientAPI.basePath + path
        let parameters: [String:Any]? = nil
        var url = URLComponents(string: URLString)
        url?.queryItems = APIHelper.mapValuesToQueryItems([
                        "subject": subject, 
                        "body": body, 
                        "to": to, 
                        "from": from
        ])


        let requestBuilder: RequestBuilder<GenericResponse>.Type = SwaggerClientAPI.requestBuilderFactory.getBuilder()

        return requestBuilder.init(method: "POST", URLString: (url?.string ?? URLString), parameters: parameters, isBody: false)
    }
    /**
     validatess order details before placing an order

     - parameter completion: completion handler to receive the data and the error objects
     */
    open class func validateMailOrder(completion: @escaping ((_ data: Void?,_ error: Error?) -> Void)) {
        validateMailOrderWithRequestBuilder().execute { (response, error) -> Void in
            if error == nil {
                completion((), error)
            } else {
                completion(nil, error)
            }
        }
    }


    /**
     validatess order details before placing an order
     - GET /mail/order
     - 

     - API Key:
       - type: apiKey X-API-KEY 
       - name: apiKeyAuth
     - API Key:
       - type: apiKey X-API-LOGIN 
       - name: apiLoginAuth
     - API Key:
       - type: apiKey X-API-PASS 
       - name: apiPasswordAuth

     - returns: RequestBuilder<Void> 
     */
    open class func validateMailOrderWithRequestBuilder() -> RequestBuilder<Void> {
        let path = "/mail/order"
        let URLString = SwaggerClientAPI.basePath + path
        let parameters: [String:Any]? = nil
        let url = URLComponents(string: URLString)


        let requestBuilder: RequestBuilder<Void>.Type = SwaggerClientAPI.requestBuilderFactory.getNonDecodableBuilder()

        return requestBuilder.init(method: "GET", URLString: (url?.string ?? URLString), parameters: parameters, isBody: false)
    }
    /**
     displays the mail log

     - parameter _id: (path) User ID 
     - parameter searchString: (query) pass an optional search string for looking up inventory (optional)
     - parameter skip: (query) number of records to skip for pagination (optional)
     - parameter limit: (query) maximum number of records to return (optional)
     - parameter completion: completion handler to receive the data and the error objects
     */
    open class func viewMailLogById(_id: Int64, searchString: String? = nil, skip: Int? = nil, limit: Int? = nil, completion: @escaping ((_ data: [MailLog]?,_ error: Error?) -> Void)) {
        viewMailLogByIdWithRequestBuilder(_id: _id, searchString: searchString, skip: skip, limit: limit).execute { (response, error) -> Void in
            completion(response?.body, error)
        }
    }


    /**
     displays the mail log
     - GET /mail/{id}/log

     - API Key:
       - type: apiKey X-API-KEY 
       - name: apiKeyAuth
     - API Key:
       - type: apiKey X-API-LOGIN 
       - name: apiLoginAuth
     - API Key:
       - type: apiKey X-API-PASS 
       - name: apiPasswordAuth
     - examples: [{contentType=application/json, example=[ {
  "id" : 0
}, {
  "id" : 0
} ]}]
     - parameter _id: (path) User ID 
     - parameter searchString: (query) pass an optional search string for looking up inventory (optional)
     - parameter skip: (query) number of records to skip for pagination (optional)
     - parameter limit: (query) maximum number of records to return (optional)

     - returns: RequestBuilder<[MailLog]> 
     */
    open class func viewMailLogByIdWithRequestBuilder(_id: Int64, searchString: String? = nil, skip: Int? = nil, limit: Int? = nil) -> RequestBuilder<[MailLog]> {
        var path = "/mail/{id}/log"
        let _idPreEscape = "\(_id)"
        let _idPostEscape = _idPreEscape.addingPercentEncoding(withAllowedCharacters: .urlPathAllowed) ?? ""
        path = path.replacingOccurrences(of: "{id}", with: _idPostEscape, options: .literal, range: nil)
        let URLString = SwaggerClientAPI.basePath + path
        let parameters: [String:Any]? = nil
        var url = URLComponents(string: URLString)
        url?.queryItems = APIHelper.mapValuesToQueryItems([
                        "searchString": searchString, 
                        "skip": skip?.encodeToJSON(), 
                        "limit": limit?.encodeToJSON()
        ])


        let requestBuilder: RequestBuilder<[MailLog]>.Type = SwaggerClientAPI.requestBuilderFactory.getBuilder()

        return requestBuilder.init(method: "GET", URLString: (url?.string ?? URLString), parameters: parameters, isBody: false)
    }
}