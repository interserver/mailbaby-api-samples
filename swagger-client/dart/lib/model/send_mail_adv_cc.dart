part of swagger.api;

class SendMailAdvCc {
  /* The email address */
  String email = null;
/* (optional) Name to use for the CC contact. */
  String name = null;

  SendMailAdvCc();

  @override
  String toString() {
    return 'SendMailAdvCc[email=$email, name=$name, ]';
  }

  SendMailAdvCc.fromJson(Map<String, dynamic> json) {
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

  static List<SendMailAdvCc> listFromJson(List<dynamic> json) {
    return json == null ? new List<SendMailAdvCc>() : json.map((value) => new SendMailAdvCc.fromJson(value)).toList();
  }

  static Map<String, SendMailAdvCc> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, SendMailAdvCc>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new SendMailAdvCc.fromJson(value));
    }
    return map;
  }
}
