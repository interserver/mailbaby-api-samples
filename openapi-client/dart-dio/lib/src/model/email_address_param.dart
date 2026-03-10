//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'email_address_param.g.dart';

/// A single email address parameter used as the body of `POST /mail/blocks/delete`.
///
/// Properties:
/// * [email] - The email address to delist from all block lists.
@BuiltValue()
abstract class EmailAddressParam implements Built<EmailAddressParam, EmailAddressParamBuilder> {
  /// The email address to delist from all block lists.
  @BuiltValueField(wireName: r'email')
  String get email;

  EmailAddressParam._();

  factory EmailAddressParam([void updates(EmailAddressParamBuilder b)]) = _$EmailAddressParam;

  @BuiltValueHook(initializeBuilder: true)
  static void _defaults(EmailAddressParamBuilder b) => b;

  @BuiltValueSerializer(custom: true)
  static Serializer<EmailAddressParam> get serializer => _$EmailAddressParamSerializer();
}

class _$EmailAddressParamSerializer implements PrimitiveSerializer<EmailAddressParam> {
  @override
  final Iterable<Type> types = const [EmailAddressParam, _$EmailAddressParam];

  @override
  final String wireName = r'EmailAddressParam';

  Iterable<Object?> _serializeProperties(
    Serializers serializers,
    EmailAddressParam object, {
    FullType specifiedType = FullType.unspecified,
  }) sync* {
    yield r'email';
    yield serializers.serialize(
      object.email,
      specifiedType: const FullType(String),
    );
  }

  @override
  Object serialize(
    Serializers serializers,
    EmailAddressParam object, {
    FullType specifiedType = FullType.unspecified,
  }) {
    return _serializeProperties(serializers, object, specifiedType: specifiedType).toList();
  }

  void _deserializeProperties(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
    required List<Object?> serializedList,
    required EmailAddressParamBuilder result,
    required List<Object?> unhandled,
  }) {
    for (var i = 0; i < serializedList.length; i += 2) {
      final key = serializedList[i] as String;
      final value = serializedList[i + 1];
      switch (key) {
        case r'email':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.email = valueDes;
          break;
        default:
          unhandled.add(key);
          unhandled.add(value);
          break;
      }
    }
  }

  @override
  EmailAddressParam deserialize(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
  }) {
    final result = EmailAddressParamBuilder();
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

