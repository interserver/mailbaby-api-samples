part of swagger.api;

class AllOfSendMailAdvFrom {
  
  AllOfSendMailAdvFrom();

  @override
  String toString() {
    return 'AllOfSendMailAdvFrom[]';
  }

  AllOfSendMailAdvFrom.fromJson(Map<String, dynamic> json) {
    if (json == null) return;
  }

  Map<String, dynamic> toJson() {
    return {
     };
  }

  static List<AllOfSendMailAdvFrom> listFromJson(List<dynamic> json) {
    return json == null ? new List<AllOfSendMailAdvFrom>() : json.map((value) => new AllOfSendMailAdvFrom.fromJson(value)).toList();
  }

  static Map<String, AllOfSendMailAdvFrom> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, AllOfSendMailAdvFrom>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new AllOfSendMailAdvFrom.fromJson(value));
    }
    return map;
  }
}
