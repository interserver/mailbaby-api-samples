//
// ErrorMessage.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation

/** The resposne when an error occurs. */
public struct ErrorMessage: Sendable, Codable, ParameterConvertible, Hashable {

    /** The response code associated with the error. */
    public var code: Int
    /** The details or description of the error. */
    public var message: String

    public init(code: Int, message: String) {
        self.code = code
        self.message = message
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case code
        case message
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(code, forKey: .code)
        try container.encode(message, forKey: .message)
    }
}

