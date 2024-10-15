//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.18

// ignore_for_file: unused_element, unused_import
// ignore_for_file: always_put_required_named_parameters_first
// ignore_for_file: constant_identifier_names
// ignore_for_file: lines_longer_than_80_chars

part of openapi.api;

class GetStats200ResponseInner {
  /// Returns a new [GetStats200ResponseInner] instance.
  GetStats200ResponseInner({
    required this.id,
    required this.status,
    required this.username,
    this.password,
    this.comment,
  });

  int id;

  String status;

  String username;

  ///
  /// Please note: This property should have been non-nullable! Since the specification file
  /// does not include a default value (using the "default:" property), however, the generated
  /// source code must fall back to having a nullable type.
  /// Consider adding a "default:" property in the specification file to hide this note.
  ///
  String? password;

  ///
  /// Please note: This property should have been non-nullable! Since the specification file
  /// does not include a default value (using the "default:" property), however, the generated
  /// source code must fall back to having a nullable type.
  /// Consider adding a "default:" property in the specification file to hide this note.
  ///
  String? comment;

  @override
  bool operator ==(Object other) => identical(this, other) || other is GetStats200ResponseInner &&
    other.id == id &&
    other.status == status &&
    other.username == username &&
    other.password == password &&
    other.comment == comment;

  @override
  int get hashCode =>
    // ignore: unnecessary_parenthesis
    (id.hashCode) +
    (status.hashCode) +
    (username.hashCode) +
    (password == null ? 0 : password!.hashCode) +
    (comment == null ? 0 : comment!.hashCode);

  @override
  String toString() => 'GetStats200ResponseInner[id=$id, status=$status, username=$username, password=$password, comment=$comment]';

  Map<String, dynamic> toJson() {
    final json = <String, dynamic>{};
      json[r'id'] = this.id;
      json[r'status'] = this.status;
      json[r'username'] = this.username;
    if (this.password != null) {
      json[r'password'] = this.password;
    } else {
      json[r'password'] = null;
    }
    if (this.comment != null) {
      json[r'comment'] = this.comment;
    } else {
      json[r'comment'] = null;
    }
    return json;
  }

  /// Returns a new [GetStats200ResponseInner] instance and imports its values from
  /// [value] if it's a [Map], null otherwise.
  // ignore: prefer_constructors_over_static_methods
  static GetStats200ResponseInner? fromJson(dynamic value) {
    if (value is Map) {
      final json = value.cast<String, dynamic>();

      // Ensure that the map contains the required keys.
      // Note 1: the values aren't checked for validity beyond being non-null.
      // Note 2: this code is stripped in release mode!
      assert(() {
        requiredKeys.forEach((key) {
          assert(json.containsKey(key), 'Required key "GetStats200ResponseInner[$key]" is missing from JSON.');
          assert(json[key] != null, 'Required key "GetStats200ResponseInner[$key]" has a null value in JSON.');
        });
        return true;
      }());

      return GetStats200ResponseInner(
        id: mapValueOfType<int>(json, r'id')!,
        status: mapValueOfType<String>(json, r'status')!,
        username: mapValueOfType<String>(json, r'username')!,
        password: mapValueOfType<String>(json, r'password'),
        comment: mapValueOfType<String>(json, r'comment'),
      );
    }
    return null;
  }

  static List<GetStats200ResponseInner> listFromJson(dynamic json, {bool growable = false,}) {
    final result = <GetStats200ResponseInner>[];
    if (json is List && json.isNotEmpty) {
      for (final row in json) {
        final value = GetStats200ResponseInner.fromJson(row);
        if (value != null) {
          result.add(value);
        }
      }
    }
    return result.toList(growable: growable);
  }

  static Map<String, GetStats200ResponseInner> mapFromJson(dynamic json) {
    final map = <String, GetStats200ResponseInner>{};
    if (json is Map && json.isNotEmpty) {
      json = json.cast<String, dynamic>(); // ignore: parameter_assignments
      for (final entry in json.entries) {
        final value = GetStats200ResponseInner.fromJson(entry.value);
        if (value != null) {
          map[entry.key] = value;
        }
      }
    }
    return map;
  }

  // maps a json object with a list of GetStats200ResponseInner-objects as value to a dart map
  static Map<String, List<GetStats200ResponseInner>> mapListFromJson(dynamic json, {bool growable = false,}) {
    final map = <String, List<GetStats200ResponseInner>>{};
    if (json is Map && json.isNotEmpty) {
      // ignore: parameter_assignments
      json = json.cast<String, dynamic>();
      for (final entry in json.entries) {
        map[entry.key] = GetStats200ResponseInner.listFromJson(entry.value, growable: growable,);
      }
    }
    return map;
  }

  /// The list of required keys that must be present in a JSON.
  static const requiredKeys = <String>{
    'id',
    'status',
    'username',
  };
}

