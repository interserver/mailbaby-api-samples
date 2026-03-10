import 'package:test/test.dart';
import 'package:openapi/openapi.dart';

// tests for MailStatsType
void main() {
  final instance = MailStatsTypeBuilder();
  // TODO add properties to the builder and call build()

  group(MailStatsType, () {
    // The time window these `received`, `sent`, and `volume` statistics cover.
    // String time (default value: '1h')
    test('to test the property `time`', () async {
      // TODO
    });

    // Total messages accepted during the current billing cycle.  Used to calculate the `cost` value.
    // int usage
    test('to test the property `usage`', () async {
      // TODO
    });

    // The ISO 4217 currency code for this account (e.g. `USD`).
    // String currency
    test('to test the property `currency`', () async {
      // TODO
    });

    // Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails).
    // double cost
    test('to test the property `cost`', () async {
      // TODO
    });

    // Count of messages accepted by the relay within the selected `time` window. Includes messages still in queue.
    // int received
    test('to test the property `received`', () async {
      // TODO
    });

    // Count of messages successfully delivered to the destination MX within the selected `time` window.  Will be ≤ `received`.
    // int sent
    test('to test the property `sent`', () async {
      // TODO
    });

    // MailStatsVolume volume
    test('to test the property `volume`', () async {
      // TODO
    });

  });
}
