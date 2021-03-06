//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'mail_log_entry.g.dart';

/// An email record
///
/// Properties:
/// * [id] - internal db id
/// * [id] - mail id
/// * [from] - from address
/// * [to] - to address
/// * [subject] - email subject
/// * [messageId] - message id
/// * [created] - creation date
/// * [time] - creation timestamp
/// * [user] - user account
/// * [transtype] - transaction type
/// * [transhost] - transaction host
/// * [originhost] - origin host
/// * [origin] - origin ip
/// * [interface_] - interface name
/// * [date] - date processed
/// * [sendingZone] - sending zone
/// * [bodySize] - email body size in bytes
/// * [sourceMd5] - md5 sum of the email
/// * [seq] - delivery sequency
/// * [domain] - to address domain
/// * [recipient] - email receiver address
/// * [locked] - locked status
/// * [lockTime] - lock timestamp
/// * [assigned] - assigned server
/// * [queued] - queued timestamp
/// * [lock] - lock id
/// * [logger] - logger
/// * [mxPort] - mx port number
/// * [connectionKey] - connection key
/// * [mxHostname] - mx hostname
/// * [sentBodyHash] - body hash
/// * [sentBodySize] - sent body size in bytes
/// * [md5Match] - md5 checksum matching result
abstract class MailLogEntry implements Built<MailLogEntry, MailLogEntryBuilder> {
    /// internal db id
    @BuiltValueField(wireName: r'_id')
    int get id;

    /// mail id
    @BuiltValueField(wireName: r'id')
    String get id;

    /// from address
    @BuiltValueField(wireName: r'from')
    String get from;

    /// to address
    @BuiltValueField(wireName: r'to')
    String get to;

    /// email subject
    @BuiltValueField(wireName: r'subject')
    String get subject;

    /// message id
    @BuiltValueField(wireName: r'messageId')
    String get messageId;

    /// creation date
    @BuiltValueField(wireName: r'created')
    String get created;

    /// creation timestamp
    @BuiltValueField(wireName: r'time')
    int get time;

    /// user account
    @BuiltValueField(wireName: r'user')
    String get user;

    /// transaction type
    @BuiltValueField(wireName: r'transtype')
    String get transtype;

    /// transaction host
    @BuiltValueField(wireName: r'transhost')
    String get transhost;

    /// origin host
    @BuiltValueField(wireName: r'originhost')
    String get originhost;

    /// origin ip
    @BuiltValueField(wireName: r'origin')
    String get origin;

    /// interface name
    @BuiltValueField(wireName: r'interface')
    String get interface_;

    /// date processed
    @BuiltValueField(wireName: r'date')
    String get date;

    /// sending zone
    @BuiltValueField(wireName: r'sendingZone')
    String get sendingZone;

    /// email body size in bytes
    @BuiltValueField(wireName: r'bodySize')
    int get bodySize;

    /// md5 sum of the email
    @BuiltValueField(wireName: r'sourceMd5')
    String get sourceMd5;

    /// delivery sequency
    @BuiltValueField(wireName: r'seq')
    int get seq;

    /// to address domain
    @BuiltValueField(wireName: r'domain')
    String get domain;

    /// email receiver address
    @BuiltValueField(wireName: r'recipient')
    String get recipient;

    /// locked status
    @BuiltValueField(wireName: r'locked')
    int get locked;

    /// lock timestamp
    @BuiltValueField(wireName: r'lockTime')
    int get lockTime;

    /// assigned server
    @BuiltValueField(wireName: r'assigned')
    String get assigned;

    /// queued timestamp
    @BuiltValueField(wireName: r'queued')
    String get queued;

    /// lock id
    @BuiltValueField(wireName: r'_lock')
    String get lock;

    /// logger
    @BuiltValueField(wireName: r'logger')
    String get logger;

    /// mx port number
    @BuiltValueField(wireName: r'mxPort')
    int get mxPort;

    /// connection key
    @BuiltValueField(wireName: r'connectionKey')
    String get connectionKey;

    /// mx hostname
    @BuiltValueField(wireName: r'mxHostname')
    String get mxHostname;

    /// body hash
    @BuiltValueField(wireName: r'sentBodyHash')
    String get sentBodyHash;

    /// sent body size in bytes
    @BuiltValueField(wireName: r'sentBodySize')
    int get sentBodySize;

    /// md5 checksum matching result
    @BuiltValueField(wireName: r'md5Match')
    int get md5Match;

    MailLogEntry._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(MailLogEntryBuilder b) => b;

    factory MailLogEntry([void updates(MailLogEntryBuilder b)]) = _$MailLogEntry;

    @BuiltValueSerializer(custom: true)
    static Serializer<MailLogEntry> get serializer => _$MailLogEntrySerializer();
}

class _$MailLogEntrySerializer implements StructuredSerializer<MailLogEntry> {
    @override
    final Iterable<Type> types = const [MailLogEntry, _$MailLogEntry];

    @override
    final String wireName = r'MailLogEntry';

    @override
    Iterable<Object?> serialize(Serializers serializers, MailLogEntry object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
        result
            ..add(r'_id')
            ..add(serializers.serialize(object.id,
                specifiedType: const FullType(int)));
        result
            ..add(r'id')
            ..add(serializers.serialize(object.id,
                specifiedType: const FullType(String)));
        result
            ..add(r'from')
            ..add(serializers.serialize(object.from,
                specifiedType: const FullType(String)));
        result
            ..add(r'to')
            ..add(serializers.serialize(object.to,
                specifiedType: const FullType(String)));
        result
            ..add(r'subject')
            ..add(serializers.serialize(object.subject,
                specifiedType: const FullType(String)));
        result
            ..add(r'messageId')
            ..add(serializers.serialize(object.messageId,
                specifiedType: const FullType(String)));
        result
            ..add(r'created')
            ..add(serializers.serialize(object.created,
                specifiedType: const FullType(String)));
        result
            ..add(r'time')
            ..add(serializers.serialize(object.time,
                specifiedType: const FullType(int)));
        result
            ..add(r'user')
            ..add(serializers.serialize(object.user,
                specifiedType: const FullType(String)));
        result
            ..add(r'transtype')
            ..add(serializers.serialize(object.transtype,
                specifiedType: const FullType(String)));
        result
            ..add(r'transhost')
            ..add(serializers.serialize(object.transhost,
                specifiedType: const FullType(String)));
        result
            ..add(r'originhost')
            ..add(serializers.serialize(object.originhost,
                specifiedType: const FullType(String)));
        result
            ..add(r'origin')
            ..add(serializers.serialize(object.origin,
                specifiedType: const FullType(String)));
        result
            ..add(r'interface')
            ..add(serializers.serialize(object.interface_,
                specifiedType: const FullType(String)));
        result
            ..add(r'date')
            ..add(serializers.serialize(object.date,
                specifiedType: const FullType(String)));
        result
            ..add(r'sendingZone')
            ..add(serializers.serialize(object.sendingZone,
                specifiedType: const FullType(String)));
        result
            ..add(r'bodySize')
            ..add(serializers.serialize(object.bodySize,
                specifiedType: const FullType(int)));
        result
            ..add(r'sourceMd5')
            ..add(serializers.serialize(object.sourceMd5,
                specifiedType: const FullType(String)));
        result
            ..add(r'seq')
            ..add(serializers.serialize(object.seq,
                specifiedType: const FullType(int)));
        result
            ..add(r'domain')
            ..add(serializers.serialize(object.domain,
                specifiedType: const FullType(String)));
        result
            ..add(r'recipient')
            ..add(serializers.serialize(object.recipient,
                specifiedType: const FullType(String)));
        result
            ..add(r'locked')
            ..add(serializers.serialize(object.locked,
                specifiedType: const FullType(int)));
        result
            ..add(r'lockTime')
            ..add(serializers.serialize(object.lockTime,
                specifiedType: const FullType(int)));
        result
            ..add(r'assigned')
            ..add(serializers.serialize(object.assigned,
                specifiedType: const FullType(String)));
        result
            ..add(r'queued')
            ..add(serializers.serialize(object.queued,
                specifiedType: const FullType(String)));
        result
            ..add(r'_lock')
            ..add(serializers.serialize(object.lock,
                specifiedType: const FullType(String)));
        result
            ..add(r'logger')
            ..add(serializers.serialize(object.logger,
                specifiedType: const FullType(String)));
        result
            ..add(r'mxPort')
            ..add(serializers.serialize(object.mxPort,
                specifiedType: const FullType(int)));
        result
            ..add(r'connectionKey')
            ..add(serializers.serialize(object.connectionKey,
                specifiedType: const FullType(String)));
        result
            ..add(r'mxHostname')
            ..add(serializers.serialize(object.mxHostname,
                specifiedType: const FullType(String)));
        result
            ..add(r'sentBodyHash')
            ..add(serializers.serialize(object.sentBodyHash,
                specifiedType: const FullType(String)));
        result
            ..add(r'sentBodySize')
            ..add(serializers.serialize(object.sentBodySize,
                specifiedType: const FullType(int)));
        result
            ..add(r'md5Match')
            ..add(serializers.serialize(object.md5Match,
                specifiedType: const FullType(int)));
        return result;
    }

    @override
    MailLogEntry deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = MailLogEntryBuilder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final Object? value = iterator.current;
            
            switch (key) {
                case r'_id':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(int)) as int;
                    result.id = valueDes;
                    break;
                case r'id':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    result.id = valueDes;
                    break;
                case r'from':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    result.from = valueDes;
                    break;
                case r'to':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    result.to = valueDes;
                    break;
                case r'subject':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    result.subject = valueDes;
                    break;
                case r'messageId':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    result.messageId = valueDes;
                    break;
                case r'created':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    result.created = valueDes;
                    break;
                case r'time':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(int)) as int;
                    result.time = valueDes;
                    break;
                case r'user':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    result.user = valueDes;
                    break;
                case r'transtype':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    result.transtype = valueDes;
                    break;
                case r'transhost':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    result.transhost = valueDes;
                    break;
                case r'originhost':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    result.originhost = valueDes;
                    break;
                case r'origin':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    result.origin = valueDes;
                    break;
                case r'interface':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    result.interface_ = valueDes;
                    break;
                case r'date':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    result.date = valueDes;
                    break;
                case r'sendingZone':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    result.sendingZone = valueDes;
                    break;
                case r'bodySize':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(int)) as int;
                    result.bodySize = valueDes;
                    break;
                case r'sourceMd5':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    result.sourceMd5 = valueDes;
                    break;
                case r'seq':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(int)) as int;
                    result.seq = valueDes;
                    break;
                case r'domain':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    result.domain = valueDes;
                    break;
                case r'recipient':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    result.recipient = valueDes;
                    break;
                case r'locked':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(int)) as int;
                    result.locked = valueDes;
                    break;
                case r'lockTime':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(int)) as int;
                    result.lockTime = valueDes;
                    break;
                case r'assigned':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    result.assigned = valueDes;
                    break;
                case r'queued':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    result.queued = valueDes;
                    break;
                case r'_lock':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    result.lock = valueDes;
                    break;
                case r'logger':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    result.logger = valueDes;
                    break;
                case r'mxPort':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(int)) as int;
                    result.mxPort = valueDes;
                    break;
                case r'connectionKey':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    result.connectionKey = valueDes;
                    break;
                case r'mxHostname':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    result.mxHostname = valueDes;
                    break;
                case r'sentBodyHash':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    result.sentBodyHash = valueDes;
                    break;
                case r'sentBodySize':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(int)) as int;
                    result.sentBodySize = valueDes;
                    break;
                case r'md5Match':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(int)) as int;
                    result.md5Match = valueDes;
                    break;
            }
        }
        return result.build();
    }
}

