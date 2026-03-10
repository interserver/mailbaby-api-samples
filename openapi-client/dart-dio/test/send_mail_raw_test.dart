import 'package:test/test.dart';
import 'package:openapi/openapi.dart';

// tests for SendMailRaw
void main() {
  final instance = SendMailRawBuilder();
  // TODO add properties to the builder and call build()

  group(SendMailRaw, () {
    // The complete RFC 822 email message including all headers and the body. Must include at minimum `From`, `To`, `Subject`, `Date`, and `MIME-Version` headers.  DKIM signatures in the `DKIM-Signature` header are transmitted verbatim and will pass verification at the destination.
    // String rawEmail
    test('to test the property `rawEmail`', () async {
      // TODO
    });

    // Optional numeric ID of the mail order to use for SMTP authentication. If omitted the first active order on your account is used.  Valid IDs are returned by `GET /mail`.
    // int id
    test('to test the property `id`', () async {
      // TODO
    });

  });
}
