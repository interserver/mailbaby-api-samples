//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.7

// ignore_for_file: unused_import

import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'mail_order.g.dart';

abstract class MailOrder implements Built<MailOrder, MailOrderBuilder> {

    @BuiltValueField(wireName: r'id')
    int get id;

    @BuiltValueField(wireName: r'status')
    String get status;

    @BuiltValueField(wireName: r'username')
    String get username;

    @nullable
    @BuiltValueField(wireName: r'password')
    String get password;

    @nullable
    @BuiltValueField(wireName: r'comment')
    String get comment;

    MailOrder._();

    static void _initializeBuilder(MailOrderBuilder b) => b;

    factory MailOrder([void updates(MailOrderBuilder b)]) = _$MailOrder;

    @BuiltValueSerializer(custom: true)
    static Serializer<MailOrder> get serializer => _$MailOrderSerializer();
}

class _$MailOrderSerializer implements StructuredSerializer<MailOrder> {

    @override
    final Iterable<Type> types = const [MailOrder, _$MailOrder];
    @override
    final String wireName = r'MailOrder';

    @override
    Iterable<Object> serialize(Serializers serializers, MailOrder object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object>[];
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
    MailOrder deserialize(Serializers serializers, Iterable<Object> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = MailOrderBuilder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final dynamic value = iterator.current;
            switch (key) {
                case r'id':
                    result.id = serializers.deserialize(value,
                        specifiedType: const FullType(int)) as int;
                    break;
                case r'status':
                    result.status = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
                case r'username':
                    result.username = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
                case r'password':
                    result.password = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
                case r'comment':
                    result.comment = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
            }
        }
        return result.build();
    }
}

