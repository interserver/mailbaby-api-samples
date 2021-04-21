part of swagger.api;

class SendMailForm {
  
  int id = null;

  SendMailForm();

  @override
  String toString() {
    return 'SendMailForm[id=$id, ]';
  }

  SendMailForm.fromJson(Map<String, dynamic> json) {
    if (json == null) return;
    id = json['id'];
  }

  Map<String, dynamic> toJson() {
    return {
      'id': id
     };
  }

  static List<SendMailForm> listFromJson(List<dynamic> json) {
    return json == null ? new List<SendMailForm>() : json.map((value) => new SendMailForm.fromJson(value)).toList();
  }

  static Map<String, SendMailForm> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, SendMailForm>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new SendMailForm.fromJson(value));
    }
    return map;
  }
}
