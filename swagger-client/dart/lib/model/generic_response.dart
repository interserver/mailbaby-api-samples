part of swagger.api;

class GenericResponse {
  /* Always `\"ok\"` on success. */
  String status = null;
/* Operation-specific result string.  For send operations this is the relay transaction ID (e.g. `185caa69ff7000f47c`) which can be used as the `mailid` parameter in `GET /mail/log`.  For create operations this is the new record's numeric ID.  For delete operations this is a human-readable confirmation. */
  String text = null;

  GenericResponse();

  @override
  String toString() {
    return 'GenericResponse[status=$status, text=$text, ]';
  }

  GenericResponse.fromJson(Map<String, dynamic> json) {
    if (json == null) return;
    status = json['status'];
    text = json['text'];
  }

  Map<String, dynamic> toJson() {
    return {
      'status': status,
      'text': text
     };
  }

  static List<GenericResponse> listFromJson(List<dynamic> json) {
    return json == null ? new List<GenericResponse>() : json.map((value) => new GenericResponse.fromJson(value)).toList();
  }

  static Map<String, GenericResponse> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, GenericResponse>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new GenericResponse.fromJson(value));
    }
    return map;
  }
}
