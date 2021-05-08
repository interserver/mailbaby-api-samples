//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.7

// ignore_for_file: unused_import

import 'dart:typed_data';
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'mail_attachment.g.dart';

abstract class MailAttachment implements Built<MailAttachment, MailAttachmentBuilder> {

    /// Contents of the attached file
    @BuiltValueField(wireName: r'data')
    Uint8List get data;

    /// Optional filename to specify for the attachment.
    @nullable
    @BuiltValueField(wireName: r'filename')
    String get filename;

    MailAttachment._();

    static void _initializeBuilder(MailAttachmentBuilder b) => b;

    factory MailAttachment([void updates(MailAttachmentBuilder b)]) = _$MailAttachment;

    @BuiltValueSerializer(custom: true)
    static Serializer<MailAttachment> get serializer => _$MailAttachmentSerializer();
}

class _$MailAttachmentSerializer implements StructuredSerializer<MailAttachment> {

    @override
    final Iterable<Type> types = const [MailAttachment, _$MailAttachment];
    @override
    final String wireName = r'MailAttachment';

    @override
    Iterable<Object> serialize(Serializers serializers, MailAttachment object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object>[];
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
    MailAttachment deserialize(Serializers serializers, Iterable<Object> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = MailAttachmentBuilder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final dynamic value = iterator.current;
            switch (key) {
                case r'data':
                    result.data = serializers.deserialize(value,
                        specifiedType: const FullType(Uint8List)) as Uint8List;
                    break;
                case r'filename':
                    result.filename = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
            }
        }
        return result.build();
    }
}

