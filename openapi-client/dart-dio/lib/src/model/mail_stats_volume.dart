//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:built_collection/built_collection.dart';
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'mail_stats_volume.g.dart';

/// Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.
///
/// Properties:
/// * [to] - Message counts keyed by destination (envelope `to`) email address.
/// * [from] - Message counts keyed by sender (envelope `from`) email address.
/// * [ip] - Message counts keyed by originating client IP address.
@BuiltValue()
abstract class MailStatsVolume implements Built<MailStatsVolume, MailStatsVolumeBuilder> {
  /// Message counts keyed by destination (envelope `to`) email address.
  @BuiltValueField(wireName: r'to')
  BuiltMap<String, int>? get to;

  /// Message counts keyed by sender (envelope `from`) email address.
  @BuiltValueField(wireName: r'from')
  BuiltMap<String, int>? get from;

  /// Message counts keyed by originating client IP address.
  @BuiltValueField(wireName: r'ip')
  BuiltMap<String, int>? get ip;

  MailStatsVolume._();

  factory MailStatsVolume([void updates(MailStatsVolumeBuilder b)]) = _$MailStatsVolume;

  @BuiltValueHook(initializeBuilder: true)
  static void _defaults(MailStatsVolumeBuilder b) => b;

  @BuiltValueSerializer(custom: true)
  static Serializer<MailStatsVolume> get serializer => _$MailStatsVolumeSerializer();
}

class _$MailStatsVolumeSerializer implements PrimitiveSerializer<MailStatsVolume> {
  @override
  final Iterable<Type> types = const [MailStatsVolume, _$MailStatsVolume];

  @override
  final String wireName = r'MailStatsVolume';

  Iterable<Object?> _serializeProperties(
    Serializers serializers,
    MailStatsVolume object, {
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
    MailStatsVolume object, {
    FullType specifiedType = FullType.unspecified,
  }) {
    return _serializeProperties(serializers, object, specifiedType: specifiedType).toList();
  }

  void _deserializeProperties(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
    required List<Object?> serializedList,
    required MailStatsVolumeBuilder result,
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
  MailStatsVolume deserialize(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
  }) {
    final result = MailStatsVolumeBuilder();
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

