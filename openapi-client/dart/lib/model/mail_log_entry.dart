//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.12

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
    required this.subject,
    required this.messageId,
    required this.created,
    required this.time,
    required this.user,
    required this.transtype,
    required this.transhost,
    required this.originhost,
    required this.origin,
    required this.interface_,
    required this.date,
    required this.sendingZone,
    required this.bodySize,
    required this.sourceMd5,
    required this.seq,
    required this.domain,
    required this.recipient,
    required this.locked,
    required this.lockTime,
    required this.assigned,
    required this.queued,
    required this.lock,
    required this.logger,
    required this.mxPort,
    required this.connectionKey,
    required this.mxHostname,
    required this.sentBodyHash,
    required this.sentBodySize,
    required this.md5Match,
  });

  /// internal db id
  int id;

  /// mail id
  String id;

  /// from address
  String from;

  /// to address
  String to;

  /// email subject
  String subject;

  /// message id
  String messageId;

  /// creation date
  String created;

  /// creation timestamp
  int time;

  /// user account
  String user;

  /// transaction type
  String transtype;

  /// transaction host
  String transhost;

  /// origin host
  String originhost;

  /// origin ip
  String origin;

  /// interface name
  String interface_;

  /// date processed
  String date;

  /// sending zone
  String sendingZone;

  /// email body size in bytes
  int bodySize;

  /// md5 sum of the email
  String sourceMd5;

  /// delivery sequency
  int seq;

  /// to address domain
  String domain;

  /// email receiver address
  String recipient;

  /// locked status
  int locked;

  /// lock timestamp
  int lockTime;

  /// assigned server
  String assigned;

  /// queued timestamp
  String queued;

  /// lock id
  String lock;

  /// logger
  String logger;

  /// mx port number
  int mxPort;

  /// connection key
  String connectionKey;

  /// mx hostname
  String mxHostname;

  /// body hash
  String sentBodyHash;

  /// sent body size in bytes
  int sentBodySize;

  /// md5 checksum matching result
  int md5Match;

  @override
  bool operator ==(Object other) => identical(this, other) || other is MailLogEntry &&
     other.id == id &&
     other.id == id &&
     other.from == from &&
     other.to == to &&
     other.subject == subject &&
     other.messageId == messageId &&
     other.created == created &&
     other.time == time &&
     other.user == user &&
     other.transtype == transtype &&
     other.transhost == transhost &&
     other.originhost == originhost &&
     other.origin == origin &&
     other.interface_ == interface_ &&
     other.date == date &&
     other.sendingZone == sendingZone &&
     other.bodySize == bodySize &&
     other.sourceMd5 == sourceMd5 &&
     other.seq == seq &&
     other.domain == domain &&
     other.recipient == recipient &&
     other.locked == locked &&
     other.lockTime == lockTime &&
     other.assigned == assigned &&
     other.queued == queued &&
     other.lock == lock &&
     other.logger == logger &&
     other.mxPort == mxPort &&
     other.connectionKey == connectionKey &&
     other.mxHostname == mxHostname &&
     other.sentBodyHash == sentBodyHash &&
     other.sentBodySize == sentBodySize &&
     other.md5Match == md5Match;

  @override
  int get hashCode =>
    // ignore: unnecessary_parenthesis
    (id.hashCode) +
    (id.hashCode) +
    (from.hashCode) +
    (to.hashCode) +
    (subject.hashCode) +
    (messageId.hashCode) +
    (created.hashCode) +
    (time.hashCode) +
    (user.hashCode) +
    (transtype.hashCode) +
    (transhost.hashCode) +
    (originhost.hashCode) +
    (origin.hashCode) +
    (interface_.hashCode) +
    (date.hashCode) +
    (sendingZone.hashCode) +
    (bodySize.hashCode) +
    (sourceMd5.hashCode) +
    (seq.hashCode) +
    (domain.hashCode) +
    (recipient.hashCode) +
    (locked.hashCode) +
    (lockTime.hashCode) +
    (assigned.hashCode) +
    (queued.hashCode) +
    (lock.hashCode) +
    (logger.hashCode) +
    (mxPort.hashCode) +
    (connectionKey.hashCode) +
    (mxHostname.hashCode) +
    (sentBodyHash.hashCode) +
    (sentBodySize.hashCode) +
    (md5Match.hashCode);

  @override
  String toString() => 'MailLogEntry[id=$id, id=$id, from=$from, to=$to, subject=$subject, messageId=$messageId, created=$created, time=$time, user=$user, transtype=$transtype, transhost=$transhost, originhost=$originhost, origin=$origin, interface_=$interface_, date=$date, sendingZone=$sendingZone, bodySize=$bodySize, sourceMd5=$sourceMd5, seq=$seq, domain=$domain, recipient=$recipient, locked=$locked, lockTime=$lockTime, assigned=$assigned, queued=$queued, lock=$lock, logger=$logger, mxPort=$mxPort, connectionKey=$connectionKey, mxHostname=$mxHostname, sentBodyHash=$sentBodyHash, sentBodySize=$sentBodySize, md5Match=$md5Match]';

  Map<String, dynamic> toJson() {
    final _json = <String, dynamic>{};
      _json[r'_id'] = id;
      _json[r'id'] = id;
      _json[r'from'] = from;
      _json[r'to'] = to;
      _json[r'subject'] = subject;
      _json[r'messageId'] = messageId;
      _json[r'created'] = created;
      _json[r'time'] = time;
      _json[r'user'] = user;
      _json[r'transtype'] = transtype;
      _json[r'transhost'] = transhost;
      _json[r'originhost'] = originhost;
      _json[r'origin'] = origin;
      _json[r'interface'] = interface_;
      _json[r'date'] = date;
      _json[r'sendingZone'] = sendingZone;
      _json[r'bodySize'] = bodySize;
      _json[r'sourceMd5'] = sourceMd5;
      _json[r'seq'] = seq;
      _json[r'domain'] = domain;
      _json[r'recipient'] = recipient;
      _json[r'locked'] = locked;
      _json[r'lockTime'] = lockTime;
      _json[r'assigned'] = assigned;
      _json[r'queued'] = queued;
      _json[r'_lock'] = lock;
      _json[r'logger'] = logger;
      _json[r'mxPort'] = mxPort;
      _json[r'connectionKey'] = connectionKey;
      _json[r'mxHostname'] = mxHostname;
      _json[r'sentBodyHash'] = sentBodyHash;
      _json[r'sentBodySize'] = sentBodySize;
      _json[r'md5Match'] = md5Match;
    return _json;
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
        subject: mapValueOfType<String>(json, r'subject')!,
        messageId: mapValueOfType<String>(json, r'messageId')!,
        created: mapValueOfType<String>(json, r'created')!,
        time: mapValueOfType<int>(json, r'time')!,
        user: mapValueOfType<String>(json, r'user')!,
        transtype: mapValueOfType<String>(json, r'transtype')!,
        transhost: mapValueOfType<String>(json, r'transhost')!,
        originhost: mapValueOfType<String>(json, r'originhost')!,
        origin: mapValueOfType<String>(json, r'origin')!,
        interface_: mapValueOfType<String>(json, r'interface')!,
        date: mapValueOfType<String>(json, r'date')!,
        sendingZone: mapValueOfType<String>(json, r'sendingZone')!,
        bodySize: mapValueOfType<int>(json, r'bodySize')!,
        sourceMd5: mapValueOfType<String>(json, r'sourceMd5')!,
        seq: mapValueOfType<int>(json, r'seq')!,
        domain: mapValueOfType<String>(json, r'domain')!,
        recipient: mapValueOfType<String>(json, r'recipient')!,
        locked: mapValueOfType<int>(json, r'locked')!,
        lockTime: mapValueOfType<int>(json, r'lockTime')!,
        assigned: mapValueOfType<String>(json, r'assigned')!,
        queued: mapValueOfType<String>(json, r'queued')!,
        lock: mapValueOfType<String>(json, r'_lock')!,
        logger: mapValueOfType<String>(json, r'logger')!,
        mxPort: mapValueOfType<int>(json, r'mxPort')!,
        connectionKey: mapValueOfType<String>(json, r'connectionKey')!,
        mxHostname: mapValueOfType<String>(json, r'mxHostname')!,
        sentBodyHash: mapValueOfType<String>(json, r'sentBodyHash')!,
        sentBodySize: mapValueOfType<int>(json, r'sentBodySize')!,
        md5Match: mapValueOfType<int>(json, r'md5Match')!,
      );
    }
    return null;
  }

  static List<MailLogEntry>? listFromJson(dynamic json, {bool growable = false,}) {
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
      json = json.cast<String, dynamic>(); // ignore: parameter_assignments
      for (final entry in json.entries) {
        final value = MailLogEntry.listFromJson(entry.value, growable: growable,);
        if (value != null) {
          map[entry.key] = value;
        }
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
    'subject',
    'messageId',
    'created',
    'time',
    'user',
    'transtype',
    'transhost',
    'originhost',
    'origin',
    'interface',
    'date',
    'sendingZone',
    'bodySize',
    'sourceMd5',
    'seq',
    'domain',
    'recipient',
    'locked',
    'lockTime',
    'assigned',
    'queued',
    '_lock',
    'logger',
    'mxPort',
    'connectionKey',
    'mxHostname',
    'sentBodyHash',
    'sentBodySize',
    'md5Match',
  };
}

