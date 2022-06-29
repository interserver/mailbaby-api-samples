//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'send_mail.g.dart';

/// Details for an Email
///
/// Properties:
/// * [to] - The Contact whom is the primary recipient of this email.
/// * [from] - The contact whom is the this email is from.
/// * [subject] - The subject or title of the email
/// * [body] - The main email contents.
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

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(SendMailBuilder b) => b;

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
    Iterable<Object?> serialize(Serializers serializers, SendMail object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
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
    SendMail deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = SendMailBuilder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final Object? value = iterator.current;
            
            switch (key) {
                case r'to':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    result.to = valueDes;
                    break;
                case r'from':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    result.from = valueDes;
                    break;
                case r'subject':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    result.subject = valueDes;
                    break;
                case r'body':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    result.body = valueDes;
                    break;
            }
        }
        return result.build();
    }
}

