//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.0

// ignore_for_file: unused_element, unused_import
// ignore_for_file: always_put_required_named_parameters_first
// ignore_for_file: lines_longer_than_80_chars

part of openapi.api;

class SendMail {
  /// Returns a new [SendMail] instance.
  SendMail({
    @required this.to,
    @required this.from,
    @required this.subject,
    @required this.body,
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
  bool operator ==(Object other) => identical(this, other) || other is SendMail &&
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
  String toString() => 'SendMail[to=$to, from=$from, subject=$subject, body=$body]';

  Map<String, dynamic> toJson() {
    final json = <String, dynamic>{};
      json[r'to'] = to;
      json[r'from'] = from;
      json[r'subject'] = subject;
      json[r'body'] = body;
    return json;
  }

  /// Returns a new [SendMail] instance and imports its values from
  /// [json] if it's non-null, null if [json] is null.
  static SendMail fromJson(Map<String, dynamic> json) => json == null
    ? null
    : SendMail(
        to: json[r'to'],
        from: json[r'from'],
        subject: json[r'subject'],
        body: json[r'body'],
    );

  static List<SendMail> listFromJson(List<dynamic> json, {bool emptyIsNull, bool growable,}) =>
    json == null || json.isEmpty
      ? true == emptyIsNull ? null : <SendMail>[]
      : json.map((v) => SendMail.fromJson(v)).toList(growable: true == growable);

  static Map<String, SendMail> mapFromJson(Map<String, dynamic> json) {
    final map = <String, SendMail>{};
    if (json != null && json.isNotEmpty) {
      json.forEach((String key, dynamic v) => map[key] = SendMail.fromJson(v));
    }
    return map;
  }

  // maps a json object with a list of SendMail-objects as value to a dart map
  static Map<String, List<SendMail>> mapListFromJson(Map<String, dynamic> json, {bool emptyIsNull, bool growable,}) {
    final map = <String, List<SendMail>>{};
    if (json != null && json.isNotEmpty) {
      json.forEach((String key, dynamic v) {
        map[key] = SendMail.listFromJson(v, emptyIsNull: emptyIsNull, growable: growable);
      });
    }
    return map;
  }
}
