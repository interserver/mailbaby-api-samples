library swagger.api;

import 'dart:async';
import 'dart:convert';
import 'package:http/browser_client.dart';
import 'package:http/http.dart';

part 'api_client.dart';
part 'api_helper.dart';
part 'api_exception.dart';
part 'auth/authentication.dart';
part 'auth/api_key_auth.dart';
part 'auth/oauth.dart';
part 'auth/http_basic_auth.dart';

part 'api/blocking_api.dart';
part 'api/history_api.dart';
part 'api/sending_api.dart';
part 'api/services_api.dart';
part 'api/status_api.dart';
part 'model/deny_rule_new.dart';
part 'model/deny_rule_record.dart';
part 'model/email_address.dart';
part 'model/email_address_name.dart';
part 'model/email_address_names.dart';
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
part 'model/raw_mail.dart';
part 'model/send_mail.dart';
part 'model/send_mail_adv.dart';

ApiClient defaultApiClient = new ApiClient();
