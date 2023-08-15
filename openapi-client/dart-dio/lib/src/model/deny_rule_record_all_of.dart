//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'deny_rule_record_all_of.g.dart';

/// DenyRuleRecordAllOf
///
/// Properties:
/// * [id] - The deny rule Id number.
/// * [created] - the date the rule was created.
@BuiltValue(instantiable: false)
abstract class DenyRuleRecordAllOf  {
  /// The deny rule Id number.
  @BuiltValueField(wireName: r'id')
  int get id;

  /// the date the rule was created.
  @BuiltValueField(wireName: r'created')
  DateTime get created;

  @BuiltValueSerializer(custom: true)
  static Serializer<DenyRuleRecordAllOf> get serializer => _$DenyRuleRecordAllOfSerializer();
}

class _$DenyRuleRecordAllOfSerializer implements PrimitiveSerializer<DenyRuleRecordAllOf> {
  @override
  final Iterable<Type> types = const [DenyRuleRecordAllOf];

  @override
  final String wireName = r'DenyRuleRecordAllOf';

  Iterable<Object?> _serializeProperties(
    Serializers serializers,
    DenyRuleRecordAllOf object, {
    FullType specifiedType = FullType.unspecified,
  }) sync* {
    yield r'id';
    yield serializers.serialize(
      object.id,
      specifiedType: const FullType(int),
    );
    yield r'created';
    yield serializers.serialize(
      object.created,
      specifiedType: const FullType(DateTime),
    );
  }

  @override
  Object serialize(
    Serializers serializers,
    DenyRuleRecordAllOf object, {
    FullType specifiedType = FullType.unspecified,
  }) {
    return _serializeProperties(serializers, object, specifiedType: specifiedType).toList();
  }

  @override
  DenyRuleRecordAllOf deserialize(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
  }) {
    return serializers.deserialize(serialized, specifiedType: FullType($DenyRuleRecordAllOf)) as $DenyRuleRecordAllOf;
  }
}

/// a concrete implementation of [DenyRuleRecordAllOf], since [DenyRuleRecordAllOf] is not instantiable
@BuiltValue(instantiable: true)
abstract class $DenyRuleRecordAllOf implements DenyRuleRecordAllOf, Built<$DenyRuleRecordAllOf, $DenyRuleRecordAllOfBuilder> {
  $DenyRuleRecordAllOf._();

  factory $DenyRuleRecordAllOf([void Function($DenyRuleRecordAllOfBuilder)? updates]) = _$$DenyRuleRecordAllOf;

  @BuiltValueHook(initializeBuilder: true)
  static void _defaults($DenyRuleRecordAllOfBuilder b) => b;

  @BuiltValueSerializer(custom: true)
  static Serializer<$DenyRuleRecordAllOf> get serializer => _$$DenyRuleRecordAllOfSerializer();
}

class _$$DenyRuleRecordAllOfSerializer implements PrimitiveSerializer<$DenyRuleRecordAllOf> {
  @override
  final Iterable<Type> types = const [$DenyRuleRecordAllOf, _$$DenyRuleRecordAllOf];

  @override
  final String wireName = r'$DenyRuleRecordAllOf';

  @override
  Object serialize(
    Serializers serializers,
    $DenyRuleRecordAllOf object, {
    FullType specifiedType = FullType.unspecified,
  }) {
    return serializers.serialize(object, specifiedType: FullType(DenyRuleRecordAllOf))!;
  }

  void _deserializeProperties(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
    required List<Object?> serializedList,
    required DenyRuleRecordAllOfBuilder result,
    required List<Object?> unhandled,
  }) {
    for (var i = 0; i < serializedList.length; i += 2) {
      final key = serializedList[i] as String;
      final value = serializedList[i + 1];
      switch (key) {
        case r'id':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(int),
          ) as int;
          result.id = valueDes;
          break;
        case r'created':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(DateTime),
          ) as DateTime;
          result.created = valueDes;
          break;
        default:
          unhandled.add(key);
          unhandled.add(value);
          break;
      }
    }
  }

  @override
  $DenyRuleRecordAllOf deserialize(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
  }) {
    final result = $DenyRuleRecordAllOfBuilder();
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

