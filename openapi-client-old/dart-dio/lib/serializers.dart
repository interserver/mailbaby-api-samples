//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.7

// ignore_for_file: unused_import

library serializers;

import 'package:built_value/iso_8601_date_time_serializer.dart';
import 'package:built_value/serializer.dart';
import 'package:built_collection/built_collection.dart';
import 'package:built_value/json_object.dart';
import 'package:built_value/standard_json_plugin.dart';

import 'package:openapi/model/error_response.dart';
import 'package:openapi/model/generic_response.dart';
import 'package:openapi/model/inline_response401.dart';
import 'package:openapi/model/mail_attachment.dart';
import 'package:openapi/model/mail_contact.dart';
import 'package:openapi/model/mail_log.dart';
import 'package:openapi/model/mail_order.dart';
import 'package:openapi/model/send_mail.dart';
import 'package:openapi/model/send_mail_adv.dart';
import 'package:openapi/model/send_mail_adv_from.dart';

part 'serializers.g.dart';

@SerializersFor(const [
  ErrorResponse,
  GenericResponse,
  InlineResponse401,
  MailAttachment,
  MailContact,
  MailLog,
  MailOrder,
  SendMail,
  SendMailAdv,
  SendMailAdvFrom,
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
