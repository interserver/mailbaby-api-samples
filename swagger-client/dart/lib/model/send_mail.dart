part of swagger.api;

class SendMail {
  /* The Contact whom is the primary recipient of this email. */
  String to = null;
/* The contact whom is the this email is from. */
  String from = null;
/* The subject or title of the email */
  String subject = null;
/* The main email contents. */
  String body = null;
/* Optional Order ID */
  int id = null;

  SendMail();

  @override
  String toString() {
    return 'SendMail[to=$to, from=$from, subject=$subject, body=$body, id=$id, ]';
  }

  SendMail.fromJson(Map<String, dynamic> json) {
    if (json == null) return;
    to = json['to'];
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
