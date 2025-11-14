part of swagger.api;

class RawMail {
  /* The entire email contents */
  String rawEmail = null;

  RawMail();

  @override
  String toString() {
    return 'RawMail[rawEmail=$rawEmail, ]';
  }

  RawMail.fromJson(Map<String, dynamic> json) {
    if (json == null) return;
    rawEmail = json['raw_email'];
  }

  Map<String, dynamic> toJson() {
    return {
      'raw_email': rawEmail
     };
  }

  static List<RawMail> listFromJson(List<dynamic> json) {
    return json == null ? new List<RawMail>() : json.map((value) => new RawMail.fromJson(value)).toList();
  }

  static Map<String, RawMail> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, RawMail>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new RawMail.fromJson(value));
    }
    return map;
  }
}
