//
// HistoryAPI.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation
#if canImport(AnyCodable)
import AnyCodable
#endif

open class HistoryAPI {

    /**
     displays a list of blocked email addresses
     
     - parameter apiResponseQueue: The queue on which api response is dispatched.
     - parameter completion: completion handler to receive the data and the error objects
     */
    @discardableResult
    open class func getStats(apiResponseQueue: DispatchQueue = OpenAPIClientAPI.apiResponseQueue, completion: @escaping ((_ data: [GetStats200ResponseInner]?, _ error: Error?) -> Void)) -> RequestTask {
        return getStatsWithRequestBuilder().execute(apiResponseQueue) { result in
            switch result {
            case let .success(response):
                completion(response.body, nil)
            case let .failure(error):
                completion(nil, error)
            }
        }
    }

    /**
     displays a list of blocked email addresses
     - GET /mail/stats
     - API Key:
       - type: apiKey X-API-KEY (HEADER)
       - name: apiKeyAuth
     - returns: RequestBuilder<[GetStats200ResponseInner]> 
     */
    open class func getStatsWithRequestBuilder() -> RequestBuilder<[GetStats200ResponseInner]> {
        let localVariablePath = "/mail/stats"
        let localVariableURLString = OpenAPIClientAPI.basePath + localVariablePath
        let localVariableParameters: [String: Any]? = nil

        let localVariableUrlComponents = URLComponents(string: localVariableURLString)

        let localVariableNillableHeaders: [String: Any?] = [
            :
        ]

        let localVariableHeaderParameters = APIHelper.rejectNilHeaders(localVariableNillableHeaders)

        let localVariableRequestBuilder: RequestBuilder<[GetStats200ResponseInner]>.Type = OpenAPIClientAPI.requestBuilderFactory.getBuilder()

        return localVariableRequestBuilder.init(method: "GET", URLString: (localVariableUrlComponents?.string ?? localVariableURLString), parameters: localVariableParameters, headers: localVariableHeaderParameters, requiresAuthentication: true)
    }

    /**
     displays the mail log
     
     - parameter id: (query) The ID of your mail order this will be sent through. (optional)
     - parameter origin: (query) originating ip address sending mail (optional)
     - parameter mx: (query) mx record mail was sent to (optional)
     - parameter from: (query) from email address (optional)
     - parameter to: (query) to/destination email address (optional)
     - parameter subject: (query) subject containing this string (optional)
     - parameter mailid: (query) mail id (optional)
     - parameter skip: (query) number of records to skip for pagination (optional, default to 0)
     - parameter limit: (query) maximum number of records to return (optional, default to 100)
     - parameter startDate: (query) earliest date to get emails in unix timestamp format (optional)
     - parameter endDate: (query) earliest date to get emails in unix timestamp format (optional)
     - parameter apiResponseQueue: The queue on which api response is dispatched.
     - parameter completion: completion handler to receive the data and the error objects
     */
    @discardableResult
    open class func viewMailLog(id: Int64? = nil, origin: String? = nil, mx: String? = nil, from: String? = nil, to: String? = nil, subject: String? = nil, mailid: String? = nil, skip: Int? = nil, limit: Int? = nil, startDate: Int64? = nil, endDate: Int64? = nil, apiResponseQueue: DispatchQueue = OpenAPIClientAPI.apiResponseQueue, completion: @escaping ((_ data: MailLog?, _ error: Error?) -> Void)) -> RequestTask {
        return viewMailLogWithRequestBuilder(id: id, origin: origin, mx: mx, from: from, to: to, subject: subject, mailid: mailid, skip: skip, limit: limit, startDate: startDate, endDate: endDate).execute(apiResponseQueue) { result in
            switch result {
            case let .success(response):
                completion(response.body, nil)
            case let .failure(error):
                completion(nil, error)
            }
        }
    }

    /**
     displays the mail log
     - GET /mail/log
     - Get a listing of the emails sent through this system 
     - API Key:
       - type: apiKey X-API-KEY (HEADER)
       - name: apiKeyAuth
     - parameter id: (query) The ID of your mail order this will be sent through. (optional)
     - parameter origin: (query) originating ip address sending mail (optional)
     - parameter mx: (query) mx record mail was sent to (optional)
     - parameter from: (query) from email address (optional)
     - parameter to: (query) to/destination email address (optional)
     - parameter subject: (query) subject containing this string (optional)
     - parameter mailid: (query) mail id (optional)
     - parameter skip: (query) number of records to skip for pagination (optional, default to 0)
     - parameter limit: (query) maximum number of records to return (optional, default to 100)
     - parameter startDate: (query) earliest date to get emails in unix timestamp format (optional)
     - parameter endDate: (query) earliest date to get emails in unix timestamp format (optional)
     - returns: RequestBuilder<MailLog> 
     */
    open class func viewMailLogWithRequestBuilder(id: Int64? = nil, origin: String? = nil, mx: String? = nil, from: String? = nil, to: String? = nil, subject: String? = nil, mailid: String? = nil, skip: Int? = nil, limit: Int? = nil, startDate: Int64? = nil, endDate: Int64? = nil) -> RequestBuilder<MailLog> {
        let localVariablePath = "/mail/log"
        let localVariableURLString = OpenAPIClientAPI.basePath + localVariablePath
        let localVariableParameters: [String: Any]? = nil

        var localVariableUrlComponents = URLComponents(string: localVariableURLString)
        localVariableUrlComponents?.queryItems = APIHelper.mapValuesToQueryItems([
            "id": (wrappedValue: id?.encodeToJSON(), isExplode: true),
            "origin": (wrappedValue: origin?.encodeToJSON(), isExplode: true),
            "mx": (wrappedValue: mx?.encodeToJSON(), isExplode: true),
            "from": (wrappedValue: from?.encodeToJSON(), isExplode: true),
            "to": (wrappedValue: to?.encodeToJSON(), isExplode: true),
            "subject": (wrappedValue: subject?.encodeToJSON(), isExplode: true),
            "mailid": (wrappedValue: mailid?.encodeToJSON(), isExplode: true),
            "skip": (wrappedValue: skip?.encodeToJSON(), isExplode: true),
            "limit": (wrappedValue: limit?.encodeToJSON(), isExplode: true),
            "startDate": (wrappedValue: startDate?.encodeToJSON(), isExplode: true),
            "endDate": (wrappedValue: endDate?.encodeToJSON(), isExplode: true),
        ])

        let localVariableNillableHeaders: [String: Any?] = [
            :
        ]

        let localVariableHeaderParameters = APIHelper.rejectNilHeaders(localVariableNillableHeaders)

        let localVariableRequestBuilder: RequestBuilder<MailLog>.Type = OpenAPIClientAPI.requestBuilderFactory.getBuilder()

        return localVariableRequestBuilder.init(method: "GET", URLString: (localVariableUrlComponents?.string ?? localVariableURLString), parameters: localVariableParameters, headers: localVariableHeaderParameters, requiresAuthentication: true)
    }
}