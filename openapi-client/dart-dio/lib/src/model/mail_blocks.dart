//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:openapi/src/model/mail_block_click_house.dart';
import 'package:openapi/src/model/mail_block_rspamd.dart';
import 'package:copy_with_extension/copy_with_extension.dart';
import 'package:json_annotation/json_annotation.dart';

part 'mail_blocks.g.dart';


@CopyWith()
@JsonSerializable(
  checked: true,
  createToJson: true,
  disallowUnrecognizedKeys: false,
  explicitToJson: true,
)
class MailBlocks {
  /// Returns a new [MailBlocks] instance.
  MailBlocks({

    required  this.local,

    required  this.mbtrap,

    required  this.subject,
  });

      /// Messages flagged by the `LOCAL_BL_RCPT` rspamd rule in the last 5 days. These are messages sent to recipients on a local block list.
  @JsonKey(
    
    name: r'local',
    required: true,
    includeIfNull: false,
  )


  final List<MailBlockClickHouse> local;



      /// Messages flagged by the `MBTRAP` rspamd rule in the last 5 days. These triggered MailBaby's honeypot / trap address detection.
  @JsonKey(
    
    name: r'mbtrap',
    required: true,
    includeIfNull: false,
  )


  final List<MailBlockClickHouse> mbtrap;



      /// Senders whose messages contained spam-indicative subjects (containing `@`, `smtp`, `socks4`, or `socks5`) with more than 4 occurrences of the same subject in the last 3 days.
  @JsonKey(
    
    name: r'subject',
    required: true,
    includeIfNull: false,
  )


  final List<MailBlockRspamd> subject;





    @override
    bool operator ==(Object other) => identical(this, other) || other is MailBlocks &&
      other.local == local &&
      other.mbtrap == mbtrap &&
      other.subject == subject;

    @override
    int get hashCode =>
        local.hashCode +
        mbtrap.hashCode +
        subject.hashCode;

  factory MailBlocks.fromJson(Map<String, dynamic> json) => _$MailBlocksFromJson(json);

  Map<String, dynamic> toJson() => _$MailBlocksToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }

}

