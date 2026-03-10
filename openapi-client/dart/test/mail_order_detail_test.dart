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

// tests for MailOrderDetail
void main() {
  // final instance = MailOrderDetail();

  group('test MailOrderDetail', () {
    // The unique numeric ID of the mail order.  Used as the `id` parameter on sending calls, log queries, and stats queries.
    // int id
    test('to test the property `id`', () async {
      // TODO
    });

    // The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send.
    // String status
    test('to test the property `status`', () async {
      // TODO
    });

    // The SMTP AUTH username for this order, always in the format `mb<id>`. Use together with the password from `GET /mail/{id}` to authenticate directly against `relay.mailbaby.net:25` if needed.
    // String username
    test('to test the property `username`', () async {
      // TODO
    });

    // The current SMTP AUTH password for this mail order.  Use with the `username` field to authenticate against `relay.mailbaby.net:25`.
    // String password
    test('to test the property `password`', () async {
      // TODO
    });

    // Optional human-readable note associated with the order.
    // String comment
    test('to test the property `comment`', () async {
      // TODO
    });


  });

}
