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

// tests for MailStatsType
void main() {
  // final instance = MailStatsType();

  group('test MailStatsType', () {
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

    // MailStatsTypeVolume volume
    test('to test the property `volume`', () async {
      // TODO
    });


  });

}
