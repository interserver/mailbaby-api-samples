part of swagger.api;

class DenyRuleRecord {
  /* The numeric ID of the deny rule, as a string.  Pass this as `ruleId` to `DELETE /mail/rules/{ruleId}` to remove the rule. */
  String id = null;
/* The timestamp when the rule was created. */
  DateTime created = null;
/* Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`. */
  String user = null;
/* The type of deny rule. */
  String type = null;
  //enum typeEnum {  domain,  email,  startswith,  destination,  };
/* The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`. */
  String data = null;

  DenyRuleRecord();

  @override
  String toString() {
    return 'DenyRuleRecord[id=$id, created=$created, user=$user, type=$type, data=$data, ]';
  }

  DenyRuleRecord.fromJson(Map<String, dynamic> json) {
    if (json == null) return;
    id = json['id'];
    created = json['created'] == null ? null : DateTime.parse(json['created']);
    user = json['user'];
    type = json['type'];
    data = json['data'];
  }

  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'created': created == null ? '' : created.toUtc().toIso8601String(),
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
