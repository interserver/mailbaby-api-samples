//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:openapi/src/model/email_address_name.dart';
import 'package:built_collection/built_collection.dart';
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'email_address_names.g.dart';

/// An array of email contacts, each with an email address and optional display name.
@BuiltValue()
abstract class EmailAddressNames implements Built<EmailAddressNames, EmailAddressNamesBuilder> {
  EmailAddressNames._();

  factory EmailAddressNames([void updates(EmailAddressNamesBuilder b)]) = _$EmailAddressNames;

  @BuiltValueHook(initializeBuilder: true)
  static void _defaults(EmailAddressNamesBuilder b) => b;

  @BuiltValueSerializer(custom: true)
  static Serializer<EmailAddressNames> get serializer => _$EmailAddressNamesSerializer();
}

class _$EmailAddressNamesSerializer implements PrimitiveSerializer<EmailAddressNames> {
  @override
  final Iterable<Type> types = const [EmailAddressNames, _$EmailAddressNames];

  @override
  final String wireName = r'EmailAddressNames';

  Iterable<Object?> _serializeProperties(
    Serializers serializers,
    EmailAddressNames object, {
    FullType specifiedType = FullType.unspecified,
  }) sync* {
  }

  @override
  Object serialize(
    Serializers serializers,
    EmailAddressNames object, {
    FullType specifiedType = FullType.unspecified,
  }) {
    return _serializeProperties(serializers, object, specifiedType: specifiedType).toList();
  }

  @override
  EmailAddressNames deserialize(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
  }) {
    final result = EmailAddressNamesBuilder();
    final serializedList = (serialized as Iterable<Object?>).toList();
    return result.build();
  }
}

