//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'send_mail_raw.g.dart';

/// Raw Email Object
///
/// Properties:
/// * [rawEmail] - The entire email contents
/// * [id] - Optional order id
@BuiltValue()
abstract class SendMailRaw implements Built<SendMailRaw, SendMailRawBuilder> {
  /// The entire email contents
  @BuiltValueField(wireName: r'raw_email')
  String get rawEmail;

  /// Optional order id
  @BuiltValueField(wireName: r'id')
  int? get id;

  SendMailRaw._();

  factory SendMailRaw([void updates(SendMailRawBuilder b)]) = _$SendMailRaw;

  @BuiltValueHook(initializeBuilder: true)
  static void _defaults(SendMailRawBuilder b) => b;

  @BuiltValueSerializer(custom: true)
  static Serializer<SendMailRaw> get serializer => _$SendMailRawSerializer();
}

class _$SendMailRawSerializer implements PrimitiveSerializer<SendMailRaw> {
  @override
  final Iterable<Type> types = const [SendMailRaw, _$SendMailRaw];

  @override
  final String wireName = r'SendMailRaw';

  Iterable<Object?> _serializeProperties(
    Serializers serializers,
    SendMailRaw object, {
    FullType specifiedType = FullType.unspecified,
  }) sync* {
    yield r'raw_email';
    yield serializers.serialize(
      object.rawEmail,
      specifiedType: const FullType(String),
    );
    if (object.id != null) {
      yield r'id';
      yield serializers.serialize(
        object.id,
        specifiedType: const FullType(int),
      );
    }
  }

  @override
  Object serialize(
    Serializers serializers,
    SendMailRaw object, {
    FullType specifiedType = FullType.unspecified,
  }) {
    return _serializeProperties(serializers, object, specifiedType: specifiedType).toList();
  }

  void _deserializeProperties(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
    required List<Object?> serializedList,
    required SendMailRawBuilder result,
    required List<Object?> unhandled,
  }) {
    for (var i = 0; i < serializedList.length; i += 2) {
      final key = serializedList[i] as String;
      final value = serializedList[i + 1];
      switch (key) {
        case r'raw_email':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.rawEmail = valueDes;
          break;
        case r'id':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(int),
          ) as int;
          result.id = valueDes;
          break;
        default:
          unhandled.add(key);
          unhandled.add(value);
          break;
      }
    }
  }

  @override
  SendMailRaw deserialize(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
  }) {
    final result = SendMailRawBuilder();
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

