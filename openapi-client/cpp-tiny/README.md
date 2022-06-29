# Documentation for OpenAPI Petstore
This is a client generator for microcontrollers on the Espressif32 platform and the Arduino framework
After the client have been generated, you have to change these following variables:
- root.cert | Provide your service root certificate.
- src/main.cpp | Change wifi name
- src/main.cpp | Change wifi password
- lib/service/AbstractService.h | Change to your url

# Documentation for MailBaby Email Delivery API 1.0.0 Tiny client cpp (Arduino) 

The project is structured like this:
```
samples/client/petstore/tiny/cpp/
├── lib
│   ├── Models
│   ├── service
│   └── TestFiles
├── platformio.ini
├── pre_compiling_bourne.py
├── README.md
├── root.cert
├── src
│   └── main.cpp
└── test
    └── RunTests.cpp
```

All URIs are relative to https://api.mailbaby.nethttps://api.mailbaby.net

### DefaultApi
|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|*getMailOrders* | *GET* /mail | displays a list of mail service orders.|
|*pingServer* | *GET* /ping | Checks if the server is running.|
|*sendAdvMail* | *POST* /mail/advsend | Sends an Email with Advanced Options.|
|*sendMail* | *POST* /mail/send | Sends an Email.|
|*viewMailLog* | *GET* /mail/log | displays the mail log.|


## What are the Model files for the data structures/objects?
|Class | Description|
|------------- | -------------|
|*GenericResponse* | |
|*GetMailOrders_200_response_inner* | |
|*GetMailOrders_401_response* | |
|*MailLog* | Mail log records|
|*MailLogEntry* | An email record|
|*SendMail* | Details for an Email|
|*SendMailAdv* | Details for an Email|
|*SendMailAdv_attachments_inner* | A File attachment for an email|
|*SendMailAdv_bcc_inner* | An Email Contact|
|*SendMailAdv_cc_inner* | An Email Contact|
|*SendMailAdv_from* | The information to use for the From address in the email. from.|
|*SendMailAdv_replyto_inner* | An Email Contact|
|*SendMailAdv_to_inner* | An Email Contact|

