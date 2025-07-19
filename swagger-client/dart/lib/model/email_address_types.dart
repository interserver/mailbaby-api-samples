part of swagger.api;

class EmailAddressTypes {
  
  EmailAddressTypes();

  @override
  String toString() {
    return 'EmailAddressTypes[]';
  }

  EmailAddressTypes.fromJson(Map<String, dynamic> json) {
    if (json == null) return;
  }

  Map<String, dynamic> toJson() {
    return {
     };
  }

  static List<EmailAddressTypes> listFromJson(List<dynamic> json) {
    return json == null ? new List<EmailAddressTypes>() : json.map((value) => new EmailAddressTypes.fromJson(value)).toList();
  }

  static Map<String, EmailAddressTypes> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, EmailAddressTypes>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new EmailAddressTypes.fromJson(value));
    }
    return map;
  }
}
