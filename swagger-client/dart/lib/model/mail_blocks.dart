part of swagger.api;

class MailBlocks {
  /* Messages flagged by the `LOCAL_BL_RCPT` rspamd rule in the last 5 days. These are messages sent to recipients on a local block list. */
  List<MailBlockClickHouse> local = [];
/* Messages flagged by the `MBTRAP` rspamd rule in the last 5 days. These triggered MailBaby's honeypot / trap address detection. */
  List<MailBlockClickHouse> mbtrap = [];
/* Senders whose messages contained spam-indicative subjects (containing `@`, `smtp`, `socks4`, or `socks5`) with more than 4 occurrences of the same subject in the last 3 days. */
  List<MailBlockRspamd> subject = [];

  MailBlocks();

  @override
  String toString() {
    return 'MailBlocks[local=$local, mbtrap=$mbtrap, subject=$subject, ]';
  }

  MailBlocks.fromJson(Map<String, dynamic> json) {
    if (json == null) return;
    local = MailBlockClickHouse.listFromJson(json['local']);
    mbtrap = MailBlockClickHouse.listFromJson(json['mbtrap']);
    subject = MailBlockRspamd.listFromJson(json['subject']);
  }

  Map<String, dynamic> toJson() {
    return {
      'local': local,
      'mbtrap': mbtrap,
      'subject': subject
     };
  }

  static List<MailBlocks> listFromJson(List<dynamic> json) {
    return json == null ? new List<MailBlocks>() : json.map((value) => new MailBlocks.fromJson(value)).toList();
  }

  static Map<String, MailBlocks> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, MailBlocks>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new MailBlocks.fromJson(value));
    }
    return map;
  }
}
