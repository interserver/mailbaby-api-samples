//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'dart:core';
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';
import 'package:one_of/one_of.dart';

part 'date_or_timestamp.g.dart';

/// A date/time value accepted as either a Unix timestamp (integer seconds since epoch) or a date string parseable by `strtotime()` (e.g. `2024-01-15`, `last monday`).
@BuiltValue()
abstract class DateOrTimestamp implements Built<DateOrTimestamp, DateOrTimestampBuilder> {
  /// One Of [String], [int]
  OneOf get oneOf;

  DateOrTimestamp._();

  factory DateOrTimestamp([void updates(DateOrTimestampBuilder b)]) = _$DateOrTimestamp;

  @BuiltValueHook(initializeBuilder: true)
  static void _defaults(DateOrTimestampBuilder b) => b;

  @BuiltValueSerializer(custom: true)
  static Serializer<DateOrTimestamp> get serializer => _$DateOrTimestampSerializer();
}

class _$DateOrTimestampSerializer implements PrimitiveSerializer<DateOrTimestamp> {
  @override
  final Iterable<Type> types = const [DateOrTimestamp, _$DateOrTimestamp];

  @override
  final String wireName = r'DateOrTimestamp';

  Iterable<Object?> _serializeProperties(
    Serializers serializers,
    DateOrTimestamp object, {
    FullType specifiedType = FullType.unspecified,
  }) sync* {
  }

  @override
  Object serialize(
    Serializers serializers,
    DateOrTimestamp object, {
    FullType specifiedType = FullType.unspecified,
  }) {
    final oneOf = object.oneOf;
    return serializers.serialize(oneOf.value, specifiedType: FullType(oneOf.valueType))!;
  }

  @override
  DateOrTimestamp deserialize(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
  }) {
    final result = DateOrTimestampBuilder();
    Object? oneOfDataSrc;
    final targetType = const FullType(OneOf, [FullType(int), FullType(String), ]);
    oneOfDataSrc = serialized;
    result.oneOf = serializers.deserialize(oneOfDataSrc, specifiedType: targetType) as OneOf;
    return result.build();
  }
}


