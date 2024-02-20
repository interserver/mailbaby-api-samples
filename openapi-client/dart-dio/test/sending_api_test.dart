import 'package:test/test.dart';
import 'package:openapi/openapi.dart';


/// tests for SendingApi
void main() {
  final instance = Openapi().getSendingApi();

  group(SendingApi, () {
    // Sends an Email with Advanced Options
    //
    // Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data to=support@interserver.net ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=\"Joe <user@domain.com>\" \\ --data to=\"Joe <support@interserver.net>\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to=support@interserver.net, support@interserver.net\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to=Joe <support@interserver.net>, Joe <support@interserver.net>\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" \\ --data \"to[1][name]=Joe\" \\ --data \"to[1][email]=support@interserver.net\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/json' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"user@domain.com\", \"to\": \"support@interserver.net\" }' ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/json' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": {\"name\": \"Joe\", \"email\": \"user@domain.com\"}, \"to\": [{\"name\": \"Joe\", \"email\": \"support@interserver.net\"}] }' ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/json' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"Joe <user@domain.com>\", \"to\": \"Joe <support@interserver.net>\" }' ``` 
    //
    //Future<GenericResponse> sendAdvMail(String subject, String body, EmailAddressTypes from, EmailAddressesTypes to, { EmailAddressesTypes replyto, EmailAddressesTypes cc, EmailAddressesTypes bcc, BuiltList<MailAttachment> attachments, int id }) async
    test('test sendAdvMail', () async {
      // TODO
    });

    // Sends an Email
    //
    // Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
    //
    //Future<GenericResponse> sendMail(String to, String from, String subject, String body) async
    test('test sendMail', () async {
      // TODO
    });

  });
}
