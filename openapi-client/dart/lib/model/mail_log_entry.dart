//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.18

// ignore_for_file: unused_element, unused_import
// ignore_for_file: always_put_required_named_parameters_first
// ignore_for_file: constant_identifier_names
// ignore_for_file: lines_longer_than_80_chars

part of openapi.api;

class MailLogEntry {
  /// Returns a new [MailLogEntry] instance.
  MailLogEntry({
    required this.id,
    required this.id,
    required this.from,
    required this.to,
    required this.created,
    required this.time,
    required this.user,
    required this.transtype,
    required this.origin,
    required this.interface_,
    this.subject,
    this.messageId,
    this.sendingZone,
    this.bodySize,
    this.seq,
    this.delivered,
    this.response,
    this.recipient,
    this.domain,
    this.locked,
    this.lockTime,
    this.assigned,
    this.queued,
    this.mxHostname,
  });

  /// Internal auto-increment database row ID.  Not meaningful outside the API.
  int id;

  /// The relay-assigned mail ID (18–19 hex characters).  This is the value returned as `text` by the sending endpoints and accepted as the `mailid` filter on `GET /mail/log`.
  String id;

  /// SMTP envelope `MAIL FROM` address (may differ from the `From:` header).
  String from;

  /// SMTP envelope `RCPT TO` address.
  String to;

  /// Human-readable creation timestamp in `YYYY-MM-DD HH:MM:SS` format.
  String created;

  /// Unix timestamp of message acceptance.  Corresponds to the `startDate` and `endDate` filter parameters on `GET /mail/log`.
  int time;

  /// The SMTP AUTH username used to submit the message (e.g. `mb5658`). Corresponds to the `username` field in `GET /mail` orders.
  String user;

  /// SMTP transaction type negotiated with the relay (e.g. `ESMTPSA`).
  String transtype;

  /// IP address of the client that submitted the message to the relay. Corresponds to the `origin` filter parameter on `GET /mail/log`.
  String origin;

  /// Relay interface name that accepted the message (e.g. `feeder`).
  String interface_;

  /// The `Subject` header value, if available.
  String? subject;

  /// The `Message-ID` header value, if present.  Can be used with the `messageId` filter on `GET /mail/log` for subsequent lookups.
  String? messageId;

  /// The sending zone assigned by the relay for outbound delivery.
  String? sendingZone;

  /// Size of the message body in bytes.
  int? bodySize;

  /// Sequence index of this recipient in a multi-recipient message. Starts at 1.
  int? seq;

  /// Delivery status flag.  `1` = successfully delivered to destination MX. `0` = queued, deferred, or failed.  `null` = delivery not yet attempted. Corresponds to the `delivered` filter parameter on `GET /mail/log`.
  int? delivered;

  /// The SMTP response string received from the destination MX server upon delivery attempt (e.g. `\"250 2.0.0 Ok queued as C91D83E128C\"`).
  String? response;

  /// The specific recipient address this delivery record is for.
  String? recipient;

  /// The destination domain.  Corresponds to the `mx` filter parameter (which matches `mxHostname`, not `domain`) on `GET /mail/log`.
  String? domain;

  /// Whether the queue entry is currently locked for delivery processing.
  int? locked;

  /// Millisecond-precision timestamp of the last queue lock acquisition.
  String? lockTime;

  /// The relay server node assigned to deliver this message.
  String? assigned;

  /// ISO 8601 timestamp when the message was placed into the delivery queue.
  String? queued;

  /// The MX hostname the relay connected to for delivery.  Corresponds to the `mx` filter parameter on `GET /mail/log`.
  String? mxHostname;

  @override
  bool operator ==(Object other) => identical(this, other) || other is MailLogEntry &&
    other.id == id &&
    other.id == id &&
    other.from == from &&
    other.to == to &&
    other.created == created &&
    other.time == time &&
    other.user == user &&
    other.transtype == transtype &&
    other.origin == origin &&
    other.interface_ == interface_ &&
    other.subject == subject &&
    other.messageId == messageId &&
    other.sendingZone == sendingZone &&
    other.bodySize == bodySize &&
    other.seq == seq &&
    other.delivered == delivered &&
    other.response == response &&
    other.recipient == recipient &&
    other.domain == domain &&
    other.locked == locked &&
    other.lockTime == lockTime &&
    other.assigned == assigned &&
    other.queued == queued &&
    other.mxHostname == mxHostname;

  @override
  int get hashCode =>
    // ignore: unnecessary_parenthesis
    (id.hashCode) +
    (id.hashCode) +
    (from.hashCode) +
    (to.hashCode) +
    (created.hashCode) +
    (time.hashCode) +
    (user.hashCode) +
    (transtype.hashCode) +
    (origin.hashCode) +
    (interface_.hashCode) +
    (subject == null ? 0 : subject!.hashCode) +
    (messageId == null ? 0 : messageId!.hashCode) +
    (sendingZone == null ? 0 : sendingZone!.hashCode) +
    (bodySize == null ? 0 : bodySize!.hashCode) +
    (seq == null ? 0 : seq!.hashCode) +
    (delivered == null ? 0 : delivered!.hashCode) +
    (response == null ? 0 : response!.hashCode) +
    (recipient == null ? 0 : recipient!.hashCode) +
    (domain == null ? 0 : domain!.hashCode) +
    (locked == null ? 0 : locked!.hashCode) +
    (lockTime == null ? 0 : lockTime!.hashCode) +
    (assigned == null ? 0 : assigned!.hashCode) +
    (queued == null ? 0 : queued!.hashCode) +
    (mxHostname == null ? 0 : mxHostname!.hashCode);

  @override
  String toString() => 'MailLogEntry[id=$id, id=$id, from=$from, to=$to, created=$created, time=$time, user=$user, transtype=$transtype, origin=$origin, interface_=$interface_, subject=$subject, messageId=$messageId, sendingZone=$sendingZone, bodySize=$bodySize, seq=$seq, delivered=$delivered, response=$response, recipient=$recipient, domain=$domain, locked=$locked, lockTime=$lockTime, assigned=$assigned, queued=$queued, mxHostname=$mxHostname]';

  Map<String, dynamic> toJson() {
    final json = <String, dynamic>{};
      json[r'_id'] = this.id;
      json[r'id'] = this.id;
      json[r'from'] = this.from;
      json[r'to'] = this.to;
      json[r'created'] = this.created;
      json[r'time'] = this.time;
      json[r'user'] = this.user;
      json[r'transtype'] = this.transtype;
      json[r'origin'] = this.origin;
      json[r'interface'] = this.interface_;
    if (this.subject != null) {
      json[r'subject'] = this.subject;
    } else {
      json[r'subject'] = null;
    }
    if (this.messageId != null) {
      json[r'messageId'] = this.messageId;
    } else {
      json[r'messageId'] = null;
    }
    if (this.sendingZone != null) {
      json[r'sendingZone'] = this.sendingZone;
    } else {
      json[r'sendingZone'] = null;
    }
    if (this.bodySize != null) {
      json[r'bodySize'] = this.bodySize;
    } else {
      json[r'bodySize'] = null;
    }
    if (this.seq != null) {
      json[r'seq'] = this.seq;
    } else {
      json[r'seq'] = null;
    }
    if (this.delivered != null) {
      json[r'delivered'] = this.delivered;
    } else {
      json[r'delivered'] = null;
    }
    if (this.response != null) {
      json[r'response'] = this.response;
    } else {
      json[r'response'] = null;
    }
    if (this.recipient != null) {
      json[r'recipient'] = this.recipient;
    } else {
      json[r'recipient'] = null;
    }
    if (this.domain != null) {
      json[r'domain'] = this.domain;
    } else {
      json[r'domain'] = null;
    }
    if (this.locked != null) {
      json[r'locked'] = this.locked;
    } else {
      json[r'locked'] = null;
    }
    if (this.lockTime != null) {
      json[r'lockTime'] = this.lockTime;
    } else {
      json[r'lockTime'] = null;
    }
    if (this.assigned != null) {
      json[r'assigned'] = this.assigned;
    } else {
      json[r'assigned'] = null;
    }
    if (this.queued != null) {
      json[r'queued'] = this.queued;
    } else {
      json[r'queued'] = null;
    }
    if (this.mxHostname != null) {
      json[r'mxHostname'] = this.mxHostname;
    } else {
      json[r'mxHostname'] = null;
    }
    return json;
  }

  /// Returns a new [MailLogEntry] instance and imports its values from
  /// [value] if it's a [Map], null otherwise.
  // ignore: prefer_constructors_over_static_methods
  static MailLogEntry? fromJson(dynamic value) {
    if (value is Map) {
      final json = value.cast<String, dynamic>();

      // Ensure that the map contains the required keys.
      // Note 1: the values aren't checked for validity beyond being non-null.
      // Note 2: this code is stripped in release mode!
      assert(() {
        requiredKeys.forEach((key) {
          assert(json.containsKey(key), 'Required key "MailLogEntry[$key]" is missing from JSON.');
          assert(json[key] != null, 'Required key "MailLogEntry[$key]" has a null value in JSON.');
        });
        return true;
      }());

      return MailLogEntry(
        id: mapValueOfType<int>(json, r'_id')!,
        id: mapValueOfType<String>(json, r'id')!,
        from: mapValueOfType<String>(json, r'from')!,
        to: mapValueOfType<String>(json, r'to')!,
        created: mapValueOfType<String>(json, r'created')!,
        time: mapValueOfType<int>(json, r'time')!,
        user: mapValueOfType<String>(json, r'user')!,
        transtype: mapValueOfType<String>(json, r'transtype')!,
        origin: mapValueOfType<String>(json, r'origin')!,
        interface_: mapValueOfType<String>(json, r'interface')!,
        subject: mapValueOfType<String>(json, r'subject'),
        messageId: mapValueOfType<String>(json, r'messageId'),
        sendingZone: mapValueOfType<String>(json, r'sendingZone'),
        bodySize: mapValueOfType<int>(json, r'bodySize'),
        seq: mapValueOfType<int>(json, r'seq'),
        delivered: mapValueOfType<int>(json, r'delivered'),
        response: mapValueOfType<String>(json, r'response'),
        recipient: mapValueOfType<String>(json, r'recipient'),
        domain: mapValueOfType<String>(json, r'domain'),
        locked: mapValueOfType<int>(json, r'locked'),
        lockTime: mapValueOfType<String>(json, r'lockTime'),
        assigned: mapValueOfType<String>(json, r'assigned'),
        queued: mapValueOfType<String>(json, r'queued'),
        mxHostname: mapValueOfType<String>(json, r'mxHostname'),
      );
    }
    return null;
  }

  static List<MailLogEntry> listFromJson(dynamic json, {bool growable = false,}) {
    final result = <MailLogEntry>[];
    if (json is List && json.isNotEmpty) {
      for (final row in json) {
        final value = MailLogEntry.fromJson(row);
        if (value != null) {
          result.add(value);
        }
      }
    }
    return result.toList(growable: growable);
  }

  static Map<String, MailLogEntry> mapFromJson(dynamic json) {
    final map = <String, MailLogEntry>{};
    if (json is Map && json.isNotEmpty) {
      json = json.cast<String, dynamic>(); // ignore: parameter_assignments
      for (final entry in json.entries) {
        final value = MailLogEntry.fromJson(entry.value);
        if (value != null) {
          map[entry.key] = value;
        }
      }
    }
    return map;
  }

  // maps a json object with a list of MailLogEntry-objects as value to a dart map
  static Map<String, List<MailLogEntry>> mapListFromJson(dynamic json, {bool growable = false,}) {
    final map = <String, List<MailLogEntry>>{};
    if (json is Map && json.isNotEmpty) {
      // ignore: parameter_assignments
      json = json.cast<String, dynamic>();
      for (final entry in json.entries) {
        map[entry.key] = MailLogEntry.listFromJson(entry.value, growable: growable,);
      }
    }
    return map;
  }

  /// The list of required keys that must be present in a JSON.
  static const requiredKeys = <String>{
    '_id',
    'id',
    'from',
    'to',
    'created',
    'time',
    'user',
    'transtype',
    'origin',
    'interface',
  };
}

