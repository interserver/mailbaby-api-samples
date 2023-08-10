import 'package:test/test.dart';
import 'package:openapi/openapi.dart';


/// tests for SendingApi
void main() {
  final instance = Openapi().getSendingApi();

  group(SendingApi, () {
    // Sends an Email with Advanced Options
    //
    // Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
    //
    //Future<GenericResponse> sendAdvMail(String subject, String body, EmailAddressName from, BuiltList<EmailAddressName> to, { BuiltList<EmailAddressName> replyto, BuiltList<EmailAddressName> cc, BuiltList<EmailAddressName> bcc, BuiltList<MailAttachment> attachments, int id }) async
    test('test sendAdvMail', () async {
      // TODO
    });

    // Sends an Email
    //
    // Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
    //
    //Future<GenericResponse> sendMail(String to, String from, String subject, String body) async
    test('test sendMail', () async {
      // TODO
    });

  });
}
