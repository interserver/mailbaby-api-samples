import 'package:test/test.dart';
import 'package:mailbaby_client_dart_dio/mailbaby_client_dart_dio.dart';

// tests for MailBlockRspamd
void main() {
  final MailBlockRspamd? instance = /* MailBlockRspamd(...) */ null;
  // TODO add properties to the entity

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
