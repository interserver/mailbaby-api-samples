import 'package:test/test.dart';
import 'package:openapi/openapi.dart';

// tests for MailBlockClickHouse
void main() {
  final instance = MailBlockClickHouseBuilder();
  // TODO add properties to the builder and call build()

  group(MailBlockClickHouse, () {
    // The date the block event was recorded.
    // Date date
    test('to test the property `date`', () async {
      // TODO
    });

    // The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it.
    // String from
    test('to test the property `from`', () async {
      // TODO
    });

    // The `Subject` header of the blocked message.
    // String subject
    test('to test the property `subject`', () async {
      // TODO
    });

    // The serialized list of recipients of the blocked message.
    // String to
    test('to test the property `to`', () async {
      // TODO
    });

    // The `Message-ID` header of the blocked message, or `null` if not present.
    // String messageId
    test('to test the property `messageId`', () async {
      // TODO
    });

  });
}
