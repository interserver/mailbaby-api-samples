import 'package:test/test.dart';
import 'package:mailbaby_client_dart_dio/mailbaby_client_dart_dio.dart';

// tests for MailStatsVolume
void main() {
  final MailStatsVolume? instance = /* MailStatsVolume(...) */ null;
  // TODO add properties to the entity

  group(MailStatsVolume, () {
    // Message counts keyed by destination (envelope `to`) email address.
    // Map<String, int> to
    test('to test the property `to`', () async {
      // TODO
    });

    // Message counts keyed by sender (envelope `from`) email address.
    // Map<String, int> from
    test('to test the property `from`', () async {
      // TODO
    });

    // Message counts keyed by originating client IP address.
    // Map<String, int> ip
    test('to test the property `ip`', () async {
      // TODO
    });

  });
}
