import 'package:test/test.dart';
import 'package:openapi/openapi.dart';

// tests for DenyRuleNew
void main() {
  //final instance = DenyRuleNewBuilder();
  // TODO add properties to the builder and call build()

  group(DenyRuleNew, () {
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

    // Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`.
    // String user
    test('to test the property `user`', () async {
      // TODO
    });

  });
}
