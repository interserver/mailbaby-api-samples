part of swagger.api;

class SendMailAdvAttachments {
  /* (optional) Filename to specify for the attachment. */
  String filename = null;
/* Contents of the attached file (must be base64 encoded) */
  String data = null;

  SendMailAdvAttachments();

  @override
  String toString() {
    return 'SendMailAdvAttachments[filename=$filename, data=$data, ]';
  }

  SendMailAdvAttachments.fromJson(Map<String, dynamic> json) {
    if (json == null) return;
    filename = json['filename'];
    data = json['data'];
  }

  Map<String, dynamic> toJson() {
    return {
      'filename': filename,
      'data': data
     };
  }

  static List<SendMailAdvAttachments> listFromJson(List<dynamic> json) {
    return json == null ? new List<SendMailAdvAttachments>() : json.map((value) => new SendMailAdvAttachments.fromJson(value)).toList();
  }

  static Map<String, SendMailAdvAttachments> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, SendMailAdvAttachments>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new SendMailAdvAttachments.fromJson(value));
    }
    return map;
  }
}
