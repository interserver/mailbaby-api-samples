import 'package:swagger/api.dart';
import 'package:test/test.dart';


/// tests for BlockingApi
void main() {
  var instance = new BlockingApi();

  group('tests for BlockingApi', () {
    // Creates a new email deny rule.
    //
    // Adds a new email deny rule into the system to block new emails that match the given criteria
    //
    //Future<GenericResponse> addRule(String user, String type, String data, DenyRuleNew body) async
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
    //Future<GenericResponse> delistBlock(String body) async
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
    //Future<List<DenyRuleRecord>> getRules() async
    test('test getRules', () async {
      // TODO
    });

  });
}
