import 'package:test/test.dart';
import 'package:openapi/openapi.dart';

// tests for SendMailAdv
void main() {
  final instance = SendMailAdvBuilder();
  // TODO add properties to the builder and call build()

  group(SendMailAdv, () {
    // The subject line of the email.
    // String subject
    test('to test the property `subject`', () async {
      // TODO
    });

    // The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.
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

    // Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name.
    // BuiltList<MailAttachment> attachments
    test('to test the property `attachments`', () async {
      // TODO
    });

    // Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.
    // int id
    test('to test the property `id`', () async {
      // TODO
    });

  });
}
