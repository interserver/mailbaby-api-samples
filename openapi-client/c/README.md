# C API client for mailbaby_email_delivery_and_management_service_api

## Overview
This API client was generated by the [OpenAPI Generator](https://openapi-generator.tech) project. By using the [OpenAPI spec](https://openapis.org) from a remote server, you can easily generate an API client.

- API version: 1.1.0
- Package version: 
- Generator version: 7.14.0-SNAPSHOT
- Build package: org.openapitools.codegen.languages.CLibcurlClientCodegen
For more information, please visit [https://www.mail.baby/contact/](https://www.mail.baby/contact/)

## Installation
You'll need the `curl 7.58.0` package in order to build the API. To have code formatted nicely, you also need to have uncrustify version 0.67 or later.

# Prerequisites

## Install the `curl 7.58.0` package with the following command on Linux.
```bash
sudo apt remove curl
wget http://curl.haxx.se/download/curl-7.58.0.tar.gz
tar -xvf curl-7.58.0.tar.gz
cd curl-7.58.0/
./configure
make
sudo make install
```
## Install the `uncrustify 0.67` package with the following command on Linux.
```bash
git clone https://github.com/uncrustify/uncrustify.git
cd uncrustify
mkdir build
cd build
cmake ..
make
sudo make install
```

## Compile the sample:
This will compile the generated code and create a library in the build folder which has to be linked to the codes where API will be used.
```bash
mkdir build
cd build
// To install library to specific location, use following commands
cmake -DCMAKE_INSTALL_PREFIX=/pathtolocation ..
// for normal install use following command
cmake ..
make
sudo make install
```
## How to use compiled library
Considering the test/source code which uses the API is written in main.c(respective api include is written and all objects necessary are defined and created)

To compile main.c(considering the file is present in build folder) use following command
-L - location of the library(not required if cmake with normal installation is performed)
-l library name
```bash
gcc main.c -L. -lmailbaby_email_delivery_and_management_service_api -o main
```
Once compiled, you can run it with ``` ./main ```

Note: You don't need to specify includes for models and include folder separately as they are path linked. You just have to import the api.h file in your code, the include linking will work.

## Documentation for API Endpoints

All URIs are relative to *https://api.mailbaby.net*

Category | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*BlockingAPI* | [**BlockingAPI_addRule**](docs/BlockingAPI.md#BlockingAPI_addRule) | **POST** /mail/rules | Creates a new email deny rule.
*BlockingAPI* | [**BlockingAPI_deleteRule**](docs/BlockingAPI.md#BlockingAPI_deleteRule) | **DELETE** /mail/rules/{ruleId} | Removes an deny mail rule.
*BlockingAPI* | [**BlockingAPI_delistBlock**](docs/BlockingAPI.md#BlockingAPI_delistBlock) | **POST** /mail/blocks/delete | Removes an email address from the blocked list
*BlockingAPI* | [**BlockingAPI_getMailBlocks**](docs/BlockingAPI.md#BlockingAPI_getMailBlocks) | **GET** /mail/blocks | displays a list of blocked email addresses
*BlockingAPI* | [**BlockingAPI_getRules**](docs/BlockingAPI.md#BlockingAPI_getRules) | **GET** /mail/rules | Displays a listing of deny email rules.
*HistoryAPI* | [**HistoryAPI_getStats**](docs/HistoryAPI.md#HistoryAPI_getStats) | **GET** /mail/stats | Account usage statistics.
*HistoryAPI* | [**HistoryAPI_viewMailLog**](docs/HistoryAPI.md#HistoryAPI_viewMailLog) | **GET** /mail/log | displays the mail log
*SendingAPI* | [**SendingAPI_sendAdvMail**](docs/SendingAPI.md#SendingAPI_sendAdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options
*SendingAPI* | [**SendingAPI_sendMail**](docs/SendingAPI.md#SendingAPI_sendMail) | **POST** /mail/send | Sends an Email
*ServicesAPI* | [**ServicesAPI_getMailOrders**](docs/ServicesAPI.md#ServicesAPI_getMailOrders) | **GET** /mail | displays a list of mail service orders
*StatusAPI* | [**StatusAPI_pingServer**](docs/StatusAPI.md#StatusAPI_pingServer) | **GET** /ping | Checks if the server is running


## Documentation for Models

 - [deny_rule_new_t](docs/deny_rule_new.md)
 - [deny_rule_record_t](docs/deny_rule_record.md)
 - [email_address_name_t](docs/email_address_name.md)
 - [email_address_types_t](docs/email_address_types.md)
 - [email_addresses_types_t](docs/email_addresses_types.md)
 - [error_message_t](docs/error_message.md)
 - [generic_response_t](docs/generic_response.md)
 - [mail_attachment_t](docs/mail_attachment.md)
 - [mail_block_click_house_t](docs/mail_block_click_house.md)
 - [mail_block_rspamd_t](docs/mail_block_rspamd.md)
 - [mail_blocks_t](docs/mail_blocks.md)
 - [mail_log_t](docs/mail_log.md)
 - [mail_log_entry_t](docs/mail_log_entry.md)
 - [mail_order_t](docs/mail_order.md)
 - [mail_stats_type_t](docs/mail_stats_type.md)
 - [mail_stats_type_volume_t](docs/mail_stats_type_volume.md)
 - [mail_stats_type_volume_from_t](docs/mail_stats_type_volume_from.md)
 - [mail_stats_type_volume_ip_t](docs/mail_stats_type_volume_ip.md)
 - [mail_stats_type_volume_to_t](docs/mail_stats_type_volume_to.md)
 - [send_mail_t](docs/send_mail.md)
 - [send_mail_adv_t](docs/send_mail_adv.md)


## Documentation for Authorization


Authentication schemes defined for the API:
### apiKeyAuth

- **Type**: API key

- **API key parameter name**: X-API-KEY
- **Location**: HTTP header


## Author

support@interserver.net

