//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.0

// ignore_for_file: unused_element, unused_import
// ignore_for_file: always_put_required_named_parameters_first
// ignore_for_file: lines_longer_than_80_chars

part of openapi.api;

class MailLog {
  /// Returns a new [MailLog] instance.
  MailLog({
    this.id,
  });

  int id;

  @override
  bool operator ==(Object other) => identical(this, other) || other is MailLog &&
     other.id == id;

  @override
  int get hashCode =>
    (id == null ? 0 : id.hashCode);

  @override
  String toString() => 'MailLog[id=$id]';

  Map<String, dynamic> toJson() {
    final json = <String, dynamic>{};
    if (id != null) {
      json[r'id'] = id;
    }
    return json;
  }

  /// Returns a new [MailLog] instance and imports its values from
  /// [json] if it's non-null, null if [json] is null.
  static MailLog fromJson(Map<String, dynamic> json) => json == null
    ? null
    : MailLog(
        id: json[r'id'],
    );

  static List<MailLog> listFromJson(List<dynamic> json, {bool emptyIsNull, bool growable,}) =>
    json == null || json.isEmpty
      ? true == emptyIsNull ? null : <MailLog>[]
      : json.map((v) => MailLog.fromJson(v)).toList(growable: true == growable);

  static Map<String, MailLog> mapFromJson(Map<String, dynamic> json) {
    final map = <String, MailLog>{};
    if (json != null && json.isNotEmpty) {
      json.forEach((String key, dynamic v) => map[key] = MailLog.fromJson(v));
    }
    return map;
  }

  // maps a json object with a list of MailLog-objects as value to a dart map
  static Map<String, List<MailLog>> mapListFromJson(Map<String, dynamic> json, {bool emptyIsNull, bool growable,}) {
    final map = <String, List<MailLog>>{};
    if (json != null && json.isNotEmpty) {
      json.forEach((String key, dynamic v) {
        map[key] = MailLog.listFromJson(v, emptyIsNull: emptyIsNull, growable: growable);
      });
    }
    return map;
  }
}

