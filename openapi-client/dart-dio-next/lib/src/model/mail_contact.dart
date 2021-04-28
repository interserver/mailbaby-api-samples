//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'mail_contact.g.dart';



abstract class MailContact implements Built<MailContact, MailContactBuilder> {
    /// The email address
    @BuiltValueField(wireName: r'email')
    String get email;

    /// Optional contact name
    @BuiltValueField(wireName: r'name')
    String? get name;

    MailContact._();

    static void _initializeBuilder(MailContactBuilder b) => b;

    factory MailContact([void updates(MailContactBuilder b)]) = _$MailContact;

    @BuiltValueSerializer(custom: true)
    static Serializer<MailContact> get serializer => _$MailContactSerializer();
}

class _$MailContactSerializer implements StructuredSerializer<MailContact> {
    @override
    final Iterable<Type> types = const [MailContact, _$MailContact];

    @override
    final String wireName = r'MailContact';

    @override
    Iterable<Object?> serialize(Serializers serializers, MailContact object,
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
    MailContact deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = MailContactBuilder();

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

