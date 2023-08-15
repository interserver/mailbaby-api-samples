//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.12

// ignore_for_file: unused_element, unused_import
// ignore_for_file: always_put_required_named_parameters_first
// ignore_for_file: constant_identifier_names
// ignore_for_file: lines_longer_than_80_chars

part of openapi.api;

class MailLog {
  /// Returns a new [MailLog] instance.
  MailLog({
    required this.total,
    required this.skip,
    required this.limit,
    this.emails = const [],
  });

  /// total number of mail log entries
  int total;

  /// number of emails skipped in listing
  int skip;

  /// number of emails to return
  int limit;

  List<MailLogEntry> emails;

  @override
  bool operator ==(Object other) => identical(this, other) || other is MailLog &&
     other.total == total &&
     other.skip == skip &&
     other.limit == limit &&
     other.emails == emails;

  @override
  int get hashCode =>
    // ignore: unnecessary_parenthesis
    (total.hashCode) +
    (skip.hashCode) +
    (limit.hashCode) +
    (emails.hashCode);

  @override
  String toString() => 'MailLog[total=$total, skip=$skip, limit=$limit, emails=$emails]';

  Map<String, dynamic> toJson() {
    final json = <String, dynamic>{};
      json[r'total'] = this.total;
      json[r'skip'] = this.skip;
      json[r'limit'] = this.limit;
      json[r'emails'] = this.emails;
    return json;
  }

  /// Returns a new [MailLog] instance and imports its values from
  /// [value] if it's a [Map], null otherwise.
  // ignore: prefer_constructors_over_static_methods
  static MailLog? fromJson(dynamic value) {
    if (value is Map) {
      final json = value.cast<String, dynamic>();

      // Ensure that the map contains the required keys.
      // Note 1: the values aren't checked for validity beyond being non-null.
      // Note 2: this code is stripped in release mode!
      assert(() {
        requiredKeys.forEach((key) {
          assert(json.containsKey(key), 'Required key "MailLog[$key]" is missing from JSON.');
          assert(json[key] != null, 'Required key "MailLog[$key]" has a null value in JSON.');
        });
        return true;
      }());

      return MailLog(
        total: mapValueOfType<int>(json, r'total')!,
        skip: mapValueOfType<int>(json, r'skip')!,
        limit: mapValueOfType<int>(json, r'limit')!,
        emails: MailLogEntry.listFromJson(json[r'emails']),
      );
    }
    return null;
  }

  static List<MailLog> listFromJson(dynamic json, {bool growable = false,}) {
    final result = <MailLog>[];
    if (json is List && json.isNotEmpty) {
      for (final row in json) {
        final value = MailLog.fromJson(row);
        if (value != null) {
          result.add(value);
        }
      }
    }
    return result.toList(growable: growable);
  }

  static Map<String, MailLog> mapFromJson(dynamic json) {
    final map = <String, MailLog>{};
    if (json is Map && json.isNotEmpty) {
      json = json.cast<String, dynamic>(); // ignore: parameter_assignments
      for (final entry in json.entries) {
        final value = MailLog.fromJson(entry.value);
        if (value != null) {
          map[entry.key] = value;
        }
      }
    }
    return map;
  }

  // maps a json object with a list of MailLog-objects as value to a dart map
  static Map<String, List<MailLog>> mapListFromJson(dynamic json, {bool growable = false,}) {
    final map = <String, List<MailLog>>{};
    if (json is Map && json.isNotEmpty) {
      // ignore: parameter_assignments
      json = json.cast<String, dynamic>();
      for (final entry in json.entries) {
        map[entry.key] = MailLog.listFromJson(entry.value, growable: growable,);
      }
    }
    return map;
  }

  /// The list of required keys that must be present in a JSON.
  static const requiredKeys = <String>{
    'total',
    'skip',
    'limit',
    'emails',
  };
}

