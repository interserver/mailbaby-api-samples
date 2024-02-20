part of swagger.api;

class EmailAddressNames {
  
  EmailAddressNames();

  @override
  String toString() {
    return 'EmailAddressNames[]';
  }

  EmailAddressNames.fromJson(Map<String, dynamic> json) {
    if (json == null) return;
  }

  Map<String, dynamic> toJson() {
    return {
     };
  }

  static List<EmailAddressNames> listFromJson(List<dynamic> json) {
    return json == null ? new List<EmailAddressNames>() : json.map((value) => new EmailAddressNames.fromJson(value)).toList();
  }

  static Map<String, EmailAddressNames> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, EmailAddressNames>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new EmailAddressNames.fromJson(value));
    }
    return map;
  }
}
