import 'package:openapi/src/model/date_or_timestamp.dart';
import 'package:openapi/src/model/deny_rule_new.dart';
import 'package:openapi/src/model/deny_rule_record.dart';
import 'package:openapi/src/model/email_address_name.dart';
import 'package:openapi/src/model/email_address_param.dart';
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
import 'package:openapi/src/model/mail_order_detail.dart';
import 'package:openapi/src/model/mail_stats_type.dart';
import 'package:openapi/src/model/mail_stats_volume.dart';
import 'package:openapi/src/model/send_mail.dart';
import 'package:openapi/src/model/send_mail_adv.dart';
import 'package:openapi/src/model/send_mail_raw.dart';
import 'package:openapi/src/model/send_mail_to.dart';

final _regList = RegExp(r'^List<(.*)>$');
final _regSet = RegExp(r'^Set<(.*)>$');
final _regMap = RegExp(r'^Map<String,(.*)>$');

  ReturnType deserialize<ReturnType, BaseType>(dynamic value, String targetType, {bool growable= true}) {
      switch (targetType) {
        case 'String':
          return '$value' as ReturnType;
        case 'int':
          return (value is int ? value : int.parse('$value')) as ReturnType;
        case 'bool':
          if (value is bool) {
            return value as ReturnType;
          }
          final valueString = '$value'.toLowerCase();
          return (valueString == 'true' || valueString == '1') as ReturnType;
        case 'double':
          return (value is double ? value : double.parse('$value')) as ReturnType;
        case 'DateOrTimestamp':
          return DateOrTimestamp.fromJson(value as Map<String, dynamic>) as ReturnType;
        case 'DenyRuleNew':
          return DenyRuleNew.fromJson(value as Map<String, dynamic>) as ReturnType;
        case 'DenyRuleRecord':
          return DenyRuleRecord.fromJson(value as Map<String, dynamic>) as ReturnType;
        case 'EmailAddressName':
          return EmailAddressName.fromJson(value as Map<String, dynamic>) as ReturnType;
        case 'EmailAddressParam':
          return EmailAddressParam.fromJson(value as Map<String, dynamic>) as ReturnType;
        case 'EmailAddressTypes':
          return EmailAddressTypes.fromJson(value as Map<String, dynamic>) as ReturnType;
        case 'EmailAddressesTypes':
          return EmailAddressesTypes.fromJson(value as Map<String, dynamic>) as ReturnType;
        case 'ErrorMessage':
          return ErrorMessage.fromJson(value as Map<String, dynamic>) as ReturnType;
        case 'GenericResponse':
          return GenericResponse.fromJson(value as Map<String, dynamic>) as ReturnType;
        case 'MailAttachment':
          return MailAttachment.fromJson(value as Map<String, dynamic>) as ReturnType;
        case 'MailBlockClickHouse':
          return MailBlockClickHouse.fromJson(value as Map<String, dynamic>) as ReturnType;
        case 'MailBlockRspamd':
          return MailBlockRspamd.fromJson(value as Map<String, dynamic>) as ReturnType;
        case 'MailBlocks':
          return MailBlocks.fromJson(value as Map<String, dynamic>) as ReturnType;
        case 'MailLog':
          return MailLog.fromJson(value as Map<String, dynamic>) as ReturnType;
        case 'MailLogEntry':
          return MailLogEntry.fromJson(value as Map<String, dynamic>) as ReturnType;
        case 'MailOrder':
          return MailOrder.fromJson(value as Map<String, dynamic>) as ReturnType;
        case 'MailOrderDetail':
          return MailOrderDetail.fromJson(value as Map<String, dynamic>) as ReturnType;
        case 'MailStatsType':
          return MailStatsType.fromJson(value as Map<String, dynamic>) as ReturnType;
        case 'MailStatsVolume':
          return MailStatsVolume.fromJson(value as Map<String, dynamic>) as ReturnType;
        case 'SendMail':
          return SendMail.fromJson(value as Map<String, dynamic>) as ReturnType;
        case 'SendMailAdv':
          return SendMailAdv.fromJson(value as Map<String, dynamic>) as ReturnType;
        case 'SendMailRaw':
          return SendMailRaw.fromJson(value as Map<String, dynamic>) as ReturnType;
        case 'SendMailTo':
          return SendMailTo.fromJson(value as Map<String, dynamic>) as ReturnType;
        default:
          RegExpMatch? match;

          if (value is List && (match = _regList.firstMatch(targetType)) != null) {
            targetType = match![1]!; // ignore: parameter_assignments
            return value
              .map<BaseType>((dynamic v) => deserialize<BaseType, BaseType>(v, targetType, growable: growable))
              .toList(growable: growable) as ReturnType;
          }
          if (value is Set && (match = _regSet.firstMatch(targetType)) != null) {
            targetType = match![1]!; // ignore: parameter_assignments
            return value
              .map<BaseType>((dynamic v) => deserialize<BaseType, BaseType>(v, targetType, growable: growable))
              .toSet() as ReturnType;
          }
          if (value is Map && (match = _regMap.firstMatch(targetType)) != null) {
            targetType = match![1]!.trim(); // ignore: parameter_assignments
            return Map<String, BaseType>.fromIterables(
              value.keys as Iterable<String>,
              value.values.map((dynamic v) => deserialize<BaseType, BaseType>(v, targetType, growable: growable)),
            ) as ReturnType;
          }
          break;
    }
    throw Exception('Cannot deserialize');
  }