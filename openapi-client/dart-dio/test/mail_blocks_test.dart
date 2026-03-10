import 'package:test/test.dart';
import 'package:openapi/openapi.dart';

// tests for MailBlocks
void main() {
  final instance = MailBlocksBuilder();
  // TODO add properties to the builder and call build()

  group(MailBlocks, () {
    // Messages flagged by the `LOCAL_BL_RCPT` rspamd rule in the last 5 days. These are messages sent to recipients on a local block list.
    // BuiltList<MailBlockClickHouse> local
    test('to test the property `local`', () async {
      // TODO
    });

    // Messages flagged by the `MBTRAP` rspamd rule in the last 5 days. These triggered MailBaby's honeypot / trap address detection.
    // BuiltList<MailBlockClickHouse> mbtrap
    test('to test the property `mbtrap`', () async {
      // TODO
    });

    // Senders whose messages contained spam-indicative subjects (containing `@`, `smtp`, `socks4`, or `socks5`) with more than 4 occurrences of the same subject in the last 3 days.
    // BuiltList<MailBlockRspamd> subject
    test('to test the property `subject`', () async {
      // TODO
    });

  });
}
