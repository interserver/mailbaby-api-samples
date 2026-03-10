part of swagger.api;

class MailStatsType {
  /* The time window these `received`, `sent`, and `volume` statistics cover. */
  String time = null;
  //enum timeEnum {  all,  billing,  month,  7d,  24h,  day,  1h,  };
/* Total messages accepted during the current billing cycle.  Used to calculate the `cost` value. */
  int usage = null;
/* The ISO 4217 currency code for this account (e.g. `USD`). */
  String currency = null;
/* Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails). */
  double cost = null;
/* Count of messages accepted by the relay within the selected `time` window. Includes messages still in queue. */
  int received = null;
/* Count of messages successfully delivered to the destination MX within the selected `time` window.  Will be ≤ `received`. */
  int sent = null;

  MailStatsTypeVolume volume = null;

  MailStatsType();

  @override
  String toString() {
    return 'MailStatsType[time=$time, usage=$usage, currency=$currency, cost=$cost, received=$received, sent=$sent, volume=$volume, ]';
  }

  MailStatsType.fromJson(Map<String, dynamic> json) {
    if (json == null) return;
    time = json['time'];
    usage = json['usage'];
    currency = json['currency'];
    cost = json['cost'];
    received = json['received'];
    sent = json['sent'];
    volume = new MailStatsTypeVolume.fromJson(json['volume']);
  }

  Map<String, dynamic> toJson() {
    return {
      'time': time,
      'usage': usage,
      'currency': currency,
      'cost': cost,
      'received': received,
      'sent': sent,
      'volume': volume
     };
  }

  static List<MailStatsType> listFromJson(List<dynamic> json) {
    return json == null ? new List<MailStatsType>() : json.map((value) => new MailStatsType.fromJson(value)).toList();
  }

  static Map<String, MailStatsType> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, MailStatsType>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new MailStatsType.fromJson(value));
    }
    return map;
  }
}
