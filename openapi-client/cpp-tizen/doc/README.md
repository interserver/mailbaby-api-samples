# Documentation for MailBaby Email Delivery and Management Service API 1.1.0 Tizen Client SDK

## How do I get the doc files?
First generate source code by running `openapi-generator`
Then run `doc/generateDocumentation.sh` from the output folder. It will generate all the doc files and put them in the `doc/SDK` directory.
To successfully generate documentation it needs `Doxygen` installed in the path.
*Note* - Before generating the documentation, put the logo of the project as the file `doc/logo.png` before running `doxygen`.


## How do I use this?
This is the structure of the doc folder:

```
.
├── logo.png                  \\Logo of the project
├── Doxyfile                  \\Doxygen config files
├── generateDocumentation.sh  \\Script to run to generate documentation
├── README.md                 \\This file
├── SDK                       \\Documentation for all classes in MailBaby Email Delivery and Management Service API Tizen Client SDK. See ./html/index.html
│   └── html

```

## *tl;dr* run this:

```
doc/generateDocumentation.sh
```

The above SDK folder will be generated. See the index.html inside the SDK folder.


## What's Doxygen?
Doxygen is the de facto standard tool for generating/extracting documentation from annotated/unannotated C++ sources, but it also supports other popular programming languages such as C, Objective-C, C#, PHP, Java, Python, IDL (Corba, Microsoft, and UNO/OpenOffice flavors), Fortran, VHDL, Tcl, and to some extent D.

Check out [Doxygen](https://www.doxygen.org/) for additional information about the Doxygen project.

## I Don't want to run Doxygen. What are the API files for accessing the REST endpoints?
All URIs are relative to https://api.mailbaby.nethttps://api.mailbaby.net


### BlockingManager
Method | HTTP request | Description
------------- | ------------- | -------------
*addRuleSync* | *POST* /mail/rules | Creates a new email deny rule..
*addRuleASync* | *POST* /mail/rules | Creates a new email deny rule..
*deleteRuleSync* | *DELETE* /mail/rules/{ruleId} | Removes an deny mail rule..
*deleteRuleASync* | *DELETE* /mail/rules/{ruleId} | Removes an deny mail rule..
*delistBlockSync* | *POST* /mail/blocks/delete | Removes an email address from the blocked list.
*delistBlockASync* | *POST* /mail/blocks/delete | Removes an email address from the blocked list.
*getMailBlocksSync* | *GET* /mail/blocks | displays a list of blocked email addresses.
*getMailBlocksASync* | *GET* /mail/blocks | displays a list of blocked email addresses.
*getRulesSync* | *GET* /mail/rules | Displays a listing of deny email rules..
*getRulesASync* | *GET* /mail/rules | Displays a listing of deny email rules..


### HistoryManager
Method | HTTP request | Description
------------- | ------------- | -------------
*getStatsSync* | *GET* /mail/stats | displays a list of blocked email addresses.
*getStatsASync* | *GET* /mail/stats | displays a list of blocked email addresses.
*viewMailLogSync* | *GET* /mail/log | displays the mail log.
*viewMailLogASync* | *GET* /mail/log | displays the mail log.


### SendingManager
Method | HTTP request | Description
------------- | ------------- | -------------
*sendAdvMailSync* | *POST* /mail/advsend | Sends an Email with Advanced Options.
*sendAdvMailASync* | *POST* /mail/advsend | Sends an Email with Advanced Options.
*sendMailSync* | *POST* /mail/send | Sends an Email.
*sendMailASync* | *POST* /mail/send | Sends an Email.


### ServicesManager
Method | HTTP request | Description
------------- | ------------- | -------------
*getMailOrdersSync* | *GET* /mail | displays a list of mail service orders.
*getMailOrdersASync* | *GET* /mail | displays a list of mail service orders.


### StatusManager
Method | HTTP request | Description
------------- | ------------- | -------------
*pingServerSync* | *GET* /ping | Checks if the server is running.
*pingServerASync* | *GET* /ping | Checks if the server is running.


## What are the Model files for the data structures/objects?
Class | Description
------------- | -------------
 *DenyRuleNew* | The data for a email deny rule record.
 *DenyRuleRecord* | The data for a email deny rule record.
 *EmailAddress* | an email address
 *EmailAddressName* | An email contact.
 *GenericResponse* | 
 *GetMailOrders_401_response* | 
 *GetStats_200_response_inner* | 
 *MailAttachment* | (optional) File attachments to include in the email.  The file contents must be base64
 *MailBlockClickHouse* | A block entry from the clickhouse mailblocks server.
 *MailBlockRspamd* | This is a block entry from the rspamd block list.
 *MailBlocks* | The listing of blocked emails.
 *MailLog* | Mail log records
 *MailLogEntry* | An email record
 *MailOrder* | A mail order record
 *SendMail* | Details for an Email
 *SendMailAdv* | Details for an Email

