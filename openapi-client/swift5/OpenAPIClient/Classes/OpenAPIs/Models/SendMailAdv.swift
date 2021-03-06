//
// SendMailAdv.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation
#if canImport(AnyCodable)
import AnyCodable
#endif

/** Details for an Email */
public struct SendMailAdv: Codable, JSONEncodable, Hashable {

    /** The subject or title of the email */
    public var subject: String
    /** The main email contents. */
    public var body: String
    public var from: SendMailAdvFrom
    /** A list of destionation email addresses to send this to */
    public var to: [SendMailAdvToInner]
    /** (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address. */
    public var replyto: [SendMailAdvReplytoInner]?
    /** (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. */
    public var cc: [SendMailAdvCcInner]?
    /** (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. */
    public var bcc: [SendMailAdvBccInner]?
    /** (optional) File attachments to include in the email.  The file contents must be base64 encoded! */
    public var attachments: [SendMailAdvAttachmentsInner]?
    /** (optional)  ID of the Mail order within our system to use as the Mail Account. */
    public var id: Int64?

    public init(subject: String, body: String, from: SendMailAdvFrom, to: [SendMailAdvToInner], replyto: [SendMailAdvReplytoInner]? = nil, cc: [SendMailAdvCcInner]? = nil, bcc: [SendMailAdvBccInner]? = nil, attachments: [SendMailAdvAttachmentsInner]? = nil, id: Int64? = nil) {
        self.subject = subject
        self.body = body
        self.from = from
        self.to = to
        self.replyto = replyto
        self.cc = cc
        self.bcc = bcc
        self.attachments = attachments
        self.id = id
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case subject
        case body
        case from
        case to
        case replyto
        case cc
        case bcc
        case attachments
        case id
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(subject, forKey: .subject)
        try container.encode(body, forKey: .body)
        try container.encode(from, forKey: .from)
        try container.encode(to, forKey: .to)
        try container.encodeIfPresent(replyto, forKey: .replyto)
        try container.encodeIfPresent(cc, forKey: .cc)
        try container.encodeIfPresent(bcc, forKey: .bcc)
        try container.encodeIfPresent(attachments, forKey: .attachments)
        try container.encodeIfPresent(id, forKey: .id)
    }
}

