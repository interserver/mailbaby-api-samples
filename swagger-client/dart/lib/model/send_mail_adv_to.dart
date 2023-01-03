part of swagger.api;

class SendMailAdvTo {
  /* The email address */
  String email = null;
/* (optional) Name to use for the destination contact. */
  String name = null;

  SendMailAdvTo();

  @override
  String toString() {
    return 'SendMailAdvTo[email=$email, name=$name, ]';
  }

  SendMailAdvTo.fromJson(Map<String, dynamic> json) {
    if (json == null) return;
    email = json['email'];
    name = json['name'];
  }

  Map<String, dynamic> toJson() {
    return {
      'email': email,
      'name': name
     };
  }

  static List<SendMailAdvTo> listFromJson(List<dynamic> json) {
    return json == null ? new List<SendMailAdvTo>() : json.map((value) => new SendMailAdvTo.fromJson(value)).toList();
  }

  static Map<String, SendMailAdvTo> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, SendMailAdvTo>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new SendMailAdvTo.fromJson(value));
    }
    return map;
  }
}
