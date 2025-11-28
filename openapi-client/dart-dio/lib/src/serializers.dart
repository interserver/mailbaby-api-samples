//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_import

import 'package:one_of_serializer/any_of_serializer.dart';
import 'package:one_of_serializer/one_of_serializer.dart';
import 'package:built_collection/built_collection.dart';
import 'package:built_value/json_object.dart';
import 'package:built_value/serializer.dart';
import 'package:built_value/standard_json_plugin.dart';
import 'package:built_value/iso_8601_date_time_serializer.dart';
import 'package:openapi/src/date_serializer.dart';
import 'package:openapi/src/model/date.dart';

import 'package:openapi/src/model/deny_rule_new.dart';
import 'package:openapi/src/model/deny_rule_record.dart';
import 'package:openapi/src/model/email_address_name.dart';
import 'package:openapi/src/model/email_address_types.dart';
import 'package:openapi/src/model/email_addresses_types.dart';
import 'package:openapi/src/model/error_message.dart';
import 'package:openapi/src/model/generic_response.dart';
import 'package:openapi/src/model/mail_attachment.dart';
import 'package:openapi/src/model/mail_block_click_house.dart';
import 'package:openapi/src/model/mail_block_rspamd.dart';
import 'package:openapi/src/model/mail_blocks.dart';
import 'package:openapi/src/model/mail_log.dart';
import 'package:openapi/src/model/mail_log_entry.dart';
import 'package:openapi/src/model/mail_order.dart';
import 'package:openapi/src/model/mail_stats_type.dart';
import 'package:openapi/src/model/mail_stats_type_volume.dart';
import 'package:openapi/src/model/mail_stats_type_volume_from.dart';
import 'package:openapi/src/model/mail_stats_type_volume_ip.dart';
import 'package:openapi/src/model/mail_stats_type_volume_to.dart';
import 'package:openapi/src/model/send_mail.dart';
import 'package:openapi/src/model/send_mail_adv.dart';
import 'package:openapi/src/model/send_mail_raw.dart';

part 'serializers.g.dart';

@SerializersFor([
  DenyRuleNew,$DenyRuleNew,
  DenyRuleRecord,
  EmailAddressName,
  EmailAddressTypes,
  EmailAddressesTypes,
  ErrorMessage,
  GenericResponse,
  MailAttachment,
  MailBlockClickHouse,
  MailBlockRspamd,
  MailBlocks,
  MailLog,
  MailLogEntry,
  MailOrder,
  MailStatsType,
  MailStatsTypeVolume,
  MailStatsTypeVolumeFrom,
  MailStatsTypeVolumeIp,
  MailStatsTypeVolumeTo,
  SendMail,
  SendMailAdv,
  SendMailRaw,
])
Serializers serializers = (_$serializers.toBuilder()
      ..addBuilderFactory(
        const FullType(BuiltList, [FullType(DenyRuleRecord)]),
        () => ListBuilder<DenyRuleRecord>(),
      )
      ..addBuilderFactory(
        const FullType(BuiltList, [FullType(MailAttachment)]),
        () => ListBuilder<MailAttachment>(),
      )
      ..addBuilderFactory(
        const FullType(BuiltList, [FullType(MailOrder)]),
        () => ListBuilder<MailOrder>(),
      )
      ..add(DenyRuleNew.serializer)
      ..add(const OneOfSerializer())
      ..add(const AnyOfSerializer())
      ..add(const DateSerializer())
      ..add(Iso8601DateTimeSerializer())
    ).build();

Serializers standardSerializers =
    (serializers.toBuilder()..addPlugin(StandardJsonPlugin())).build();
