//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.0

// ignore_for_file: unused_element, unused_import
// ignore_for_file: always_put_required_named_parameters_first
// ignore_for_file: lines_longer_than_80_chars

part of openapi.api;

class SendMailAdv {
  /// Returns a new [SendMailAdv] instance.
  SendMailAdv({
    @required this.subject,
    @required this.body,
    this.from = const [],
    this.to = const [],
    @required this.id,
    this.replyto = const [],
    this.cc = const [],
    this.bcc = const [],
    this.attachments = const [],
  });

  /// The subject or title of the email
  String subject;

  /// The main email contents.
  String body;

  /// The contact whom is the this email is from.
  List<SendMailAdvFrom> from;

  /// The Contact whom is the primary recipient of this email.
  List<MailContact> to;

  /// The ID of the Mail order within our system to use as the Mail Account.
  int id;

  /// Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address.
  List<MailContact> replyto;

  /// Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.
  List<MailContact> cc;

  /// Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.
  List<MailContact> bcc;

  /// Optional file attachments to include in the email
  List<MailAttachment> attachments;

  @override
  bool operator ==(Object other) => identical(this, other) || other is SendMailAdv &&
     other.subject == subject &&
     other.body == body &&
     other.from == from &&
     other.to == to &&
     other.id == id &&
     other.replyto == replyto &&
     other.cc == cc &&
     other.bcc == bcc &&
     other.attachments == attachments;

  @override
  int get hashCode =>
    (subject == null ? 0 : subject.hashCode) +
    (body == null ? 0 : body.hashCode) +
    (from == null ? 0 : from.hashCode) +
    (to == null ? 0 : to.hashCode) +
    (id == null ? 0 : id.hashCode) +
    (replyto == null ? 0 : replyto.hashCode) +
    (cc == null ? 0 : cc.hashCode) +
    (bcc == null ? 0 : bcc.hashCode) +
    (attachments == null ? 0 : attachments.hashCode);

  @override
  String toString() => 'SendMailAdv[subject=$subject, body=$body, from=$from, to=$to, id=$id, replyto=$replyto, cc=$cc, bcc=$bcc, attachments=$attachments]';

  Map<String, dynamic> toJson() {
    final json = <String, dynamic>{};
      json[r'subject'] = subject;
      json[r'body'] = body;
      json[r'from'] = from;
      json[r'to'] = to;
      json[r'id'] = id;
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

  /// Returns a new [SendMailAdv] instance and imports its values from
  /// [json] if it's non-null, null if [json] is null.
  static SendMailAdv fromJson(Map<String, dynamic> json) => json == null
    ? null
    : SendMailAdv(
        subject: json[r'subject'],
        body: json[r'body'],
        from: SendMailAdvFrom.listFromJson(json[r'from']),
        to: MailContact.listFromJson(json[r'to']),
        id: json[r'id'],
        replyto: MailContact.listFromJson(json[r'replyto']),
        cc: MailContact.listFromJson(json[r'cc']),
        bcc: MailContact.listFromJson(json[r'bcc']),
        attachments: MailAttachment.listFromJson(json[r'attachments']),
    );

  static List<SendMailAdv> listFromJson(List<dynamic> json, {bool emptyIsNull, bool growable,}) =>
    json == null || json.isEmpty
      ? true == emptyIsNull ? null : <SendMailAdv>[]
      : json.map((v) => SendMailAdv.fromJson(v)).toList(growable: true == growable);

  static Map<String, SendMailAdv> mapFromJson(Map<String, dynamic> json) {
    final map = <String, SendMailAdv>{};
    if (json != null && json.isNotEmpty) {
      json.forEach((String key, dynamic v) => map[key] = SendMailAdv.fromJson(v));
    }
    return map;
  }

  // maps a json object with a list of SendMailAdv-objects as value to a dart map
  static Map<String, List<SendMailAdv>> mapListFromJson(Map<String, dynamic> json, {bool emptyIsNull, bool growable,}) {
    final map = <String, List<SendMailAdv>>{};
    if (json != null && json.isNotEmpty) {
      json.forEach((String key, dynamic v) {
        map[key] = SendMailAdv.listFromJson(v, emptyIsNull: emptyIsNull, growable: growable);
      });
    }
    return map;
  }
}
