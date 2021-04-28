//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.7

// ignore_for_file: unused_import

import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'mail_log.g.dart';

abstract class MailLog implements Built<MailLog, MailLogBuilder> {

    @nullable
    @BuiltValueField(wireName: r'id')
    int get id;

    MailLog._();

    static void _initializeBuilder(MailLogBuilder b) => b;

    factory MailLog([void updates(MailLogBuilder b)]) = _$MailLog;

    @BuiltValueSerializer(custom: true)
    static Serializer<MailLog> get serializer => _$MailLogSerializer();
}

class _$MailLogSerializer implements StructuredSerializer<MailLog> {

    @override
    final Iterable<Type> types = const [MailLog, _$MailLog];
    @override
    final String wireName = r'MailLog';

    @override
    Iterable<Object> serialize(Serializers serializers, MailLog object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object>[];
        if (object.id != null) {
            result
                ..add(r'id')
                ..add(serializers.serialize(object.id,
                    specifiedType: const FullType(int)));
        }
        return result;
    }

    @override
    MailLog deserialize(Serializers serializers, Iterable<Object> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = MailLogBuilder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final dynamic value = iterator.current;
            switch (key) {
                case r'id':
                    result.id = serializers.deserialize(value,
                        specifiedType: const FullType(int)) as int;
                    break;
            }
        }
        return result.build();
    }
}

