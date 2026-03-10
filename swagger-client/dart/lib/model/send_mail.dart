part of swagger.api;

class SendMail {
  /* The primary recipient address.  Accepts a single email address string or an array of email address strings for multiple recipients. */
  OneOfSendMailTo to = null;
/* The sender address.  This is used as both the `From` header and the `Reply-To` header automatically.  Must be a valid email address authorized for your mail order. */
  String from = null;
/* The subject line of the email. */
  String subject = null;
/* The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`. */
  String body = null;
/* Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`. */
  int id = null;

  SendMail();

  @override
  String toString() {
    return 'SendMail[to=$to, from=$from, subject=$subject, body=$body, id=$id, ]';
  }

  SendMail.fromJson(Map<String, dynamic> json) {
    if (json == null) return;
    to = new OneOfSendMailTo.fromJson(json['to']);
    from = json['from'];
    subject = json['subject'];
    body = json['body'];
    id = json['id'];
  }

  Map<String, dynamic> toJson() {
    return {
      'to': to,
      'from': from,
      'subject': subject,
      'body': body,
      'id': id
     };
  }

  static List<SendMail> listFromJson(List<dynamic> json) {
    return json == null ? new List<SendMail>() : json.map((value) => new SendMail.fromJson(value)).toList();
  }

  static Map<String, SendMail> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, SendMail>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new SendMail.fromJson(value));
    }
    return map;
  }
}
