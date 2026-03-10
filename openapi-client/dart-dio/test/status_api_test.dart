import 'package:test/test.dart';
import 'package:openapi/openapi.dart';


/// tests for StatusApi
void main() {
  final instance = Openapi().getStatusApi();

  group(StatusApi, () {
    // Checks if the server is running
    //
    // A lightweight health-check endpoint.  Returns a plain-text `200 OK` when the API server is reachable.  No authentication is required.  Useful for monitoring and uptime checks. 
    //
    //Future pingServer() async
    test('test pingServer', () async {
      // TODO
    });

  });
}
