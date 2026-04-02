part of swagger.api;

class DateOrTimestamp {
  
  DateOrTimestamp();

  @override
  String toString() {
    return 'DateOrTimestamp[]';
  }

  DateOrTimestamp.fromJson(Map<String, dynamic> json) {
    if (json == null) return;
  }

  Map<String, dynamic> toJson() {
    return {
     };
  }

  static List<DateOrTimestamp> listFromJson(List<dynamic> json) {
    return json == null ? new List<DateOrTimestamp>() : json.map((value) => new DateOrTimestamp.fromJson(value)).toList();
  }

  static Map<String, DateOrTimestamp> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, DateOrTimestamp>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new DateOrTimestamp.fromJson(value));
    }
    return map;
  }
}
