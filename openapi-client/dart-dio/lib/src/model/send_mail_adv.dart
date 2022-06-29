//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:openapi/src/model/send_mail_adv_attachments_inner.dart';
import 'package:openapi/src/model/send_mail_adv_bcc_inner.dart';
import 'package:openapi/src/model/send_mail_adv_from.dart';
import 'package:openapi/src/model/send_mail_adv_cc_inner.dart';
import 'package:openapi/src/model/send_mail_adv_replyto_inner.dart';
import 'package:built_collection/built_collection.dart';
import 'package:openapi/src/model/send_mail_adv_to_inner.dart';
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'send_mail_adv.g.dart';

/// Details for an Email
///
/// Properties:
/// * [subject] - The subject or title of the email
/// * [body] - The main email contents.
/// * [from] 
/// * [to] - A list of destionation email addresses to send this to
/// * [replyto] - (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address.
/// * [cc] - (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.
/// * [bcc] - (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.
/// * [attachments] - (optional) File attachments to include in the email.  The file contents must be base64 encoded!
/// * [id] - (optional)  ID of the Mail order within our system to use as the Mail Account.
abstract class SendMailAdv implements Built<SendMailAdv, SendMailAdvBuilder> {
    /// The subject or title of the email
    @BuiltValueField(wireName: r'subject')
    String get subject;

    /// The main email contents.
    @BuiltValueField(wireName: r'body')
    String get body;

    @BuiltValueField(wireName: r'from')
    SendMailAdvFrom get from;

    /// A list of destionation email addresses to send this to
    @BuiltValueField(wireName: r'to')
    BuiltList<SendMailAdvToInner> get to;

    /// (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address.
    @BuiltValueField(wireName: r'replyto')
    BuiltList<SendMailAdvReplytoInner>? get replyto;

    /// (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.
    @BuiltValueField(wireName: r'cc')
    BuiltList<SendMailAdvCcInner>? get cc;

    /// (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.
    @BuiltValueField(wireName: r'bcc')
    BuiltList<SendMailAdvBccInner>? get bcc;

    /// (optional) File attachments to include in the email.  The file contents must be base64 encoded!
    @BuiltValueField(wireName: r'attachments')
    BuiltList<SendMailAdvAttachmentsInner>? get attachments;

    /// (optional)  ID of the Mail order within our system to use as the Mail Account.
    @BuiltValueField(wireName: r'id')
    int? get id;

    SendMailAdv._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(SendMailAdvBuilder b) => b;

    factory SendMailAdv([void updates(SendMailAdvBuilder b)]) = _$SendMailAdv;

    @BuiltValueSerializer(custom: true)
    static Serializer<SendMailAdv> get serializer => _$SendMailAdvSerializer();
}

class _$SendMailAdvSerializer implements StructuredSerializer<SendMailAdv> {
    @override
    final Iterable<Type> types = const [SendMailAdv, _$SendMailAdv];

    @override
    final String wireName = r'SendMailAdv';

    @override
    Iterable<Object?> serialize(Serializers serializers, SendMailAdv object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
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
                specifiedType: const FullType(SendMailAdvFrom)));
        result
            ..add(r'to')
            ..add(serializers.serialize(object.to,
                specifiedType: const FullType(BuiltList, [FullType(SendMailAdvToInner)])));
        if (object.replyto != null) {
            result
                ..add(r'replyto')
                ..add(serializers.serialize(object.replyto,
                    specifiedType: const FullType(BuiltList, [FullType(SendMailAdvReplytoInner)])));
        }
        if (object.cc != null) {
            result
                ..add(r'cc')
                ..add(serializers.serialize(object.cc,
                    specifiedType: const FullType(BuiltList, [FullType(SendMailAdvCcInner)])));
        }
        if (object.bcc != null) {
            result
                ..add(r'bcc')
                ..add(serializers.serialize(object.bcc,
                    specifiedType: const FullType(BuiltList, [FullType(SendMailAdvBccInner)])));
        }
        if (object.attachments != null) {
            result
                ..add(r'attachments')
                ..add(serializers.serialize(object.attachments,
                    specifiedType: const FullType(BuiltList, [FullType(SendMailAdvAttachmentsInner)])));
        }
        if (object.id != null) {
            result
                ..add(r'id')
                ..add(serializers.serialize(object.id,
                    specifiedType: const FullType(int)));
        }
        return result;
    }

    @override
    SendMailAdv deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = SendMailAdvBuilder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final Object? value = iterator.current;
            
            switch (key) {
                case r'subject':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    result.subject = valueDes;
                    break;
                case r'body':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    result.body = valueDes;
                    break;
                case r'from':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(SendMailAdvFrom)) as SendMailAdvFrom;
                    result.from.replace(valueDes);
                    break;
                case r'to':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(BuiltList, [FullType(SendMailAdvToInner)])) as BuiltList<SendMailAdvToInner>;
                    result.to.replace(valueDes);
                    break;
                case r'replyto':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(BuiltList, [FullType(SendMailAdvReplytoInner)])) as BuiltList<SendMailAdvReplytoInner>;
                    result.replyto.replace(valueDes);
                    break;
                case r'cc':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(BuiltList, [FullType(SendMailAdvCcInner)])) as BuiltList<SendMailAdvCcInner>;
                    result.cc.replace(valueDes);
                    break;
                case r'bcc':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(BuiltList, [FullType(SendMailAdvBccInner)])) as BuiltList<SendMailAdvBccInner>;
                    result.bcc.replace(valueDes);
                    break;
                case r'attachments':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(BuiltList, [FullType(SendMailAdvAttachmentsInner)])) as BuiltList<SendMailAdvAttachmentsInner>;
                    result.attachments.replace(valueDes);
                    break;
                case r'id':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(int)) as int;
                    result.id = valueDes;
                    break;
            }
        }
        return result.build();
    }
}

