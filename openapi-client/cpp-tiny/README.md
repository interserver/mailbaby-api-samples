# Documentation for OpenAPI Petstore
This is a client generator for microcontrollers on the Espressif32 platform and the Arduino framework
After the client have been generated, you have to change these following variables:
- root.cert | Provide your service root certificate.
- src/main.cpp | Change wifi name
- src/main.cpp | Change wifi password
- lib/service/AbstractService.h | Change to your url

# Documentation for MailBaby Email Delivery and Management Service API 1.3.0 Tiny client cpp (Arduino) 

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

### BlockingApi
|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|*addRule* | *POST* /mail/rules | Creates a new email deny rule..|
|*deleteRule* | *DELETE* /mail/rules/{ruleId} | Removes an deny mail rule..|
|*delistBlock* | *POST* /mail/blocks/delete | Removes an email address from the blocked list.|
|*getMailBlocks* | *GET* /mail/blocks | displays a list of blocked email addresses.|
|*getRules* | *GET* /mail/rules | Displays a listing of deny email rules..|

### HistoryApi
|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|*getStats* | *GET* /mail/stats | Account usage statistics..|
|*viewMailLog* | *GET* /mail/log | displays the mail log.|

### SendingApi
|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|*rawMail* | *POST* /mail/rawsend | Sends a raw email.|
|*sendAdvMail* | *POST* /mail/advsend | Sends an Email with Advanced Options.|
|*sendMail* | *POST* /mail/send | Sends an Email.|

### ServicesApi
|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|*getMailOrders* | *GET* /mail | displays a list of mail service orders.|

### StatusApi
|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|*pingServer* | *GET* /ping | Checks if the server is running.|


## What are the Model files for the data structures/objects?
|Class | Description|
|------------- | -------------|
|*DenyRuleNew* | The data for a email deny rule record.|
|*DenyRuleRecord* | The data for a email deny rule record.|
|*EmailAddressName* | An email contact.|
|*EmailAddressTypes* | |
|*EmailAddressesTypes* | |
|*ErrorMessage* | The resposne when an error occurs.|
|*GenericResponse* | |
|*MailAttachment* | (optional) File attachments to include in the email.  The file contents must be base64|
|*MailBlockClickHouse* | A block entry from the clickhouse mailblocks server.|
|*MailBlockRspamd* | This is a block entry from the rspamd block list.|
|*MailBlocks* | The listing of blocked emails.|
|*MailLog* | Mail log records|
|*MailLogEntry* | An email record|
|*MailOrder* | A mail order record|
|*MailStatsType* | Statistics about the mail usage including volume by IP, To address, and From address; as well as total sent / delivered counts and cost.|
|*MailStatsType_volume* | |
|*MailStatsType_volume_from* | |
|*MailStatsType_volume_ip* | |
|*MailStatsType_volume_to* | |
|*SendMail* | Details for an Email|
|*SendMailAdv* | Details for an Email|
|*SendMailRaw* | Raw Email Object|

