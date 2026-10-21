//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:copy_with_extension/copy_with_extension.dart';
import 'package:json_annotation/json_annotation.dart';

part 'deny_rule_new.g.dart';


@CopyWith()
@JsonSerializable(
  checked: true,
  createToJson: true,
  disallowUnrecognizedKeys: false,
  explicitToJson: true,
)
class DenyRuleNew {
  /// Returns a new [DenyRuleNew] instance.
  DenyRuleNew({

    required  this.type,

    required  this.data,

     this.user,
  });

      /// The matching strategy for this rule.  `email` blocks an exact sender address, `domain` blocks all senders at a domain, `destination` blocks an exact recipient address, and `startswith` blocks any sender whose local-part begins with the given prefix.
  @JsonKey(
    
    name: r'type',
    required: true,
    includeIfNull: false,
  unknownEnumValue: DenyRuleNewTypeEnum.unknownDefaultOpenApi,
  )


  final DenyRuleNewTypeEnum type;



      /// The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`.
  @JsonKey(
    
    name: r'data',
    required: true,
    includeIfNull: false,
  )


  final String data;



      /// Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`.
  @JsonKey(
    
    name: r'user',
    required: false,
    includeIfNull: false,
  )


  final String? user;





    @override
    bool operator ==(Object other) => identical(this, other) || other is DenyRuleNew &&
      other.type == type &&
      other.data == data &&
      other.user == user;

    @override
    int get hashCode =>
        type.hashCode +
        data.hashCode +
        user.hashCode;

  factory DenyRuleNew.fromJson(Map<String, dynamic> json) => _$DenyRuleNewFromJson(json);

  Map<String, dynamic> toJson() => _$DenyRuleNewToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }

}

/// The matching strategy for this rule.  `email` blocks an exact sender address, `domain` blocks all senders at a domain, `destination` blocks an exact recipient address, and `startswith` blocks any sender whose local-part begins with the given prefix.
enum DenyRuleNewTypeEnum {
@JsonValue(r'domain')
domain(r'domain'),
@JsonValue(r'email')
email(r'email'),
@JsonValue(r'startswith')
startswith(r'startswith'),
@JsonValue(r'destination')
destination(r'destination'),
@JsonValue(r'unknown_default_open_api')
unknownDefaultOpenApi(r'unknown_default_open_api');

const DenyRuleNewTypeEnum(this.value);

final String value;

@override
String toString() => value;
}


