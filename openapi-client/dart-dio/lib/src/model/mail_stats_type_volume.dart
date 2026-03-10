//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:built_collection/built_collection.dart';
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'mail_stats_type_volume.g.dart';

/// Top-500 breakdown of message counts grouped by source IP, destination address, and sender address within the selected `time` window.
///
/// Properties:
/// * [to] - Message counts keyed by destination (envelope `to`) email address.
/// * [from] - Message counts keyed by sender (envelope `from`) email address.
/// * [ip] - Message counts keyed by originating client IP address.
@BuiltValue()
abstract class MailStatsTypeVolume implements Built<MailStatsTypeVolume, MailStatsTypeVolumeBuilder> {
  /// Message counts keyed by destination (envelope `to`) email address.
  @BuiltValueField(wireName: r'to')
  BuiltMap<String, int>? get to;

  /// Message counts keyed by sender (envelope `from`) email address.
  @BuiltValueField(wireName: r'from')
  BuiltMap<String, int>? get from;

  /// Message counts keyed by originating client IP address.
  @BuiltValueField(wireName: r'ip')
  BuiltMap<String, int>? get ip;

  MailStatsTypeVolume._();

  factory MailStatsTypeVolume([void updates(MailStatsTypeVolumeBuilder b)]) = _$MailStatsTypeVolume;

  @BuiltValueHook(initializeBuilder: true)
  static void _defaults(MailStatsTypeVolumeBuilder b) => b;

  @BuiltValueSerializer(custom: true)
  static Serializer<MailStatsTypeVolume> get serializer => _$MailStatsTypeVolumeSerializer();
}

class _$MailStatsTypeVolumeSerializer implements PrimitiveSerializer<MailStatsTypeVolume> {
  @override
  final Iterable<Type> types = const [MailStatsTypeVolume, _$MailStatsTypeVolume];

  @override
  final String wireName = r'MailStatsTypeVolume';

  Iterable<Object?> _serializeProperties(
    Serializers serializers,
    MailStatsTypeVolume object, {
    FullType specifiedType = FullType.unspecified,
  }) sync* {
    if (object.to != null) {
      yield r'to';
      yield serializers.serialize(
        object.to,
        specifiedType: const FullType(BuiltMap, [FullType(String), FullType(int)]),
      );
    }
    if (object.from != null) {
      yield r'from';
      yield serializers.serialize(
        object.from,
        specifiedType: const FullType(BuiltMap, [FullType(String), FullType(int)]),
      );
    }
    if (object.ip != null) {
      yield r'ip';
      yield serializers.serialize(
        object.ip,
        specifiedType: const FullType(BuiltMap, [FullType(String), FullType(int)]),
      );
    }
  }

  @override
  Object serialize(
    Serializers serializers,
    MailStatsTypeVolume object, {
    FullType specifiedType = FullType.unspecified,
  }) {
    return _serializeProperties(serializers, object, specifiedType: specifiedType).toList();
  }

  void _deserializeProperties(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
    required List<Object?> serializedList,
    required MailStatsTypeVolumeBuilder result,
    required List<Object?> unhandled,
  }) {
    for (var i = 0; i < serializedList.length; i += 2) {
      final key = serializedList[i] as String;
      final value = serializedList[i + 1];
      switch (key) {
        case r'to':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(BuiltMap, [FullType(String), FullType(int)]),
          ) as BuiltMap<String, int>;
          result.to.replace(valueDes);
          break;
        case r'from':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(BuiltMap, [FullType(String), FullType(int)]),
          ) as BuiltMap<String, int>;
          result.from.replace(valueDes);
          break;
        case r'ip':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(BuiltMap, [FullType(String), FullType(int)]),
          ) as BuiltMap<String, int>;
          result.ip.replace(valueDes);
          break;
        default:
          unhandled.add(key);
          unhandled.add(value);
          break;
      }
    }
  }

  @override
  MailStatsTypeVolume deserialize(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
  }) {
    final result = MailStatsTypeVolumeBuilder();
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

