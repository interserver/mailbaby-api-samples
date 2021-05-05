part of swagger.api;

class Body {
  
  SendMail payload = null;

  Body();

  @override
  String toString() {
    return 'Body[payload=$payload, ]';
  }

  Body.fromJson(Map<String, dynamic> json) {
    if (json == null) return;
    payload = new SendMail.fromJson(json['payload']);
  }

  Map<String, dynamic> toJson() {
    return {
      'payload': payload
     };
  }

  static List<Body> listFromJson(List<dynamic> json) {
    return json == null ? new List<Body>() : json.map((value) => new Body.fromJson(value)).toList();
  }

  static Map<String, Body> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, Body>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new Body.fromJson(value));
    }
    return map;
  }
}
