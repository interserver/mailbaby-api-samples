import 'package:test/test.dart';
import 'package:openapi/openapi.dart';

// tests for MailStatsTypeVolume
void main() {
  final instance = MailStatsTypeVolumeBuilder();
  // TODO add properties to the builder and call build()

  group(MailStatsTypeVolume, () {
    // Message counts keyed by destination (envelope `to`) email address.
    // BuiltMap<String, int> to
    test('to test the property `to`', () async {
      // TODO
    });

    // Message counts keyed by sender (envelope `from`) email address.
    // BuiltMap<String, int> from
    test('to test the property `from`', () async {
      // TODO
    });

    // Message counts keyed by originating client IP address.
    // BuiltMap<String, int> ip
    test('to test the property `ip`', () async {
      // TODO
    });

  });
}
