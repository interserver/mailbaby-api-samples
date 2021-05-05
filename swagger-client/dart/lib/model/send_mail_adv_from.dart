part of swagger.api;

class SendMailAdvFrom {
  /* The email address */
  String email = null;
/* Optional contact name */
  String name = null;

  SendMailAdvFrom();

  @override
  String toString() {
    return 'SendMailAdvFrom[email=$email, name=$name, ]';
  }

  SendMailAdvFrom.fromJson(Map<String, dynamic> json) {
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

  static List<SendMailAdvFrom> listFromJson(List<dynamic> json) {
    return json == null ? new List<SendMailAdvFrom>() : json.map((value) => new SendMailAdvFrom.fromJson(value)).toList();
  }

  static Map<String, SendMailAdvFrom> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, SendMailAdvFrom>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new SendMailAdvFrom.fromJson(value));
    }
    return map;
  }
}
