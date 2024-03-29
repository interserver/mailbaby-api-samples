//
// SendMailAdv.swift
//
// Generated by swagger-codegen
// https://github.com/swagger-api/swagger-codegen
//

import Foundation


/** Details for an Email */

public struct SendMailAdv: Codable {

    /** The subject or title of the email */
    public var subject: String
    /** The main email contents. */
    public var body: String
    public var from: EmailAddressTypes
    public var to: EmailAddressesTypes
    public var replyto: EmailAddressesTypes?
    public var cc: EmailAddressesTypes?
    public var bcc: EmailAddressesTypes?
    /** (optional) File attachments to include in the email.  The file contents must be base64 encoded! */
    public var attachments: [MailAttachment]?
    /** (optional)  ID of the Mail order within our system to use as the Mail Account. */
    public var _id: Int64?

    public init(subject: String, body: String, from: EmailAddressTypes, to: EmailAddressesTypes, replyto: EmailAddressesTypes? = nil, cc: EmailAddressesTypes? = nil, bcc: EmailAddressesTypes? = nil, attachments: [MailAttachment]? = nil, _id: Int64? = nil) {
        self.subject = subject
        self.body = body
        self.from = from
        self.to = to
        self.replyto = replyto
        self.cc = cc
        self.bcc = bcc
        self.attachments = attachments
        self._id = _id
    }

    public enum CodingKeys: String, CodingKey { 
        case subject
        case body
        case from
        case to
        case replyto
        case cc
        case bcc
        case attachments
        case _id = "id"
    }

}
