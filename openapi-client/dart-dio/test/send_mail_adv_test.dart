import 'package:test/test.dart';
import 'package:openapi/openapi.dart';

// tests for SendMailAdv
void main() {
  final instance = SendMailAdvBuilder();
  // TODO add properties to the builder and call build()

  group(SendMailAdv, () {
    // The subject or title of the email
    // String subject
    test('to test the property `subject`', () async {
      // TODO
    });

    // The main email contents.
    // String body
    test('to test the property `body`', () async {
      // TODO
    });

    // EmailAddressTypes from
    test('to test the property `from`', () async {
      // TODO
    });

    // EmailAddressesTypes to
    test('to test the property `to`', () async {
      // TODO
    });

    // EmailAddressesTypes replyto
    test('to test the property `replyto`', () async {
      // TODO
    });

    // EmailAddressesTypes cc
    test('to test the property `cc`', () async {
      // TODO
    });

    // EmailAddressesTypes bcc
    test('to test the property `bcc`', () async {
      // TODO
    });

    // (optional) File attachments to include in the email.  The file contents must be base64 encoded!
    // BuiltList<MailAttachment> attachments
    test('to test the property `attachments`', () async {
      // TODO
    });

    // (optional)  ID of the Mail order within our system to use as the Mail Account.
    // int id
    test('to test the property `id`', () async {
      // TODO
    });

  });
}
