part of swagger.api;

class SendMailFrom {
  /* The email address */
  String email = null;
/* Optional contact name */
  String name = null;

  SendMailFrom();

  @override
  String toString() {
    return 'SendMailFrom[email=$email, name=$name, ]';
  }

  SendMailFrom.fromJson(Map<String, dynamic> json) {
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

  static List<SendMailFrom> listFromJson(List<dynamic> json) {
    return json == null ? new List<SendMailFrom>() : json.map((value) => new SendMailFrom.fromJson(value)).toList();
  }

  static Map<String, SendMailFrom> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, SendMailFrom>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new SendMailFrom.fromJson(value));
    }
    return map;
  }
}
