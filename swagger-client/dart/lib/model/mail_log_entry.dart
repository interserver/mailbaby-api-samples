part of swagger.api;

class MailLogEntry {
  /* Internal auto-increment database row ID.  Not meaningful outside the API. */
  int id = null;
/* The relay-assigned mail ID (18–19 hex characters).  This is the value returned as `text` by the sending endpoints and accepted as the `mailid` filter on `GET /mail/log`. */
  String id = null;
/* SMTP envelope `MAIL FROM` address (may differ from the `From:` header). */
  String from = null;
/* SMTP envelope `RCPT TO` address. */
  String to = null;
/* The `Subject` header value, if available. */
  String subject = null;
/* The `Message-ID` header value, if present.  Can be used with the `messageId` filter on `GET /mail/log` for subsequent lookups. */
  String messageId = null;
/* Human-readable creation timestamp in `YYYY-MM-DD HH:MM:SS` format. */
  String created = null;
/* Unix timestamp of message acceptance.  Corresponds to the `startDate` and `endDate` filter parameters on `GET /mail/log`. */
  int time = null;
/* The SMTP AUTH username used to submit the message (e.g. `mb5658`). Corresponds to the `username` field in `GET /mail` orders. */
  String user = null;
/* SMTP transaction type negotiated with the relay (e.g. `ESMTPSA`). */
  String transtype = null;
/* IP address of the client that submitted the message to the relay. Corresponds to the `origin` filter parameter on `GET /mail/log`. */
  String origin = null;
/* Relay interface name that accepted the message (e.g. `feeder`). */
  String interface = null;
/* The sending zone assigned by the relay for outbound delivery. */
  String sendingZone = null;
/* Size of the message body in bytes. */
  int bodySize = null;
/* Sequence index of this recipient in a multi-recipient message. Starts at 1. */
  int seq = null;
/* Delivery status flag.  `1` = successfully delivered to destination MX. `0` = queued, deferred, or failed.  `null` = delivery not yet attempted. Corresponds to the `delivered` filter parameter on `GET /mail/log`. */
  int delivered = null;
/* The SMTP response string received from the destination MX server upon delivery attempt (e.g. `\"250 2.0.0 Ok queued as C91D83E128C\"`). */
  String response = null;
/* The specific recipient address this delivery record is for. */
  String recipient = null;
/* The destination domain.  Corresponds to the `mx` filter parameter (which matches `mxHostname`, not `domain`) on `GET /mail/log`. */
  String domain = null;
/* Whether the queue entry is currently locked for delivery processing. */
  int locked = null;
/* Millisecond-precision timestamp of the last queue lock acquisition. */
  String lockTime = null;
/* The relay server node assigned to deliver this message. */
  String assigned = null;
/* ISO 8601 timestamp when the message was placed into the delivery queue. */
  String queued = null;
/* The MX hostname the relay connected to for delivery.  Corresponds to the `mx` filter parameter on `GET /mail/log`. */
  String mxHostname = null;

  MailLogEntry();

  @override
  String toString() {
    return 'MailLogEntry[id=$id, id=$id, from=$from, to=$to, subject=$subject, messageId=$messageId, created=$created, time=$time, user=$user, transtype=$transtype, origin=$origin, interface=$interface, sendingZone=$sendingZone, bodySize=$bodySize, seq=$seq, delivered=$delivered, response=$response, recipient=$recipient, domain=$domain, locked=$locked, lockTime=$lockTime, assigned=$assigned, queued=$queued, mxHostname=$mxHostname, ]';
  }

  MailLogEntry.fromJson(Map<String, dynamic> json) {
    if (json == null) return;
    id = json['_id'];
    id = json['id'];
    from = json['from'];
    to = json['to'];
    subject = json['subject'];
    messageId = json['messageId'];
    created = json['created'];
    time = json['time'];
    user = json['user'];
    transtype = json['transtype'];
    origin = json['origin'];
    interface = json['interface'];
    sendingZone = json['sendingZone'];
    bodySize = json['bodySize'];
    seq = json['seq'];
    delivered = json['delivered'];
    response = json['response'];
    recipient = json['recipient'];
    domain = json['domain'];
    locked = json['locked'];
    lockTime = json['lockTime'];
    assigned = json['assigned'];
    queued = json['queued'];
    mxHostname = json['mxHostname'];
  }

  Map<String, dynamic> toJson() {
    return {
      '_id': id,
      'id': id,
      'from': from,
      'to': to,
      'subject': subject,
      'messageId': messageId,
      'created': created,
      'time': time,
      'user': user,
      'transtype': transtype,
      'origin': origin,
      'interface': interface,
      'sendingZone': sendingZone,
      'bodySize': bodySize,
      'seq': seq,
      'delivered': delivered,
      'response': response,
      'recipient': recipient,
      'domain': domain,
      'locked': locked,
      'lockTime': lockTime,
      'assigned': assigned,
      'queued': queued,
      'mxHostname': mxHostname
     };
  }

  static List<MailLogEntry> listFromJson(List<dynamic> json) {
    return json == null ? new List<MailLogEntry>() : json.map((value) => new MailLogEntry.fromJson(value)).toList();
  }

  static Map<String, MailLogEntry> mapFromJson(Map<String, Map<String, dynamic>> json) {
    var map = new Map<String, MailLogEntry>();
    if (json != null && json.length > 0) {
      json.forEach((String key, Map<String, dynamic> value) => map[key] = new MailLogEntry.fromJson(value));
    }
    return map;
  }
}
