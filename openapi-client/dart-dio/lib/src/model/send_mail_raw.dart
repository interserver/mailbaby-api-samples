//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:copy_with_extension/copy_with_extension.dart';
import 'package:json_annotation/json_annotation.dart';

part 'send_mail_raw.g.dart';


@CopyWith()
@JsonSerializable(
  checked: true,
  createToJson: true,
  disallowUnrecognizedKeys: false,
  explicitToJson: true,
)
class SendMailRaw {
  /// Returns a new [SendMailRaw] instance.
  SendMailRaw({

    required  this.rawEmail,

     this.id,
  });

      /// The complete RFC 822 email message including all headers and the body. Must include at minimum `From`, `To`, `Subject`, `Date`, and `MIME-Version` headers.  DKIM signatures in the `DKIM-Signature` header are transmitted verbatim and will pass verification at the destination.
  @JsonKey(
    
    name: r'raw_email',
    required: true,
    includeIfNull: false,
  )


  final String rawEmail;



      /// Optional numeric ID of the mail order to use for SMTP authentication. If omitted the first active order on your account is used.  Valid IDs are returned by `GET /mail`.
  @JsonKey(
    
    name: r'id',
    required: false,
    includeIfNull: false,
  )


  final int? id;





    @override
    bool operator ==(Object other) => identical(this, other) || other is SendMailRaw &&
      other.rawEmail == rawEmail &&
      other.id == id;

    @override
    int get hashCode =>
        rawEmail.hashCode +
        id.hashCode;

  factory SendMailRaw.fromJson(Map<String, dynamic> json) => _$SendMailRawFromJson(json);

  Map<String, dynamic> toJson() => _$SendMailRawToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }

}

