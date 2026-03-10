//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:built_collection/built_collection.dart';
import 'package:openapi/src/model/mail_stats_volume.dart';
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'mail_stats_type.g.dart';

/// Account usage statistics returned by `GET /mail/stats`.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.
///
/// Properties:
/// * [time] - The time window these `received`, `sent`, and `volume` statistics cover.
/// * [usage] - Total messages accepted during the current billing cycle.  Used to calculate the `cost` value.
/// * [currency] - The ISO 4217 currency code for this account (e.g. `USD`).
/// * [cost] - Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails).
/// * [received] - Count of messages accepted by the relay within the selected `time` window. Includes messages still in queue.
/// * [sent] - Count of messages successfully delivered to the destination MX within the selected `time` window.  Will be ≤ `received`.
/// * [volume] 
@BuiltValue()
abstract class MailStatsType implements Built<MailStatsType, MailStatsTypeBuilder> {
  /// The time window these `received`, `sent`, and `volume` statistics cover.
  @BuiltValueField(wireName: r'time')
  MailStatsTypeTimeEnum? get time;
  // enum timeEnum {  all,  billing,  month,  7d,  24h,  day,  1h,  };

  /// Total messages accepted during the current billing cycle.  Used to calculate the `cost` value.
  @BuiltValueField(wireName: r'usage')
  int? get usage;

  /// The ISO 4217 currency code for this account (e.g. `USD`).
  @BuiltValueField(wireName: r'currency')
  String? get currency;

  /// Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails).
  @BuiltValueField(wireName: r'cost')
  double? get cost;

  /// Count of messages accepted by the relay within the selected `time` window. Includes messages still in queue.
  @BuiltValueField(wireName: r'received')
  int? get received;

  /// Count of messages successfully delivered to the destination MX within the selected `time` window.  Will be ≤ `received`.
  @BuiltValueField(wireName: r'sent')
  int? get sent;

  @BuiltValueField(wireName: r'volume')
  MailStatsVolume? get volume;

  MailStatsType._();

  factory MailStatsType([void updates(MailStatsTypeBuilder b)]) = _$MailStatsType;

  @BuiltValueHook(initializeBuilder: true)
  static void _defaults(MailStatsTypeBuilder b) => b
      ..time = MailStatsTypeTimeEnum.valueOf('1h');

  @BuiltValueSerializer(custom: true)
  static Serializer<MailStatsType> get serializer => _$MailStatsTypeSerializer();
}

class _$MailStatsTypeSerializer implements PrimitiveSerializer<MailStatsType> {
  @override
  final Iterable<Type> types = const [MailStatsType, _$MailStatsType];

  @override
  final String wireName = r'MailStatsType';

  Iterable<Object?> _serializeProperties(
    Serializers serializers,
    MailStatsType object, {
    FullType specifiedType = FullType.unspecified,
  }) sync* {
    if (object.time != null) {
      yield r'time';
      yield serializers.serialize(
        object.time,
        specifiedType: const FullType(MailStatsTypeTimeEnum),
      );
    }
    if (object.usage != null) {
      yield r'usage';
      yield serializers.serialize(
        object.usage,
        specifiedType: const FullType(int),
      );
    }
    if (object.currency != null) {
      yield r'currency';
      yield serializers.serialize(
        object.currency,
        specifiedType: const FullType(String),
      );
    }
    if (object.cost != null) {
      yield r'cost';
      yield serializers.serialize(
        object.cost,
        specifiedType: const FullType(double),
      );
    }
    if (object.received != null) {
      yield r'received';
      yield serializers.serialize(
        object.received,
        specifiedType: const FullType(int),
      );
    }
    if (object.sent != null) {
      yield r'sent';
      yield serializers.serialize(
        object.sent,
        specifiedType: const FullType(int),
      );
    }
    if (object.volume != null) {
      yield r'volume';
      yield serializers.serialize(
        object.volume,
        specifiedType: const FullType(MailStatsVolume),
      );
    }
  }

  @override
  Object serialize(
    Serializers serializers,
    MailStatsType object, {
    FullType specifiedType = FullType.unspecified,
  }) {
    return _serializeProperties(serializers, object, specifiedType: specifiedType).toList();
  }

  void _deserializeProperties(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
    required List<Object?> serializedList,
    required MailStatsTypeBuilder result,
    required List<Object?> unhandled,
  }) {
    for (var i = 0; i < serializedList.length; i += 2) {
      final key = serializedList[i] as String;
      final value = serializedList[i + 1];
      switch (key) {
        case r'time':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(MailStatsTypeTimeEnum),
          ) as MailStatsTypeTimeEnum;
          result.time = valueDes;
          break;
        case r'usage':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(int),
          ) as int;
          result.usage = valueDes;
          break;
        case r'currency':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.currency = valueDes;
          break;
        case r'cost':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(double),
          ) as double;
          result.cost = valueDes;
          break;
        case r'received':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(int),
          ) as int;
          result.received = valueDes;
          break;
        case r'sent':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(int),
          ) as int;
          result.sent = valueDes;
          break;
        case r'volume':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(MailStatsVolume),
          ) as MailStatsVolume;
          result.volume.replace(valueDes);
          break;
        default:
          unhandled.add(key);
          unhandled.add(value);
          break;
      }
    }
  }

  @override
  MailStatsType deserialize(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
  }) {
    final result = MailStatsTypeBuilder();
    final serializedList = (serialized as Iterable<Object?>).toList();
    final unhandled = <Object?>[];
    _deserializeProperties(
      serializers,
      serialized,
      specifiedType: specifiedType,
      serializedList: serializedList,
      unhandled: unhandled,
      result: result,
    );
    return result.build();
  }
}

class MailStatsTypeTimeEnum extends EnumClass {

  /// The time window these `received`, `sent`, and `volume` statistics cover.
  @BuiltValueEnumConst(wireName: r'all')
  static const MailStatsTypeTimeEnum all = _$mailStatsTypeTimeEnum_all;
  /// The time window these `received`, `sent`, and `volume` statistics cover.
  @BuiltValueEnumConst(wireName: r'billing')
  static const MailStatsTypeTimeEnum billing = _$mailStatsTypeTimeEnum_billing;
  /// The time window these `received`, `sent`, and `volume` statistics cover.
  @BuiltValueEnumConst(wireName: r'month')
  static const MailStatsTypeTimeEnum month = _$mailStatsTypeTimeEnum_month;
  /// The time window these `received`, `sent`, and `volume` statistics cover.
  @BuiltValueEnumConst(wireName: r'7d')
  static const MailStatsTypeTimeEnum n7d = _$mailStatsTypeTimeEnum_n7d;
  /// The time window these `received`, `sent`, and `volume` statistics cover.
  @BuiltValueEnumConst(wireName: r'24h')
  static const MailStatsTypeTimeEnum n24h = _$mailStatsTypeTimeEnum_n24h;
  /// The time window these `received`, `sent`, and `volume` statistics cover.
  @BuiltValueEnumConst(wireName: r'day')
  static const MailStatsTypeTimeEnum day = _$mailStatsTypeTimeEnum_day;
  /// The time window these `received`, `sent`, and `volume` statistics cover.
  @BuiltValueEnumConst(wireName: r'1h')
  static const MailStatsTypeTimeEnum n1h = _$mailStatsTypeTimeEnum_n1h;

  static Serializer<MailStatsTypeTimeEnum> get serializer => _$mailStatsTypeTimeEnumSerializer;

  const MailStatsTypeTimeEnum._(String name): super(name);

  static BuiltSet<MailStatsTypeTimeEnum> get values => _$mailStatsTypeTimeEnumValues;
  static MailStatsTypeTimeEnum valueOf(String name) => _$mailStatsTypeTimeEnumValueOf(name);
}

