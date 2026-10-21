//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:mailbaby_client_dart_dio/src/model/mail_stats_volume.dart';
import 'package:copy_with_extension/copy_with_extension.dart';
import 'package:json_annotation/json_annotation.dart';

part 'mail_stats_type.g.dart';


@CopyWith()
@JsonSerializable(
  checked: true,
  createToJson: true,
  disallowUnrecognizedKeys: false,
  explicitToJson: true,
)
class MailStatsType {
  /// Returns a new [MailStatsType] instance.
  MailStatsType({

     this.time = const MailStatsTypeTimeEnum._('1h'),

     this.usage,

     this.currency,

     this.cost,

     this.received,

     this.sent,

     this.volume,
  });

      /// The time window these `received`, `sent`, and `volume` statistics cover.
  @JsonKey(
    defaultValue: '1h',
    name: r'time',
    required: false,
    includeIfNull: false,
  unknownEnumValue: MailStatsTypeTimeEnum.unknownDefaultOpenApi,
  )


  final MailStatsTypeTimeEnum? time;



      /// Total messages accepted during the current billing cycle.  Used to calculate the `cost` value.
  @JsonKey(
    
    name: r'usage',
    required: false,
    includeIfNull: false,
  )


  final int? usage;



      /// The ISO 4217 currency code for this account (e.g. `USD`).
  @JsonKey(
    
    name: r'currency',
    required: false,
    includeIfNull: false,
  )


  final String? currency;



      /// Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails).
  @JsonKey(
    
    name: r'cost',
    required: false,
    includeIfNull: false,
  )


  final double? cost;



      /// Count of messages accepted by the relay within the selected `time` window. Includes messages still in queue.
  @JsonKey(
    
    name: r'received',
    required: false,
    includeIfNull: false,
  )


  final int? received;



      /// Count of messages successfully delivered to the destination MX within the selected `time` window.  Will be ≤ `received`.
  @JsonKey(
    
    name: r'sent',
    required: false,
    includeIfNull: false,
  )


  final int? sent;



  @JsonKey(
    
    name: r'volume',
    required: false,
    includeIfNull: false,
  )


  final MailStatsVolume? volume;





    @override
    bool operator ==(Object other) => identical(this, other) || other is MailStatsType &&
      other.time == time &&
      other.usage == usage &&
      other.currency == currency &&
      other.cost == cost &&
      other.received == received &&
      other.sent == sent &&
      other.volume == volume;

    @override
    int get hashCode =>
        time.hashCode +
        usage.hashCode +
        currency.hashCode +
        cost.hashCode +
        received.hashCode +
        sent.hashCode +
        volume.hashCode;

  factory MailStatsType.fromJson(Map<String, dynamic> json) => _$MailStatsTypeFromJson(json);

  Map<String, dynamic> toJson() => _$MailStatsTypeToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }

}

/// The time window these `received`, `sent`, and `volume` statistics cover.
enum MailStatsTypeTimeEnum {
@JsonValue(r'all')
All(r'all'),
@JsonValue(r'billing')
Billing(r'billing'),
@JsonValue(r'month')
Month(r'month'),
@JsonValue(r'7d')
SevenDays(r'7d'),
@JsonValue(r'24h')
TwentyFourHours(r'24h'),
@JsonValue(r'day')
Day(r'day'),
@JsonValue(r'1h')
OneHour(r'1h'),
@JsonValue(r'unknown_default_open_api')
unknownDefaultOpenApi(r'unknown_default_open_api');

const MailStatsTypeTimeEnum(this.value);

final String value;

@override
String toString() => value;
}


