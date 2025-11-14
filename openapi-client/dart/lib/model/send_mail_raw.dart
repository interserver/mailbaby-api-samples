//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.18

// ignore_for_file: unused_element, unused_import
// ignore_for_file: always_put_required_named_parameters_first
// ignore_for_file: constant_identifier_names
// ignore_for_file: lines_longer_than_80_chars

part of openapi.api;

class SendMailRaw {
  /// Returns a new [SendMailRaw] instance.
  SendMailRaw({
    required this.rawEmail,
    this.id,
  });

  /// The entire email contents
  String rawEmail;

  /// Optional order id
  ///
  /// Please note: This property should have been non-nullable! Since the specification file
  /// does not include a default value (using the "default:" property), however, the generated
  /// source code must fall back to having a nullable type.
  /// Consider adding a "default:" property in the specification file to hide this note.
  ///
  int? id;

  @override
  bool operator ==(Object other) => identical(this, other) || other is SendMailRaw &&
    other.rawEmail == rawEmail &&
    other.id == id;

  @override
  int get hashCode =>
    // ignore: unnecessary_parenthesis
    (rawEmail.hashCode) +
    (id == null ? 0 : id!.hashCode);

  @override
  String toString() => 'SendMailRaw[rawEmail=$rawEmail, id=$id]';

  Map<String, dynamic> toJson() {
    final json = <String, dynamic>{};
      json[r'raw_email'] = this.rawEmail;
    if (this.id != null) {
      json[r'id'] = this.id;
    } else {
      json[r'id'] = null;
    }
    return json;
  }

  /// Returns a new [SendMailRaw] instance and imports its values from
  /// [value] if it's a [Map], null otherwise.
  // ignore: prefer_constructors_over_static_methods
  static SendMailRaw? fromJson(dynamic value) {
    if (value is Map) {
      final json = value.cast<String, dynamic>();

      // Ensure that the map contains the required keys.
      // Note 1: the values aren't checked for validity beyond being non-null.
      // Note 2: this code is stripped in release mode!
      assert(() {
        requiredKeys.forEach((key) {
          assert(json.containsKey(key), 'Required key "SendMailRaw[$key]" is missing from JSON.');
          assert(json[key] != null, 'Required key "SendMailRaw[$key]" has a null value in JSON.');
        });
        return true;
      }());

      return SendMailRaw(
        rawEmail: mapValueOfType<String>(json, r'raw_email')!,
        id: mapValueOfType<int>(json, r'id'),
      );
    }
    return null;
  }

  static List<SendMailRaw> listFromJson(dynamic json, {bool growable = false,}) {
    final result = <SendMailRaw>[];
    if (json is List && json.isNotEmpty) {
      for (final row in json) {
        final value = SendMailRaw.fromJson(row);
        if (value != null) {
          result.add(value);
        }
      }
    }
    return result.toList(growable: growable);
  }

  static Map<String, SendMailRaw> mapFromJson(dynamic json) {
    final map = <String, SendMailRaw>{};
    if (json is Map && json.isNotEmpty) {
      json = json.cast<String, dynamic>(); // ignore: parameter_assignments
      for (final entry in json.entries) {
        final value = SendMailRaw.fromJson(entry.value);
        if (value != null) {
          map[entry.key] = value;
        }
      }
    }
    return map;
  }

  // maps a json object with a list of SendMailRaw-objects as value to a dart map
  static Map<String, List<SendMailRaw>> mapListFromJson(dynamic json, {bool growable = false,}) {
    final map = <String, List<SendMailRaw>>{};
    if (json is Map && json.isNotEmpty) {
      // ignore: parameter_assignments
      json = json.cast<String, dynamic>();
      for (final entry in json.entries) {
        map[entry.key] = SendMailRaw.listFromJson(entry.value, growable: growable,);
      }
    }
    return map;
  }

  /// The list of required keys that must be present in a JSON.
  static const requiredKeys = <String>{
    'raw_email',
  };
}

