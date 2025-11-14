part of swagger.api;

class SendMailRaw {
  /* The entire email contents */
  String rawEmail = null;
/* Optional order id */
  int id = null;

  SendMailRaw();

  @override
  String toString() {
    return 'SendMailRaw[rawEmail=$rawEmail, id=$id, ]';
  }

  SendMailRaw.fromJson(Map<String, dynamic> json) {
    if (json == null) return;
    rawEmail = json['raw_email'];
    id = json['id'];
  }

  Map<String, dynamic> toJson() {
    return {
      'raw_email': rawEmail,
      'id': id
     };
  }

  static List<SendMailRaw> listFromJson(List<dynamic> json) {
    return json == null ? new List<SendMailRaw>() : json.map((value) => new SendMailRaw.fromJson(value)).toList();
  }

  static Map<String, SendMailRaw> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, SendMailRaw>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new SendMailRaw.fromJson(value));
    }
    return map;
  }
}
