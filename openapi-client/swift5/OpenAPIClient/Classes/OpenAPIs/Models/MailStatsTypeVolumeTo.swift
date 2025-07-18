//
// MailStatsTypeVolumeTo.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation
#if canImport(AnyCodable)
import AnyCodable
#endif

public struct MailStatsTypeVolumeTo: Codable, JSONEncodable, Hashable {

    public var clientdomainCom: Int?
    public var usersiteNet: Int?
    public var salescompanyCom: Int?
    public var clientanothersiteCom: Int?

    public init(clientdomainCom: Int? = nil, usersiteNet: Int? = nil, salescompanyCom: Int? = nil, clientanothersiteCom: Int? = nil) {
        self.clientdomainCom = clientdomainCom
        self.usersiteNet = usersiteNet
        self.salescompanyCom = salescompanyCom
        self.clientanothersiteCom = clientanothersiteCom
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case clientdomainCom = "client@domain.com"
        case usersiteNet = "user@site.net"
        case salescompanyCom = "sales@company.com"
        case clientanothersiteCom = "client@anothersite.com"
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(clientdomainCom, forKey: .clientdomainCom)
        try container.encodeIfPresent(usersiteNet, forKey: .usersiteNet)
        try container.encodeIfPresent(salescompanyCom, forKey: .salescompanyCom)
        try container.encodeIfPresent(clientanothersiteCom, forKey: .clientanothersiteCom)
    }
}

