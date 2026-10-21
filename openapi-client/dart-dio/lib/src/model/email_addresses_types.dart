//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:openapi/src/model/email_address_name.dart';
import 'package:copy_with_extension/copy_with_extension.dart';
import 'package:json_annotation/json_annotation.dart';

part 'email_addresses_types.g.dart';


@CopyWith()
@JsonSerializable(
  checked: true,
  createToJson: true,
  disallowUnrecognizedKeys: false,
  explicitToJson: true,
)
class EmailAddressesTypes {
  /// Returns a new [EmailAddressesTypes] instance.
  EmailAddressesTypes({
  });



    @override
    bool operator ==(Object other) => identical(this, other) || other is EmailAddressesTypes &&

    @override
    int get hashCode =>

  factory EmailAddressesTypes.fromJson(Map<String, dynamic> json) => _$EmailAddressesTypesFromJson(json);

  Map<String, dynamic> toJson() => _$EmailAddressesTypesToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }

}

