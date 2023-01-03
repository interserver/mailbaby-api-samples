part of swagger.api;

class SendMailAdvReplyto {
  /* The email address */
  String email = null;
/* (optional) Name to use for the sending contact. */
  String name = null;

  SendMailAdvReplyto();

  @override
  String toString() {
    return 'SendMailAdvReplyto[email=$email, name=$name, ]';
  }

  SendMailAdvReplyto.fromJson(Map<String, dynamic> json) {
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

  static List<SendMailAdvReplyto> listFromJson(List<dynamic> json) {
    return json == null ? new List<SendMailAdvReplyto>() : json.map((value) => new SendMailAdvReplyto.fromJson(value)).toList();
  }

  static Map<String, SendMailAdvReplyto> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, SendMailAdvReplyto>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new SendMailAdvReplyto.fromJson(value));
    }
    return map;
  }
}
