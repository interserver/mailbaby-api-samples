import 'package:test/test.dart';
import 'package:mailbaby_client_dart_dio/mailbaby_client_dart_dio.dart';

// tests for MailBlocks
void main() {
  final MailBlocks? instance = /* MailBlocks(...) */ null;
  // TODO add properties to the entity

  group(MailBlocks, () {
    // Messages flagged by the `LOCAL_BL_RCPT` rspamd rule in the last 5 days. These are messages sent to recipients on a local block list.
    // List<MailBlockClickHouse> local
    test('to test the property `local`', () async {
      // TODO
    });

    // Messages flagged by the `MBTRAP` rspamd rule in the last 5 days. These triggered MailBaby's honeypot / trap address detection.
    // List<MailBlockClickHouse> mbtrap
    test('to test the property `mbtrap`', () async {
      // TODO
    });

    // Senders whose messages contained spam-indicative subjects (containing `@`, `smtp`, `socks4`, or `socks5`) with more than 4 occurrences of the same subject in the last 3 days.
    // List<MailBlockRspamd> subject
    test('to test the property `subject`', () async {
      // TODO
    });

  });
}
