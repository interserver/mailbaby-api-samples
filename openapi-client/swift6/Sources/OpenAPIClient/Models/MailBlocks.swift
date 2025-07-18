//
// MailBlocks.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation

/** The listing of blocked emails. */
public struct MailBlocks: Sendable, Codable, ParameterConvertible, Hashable {

    public var local: [MailBlockClickHouse]
    public var mbtrap: [MailBlockClickHouse]
    public var subject: [MailBlockRspamd]

    public init(local: [MailBlockClickHouse], mbtrap: [MailBlockClickHouse], subject: [MailBlockRspamd]) {
        self.local = local
        self.mbtrap = mbtrap
        self.subject = subject
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case local
        case mbtrap
        case subject
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(local, forKey: .local)
        try container.encode(mbtrap, forKey: .mbtrap)
        try container.encode(subject, forKey: .subject)
    }
}

