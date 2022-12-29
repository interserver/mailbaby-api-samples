//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.12

// ignore_for_file: unused_element, unused_import
// ignore_for_file: always_put_required_named_parameters_first
// ignore_for_file: constant_identifier_names
// ignore_for_file: lines_longer_than_80_chars

part of openapi.api;

class SendMailAdvAttachmentsInner {
  /// Returns a new [SendMailAdvAttachmentsInner] instance.
  SendMailAdvAttachmentsInner({
    required this.data,
    this.filename,
  });

  /// Contents of the attached file (must be base64 encoded)
  MultipartFile data;

  /// (optional) Filename to specify for the attachment.
  ///
  /// Please note: This property should have been non-nullable! Since the specification file
  /// does not include a default value (using the "default:" property), however, the generated
  /// source code must fall back to having a nullable type.
  /// Consider adding a "default:" property in the specification file to hide this note.
  ///
  String? filename;

  @override
  bool operator ==(Object other) => identical(this, other) || other is SendMailAdvAttachmentsInner &&
     other.data == data &&
     other.filename == filename;

  @override
  int get hashCode =>
    // ignore: unnecessary_parenthesis
    (data.hashCode) +
    (filename == null ? 0 : filename!.hashCode);

  @override
  String toString() => 'SendMailAdvAttachmentsInner[data=$data, filename=$filename]';

  Map<String, dynamic> toJson() {
    final _json = <String, dynamic>{};
      _json[r'data'] = data;
    if (filename != null) {
      _json[r'filename'] = filename;
    } else {
      _json[r'filename'] = null;
    }
    return _json;
  }

  /// Returns a new [SendMailAdvAttachmentsInner] instance and imports its values from
  /// [value] if it's a [Map], null otherwise.
  // ignore: prefer_constructors_over_static_methods
  static SendMailAdvAttachmentsInner? fromJson(dynamic value) {
    if (value is Map) {
      final json = value.cast<String, dynamic>();

      // Ensure that the map contains the required keys.
      // Note 1: the values aren't checked for validity beyond being non-null.
      // Note 2: this code is stripped in release mode!
      assert(() {
        requiredKeys.forEach((key) {
          assert(json.containsKey(key), 'Required key "SendMailAdvAttachmentsInner[$key]" is missing from JSON.');
          assert(json[key] != null, 'Required key "SendMailAdvAttachmentsInner[$key]" has a null value in JSON.');
        });
        return true;
      }());

      return SendMailAdvAttachmentsInner(
        data: null, // No support for decoding binary content from JSON
        filename: mapValueOfType<String>(json, r'filename'),
      );
    }
    return null;
  }

  static List<SendMailAdvAttachmentsInner>? listFromJson(dynamic json, {bool growable = false,}) {
    final result = <SendMailAdvAttachmentsInner>[];
    if (json is List && json.isNotEmpty) {
      for (final row in json) {
        final value = SendMailAdvAttachmentsInner.fromJson(row);
        if (value != null) {
          result.add(value);
        }
      }
    }
    return result.toList(growable: growable);
  }

  static Map<String, SendMailAdvAttachmentsInner> mapFromJson(dynamic json) {
    final map = <String, SendMailAdvAttachmentsInner>{};
    if (json is Map && json.isNotEmpty) {
      json = json.cast<String, dynamic>(); // ignore: parameter_assignments
      for (final entry in json.entries) {
        final value = SendMailAdvAttachmentsInner.fromJson(entry.value);
        if (value != null) {
          map[entry.key] = value;
        }
      }
    }
    return map;
  }

  // maps a json object with a list of SendMailAdvAttachmentsInner-objects as value to a dart map
  static Map<String, List<SendMailAdvAttachmentsInner>> mapListFromJson(dynamic json, {bool growable = false,}) {
    final map = <String, List<SendMailAdvAttachmentsInner>>{};
    if (json is Map && json.isNotEmpty) {
      json = json.cast<String, dynamic>(); // ignore: parameter_assignments
      for (final entry in json.entries) {
        final value = SendMailAdvAttachmentsInner.listFromJson(entry.value, growable: growable,);
        if (value != null) {
          map[entry.key] = value;
        }
      }
    }
    return map;
  }

  /// The list of required keys that must be present in a JSON.
  static const requiredKeys = <String>{
    'data',
  };
}

