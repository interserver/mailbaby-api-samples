//
// MailStatsTypeVolumeFrom.swift
//
// Generated by swagger-codegen
// https://github.com/swagger-api/swagger-codegen
//

import Foundation


open class MailStatsTypeVolumeFrom: JSONEncodable {
    public var billingsomedomainCom: Int32?
    public var salessomedomainCom: Int32?

    public init() {}

    // MARK: JSONEncodable
    open func encodeToJSON() -> Any {
        var nillableDictionary = [String:Any?]()
        nillableDictionary["billing@somedomain.com"] = self.billingsomedomainCom?.encodeToJSON()
        nillableDictionary["sales@somedomain.com"] = self.salessomedomainCom?.encodeToJSON()

        let dictionary: [String:Any] = APIHelper.rejectNil(nillableDictionary) ?? [:]
        return dictionary
    }
}
