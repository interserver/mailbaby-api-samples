//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_import

import 'package:built_collection/built_collection.dart';
import 'package:built_value/json_object.dart';
import 'package:built_value/serializer.dart';
import 'package:built_value/standard_json_plugin.dart';
import 'package:built_value/iso_8601_date_time_serializer.dart';
import 'package:openapi/src/date_serializer.dart';
import 'package:openapi/src/model/date.dart';

import 'package:openapi/src/model/generic_response.dart';
import 'package:openapi/src/model/get_mail_orders200_response_inner.dart';
import 'package:openapi/src/model/get_mail_orders401_response.dart';
import 'package:openapi/src/model/mail_log.dart';
import 'package:openapi/src/model/mail_log_entry.dart';
import 'package:openapi/src/model/send_mail.dart';
import 'package:openapi/src/model/send_mail_adv.dart';
import 'package:openapi/src/model/send_mail_adv_attachments_inner.dart';
import 'package:openapi/src/model/send_mail_adv_bcc_inner.dart';
import 'package:openapi/src/model/send_mail_adv_cc_inner.dart';
import 'package:openapi/src/model/send_mail_adv_from.dart';
import 'package:openapi/src/model/send_mail_adv_replyto_inner.dart';
import 'package:openapi/src/model/send_mail_adv_to_inner.dart';

part 'serializers.g.dart';

@SerializersFor([
  GenericResponse,
  GetMailOrders200ResponseInner,
  GetMailOrders401Response,
  MailLog,
  MailLogEntry,
  SendMail,
  SendMailAdv,
  SendMailAdvAttachmentsInner,
  SendMailAdvBccInner,
  SendMailAdvCcInner,
  SendMailAdvFrom,
  SendMailAdvReplytoInner,
  SendMailAdvToInner,
])
Serializers serializers = (_$serializers.toBuilder()
      ..addBuilderFactory(
        const FullType(BuiltList, [FullType(GetMailOrders200ResponseInner)]),
        () => ListBuilder<GetMailOrders200ResponseInner>(),
      )
      ..add(const DateSerializer())
      ..add(Iso8601DateTimeSerializer()))
    .build();

Serializers standardSerializers =
    (serializers.toBuilder()..addPlugin(StandardJsonPlugin())).build();
