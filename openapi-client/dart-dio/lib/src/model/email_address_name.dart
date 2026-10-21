//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:copy_with_extension/copy_with_extension.dart';
import 'package:json_annotation/json_annotation.dart';

part 'email_address_name.g.dart';


@CopyWith()
@JsonSerializable(
  checked: true,
  createToJson: true,
  disallowUnrecognizedKeys: false,
  explicitToJson: true,
)
class EmailAddressName {
  /// Returns a new [EmailAddressName] instance.
  EmailAddressName({

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
    bool operator ==(Object other) => identical(this, other) || other is EmailAddressName &&
      other.email == email &&
      other.name == name;

    @override
    int get hashCode =>
        email.hashCode +
        name.hashCode;

  factory EmailAddressName.fromJson(Map<String, dynamic> json) => _$EmailAddressNameFromJson(json);

  Map<String, dynamic> toJson() => _$EmailAddressNameToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }

}

