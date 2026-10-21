//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:copy_with_extension/copy_with_extension.dart';
import 'package:json_annotation/json_annotation.dart';

part 'mail_block_click_house.g.dart';


@CopyWith()
@JsonSerializable(
  checked: true,
  createToJson: true,
  disallowUnrecognizedKeys: false,
  explicitToJson: true,
)
class MailBlockClickHouse {
  /// Returns a new [MailBlockClickHouse] instance.
  MailBlockClickHouse({

    required  this.date,

    required  this.from,

    required  this.subject,

    required  this.to,

     this.messageId,
  });

      /// The date the block event was recorded.
  @JsonKey(
    
    name: r'date',
    required: true,
    includeIfNull: false,
  )


  final DateTime date;



      /// The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it.
  @JsonKey(
    
    name: r'from',
    required: true,
    includeIfNull: false,
  )


  final String from;



      /// The `Subject` header of the blocked message.
  @JsonKey(
    
    name: r'subject',
    required: true,
    includeIfNull: false,
  )


  final String subject;



      /// The serialized list of recipients of the blocked message.
  @JsonKey(
    
    name: r'to',
    required: true,
    includeIfNull: false,
  )


  final String to;



      /// The `Message-ID` header of the blocked message, or `null` if not present.
  @JsonKey(
    
    name: r'messageId',
    required: false,
    includeIfNull: false,
  )


  final String? messageId;





    @override
    bool operator ==(Object other) => identical(this, other) || other is MailBlockClickHouse &&
      other.date == date &&
      other.from == from &&
      other.subject == subject &&
      other.to == to &&
      other.messageId == messageId;

    @override
    int get hashCode =>
        date.hashCode +
        from.hashCode +
        subject.hashCode +
        to.hashCode +
        (messageId == null ? 0 : messageId.hashCode);

  factory MailBlockClickHouse.fromJson(Map<String, dynamic> json) => _$MailBlockClickHouseFromJson(json);

  Map<String, dynamic> toJson() => _$MailBlockClickHouseToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }

}

