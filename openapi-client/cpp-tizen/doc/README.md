# Documentation for MailBaby Email Delivery API 1.0.0 Tizen Client SDK

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
├── SDK                       \\Documentation for all classes in MailBaby Email Delivery API Tizen Client SDK. See ./html/index.html
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


### DefaultManager
Method | HTTP request | Description
------------- | ------------- | -------------
*getMailOrdersSync* | *GET* /mail | displays a list of mail service orders.
*getMailOrdersASync* | *GET* /mail | displays a list of mail service orders.
*pingServerSync* | *GET* /ping | Checks if the server is running.
*pingServerASync* | *GET* /ping | Checks if the server is running.
*sendAdvMailSync* | *POST* /mail/advsend | Sends an Email with Advanced Options.
*sendAdvMailASync* | *POST* /mail/advsend | Sends an Email with Advanced Options.
*sendMailSync* | *POST* /mail/send | Sends an Email.
*sendMailASync* | *POST* /mail/send | Sends an Email.
*viewMailLogSync* | *GET* /mail/log | displays the mail log.
*viewMailLogASync* | *GET* /mail/log | displays the mail log.


## What are the Model files for the data structures/objects?
Class | Description
------------- | -------------
 *GenericResponse* | 
 *GetMailOrders_200_response_inner* | 
 *GetMailOrders_401_response* | 
 *MailLog* | Mail log records
 *MailLogEntry* | An email record
 *SendMail* | Details for an Email
 *SendMailAdv* | Details for an Email
 *SendMailAdv_attachments_inner* | A File attachment for an email
 *SendMailAdv_bcc_inner* | An Email Contact
 *SendMailAdv_cc_inner* | An Email Contact
 *SendMailAdv_from* | The information to use for the From address in the email. from.
 *SendMailAdv_replyto_inner* | An Email Contact
 *SendMailAdv_to_inner* | An Email Contact

