//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.18

// ignore_for_file: unused_element, unused_import
// ignore_for_file: always_put_required_named_parameters_first
// ignore_for_file: constant_identifier_names
// ignore_for_file: lines_longer_than_80_chars

part of openapi.api;

class DateOrTimestamp {
  /// Returns a new [DateOrTimestamp] instance.
  DateOrTimestamp({
  });

  @override
  bool operator ==(Object other) => identical(this, other) || other is DateOrTimestamp &&

  @override
  int get hashCode =>
    // ignore: unnecessary_parenthesis

  @override
  String toString() => 'DateOrTimestamp[]';

  Map<String, dynamic> toJson() {
    final json = <String, dynamic>{};
    return json;
  }

  /// Returns a new [DateOrTimestamp] instance and imports its values from
  /// [value] if it's a [Map], null otherwise.
  // ignore: prefer_constructors_over_static_methods
  static DateOrTimestamp? fromJson(dynamic value) {
    if (value is Map) {
      final json = value.cast<String, dynamic>();

      // Ensure that the map contains the required keys.
      // Note 1: the values aren't checked for validity beyond being non-null.
      // Note 2: this code is stripped in release mode!
      assert(() {
        return true;
      }());

      return DateOrTimestamp(
      );
    }
    return null;
  }

  static List<DateOrTimestamp> listFromJson(dynamic json, {bool growable = false,}) {
    final result = <DateOrTimestamp>[];
    if (json is List && json.isNotEmpty) {
      for (final row in json) {
        final value = DateOrTimestamp.fromJson(row);
        if (value != null) {
          result.add(value);
        }
      }
    }
    return result.toList(growable: growable);
  }

  static Map<String, DateOrTimestamp> mapFromJson(dynamic json) {
    final map = <String, DateOrTimestamp>{};
    if (json is Map && json.isNotEmpty) {
      json = json.cast<String, dynamic>(); // ignore: parameter_assignments
      for (final entry in json.entries) {
        final value = DateOrTimestamp.fromJson(entry.value);
        if (value != null) {
          map[entry.key] = value;
        }
      }
    }
    return map;
  }

  // maps a json object with a list of DateOrTimestamp-objects as value to a dart map
  static Map<String, List<DateOrTimestamp>> mapListFromJson(dynamic json, {bool growable = false,}) {
    final map = <String, List<DateOrTimestamp>>{};
    if (json is Map && json.isNotEmpty) {
      // ignore: parameter_assignments
      json = json.cast<String, dynamic>();
      for (final entry in json.entries) {
        map[entry.key] = DateOrTimestamp.listFromJson(entry.value, growable: growable,);
      }
    }
    return map;
  }

  /// The list of required keys that must be present in a JSON.
  static const requiredKeys = <String>{
  };
}

