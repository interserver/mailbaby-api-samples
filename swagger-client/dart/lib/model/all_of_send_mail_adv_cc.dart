part of swagger.api;

class AllOfSendMailAdvCc {
  
  AllOfSendMailAdvCc();

  @override
  String toString() {
    return 'AllOfSendMailAdvCc[]';
  }

  AllOfSendMailAdvCc.fromJson(Map<String, dynamic> json) {
    if (json == null) return;
  }

  Map<String, dynamic> toJson() {
    return {
     };
  }

  static List<AllOfSendMailAdvCc> listFromJson(List<dynamic> json) {
    return json == null ? new List<AllOfSendMailAdvCc>() : json.map((value) => new AllOfSendMailAdvCc.fromJson(value)).toList();
  }

  static Map<String, AllOfSendMailAdvCc> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, AllOfSendMailAdvCc>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new AllOfSendMailAdvCc.fromJson(value));
    }
    return map;
  }
}
