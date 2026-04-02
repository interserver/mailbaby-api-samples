part of swagger.api;

class SendMailAdv {
  /* The subject line of the email. */
  String subject = null;
/* The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`. */
  String body = null;
/* The sender address.  Accepts a plain email string, an RFC 822 named string (`\"Name <email>\"`), or a `{\"email\": \"...\", \"name\": \"...\"}` object. */
  AllOfSendMailAdvFrom from = null;
/* One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects. */
  AllOfSendMailAdvTo to = null;
/* Optional.  One or more addresses to set as the `Reply-To` header. When recipients reply to the message their email client will address the reply to these addresses instead of `from`. */
  AllOfSendMailAdvReplyto replyto = null;
/* Optional.  Carbon-copy recipients.  These addresses are listed in the `Cc` header and are visible to all recipients. */
  AllOfSendMailAdvCc cc = null;
/* Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header. */
  AllOfSendMailAdvBcc bcc = null;
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
    from = new AllOfSendMailAdvFrom.fromJson(json['from']);
    to = new AllOfSendMailAdvTo.fromJson(json['to']);
    replyto = new AllOfSendMailAdvReplyto.fromJson(json['replyto']);
    cc = new AllOfSendMailAdvCc.fromJson(json['cc']);
    bcc = new AllOfSendMailAdvBcc.fromJson(json['bcc']);
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
