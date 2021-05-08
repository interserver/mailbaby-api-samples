//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.0

// ignore_for_file: unused_element, unused_import
// ignore_for_file: always_put_required_named_parameters_first
// ignore_for_file: lines_longer_than_80_chars

part of openapi.api;

class GenericResponse {
  /// Returns a new [GenericResponse] instance.
  GenericResponse({
    this.status,
    this.text,
  });

  String status;

  String text;

  @override
  bool operator ==(Object other) => identical(this, other) || other is GenericResponse &&
     other.status == status &&
     other.text == text;

  @override
  int get hashCode =>
    (status == null ? 0 : status.hashCode) +
    (text == null ? 0 : text.hashCode);

  @override
  String toString() => 'GenericResponse[status=$status, text=$text]';

  Map<String, dynamic> toJson() {
    final json = <String, dynamic>{};
    if (status != null) {
      json[r'status'] = status;
    }
    if (text != null) {
      json[r'text'] = text;
    }
    return json;
  }

  /// Returns a new [GenericResponse] instance and imports its values from
  /// [json] if it's non-null, null if [json] is null.
  static GenericResponse fromJson(Map<String, dynamic> json) => json == null
    ? null
    : GenericResponse(
        status: json[r'status'],
        text: json[r'text'],
    );

  static List<GenericResponse> listFromJson(List<dynamic> json, {bool emptyIsNull, bool growable,}) =>
    json == null || json.isEmpty
      ? true == emptyIsNull ? null : <GenericResponse>[]
      : json.map((v) => GenericResponse.fromJson(v)).toList(growable: true == growable);

  static Map<String, GenericResponse> mapFromJson(Map<String, dynamic> json) {
    final map = <String, GenericResponse>{};
    if (json != null && json.isNotEmpty) {
      json.forEach((String key, dynamic v) => map[key] = GenericResponse.fromJson(v));
    }
    return map;
  }

  // maps a json object with a list of GenericResponse-objects as value to a dart map
  static Map<String, List<GenericResponse>> mapListFromJson(Map<String, dynamic> json, {bool emptyIsNull, bool growable,}) {
    final map = <String, List<GenericResponse>>{};
    if (json != null && json.isNotEmpty) {
      json.forEach((String key, dynamic v) {
        map[key] = GenericResponse.listFromJson(v, emptyIsNull: emptyIsNull, growable: growable);
      });
    }
    return map;
  }
}

