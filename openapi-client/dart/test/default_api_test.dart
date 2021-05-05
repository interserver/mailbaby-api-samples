//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.0

// ignore_for_file: unused_element, unused_import
// ignore_for_file: always_put_required_named_parameters_first
// ignore_for_file: lines_longer_than_80_chars

import 'package:openapi/api.dart';
import 'package:test/test.dart';


/// tests for DefaultApi
void main() {
  final instance = DefaultApi();

  group('tests for DefaultApi', () {
    // displays a list of mail service orders
    //
    //Future<List<MailOrder>> getMailOrders({ int id }) async
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
    //Future<GenericResponse> sendMail({ String to, String from, String subject, String body }) async
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
    //Future<List<MailLog>> viewMailLogById({ int id, String searchString, int skip, int limit }) async
    test('test viewMailLogById', () async {
      // TODO
    });

  });
}
