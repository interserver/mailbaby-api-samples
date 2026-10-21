import 'package:test/test.dart';
import 'package:mailbaby_client_dart_dio/mailbaby_client_dart_dio.dart';

// tests for MailLog
void main() {
  final MailLog? instance = /* MailLog(...) */ null;
  // TODO add properties to the entity

  group(MailLog, () {
    // Total number of log entries that match the supplied filters, regardless of `skip` and `limit`.  Use this to calculate the number of pages: `ceil(total / limit)`.
    // int total
    test('to test the property `total`', () async {
      // TODO
    });

    // The `skip` value used for this page (echoed from the request).
    // int skip
    test('to test the property `skip`', () async {
      // TODO
    });

    // The `limit` value used for this page (echoed from the request).
    // int limit
    test('to test the property `limit`', () async {
      // TODO
    });

    // List<MailLogEntry> emails
    test('to test the property `emails`', () async {
      // TODO
    });

  });
}
