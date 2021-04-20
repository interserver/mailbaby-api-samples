//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.0

// ignore_for_file: unused_element, unused_import
// ignore_for_file: always_put_required_named_parameters_first
// ignore_for_file: lines_longer_than_80_chars

part of openapi.api;

class ErrorResponse {
  /// Returns a new [ErrorResponse] instance.
  ErrorResponse({
    @required this.code,
    @required this.message,
  });

  String code;

  String message;

  @override
  bool operator ==(Object other) => identical(this, other) || other is ErrorResponse &&
     other.code == code &&
     other.message == message;

  @override
  int get hashCode =>
    (code == null ? 0 : code.hashCode) +
    (message == null ? 0 : message.hashCode);

  @override
  String toString() => 'ErrorResponse[code=$code, message=$message]';

  Map<String, dynamic> toJson() {
    final json = <String, dynamic>{};
      json[r'code'] = code;
      json[r'message'] = message;
    return json;
  }

  /// Returns a new [ErrorResponse] instance and imports its values from
  /// [json] if it's non-null, null if [json] is null.
  static ErrorResponse fromJson(Map<String, dynamic> json) => json == null
    ? null
    : ErrorResponse(
        code: json[r'code'],
        message: json[r'message'],
    );

  static List<ErrorResponse> listFromJson(List<dynamic> json, {bool emptyIsNull, bool growable,}) =>
    json == null || json.isEmpty
      ? true == emptyIsNull ? null : <ErrorResponse>[]
      : json.map((v) => ErrorResponse.fromJson(v)).toList(growable: true == growable);

  static Map<String, ErrorResponse> mapFromJson(Map<String, dynamic> json) {
    final map = <String, ErrorResponse>{};
    if (json != null && json.isNotEmpty) {
      json.forEach((String key, dynamic v) => map[key] = ErrorResponse.fromJson(v));
    }
    return map;
  }

  // maps a json object with a list of ErrorResponse-objects as value to a dart map
  static Map<String, List<ErrorResponse>> mapListFromJson(Map<String, dynamic> json, {bool emptyIsNull, bool growable,}) {
    final map = <String, List<ErrorResponse>>{};
    if (json != null && json.isNotEmpty) {
      json.forEach((String key, dynamic v) {
        map[key] = ErrorResponse.listFromJson(v, emptyIsNull: emptyIsNull, growable: growable);
      });
    }
    return map;
  }
}

