//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'send_mail_adv_cc_inner.g.dart';

/// An Email Contact
///
/// Properties:
/// * [email] - The email address
/// * [name] - (optional) Name to use for the CC contact.
abstract class SendMailAdvCcInner implements Built<SendMailAdvCcInner, SendMailAdvCcInnerBuilder> {
    /// The email address
    @BuiltValueField(wireName: r'email')
    String get email;

    /// (optional) Name to use for the CC contact.
    @BuiltValueField(wireName: r'name')
    String? get name;

    SendMailAdvCcInner._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(SendMailAdvCcInnerBuilder b) => b;

    factory SendMailAdvCcInner([void updates(SendMailAdvCcInnerBuilder b)]) = _$SendMailAdvCcInner;

    @BuiltValueSerializer(custom: true)
    static Serializer<SendMailAdvCcInner> get serializer => _$SendMailAdvCcInnerSerializer();
}

class _$SendMailAdvCcInnerSerializer implements StructuredSerializer<SendMailAdvCcInner> {
    @override
    final Iterable<Type> types = const [SendMailAdvCcInner, _$SendMailAdvCcInner];

    @override
    final String wireName = r'SendMailAdvCcInner';

    @override
    Iterable<Object?> serialize(Serializers serializers, SendMailAdvCcInner object,
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
    SendMailAdvCcInner deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = SendMailAdvCcInnerBuilder();

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

