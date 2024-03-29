//
// InlineResponse200.swift
//
// Generated by swagger-codegen
// https://github.com/swagger-api/swagger-codegen
//

import Foundation


open class InlineResponse200: JSONEncodable {
    public var id: Int32?
    public var status: String?
    public var username: String?
    public var password: String?
    public var comment: String?

    public init() {}

    // MARK: JSONEncodable
    open func encodeToJSON() -> Any {
        var nillableDictionary = [String:Any?]()
        nillableDictionary["id"] = self.id?.encodeToJSON()
        nillableDictionary["status"] = self.status
        nillableDictionary["username"] = self.username
        nillableDictionary["password"] = self.password
        nillableDictionary["comment"] = self.comment

        let dictionary: [String:Any] = APIHelper.rejectNil(nillableDictionary) ?? [:]
        return dictionary
    }
}
