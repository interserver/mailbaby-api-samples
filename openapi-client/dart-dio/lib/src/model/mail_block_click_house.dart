//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:openapi/src/model/date.dart';
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'mail_block_click_house.g.dart';

/// A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (`LOCAL_BL_RCPT` or `MBTRAP`). The `from` address can be passed to `POST /mail/blocks/delete` to delist it.
///
/// Properties:
/// * [date] - The date the block event was recorded.
/// * [from] - The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it.
/// * [subject] - The `Subject` header of the blocked message.
/// * [to] - The serialized list of recipients of the blocked message.
/// * [messageId] - The `Message-ID` header of the blocked message, or `null` if not present.
@BuiltValue()
abstract class MailBlockClickHouse implements Built<MailBlockClickHouse, MailBlockClickHouseBuilder> {
  /// The date the block event was recorded.
  @BuiltValueField(wireName: r'date')
  Date get date;

  /// The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it.
  @BuiltValueField(wireName: r'from')
  String get from;

  /// The `Subject` header of the blocked message.
  @BuiltValueField(wireName: r'subject')
  String get subject;

  /// The serialized list of recipients of the blocked message.
  @BuiltValueField(wireName: r'to')
  String get to;

  /// The `Message-ID` header of the blocked message, or `null` if not present.
  @BuiltValueField(wireName: r'messageId')
  String? get messageId;

  MailBlockClickHouse._();

  factory MailBlockClickHouse([void updates(MailBlockClickHouseBuilder b)]) = _$MailBlockClickHouse;

  @BuiltValueHook(initializeBuilder: true)
  static void _defaults(MailBlockClickHouseBuilder b) => b;

  @BuiltValueSerializer(custom: true)
  static Serializer<MailBlockClickHouse> get serializer => _$MailBlockClickHouseSerializer();
}

class _$MailBlockClickHouseSerializer implements PrimitiveSerializer<MailBlockClickHouse> {
  @override
  final Iterable<Type> types = const [MailBlockClickHouse, _$MailBlockClickHouse];

  @override
  final String wireName = r'MailBlockClickHouse';

  Iterable<Object?> _serializeProperties(
    Serializers serializers,
    MailBlockClickHouse object, {
    FullType specifiedType = FullType.unspecified,
  }) sync* {
    yield r'date';
    yield serializers.serialize(
      object.date,
      specifiedType: const FullType(Date),
    );
    yield r'from';
    yield serializers.serialize(
      object.from,
      specifiedType: const FullType(String),
    );
    yield r'subject';
    yield serializers.serialize(
      object.subject,
      specifiedType: const FullType(String),
    );
    yield r'to';
    yield serializers.serialize(
      object.to,
      specifiedType: const FullType(String),
    );
    if (object.messageId != null) {
      yield r'messageId';
      yield serializers.serialize(
        object.messageId,
        specifiedType: const FullType.nullable(String),
      );
    }
  }

  @override
  Object serialize(
    Serializers serializers,
    MailBlockClickHouse object, {
    FullType specifiedType = FullType.unspecified,
  }) {
    return _serializeProperties(serializers, object, specifiedType: specifiedType).toList();
  }

  void _deserializeProperties(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
    required List<Object?> serializedList,
    required MailBlockClickHouseBuilder result,
    required List<Object?> unhandled,
  }) {
    for (var i = 0; i < serializedList.length; i += 2) {
      final key = serializedList[i] as String;
      final value = serializedList[i + 1];
      switch (key) {
        case r'date':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(Date),
          ) as Date;
          result.date = valueDes;
          break;
        case r'from':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.from = valueDes;
          break;
        case r'subject':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.subject = valueDes;
          break;
        case r'to':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.to = valueDes;
          break;
        case r'messageId':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType.nullable(String),
          ) as String?;
          if (valueDes == null) continue;
          result.messageId = valueDes;
          break;
        default:
          unhandled.add(key);
          unhandled.add(value);
          break;
      }
    }
  }

  @override
  MailBlockClickHouse deserialize(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
  }) {
    final result = MailBlockClickHouseBuilder();
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

