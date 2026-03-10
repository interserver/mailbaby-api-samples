part of swagger.api;

class MailStatsTypeVolume {
  /* Message counts keyed by destination (envelope `to`) email address. */
  Map<String, int> to = {};
/* Message counts keyed by sender (envelope `from`) email address. */
  Map<String, int> from = {};
/* Message counts keyed by originating client IP address. */
  Map<String, int> ip = {};

  MailStatsTypeVolume();

  @override
  String toString() {
    return 'MailStatsTypeVolume[to=$to, from=$from, ip=$ip, ]';
  }

  MailStatsTypeVolume.fromJson(Map<String, dynamic> json) {
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

  static List<MailStatsTypeVolume> listFromJson(List<dynamic> json) {
    return json == null ? new List<MailStatsTypeVolume>() : json.map((value) => new MailStatsTypeVolume.fromJson(value)).toList();
  }

  static Map<String, MailStatsTypeVolume> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, MailStatsTypeVolume>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new MailStatsTypeVolume.fromJson(value));
    }
    return map;
  }
}
