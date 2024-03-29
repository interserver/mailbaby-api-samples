//
// ErrorMessage.swift
//
// Generated by swagger-codegen
// https://github.com/swagger-api/swagger-codegen
//

import Foundation


/** The resposne when an error occurs. */
open class ErrorMessage: JSONEncodable {
    /** The response code associated with the error. */
    public var code: Int32?
    /** The details or description of the error. */
    public var message: String?

    public init() {}

    // MARK: JSONEncodable
    open func encodeToJSON() -> Any {
        var nillableDictionary = [String:Any?]()
        nillableDictionary["code"] = self.code?.encodeToJSON()
        nillableDictionary["message"] = self.message

        let dictionary: [String:Any] = APIHelper.rejectNil(nillableDictionary) ?? [:]
        return dictionary
    }
}
