//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:copy_with_extension/copy_with_extension.dart';
import 'package:json_annotation/json_annotation.dart';

part 'deny_rule_record.g.dart';


@CopyWith()
@JsonSerializable(
  checked: true,
  createToJson: true,
  disallowUnrecognizedKeys: false,
  explicitToJson: true,
)
class DenyRuleRecord {
  /// Returns a new [DenyRuleRecord] instance.
  DenyRuleRecord({

    required  this.type,

    required  this.data,

    required  this.id,

    required  this.created,

     this.user,
  });

      /// The matching strategy for this rule.  `email` blocks an exact sender address, `domain` blocks all senders at a domain, `destination` blocks an exact recipient address, and `startswith` blocks any sender whose local-part begins with the given prefix.
  @JsonKey(
    
    name: r'type',
    required: true,
    includeIfNull: false,
  unknownEnumValue: DenyRuleRecordTypeEnum.unknownDefaultOpenApi,
  )


  final DenyRuleRecordTypeEnum type;



      /// The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`.
  @JsonKey(
    
    name: r'data',
    required: true,
    includeIfNull: false,
  )


  final String data;



      /// The numeric ID of the deny rule, as a string.  Pass this as `ruleId` to `DELETE /mail/rules/{ruleId}` to remove the rule.
  @JsonKey(
    
    name: r'id',
    required: true,
    includeIfNull: false,
  )


  final String id;



      /// The timestamp when the rule was created.
  @JsonKey(
    
    name: r'created',
    required: true,
    includeIfNull: false,
  )


  final DateTime created;



      /// Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`.
  @JsonKey(
    
    name: r'user',
    required: false,
    includeIfNull: false,
  )


  final String? user;





    @override
    bool operator ==(Object other) => identical(this, other) || other is DenyRuleRecord &&
      other.type == type &&
      other.data == data &&
      other.id == id &&
      other.created == created &&
      other.user == user;

    @override
    int get hashCode =>
        type.hashCode +
        data.hashCode +
        id.hashCode +
        created.hashCode +
        user.hashCode;

  factory DenyRuleRecord.fromJson(Map<String, dynamic> json) => _$DenyRuleRecordFromJson(json);

  Map<String, dynamic> toJson() => _$DenyRuleRecordToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }

}

/// The matching strategy for this rule.  `email` blocks an exact sender address, `domain` blocks all senders at a domain, `destination` blocks an exact recipient address, and `startswith` blocks any sender whose local-part begins with the given prefix.
enum DenyRuleRecordTypeEnum {
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

const DenyRuleRecordTypeEnum(this.value);

final String value;

@override
String toString() => value;
}


