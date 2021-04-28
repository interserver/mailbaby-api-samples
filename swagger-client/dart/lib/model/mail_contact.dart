part of swagger.api;

class MailContact {
  /* The email address */
  String email = null;
/* Optional contact name */
  String name = null;

  MailContact();

  @override
  String toString() {
    return 'MailContact[email=$email, name=$name, ]';
  }

  MailContact.fromJson(Map<String, dynamic> json) {
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

  static List<MailContact> listFromJson(List<dynamic> json) {
    return json == null ? new List<MailContact>() : json.map((value) => new MailContact.fromJson(value)).toList();
  }

  static Map<String, MailContact> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, MailContact>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new MailContact.fromJson(value));
    }
    return map;
  }
}
