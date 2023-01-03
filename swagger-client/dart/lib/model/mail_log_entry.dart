part of swagger.api;

class MailLogEntry {
  /* internal db id */
  int id = null;
/* mail id */
  String id = null;
/* from address */
  String from = null;
/* to address */
  String to = null;
/* email subject */
  String subject = null;
/* message id */
  String messageId = null;
/* creation date */
  String created = null;
/* creation timestamp */
  int time = null;
/* user account */
  String user = null;
/* transaction type */
  String transtype = null;
/* transaction host */
  String transhost = null;
/* origin host */
  String originhost = null;
/* origin ip */
  String origin = null;
/* interface name */
  String interface = null;
/* date processed */
  String date = null;
/* sending zone */
  String sendingZone = null;
/* email body size in bytes */
  int bodySize = null;
/* md5 sum of the email */
  String sourceMd5 = null;
/* delivery sequency */
  int seq = null;
/* to address domain */
  String domain = null;
/* email receiver address */
  String recipient = null;
/* locked status */
  int locked = null;
/* lock timestamp */
  int lockTime = null;
/* assigned server */
  String assigned = null;
/* queued timestamp */
  String queued = null;
/* lock id */
  String lock = null;
/* logger */
  String logger = null;
/* mx port number */
  int mxPort = null;
/* connection key */
  String connectionKey = null;
/* mx hostname */
  String mxHostname = null;
/* body hash */
  String sentBodyHash = null;
/* sent body size in bytes */
  int sentBodySize = null;
/* md5 checksum matching result */
  int md5Match = null;

  MailLogEntry();

  @override
  String toString() {
    return 'MailLogEntry[id=$id, id=$id, from=$from, to=$to, subject=$subject, messageId=$messageId, created=$created, time=$time, user=$user, transtype=$transtype, transhost=$transhost, originhost=$originhost, origin=$origin, interface=$interface, date=$date, sendingZone=$sendingZone, bodySize=$bodySize, sourceMd5=$sourceMd5, seq=$seq, domain=$domain, recipient=$recipient, locked=$locked, lockTime=$lockTime, assigned=$assigned, queued=$queued, lock=$lock, logger=$logger, mxPort=$mxPort, connectionKey=$connectionKey, mxHostname=$mxHostname, sentBodyHash=$sentBodyHash, sentBodySize=$sentBodySize, md5Match=$md5Match, ]';
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
    transhost = json['transhost'];
    originhost = json['originhost'];
    origin = json['origin'];
    interface = json['interface'];
    date = json['date'];
    sendingZone = json['sendingZone'];
    bodySize = json['bodySize'];
    sourceMd5 = json['sourceMd5'];
    seq = json['seq'];
    domain = json['domain'];
    recipient = json['recipient'];
    locked = json['locked'];
    lockTime = json['lockTime'];
    assigned = json['assigned'];
    queued = json['queued'];
    lock = json['_lock'];
    logger = json['logger'];
    mxPort = json['mxPort'];
    connectionKey = json['connectionKey'];
    mxHostname = json['mxHostname'];
    sentBodyHash = json['sentBodyHash'];
    sentBodySize = json['sentBodySize'];
    md5Match = json['md5Match'];
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
      'transhost': transhost,
      'originhost': originhost,
      'origin': origin,
      'interface': interface,
      'date': date,
      'sendingZone': sendingZone,
      'bodySize': bodySize,
      'sourceMd5': sourceMd5,
      'seq': seq,
      'domain': domain,
      'recipient': recipient,
      'locked': locked,
      'lockTime': lockTime,
      'assigned': assigned,
      'queued': queued,
      '_lock': lock,
      'logger': logger,
      'mxPort': mxPort,
      'connectionKey': connectionKey,
      'mxHostname': mxHostname,
      'sentBodyHash': sentBodyHash,
      'sentBodySize': sentBodySize,
      'md5Match': md5Match
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
