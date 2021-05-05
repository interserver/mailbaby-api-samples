//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'send_mail_adv_from.g.dart';



abstract class SendMailAdvFrom implements Built<SendMailAdvFrom, SendMailAdvFromBuilder> {
    /// The email address
    @BuiltValueField(wireName: r'email')
    String get email;

    /// Optional contact name
    @BuiltValueField(wireName: r'name')
    String? get name;

    SendMailAdvFrom._();

    static void _initializeBuilder(SendMailAdvFromBuilder b) => b;

    factory SendMailAdvFrom([void updates(SendMailAdvFromBuilder b)]) = _$SendMailAdvFrom;

    @BuiltValueSerializer(custom: true)
    static Serializer<SendMailAdvFrom> get serializer => _$SendMailAdvFromSerializer();
}

class _$SendMailAdvFromSerializer implements StructuredSerializer<SendMailAdvFrom> {
    @override
    final Iterable<Type> types = const [SendMailAdvFrom, _$SendMailAdvFrom];

    @override
    final String wireName = r'SendMailAdvFrom';

    @override
    Iterable<Object?> serialize(Serializers serializers, SendMailAdvFrom object,
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
    SendMailAdvFrom deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = SendMailAdvFromBuilder();

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

