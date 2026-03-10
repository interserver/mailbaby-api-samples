//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:built_collection/built_collection.dart';
import 'package:openapi/src/model/email_addresses_types.dart';
import 'package:openapi/src/model/email_address_types.dart';
import 'package:openapi/src/model/mail_attachment.dart';
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'send_mail_adv.g.dart';

/// Request body for `POST /mail/advsend`.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (`from`, `to`, `replyto`, `cc`, `bcc`) each accept either a plain RFC 822 string (e.g. `\"Joe <joe@example.com>\"` or a comma-separated list) or a structured array of `{\"email\": \"...\", \"name\": \"...\"}` objects.  HTML detection is automatic based on whether `body` contains HTML tags.
///
/// Properties:
/// * [subject] - The subject line of the email.
/// * [body] - The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.
/// * [from] 
/// * [to] 
/// * [replyto] 
/// * [cc] 
/// * [bcc] 
/// * [attachments] - Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name.
/// * [id] - Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.
@BuiltValue()
abstract class SendMailAdv implements Built<SendMailAdv, SendMailAdvBuilder> {
  /// The subject line of the email.
  @BuiltValueField(wireName: r'subject')
  String get subject;

  /// The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.
  @BuiltValueField(wireName: r'body')
  String get body;

  @BuiltValueField(wireName: r'from')
  EmailAddressTypes get from;

  @BuiltValueField(wireName: r'to')
  EmailAddressesTypes get to;

  @BuiltValueField(wireName: r'replyto')
  EmailAddressesTypes? get replyto;

  @BuiltValueField(wireName: r'cc')
  EmailAddressesTypes? get cc;

  @BuiltValueField(wireName: r'bcc')
  EmailAddressesTypes? get bcc;

  /// Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name.
  @BuiltValueField(wireName: r'attachments')
  BuiltList<MailAttachment>? get attachments;

  /// Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.
  @BuiltValueField(wireName: r'id')
  int? get id;

  SendMailAdv._();

  factory SendMailAdv([void updates(SendMailAdvBuilder b)]) = _$SendMailAdv;

  @BuiltValueHook(initializeBuilder: true)
  static void _defaults(SendMailAdvBuilder b) => b;

  @BuiltValueSerializer(custom: true)
  static Serializer<SendMailAdv> get serializer => _$SendMailAdvSerializer();
}

class _$SendMailAdvSerializer implements PrimitiveSerializer<SendMailAdv> {
  @override
  final Iterable<Type> types = const [SendMailAdv, _$SendMailAdv];

  @override
  final String wireName = r'SendMailAdv';

  Iterable<Object?> _serializeProperties(
    Serializers serializers,
    SendMailAdv object, {
    FullType specifiedType = FullType.unspecified,
  }) sync* {
    yield r'subject';
    yield serializers.serialize(
      object.subject,
      specifiedType: const FullType(String),
    );
    yield r'body';
    yield serializers.serialize(
      object.body,
      specifiedType: const FullType(String),
    );
    yield r'from';
    yield serializers.serialize(
      object.from,
      specifiedType: const FullType(EmailAddressTypes),
    );
    yield r'to';
    yield serializers.serialize(
      object.to,
      specifiedType: const FullType(EmailAddressesTypes),
    );
    if (object.replyto != null) {
      yield r'replyto';
      yield serializers.serialize(
        object.replyto,
        specifiedType: const FullType(EmailAddressesTypes),
      );
    }
    if (object.cc != null) {
      yield r'cc';
      yield serializers.serialize(
        object.cc,
        specifiedType: const FullType(EmailAddressesTypes),
      );
    }
    if (object.bcc != null) {
      yield r'bcc';
      yield serializers.serialize(
        object.bcc,
        specifiedType: const FullType(EmailAddressesTypes),
      );
    }
    if (object.attachments != null) {
      yield r'attachments';
      yield serializers.serialize(
        object.attachments,
        specifiedType: const FullType(BuiltList, [FullType(MailAttachment)]),
      );
    }
    if (object.id != null) {
      yield r'id';
      yield serializers.serialize(
        object.id,
        specifiedType: const FullType(int),
      );
    }
  }

  @override
  Object serialize(
    Serializers serializers,
    SendMailAdv object, {
    FullType specifiedType = FullType.unspecified,
  }) {
    return _serializeProperties(serializers, object, specifiedType: specifiedType).toList();
  }

  void _deserializeProperties(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
    required List<Object?> serializedList,
    required SendMailAdvBuilder result,
    required List<Object?> unhandled,
  }) {
    for (var i = 0; i < serializedList.length; i += 2) {
      final key = serializedList[i] as String;
      final value = serializedList[i + 1];
      switch (key) {
        case r'subject':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.subject = valueDes;
          break;
        case r'body':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.body = valueDes;
          break;
        case r'from':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(EmailAddressTypes),
          ) as EmailAddressTypes;
          result.from.replace(valueDes);
          break;
        case r'to':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(EmailAddressesTypes),
          ) as EmailAddressesTypes;
          result.to.replace(valueDes);
          break;
        case r'replyto':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(EmailAddressesTypes),
          ) as EmailAddressesTypes;
          result.replyto.replace(valueDes);
          break;
        case r'cc':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(EmailAddressesTypes),
          ) as EmailAddressesTypes;
          result.cc.replace(valueDes);
          break;
        case r'bcc':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(EmailAddressesTypes),
          ) as EmailAddressesTypes;
          result.bcc.replace(valueDes);
          break;
        case r'attachments':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(BuiltList, [FullType(MailAttachment)]),
          ) as BuiltList<MailAttachment>;
          result.attachments.replace(valueDes);
          break;
        case r'id':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(int),
          ) as int;
          result.id = valueDes;
          break;
        default:
          unhandled.add(key);
          unhandled.add(value);
          break;
      }
    }
  }

  @override
  SendMailAdv deserialize(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
  }) {
    final result = SendMailAdvBuilder();
    final serializedList = (serialized as Iterable<Object?>).toList();
    final unhandled = <Object?>[];
    _deserializeProperties(
      serializers,
      serialized,
      specifiedType: specifiedType,
      serializedList: serializedList,
      unhandled: unhandled,
      result: result,
    );
    return result.build();
  }
}

