//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'get_mail_orders200_response_inner.g.dart';

/// GetMailOrders200ResponseInner
///
/// Properties:
/// * [id] 
/// * [status] 
/// * [username] 
/// * [password] 
/// * [comment] 
abstract class GetMailOrders200ResponseInner implements Built<GetMailOrders200ResponseInner, GetMailOrders200ResponseInnerBuilder> {
    @BuiltValueField(wireName: r'id')
    int get id;

    @BuiltValueField(wireName: r'status')
    String get status;

    @BuiltValueField(wireName: r'username')
    String get username;

    @BuiltValueField(wireName: r'password')
    String? get password;

    @BuiltValueField(wireName: r'comment')
    String? get comment;

    GetMailOrders200ResponseInner._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(GetMailOrders200ResponseInnerBuilder b) => b;

    factory GetMailOrders200ResponseInner([void updates(GetMailOrders200ResponseInnerBuilder b)]) = _$GetMailOrders200ResponseInner;

    @BuiltValueSerializer(custom: true)
    static Serializer<GetMailOrders200ResponseInner> get serializer => _$GetMailOrders200ResponseInnerSerializer();
}

class _$GetMailOrders200ResponseInnerSerializer implements StructuredSerializer<GetMailOrders200ResponseInner> {
    @override
    final Iterable<Type> types = const [GetMailOrders200ResponseInner, _$GetMailOrders200ResponseInner];

    @override
    final String wireName = r'GetMailOrders200ResponseInner';

    @override
    Iterable<Object?> serialize(Serializers serializers, GetMailOrders200ResponseInner object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
        result
            ..add(r'id')
            ..add(serializers.serialize(object.id,
                specifiedType: const FullType(int)));
        result
            ..add(r'status')
            ..add(serializers.serialize(object.status,
                specifiedType: const FullType(String)));
        result
            ..add(r'username')
            ..add(serializers.serialize(object.username,
                specifiedType: const FullType(String)));
        if (object.password != null) {
            result
                ..add(r'password')
                ..add(serializers.serialize(object.password,
                    specifiedType: const FullType(String)));
        }
        if (object.comment != null) {
            result
                ..add(r'comment')
                ..add(serializers.serialize(object.comment,
                    specifiedType: const FullType(String)));
        }
        return result;
    }

    @override
    GetMailOrders200ResponseInner deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = GetMailOrders200ResponseInnerBuilder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final Object? value = iterator.current;
            
            switch (key) {
                case r'id':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(int)) as int;
                    result.id = valueDes;
                    break;
                case r'status':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    result.status = valueDes;
                    break;
                case r'username':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    result.username = valueDes;
                    break;
                case r'password':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    result.password = valueDes;
                    break;
                case r'comment':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    result.comment = valueDes;
                    break;
            }
        }
        return result.build();
    }
}

