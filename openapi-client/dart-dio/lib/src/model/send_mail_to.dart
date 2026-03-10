//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:built_collection/built_collection.dart';
import 'dart:core';
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';
import 'package:one_of/one_of.dart';

part 'send_mail_to.g.dart';

/// The primary recipient address for a simple send request. Accepts a single email address string or an array of email address strings for multiple recipients.
@BuiltValue()
abstract class SendMailTo implements Built<SendMailTo, SendMailToBuilder> {
  /// One Of [BuiltList<String>], [String]
  OneOf get oneOf;

  SendMailTo._();

  factory SendMailTo([void updates(SendMailToBuilder b)]) = _$SendMailTo;

  @BuiltValueHook(initializeBuilder: true)
  static void _defaults(SendMailToBuilder b) => b;

  @BuiltValueSerializer(custom: true)
  static Serializer<SendMailTo> get serializer => _$SendMailToSerializer();
}

class _$SendMailToSerializer implements PrimitiveSerializer<SendMailTo> {
  @override
  final Iterable<Type> types = const [SendMailTo, _$SendMailTo];

  @override
  final String wireName = r'SendMailTo';

  Iterable<Object?> _serializeProperties(
    Serializers serializers,
    SendMailTo object, {
    FullType specifiedType = FullType.unspecified,
  }) sync* {
  }

  @override
  Object serialize(
    Serializers serializers,
    SendMailTo object, {
    FullType specifiedType = FullType.unspecified,
  }) {
    final oneOf = object.oneOf;
    return serializers.serialize(oneOf.value, specifiedType: FullType(oneOf.valueType))!;
  }

  @override
  SendMailTo deserialize(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
  }) {
    final result = SendMailToBuilder();
    Object? oneOfDataSrc;
    final targetType = const FullType(OneOf, [FullType(String), FullType(BuiltList, [FullType(String)]), ]);
    oneOfDataSrc = serialized;
    result.oneOf = serializers.deserialize(oneOfDataSrc, specifiedType: targetType) as OneOf;
    return result.build();
  }
}

