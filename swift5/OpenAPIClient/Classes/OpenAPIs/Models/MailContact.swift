//
// MailContact.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation

/** An Email Contact */
public struct MailContact: Codable {

    /** The email address */
    public var email: String
    /** Optional contact name */
    public var name: String?

    public init(email: String, name: String? = nil) {
        self.email = email
        self.name = name
    }

}