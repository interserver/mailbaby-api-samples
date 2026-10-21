//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:copy_with_extension/copy_with_extension.dart';
import 'package:json_annotation/json_annotation.dart';

part 'send_mail_to.g.dart';


@CopyWith()
@JsonSerializable(
  checked: true,
  createToJson: true,
  disallowUnrecognizedKeys: false,
  explicitToJson: true,
)
class SendMailTo {
  /// Returns a new [SendMailTo] instance.
  SendMailTo({
  });



    @override
    bool operator ==(Object other) => identical(this, other) || other is SendMailTo &&

    @override
    int get hashCode =>

  factory SendMailTo.fromJson(Map<String, dynamic> json) => _$SendMailToFromJson(json);

  Map<String, dynamic> toJson() => _$SendMailToToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }

}

