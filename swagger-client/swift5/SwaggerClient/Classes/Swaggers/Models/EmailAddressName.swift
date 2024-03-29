//
// EmailAddressName.swift
//
// Generated by swagger-codegen
// https://github.com/swagger-api/swagger-codegen
//

import Foundation


/** An email contact. */

public struct EmailAddressName: Codable {

    /** The email address. */
    public var email: String
    /** Name to use for the sending contact. */
    public var name: String?

    public init(email: String, name: String? = nil) {
        self.email = email
        self.name = name
    }


}
