//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:copy_with_extension/copy_with_extension.dart';
import 'package:json_annotation/json_annotation.dart';

part 'mail_stats_volume.g.dart';


@CopyWith()
@JsonSerializable(
  checked: true,
  createToJson: true,
  disallowUnrecognizedKeys: false,
  explicitToJson: true,
)
class MailStatsVolume {
  /// Returns a new [MailStatsVolume] instance.
  MailStatsVolume({

     this.to,

     this.from,

     this.ip,
  });

      /// Message counts keyed by destination (envelope `to`) email address.
  @JsonKey(
    
    name: r'to',
    required: false,
    includeIfNull: false,
  )


  final Map<String, int>? to;



      /// Message counts keyed by sender (envelope `from`) email address.
  @JsonKey(
    
    name: r'from',
    required: false,
    includeIfNull: false,
  )


  final Map<String, int>? from;



      /// Message counts keyed by originating client IP address.
  @JsonKey(
    
    name: r'ip',
    required: false,
    includeIfNull: false,
  )


  final Map<String, int>? ip;





    @override
    bool operator ==(Object other) => identical(this, other) || other is MailStatsVolume &&
      other.to == to &&
      other.from == from &&
      other.ip == ip;

    @override
    int get hashCode =>
        to.hashCode +
        from.hashCode +
        ip.hashCode;

  factory MailStatsVolume.fromJson(Map<String, dynamic> json) => _$MailStatsVolumeFromJson(json);

  Map<String, dynamic> toJson() => _$MailStatsVolumeToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }

}

