import 'package:test/test.dart';
import 'package:openapi/openapi.dart';


/// tests for StatusApi
void main() {
  final instance = Openapi().getStatusApi();

  group(StatusApi, () {
    // Checks if the server is running
    //
    //Future pingServer() async
    test('test pingServer', () async {
      // TODO
    });

  });
}
