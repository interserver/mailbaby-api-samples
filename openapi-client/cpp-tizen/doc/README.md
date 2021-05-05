# Documentation for Mail Baby API 1.0.0 Tizen Client SDK

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
├── SDK                       \\Documentation for all classes in Mail Baby API Tizen Client SDK. See ./html/index.html
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
*placeMailOrderSync* | *POST* /mail/order | places a mail order.
*placeMailOrderASync* | *POST* /mail/order | places a mail order.
*sendAdvMailSync* | *POST* /mail/advsend | Sends an Email with Advanced Options.
*sendAdvMailASync* | *POST* /mail/advsend | Sends an Email with Advanced Options.
*sendMailSync* | *POST* /mail/send | Sends an Email.
*sendMailASync* | *POST* /mail/send | Sends an Email.
*validateMailOrderSync* | *GET* /mail/order | validatess order details before placing an order.
*validateMailOrderASync* | *GET* /mail/order | validatess order details before placing an order.
*viewMailLogByIdSync* | *GET* /mail/log | displays the mail log.
*viewMailLogByIdASync* | *GET* /mail/log | displays the mail log.


## What are the Model files for the data structures/objects?
Class | Description
------------- | -------------
 *ErrorResponse* | 
 *GenericResponse* | 
 *MailAttachment* | A File attachment for an email
 *MailContact* | An Email Contact
 *MailLog* | Mail Order Details
 *MailOrder* | 
 *SendMail* | Details for an Email
 *SendMailAdv* | Details for an Email
 *SendMailAdv_from* | An Email Contact

