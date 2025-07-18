//
// HistoryAPI.swift
//
// Generated by swagger-codegen
// https://github.com/swagger-api/swagger-codegen
//

import Foundation
import Alamofire


open class HistoryAPI: APIBase {
    /**
     * enum for parameter time
     */
    public enum Time_getStats: String { 
        case all = "all"
        case billing = "billing"
        case month = "month"
        case _7d = "7d"
        case _24h = "24h"
        case _1d = "1d"
        case _1h = "1h"
    }

    /**
     Account usage statistics.
     - parameter time: (query) The timeframe for the statistics. (optional)
     - parameter completion: completion handler to receive the data and the error objects
     */
    open class func getStats(time: Time_getStats? = nil, completion: @escaping ((_ data: MailStatsType?, _ error: ErrorResponse?) -> Void)) {
        getStatsWithRequestBuilder(time: time).execute { (response, error) -> Void in
            completion(response?.body, error)
        }
    }


    /**
     Account usage statistics.
     - GET /mail/stats
     - Returns information about the usage on your mail accounts.
     - API Key:
       - type: apiKey X-API-KEY 
       - name: apiKeyAuth
     - examples: [{contentType=application/json, example={
  "time" : "all",
  "usage" : 55,
  "currency" : "USD",
  "currencySymbol" : "$",
  "cost" : 1.02,
  "received" : 508,
  "sent" : 495,
  "volume" : {
    "to" : {
      "client@domain.com" : 395,
      "user@site.net" : 57,
      "sales@company.com" : 47,
      "client@anothersite.com" : 9
    },
    "from" : {
      "billing@somedomain.com" : 369,
      "sales@somedomain.com" : 139
    },
    "ip" : {
      "1.1.1.1" : 142,
      "2.2.2.2" : 132,
      "3.3.3.3" : 129,
      "4.4.4.4" : 105
    }
  }
}}]
     - parameter time: (query) The timeframe for the statistics. (optional)
     - returns: RequestBuilder<MailStatsType> 
     */
    open class func getStatsWithRequestBuilder(time: Time_getStats? = nil) -> RequestBuilder<MailStatsType> {
        let path = "/mail/stats"
        let URLString = SwaggerClientAPI.basePath + path
        let parameters: [String:Any]? = nil
        var url = URLComponents(string: URLString)
        url?.queryItems = APIHelper.mapValuesToQueryItems(values:[
                        "time": time?.rawValue
        ])

        let requestBuilder: RequestBuilder<MailStatsType>.Type = SwaggerClientAPI.requestBuilderFactory.getBuilder()

        return requestBuilder.init(method: "GET", URLString: (url?.string ?? URLString), parameters: parameters, isBody: false)
    }

    /**
     * enum for parameter delivered
     */
    public enum Delivered_viewMailLog: String { 
        case _0 = "0"
        case _1 = "1"
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
     - parameter replyto: (query) Reply-To Email Address (optional)
     - parameter headerfrom: (query) Header From Email Address (optional)
     - parameter delivered: (query) Limiting the emails to wether or not they were delivered. (optional)
     - parameter completion: completion handler to receive the data and the error objects
     */
    open class func viewMailLog(id: Int64? = nil, origin: String? = nil, mx: String? = nil, from: String? = nil, to: String? = nil, subject: String? = nil, mailid: String? = nil, skip: Int32? = nil, limit: Int32? = nil, startDate: Int64? = nil, endDate: Int64? = nil, replyto: String? = nil, headerfrom: String? = nil, delivered: Delivered_viewMailLog? = nil, completion: @escaping ((_ data: MailLog?, _ error: ErrorResponse?) -> Void)) {
        viewMailLogWithRequestBuilder(id: id, origin: origin, mx: mx, from: from, to: to, subject: subject, mailid: mailid, skip: skip, limit: limit, startDate: startDate, endDate: endDate, replyto: replyto, headerfrom: headerfrom, delivered: delivered).execute { (response, error) -> Void in
            completion(response?.body, error)
        }
    }


    /**
     displays the mail log
     - GET /mail/log
     - Get a listing of the emails sent through this system 
     - API Key:
       - type: apiKey X-API-KEY 
       - name: apiKeyAuth
     - examples: [{contentType=application/json, example={
  "total" : 1,
  "skip" : 0,
  "limit" : 100,
  "emails" : [ {
    "_id" : 103172,
    "id" : "17c7eda538e0005d03",
    "from" : "person@mysite.com",
    "to" : "client@isp.com",
    "subject" : "sell 0.005 shares",
    "messageId" : "<vmiLEebsuCbSpUxD7oN3REpaN4VbN6BrdCAbNKIrdAo@relay0.mailbaby.net>",
    "created" : "2021-10-14T08:50:10.000Z",
    "time" : 1634215809,
    "user" : "mb5658",
    "transtype" : "ESMTPSA",
    "origin" : "199.231.189.154",
    "interface" : "feeder",
    "sendingZone" : "interserver",
    "bodySize" : 63,
    "seq" : 1,
    "delivered" : 1,
    "recipient" : "client@isp.com",
    "domain" : "interserver.net",
    "locked" : 1,
    "lockTime" : "1634215818533",
    "assigned" : "relay1",
    "queued" : "2021-10-14T12:50:15.487Z",
    "mxHostname" : "mx.j.is.cc",
    "response" : "250 2.0.0 Ok queued as C91D83E128C"
  } ]
}}]
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
     - parameter replyto: (query) Reply-To Email Address (optional)
     - parameter headerfrom: (query) Header From Email Address (optional)
     - parameter delivered: (query) Limiting the emails to wether or not they were delivered. (optional)
     - returns: RequestBuilder<MailLog> 
     */
    open class func viewMailLogWithRequestBuilder(id: Int64? = nil, origin: String? = nil, mx: String? = nil, from: String? = nil, to: String? = nil, subject: String? = nil, mailid: String? = nil, skip: Int32? = nil, limit: Int32? = nil, startDate: Int64? = nil, endDate: Int64? = nil, replyto: String? = nil, headerfrom: String? = nil, delivered: Delivered_viewMailLog? = nil) -> RequestBuilder<MailLog> {
        let path = "/mail/log"
        let URLString = SwaggerClientAPI.basePath + path
        let parameters: [String:Any]? = nil
        var url = URLComponents(string: URLString)
        url?.queryItems = APIHelper.mapValuesToQueryItems(values:[
                        "id": id?.encodeToJSON(),
                        "origin": origin,
                        "mx": mx,
                        "from": from,
                        "to": to,
                        "subject": subject,
                        "mailid": mailid,
                        "skip": skip?.encodeToJSON(),
                        "limit": limit?.encodeToJSON(),
                        "startDate": startDate?.encodeToJSON(),
                        "endDate": endDate?.encodeToJSON(),
                        "replyto": replyto,
                        "headerfrom": headerfrom,
                        "delivered": delivered?.rawValue
        ])

        let requestBuilder: RequestBuilder<MailLog>.Type = SwaggerClientAPI.requestBuilderFactory.getBuilder()

        return requestBuilder.init(method: "GET", URLString: (url?.string ?? URLString), parameters: parameters, isBody: false)
    }

}
