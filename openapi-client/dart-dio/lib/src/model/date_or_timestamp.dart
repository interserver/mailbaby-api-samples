//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:copy_with_extension/copy_with_extension.dart';
import 'package:json_annotation/json_annotation.dart';

part 'date_or_timestamp.g.dart';


@CopyWith()
@JsonSerializable(
  checked: true,
  createToJson: true,
  disallowUnrecognizedKeys: false,
  explicitToJson: true,
)
class DateOrTimestamp {
  /// Returns a new [DateOrTimestamp] instance.
  DateOrTimestamp({
  });



    @override
    bool operator ==(Object other) => identical(this, other) || other is DateOrTimestamp &&

    @override
    int get hashCode =>

  factory DateOrTimestamp.fromJson(Map<String, dynamic> json) => _$DateOrTimestampFromJson(json);

  Map<String, dynamic> toJson() => _$DateOrTimestampToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }

}

