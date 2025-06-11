import 'package:test/test.dart';
import 'package:openapi/openapi.dart';


/// tests for HistoryApi
void main() {
  final instance = Openapi().getHistoryApi();

  group(HistoryApi, () {
    // Account usage statistics.
    //
    // Returns information about the usage on your mail accounts.
    //
    //Future<MailStatsType> getStats({ String time }) async
    test('test getStats', () async {
      // TODO
    });

    // displays the mail log
    //
    // Get a listing of the emails sent through this system 
    //
    //Future<MailLog> viewMailLog({ int id, String origin, String mx, String from, String to, String subject, String mailid, int skip, int limit, int startDate, int endDate, String replyto, String headerfrom, String delivered }) async
    test('test viewMailLog', () async {
      // TODO
    });

  });
}
