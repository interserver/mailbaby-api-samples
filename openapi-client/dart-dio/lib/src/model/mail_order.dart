//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:copy_with_extension/copy_with_extension.dart';
import 'package:json_annotation/json_annotation.dart';

part 'mail_order.g.dart';


@CopyWith()
@JsonSerializable(
  checked: true,
  createToJson: true,
  disallowUnrecognizedKeys: false,
  explicitToJson: true,
)
class MailOrder {
  /// Returns a new [MailOrder] instance.
  MailOrder({

    required  this.id,

    required  this.status,

    required  this.username,

     this.comment,
  });

      /// The unique numeric ID of the mail order.  Used as the `id` parameter on sending calls, log queries, and stats queries.
  @JsonKey(
    
    name: r'id',
    required: true,
    includeIfNull: false,
  )


  final int id;



      /// The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send.
  @JsonKey(
    
    name: r'status',
    required: true,
    includeIfNull: false,
  unknownEnumValue: MailOrderStatusEnum.unknownDefaultOpenApi,
  )


  final MailOrderStatusEnum status;



      /// The SMTP AUTH username for this order, always in the format `mb<id>`. Use together with the password from `GET /mail/{id}` to authenticate directly against `relay.mailbaby.net:25` if needed.
  @JsonKey(
    
    name: r'username',
    required: true,
    includeIfNull: false,
  )


  final String username;



      /// Optional human-readable note associated with the order.  Only present in the response when the order has a non-empty comment.
  @JsonKey(
    
    name: r'comment',
    required: false,
    includeIfNull: false,
  )


  final String? comment;





    @override
    bool operator ==(Object other) => identical(this, other) || other is MailOrder &&
      other.id == id &&
      other.status == status &&
      other.username == username &&
      other.comment == comment;

    @override
    int get hashCode =>
        id.hashCode +
        status.hashCode +
        username.hashCode +
        comment.hashCode;

  factory MailOrder.fromJson(Map<String, dynamic> json) => _$MailOrderFromJson(json);

  Map<String, dynamic> toJson() => _$MailOrderToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }

}

/// The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send.
enum MailOrderStatusEnum {
@JsonValue(r'active')
active(r'active'),
@JsonValue(r'canceled')
canceled(r'canceled'),
@JsonValue(r'unknown_default_open_api')
unknownDefaultOpenApi(r'unknown_default_open_api');

const MailOrderStatusEnum(this.value);

final String value;

@override
String toString() => value;
}


