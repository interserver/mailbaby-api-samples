//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:built_collection/built_collection.dart';
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'deny_rule_new.g.dart';

/// The fields required to create a new email deny rule via `POST /mail/rules`. The `type` controls what `data` is matched against: - `email` — exact sender address match - `domain` — all senders from a domain - `destination` — exact recipient address match - `startswith` — sender local-part prefix match (alphanumeric + `+_.-` only)
///
/// Properties:
/// * [type] - The type of deny rule.
/// * [data] - The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`.
/// * [user] - Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`.
@BuiltValue(instantiable: false)
abstract class DenyRuleNew  {
  /// The type of deny rule.
  @BuiltValueField(wireName: r'type')
  DenyRuleNewTypeEnum get type;
  // enum typeEnum {  domain,  email,  startswith,  destination,  };

  /// The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`.
  @BuiltValueField(wireName: r'data')
  String get data;

  /// Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`.
  @BuiltValueField(wireName: r'user')
  String? get user;

  @BuiltValueSerializer(custom: true)
  static Serializer<DenyRuleNew> get serializer => _$DenyRuleNewSerializer();
}

class _$DenyRuleNewSerializer implements PrimitiveSerializer<DenyRuleNew> {
  @override
  final Iterable<Type> types = const [DenyRuleNew];

  @override
  final String wireName = r'DenyRuleNew';

  Iterable<Object?> _serializeProperties(
    Serializers serializers,
    DenyRuleNew object, {
    FullType specifiedType = FullType.unspecified,
  }) sync* {
    yield r'type';
    yield serializers.serialize(
      object.type,
      specifiedType: const FullType(DenyRuleNewTypeEnum),
    );
    yield r'data';
    yield serializers.serialize(
      object.data,
      specifiedType: const FullType(String),
    );
    if (object.user != null) {
      yield r'user';
      yield serializers.serialize(
        object.user,
        specifiedType: const FullType(String),
      );
    }
  }

  @override
  Object serialize(
    Serializers serializers,
    DenyRuleNew object, {
    FullType specifiedType = FullType.unspecified,
  }) {
    return _serializeProperties(serializers, object, specifiedType: specifiedType).toList();
  }

  @override
  DenyRuleNew deserialize(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
  }) {
    return serializers.deserialize(serialized, specifiedType: FullType($DenyRuleNew)) as $DenyRuleNew;
  }
}

/// a concrete implementation of [DenyRuleNew], since [DenyRuleNew] is not instantiable
@BuiltValue(instantiable: true)
abstract class $DenyRuleNew implements DenyRuleNew, Built<$DenyRuleNew, $DenyRuleNewBuilder> {
  $DenyRuleNew._();

  factory $DenyRuleNew([void Function($DenyRuleNewBuilder)? updates]) = _$$DenyRuleNew;

  @BuiltValueHook(initializeBuilder: true)
  static void _defaults($DenyRuleNewBuilder b) => b;

  @BuiltValueSerializer(custom: true)
  static Serializer<$DenyRuleNew> get serializer => _$$DenyRuleNewSerializer();
}

class _$$DenyRuleNewSerializer implements PrimitiveSerializer<$DenyRuleNew> {
  @override
  final Iterable<Type> types = const [$DenyRuleNew, _$$DenyRuleNew];

  @override
  final String wireName = r'$DenyRuleNew';

  @override
  Object serialize(
    Serializers serializers,
    $DenyRuleNew object, {
    FullType specifiedType = FullType.unspecified,
  }) {
    return serializers.serialize(object, specifiedType: FullType(DenyRuleNew))!;
  }

  void _deserializeProperties(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
    required List<Object?> serializedList,
    required DenyRuleNewBuilder result,
    required List<Object?> unhandled,
  }) {
    for (var i = 0; i < serializedList.length; i += 2) {
      final key = serializedList[i] as String;
      final value = serializedList[i + 1];
      switch (key) {
        case r'type':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(DenyRuleNewTypeEnum),
          ) as DenyRuleNewTypeEnum;
          result.type = valueDes;
          break;
        case r'data':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.data = valueDes;
          break;
        case r'user':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.user = valueDes;
          break;
        default:
          unhandled.add(key);
          unhandled.add(value);
          break;
      }
    }
  }

  @override
  $DenyRuleNew deserialize(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
  }) {
    final result = $DenyRuleNewBuilder();
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

class DenyRuleNewTypeEnum extends EnumClass {

  /// The type of deny rule.
  @BuiltValueEnumConst(wireName: r'domain')
  static const DenyRuleNewTypeEnum domain = _$denyRuleNewTypeEnum_domain;
  /// The type of deny rule.
  @BuiltValueEnumConst(wireName: r'email')
  static const DenyRuleNewTypeEnum email = _$denyRuleNewTypeEnum_email;
  /// The type of deny rule.
  @BuiltValueEnumConst(wireName: r'startswith')
  static const DenyRuleNewTypeEnum startswith = _$denyRuleNewTypeEnum_startswith;
  /// The type of deny rule.
  @BuiltValueEnumConst(wireName: r'destination')
  static const DenyRuleNewTypeEnum destination = _$denyRuleNewTypeEnum_destination;

  static Serializer<DenyRuleNewTypeEnum> get serializer => _$denyRuleNewTypeEnumSerializer;

  const DenyRuleNewTypeEnum._(String name): super(name);

  static BuiltSet<DenyRuleNewTypeEnum> get values => _$denyRuleNewTypeEnumValues;
  static DenyRuleNewTypeEnum valueOf(String name) => _$denyRuleNewTypeEnumValueOf(name);
}

