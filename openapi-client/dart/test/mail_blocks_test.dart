//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.18

// ignore_for_file: unused_element, unused_import
// ignore_for_file: always_put_required_named_parameters_first
// ignore_for_file: constant_identifier_names
// ignore_for_file: lines_longer_than_80_chars

import 'package:openapi/api.dart';
import 'package:test/test.dart';

// tests for MailBlocks
void main() {
  // final instance = MailBlocks();

  group('test MailBlocks', () {
    // Messages flagged by the `LOCAL_BL_RCPT` rspamd rule in the last 5 days. These are messages sent to recipients on a local block list.
    // List<MailBlockClickHouse> local (default value: const [])
    test('to test the property `local`', () async {
      // TODO
    });

    // Messages flagged by the `MBTRAP` rspamd rule in the last 5 days. These triggered MailBaby's honeypot / trap address detection.
    // List<MailBlockClickHouse> mbtrap (default value: const [])
    test('to test the property `mbtrap`', () async {
      // TODO
    });

    // Senders whose messages contained spam-indicative subjects (containing `@`, `smtp`, `socks4`, or `socks5`) with more than 4 occurrences of the same subject in the last 3 days.
    // List<MailBlockRspamd> subject (default value: const [])
    test('to test the property `subject`', () async {
      // TODO
    });


  });

}
