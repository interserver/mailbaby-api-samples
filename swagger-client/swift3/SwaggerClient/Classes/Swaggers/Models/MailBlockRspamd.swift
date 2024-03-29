//
// MailBlockRspamd.swift
//
// Generated by swagger-codegen
// https://github.com/swagger-api/swagger-codegen
//

import Foundation


/** This is a block entry from the rspamd block list. */
open class MailBlockRspamd: JSONEncodable {
    public var from: String?
    public var subject: String?

    public init() {}

    // MARK: JSONEncodable
    open func encodeToJSON() -> Any {
        var nillableDictionary = [String:Any?]()
        nillableDictionary["from"] = self.from
        nillableDictionary["subject"] = self.subject

        let dictionary: [String:Any] = APIHelper.rejectNil(nillableDictionary) ?? [:]
        return dictionary
    }
}
