part of swagger.api;

class AllOfSendMailAdvTo {
  
  AllOfSendMailAdvTo();

  @override
  String toString() {
    return 'AllOfSendMailAdvTo[]';
  }

  AllOfSendMailAdvTo.fromJson(Map<String, dynamic> json) {
    if (json == null) return;
  }

  Map<String, dynamic> toJson() {
    return {
     };
  }

  static List<AllOfSendMailAdvTo> listFromJson(List<dynamic> json) {
    return json == null ? new List<AllOfSendMailAdvTo>() : json.map((value) => new AllOfSendMailAdvTo.fromJson(value)).toList();
  }

  static Map<String, AllOfSendMailAdvTo> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, AllOfSendMailAdvTo>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new AllOfSendMailAdvTo.fromJson(value));
    }
    return map;
  }
}
