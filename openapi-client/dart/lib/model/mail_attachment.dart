//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.0

// ignore_for_file: unused_element, unused_import
// ignore_for_file: always_put_required_named_parameters_first
// ignore_for_file: lines_longer_than_80_chars

part of openapi.api;

class MailAttachment {
  /// Returns a new [MailAttachment] instance.
  MailAttachment({
    @required this.data,
    this.filename,
  });

  /// Contents of the attached file
  MultipartFile data;

  /// Optional filename to specify for the attachment.
  String filename;

  @override
  bool operator ==(Object other) => identical(this, other) || other is MailAttachment &&
     other.data == data &&
     other.filename == filename;

  @override
  int get hashCode =>
    (data == null ? 0 : data.hashCode) +
    (filename == null ? 0 : filename.hashCode);

  @override
  String toString() => 'MailAttachment[data=$data, filename=$filename]';

  Map<String, dynamic> toJson() {
    final json = <String, dynamic>{};
      json[r'data'] = data;
    if (filename != null) {
      json[r'filename'] = filename;
    }
    return json;
  }

  /// Returns a new [MailAttachment] instance and imports its values from
  /// [json] if it's non-null, null if [json] is null.
  static MailAttachment fromJson(Map<String, dynamic> json) => json == null
    ? null
    : MailAttachment(
        data: null, // No support for decoding binary content from JSON
        filename: json[r'filename'],
    );

  static List<MailAttachment> listFromJson(List<dynamic> json, {bool emptyIsNull, bool growable,}) =>
    json == null || json.isEmpty
      ? true == emptyIsNull ? null : <MailAttachment>[]
      : json.map((v) => MailAttachment.fromJson(v)).toList(growable: true == growable);

  static Map<String, MailAttachment> mapFromJson(Map<String, dynamic> json) {
    final map = <String, MailAttachment>{};
    if (json != null && json.isNotEmpty) {
      json.forEach((String key, dynamic v) => map[key] = MailAttachment.fromJson(v));
    }
    return map;
  }

  // maps a json object with a list of MailAttachment-objects as value to a dart map
  static Map<String, List<MailAttachment>> mapListFromJson(Map<String, dynamic> json, {bool emptyIsNull, bool growable,}) {
    final map = <String, List<MailAttachment>>{};
    if (json != null && json.isNotEmpty) {
      json.forEach((String key, dynamic v) {
        map[key] = MailAttachment.listFromJson(v, emptyIsNull: emptyIsNull, growable: growable);
      });
    }
    return map;
  }
}

