//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'send_mail_from.g.dart';



abstract class SendMailFrom implements Built<SendMailFrom, SendMailFromBuilder> {
    /// The email address
    @BuiltValueField(wireName: r'email')
    String get email;

    /// Optional contact name
    @BuiltValueField(wireName: r'name')
    String? get name;

    SendMailFrom._();

    static void _initializeBuilder(SendMailFromBuilder b) => b;

    factory SendMailFrom([void updates(SendMailFromBuilder b)]) = _$SendMailFrom;

    @BuiltValueSerializer(custom: true)
    static Serializer<SendMailFrom> get serializer => _$SendMailFromSerializer();
}

class _$SendMailFromSerializer implements StructuredSerializer<SendMailFrom> {
    @override
    final Iterable<Type> types = const [SendMailFrom, _$SendMailFrom];

    @override
    final String wireName = r'SendMailFrom';

    @override
    Iterable<Object?> serialize(Serializers serializers, SendMailFrom object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
        result
            ..add(r'email')
            ..add(serializers.serialize(object.email,
                specifiedType: const FullType(String)));
        if (object.name != null) {
            result
                ..add(r'name')
                ..add(serializers.serialize(object.name,
                    specifiedType: const FullType(String)));
        }
        return result;
    }

    @override
    SendMailFrom deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = SendMailFromBuilder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final Object? value = iterator.current;
            switch (key) {
                case r'email':
                    result.email = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
                case r'name':
                    result.name = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
            }
        }
        return result.build();
    }
}

