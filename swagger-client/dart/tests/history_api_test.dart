import 'package:swagger/api.dart';
import 'package:test/test.dart';


/// tests for HistoryApi
void main() {
  var instance = new HistoryApi();

  group('tests for HistoryApi', () {
    // Account usage statistics.
    //
    // Returns information about the usage on your mail accounts.
    //
    //Future<List<InlineResponse200>> getStats() async
    test('test getStats', () async {
      // TODO
    });

    // displays the mail log
    //
    // Get a listing of the emails sent through this system 
    //
    //Future<MailLog> viewMailLog({ int id, String origin, String mx, String from, String to, String subject, String mailid, int skip, int limit, int startDate, int endDate }) async
    test('test viewMailLog', () async {
      // TODO
    });

  });
}
