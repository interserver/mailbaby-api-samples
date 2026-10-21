import 'package:test/test.dart';
import 'package:openapi/openapi.dart';

// tests for GenericResponse
void main() {
  final GenericResponse? instance = /* GenericResponse(...) */ null;
  // TODO add properties to the entity

  group(GenericResponse, () {
    // Always `\"ok\"` on success.
    // String status
    test('to test the property `status`', () async {
      // TODO
    });

    // Operation-specific result string.  For send operations this is the relay transaction ID (e.g. `185caa69ff7000f47c`) which can be used as the `mailid` parameter in `GET /mail/log`.  For create operations this is the new record's numeric ID.  For delete operations this is a human-readable confirmation.
    // String text
    test('to test the property `text`', () async {
      // TODO
    });

  });
}
