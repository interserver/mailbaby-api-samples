//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:openapi/src/model/email_address_name.dart';
import 'dart:core';
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';
import 'package:one_of/one_of.dart';

part 'email_address_types.g.dart';

/// 
///
/// Properties:
/// * [email] - The email address.
/// * [name] - Name to use for the sending contact.
@BuiltValue()
abstract class EmailAddressTypes implements Built<EmailAddressTypes, EmailAddressTypesBuilder> {
  /// One Of [EmailAddressName], [String]
  OneOf get oneOf;

  EmailAddressTypes._();

  factory EmailAddressTypes([void updates(EmailAddressTypesBuilder b)]) = _$EmailAddressTypes;

  @BuiltValueHook(initializeBuilder: true)
  static void _defaults(EmailAddressTypesBuilder b) => b;

  @BuiltValueSerializer(custom: true)
  static Serializer<EmailAddressTypes> get serializer => _$EmailAddressTypesSerializer();
}

class _$EmailAddressTypesSerializer implements PrimitiveSerializer<EmailAddressTypes> {
  @override
  final Iterable<Type> types = const [EmailAddressTypes, _$EmailAddressTypes];

  @override
  final String wireName = r'EmailAddressTypes';

  Iterable<Object?> _serializeProperties(
    Serializers serializers,
    EmailAddressTypes object, {
    FullType specifiedType = FullType.unspecified,
  }) sync* {
  }

  @override
  Object serialize(
    Serializers serializers,
    EmailAddressTypes object, {
    FullType specifiedType = FullType.unspecified,
  }) {
    final oneOf = object.oneOf;
    return serializers.serialize(oneOf.value, specifiedType: FullType(oneOf.valueType))!;
  }

  @override
  EmailAddressTypes deserialize(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
  }) {
    final result = EmailAddressTypesBuilder();
    Object? oneOfDataSrc;
    final targetType = const FullType(OneOf, [FullType(String), FullType(EmailAddressName), ]);
    oneOfDataSrc = serialized;
    result.oneOf = serializers.deserialize(oneOfDataSrc, specifiedType: targetType) as OneOf;
    return result.build();
  }
}

