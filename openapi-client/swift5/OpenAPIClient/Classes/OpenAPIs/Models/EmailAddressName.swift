//
// EmailAddressName.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation
#if canImport(AnyCodable)
import AnyCodable
#endif

/** An email contact. */
public struct EmailAddressName: Codable, JSONEncodable, Hashable {

    /** The email address. */
    public var email: String
    /** Name to use for the sending contact. */
    public var name: String?

    public init(email: String, name: String? = nil) {
        self.email = email
        self.name = name
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case email
        case name
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(email, forKey: .email)
        try container.encodeIfPresent(name, forKey: .name)
    }
}
