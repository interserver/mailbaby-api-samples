# MailBaby Email Delivery and Management Service API - Jetbrains API Client

## General API description

**Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.**  # Overview  This is the API interface to the [Mail Baby](https://mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net).  # Mail Orders  Every sending account in MailBaby is backed by a **Mail Order** — a provisioned sending credential with a numeric &#x60;id&#x60; and a corresponding SMTP username (&#x60;mb&lt;id&gt;&#x60;).  Most calls accept an optional &#x60;id&#x60; parameter; when omitted the API automatically selects the first active order on your account. Use &#x60;GET /mail&#x60; to list all orders, and &#x60;GET /mail/{id}&#x60; to inspect a single order including its current SMTP password.  # Sending Email  Three sending methods are available depending on your use-case: | Endpoint | Best for | |----------|----------| | &#x60;POST /mail/send&#x60; | Simple single-recipient messages | | &#x60;POST /mail/advsend&#x60; | Multiple recipients, CC/BCC, attachments, named contacts | | &#x60;POST /mail/rawsend&#x60; | Pre-built RFC 822 messages (e.g. DKIM-signed payloads) |  After a successful send each endpoint returns a &#x60;GenericResponse&#x60; whose &#x60;text&#x60; field contains the **transaction ID** assigned by the relay.  This ID can later be matched against entries in &#x60;GET /mail/log&#x60; via the &#x60;mailid&#x60; query parameter.  # Filtering &amp; Logs  &#x60;GET /mail/log&#x60; provides paginated access to every message accepted by the relay for your account.  Combine any of the query parameters to narrow results — e.g. &#x60;from&#x60;, &#x60;to&#x60;, &#x60;subject&#x60;, &#x60;messageId&#x60;, &#x60;origin&#x60;, &#x60;mx&#x60;, &#x60;startDate&#x60;/&#x60;endDate&#x60;, and &#x60;delivered&#x60;.  # Blocking  Two independent mechanisms exist for suppressing unwanted email: - **Block lists** (&#x60;GET /mail/blocks&#x60;, &#x60;POST /mail/blocks/delete&#x60;) — addresses flagged by the   system spam filters (LOCAL_BL_RCPT / MBTRAP rules in rspamd, and suspicious subjects). - **Deny rules** (&#x60;GET /mail/rules&#x60;, &#x60;POST /mail/rules&#x60;, &#x60;DELETE /mail/rules/{ruleId}&#x60;) —   custom rules you configure to reject specific senders, domains, destination addresses, or   subject-line prefixes before a message is even attempted.   # Authentication  In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. Pass your key in the &#x60;X-API-KEY&#x60; HTTP request header for every protected call. 

* API basepath : [https://api.mailbaby.net](https://api.mailbaby.net)
* Version : 1.4.0

## Documentation for API Endpoints

All URIs are relative to *https://api.mailbaby.net*, but will link to the `.http` file that contains the endpoint definition.
There may be multiple requests for a single endpoint, one for each example described in the OpenAPI specification.

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*BlockingApi* | [**addRule**](Apis/BlockingApi.http#addrule) | **POST** /mail/rules | Creates a new email deny rule
*BlockingApi* | [**deleteRule**](Apis/BlockingApi.http#deleterule) | **DELETE** /mail/rules/{ruleId} | Removes a deny mail rule
*BlockingApi* | [**delistBlock**](Apis/BlockingApi.http#delistblock) | **POST** /mail/blocks/delete | Removes an email address from the block lists
*BlockingApi* | [**getMailBlocks**](Apis/BlockingApi.http#getmailblocks) | **GET** /mail/blocks | Displays a list of blocked email addresses
*BlockingApi* | [**getRules**](Apis/BlockingApi.http#getrules) | **GET** /mail/rules | Displays a listing of deny email rules
*HistoryApi* | [**getStats**](Apis/HistoryApi.http#getstats) | **GET** /mail/stats | Account usage statistics
*HistoryApi* | [**viewMailLog**](Apis/HistoryApi.http#viewmaillog) | **GET** /mail/log | Displays the mail log
*SendingApi* | [**rawMail**](Apis/SendingApi.http#rawmail) | **POST** /mail/rawsend | Sends a raw RFC 822 email
*SendingApi* | [**sendAdvMail**](Apis/SendingApi.http#sendadvmail) | **POST** /mail/advsend | Sends an Email with Advanced Options
*SendingApi* | [**sendMail**](Apis/SendingApi.http#sendmail) | **POST** /mail/send | Sends an Email
*ServicesApi* | [**getMailOrderById**](Apis/ServicesApi.http#getmailorderbyid) | **GET** /mail/{id} | Displays details for a single mail order
*ServicesApi* | [**getMailOrders**](Apis/ServicesApi.http#getmailorders) | **GET** /mail | Displays a list of mail service orders
*StatusApi* | [**pingServer**](Apis/StatusApi.http#pingserver) | **GET** /ping | Checks if the server is running


## Usage

### Prerequisites

You need [IntelliJ](https://www.jetbrains.com/idea/) to be able to run those queries. More information can be found [here](https://www.jetbrains.com/help/idea/http-client-in-product-code-editor.html).
You may have some luck running queries using the [Code REST Client](https://marketplace.visualstudio.com/items?itemName=humao.rest-client) as well, but your mileage may vary.

### Variables and Environment files

* Generally speaking, you want queries to be specific using custom variables. All variables in the `.http` files have the `` format.
* You can create [public or private environment files](https://www.jetbrains.com/help/idea/exploring-http-syntax.html#environment-variables) to dynamically replace the variables at runtime.

_Note: don't commit private environment files! They typically will contain sensitive information like API Keys._

### Customizations

If you have control over the generation of the files here, there are two main things you can do

* Select elements to replace as variables during generation. The process is case-sensitive. For example, API_KEY -> 
    * For this, run the generation with the `bodyVariables` property, followed by a "-" separated list of variables
    * Example: `--additional-properties bodyVariables=YOUR_MERCHANT_ACCOUNT-YOUR_COMPANY_ACCOUNT-YOUR_BALANCE_PLATFORM`
* Add custom headers to _all_ requests. This can be useful for example if your specifications are missing [security schemes](https://github.com/github/rest-api-description/issues/237).
    * For this, run the generation with the `customHeaders` property, followed by a "&" separated list of variables
    * Example : `--additional-properties=customHeaders="Cookie:X-API-KEY="&"Accept-Encoding=gzip"`

_This client was generated by the [jetbrains-http-client](https://openapi-generator.tech/docs/generators/jetbrains-http-client) generator of OpenAPI Generator_