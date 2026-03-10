//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:openapi/src/model/email_address_names.dart';
import 'dart:core';
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';
import 'package:one_of/one_of.dart';

part 'email_addresses_types.g.dart';

/// A flexible email address list that accepts either a plain RFC 822 string or a structured array of contact objects.  When a string is provided it is parsed as a comma-separated list of RFC 822 addresses (supporting the `\"Name <email>\"` and bare `email` formats).  When an array is provided each entry must have at least an `email` field with an optional `name` field.
@BuiltValue()
abstract class EmailAddressesTypes implements Built<EmailAddressesTypes, EmailAddressesTypesBuilder> {
  /// One Of [EmailAddressNames], [String]
  OneOf get oneOf;

  EmailAddressesTypes._();

  factory EmailAddressesTypes([void updates(EmailAddressesTypesBuilder b)]) = _$EmailAddressesTypes;

  @BuiltValueHook(initializeBuilder: true)
  static void _defaults(EmailAddressesTypesBuilder b) => b;

  @BuiltValueSerializer(custom: true)
  static Serializer<EmailAddressesTypes> get serializer => _$EmailAddressesTypesSerializer();
}

class _$EmailAddressesTypesSerializer implements PrimitiveSerializer<EmailAddressesTypes> {
  @override
  final Iterable<Type> types = const [EmailAddressesTypes, _$EmailAddressesTypes];

  @override
  final String wireName = r'EmailAddressesTypes';

  Iterable<Object?> _serializeProperties(
    Serializers serializers,
    EmailAddressesTypes object, {
    FullType specifiedType = FullType.unspecified,
  }) sync* {
  }

  @override
  Object serialize(
    Serializers serializers,
    EmailAddressesTypes object, {
    FullType specifiedType = FullType.unspecified,
  }) {
    final oneOf = object.oneOf;
    return serializers.serialize(oneOf.value, specifiedType: FullType(oneOf.valueType))!;
  }

  @override
  EmailAddressesTypes deserialize(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
  }) {
    final result = EmailAddressesTypesBuilder();
    Object? oneOfDataSrc;
    final targetType = const FullType(OneOf, [FullType(String), FullType(EmailAddressNames), ]);
    oneOfDataSrc = serialized;
    result.oneOf = serializers.deserialize(oneOfDataSrc, specifiedType: targetType) as OneOf;
    return result.build();
  }
}

