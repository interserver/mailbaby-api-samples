import 'package:openapi/api.dart';
import 'package:test/test.dart';

// tests for SendMailAdv
void main() {
  var instance = new SendMailAdv();

  group('test SendMailAdv', () {
    // The subject or title of the email
    // String subject (default value: null)
    test('to test the property `subject`', () async {
      // TODO
    });

    // The main email contents.
    // String body (default value: null)
    test('to test the property `body`', () async {
      // TODO
    });

    // The contact whom is the this email is from.
    // List<SendMailAdvFrom> from (default value: const [])
    test('to test the property `from`', () async {
      // TODO
    });

    // The Contact whom is the primary recipient of this email.
    // List<MailContact> to (default value: const [])
    test('to test the property `to`', () async {
      // TODO
    });

    // The ID of the Mail order within our system to use as the Mail Account.
    // int id (default value: null)
    test('to test the property `id`', () async {
      // TODO
    });

    // Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address.
    // List<MailContact> replyto (default value: const [])
    test('to test the property `replyto`', () async {
      // TODO
    });

    // Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.
    // List<MailContact> cc (default value: const [])
    test('to test the property `cc`', () async {
      // TODO
    });

    // Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.
    // List<MailContact> bcc (default value: const [])
    test('to test the property `bcc`', () async {
      // TODO
    });

    // Optional file attachments to include in the email
    // List<MailAttachment> attachments (default value: const [])
    test('to test the property `attachments`', () async {
      // TODO
    });


  });

}
