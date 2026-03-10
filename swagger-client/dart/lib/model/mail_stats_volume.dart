part of swagger.api;

class MailStatsVolume {
  /* Message counts keyed by destination (envelope `to`) email address. */
  Map<String, int> to = {};
/* Message counts keyed by sender (envelope `from`) email address. */
  Map<String, int> from = {};
/* Message counts keyed by originating client IP address. */
  Map<String, int> ip = {};

  MailStatsVolume();

  @override
  String toString() {
    return 'MailStatsVolume[to=$to, from=$from, ip=$ip, ]';
  }

  MailStatsVolume.fromJson(Map<String, dynamic> json) {
    if (json == null) return;
    to = json['to'];
    from = json['from'];
    ip = json['ip'];
  }

  Map<String, dynamic> toJson() {
    return {
      'to': to,
      'from': from,
      'ip': ip
     };
  }

  static List<MailStatsVolume> listFromJson(List<dynamic> json) {
    return json == null ? new List<MailStatsVolume>() : json.map((value) => new MailStatsVolume.fromJson(value)).toList();
  }

  static Map<String, MailStatsVolume> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, MailStatsVolume>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new MailStatsVolume.fromJson(value));
    }
    return map;
  }
}
