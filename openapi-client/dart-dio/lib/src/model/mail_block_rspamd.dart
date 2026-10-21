//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:copy_with_extension/copy_with_extension.dart';
import 'package:json_annotation/json_annotation.dart';

part 'mail_block_rspamd.g.dart';


@CopyWith()
@JsonSerializable(
  checked: true,
  createToJson: true,
  disallowUnrecognizedKeys: false,
  explicitToJson: true,
)
class MailBlockRspamd {
  /// Returns a new [MailBlockRspamd] instance.
  MailBlockRspamd({

    required  this.from,

    required  this.subject,
  });

      /// The sender email address.  Pass this value as `email` to `POST /mail/blocks/delete` to delist the sender.
  @JsonKey(
    
    name: r'from',
    required: true,
    includeIfNull: false,
  )


  final String from;



      /// The suspicious subject pattern that triggered the block.
  @JsonKey(
    
    name: r'subject',
    required: true,
    includeIfNull: false,
  )


  final String subject;





    @override
    bool operator ==(Object other) => identical(this, other) || other is MailBlockRspamd &&
      other.from == from &&
      other.subject == subject;

    @override
    int get hashCode =>
        from.hashCode +
        subject.hashCode;

  factory MailBlockRspamd.fromJson(Map<String, dynamic> json) => _$MailBlockRspamdFromJson(json);

  Map<String, dynamic> toJson() => _$MailBlockRspamdToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }

}

