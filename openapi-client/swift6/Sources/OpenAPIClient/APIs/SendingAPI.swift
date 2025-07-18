//
// SendingAPI.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation

open class SendingAPI {

    /**
     Sends an Email with Advanced Options
     
     - parameter subject: (form) The subject or title of the email 
     - parameter body: (form) The main email contents. 
     - parameter from: (form)  
     - parameter to: (form)  
     - parameter replyto: (form)  (optional)
     - parameter cc: (form)  (optional)
     - parameter bcc: (form)  (optional)
     - parameter attachments: (form) (optional) File attachments to include in the email.  The file contents must be base64 encoded! (optional)
     - parameter id: (form) (optional)  ID of the Mail order within our system to use as the Mail Account. (optional)
     - parameter apiConfiguration: The configuration for the http request.
     - returns: GenericResponse
     */
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open class func sendAdvMail(subject: String, body: String, from: EmailAddressTypes, to: EmailAddressesTypes, replyto: EmailAddressesTypes? = nil, cc: EmailAddressesTypes? = nil, bcc: EmailAddressesTypes? = nil, attachments: [MailAttachment]? = nil, id: Int64? = nil, apiConfiguration: OpenAPIClientAPIConfiguration = OpenAPIClientAPIConfiguration.shared) async throws(ErrorResponse) -> GenericResponse {
        return try await sendAdvMailWithRequestBuilder(subject: subject, body: body, from: from, to: to, replyto: replyto, cc: cc, bcc: bcc, attachments: attachments, id: id, apiConfiguration: apiConfiguration).execute().body
    }

    /**
     Sends an Email with Advanced Options
     - POST /mail/advsend
     - Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  ```BasicForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data to=support@interserver.net ```  ```ArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" ```  ```NameEmailForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=\"Joe <user@domain.com>\" \\ --data to=\"Joe <support@interserver.net>\" ```  ```MultToForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to=support@interserver.net, support@interserver.net\" ```  ```MultToFullForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to=Joe <support@interserver.net>, Joe <support@interserver.net>\" ```  ```MultToArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" \\ --data \"to[1][name]=Joe\" \\ --data \"to[1][email]=support@interserver.net\" ```  ```BasicJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/json' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"user@domain.com\", \"to\": \"support@interserver.net\" }' ```  ```ArrayJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/json' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": {\"name\": \"Joe\", \"email\": \"user@domain.com\"}, \"to\": [{\"name\": \"Joe\", \"email\": \"support@interserver.net\"}] }' ```  ```NameEmailJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/json' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"Joe <user@domain.com>\", \"to\": \"Joe <support@interserver.net>\" }' ``` 
     - API Key:
       - type: apiKey X-API-KEY (HEADER)
       - name: apiKeyAuth
     - parameter subject: (form) The subject or title of the email 
     - parameter body: (form) The main email contents. 
     - parameter from: (form)  
     - parameter to: (form)  
     - parameter replyto: (form)  (optional)
     - parameter cc: (form)  (optional)
     - parameter bcc: (form)  (optional)
     - parameter attachments: (form) (optional) File attachments to include in the email.  The file contents must be base64 encoded! (optional)
     - parameter id: (form) (optional)  ID of the Mail order within our system to use as the Mail Account. (optional)
     - parameter apiConfiguration: The configuration for the http request.
     - returns: RequestBuilder<GenericResponse> 
     */
    open class func sendAdvMailWithRequestBuilder(subject: String, body: String, from: EmailAddressTypes, to: EmailAddressesTypes, replyto: EmailAddressesTypes? = nil, cc: EmailAddressesTypes? = nil, bcc: EmailAddressesTypes? = nil, attachments: [MailAttachment]? = nil, id: Int64? = nil, apiConfiguration: OpenAPIClientAPIConfiguration = OpenAPIClientAPIConfiguration.shared) -> RequestBuilder<GenericResponse> {
        let localVariablePath = "/mail/advsend"
        let localVariableURLString = apiConfiguration.basePath + localVariablePath
        let localVariableFormParams: [String: (any Sendable)?] = [
            "subject": subject.asParameter(codableHelper: apiConfiguration.codableHelper),
            "body": body.asParameter(codableHelper: apiConfiguration.codableHelper),
            "from": from.asParameter(codableHelper: apiConfiguration.codableHelper),
            "to": to.asParameter(codableHelper: apiConfiguration.codableHelper),
            "replyto": replyto?.asParameter(codableHelper: apiConfiguration.codableHelper),
            "cc": cc?.asParameter(codableHelper: apiConfiguration.codableHelper),
            "bcc": bcc?.asParameter(codableHelper: apiConfiguration.codableHelper),
            "attachments": attachments?.asParameter(codableHelper: apiConfiguration.codableHelper),
            "id": id?.asParameter(codableHelper: apiConfiguration.codableHelper),
        ]

        let localVariableNonNullParameters = APIHelper.rejectNil(localVariableFormParams)
        let localVariableParameters = APIHelper.convertBoolToString(localVariableNonNullParameters)

        let localVariableUrlComponents = URLComponents(string: localVariableURLString)

        let localVariableNillableHeaders: [String: (any Sendable)?] = [
            "Content-Type": "application/x-www-form-urlencoded",
        ]

        let localVariableHeaderParameters = APIHelper.rejectNilHeaders(localVariableNillableHeaders)

        let localVariableRequestBuilder: RequestBuilder<GenericResponse>.Type = apiConfiguration.requestBuilderFactory.getBuilder()

        return localVariableRequestBuilder.init(method: "POST", URLString: (localVariableUrlComponents?.string ?? localVariableURLString), parameters: localVariableParameters, headers: localVariableHeaderParameters, requiresAuthentication: true, apiConfiguration: apiConfiguration)
    }

    /**
     Sends an Email
     
     - parameter to: (form) The Contact whom is the primary recipient of this email. 
     - parameter from: (form) The contact whom is the this email is from. 
     - parameter subject: (form) The subject or title of the email 
     - parameter body: (form) The main email contents. 
     - parameter apiConfiguration: The configuration for the http request.
     - returns: GenericResponse
     */
    @available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 6.0, *)
    open class func sendMail(to: String, from: String, subject: String, body: String, apiConfiguration: OpenAPIClientAPIConfiguration = OpenAPIClientAPIConfiguration.shared) async throws(ErrorResponse) -> GenericResponse {
        return try await sendMailWithRequestBuilder(to: to, from: from, subject: subject, body: body, apiConfiguration: apiConfiguration).execute().body
    }

    /**
     Sends an Email
     - POST /mail/send
     - Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
     - API Key:
       - type: apiKey X-API-KEY (HEADER)
       - name: apiKeyAuth
     - parameter to: (form) The Contact whom is the primary recipient of this email. 
     - parameter from: (form) The contact whom is the this email is from. 
     - parameter subject: (form) The subject or title of the email 
     - parameter body: (form) The main email contents. 
     - parameter apiConfiguration: The configuration for the http request.
     - returns: RequestBuilder<GenericResponse> 
     */
    open class func sendMailWithRequestBuilder(to: String, from: String, subject: String, body: String, apiConfiguration: OpenAPIClientAPIConfiguration = OpenAPIClientAPIConfiguration.shared) -> RequestBuilder<GenericResponse> {
        let localVariablePath = "/mail/send"
        let localVariableURLString = apiConfiguration.basePath + localVariablePath
        let localVariableFormParams: [String: (any Sendable)?] = [
            "to": to.asParameter(codableHelper: apiConfiguration.codableHelper),
            "from": from.asParameter(codableHelper: apiConfiguration.codableHelper),
            "subject": subject.asParameter(codableHelper: apiConfiguration.codableHelper),
            "body": body.asParameter(codableHelper: apiConfiguration.codableHelper),
        ]

        let localVariableNonNullParameters = APIHelper.rejectNil(localVariableFormParams)
        let localVariableParameters = APIHelper.convertBoolToString(localVariableNonNullParameters)

        let localVariableUrlComponents = URLComponents(string: localVariableURLString)

        let localVariableNillableHeaders: [String: (any Sendable)?] = [
            "Content-Type": "application/x-www-form-urlencoded",
        ]

        let localVariableHeaderParameters = APIHelper.rejectNilHeaders(localVariableNillableHeaders)

        let localVariableRequestBuilder: RequestBuilder<GenericResponse>.Type = apiConfiguration.requestBuilderFactory.getBuilder()

        return localVariableRequestBuilder.init(method: "POST", URLString: (localVariableUrlComponents?.string ?? localVariableURLString), parameters: localVariableParameters, headers: localVariableHeaderParameters, requiresAuthentication: true, apiConfiguration: apiConfiguration)
    }
}
