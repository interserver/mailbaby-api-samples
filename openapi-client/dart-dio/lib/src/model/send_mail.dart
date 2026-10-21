//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:mailbaby_client_dart_dio/src/model/send_mail_to.dart';
import 'package:copy_with_extension/copy_with_extension.dart';
import 'package:json_annotation/json_annotation.dart';

part 'send_mail.g.dart';


@CopyWith()
@JsonSerializable(
  checked: true,
  createToJson: true,
  disallowUnrecognizedKeys: false,
  explicitToJson: true,
)
class SendMail {
  /// Returns a new [SendMail] instance.
  SendMail({

    required  this.to,

    required  this.from,

    required  this.subject,

    required  this.body,

     this.id,
  });

  @JsonKey(
    
    name: r'to',
    required: true,
    includeIfNull: false,
  )


  final SendMailTo to;



      /// The sender address.  This is used as both the `From` header and the `Reply-To` header automatically.  Must be a valid email address authorized for your mail order.
  @JsonKey(
    
    name: r'from',
    required: true,
    includeIfNull: false,
  )


  final String from;



      /// The subject line of the email.
  @JsonKey(
    
    name: r'subject',
    required: true,
    includeIfNull: false,
  )


  final String subject;



      /// The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.
  @JsonKey(
    
    name: r'body',
    required: true,
    includeIfNull: false,
  )


  final String body;



      /// Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.
  @JsonKey(
    
    name: r'id',
    required: false,
    includeIfNull: false,
  )


  final int? id;





    @override
    bool operator ==(Object other) => identical(this, other) || other is SendMail &&
      other.to == to &&
      other.from == from &&
      other.subject == subject &&
      other.body == body &&
      other.id == id;

    @override
    int get hashCode =>
        to.hashCode +
        from.hashCode +
        subject.hashCode +
        body.hashCode +
        id.hashCode;

  factory SendMail.fromJson(Map<String, dynamic> json) => _$SendMailFromJson(json);

  Map<String, dynamic> toJson() => _$SendMailToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }

}

