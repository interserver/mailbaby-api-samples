//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.0

// ignore_for_file: unused_element, unused_import
// ignore_for_file: always_put_required_named_parameters_first
// ignore_for_file: lines_longer_than_80_chars

part of openapi.api;

class Body1 {
  /// Returns a new [Body1] instance.
  Body1({
    this.to,
    this.from,
    this.subject,
    this.body,
  });

  /// The Contact whom is the primary recipient of this email.
  String to;

  /// The contact whom is the this email is from.
  String from;

  /// The subject or title of the email
  String subject;

  /// The main email contents.
  String body;

  @override
  bool operator ==(Object other) => identical(this, other) || other is Body1 &&
     other.to == to &&
     other.from == from &&
     other.subject == subject &&
     other.body == body;

  @override
  int get hashCode =>
    (to == null ? 0 : to.hashCode) +
    (from == null ? 0 : from.hashCode) +
    (subject == null ? 0 : subject.hashCode) +
    (body == null ? 0 : body.hashCode);

  @override
  String toString() => 'Body1[to=$to, from=$from, subject=$subject, body=$body]';

  Map<String, dynamic> toJson() {
    final json = <String, dynamic>{};
    if (to != null) {
      json[r'to'] = to;
    }
    if (from != null) {
      json[r'from'] = from;
    }
    if (subject != null) {
      json[r'subject'] = subject;
    }
    if (body != null) {
      json[r'body'] = body;
    }
    return json;
  }

  /// Returns a new [Body1] instance and imports its values from
  /// [json] if it's non-null, null if [json] is null.
  static Body1 fromJson(Map<String, dynamic> json) => json == null
    ? null
    : Body1(
        to: json[r'to'],
        from: json[r'from'],
        subject: json[r'subject'],
        body: json[r'body'],
    );

  static List<Body1> listFromJson(List<dynamic> json, {bool emptyIsNull, bool growable,}) =>
    json == null || json.isEmpty
      ? true == emptyIsNull ? null : <Body1>[]
      : json.map((v) => Body1.fromJson(v)).toList(growable: true == growable);

  static Map<String, Body1> mapFromJson(Map<String, dynamic> json) {
    final map = <String, Body1>{};
    if (json != null && json.isNotEmpty) {
      json.forEach((String key, dynamic v) => map[key] = Body1.fromJson(v));
    }
    return map;
  }

  // maps a json object with a list of Body1-objects as value to a dart map
  static Map<String, List<Body1>> mapListFromJson(Map<String, dynamic> json, {bool emptyIsNull, bool growable,}) {
    final map = <String, List<Body1>>{};
    if (json != null && json.isNotEmpty) {
      json.forEach((String key, dynamic v) {
        map[key] = Body1.listFromJson(v, emptyIsNull: emptyIsNull, growable: growable);
      });
    }
    return map;
  }
}

