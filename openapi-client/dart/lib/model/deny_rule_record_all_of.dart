//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.12

// ignore_for_file: unused_element, unused_import
// ignore_for_file: always_put_required_named_parameters_first
// ignore_for_file: constant_identifier_names
// ignore_for_file: lines_longer_than_80_chars

part of openapi.api;

class DenyRuleRecordAllOf {
  /// Returns a new [DenyRuleRecordAllOf] instance.
  DenyRuleRecordAllOf({
    required this.id,
    required this.created,
  });

  /// The deny rule Id number.
  int id;

  /// the date the rule was created.
  DateTime created;

  @override
  bool operator ==(Object other) => identical(this, other) || other is DenyRuleRecordAllOf &&
     other.id == id &&
     other.created == created;

  @override
  int get hashCode =>
    // ignore: unnecessary_parenthesis
    (id.hashCode) +
    (created.hashCode);

  @override
  String toString() => 'DenyRuleRecordAllOf[id=$id, created=$created]';

  Map<String, dynamic> toJson() {
    final json = <String, dynamic>{};
      json[r'id'] = this.id;
      json[r'created'] = this.created.toUtc().toIso8601String();
    return json;
  }

  /// Returns a new [DenyRuleRecordAllOf] instance and imports its values from
  /// [value] if it's a [Map], null otherwise.
  // ignore: prefer_constructors_over_static_methods
  static DenyRuleRecordAllOf? fromJson(dynamic value) {
    if (value is Map) {
      final json = value.cast<String, dynamic>();

      // Ensure that the map contains the required keys.
      // Note 1: the values aren't checked for validity beyond being non-null.
      // Note 2: this code is stripped in release mode!
      assert(() {
        requiredKeys.forEach((key) {
          assert(json.containsKey(key), 'Required key "DenyRuleRecordAllOf[$key]" is missing from JSON.');
          assert(json[key] != null, 'Required key "DenyRuleRecordAllOf[$key]" has a null value in JSON.');
        });
        return true;
      }());

      return DenyRuleRecordAllOf(
        id: mapValueOfType<int>(json, r'id')!,
        created: mapDateTime(json, r'created', '')!,
      );
    }
    return null;
  }

  static List<DenyRuleRecordAllOf> listFromJson(dynamic json, {bool growable = false,}) {
    final result = <DenyRuleRecordAllOf>[];
    if (json is List && json.isNotEmpty) {
      for (final row in json) {
        final value = DenyRuleRecordAllOf.fromJson(row);
        if (value != null) {
          result.add(value);
        }
      }
    }
    return result.toList(growable: growable);
  }

  static Map<String, DenyRuleRecordAllOf> mapFromJson(dynamic json) {
    final map = <String, DenyRuleRecordAllOf>{};
    if (json is Map && json.isNotEmpty) {
      json = json.cast<String, dynamic>(); // ignore: parameter_assignments
      for (final entry in json.entries) {
        final value = DenyRuleRecordAllOf.fromJson(entry.value);
        if (value != null) {
          map[entry.key] = value;
        }
      }
    }
    return map;
  }

  // maps a json object with a list of DenyRuleRecordAllOf-objects as value to a dart map
  static Map<String, List<DenyRuleRecordAllOf>> mapListFromJson(dynamic json, {bool growable = false,}) {
    final map = <String, List<DenyRuleRecordAllOf>>{};
    if (json is Map && json.isNotEmpty) {
      // ignore: parameter_assignments
      json = json.cast<String, dynamic>();
      for (final entry in json.entries) {
        map[entry.key] = DenyRuleRecordAllOf.listFromJson(entry.value, growable: growable,);
      }
    }
    return map;
  }

  /// The list of required keys that must be present in a JSON.
  static const requiredKeys = <String>{
    'id',
    'created',
  };
}

