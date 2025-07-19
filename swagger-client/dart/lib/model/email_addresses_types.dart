part of swagger.api;

class EmailAddressesTypes {
  
  EmailAddressesTypes();

  @override
  String toString() {
    return 'EmailAddressesTypes[]';
  }

  EmailAddressesTypes.fromJson(Map<String, dynamic> json) {
    if (json == null) return;
  }

  Map<String, dynamic> toJson() {
    return {
     };
  }

  static List<EmailAddressesTypes> listFromJson(List<dynamic> json) {
    return json == null ? new List<EmailAddressesTypes>() : json.map((value) => new EmailAddressesTypes.fromJson(value)).toList();
  }

  static Map<String, EmailAddressesTypes> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, EmailAddressesTypes>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new EmailAddressesTypes.fromJson(value));
    }
    return map;
  }
}
