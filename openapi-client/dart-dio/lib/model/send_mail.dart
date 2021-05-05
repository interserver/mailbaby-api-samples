//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.7

// ignore_for_file: unused_import

import 'package:openapi/model/mail_contact.dart';
import 'package:openapi/model/send_mail_from.dart';
import 'package:built_collection/built_collection.dart';
import 'package:openapi/model/mail_attachment.dart';
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'send_mail.g.dart';

abstract class SendMail implements Built<SendMail, SendMailBuilder> {

    /// The subject or title of the email
    @BuiltValueField(wireName: r'subject')
    String get subject;

    /// The main email contents.
    @BuiltValueField(wireName: r'body')
    String get body;

    /// The contact whom is the this email is from.
    @BuiltValueField(wireName: r'from')
    BuiltList<SendMailFrom> get from;

    /// The Contact whom is the primary recipient of this email.
    @BuiltValueField(wireName: r'to')
    BuiltList<MailContact> get to;

    /// The ID of the Mail order within our system to use as the Mail Account.
    @BuiltValueField(wireName: r'id')
    int get id;

    /// Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address.
    @nullable
    @BuiltValueField(wireName: r'replyto')
    BuiltList<MailContact> get replyto;

    /// Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.
    @nullable
    @BuiltValueField(wireName: r'cc')
    BuiltList<MailContact> get cc;

    /// Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.
    @nullable
    @BuiltValueField(wireName: r'bcc')
    BuiltList<MailContact> get bcc;

    /// Optional file attachments to include in the email
    @nullable
    @BuiltValueField(wireName: r'attachments')
    BuiltList<MailAttachment> get attachments;

    SendMail._();

    static void _initializeBuilder(SendMailBuilder b) => b;

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
    Iterable<Object> serialize(Serializers serializers, SendMail object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object>[];
        result
            ..add(r'subject')
            ..add(serializers.serialize(object.subject,
                specifiedType: const FullType(String)));
        result
            ..add(r'body')
            ..add(serializers.serialize(object.body,
                specifiedType: const FullType(String)));
        result
            ..add(r'from')
            ..add(serializers.serialize(object.from,
                specifiedType: const FullType(BuiltList, [FullType(SendMailFrom)])));
        result
            ..add(r'to')
            ..add(serializers.serialize(object.to,
                specifiedType: const FullType(BuiltList, [FullType(MailContact)])));
        result
            ..add(r'id')
            ..add(serializers.serialize(object.id,
                specifiedType: const FullType(int)));
        if (object.replyto != null) {
            result
                ..add(r'replyto')
                ..add(serializers.serialize(object.replyto,
                    specifiedType: const FullType(BuiltList, [FullType(MailContact)])));
        }
        if (object.cc != null) {
            result
                ..add(r'cc')
                ..add(serializers.serialize(object.cc,
                    specifiedType: const FullType(BuiltList, [FullType(MailContact)])));
        }
        if (object.bcc != null) {
            result
                ..add(r'bcc')
                ..add(serializers.serialize(object.bcc,
                    specifiedType: const FullType(BuiltList, [FullType(MailContact)])));
        }
        if (object.attachments != null) {
            result
                ..add(r'attachments')
                ..add(serializers.serialize(object.attachments,
                    specifiedType: const FullType(BuiltList, [FullType(MailAttachment)])));
        }
        return result;
    }

    @override
    SendMail deserialize(Serializers serializers, Iterable<Object> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = SendMailBuilder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final dynamic value = iterator.current;
            switch (key) {
                case r'subject':
                    result.subject = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
                case r'body':
                    result.body = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
                case r'from':
                    result.from.replace(serializers.deserialize(value,
                        specifiedType: const FullType(BuiltList, [FullType(SendMailFrom)])) as BuiltList<SendMailFrom>);
                    break;
                case r'to':
                    result.to.replace(serializers.deserialize(value,
                        specifiedType: const FullType(BuiltList, [FullType(MailContact)])) as BuiltList<MailContact>);
                    break;
                case r'id':
                    result.id = serializers.deserialize(value,
                        specifiedType: const FullType(int)) as int;
                    break;
                case r'replyto':
                    result.replyto.replace(serializers.deserialize(value,
                        specifiedType: const FullType(BuiltList, [FullType(MailContact)])) as BuiltList<MailContact>);
                    break;
                case r'cc':
                    result.cc.replace(serializers.deserialize(value,
                        specifiedType: const FullType(BuiltList, [FullType(MailContact)])) as BuiltList<MailContact>);
                    break;
                case r'bcc':
                    result.bcc.replace(serializers.deserialize(value,
                        specifiedType: const FullType(BuiltList, [FullType(MailContact)])) as BuiltList<MailContact>);
                    break;
                case r'attachments':
                    result.attachments.replace(serializers.deserialize(value,
                        specifiedType: const FullType(BuiltList, [FullType(MailAttachment)])) as BuiltList<MailAttachment>);
                    break;
            }
        }
        return result.build();
    }
}

