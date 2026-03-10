import 'package:test/test.dart';
import 'package:openapi/openapi.dart';

// tests for DenyRuleRecord
void main() {
  final instance = DenyRuleRecordBuilder();
  // TODO add properties to the builder and call build()

  group(DenyRuleRecord, () {
    // The type of deny rule.
    // String type
    test('to test the property `type`', () async {
      // TODO
    });

    // The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`.
    // String data
    test('to test the property `data`', () async {
      // TODO
    });

    // The numeric ID of the deny rule, as a string.  Pass this as `ruleId` to `DELETE /mail/rules/{ruleId}` to remove the rule.
    // String id
    test('to test the property `id`', () async {
      // TODO
    });

    // The timestamp when the rule was created.
    // DateTime created
    test('to test the property `created`', () async {
      // TODO
    });

    // Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`.
    // String user
    test('to test the property `user`', () async {
      // TODO
    });

  });
}
