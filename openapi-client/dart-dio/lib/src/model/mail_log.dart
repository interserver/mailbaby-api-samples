//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:mailbaby_client_dart_dio/src/model/mail_log_entry.dart';
import 'package:copy_with_extension/copy_with_extension.dart';
import 'package:json_annotation/json_annotation.dart';

part 'mail_log.g.dart';


@CopyWith()
@JsonSerializable(
  checked: true,
  createToJson: true,
  disallowUnrecognizedKeys: false,
  explicitToJson: true,
)
class MailLog {
  /// Returns a new [MailLog] instance.
  MailLog({

    required  this.total,

    required  this.skip,

    required  this.limit,

    required  this.emails,
  });

      /// Total number of log entries that match the supplied filters, regardless of `skip` and `limit`.  Use this to calculate the number of pages: `ceil(total / limit)`.
  @JsonKey(
    
    name: r'total',
    required: true,
    includeIfNull: false,
  )


  final int total;



      /// The `skip` value used for this page (echoed from the request).
  @JsonKey(
    
    name: r'skip',
    required: true,
    includeIfNull: false,
  )


  final int skip;



      /// The `limit` value used for this page (echoed from the request).
  @JsonKey(
    
    name: r'limit',
    required: true,
    includeIfNull: false,
  )


  final int limit;



  @JsonKey(
    
    name: r'emails',
    required: true,
    includeIfNull: false,
  )


  final List<MailLogEntry> emails;





    @override
    bool operator ==(Object other) => identical(this, other) || other is MailLog &&
      other.total == total &&
      other.skip == skip &&
      other.limit == limit &&
      other.emails == emails;

    @override
    int get hashCode =>
        total.hashCode +
        skip.hashCode +
        limit.hashCode +
        emails.hashCode;

  factory MailLog.fromJson(Map<String, dynamic> json) => _$MailLogFromJson(json);

  Map<String, dynamic> toJson() => _$MailLogToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }

}

