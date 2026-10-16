import 'package:test/test.dart';
import 'package:openapi/openapi.dart';


/// tests for StatusApi
void main() {
  final instance = Openapi().getStatusApi();

  group(StatusApi, () {
    // Health check — verify the API is reachable
    //
    // **No authentication required.** Returns the plain-text string `Server is up and running` with a `200` status when the API host is reachable. Use this as a connectivity smoke-test before attempting any authenticated call. Useful for uptime monitoring, load-balancer health checks, and CI smoke tests. 
    //
    //Future<String> pingServer() async
    test('test pingServer', () async {
      // TODO
    });

  });
}
