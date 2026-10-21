//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:copy_with_extension/copy_with_extension.dart';
import 'package:json_annotation/json_annotation.dart';

part 'mail_log_entry.g.dart';


@CopyWith()
@JsonSerializable(
  checked: true,
  createToJson: true,
  disallowUnrecognizedKeys: false,
  explicitToJson: true,
)
class MailLogEntry {
  /// Returns a new [MailLogEntry] instance.
  MailLogEntry({

    required  this.id,

    required  this.id,

    required  this.from,

    required  this.to,

    required  this.created,

    required  this.time,

    required  this.user,

    required  this.transtype,

    required  this.origin,

    required  this.interface_,

     this.subject,

     this.messageId,

     this.sendingZone,

     this.bodySize,

     this.seq,

     this.delivered,

     this.code,

     this.response,

     this.recipient,

     this.domain,

     this.locked,

     this.lockTime,

     this.assigned,

     this.queued,

     this.mxHostname,
  });

      /// Internal auto-increment database row ID.  Not meaningful outside the API.
  @JsonKey(
    
    name: r'_id',
    required: true,
    includeIfNull: false,
  )


  final int id;



      /// The relay-assigned mail ID (18–19 hex characters).  This is the value returned as `text` by the sending endpoints and accepted as the `mailid` filter on `GET /mail/log`.
  @JsonKey(
    
    name: r'id',
    required: true,
    includeIfNull: false,
  )


  final String id;



      /// SMTP envelope `MAIL FROM` address (may differ from the `From:` header).
  @JsonKey(
    
    name: r'from',
    required: true,
    includeIfNull: false,
  )


  final String from;



      /// SMTP envelope `RCPT TO` address.
  @JsonKey(
    
    name: r'to',
    required: true,
    includeIfNull: false,
  )


  final String to;



      /// Human-readable creation timestamp in `YYYY-MM-DD HH:MM:SS` format.
  @JsonKey(
    
    name: r'created',
    required: true,
    includeIfNull: false,
  )


  final String created;



      /// Unix timestamp of message acceptance.  Corresponds to the `startDate` and `endDate` filter parameters on `GET /mail/log`.
  @JsonKey(
    
    name: r'time',
    required: true,
    includeIfNull: false,
  )


  final int time;



      /// The SMTP AUTH username used to submit the message (e.g. `mb5658`). Corresponds to the `username` field in `GET /mail` orders.
  @JsonKey(
    
    name: r'user',
    required: true,
    includeIfNull: false,
  )


  final String user;



      /// SMTP transaction type negotiated with the relay (e.g. `ESMTPSA`).
  @JsonKey(
    
    name: r'transtype',
    required: true,
    includeIfNull: false,
  )


  final String transtype;



      /// IP address of the client that submitted the message to the relay. Corresponds to the `origin` filter parameter on `GET /mail/log`.
  @JsonKey(
    
    name: r'origin',
    required: true,
    includeIfNull: false,
  )


  final String origin;



      /// Relay interface name that accepted the message (e.g. `feeder`).
  @JsonKey(
    
    name: r'interface',
    required: true,
    includeIfNull: false,
  )


  final String interface_;



      /// The `Subject` header value, if available.
  @JsonKey(
    
    name: r'subject',
    required: false,
    includeIfNull: false,
  )


  final String? subject;



      /// The `Message-ID` header value, if present.  Can be used with the `messageId` filter on `GET /mail/log` for subsequent lookups.
  @JsonKey(
    
    name: r'messageId',
    required: false,
    includeIfNull: false,
  )


  final String? messageId;



      /// The sending zone assigned by the relay for outbound delivery.
  @JsonKey(
    
    name: r'sendingZone',
    required: false,
    includeIfNull: false,
  )


  final String? sendingZone;



      /// Size of the message body in bytes.
  @JsonKey(
    
    name: r'bodySize',
    required: false,
    includeIfNull: false,
  )


  final int? bodySize;



      /// Sequence index of this recipient in a multi-recipient message. Starts at 1.
  @JsonKey(
    
    name: r'seq',
    required: false,
    includeIfNull: false,
  )


  final int? seq;



      /// Delivery status flag.  `1` = successfully delivered to destination MX. `0` = queued, deferred, or failed.  `null` = delivery not yet attempted. Corresponds to the `delivered` filter parameter on `GET /mail/log`.
  @JsonKey(
    
    name: r'delivered',
    required: false,
    includeIfNull: false,
  )


  final int? delivered;



      /// The SMTP response code from the destination MX server (e.g. `250` for success, `550` for permanent failure).
  @JsonKey(
    
    name: r'code',
    required: false,
    includeIfNull: false,
  )


  final int? code;



      /// The SMTP response string received from the destination MX server upon delivery attempt (e.g. `\"250 2.0.0 Ok queued as C91D83E128C\"`).
  @JsonKey(
    
    name: r'response',
    required: false,
    includeIfNull: false,
  )


  final String? response;



      /// The specific recipient address this delivery record is for.
  @JsonKey(
    
    name: r'recipient',
    required: false,
    includeIfNull: false,
  )


  final String? recipient;



      /// The destination domain.  Corresponds to the `mx` filter parameter (which matches `mxHostname`, not `domain`) on `GET /mail/log`.
  @JsonKey(
    
    name: r'domain',
    required: false,
    includeIfNull: false,
  )


  final String? domain;



      /// Whether the queue entry is currently locked for delivery processing.
  @JsonKey(
    
    name: r'locked',
    required: false,
    includeIfNull: false,
  )


  final int? locked;



      /// Millisecond-precision timestamp of the last queue lock acquisition.
  @JsonKey(
    
    name: r'lockTime',
    required: false,
    includeIfNull: false,
  )


  final String? lockTime;



      /// The relay server node assigned to deliver this message.
  @JsonKey(
    
    name: r'assigned',
    required: false,
    includeIfNull: false,
  )


  final String? assigned;



      /// ISO 8601 timestamp when the message was placed into the delivery queue.
  @JsonKey(
    
    name: r'queued',
    required: false,
    includeIfNull: false,
  )


  final String? queued;



      /// The MX hostname the relay connected to for delivery.  Corresponds to the `mx` filter parameter on `GET /mail/log`.
  @JsonKey(
    
    name: r'mxHostname',
    required: false,
    includeIfNull: false,
  )


  final String? mxHostname;





    @override
    bool operator ==(Object other) => identical(this, other) || other is MailLogEntry &&
      other.id == id &&
      other.id == id &&
      other.from == from &&
      other.to == to &&
      other.created == created &&
      other.time == time &&
      other.user == user &&
      other.transtype == transtype &&
      other.origin == origin &&
      other.interface_ == interface_ &&
      other.subject == subject &&
      other.messageId == messageId &&
      other.sendingZone == sendingZone &&
      other.bodySize == bodySize &&
      other.seq == seq &&
      other.delivered == delivered &&
      other.code == code &&
      other.response == response &&
      other.recipient == recipient &&
      other.domain == domain &&
      other.locked == locked &&
      other.lockTime == lockTime &&
      other.assigned == assigned &&
      other.queued == queued &&
      other.mxHostname == mxHostname;

    @override
    int get hashCode =>
        id.hashCode +
        id.hashCode +
        from.hashCode +
        to.hashCode +
        created.hashCode +
        time.hashCode +
        user.hashCode +
        transtype.hashCode +
        origin.hashCode +
        interface_.hashCode +
        (subject == null ? 0 : subject.hashCode) +
        (messageId == null ? 0 : messageId.hashCode) +
        (sendingZone == null ? 0 : sendingZone.hashCode) +
        (bodySize == null ? 0 : bodySize.hashCode) +
        (seq == null ? 0 : seq.hashCode) +
        (delivered == null ? 0 : delivered.hashCode) +
        (code == null ? 0 : code.hashCode) +
        (response == null ? 0 : response.hashCode) +
        (recipient == null ? 0 : recipient.hashCode) +
        (domain == null ? 0 : domain.hashCode) +
        (locked == null ? 0 : locked.hashCode) +
        (lockTime == null ? 0 : lockTime.hashCode) +
        (assigned == null ? 0 : assigned.hashCode) +
        (queued == null ? 0 : queued.hashCode) +
        (mxHostname == null ? 0 : mxHostname.hashCode);

  factory MailLogEntry.fromJson(Map<String, dynamic> json) => _$MailLogEntryFromJson(json);

  Map<String, dynamic> toJson() => _$MailLogEntryToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }

}

