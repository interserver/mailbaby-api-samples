//
// EmailAddressesTypes.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation

/**  */
public enum EmailAddressesTypes: Sendable, Codable, ParameterConvertible, Hashable {
    case typeString(String)
    case typeArrayOfEmailAddressName([EmailAddressName])

    public func encode(to encoder: Encoder) throws {
        var container = encoder.singleValueContainer()
        switch self {
        case .typeString(let value):
            try container.encode(value)
        case .typeArrayOfEmailAddressName(let value):
            try container.encode(value)
        }
    }

    public init(from decoder: Decoder) throws {
        let container = try decoder.singleValueContainer()
        if let value = try? container.decode(String.self) {
            self = .typeString(value)
        } else if let value = try? container.decode([EmailAddressName].self) {
            self = .typeArrayOfEmailAddressName(value)
        } else {
            throw DecodingError.typeMismatch(Self.Type.self, .init(codingPath: decoder.codingPath, debugDescription: "Unable to decode instance of EmailAddressesTypes"))
        }
    }
}

