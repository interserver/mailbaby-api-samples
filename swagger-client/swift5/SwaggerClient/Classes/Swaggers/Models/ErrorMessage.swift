//
// ErrorMessage.swift
//
// Generated by swagger-codegen
// https://github.com/swagger-api/swagger-codegen
//

import Foundation


/** The resposne when an error occurs. */

public struct ErrorMessage: Codable {

    /** The response code associated with the error. */
    public var code: Int
    /** The details or description of the error. */
    public var message: String

    public init(code: Int, message: String) {
        self.code = code
        self.message = message
    }


}