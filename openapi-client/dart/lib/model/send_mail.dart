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
    @required this.id,
    @required this.from,
    this.to = const [],
    @required this.subject,
    @required this.body,
    this.replyto = const [],
    this.cc = const [],
    this.bcc = const [],
    this.attachments = const [],
  });

  /// The ID of the Mail order within our system to use as the Mail Account.
  int id;

  MailContact from;

  /// The Contact whom is the primary recipient of this email.
  List<MailContact> to;

  /// The subject or title of the email
  String subject;

  /// The main email contents.
  String body;

  /// Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address.
  List<MailContact> replyto;

  /// Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.
  List<MailContact> cc;

  /// Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.
  List<MailContact> bcc;

  /// Optional file attachments to include in the email
  List<MailAttachment> attachments;

  @override
  bool operator ==(Object other) => identical(this, other) || other is SendMail &&
     other.id == id &&
     other.from == from &&
     other.to == to &&
     other.subject == subject &&
     other.body == body &&
     other.replyto == replyto &&
     other.cc == cc &&
     other.bcc == bcc &&
     other.attachments == attachments;

  @override
  int get hashCode =>
    (id == null ? 0 : id.hashCode) +
    (from == null ? 0 : from.hashCode) +
    (to == null ? 0 : to.hashCode) +
    (subject == null ? 0 : subject.hashCode) +
    (body == null ? 0 : body.hashCode) +
    (replyto == null ? 0 : replyto.hashCode) +
    (cc == null ? 0 : cc.hashCode) +
    (bcc == null ? 0 : bcc.hashCode) +
    (attachments == null ? 0 : attachments.hashCode);

  @override
  String toString() => 'SendMail[id=$id, from=$from, to=$to, subject=$subject, body=$body, replyto=$replyto, cc=$cc, bcc=$bcc, attachments=$attachments]';

  Map<String, dynamic> toJson() {
    final json = <String, dynamic>{};
      json[r'id'] = id;
      json[r'from'] = from;
      json[r'to'] = to;
      json[r'subject'] = subject;
      json[r'body'] = body;
    if (replyto != null) {
      json[r'replyto'] = replyto;
    }
    if (cc != null) {
      json[r'cc'] = cc;
    }
    if (bcc != null) {
      json[r'bcc'] = bcc;
    }
    if (attachments != null) {
      json[r'attachments'] = attachments;
    }
    return json;
  }

  /// Returns a new [SendMail] instance and imports its values from
  /// [json] if it's non-null, null if [json] is null.
  static SendMail fromJson(Map<String, dynamic> json) => json == null
    ? null
    : SendMail(
        id: json[r'id'],
        from: MailContact.fromJson(json[r'from']),
        to: MailContact.listFromJson(json[r'to']),
        subject: json[r'subject'],
        body: json[r'body'],
        replyto: MailContact.listFromJson(json[r'replyto']),
        cc: MailContact.listFromJson(json[r'cc']),
        bcc: MailContact.listFromJson(json[r'bcc']),
        attachments: MailAttachment.listFromJson(json[r'attachments']),
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

