import 'package:openapi/api.dart';
import 'package:test/test.dart';


/// tests for DefaultApi
void main() {
  var instance = new DefaultApi();

  group('tests for DefaultApi', () {
    // displays a list of mail service orders
    //
    //Future<List<MailOrder>> getMailOrders() async
    test('test getMailOrders', () async {
      // TODO
    });

    // Checks if the server is running
    //
    //Future pingServer() async
    test('test pingServer', () async {
      // TODO
    });

    // places a mail order
    //
    // Adds an item to the system
    //
    //Future placeMailOrder({ MailOrder mailOrder }) async
    test('test placeMailOrder', () async {
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
    // Sends An email through one of your mail orders.
    //
    //Future<GenericResponse> sendMail(String to, String from, String subject, String body) async
    test('test sendMail', () async {
      // TODO
    });

    // validatess order details before placing an order
    //
    //Future validateMailOrder() async
    test('test validateMailOrder', () async {
      // TODO
    });

    // displays the mail log
    //
    // By passing in the appropriate options, you can search for available inventory in the system 
    //
    //Future<List<MailLog>> viewMailLog({ int id, String searchString, int skip, int limit }) async
    test('test viewMailLog', () async {
      // TODO
    });

  });
}
