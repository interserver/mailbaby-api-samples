part of swagger.api;

class Body {
  /* The Subject of the email */
  String subject = null;
/* The contents of the email */
  String body = null;
/* The email address of who this email will be sent from. */
  String from = null;
/* The email address of who this email will be sent to. */
  String to = null;
/* The ID of your mail order this will be sent through. */
  int id = null;
/* The name or title of who this email is being sent to. */
  String toName = null;
/* The name or title of who this email is being sent from. */
  String fromName = null;

  Body();

  @override
  String toString() {
    return 'Body[subject=$subject, body=$body, from=$from, to=$to, id=$id, toName=$toName, fromName=$fromName, ]';
  }

  Body.fromJson(Map<String, dynamic> json) {
    if (json == null) return;
    subject = json['subject'];
    body = json['body'];
    from = json['from'];
    to = json['to'];
    id = json['id'];
    toName = json['toName'];
    fromName = json['fromName'];
  }

  Map<String, dynamic> toJson() {
    return {
      'subject': subject,
      'body': body,
      'from': from,
      'to': to,
      'id': id,
      'toName': toName,
      'fromName': fromName
     };
  }

  static List<Body> listFromJson(List<dynamic> json) {
    return json == null ? new List<Body>() : json.map((value) => new Body.fromJson(value)).toList();
  }

  static Map<String, Body> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, Body>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new Body.fromJson(value));
    }
    return map;
  }
}
