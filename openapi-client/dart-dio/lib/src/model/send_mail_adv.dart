//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:openapi/src/model/email_addresses_types.dart';
import 'package:openapi/src/model/email_address_types.dart';
import 'package:openapi/src/model/mail_attachment.dart';
import 'package:copy_with_extension/copy_with_extension.dart';
import 'package:json_annotation/json_annotation.dart';

part 'send_mail_adv.g.dart';


@CopyWith()
@JsonSerializable(
  checked: true,
  createToJson: true,
  disallowUnrecognizedKeys: false,
  explicitToJson: true,
)
class SendMailAdv {
  /// Returns a new [SendMailAdv] instance.
  SendMailAdv({

    required  this.subject,

    required  this.body,

    required  this.from,

    required  this.to,

     this.replyto,

     this.cc,

     this.bcc,

     this.attachments,

     this.id,
  });

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



      /// The sender address.  Accepts a plain email string, an RFC 822 named string (`\"Name <email>\"`), or a `{\"email\": \"...\", \"name\": \"...\"}` object.
  @JsonKey(
    
    name: r'from',
    required: true,
    includeIfNull: false,
  )


  final EmailAddressTypes from;



      /// One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.
  @JsonKey(
    
    name: r'to',
    required: true,
    includeIfNull: false,
  )


  final EmailAddressesTypes to;



      /// Optional.  One or more addresses to set as the `Reply-To` header. When recipients reply to the message their email client will address the reply to these addresses instead of `from`.
  @JsonKey(
    
    name: r'replyto',
    required: false,
    includeIfNull: false,
  )


  final EmailAddressesTypes? replyto;



      /// Optional.  Carbon-copy recipients.  These addresses are listed in the `Cc` header and are visible to all recipients.
  @JsonKey(
    
    name: r'cc',
    required: false,
    includeIfNull: false,
  )


  final EmailAddressesTypes? cc;



      /// Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.
  @JsonKey(
    
    name: r'bcc',
    required: false,
    includeIfNull: false,
  )


  final EmailAddressesTypes? bcc;



      /// Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name.
  @JsonKey(
    
    name: r'attachments',
    required: false,
    includeIfNull: false,
  )


  final List<MailAttachment>? attachments;



      /// Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.
  @JsonKey(
    
    name: r'id',
    required: false,
    includeIfNull: false,
  )


  final int? id;





    @override
    bool operator ==(Object other) => identical(this, other) || other is SendMailAdv &&
      other.subject == subject &&
      other.body == body &&
      other.from == from &&
      other.to == to &&
      other.replyto == replyto &&
      other.cc == cc &&
      other.bcc == bcc &&
      other.attachments == attachments &&
      other.id == id;

    @override
    int get hashCode =>
        subject.hashCode +
        body.hashCode +
        from.hashCode +
        to.hashCode +
        replyto.hashCode +
        cc.hashCode +
        bcc.hashCode +
        attachments.hashCode +
        id.hashCode;

  factory SendMailAdv.fromJson(Map<String, dynamic> json) => _$SendMailAdvFromJson(json);

  Map<String, dynamic> toJson() => _$SendMailAdvToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }

}

