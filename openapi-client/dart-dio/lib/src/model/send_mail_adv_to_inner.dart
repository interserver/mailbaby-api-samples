//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'send_mail_adv_to_inner.g.dart';

/// An Email Contact
///
/// Properties:
/// * [email] - The email address
/// * [name] - (optional) Name to use for the destination contact.
abstract class SendMailAdvToInner implements Built<SendMailAdvToInner, SendMailAdvToInnerBuilder> {
    /// The email address
    @BuiltValueField(wireName: r'email')
    String get email;

    /// (optional) Name to use for the destination contact.
    @BuiltValueField(wireName: r'name')
    String? get name;

    SendMailAdvToInner._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(SendMailAdvToInnerBuilder b) => b;

    factory SendMailAdvToInner([void updates(SendMailAdvToInnerBuilder b)]) = _$SendMailAdvToInner;

    @BuiltValueSerializer(custom: true)
    static Serializer<SendMailAdvToInner> get serializer => _$SendMailAdvToInnerSerializer();
}

class _$SendMailAdvToInnerSerializer implements StructuredSerializer<SendMailAdvToInner> {
    @override
    final Iterable<Type> types = const [SendMailAdvToInner, _$SendMailAdvToInner];

    @override
    final String wireName = r'SendMailAdvToInner';

    @override
    Iterable<Object?> serialize(Serializers serializers, SendMailAdvToInner object,
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
    SendMailAdvToInner deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = SendMailAdvToInnerBuilder();

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

