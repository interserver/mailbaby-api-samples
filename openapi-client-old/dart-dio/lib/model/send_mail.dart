//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.7

// ignore_for_file: unused_import

import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'send_mail.g.dart';

abstract class SendMail implements Built<SendMail, SendMailBuilder> {

    /// The Contact whom is the primary recipient of this email.
    @BuiltValueField(wireName: r'to')
    String get to;

    /// The contact whom is the this email is from.
    @BuiltValueField(wireName: r'from')
    String get from;

    /// The subject or title of the email
    @BuiltValueField(wireName: r'subject')
    String get subject;

    /// The main email contents.
    @BuiltValueField(wireName: r'body')
    String get body;

    SendMail._();

    static void _initializeBuilder(SendMailBuilder b) => b;

    factory SendMail([void updates(SendMailBuilder b)]) = _$SendMail;

    @BuiltValueSerializer(custom: true)
    static Serializer<SendMail> get serializer => _$SendMailSerializer();
}

class _$SendMailSerializer implements StructuredSerializer<SendMail> {

    @override
    final Iterable<Type> types = const [SendMail, _$SendMail];
    @override
    final String wireName = r'SendMail';

    @override
    Iterable<Object> serialize(Serializers serializers, SendMail object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object>[];
        result
            ..add(r'to')
            ..add(serializers.serialize(object.to,
                specifiedType: const FullType(String)));
        result
            ..add(r'from')
            ..add(serializers.serialize(object.from,
                specifiedType: const FullType(String)));
        result
            ..add(r'subject')
            ..add(serializers.serialize(object.subject,
                specifiedType: const FullType(String)));
        result
            ..add(r'body')
            ..add(serializers.serialize(object.body,
                specifiedType: const FullType(String)));
        return result;
    }

    @override
    SendMail deserialize(Serializers serializers, Iterable<Object> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = SendMailBuilder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final dynamic value = iterator.current;
            switch (key) {
                case r'to':
                    result.to = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
                case r'from':
                    result.from = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
                case r'subject':
                    result.subject = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
                case r'body':
                    result.body = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
            }
        }
        return result.build();
    }
}

