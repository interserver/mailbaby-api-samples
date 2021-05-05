//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.7

// ignore_for_file: unused_import

import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'body1.g.dart';

abstract class Body1 implements Built<Body1, Body1Builder> {

    /// The Contact whom is the primary recipient of this email.
    @nullable
    @BuiltValueField(wireName: r'to')
    String get to;

    /// The contact whom is the this email is from.
    @nullable
    @BuiltValueField(wireName: r'from')
    String get from;

    /// The subject or title of the email
    @nullable
    @BuiltValueField(wireName: r'subject')
    String get subject;

    /// The main email contents.
    @nullable
    @BuiltValueField(wireName: r'body')
    String get body;

    Body1._();

    static void _initializeBuilder(Body1Builder b) => b;

    factory Body1([void updates(Body1Builder b)]) = _$Body1;

    @BuiltValueSerializer(custom: true)
    static Serializer<Body1> get serializer => _$Body1Serializer();
}

class _$Body1Serializer implements StructuredSerializer<Body1> {

    @override
    final Iterable<Type> types = const [Body1, _$Body1];
    @override
    final String wireName = r'Body1';

    @override
    Iterable<Object> serialize(Serializers serializers, Body1 object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object>[];
        if (object.to != null) {
            result
                ..add(r'to')
                ..add(serializers.serialize(object.to,
                    specifiedType: const FullType(String)));
        }
        if (object.from != null) {
            result
                ..add(r'from')
                ..add(serializers.serialize(object.from,
                    specifiedType: const FullType(String)));
        }
        if (object.subject != null) {
            result
                ..add(r'subject')
                ..add(serializers.serialize(object.subject,
                    specifiedType: const FullType(String)));
        }
        if (object.body != null) {
            result
                ..add(r'body')
                ..add(serializers.serialize(object.body,
                    specifiedType: const FullType(String)));
        }
        return result;
    }

    @override
    Body1 deserialize(Serializers serializers, Iterable<Object> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = Body1Builder();

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

