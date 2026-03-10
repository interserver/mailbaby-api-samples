part of swagger.api;

class EmailAddressParam {
  /* The email address to delist from all block lists. */
  String email = null;

  EmailAddressParam();

  @override
  String toString() {
    return 'EmailAddressParam[email=$email, ]';
  }

  EmailAddressParam.fromJson(Map<String, dynamic> json) {
    if (json == null) return;
    email = json['email'];
  }

  Map<String, dynamic> toJson() {
    return {
      'email': email
     };
  }

  static List<EmailAddressParam> listFromJson(List<dynamic> json) {
    return json == null ? new List<EmailAddressParam>() : json.map((value) => new EmailAddressParam.fromJson(value)).toList();
  }

  static Map<String, EmailAddressParam> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, EmailAddressParam>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new EmailAddressParam.fromJson(value));
    }
    return map;
  }
}
