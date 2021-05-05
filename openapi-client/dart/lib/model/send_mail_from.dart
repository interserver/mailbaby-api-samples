//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.0

// ignore_for_file: unused_element, unused_import
// ignore_for_file: always_put_required_named_parameters_first
// ignore_for_file: lines_longer_than_80_chars

part of openapi.api;

class SendMailFrom {
  /// Returns a new [SendMailFrom] instance.
  SendMailFrom({
    @required this.email,
    this.name,
  });

  /// The email address
  String email;

  /// Optional contact name
  String name;

  @override
  bool operator ==(Object other) => identical(this, other) || other is SendMailFrom &&
     other.email == email &&
     other.name == name;

  @override
  int get hashCode =>
    (email == null ? 0 : email.hashCode) +
    (name == null ? 0 : name.hashCode);

  @override
  String toString() => 'SendMailFrom[email=$email, name=$name]';

  Map<String, dynamic> toJson() {
    final json = <String, dynamic>{};
      json[r'email'] = email;
    if (name != null) {
      json[r'name'] = name;
    }
    return json;
  }

  /// Returns a new [SendMailFrom] instance and imports its values from
  /// [json] if it's non-null, null if [json] is null.
  static SendMailFrom fromJson(Map<String, dynamic> json) => json == null
    ? null
    : SendMailFrom(
        email: json[r'email'],
        name: json[r'name'],
    );

  static List<SendMailFrom> listFromJson(List<dynamic> json, {bool emptyIsNull, bool growable,}) =>
    json == null || json.isEmpty
      ? true == emptyIsNull ? null : <SendMailFrom>[]
      : json.map((v) => SendMailFrom.fromJson(v)).toList(growable: true == growable);

  static Map<String, SendMailFrom> mapFromJson(Map<String, dynamic> json) {
    final map = <String, SendMailFrom>{};
    if (json != null && json.isNotEmpty) {
      json.forEach((String key, dynamic v) => map[key] = SendMailFrom.fromJson(v));
    }
    return map;
  }

  // maps a json object with a list of SendMailFrom-objects as value to a dart map
  static Map<String, List<SendMailFrom>> mapListFromJson(Map<String, dynamic> json, {bool emptyIsNull, bool growable,}) {
    final map = <String, List<SendMailFrom>>{};
    if (json != null && json.isNotEmpty) {
      json.forEach((String key, dynamic v) {
        map[key] = SendMailFrom.listFromJson(v, emptyIsNull: emptyIsNull, growable: growable);
      });
    }
    return map;
  }
}

