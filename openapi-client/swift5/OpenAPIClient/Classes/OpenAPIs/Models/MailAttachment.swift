//
// MailAttachment.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation

/** A File attachment for an email */
public struct MailAttachment: Codable {

    /** Contents of the attached file */
    public var data: URL
    /** Optional filename to specify for the attachment. */
    public var filename: String?

    public init(data: URL, filename: String? = nil) {
        self.data = data
        self.filename = filename
    }

}