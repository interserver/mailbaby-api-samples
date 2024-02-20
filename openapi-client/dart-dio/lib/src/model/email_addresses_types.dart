//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:openapi/src/model/email_address_name.dart';
import 'package:built_collection/built_collection.dart';
import 'dart:core';
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';
import 'package:one_of/one_of.dart';

part 'email_addresses_types.g.dart';

/// 
@BuiltValue()
abstract class EmailAddressesTypes implements Built<EmailAddressesTypes, EmailAddressesTypesBuilder> {
  /// One Of [BuiltList<EmailAddressName>], [String]
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
    final targetType = const FullType(OneOf, [FullType(String), FullType(BuiltList, [FullType(EmailAddressName)]), ]);
    oneOfDataSrc = serialized;
    result.oneOf = serializers.deserialize(oneOfDataSrc, specifiedType: targetType) as OneOf;
    return result.build();
  }
}

