part of swagger.api;

class SendMailTo {
  
  SendMailTo();

  @override
  String toString() {
    return 'SendMailTo[]';
  }

  SendMailTo.fromJson(Map<String, dynamic> json) {
    if (json == null) return;
  }

  Map<String, dynamic> toJson() {
    return {
     };
  }

  static List<SendMailTo> listFromJson(List<dynamic> json) {
    return json == null ? new List<SendMailTo>() : json.map((value) => new SendMailTo.fromJson(value)).toList();
  }

  static Map<String, SendMailTo> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, SendMailTo>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new SendMailTo.fromJson(value));
    }
    return map;
  }
}
