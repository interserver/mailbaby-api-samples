//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'raw_mail.g.dart';

/// Raw Email Object
///
/// Properties:
/// * [rawEmail] - The entire email contents
@BuiltValue()
abstract class RawMail implements Built<RawMail, RawMailBuilder> {
  /// The entire email contents
  @BuiltValueField(wireName: r'raw_email')
  String get rawEmail;

  RawMail._();

  factory RawMail([void updates(RawMailBuilder b)]) = _$RawMail;

  @BuiltValueHook(initializeBuilder: true)
  static void _defaults(RawMailBuilder b) => b;

  @BuiltValueSerializer(custom: true)
  static Serializer<RawMail> get serializer => _$RawMailSerializer();
}

class _$RawMailSerializer implements PrimitiveSerializer<RawMail> {
  @override
  final Iterable<Type> types = const [RawMail, _$RawMail];

  @override
  final String wireName = r'RawMail';

  Iterable<Object?> _serializeProperties(
    Serializers serializers,
    RawMail object, {
    FullType specifiedType = FullType.unspecified,
  }) sync* {
    yield r'raw_email';
    yield serializers.serialize(
      object.rawEmail,
      specifiedType: const FullType(String),
    );
  }

  @override
  Object serialize(
    Serializers serializers,
    RawMail object, {
    FullType specifiedType = FullType.unspecified,
  }) {
    return _serializeProperties(serializers, object, specifiedType: specifiedType).toList();
  }

  void _deserializeProperties(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
    required List<Object?> serializedList,
    required RawMailBuilder result,
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
        default:
          unhandled.add(key);
          unhandled.add(value);
          break;
      }
    }
  }

  @override
  RawMail deserialize(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
  }) {
    final result = RawMailBuilder();
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

