//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.0

// ignore_for_file: unused_element, unused_import
// ignore_for_file: always_put_required_named_parameters_first
// ignore_for_file: lines_longer_than_80_chars

part of openapi.api;

class InlineResponse401 {
  /// Returns a new [InlineResponse401] instance.
  InlineResponse401({
    @required this.code,
    @required this.message,
  });

  String code;

  String message;

  @override
  bool operator ==(Object other) => identical(this, other) || other is InlineResponse401 &&
     other.code == code &&
     other.message == message;

  @override
  int get hashCode =>
    (code == null ? 0 : code.hashCode) +
    (message == null ? 0 : message.hashCode);

  @override
  String toString() => 'InlineResponse401[code=$code, message=$message]';

  Map<String, dynamic> toJson() {
    final json = <String, dynamic>{};
      json[r'code'] = code;
      json[r'message'] = message;
    return json;
  }

  /// Returns a new [InlineResponse401] instance and imports its values from
  /// [json] if it's non-null, null if [json] is null.
  static InlineResponse401 fromJson(Map<String, dynamic> json) => json == null
    ? null
    : InlineResponse401(
        code: json[r'code'],
        message: json[r'message'],
    );

  static List<InlineResponse401> listFromJson(List<dynamic> json, {bool emptyIsNull, bool growable,}) =>
    json == null || json.isEmpty
      ? true == emptyIsNull ? null : <InlineResponse401>[]
      : json.map((v) => InlineResponse401.fromJson(v)).toList(growable: true == growable);

  static Map<String, InlineResponse401> mapFromJson(Map<String, dynamic> json) {
    final map = <String, InlineResponse401>{};
    if (json != null && json.isNotEmpty) {
      json.forEach((String key, dynamic v) => map[key] = InlineResponse401.fromJson(v));
    }
    return map;
  }

  // maps a json object with a list of InlineResponse401-objects as value to a dart map
  static Map<String, List<InlineResponse401>> mapListFromJson(Map<String, dynamic> json, {bool emptyIsNull, bool growable,}) {
    final map = <String, List<InlineResponse401>>{};
    if (json != null && json.isNotEmpty) {
      json.forEach((String key, dynamic v) {
        map[key] = InlineResponse401.listFromJson(v, emptyIsNull: emptyIsNull, growable: growable);
      });
    }
    return map;
  }
}

