part of swagger.api;

class MailAttachment {
  /* The filename shown to recipients (e.g. `report.pdf`, `invoice.xlsx`). */
  String filename = null;
/* The file contents as a base64-encoded string.  Decode this to retrieve the original binary file. */
  String data = null;

  MailAttachment();

  @override
  String toString() {
    return 'MailAttachment[filename=$filename, data=$data, ]';
  }

  MailAttachment.fromJson(Map<String, dynamic> json) {
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

  static List<MailAttachment> listFromJson(List<dynamic> json) {
    return json == null ? new List<MailAttachment>() : json.map((value) => new MailAttachment.fromJson(value)).toList();
  }

  static Map<String, MailAttachment> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, MailAttachment>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new MailAttachment.fromJson(value));
    }
    return map;
  }
}
