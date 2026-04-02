part of swagger.api;

class AllOfSendMailAdvReplyto {
  
  AllOfSendMailAdvReplyto();

  @override
  String toString() {
    return 'AllOfSendMailAdvReplyto[]';
  }

  AllOfSendMailAdvReplyto.fromJson(Map<String, dynamic> json) {
    if (json == null) return;
  }

  Map<String, dynamic> toJson() {
    return {
     };
  }

  static List<AllOfSendMailAdvReplyto> listFromJson(List<dynamic> json) {
    return json == null ? new List<AllOfSendMailAdvReplyto>() : json.map((value) => new AllOfSendMailAdvReplyto.fromJson(value)).toList();
  }

  static Map<String, AllOfSendMailAdvReplyto> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, AllOfSendMailAdvReplyto>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new AllOfSendMailAdvReplyto.fromJson(value));
    }
    return map;
  }
}
