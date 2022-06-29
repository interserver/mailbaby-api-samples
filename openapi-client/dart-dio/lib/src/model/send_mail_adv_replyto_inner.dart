//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'send_mail_adv_replyto_inner.g.dart';

/// An Email Contact
///
/// Properties:
/// * [email] - The email address
/// * [name] - (optional) Name to use for the sending contact.
abstract class SendMailAdvReplytoInner implements Built<SendMailAdvReplytoInner, SendMailAdvReplytoInnerBuilder> {
    /// The email address
    @BuiltValueField(wireName: r'email')
    String get email;

    /// (optional) Name to use for the sending contact.
    @BuiltValueField(wireName: r'name')
    String? get name;

    SendMailAdvReplytoInner._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(SendMailAdvReplytoInnerBuilder b) => b;

    factory SendMailAdvReplytoInner([void updates(SendMailAdvReplytoInnerBuilder b)]) = _$SendMailAdvReplytoInner;

    @BuiltValueSerializer(custom: true)
    static Serializer<SendMailAdvReplytoInner> get serializer => _$SendMailAdvReplytoInnerSerializer();
}

class _$SendMailAdvReplytoInnerSerializer implements StructuredSerializer<SendMailAdvReplytoInner> {
    @override
    final Iterable<Type> types = const [SendMailAdvReplytoInner, _$SendMailAdvReplytoInner];

    @override
    final String wireName = r'SendMailAdvReplytoInner';

    @override
    Iterable<Object?> serialize(Serializers serializers, SendMailAdvReplytoInner object,
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
    SendMailAdvReplytoInner deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = SendMailAdvReplytoInnerBuilder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final Object? value = iterator.current;
            
            switch (key) {
                case r'email':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    result.email = valueDes;
                    break;
                case r'name':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    result.name = valueDes;
                    break;
            }
        }
        return result.build();
    }
}

