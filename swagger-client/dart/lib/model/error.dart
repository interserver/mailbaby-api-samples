part of swagger.api;

class Error {
  
  String code = null;

  String message = null;

  Error();

  @override
  String toString() {
    return 'Error[code=$code, message=$message, ]';
  }

  Error.fromJson(Map<String, dynamic> json) {
    if (json == null) return;
    code = json['code'];
    message = json['message'];
  }

  Map<String, dynamic> toJson() {
    return {
      'code': code,
      'message': message
     };
  }

  static List<Error> listFromJson(List<dynamic> json) {
    return json == null ? new List<Error>() : json.map((value) => new Error.fromJson(value)).toList();
  }

  static Map<String, Error> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, Error>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new Error.fromJson(value));
    }
    return map;
  }
}
