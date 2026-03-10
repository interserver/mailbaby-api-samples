part of swagger.api;

class MailOrderDetail {
  /* The current SMTP AUTH password for this mail order.  Use with the `username` field to authenticate against `relay.mailbaby.net:25`. */
  String password = null;
/* The unique numeric ID of the mail order.  Used as the `id` parameter on sending calls, log queries, and stats queries. */
  int id = null;
/* The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send. */
  String status = null;
/* The SMTP AUTH username for this order, always in the format `mb<id>`. Use together with the password from `GET /mail/{id}` to authenticate directly against `relay.mailbaby.net:25` if needed. */
  String username = null;
/* Optional human-readable note associated with the order. */
  String comment = null;

  MailOrderDetail();

  @override
  String toString() {
    return 'MailOrderDetail[password=$password, id=$id, status=$status, username=$username, comment=$comment, ]';
  }

  MailOrderDetail.fromJson(Map<String, dynamic> json) {
    if (json == null) return;
    password = json['password'];
    id = json['id'];
    status = json['status'];
    username = json['username'];
    comment = json['comment'];
  }

  Map<String, dynamic> toJson() {
    return {
      'password': password,
      'id': id,
      'status': status,
      'username': username,
      'comment': comment
     };
  }

  static List<MailOrderDetail> listFromJson(List<dynamic> json) {
    return json == null ? new List<MailOrderDetail>() : json.map((value) => new MailOrderDetail.fromJson(value)).toList();
  }

  static Map<String, MailOrderDetail> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, MailOrderDetail>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new MailOrderDetail.fromJson(value));
    }
    return map;
  }
}
