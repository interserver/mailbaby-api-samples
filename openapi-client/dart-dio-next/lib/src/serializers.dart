//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

import 'package:built_collection/built_collection.dart';
import 'package:built_value/json_object.dart';
import 'package:built_value/serializer.dart';
import 'package:built_value/standard_json_plugin.dart';
import 'package:built_value/iso_8601_date_time_serializer.dart';

import 'package:openapi/src/model/error_response.dart';
import 'package:openapi/src/model/generic_response.dart';
import 'package:openapi/src/model/mail_attachment.dart';
import 'package:openapi/src/model/mail_contact.dart';
import 'package:openapi/src/model/mail_log.dart';
import 'package:openapi/src/model/mail_order.dart';
import 'package:openapi/src/model/send_mail.dart';

part 'serializers.g.dart';

@SerializersFor([
  ErrorResponse,
  GenericResponse,
  MailAttachment,
  MailContact,
  MailLog,
  MailOrder,
  SendMail,
])
Serializers serializers = (_$serializers.toBuilder()
      ..addBuilderFactory(
        const FullType(BuiltList, [FullType(MailLog)]),
        () => ListBuilder<MailLog>(),
      )
      ..addBuilderFactory(
        const FullType(BuiltList, [FullType(MailOrder)]),
        () => ListBuilder<MailOrder>(),
      )
      ..add(Iso8601DateTimeSerializer()))
    .build();

Serializers standardSerializers =
    (serializers.toBuilder()..addPlugin(StandardJsonPlugin())).build();