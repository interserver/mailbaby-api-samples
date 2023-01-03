part of swagger.api;

class SendMailAdvBcc {
  /* The email address */
  String email = null;
/* (optional) Name to use for the BCC contact. */
  String name = null;

  SendMailAdvBcc();

  @override
  String toString() {
    return 'SendMailAdvBcc[email=$email, name=$name, ]';
  }

  SendMailAdvBcc.fromJson(Map<String, dynamic> json) {
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

  static List<SendMailAdvBcc> listFromJson(List<dynamic> json) {
    return json == null ? new List<SendMailAdvBcc>() : json.map((value) => new SendMailAdvBcc.fromJson(value)).toList();
  }

  static Map<String, SendMailAdvBcc> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, SendMailAdvBcc>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new SendMailAdvBcc.fromJson(value));
    }
    return map;
  }
}
