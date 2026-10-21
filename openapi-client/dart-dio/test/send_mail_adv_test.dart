import 'package:test/test.dart';
import 'package:mailbaby_client_dart_dio/mailbaby_client_dart_dio.dart';

// tests for SendMailAdv
void main() {
  final SendMailAdv? instance = /* SendMailAdv(...) */ null;
  // TODO add properties to the entity

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

    // The sender address.  Accepts a plain email string, an RFC 822 named string (`\"Name <email>\"`), or a `{\"email\": \"...\", \"name\": \"...\"}` object.
    // EmailAddressTypes from
    test('to test the property `from`', () async {
      // TODO
    });

    // One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.
    // EmailAddressesTypes to
    test('to test the property `to`', () async {
      // TODO
    });

    // Optional.  One or more addresses to set as the `Reply-To` header. When recipients reply to the message their email client will address the reply to these addresses instead of `from`.
    // EmailAddressesTypes replyto
    test('to test the property `replyto`', () async {
      // TODO
    });

    // Optional.  Carbon-copy recipients.  These addresses are listed in the `Cc` header and are visible to all recipients.
    // EmailAddressesTypes cc
    test('to test the property `cc`', () async {
      // TODO
    });

    // Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.
    // EmailAddressesTypes bcc
    test('to test the property `bcc`', () async {
      // TODO
    });

    // Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name.
    // List<MailAttachment> attachments
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
