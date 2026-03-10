import 'package:test/test.dart';
import 'package:openapi/openapi.dart';

// tests for SendMail
void main() {
  final instance = SendMailBuilder();
  // TODO add properties to the builder and call build()

  group(SendMail, () {
    // SendMailTo to
    test('to test the property `to`', () async {
      // TODO
    });

    // The sender address.  This is used as both the `From` header and the `Reply-To` header automatically.  Must be a valid email address authorized for your mail order.
    // String from
    test('to test the property `from`', () async {
      // TODO
    });

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

    // Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.
    // int id
    test('to test the property `id`', () async {
      // TODO
    });

  });
}
