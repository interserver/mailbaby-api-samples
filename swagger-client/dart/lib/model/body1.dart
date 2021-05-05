part of swagger.api;

class Body1 {
  /* The Contact whom is the primary recipient of this email. */
  String to = null;
/* The contact whom is the this email is from. */
  String from = null;
/* The subject or title of the email */
  String subject = null;
/* The main email contents. */
  String body = null;

  Body1();

  @override
  String toString() {
    return 'Body1[to=$to, from=$from, subject=$subject, body=$body, ]';
  }

  Body1.fromJson(Map<String, dynamic> json) {
    if (json == null) return;
    to = json['to'];
    from = json['from'];
    subject = json['subject'];
    body = json['body'];
  }

  Map<String, dynamic> toJson() {
    return {
      'to': to,
      'from': from,
      'subject': subject,
      'body': body
     };
  }

  static List<Body1> listFromJson(List<dynamic> json) {
    return json == null ? new List<Body1>() : json.map((value) => new Body1.fromJson(value)).toList();
  }

  static Map<String, Body1> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, Body1>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new Body1.fromJson(value));
    }
    return map;
  }
}
