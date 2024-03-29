//
// MailLogEntry.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation

/// An email record 
public struct MailLogEntry: Codable {
    /// internal db id
    public var id: Int
    /// mail id
    public var id: String
    /// from address
    public var from: String
    /// to address
    public var to: String
    /// email subject
    public var subject: String
    /// creation date
    public var created: String
    /// creation timestamp
    public var time: Int
    /// user account
    public var user: String
    /// transaction type
    public var transtype: String
    /// origin ip
    public var origin: String
    /// interface name
    public var interface: String
    /// sending zone
    public var sendingZone: String
    /// email body size in bytes
    public var bodySize: Int
    /// index of email in the to adderess list
    public var seq: Int
    /// to address this email is being sent to
    public var recipient: String
    /// to address domain
    public var domain: String
    /// locked status
    public var locked: Int
    /// lock timestamp
    public var lockTime: String
    /// assigned server
    public var assigned: String
    /// queued timestamp
    public var queued: String
    /// mx hostname
    public var mxHostname: String
    /// mail delivery response
    public var response: String
    /// message id
    public var messageId: String?

    public init(id: Int, id: String, from: String, to: String, subject: String, created: String, time: Int, user: String, transtype: String, origin: String, interface: String, sendingZone: String, bodySize: Int, seq: Int, recipient: String, domain: String, locked: Int, lockTime: String, assigned: String, queued: String, mxHostname: String, response: String, messageId: String? = nil) {
        self.id = id
        self.id = id
        self.from = from
        self.to = to
        self.subject = subject
        self.created = created
        self.time = time
        self.user = user
        self.transtype = transtype
        self.origin = origin
        self.interface = interface
        self.sendingZone = sendingZone
        self.bodySize = bodySize
        self.seq = seq
        self.recipient = recipient
        self.domain = domain
        self.locked = locked
        self.lockTime = lockTime
        self.assigned = assigned
        self.queued = queued
        self.mxHostname = mxHostname
        self.response = response
        self.messageId = messageId
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case id = "_id"
        case id
        case from
        case to
        case subject
        case created
        case time
        case user
        case transtype
        case origin
        case interface
        case sendingZone
        case bodySize
        case seq
        case recipient
        case domain
        case locked
        case lockTime
        case assigned
        case queued
        case mxHostname
        case response
        case messageId
    }

    public init(from decoder: Decoder) throws {
        let container = try decoder.container(keyedBy: CodingKeys.self)
        id = try container.decode(Int.self, forKey: .id)
        id = try container.decode(String.self, forKey: .id)
        from = try container.decode(String.self, forKey: .from)
        to = try container.decode(String.self, forKey: .to)
        subject = try container.decode(String.self, forKey: .subject)
        created = try container.decode(String.self, forKey: .created)
        time = try container.decode(Int.self, forKey: .time)
        user = try container.decode(String.self, forKey: .user)
        transtype = try container.decode(String.self, forKey: .transtype)
        origin = try container.decode(String.self, forKey: .origin)
        interface = try container.decode(String.self, forKey: .interface)
        sendingZone = try container.decode(String.self, forKey: .sendingZone)
        bodySize = try container.decode(Int.self, forKey: .bodySize)
        seq = try container.decode(Int.self, forKey: .seq)
        recipient = try container.decode(String.self, forKey: .recipient)
        domain = try container.decode(String.self, forKey: .domain)
        locked = try container.decode(Int.self, forKey: .locked)
        lockTime = try container.decode(String.self, forKey: .lockTime)
        assigned = try container.decode(String.self, forKey: .assigned)
        queued = try container.decode(String.self, forKey: .queued)
        mxHostname = try container.decode(String.self, forKey: .mxHostname)
        response = try container.decode(String.self, forKey: .response)
        messageId = try container.decodeIfPresent(String.self, forKey: .messageId)
    }

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(id, forKey: .id)
        try container.encode(id, forKey: .id)
        try container.encode(from, forKey: .from)
        try container.encode(to, forKey: .to)
        try container.encode(subject, forKey: .subject)
        try container.encode(created, forKey: .created)
        try container.encode(time, forKey: .time)
        try container.encode(user, forKey: .user)
        try container.encode(transtype, forKey: .transtype)
        try container.encode(origin, forKey: .origin)
        try container.encode(interface, forKey: .interface)
        try container.encode(sendingZone, forKey: .sendingZone)
        try container.encode(bodySize, forKey: .bodySize)
        try container.encode(seq, forKey: .seq)
        try container.encode(recipient, forKey: .recipient)
        try container.encode(domain, forKey: .domain)
        try container.encode(locked, forKey: .locked)
        try container.encode(lockTime, forKey: .lockTime)
        try container.encode(assigned, forKey: .assigned)
        try container.encode(queued, forKey: .queued)
        try container.encode(mxHostname, forKey: .mxHostname)
        try container.encode(response, forKey: .response)
        try container.encodeIfPresent(messageId, forKey: .messageId)
    }
}
