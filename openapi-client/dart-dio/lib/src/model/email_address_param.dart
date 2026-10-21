//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:copy_with_extension/copy_with_extension.dart';
import 'package:json_annotation/json_annotation.dart';

part 'email_address_param.g.dart';


@CopyWith()
@JsonSerializable(
  checked: true,
  createToJson: true,
  disallowUnrecognizedKeys: false,
  explicitToJson: true,
)
class EmailAddressParam {
  /// Returns a new [EmailAddressParam] instance.
  EmailAddressParam({

    required  this.email,
  });

      /// The email address to delist from all block lists.
  @JsonKey(
    
    name: r'email',
    required: true,
    includeIfNull: false,
  )


  final String email;





    @override
    bool operator ==(Object other) => identical(this, other) || other is EmailAddressParam &&
      other.email == email;

    @override
    int get hashCode =>
        email.hashCode;

  factory EmailAddressParam.fromJson(Map<String, dynamic> json) => _$EmailAddressParamFromJson(json);

  Map<String, dynamic> toJson() => _$EmailAddressParamToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }

}

