//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:mailbaby_client_dart_dio/src/model/email_address_name.dart';
import 'package:copy_with_extension/copy_with_extension.dart';
import 'package:json_annotation/json_annotation.dart';

part 'email_address_types.g.dart';


@CopyWith()
@JsonSerializable(
  checked: true,
  createToJson: true,
  disallowUnrecognizedKeys: false,
  explicitToJson: true,
)
class EmailAddressTypes {
  /// Returns a new [EmailAddressTypes] instance.
  EmailAddressTypes({

    required  this.email,

     this.name,
  });

      /// The email address.
  @JsonKey(
    
    name: r'email',
    required: true,
    includeIfNull: false,
  )


  final String email;



      /// Optional display name shown to recipients (e.g. in the `From:` header).
  @JsonKey(
    
    name: r'name',
    required: false,
    includeIfNull: false,
  )


  final String? name;





    @override
    bool operator ==(Object other) => identical(this, other) || other is EmailAddressTypes &&
      other.email == email &&
      other.name == name;

    @override
    int get hashCode =>
        email.hashCode +
        name.hashCode;

  factory EmailAddressTypes.fromJson(Map<String, dynamic> json) => _$EmailAddressTypesFromJson(json);

  Map<String, dynamic> toJson() => _$EmailAddressTypesToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }

}

