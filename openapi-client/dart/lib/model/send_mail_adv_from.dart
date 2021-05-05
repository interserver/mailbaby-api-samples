//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.0

// ignore_for_file: unused_element, unused_import
// ignore_for_file: always_put_required_named_parameters_first
// ignore_for_file: lines_longer_than_80_chars

part of openapi.api;

class SendMailAdvFrom {
  /// Returns a new [SendMailAdvFrom] instance.
  SendMailAdvFrom({
    @required this.email,
    this.name,
  });

  /// The email address
  String email;

  /// Optional contact name
  String name;

  @override
  bool operator ==(Object other) => identical(this, other) || other is SendMailAdvFrom &&
     other.email == email &&
     other.name == name;

  @override
  int get hashCode =>
    (email == null ? 0 : email.hashCode) +
    (name == null ? 0 : name.hashCode);

  @override
  String toString() => 'SendMailAdvFrom[email=$email, name=$name]';

  Map<String, dynamic> toJson() {
    final json = <String, dynamic>{};
      json[r'email'] = email;
    if (name != null) {
      json[r'name'] = name;
    }
    return json;
  }

  /// Returns a new [SendMailAdvFrom] instance and imports its values from
  /// [json] if it's non-null, null if [json] is null.
  static SendMailAdvFrom fromJson(Map<String, dynamic> json) => json == null
    ? null
    : SendMailAdvFrom(
        email: json[r'email'],
        name: json[r'name'],
    );

  static List<SendMailAdvFrom> listFromJson(List<dynamic> json, {bool emptyIsNull, bool growable,}) =>
    json == null || json.isEmpty
      ? true == emptyIsNull ? null : <SendMailAdvFrom>[]
      : json.map((v) => SendMailAdvFrom.fromJson(v)).toList(growable: true == growable);

  static Map<String, SendMailAdvFrom> mapFromJson(Map<String, dynamic> json) {
    final map = <String, SendMailAdvFrom>{};
    if (json != null && json.isNotEmpty) {
      json.forEach((String key, dynamic v) => map[key] = SendMailAdvFrom.fromJson(v));
    }
    return map;
  }

  // maps a json object with a list of SendMailAdvFrom-objects as value to a dart map
  static Map<String, List<SendMailAdvFrom>> mapListFromJson(Map<String, dynamic> json, {bool emptyIsNull, bool growable,}) {
    final map = <String, List<SendMailAdvFrom>>{};
    if (json != null && json.isNotEmpty) {
      json.forEach((String key, dynamic v) {
        map[key] = SendMailAdvFrom.listFromJson(v, emptyIsNull: emptyIsNull, growable: growable);
      });
    }
    return map;
  }
}

