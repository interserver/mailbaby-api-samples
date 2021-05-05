part of swagger.api;

class SendMailAdv {
  /* The subject or title of the email */
  String subject = null;
/* The main email contents. */
  String body = null;
/* The contact whom is the this email is from. */
  List<SendMailAdvFrom> from = [];
/* The Contact whom is the primary recipient of this email. */
  List<MailContact> to = [];
/* The ID of the Mail order within our system to use as the Mail Account. */
  int id = null;
/* Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address. */
  List<MailContact> replyto = [];
/* Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. */
  List<MailContact> cc = [];
/* Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. */
  List<MailContact> bcc = [];
/* Optional file attachments to include in the email */
  List<MailAttachment> attachments = [];

  SendMailAdv();

  @override
  String toString() {
    return 'SendMailAdv[subject=$subject, body=$body, from=$from, to=$to, id=$id, replyto=$replyto, cc=$cc, bcc=$bcc, attachments=$attachments, ]';
  }

  SendMailAdv.fromJson(Map<String, dynamic> json) {
    if (json == null) return;
    subject = json['subject'];
    body = json['body'];
    from = SendMailAdvFrom.listFromJson(json['from']);
    to = MailContact.listFromJson(json['to']);
    id = json['id'];
    replyto = MailContact.listFromJson(json['replyto']);
    cc = MailContact.listFromJson(json['cc']);
    bcc = MailContact.listFromJson(json['bcc']);
    attachments = MailAttachment.listFromJson(json['attachments']);
  }

  Map<String, dynamic> toJson() {
    return {
      'subject': subject,
      'body': body,
      'from': from,
      'to': to,
      'id': id,
      'replyto': replyto,
      'cc': cc,
      'bcc': bcc,
      'attachments': attachments
     };
  }

  static List<SendMailAdv> listFromJson(List<dynamic> json) {
    return json == null ? new List<SendMailAdv>() : json.map((value) => new SendMailAdv.fromJson(value)).toList();
  }

  static Map<String, SendMailAdv> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, SendMailAdv>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new SendMailAdv.fromJson(value));
    }
    return map;
  }
}
