//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.18

// ignore_for_file: unused_element, unused_import
// ignore_for_file: always_put_required_named_parameters_first
// ignore_for_file: constant_identifier_names
// ignore_for_file: lines_longer_than_80_chars

part of openapi.api;

class SendMailAdv {
  /// Returns a new [SendMailAdv] instance.
  SendMailAdv({
    required this.subject,
    required this.body,
    required this.from,
    required this.to,
    this.replyto,
    this.cc,
    this.bcc,
    this.attachments = const [],
    this.id,
  });

  /// The subject or title of the email
  String subject;

  /// The main email contents.
  String body;

  EmailAddressTypes from;

  EmailAddressesTypes to;

  ///
  /// Please note: This property should have been non-nullable! Since the specification file
  /// does not include a default value (using the "default:" property), however, the generated
  /// source code must fall back to having a nullable type.
  /// Consider adding a "default:" property in the specification file to hide this note.
  ///
  EmailAddressesTypes? replyto;

  ///
  /// Please note: This property should have been non-nullable! Since the specification file
  /// does not include a default value (using the "default:" property), however, the generated
  /// source code must fall back to having a nullable type.
  /// Consider adding a "default:" property in the specification file to hide this note.
  ///
  EmailAddressesTypes? cc;

  ///
  /// Please note: This property should have been non-nullable! Since the specification file
  /// does not include a default value (using the "default:" property), however, the generated
  /// source code must fall back to having a nullable type.
  /// Consider adding a "default:" property in the specification file to hide this note.
  ///
  EmailAddressesTypes? bcc;

  /// (optional) File attachments to include in the email.  The file contents must be base64 encoded!
  List<MailAttachment> attachments;

  /// (optional)  ID of the Mail order within our system to use as the Mail Account.
  ///
  /// Please note: This property should have been non-nullable! Since the specification file
  /// does not include a default value (using the "default:" property), however, the generated
  /// source code must fall back to having a nullable type.
  /// Consider adding a "default:" property in the specification file to hide this note.
  ///
  int? id;

  @override
  bool operator ==(Object other) => identical(this, other) || other is SendMailAdv &&
    other.subject == subject &&
    other.body == body &&
    other.from == from &&
    other.to == to &&
    other.replyto == replyto &&
    other.cc == cc &&
    other.bcc == bcc &&
    _deepEquality.equals(other.attachments, attachments) &&
    other.id == id;

  @override
  int get hashCode =>
    // ignore: unnecessary_parenthesis
    (subject.hashCode) +
    (body.hashCode) +
    (from.hashCode) +
    (to.hashCode) +
    (replyto == null ? 0 : replyto!.hashCode) +
    (cc == null ? 0 : cc!.hashCode) +
    (bcc == null ? 0 : bcc!.hashCode) +
    (attachments.hashCode) +
    (id == null ? 0 : id!.hashCode);

  @override
  String toString() => 'SendMailAdv[subject=$subject, body=$body, from=$from, to=$to, replyto=$replyto, cc=$cc, bcc=$bcc, attachments=$attachments, id=$id]';

  Map<String, dynamic> toJson() {
    final json = <String, dynamic>{};
      json[r'subject'] = this.subject;
      json[r'body'] = this.body;
      json[r'from'] = this.from;
      json[r'to'] = this.to;
    if (this.replyto != null) {
      json[r'replyto'] = this.replyto;
    } else {
      json[r'replyto'] = null;
    }
    if (this.cc != null) {
      json[r'cc'] = this.cc;
    } else {
      json[r'cc'] = null;
    }
    if (this.bcc != null) {
      json[r'bcc'] = this.bcc;
    } else {
      json[r'bcc'] = null;
    }
      json[r'attachments'] = this.attachments;
    if (this.id != null) {
      json[r'id'] = this.id;
    } else {
      json[r'id'] = null;
    }
    return json;
  }

  /// Returns a new [SendMailAdv] instance and imports its values from
  /// [value] if it's a [Map], null otherwise.
  // ignore: prefer_constructors_over_static_methods
  static SendMailAdv? fromJson(dynamic value) {
    if (value is Map) {
      final json = value.cast<String, dynamic>();

      // Ensure that the map contains the required keys.
      // Note 1: the values aren't checked for validity beyond being non-null.
      // Note 2: this code is stripped in release mode!
      assert(() {
        requiredKeys.forEach((key) {
          assert(json.containsKey(key), 'Required key "SendMailAdv[$key]" is missing from JSON.');
          assert(json[key] != null, 'Required key "SendMailAdv[$key]" has a null value in JSON.');
        });
        return true;
      }());

      return SendMailAdv(
        subject: mapValueOfType<String>(json, r'subject')!,
        body: mapValueOfType<String>(json, r'body')!,
        from: EmailAddressTypes.fromJson(json[r'from'])!,
        to: EmailAddressesTypes.fromJson(json[r'to'])!,
        replyto: EmailAddressesTypes.fromJson(json[r'replyto']),
        cc: EmailAddressesTypes.fromJson(json[r'cc']),
        bcc: EmailAddressesTypes.fromJson(json[r'bcc']),
        attachments: MailAttachment.listFromJson(json[r'attachments']),
        id: mapValueOfType<int>(json, r'id'),
      );
    }
    return null;
  }

  static List<SendMailAdv> listFromJson(dynamic json, {bool growable = false,}) {
    final result = <SendMailAdv>[];
    if (json is List && json.isNotEmpty) {
      for (final row in json) {
        final value = SendMailAdv.fromJson(row);
        if (value != null) {
          result.add(value);
        }
      }
    }
    return result.toList(growable: growable);
  }

  static Map<String, SendMailAdv> mapFromJson(dynamic json) {
    final map = <String, SendMailAdv>{};
    if (json is Map && json.isNotEmpty) {
      json = json.cast<String, dynamic>(); // ignore: parameter_assignments
      for (final entry in json.entries) {
        final value = SendMailAdv.fromJson(entry.value);
        if (value != null) {
          map[entry.key] = value;
        }
      }
    }
    return map;
  }

  // maps a json object with a list of SendMailAdv-objects as value to a dart map
  static Map<String, List<SendMailAdv>> mapListFromJson(dynamic json, {bool growable = false,}) {
    final map = <String, List<SendMailAdv>>{};
    if (json is Map && json.isNotEmpty) {
      // ignore: parameter_assignments
      json = json.cast<String, dynamic>();
      for (final entry in json.entries) {
        map[entry.key] = SendMailAdv.listFromJson(entry.value, growable: growable,);
      }
    }
    return map;
  }

  /// The list of required keys that must be present in a JSON.
  static const requiredKeys = <String>{
    'subject',
    'body',
    'from',
    'to',
  };
}

