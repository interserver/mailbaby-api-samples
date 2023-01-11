//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.12

// ignore_for_file: unused_element, unused_import
// ignore_for_file: always_put_required_named_parameters_first
// ignore_for_file: constant_identifier_names
// ignore_for_file: lines_longer_than_80_chars

import 'package:openapi/api.dart';
import 'package:test/test.dart';


/// tests for DefaultApi
void main() {
  // final instance = DefaultApi();

  group('tests for DefaultApi', () {
    // displays a list of mail service orders
    //
    //Future<List<GetMailOrders200ResponseInner>> getMailOrders() async
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
    // Get a listing of the emails sent through this system 
    //
    //Future<MailLog> viewMailLog({ int id, String origin, String mx, String from, String to, String subject, String mailid, int skip, int limit, int startDate, int endDate }) async
    test('test viewMailLog', () async {
      // TODO
    });

  });
}
