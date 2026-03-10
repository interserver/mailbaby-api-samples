part of swagger.api;

class OneOfSendMailTo {
  
  OneOfSendMailTo();

  @override
  String toString() {
    return 'OneOfSendMailTo[]';
  }

  OneOfSendMailTo.fromJson(Map<String, dynamic> json) {
    if (json == null) return;
  }

  Map<String, dynamic> toJson() {
    return {
     };
  }

  static List<OneOfSendMailTo> listFromJson(List<dynamic> json) {
    return json == null ? new List<OneOfSendMailTo>() : json.map((value) => new OneOfSendMailTo.fromJson(value)).toList();
  }

  static Map<String, OneOfSendMailTo> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, OneOfSendMailTo>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new OneOfSendMailTo.fromJson(value));
    }
    return map;
  }
}
