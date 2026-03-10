//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.18

// ignore_for_file: unused_element, unused_import
// ignore_for_file: always_put_required_named_parameters_first
// ignore_for_file: constant_identifier_names
// ignore_for_file: lines_longer_than_80_chars

part of openapi.api;

class MailStatsTypeVolume {
  /// Returns a new [MailStatsTypeVolume] instance.
  MailStatsTypeVolume({
    this.to = const {},
    this.from = const {},
    this.ip = const {},
  });

  /// Message counts keyed by destination (envelope `to`) email address.
  Map<String, int> to;

  /// Message counts keyed by sender (envelope `from`) email address.
  Map<String, int> from;

  /// Message counts keyed by originating client IP address.
  Map<String, int> ip;

  @override
  bool operator ==(Object other) => identical(this, other) || other is MailStatsTypeVolume &&
    _deepEquality.equals(other.to, to) &&
    _deepEquality.equals(other.from, from) &&
    _deepEquality.equals(other.ip, ip);

  @override
  int get hashCode =>
    // ignore: unnecessary_parenthesis
    (to.hashCode) +
    (from.hashCode) +
    (ip.hashCode);

  @override
  String toString() => 'MailStatsTypeVolume[to=$to, from=$from, ip=$ip]';

  Map<String, dynamic> toJson() {
    final json = <String, dynamic>{};
      json[r'to'] = this.to;
      json[r'from'] = this.from;
      json[r'ip'] = this.ip;
    return json;
  }

  /// Returns a new [MailStatsTypeVolume] instance and imports its values from
  /// [value] if it's a [Map], null otherwise.
  // ignore: prefer_constructors_over_static_methods
  static MailStatsTypeVolume? fromJson(dynamic value) {
    if (value is Map) {
      final json = value.cast<String, dynamic>();

      // Ensure that the map contains the required keys.
      // Note 1: the values aren't checked for validity beyond being non-null.
      // Note 2: this code is stripped in release mode!
      assert(() {
        requiredKeys.forEach((key) {
          assert(json.containsKey(key), 'Required key "MailStatsTypeVolume[$key]" is missing from JSON.');
          assert(json[key] != null, 'Required key "MailStatsTypeVolume[$key]" has a null value in JSON.');
        });
        return true;
      }());

      return MailStatsTypeVolume(
        to: mapCastOfType<String, int>(json, r'to') ?? const {},
        from: mapCastOfType<String, int>(json, r'from') ?? const {},
        ip: mapCastOfType<String, int>(json, r'ip') ?? const {},
      );
    }
    return null;
  }

  static List<MailStatsTypeVolume> listFromJson(dynamic json, {bool growable = false,}) {
    final result = <MailStatsTypeVolume>[];
    if (json is List && json.isNotEmpty) {
      for (final row in json) {
        final value = MailStatsTypeVolume.fromJson(row);
        if (value != null) {
          result.add(value);
        }
      }
    }
    return result.toList(growable: growable);
  }

  static Map<String, MailStatsTypeVolume> mapFromJson(dynamic json) {
    final map = <String, MailStatsTypeVolume>{};
    if (json is Map && json.isNotEmpty) {
      json = json.cast<String, dynamic>(); // ignore: parameter_assignments
      for (final entry in json.entries) {
        final value = MailStatsTypeVolume.fromJson(entry.value);
        if (value != null) {
          map[entry.key] = value;
        }
      }
    }
    return map;
  }

  // maps a json object with a list of MailStatsTypeVolume-objects as value to a dart map
  static Map<String, List<MailStatsTypeVolume>> mapListFromJson(dynamic json, {bool growable = false,}) {
    final map = <String, List<MailStatsTypeVolume>>{};
    if (json is Map && json.isNotEmpty) {
      // ignore: parameter_assignments
      json = json.cast<String, dynamic>();
      for (final entry in json.entries) {
        map[entry.key] = MailStatsTypeVolume.listFromJson(entry.value, growable: growable,);
      }
    }
    return map;
  }

  /// The list of required keys that must be present in a JSON.
  static const requiredKeys = <String>{
  };
}

