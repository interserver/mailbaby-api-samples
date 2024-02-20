part of swagger.api;

class ErrorMessage {
  /* The response code associated with the error. */
  int code = null;
/* The details or description of the error. */
  String message = null;

  ErrorMessage();

  @override
  String toString() {
    return 'ErrorMessage[code=$code, message=$message, ]';
  }

  ErrorMessage.fromJson(Map<String, dynamic> json) {
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

  static List<ErrorMessage> listFromJson(List<dynamic> json) {
    return json == null ? new List<ErrorMessage>() : json.map((value) => new ErrorMessage.fromJson(value)).toList();
  }

  static Map<String, ErrorMessage> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, ErrorMessage>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new ErrorMessage.fromJson(value));
    }
    return map;
  }
}
