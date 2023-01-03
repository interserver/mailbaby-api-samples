part of swagger.api;

class InlineResponse200 {
  
  int id = null;

  String status = null;

  String username = null;

  String password = null;

  String comment = null;

  InlineResponse200();

  @override
  String toString() {
    return 'InlineResponse200[id=$id, status=$status, username=$username, password=$password, comment=$comment, ]';
  }

  InlineResponse200.fromJson(Map<String, dynamic> json) {
    if (json == null) return;
    id = json['id'];
    status = json['status'];
    username = json['username'];
    password = json['password'];
    comment = json['comment'];
  }

  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'status': status,
      'username': username,
      'password': password,
      'comment': comment
     };
  }

  static List<InlineResponse200> listFromJson(List<dynamic> json) {
    return json == null ? new List<InlineResponse200>() : json.map((value) => new InlineResponse200.fromJson(value)).toList();
  }

  static Map<String, InlineResponse200> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, InlineResponse200>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new InlineResponse200.fromJson(value));
    }
    return map;
  }
}
