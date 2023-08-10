import 'package:test/test.dart';
import 'package:openapi/openapi.dart';


/// tests for BlockingApi
void main() {
  final instance = Openapi().getBlockingApi();

  group(BlockingApi, () {
    // Creates a new email deny rule.
    //
    // Adds a new email deny rule into the system to block new emails that match the given criteria
    //
    //Future<GenericResponse> addRule(String type, String data, { String user }) async
    test('test addRule', () async {
      // TODO
    });

    // Removes an deny mail rule.
    //
    // Removes one of the configured deny mail rules from the system.
    //
    //Future<GenericResponse> deleteRule(int ruleId) async
    test('test deleteRule', () async {
      // TODO
    });

    // Removes an email address from the blocked list
    //
    // Removes an email address from the various block lists. 
    //
    //Future<GenericResponse> delistBlock(EmailAddress emailAddress) async
    test('test delistBlock', () async {
      // TODO
    });

    // displays a list of blocked email addresses
    //
    //Future<MailBlocks> getMailBlocks() async
    test('test getMailBlocks', () async {
      // TODO
    });

    // Displays a listing of deny email rules.
    //
    // Returns a listing of all the deny block rules you have configured.
    //
    //Future<BuiltList<DenyRuleRecord>> getRules() async
    test('test getRules', () async {
      // TODO
    });

  });
}
