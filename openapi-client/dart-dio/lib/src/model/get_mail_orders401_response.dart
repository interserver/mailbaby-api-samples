//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'get_mail_orders401_response.g.dart';

/// GetMailOrders401Response
///
/// Properties:
/// * [code] 
/// * [message] 
abstract class GetMailOrders401Response implements Built<GetMailOrders401Response, GetMailOrders401ResponseBuilder> {
    @BuiltValueField(wireName: r'code')
    String get code;

    @BuiltValueField(wireName: r'message')
    String get message;

    GetMailOrders401Response._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(GetMailOrders401ResponseBuilder b) => b;

    factory GetMailOrders401Response([void updates(GetMailOrders401ResponseBuilder b)]) = _$GetMailOrders401Response;

    @BuiltValueSerializer(custom: true)
    static Serializer<GetMailOrders401Response> get serializer => _$GetMailOrders401ResponseSerializer();
}

class _$GetMailOrders401ResponseSerializer implements StructuredSerializer<GetMailOrders401Response> {
    @override
    final Iterable<Type> types = const [GetMailOrders401Response, _$GetMailOrders401Response];

    @override
    final String wireName = r'GetMailOrders401Response';

    @override
    Iterable<Object?> serialize(Serializers serializers, GetMailOrders401Response object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
        result
            ..add(r'code')
            ..add(serializers.serialize(object.code,
                specifiedType: const FullType(String)));
        result
            ..add(r'message')
            ..add(serializers.serialize(object.message,
                specifiedType: const FullType(String)));
        return result;
    }

    @override
    GetMailOrders401Response deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = GetMailOrders401ResponseBuilder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final Object? value = iterator.current;
            
            switch (key) {
                case r'code':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    result.code = valueDes;
                    break;
                case r'message':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    result.message = valueDes;
                    break;
            }
        }
        return result.build();
    }
}

