import 'package:test/test.dart';
import 'package:openapi/openapi.dart';


/// tests for DefaultApi
void main() {
  final instance = Openapi().getDefaultApi();

  group(DefaultApi, () {
    // Gets mail order information by id
    //
    // returns information about a mail order in the system with the given id.
    //
    //Future<MailOrder> getMailById(int id) async
    test('test getMailById', () async {
      // TODO
    });

    // displays a list of mail service orders
    //
    //Future<BuiltList<MailOrder>> getMailOrders() async
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
    //Future<GenericResponse> sendAdvMailById(int id, SendMail sendMail) async
    test('test sendAdvMailById', () async {
      // TODO
    });

    // Sends an Email
    //
    // Sends An email through one of your mail orders.
    //
    //Future<GenericResponse> sendMailById(int id, { String subject, String body, String to, String toName, String from, String fromName }) async
    test('test sendMailById', () async {
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
    //Future<BuiltList<MailLog>> viewMailLogById(int id, { String searchString, int skip, int limit }) async
    test('test viewMailLogById', () async {
      // TODO
    });

  });
}