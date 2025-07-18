//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.18

// ignore_for_file: unused_element, unused_import
// ignore_for_file: always_put_required_named_parameters_first
// ignore_for_file: constant_identifier_names
// ignore_for_file: lines_longer_than_80_chars

library openapi.api;

import 'dart:async';
import 'dart:convert';
import 'dart:io';

import 'package:collection/collection.dart';
import 'package:http/http.dart';
import 'package:intl/intl.dart';
import 'package:meta/meta.dart';

part 'api_client.dart';
part 'api_helper.dart';
part 'api_exception.dart';
part 'auth/authentication.dart';
part 'auth/api_key_auth.dart';
part 'auth/oauth.dart';
part 'auth/http_basic_auth.dart';
part 'auth/http_bearer_auth.dart';

part 'api/blocking_api.dart';
part 'api/history_api.dart';
part 'api/sending_api.dart';
part 'api/services_api.dart';
part 'api/status_api.dart';

part 'model/deny_rule_new.dart';
part 'model/deny_rule_record.dart';
part 'model/email_address_name.dart';
part 'model/email_address_types.dart';
part 'model/email_addresses_types.dart';
part 'model/error_message.dart';
part 'model/generic_response.dart';
part 'model/mail_attachment.dart';
part 'model/mail_block_click_house.dart';
part 'model/mail_block_rspamd.dart';
part 'model/mail_blocks.dart';
part 'model/mail_log.dart';
part 'model/mail_log_entry.dart';
part 'model/mail_order.dart';
part 'model/mail_stats_type.dart';
part 'model/mail_stats_type_volume.dart';
part 'model/mail_stats_type_volume_from.dart';
part 'model/mail_stats_type_volume_ip.dart';
part 'model/mail_stats_type_volume_to.dart';
part 'model/send_mail.dart';
part 'model/send_mail_adv.dart';


/// An [ApiClient] instance that uses the default values obtained from
/// the OpenAPI specification file.
var defaultApiClient = ApiClient();

const _delimiters = {'csv': ',', 'ssv': ' ', 'tsv': '\t', 'pipes': '|'};
const _dateEpochMarker = 'epoch';
const _deepEquality = DeepCollectionEquality();
final _dateFormatter = DateFormat('yyyy-MM-dd');
final _regList = RegExp(r'^List<(.*)>$');
final _regSet = RegExp(r'^Set<(.*)>$');
final _regMap = RegExp(r'^Map<String,(.*)>$');

bool _isEpochMarker(String? pattern) => pattern == _dateEpochMarker || pattern == '/$_dateEpochMarker/';
