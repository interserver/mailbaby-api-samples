//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'get_mail_orders401_response.g.dart';

/// GetMailOrders401Response
///
/// Properties:
/// * [code] 
/// * [message] 
@BuiltValue()
abstract class GetMailOrders401Response implements Built<GetMailOrders401Response, GetMailOrders401ResponseBuilder> {
  @BuiltValueField(wireName: r'code')
  String get code;

  @BuiltValueField(wireName: r'message')
  String get message;

  GetMailOrders401Response._();

  factory GetMailOrders401Response([void updates(GetMailOrders401ResponseBuilder b)]) = _$GetMailOrders401Response;

  @BuiltValueHook(initializeBuilder: true)
  static void _defaults(GetMailOrders401ResponseBuilder b) => b;

  @BuiltValueSerializer(custom: true)
  static Serializer<GetMailOrders401Response> get serializer => _$GetMailOrders401ResponseSerializer();
}

class _$GetMailOrders401ResponseSerializer implements PrimitiveSerializer<GetMailOrders401Response> {
  @override
  final Iterable<Type> types = const [GetMailOrders401Response, _$GetMailOrders401Response];

  @override
  final String wireName = r'GetMailOrders401Response';

  Iterable<Object?> _serializeProperties(
    Serializers serializers,
    GetMailOrders401Response object, {
    FullType specifiedType = FullType.unspecified,
  }) sync* {
    yield r'code';
    yield serializers.serialize(
      object.code,
      specifiedType: const FullType(String),
    );
    yield r'message';
    yield serializers.serialize(
      object.message,
      specifiedType: const FullType(String),
    );
  }

  @override
  Object serialize(
    Serializers serializers,
    GetMailOrders401Response object, {
    FullType specifiedType = FullType.unspecified,
  }) {
    return _serializeProperties(serializers, object, specifiedType: specifiedType).toList();
  }

  void _deserializeProperties(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
    required List<Object?> serializedList,
    required GetMailOrders401ResponseBuilder result,
    required List<Object?> unhandled,
  }) {
    for (var i = 0; i < serializedList.length; i += 2) {
      final key = serializedList[i] as String;
      final value = serializedList[i + 1];
      switch (key) {
        case r'code':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.code = valueDes;
          break;
        case r'message':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.message = valueDes;
          break;
        default:
          unhandled.add(key);
          unhandled.add(value);
          break;
      }
    }
  }

  @override
  GetMailOrders401Response deserialize(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
  }) {
    final result = GetMailOrders401ResponseBuilder();
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

