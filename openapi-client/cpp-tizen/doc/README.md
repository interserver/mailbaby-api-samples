# Documentation for MailBaby Email Delivery and Management Service API 1.4.0 Tizen Client SDK

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
*addRuleSync* | *POST* /mail/rules | Creates a new email deny rule.
*addRuleASync* | *POST* /mail/rules | Creates a new email deny rule.
*deleteRuleSync* | *DELETE* /mail/rules/{ruleId} | Removes a deny mail rule.
*deleteRuleASync* | *DELETE* /mail/rules/{ruleId} | Removes a deny mail rule.
*delistBlockSync* | *POST* /mail/blocks/delete | Removes an email address from the block lists.
*delistBlockASync* | *POST* /mail/blocks/delete | Removes an email address from the block lists.
*getMailBlocksSync* | *GET* /mail/blocks | Displays a list of blocked email addresses.
*getMailBlocksASync* | *GET* /mail/blocks | Displays a list of blocked email addresses.
*getRulesSync* | *GET* /mail/rules | Displays a listing of deny email rules.
*getRulesASync* | *GET* /mail/rules | Displays a listing of deny email rules.


### HistoryManager
Method | HTTP request | Description
------------- | ------------- | -------------
*getStatsSync* | *GET* /mail/stats | Account usage statistics.
*getStatsASync* | *GET* /mail/stats | Account usage statistics.
*viewMailLogSync* | *GET* /mail/log | Displays the mail log.
*viewMailLogASync* | *GET* /mail/log | Displays the mail log.


### SendingManager
Method | HTTP request | Description
------------- | ------------- | -------------
*rawMailSync* | *POST* /mail/rawsend | Sends a raw RFC 822 email.
*rawMailASync* | *POST* /mail/rawsend | Sends a raw RFC 822 email.
*sendAdvMailSync* | *POST* /mail/advsend | Sends an Email with Advanced Options.
*sendAdvMailASync* | *POST* /mail/advsend | Sends an Email with Advanced Options.
*sendMailSync* | *POST* /mail/send | Sends an Email.
*sendMailASync* | *POST* /mail/send | Sends an Email.


### ServicesManager
Method | HTTP request | Description
------------- | ------------- | -------------
*getMailOrderByIdSync* | *GET* /mail/{id} | Displays details for a single mail order.
*getMailOrderByIdASync* | *GET* /mail/{id} | Displays details for a single mail order.
*getMailOrdersSync* | *GET* /mail | Displays a list of mail service orders.
*getMailOrdersASync* | *GET* /mail | Displays a list of mail service orders.


### StatusManager
Method | HTTP request | Description
------------- | ------------- | -------------
*pingServerSync* | *GET* /ping | Checks if the server is running.
*pingServerASync* | *GET* /ping | Checks if the server is running.


## What are the Model files for the data structures/objects?
Class | Description
------------- | -------------
 *DenyRuleNew* | The fields required to create a new email deny rule via `POST /mail/rules`. The `type` controls what `data` is matched against: - `email` — exact sender address match - `domain` — all senders from a domain - `destination` — exact recipient address match - `startswith` — sender local-part prefix match (alphanumeric + `+_.-` only)
 *DenyRuleRecord* | A complete deny rule record as returned by `GET /mail/rules`.  Combines the rule definition fields (`DenyRuleNew`) with server-assigned metadata (`id` and `created`).  The `id` value is required by `DELETE /mail/rules/{ruleId}`.
 *EmailAddressName* | An email contact with an optional display name.  Used in structured address fields (`from`, `to`, `cc`, `bcc`, `replyto`) in `SendMailAdv`.
 *EmailAddressParam* | A single email address parameter used as the body of `POST /mail/blocks/delete`.
 *EmailAddressTypes* | A flexible single email address that accepts either a plain address string, an RFC 822 named-address string (`\"Name <email>\"`), or a structured contact object.
 *EmailAddressesTypes* | A flexible email address list that accepts either a plain RFC 822 string or a structured array of contact objects.  When a string is provided it is parsed as a comma-separated list of RFC 822 addresses (supporting the `\"Name <email>\"` and bare `email` formats).  When an array is provided each entry must have at least an `email` field with an optional `name` field.
 *ErrorMessage* | The response body returned when an error occurs.
 *GenericResponse* | Standard success response returned by write operations (send, add rule, delete, etc.).  The `status` field is always `\"ok\"` on success.  The `text` field carries operation-specific data — for sending calls it contains the relay transaction ID; for create calls it contains the new record's ID; for delete calls it contains a confirmation string.
 *MailAttachment* | A file attachment for use with `POST /mail/advsend`.  The file content must be base64-encoded.  The `filename` is shown to recipients in their email client.
 *MailBlockClickHouse* | A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (`LOCAL_BL_RCPT` or `MBTRAP`). The `from` address can be passed to `POST /mail/blocks/delete` to delist it.
 *MailBlockRspamd* | A block pattern sourced from the rspamd database.  Represents a sender whose recent messages contained suspicious subject lines (e.g. containing relay/proxy strings) repeated more than 4 times in the last 3 days. The `from` address can be passed to `POST /mail/blocks/delete` to delist it.
 *MailBlocks* | The complete set of blocked addresses and message patterns returned by `GET /mail/blocks`.  Three independent block sources are combined into one response. Use `POST /mail/blocks/delete` with a `from` address from any entry to delist it.
 *MailLog* | Paginated mail log response returned by `GET /mail/log`.  Contains the full matched count (`total`) plus a page of `MailLogEntry` records.  Use `skip` and `limit` to page through large result sets.
 *MailLogEntry* | A single email record in the mail log.  Combines data from the message store (envelope metadata), the queue release table (delivery status and response), and the sender delivery table (MX routing details).  Key field relationships with other API calls: - The `id` field matches the `mailid` query parameter on `GET /mail/log` and   the `text` field of a successful send response. - The `from` address can be passed to `POST /mail/blocks/delete` to delist a   flagged sender. - The `user` field is the SMTP username (e.g. `mb5658`) corresponding to the   `username` field in `GET /mail` / `GET /mail/{id}`.
 *MailOrder* | A mail service order record.  Each order represents one provisioned sending account with a dedicated SMTP username.  The `id` is the numeric identifier used across most API calls.  The `username` is always `mb<id>` and is the SMTP AUTH username for `relay.mailbaby.net`.
 *MailOrderDetail* | Extended mail order record including the current SMTP password.  Returned by `GET /mail/{id}`.  The `username` and `password` fields can be used to authenticate directly against `relay.mailbaby.net:25` via SMTP AUTH if you prefer to send via a native SMTP client rather than the REST API.
 *MailStatsType* | Account usage statistics returned by `GET /mail/stats`.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.
 *MailStatsType_volume* | Top-500 breakdown of message counts grouped by source IP, destination address, and sender address within the selected `time` window.
 *SendMail* | Request body for `POST /mail/send`.  Sends a simple single-recipient message. HTML detection is automatic — if `body` contains HTML tags the message is sent as `text/html`; otherwise as `text/plain`.  The `from` address is automatically set as both the `From` and `Reply-To` headers.  For multiple recipients, CC/BCC, attachments, or per-field Reply-To control, use `POST /mail/advsend` instead.
 *SendMailAdv* | Request body for `POST /mail/advsend`.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (`from`, `to`, `replyto`, `cc`, `bcc`) each accept either a plain RFC 822 string (e.g. `\"Joe <joe@example.com>\"` or a comma-separated list) or a structured array of `{\"email\": \"...\", \"name\": \"...\"}` objects.  HTML detection is automatic based on whether `body` contains HTML tags.
 *SendMailRaw* | Request body for `POST /mail/rawsend`.  Accepts a complete RFC 822 message (all headers and body) as a verbatim string.  The relay injects it without modification, preserving any existing `DKIM-Signature` header intact.  The `From`, `To`, `Cc`, and `Bcc` addresses are extracted from the message headers automatically — you do not need to specify them separately.
 *SendMail_to* | The primary recipient address.  Accepts a single email address string or an array of email address strings for multiple recipients.

