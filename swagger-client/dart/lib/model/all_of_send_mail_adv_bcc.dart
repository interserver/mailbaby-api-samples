part of swagger.api;

class AllOfSendMailAdvBcc {
  
  AllOfSendMailAdvBcc();

  @override
  String toString() {
    return 'AllOfSendMailAdvBcc[]';
  }

  AllOfSendMailAdvBcc.fromJson(Map<String, dynamic> json) {
    if (json == null) return;
  }

  Map<String, dynamic> toJson() {
    return {
     };
  }

  static List<AllOfSendMailAdvBcc> listFromJson(List<dynamic> json) {
    return json == null ? new List<AllOfSendMailAdvBcc>() : json.map((value) => new AllOfSendMailAdvBcc.fromJson(value)).toList();
  }

  static Map<String, AllOfSendMailAdvBcc> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, AllOfSendMailAdvBcc>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new AllOfSendMailAdvBcc.fromJson(value));
    }
    return map;
  }
}
