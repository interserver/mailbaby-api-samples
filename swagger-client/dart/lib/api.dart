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

part 'api/default_api.dart';
part 'model/generic_response.dart';
part 'model/inline_response200.dart';
part 'model/inline_response401.dart';
part 'model/mail_log.dart';
part 'model/mail_log_entry.dart';
part 'model/send_mail.dart';
part 'model/send_mail_adv.dart';
part 'model/send_mail_adv_attachments.dart';
part 'model/send_mail_adv_bcc.dart';
part 'model/send_mail_adv_cc.dart';
part 'model/send_mail_adv_from.dart';
part 'model/send_mail_adv_replyto.dart';
part 'model/send_mail_adv_to.dart';

ApiClient defaultApiClient = new ApiClient();
