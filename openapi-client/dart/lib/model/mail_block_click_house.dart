//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.18

// ignore_for_file: unused_element, unused_import
// ignore_for_file: always_put_required_named_parameters_first
// ignore_for_file: constant_identifier_names
// ignore_for_file: lines_longer_than_80_chars

part of openapi.api;

class MailBlockClickHouse {
  /// Returns a new [MailBlockClickHouse] instance.
  MailBlockClickHouse({
    required this.date,
    required this.from,
    required this.subject,
    required this.to,
    this.messageId,
  });

  /// The date the block event was recorded.
  DateTime date;

  /// The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it.
  String from;

  /// The `Subject` header of the blocked message.
  String subject;

  /// The serialized list of recipients of the blocked message.
  String to;

  /// The `Message-ID` header of the blocked message, or `null` if not present.
  String? messageId;

  @override
  bool operator ==(Object other) => identical(this, other) || other is MailBlockClickHouse &&
    other.date == date &&
    other.from == from &&
    other.subject == subject &&
    other.to == to &&
    other.messageId == messageId;

  @override
  int get hashCode =>
    // ignore: unnecessary_parenthesis
    (date.hashCode) +
    (from.hashCode) +
    (subject.hashCode) +
    (to.hashCode) +
    (messageId == null ? 0 : messageId!.hashCode);

  @override
  String toString() => 'MailBlockClickHouse[date=$date, from=$from, subject=$subject, to=$to, messageId=$messageId]';

  Map<String, dynamic> toJson() {
    final json = <String, dynamic>{};
      json[r'date'] = _dateFormatter.format(this.date.toUtc());
      json[r'from'] = this.from;
      json[r'subject'] = this.subject;
      json[r'to'] = this.to;
    if (this.messageId != null) {
      json[r'messageId'] = this.messageId;
    } else {
      json[r'messageId'] = null;
    }
    return json;
  }

  /// Returns a new [MailBlockClickHouse] instance and imports its values from
  /// [value] if it's a [Map], null otherwise.
  // ignore: prefer_constructors_over_static_methods
  static MailBlockClickHouse? fromJson(dynamic value) {
    if (value is Map) {
      final json = value.cast<String, dynamic>();

      // Ensure that the map contains the required keys.
      // Note 1: the values aren't checked for validity beyond being non-null.
      // Note 2: this code is stripped in release mode!
      assert(() {
        requiredKeys.forEach((key) {
          assert(json.containsKey(key), 'Required key "MailBlockClickHouse[$key]" is missing from JSON.');
          assert(json[key] != null, 'Required key "MailBlockClickHouse[$key]" has a null value in JSON.');
        });
        return true;
      }());

      return MailBlockClickHouse(
        date: mapDateTime(json, r'date', r'')!,
        from: mapValueOfType<String>(json, r'from')!,
        subject: mapValueOfType<String>(json, r'subject')!,
        to: mapValueOfType<String>(json, r'to')!,
        messageId: mapValueOfType<String>(json, r'messageId'),
      );
    }
    return null;
  }

  static List<MailBlockClickHouse> listFromJson(dynamic json, {bool growable = false,}) {
    final result = <MailBlockClickHouse>[];
    if (json is List && json.isNotEmpty) {
      for (final row in json) {
        final value = MailBlockClickHouse.fromJson(row);
        if (value != null) {
          result.add(value);
        }
      }
    }
    return result.toList(growable: growable);
  }

  static Map<String, MailBlockClickHouse> mapFromJson(dynamic json) {
    final map = <String, MailBlockClickHouse>{};
    if (json is Map && json.isNotEmpty) {
      json = json.cast<String, dynamic>(); // ignore: parameter_assignments
      for (final entry in json.entries) {
        final value = MailBlockClickHouse.fromJson(entry.value);
        if (value != null) {
          map[entry.key] = value;
        }
      }
    }
    return map;
  }

  // maps a json object with a list of MailBlockClickHouse-objects as value to a dart map
  static Map<String, List<MailBlockClickHouse>> mapListFromJson(dynamic json, {bool growable = false,}) {
    final map = <String, List<MailBlockClickHouse>>{};
    if (json is Map && json.isNotEmpty) {
      // ignore: parameter_assignments
      json = json.cast<String, dynamic>();
      for (final entry in json.entries) {
        map[entry.key] = MailBlockClickHouse.listFromJson(entry.value, growable: growable,);
      }
    }
    return map;
  }

  /// The list of required keys that must be present in a JSON.
  static const requiredKeys = <String>{
    'date',
    'from',
    'subject',
    'to',
  };
}

