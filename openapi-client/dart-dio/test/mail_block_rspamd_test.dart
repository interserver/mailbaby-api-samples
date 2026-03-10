import 'package:test/test.dart';
import 'package:openapi/openapi.dart';

// tests for MailBlockRspamd
void main() {
  final instance = MailBlockRspamdBuilder();
  // TODO add properties to the builder and call build()

  group(MailBlockRspamd, () {
    // The sender email address.  Pass this value as `email` to `POST /mail/blocks/delete` to delist the sender.
    // String from
    test('to test the property `from`', () async {
      // TODO
    });

    // The suspicious subject pattern that triggered the block.
    // String subject
    test('to test the property `subject`', () async {
      // TODO
    });

  });
}
