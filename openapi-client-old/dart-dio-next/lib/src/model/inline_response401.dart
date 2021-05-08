//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'inline_response401.g.dart';



abstract class InlineResponse401 implements Built<InlineResponse401, InlineResponse401Builder> {
    @BuiltValueField(wireName: r'code')
    String get code;

    @BuiltValueField(wireName: r'message')
    String get message;

    InlineResponse401._();

    static void _initializeBuilder(InlineResponse401Builder b) => b;

    factory InlineResponse401([void updates(InlineResponse401Builder b)]) = _$InlineResponse401;

    @BuiltValueSerializer(custom: true)
    static Serializer<InlineResponse401> get serializer => _$InlineResponse401Serializer();
}

class _$InlineResponse401Serializer implements StructuredSerializer<InlineResponse401> {
    @override
    final Iterable<Type> types = const [InlineResponse401, _$InlineResponse401];

    @override
    final String wireName = r'InlineResponse401';

    @override
    Iterable<Object?> serialize(Serializers serializers, InlineResponse401 object,
        {FullType specifiedType = FullType.unspecified}) {
        final result = <Object?>[];
        result
            ..add(r'code')
            ..add(serializers.serialize(object.code,
                specifiedType: const FullType(String)));
        result
            ..add(r'message')
            ..add(serializers.serialize(object.message,
                specifiedType: const FullType(String)));
        return result;
    }

    @override
    InlineResponse401 deserialize(Serializers serializers, Iterable<Object?> serialized,
        {FullType specifiedType = FullType.unspecified}) {
        final result = InlineResponse401Builder();

        final iterator = serialized.iterator;
        while (iterator.moveNext()) {
            final key = iterator.current as String;
            iterator.moveNext();
            final Object? value = iterator.current;
            switch (key) {
                case r'code':
                    result.code = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
                case r'message':
                    result.message = serializers.deserialize(value,
                        specifiedType: const FullType(String)) as String;
                    break;
            }
        }
        return result.build();
    }
}

