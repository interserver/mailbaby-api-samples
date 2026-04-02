import 'package:test/test.dart';
import 'package:openapi/openapi.dart';


/// tests for StatusApi
void main() {
  final instance = Openapi().getStatusApi();

  group(StatusApi, () {
    // Checks if the server is running
    //
    // A lightweight health-check endpoint.  Returns the plain-text string `Server is up and running` with a `200` status when the API server is reachable.  **No authentication is required.** Useful for uptime monitoring, load-balancer health checks, and smoke tests. 
    //
    //Future<String> pingServer() async
    test('test pingServer', () async {
      // TODO
    });

  });
}
