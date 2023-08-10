import 'package:test/test.dart';
import 'package:openapi/openapi.dart';


/// tests for ServicesApi
void main() {
  final instance = Openapi().getServicesApi();

  group(ServicesApi, () {
    // displays a list of mail service orders
    //
    // This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.
    //
    //Future<BuiltList<MailOrder>> getMailOrders() async
    test('test getMailOrders', () async {
      // TODO
    });

  });
}
