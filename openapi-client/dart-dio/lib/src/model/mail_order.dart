//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'mail_order.g.dart';

/// A mail service order record.  Each order represents one provisioned sending account with a dedicated SMTP username.  The `id` is the numeric identifier used across most API calls.  The `username` is always `mb<id>` and is the SMTP AUTH username for `relay.mailbaby.net`.
///
/// Properties:
/// * [id] - The unique numeric ID of the mail order.  Used as the `id` parameter on sending calls, log queries, and stats queries.
/// * [status] - The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send.
/// * [username] - The SMTP AUTH username for this order, always in the format `mb<id>`. Use together with the password from `GET /mail/{id}` to authenticate directly against `relay.mailbaby.net:25` if needed.
/// * [comment] - Optional human-readable note associated with the order.
@BuiltValue(instantiable: false)
abstract class MailOrder  {
  /// The unique numeric ID of the mail order.  Used as the `id` parameter on sending calls, log queries, and stats queries.
  @BuiltValueField(wireName: r'id')
  int get id;

  /// The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send.
  @BuiltValueField(wireName: r'status')
  String get status;

  /// The SMTP AUTH username for this order, always in the format `mb<id>`. Use together with the password from `GET /mail/{id}` to authenticate directly against `relay.mailbaby.net:25` if needed.
  @BuiltValueField(wireName: r'username')
  String get username;

  /// Optional human-readable note associated with the order.
  @BuiltValueField(wireName: r'comment')
  String? get comment;

  @BuiltValueSerializer(custom: true)
  static Serializer<MailOrder> get serializer => _$MailOrderSerializer();
}

class _$MailOrderSerializer implements PrimitiveSerializer<MailOrder> {
  @override
  final Iterable<Type> types = const [MailOrder];

  @override
  final String wireName = r'MailOrder';

  Iterable<Object?> _serializeProperties(
    Serializers serializers,
    MailOrder object, {
    FullType specifiedType = FullType.unspecified,
  }) sync* {
    yield r'id';
    yield serializers.serialize(
      object.id,
      specifiedType: const FullType(int),
    );
    yield r'status';
    yield serializers.serialize(
      object.status,
      specifiedType: const FullType(String),
    );
    yield r'username';
    yield serializers.serialize(
      object.username,
      specifiedType: const FullType(String),
    );
    if (object.comment != null) {
      yield r'comment';
      yield serializers.serialize(
        object.comment,
        specifiedType: const FullType(String),
      );
    }
  }

  @override
  Object serialize(
    Serializers serializers,
    MailOrder object, {
    FullType specifiedType = FullType.unspecified,
  }) {
    return _serializeProperties(serializers, object, specifiedType: specifiedType).toList();
  }

  @override
  MailOrder deserialize(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
  }) {
    return serializers.deserialize(serialized, specifiedType: FullType($MailOrder)) as $MailOrder;
  }
}

/// a concrete implementation of [MailOrder], since [MailOrder] is not instantiable
@BuiltValue(instantiable: true)
abstract class $MailOrder implements MailOrder, Built<$MailOrder, $MailOrderBuilder> {
  $MailOrder._();

  factory $MailOrder([void Function($MailOrderBuilder)? updates]) = _$$MailOrder;

  @BuiltValueHook(initializeBuilder: true)
  static void _defaults($MailOrderBuilder b) => b;

  @BuiltValueSerializer(custom: true)
  static Serializer<$MailOrder> get serializer => _$$MailOrderSerializer();
}

class _$$MailOrderSerializer implements PrimitiveSerializer<$MailOrder> {
  @override
  final Iterable<Type> types = const [$MailOrder, _$$MailOrder];

  @override
  final String wireName = r'$MailOrder';

  @override
  Object serialize(
    Serializers serializers,
    $MailOrder object, {
    FullType specifiedType = FullType.unspecified,
  }) {
    return serializers.serialize(object, specifiedType: FullType(MailOrder))!;
  }

  void _deserializeProperties(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
    required List<Object?> serializedList,
    required MailOrderBuilder result,
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
        case r'status':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.status = valueDes;
          break;
        case r'username':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.username = valueDes;
          break;
        case r'comment':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.comment = valueDes;
          break;
        default:
          unhandled.add(key);
          unhandled.add(value);
          break;
      }
    }
  }

  @override
  $MailOrder deserialize(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
  }) {
    final result = $MailOrderBuilder();
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

