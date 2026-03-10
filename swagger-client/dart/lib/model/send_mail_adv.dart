part of swagger.api;

class SendMailAdv {
  /* The subject line of the email. */
  String subject = null;
/* The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`. */
  String body = null;

  EmailAddressTypes from = null;

  EmailAddressesTypes to = null;

  EmailAddressesTypes replyto = null;

  EmailAddressesTypes cc = null;

  EmailAddressesTypes bcc = null;
/* Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name. */
  List<MailAttachment> attachments = [];
/* Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`. */
  int id = null;

  SendMailAdv();

  @override
  String toString() {
    return 'SendMailAdv[subject=$subject, body=$body, from=$from, to=$to, replyto=$replyto, cc=$cc, bcc=$bcc, attachments=$attachments, id=$id, ]';
  }

  SendMailAdv.fromJson(Map<String, dynamic> json) {
    if (json == null) return;
    subject = json['subject'];
    body = json['body'];
    from = new EmailAddressTypes.fromJson(json['from']);
    to = new EmailAddressesTypes.fromJson(json['to']);
    replyto = new EmailAddressesTypes.fromJson(json['replyto']);
    cc = new EmailAddressesTypes.fromJson(json['cc']);
    bcc = new EmailAddressesTypes.fromJson(json['bcc']);
    attachments = MailAttachment.listFromJson(json['attachments']);
    id = json['id'];
  }

  Map<String, dynamic> toJson() {
    return {
      'subject': subject,
      'body': body,
      'from': from,
      'to': to,
      'replyto': replyto,
      'cc': cc,
      'bcc': bcc,
      'attachments': attachments,
      'id': id
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
