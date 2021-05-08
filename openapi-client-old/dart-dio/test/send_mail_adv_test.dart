//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.7

// ignore_for_file: unused_import

import 'package:openapi/model/send_mail_adv.dart';
import 'package:test/test.dart';

// tests for SendMailAdv
void main() {
  final instance = SendMailAdvBuilder();
  // TODO add properties to the builder and call build()

  group(SendMailAdv, () {
    // The subject or title of the email
    // String subject
    test('to test the property `subject`', () async {
      // TODO
    });

    // The main email contents.
    // String body
    test('to test the property `body`', () async {
      // TODO
    });

    // The contact whom is the this email is from.
    // BuiltList<SendMailAdvFrom> from
    test('to test the property `from`', () async {
      // TODO
    });

    // The Contact whom is the primary recipient of this email.
    // BuiltList<MailContact> to
    test('to test the property `to`', () async {
      // TODO
    });

    // The ID of the Mail order within our system to use as the Mail Account.
    // int id
    test('to test the property `id`', () async {
      // TODO
    });

    // Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address.
    // BuiltList<MailContact> replyto
    test('to test the property `replyto`', () async {
      // TODO
    });

    // Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.
    // BuiltList<MailContact> cc
    test('to test the property `cc`', () async {
      // TODO
    });

    // Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.
    // BuiltList<MailContact> bcc
    test('to test the property `bcc`', () async {
      // TODO
    });

    // Optional file attachments to include in the email
    // BuiltList<MailAttachment> attachments
    test('to test the property `attachments`', () async {
      // TODO
    });


  });

}
