part of swagger.api;

class EmailAddress {
  
  EmailAddress();

  @override
  String toString() {
    return 'EmailAddress[]';
  }

  EmailAddress.fromJson(Map<String, dynamic> json) {
    if (json == null) return;
  }

  Map<String, dynamic> toJson() {
    return {
     };
  }

  static List<EmailAddress> listFromJson(List<dynamic> json) {
    return json == null ? new List<EmailAddress>() : json.map((value) => new EmailAddress.fromJson(value)).toList();
  }

  static Map<String, EmailAddress> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, EmailAddress>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new EmailAddress.fromJson(value));
    }
    return map;
  }
}
