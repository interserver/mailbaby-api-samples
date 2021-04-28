//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'generic_response.g.dart';



abstract class GenericResponse implements Built<GenericResponse, GenericResponseBuilder> {
    @BuiltValueField(wireName: r'status')
    String? get status;

    @BuiltValueField(wireName: r'status_text')
    String? get statusText;

    GenericResponse._();

    static void _initializeBuilder(GenericResponseBuilder b) => b;

    factory GenericResponse([void updates(GenericResponseBuilder b)]) = _$GenericResponse;

    @BuiltValueSerializer(custom: true)
    static Serializer<GenericResponse> get serializer => _$GenericResponseSerializer();
}

class _$GenericResponseSerializer implements StructuredSerializer<GenericResponse> {
    @override
    final Iterable<Type> types = const [GenericResponse, _$GenericResponse];

    @override
    final String wireName = r'GenericResponse';

    @override
    Iterable<Object?> serialize(Serializers serializers, GenericResponse object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
        if (object.status != null) {
            result
                ..add(r'status')
                ..add(serializers.serialize(object.status,
                    specifiedType: const FullType(String)));
        }
        if (object.statusText != null) {
            result
                ..add(r'status_text')
                ..add(serializers.serialize(object.statusText,
                    specifiedType: const FullType(String)));
        }
        return result;
    }

    @override
    GenericResponse deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = GenericResponseBuilder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final Object? value = iterator.current;
            switch (key) {
                case r'status':
                    result.status = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
                case r'status_text':
                    result.statusText = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
            }
        }
        return result.build();
    }
}

