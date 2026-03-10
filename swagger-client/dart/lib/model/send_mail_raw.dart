part of swagger.api;

class SendMailRaw {
  /* The complete RFC 822 email message including all headers and the body. Must include at minimum `From`, `To`, `Subject`, `Date`, and `MIME-Version` headers.  DKIM signatures in the `DKIM-Signature` header are transmitted verbatim and will pass verification at the destination. */
  String rawEmail = null;
/* Optional numeric ID of the mail order to use for SMTP authentication. If omitted the first active order on your account is used.  Valid IDs are returned by `GET /mail`. */
  int id = null;

  SendMailRaw();

  @override
  String toString() {
    return 'SendMailRaw[rawEmail=$rawEmail, id=$id, ]';
  }

  SendMailRaw.fromJson(Map<String, dynamic> json) {
    if (json == null) return;
    rawEmail = json['raw_email'];
    id = json['id'];
  }

  Map<String, dynamic> toJson() {
    return {
      'raw_email': rawEmail,
      'id': id
     };
  }

  static List<SendMailRaw> listFromJson(List<dynamic> json) {
    return json == null ? new List<SendMailRaw>() : json.map((value) => new SendMailRaw.fromJson(value)).toList();
  }

  static Map<String, SendMailRaw> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, SendMailRaw>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new SendMailRaw.fromJson(value));
    }
    return map;
  }
}
