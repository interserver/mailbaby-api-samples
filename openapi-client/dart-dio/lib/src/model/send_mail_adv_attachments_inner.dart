//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'dart:typed_data';
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'send_mail_adv_attachments_inner.g.dart';

/// A File attachment for an email
///
/// Properties:
/// * [data] - Contents of the attached file (must be base64 encoded)
/// * [filename] - (optional) Filename to specify for the attachment.
abstract class SendMailAdvAttachmentsInner implements Built<SendMailAdvAttachmentsInner, SendMailAdvAttachmentsInnerBuilder> {
    /// Contents of the attached file (must be base64 encoded)
    @BuiltValueField(wireName: r'data')
    Uint8List get data;

    /// (optional) Filename to specify for the attachment.
    @BuiltValueField(wireName: r'filename')
    String? get filename;

    SendMailAdvAttachmentsInner._();

    @BuiltValueHook(initializeBuilder: true)
    static void _defaults(SendMailAdvAttachmentsInnerBuilder b) => b;

    factory SendMailAdvAttachmentsInner([void updates(SendMailAdvAttachmentsInnerBuilder b)]) = _$SendMailAdvAttachmentsInner;

    @BuiltValueSerializer(custom: true)
    static Serializer<SendMailAdvAttachmentsInner> get serializer => _$SendMailAdvAttachmentsInnerSerializer();
}

class _$SendMailAdvAttachmentsInnerSerializer implements StructuredSerializer<SendMailAdvAttachmentsInner> {
    @override
    final Iterable<Type> types = const [SendMailAdvAttachmentsInner, _$SendMailAdvAttachmentsInner];

    @override
    final String wireName = r'SendMailAdvAttachmentsInner';

    @override
    Iterable<Object?> serialize(Serializers serializers, SendMailAdvAttachmentsInner object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
        result
            ..add(r'data')
            ..add(serializers.serialize(object.data,
                specifiedType: const FullType(Uint8List)));
        if (object.filename != null) {
            result
                ..add(r'filename')
                ..add(serializers.serialize(object.filename,
                    specifiedType: const FullType(String)));
        }
        return result;
    }

    @override
    SendMailAdvAttachmentsInner deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = SendMailAdvAttachmentsInnerBuilder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final Object? value = iterator.current;
            
            switch (key) {
                case r'data':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(Uint8List)) as Uint8List;
                    result.data = valueDes;
                    break;
                case r'filename':
                    final valueDes = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    result.filename = valueDes;
                    break;
            }
        }
        return result.build();
    }
}

