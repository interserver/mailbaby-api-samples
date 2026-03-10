//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.18

// ignore_for_file: unused_element, unused_import
// ignore_for_file: always_put_required_named_parameters_first
// ignore_for_file: constant_identifier_names
// ignore_for_file: lines_longer_than_80_chars

part of openapi.api;

class EmailAddressParam {
  /// Returns a new [EmailAddressParam] instance.
  EmailAddressParam({
    required this.email,
  });

  /// The email address to delist from all block lists.
  String email;

  @override
  bool operator ==(Object other) => identical(this, other) || other is EmailAddressParam &&
    other.email == email;

  @override
  int get hashCode =>
    // ignore: unnecessary_parenthesis
    (email.hashCode);

  @override
  String toString() => 'EmailAddressParam[email=$email]';

  Map<String, dynamic> toJson() {
    final json = <String, dynamic>{};
      json[r'email'] = this.email;
    return json;
  }

  /// Returns a new [EmailAddressParam] instance and imports its values from
  /// [value] if it's a [Map], null otherwise.
  // ignore: prefer_constructors_over_static_methods
  static EmailAddressParam? fromJson(dynamic value) {
    if (value is Map) {
      final json = value.cast<String, dynamic>();

      // Ensure that the map contains the required keys.
      // Note 1: the values aren't checked for validity beyond being non-null.
      // Note 2: this code is stripped in release mode!
      assert(() {
        requiredKeys.forEach((key) {
          assert(json.containsKey(key), 'Required key "EmailAddressParam[$key]" is missing from JSON.');
          assert(json[key] != null, 'Required key "EmailAddressParam[$key]" has a null value in JSON.');
        });
        return true;
      }());

      return EmailAddressParam(
        email: mapValueOfType<String>(json, r'email')!,
      );
    }
    return null;
  }

  static List<EmailAddressParam> listFromJson(dynamic json, {bool growable = false,}) {
    final result = <EmailAddressParam>[];
    if (json is List && json.isNotEmpty) {
      for (final row in json) {
        final value = EmailAddressParam.fromJson(row);
        if (value != null) {
          result.add(value);
        }
      }
    }
    return result.toList(growable: growable);
  }

  static Map<String, EmailAddressParam> mapFromJson(dynamic json) {
    final map = <String, EmailAddressParam>{};
    if (json is Map && json.isNotEmpty) {
      json = json.cast<String, dynamic>(); // ignore: parameter_assignments
      for (final entry in json.entries) {
        final value = EmailAddressParam.fromJson(entry.value);
        if (value != null) {
          map[entry.key] = value;
        }
      }
    }
    return map;
  }

  // maps a json object with a list of EmailAddressParam-objects as value to a dart map
  static Map<String, List<EmailAddressParam>> mapListFromJson(dynamic json, {bool growable = false,}) {
    final map = <String, List<EmailAddressParam>>{};
    if (json is Map && json.isNotEmpty) {
      // ignore: parameter_assignments
      json = json.cast<String, dynamic>();
      for (final entry in json.entries) {
        map[entry.key] = EmailAddressParam.listFromJson(entry.value, growable: growable,);
      }
    }
    return map;
  }

  /// The list of required keys that must be present in a JSON.
  static const requiredKeys = <String>{
    'email',
  };
}

