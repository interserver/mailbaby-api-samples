part of swagger.api;

class ErrorResponse {
  
  String code = null;

  String message = null;

  ErrorResponse();

  @override
  String toString() {
    return 'ErrorResponse[code=$code, message=$message, ]';
  }

  ErrorResponse.fromJson(Map<String, dynamic> json) {
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

  static List<ErrorResponse> listFromJson(List<dynamic> json) {
    return json == null ? new List<ErrorResponse>() : json.map((value) => new ErrorResponse.fromJson(value)).toList();
  }

  static Map<String, ErrorResponse> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, ErrorResponse>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new ErrorResponse.fromJson(value));
    }
    return map;
  }
}
