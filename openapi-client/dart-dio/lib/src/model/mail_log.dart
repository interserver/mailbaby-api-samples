//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:built_collection/built_collection.dart';
import 'package:openapi/src/model/mail_log_entry.dart';
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'mail_log.g.dart';

/// Mail log records
///
/// Properties:
/// * [total] - total number of mail log entries
/// * [skip] - number of emails skipped in listing
/// * [limit] - number of emails to return
/// * [emails] 
abstract class MailLog implements Built<MailLog, MailLogBuilder> {
    /// total number of mail log entries
    @BuiltValueField(wireName: r'total')
    int get total;

    /// number of emails skipped in listing
    @BuiltValueField(wireName: r'skip')
    int get skip;

    /// number of emails to return
    @BuiltValueField(wireName: r'limit')
    int get limit;

    @BuiltValueField(wireName: r'emails')
    BuiltList<MailLogEntry> get emails;

    MailLog._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(MailLogBuilder b) => b;

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
    Iterable<Object?> serialize(Serializers serializers, MailLog object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
        result
            ..add(r'total')
            ..add(serializers.serialize(object.total,
                specifiedType: const FullType(int)));
        result
            ..add(r'skip')
            ..add(serializers.serialize(object.skip,
                specifiedType: const FullType(int)));
        result
            ..add(r'limit')
            ..add(serializers.serialize(object.limit,
                specifiedType: const FullType(int)));
        result
            ..add(r'emails')
            ..add(serializers.serialize(object.emails,
                specifiedType: const FullType(BuiltList, [FullType(MailLogEntry)])));
        return result;
    }

    @override
    MailLog deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = MailLogBuilder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final Object? value = iterator.current;
            
            switch (key) {
                case r'total':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(int)) as int;
                    result.total = valueDes;
                    break;
                case r'skip':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(int)) as int;
                    result.skip = valueDes;
                    break;
                case r'limit':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(int)) as int;
                    result.limit = valueDes;
                    break;
                case r'emails':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(BuiltList, [FullType(MailLogEntry)])) as BuiltList<MailLogEntry>;
                    result.emails.replace(valueDes);
                    break;
            }
        }
        return result.build();
    }
}

