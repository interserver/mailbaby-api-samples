//
// GenericResponse.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation

public struct GenericResponse: Codable {
    public var status: String?
    public var text: String?

    public init(status: String? = nil, text: String? = nil) {
        self.status = status
        self.text = text
    }
}