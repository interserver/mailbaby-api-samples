part of swagger.api;

class DenyRuleRecord {
  /* Mail account username that will be tied to this rule.  If not specified the first active mail order will be used. */
  String user = null;
/* The type of deny rule. */
  String type = null;
  //enum typeEnum {  domain,  email,  startswith,  };
/* The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com. */
  String data = null;

  DenyRuleRecord();

  @override
  String toString() {
    return 'DenyRuleRecord[user=$user, type=$type, data=$data, ]';
  }

  DenyRuleRecord.fromJson(Map<String, dynamic> json) {
    if (json == null) return;
    user = json['user'];
    type = json['type'];
    data = json['data'];
  }

  Map<String, dynamic> toJson() {
    return {
      'user': user,
      'type': type,
      'data': data
     };
  }

  static List<DenyRuleRecord> listFromJson(List<dynamic> json) {
    return json == null ? new List<DenyRuleRecord>() : json.map((value) => new DenyRuleRecord.fromJson(value)).toList();
  }

  static Map<String, DenyRuleRecord> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, DenyRuleRecord>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new DenyRuleRecord.fromJson(value));
    }
    return map;
  }
}
