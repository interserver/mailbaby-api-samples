//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'send_mail_adv_bcc_inner.g.dart';

/// An Email Contact
///
/// Properties:
/// * [email] - The email address
/// * [name] - (optional) Name to use for the BCC contact.
abstract class SendMailAdvBccInner implements Built<SendMailAdvBccInner, SendMailAdvBccInnerBuilder> {
    /// The email address
    @BuiltValueField(wireName: r'email')
    String get email;

    /// (optional) Name to use for the BCC contact.
    @BuiltValueField(wireName: r'name')
    String? get name;

    SendMailAdvBccInner._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(SendMailAdvBccInnerBuilder b) => b;

    factory SendMailAdvBccInner([void updates(SendMailAdvBccInnerBuilder b)]) = _$SendMailAdvBccInner;

    @BuiltValueSerializer(custom: true)
    static Serializer<SendMailAdvBccInner> get serializer => _$SendMailAdvBccInnerSerializer();
}

class _$SendMailAdvBccInnerSerializer implements StructuredSerializer<SendMailAdvBccInner> {
    @override
    final Iterable<Type> types = const [SendMailAdvBccInner, _$SendMailAdvBccInner];

    @override
    final String wireName = r'SendMailAdvBccInner';

    @override
    Iterable<Object?> serialize(Serializers serializers, SendMailAdvBccInner object,
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
    SendMailAdvBccInner deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = SendMailAdvBccInnerBuilder();

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

