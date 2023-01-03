import 'package:test/test.dart';
import 'package:openapi/openapi.dart';


/// tests for DefaultApi
void main() {
  final instance = Openapi().getDefaultApi();

  group(DefaultApi, () {
    // displays a list of mail service orders
    //
    //Future<BuiltList<GetMailOrders200ResponseInner>> getMailOrders() async
    test('test getMailOrders', () async {
      // TODO
    });

    // Checks if the server is running
    //
    //Future pingServer() async
    test('test pingServer', () async {
      // TODO
    });

    // Sends an Email with Advanced Options
    //
    // Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
    //
    //Future<GenericResponse> sendAdvMail(SendMailAdv sendMailAdv) async
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

    // displays the mail log
    //
    // By passing in the appropriate options, you can search for available inventory in the system 
    //
    //Future<MailLog> viewMailLog({ int id, String search, int skip, int limit, int startDate, int endDate }) async
    test('test viewMailLog', () async {
      // TODO
    });

  });
}
