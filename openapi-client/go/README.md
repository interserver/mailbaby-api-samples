# Go API client for openapi

**Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.**
# Overview
This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net).
# Authentication
In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site.
We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page.


## Overview
This API client was generated by the [OpenAPI Generator](https://openapi-generator.tech) project.  By using the [OpenAPI-spec](https://www.openapis.org/) from a remote server, you can easily generate an API client.

- API version: 1.1.0
- Package version: 1.0.0
- Generator version: 7.14.0-SNAPSHOT
- Build package: org.openapitools.codegen.languages.GoClientCodegen
For more information, please visit [https://www.mail.baby/contact/](https://www.mail.baby/contact/)

## Installation

Install the following dependencies:

```sh
go get github.com/stretchr/testify/assert
go get golang.org/x/net/context
```

Put the package under your project folder and add the following in import:

```go
import openapi "github.com/GIT_USER_ID/GIT_REPO_ID"
```

To use a proxy, set the environment variable `HTTP_PROXY`:

```go
os.Setenv("HTTP_PROXY", "http://proxy_name:proxy_port")
```

## Configuration of Server URL

Default configuration comes with `Servers` field that contains server objects as defined in the OpenAPI specification.

### Select Server Configuration

For using other server than the one defined on index 0 set context value `openapi.ContextServerIndex` of type `int`.

```go
ctx := context.WithValue(context.Background(), openapi.ContextServerIndex, 1)
```

### Templated Server URL

Templated server URL is formatted using default variables from configuration or from context value `openapi.ContextServerVariables` of type `map[string]string`.

```go
ctx := context.WithValue(context.Background(), openapi.ContextServerVariables, map[string]string{
	"basePath": "v2",
})
```

Note, enum values are always validated and all unused variables are silently ignored.

### URLs Configuration per Operation

Each operation can use different server URL defined using `OperationServers` map in the `Configuration`.
An operation is uniquely identified by `"{classname}Service.{nickname}"` string.
Similar rules for overriding default operation server index and variables applies by using `openapi.ContextOperationServerIndices` and `openapi.ContextOperationServerVariables` context maps.

```go
ctx := context.WithValue(context.Background(), openapi.ContextOperationServerIndices, map[string]int{
	"{classname}Service.{nickname}": 2,
})
ctx = context.WithValue(context.Background(), openapi.ContextOperationServerVariables, map[string]map[string]string{
	"{classname}Service.{nickname}": {
		"port": "8443",
	},
})
```

## Documentation for API Endpoints

All URIs are relative to *https://api.mailbaby.net*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*BlockingAPI* | [**AddRule**](docs/BlockingAPI.md#addrule) | **Post** /mail/rules | Creates a new email deny rule.
*BlockingAPI* | [**DeleteRule**](docs/BlockingAPI.md#deleterule) | **Delete** /mail/rules/{ruleId} | Removes an deny mail rule.
*BlockingAPI* | [**DelistBlock**](docs/BlockingAPI.md#delistblock) | **Post** /mail/blocks/delete | Removes an email address from the blocked list
*BlockingAPI* | [**GetMailBlocks**](docs/BlockingAPI.md#getmailblocks) | **Get** /mail/blocks | displays a list of blocked email addresses
*BlockingAPI* | [**GetRules**](docs/BlockingAPI.md#getrules) | **Get** /mail/rules | Displays a listing of deny email rules.
*HistoryAPI* | [**GetStats**](docs/HistoryAPI.md#getstats) | **Get** /mail/stats | Account usage statistics.
*HistoryAPI* | [**ViewMailLog**](docs/HistoryAPI.md#viewmaillog) | **Get** /mail/log | displays the mail log
*SendingAPI* | [**SendAdvMail**](docs/SendingAPI.md#sendadvmail) | **Post** /mail/advsend | Sends an Email with Advanced Options
*SendingAPI* | [**SendMail**](docs/SendingAPI.md#sendmail) | **Post** /mail/send | Sends an Email
*ServicesAPI* | [**GetMailOrders**](docs/ServicesAPI.md#getmailorders) | **Get** /mail | displays a list of mail service orders
*StatusAPI* | [**PingServer**](docs/StatusAPI.md#pingserver) | **Get** /ping | Checks if the server is running


## Documentation For Models

 - [DenyRuleNew](docs/DenyRuleNew.md)
 - [DenyRuleRecord](docs/DenyRuleRecord.md)
 - [EmailAddressName](docs/EmailAddressName.md)
 - [EmailAddressTypes](docs/EmailAddressTypes.md)
 - [EmailAddressesTypes](docs/EmailAddressesTypes.md)
 - [ErrorMessage](docs/ErrorMessage.md)
 - [GenericResponse](docs/GenericResponse.md)
 - [MailAttachment](docs/MailAttachment.md)
 - [MailBlockClickHouse](docs/MailBlockClickHouse.md)
 - [MailBlockRspamd](docs/MailBlockRspamd.md)
 - [MailBlocks](docs/MailBlocks.md)
 - [MailLog](docs/MailLog.md)
 - [MailLogEntry](docs/MailLogEntry.md)
 - [MailOrder](docs/MailOrder.md)
 - [MailStatsType](docs/MailStatsType.md)
 - [MailStatsTypeVolume](docs/MailStatsTypeVolume.md)
 - [MailStatsTypeVolumeFrom](docs/MailStatsTypeVolumeFrom.md)
 - [MailStatsTypeVolumeIp](docs/MailStatsTypeVolumeIp.md)
 - [MailStatsTypeVolumeTo](docs/MailStatsTypeVolumeTo.md)
 - [SendMail](docs/SendMail.md)
 - [SendMailAdv](docs/SendMailAdv.md)


## Documentation For Authorization


Authentication schemes defined for the API:
### apiKeyAuth

- **Type**: API key
- **API key parameter name**: X-API-KEY
- **Location**: HTTP header

Note, each API key must be added to a map of `map[string]APIKey` where the key is: apiKeyAuth and passed in as the auth context for each request.

Example

```go
auth := context.WithValue(
		context.Background(),
		openapi.ContextAPIKeys,
		map[string]openapi.APIKey{
			"apiKeyAuth": {Key: "API_KEY_STRING"},
		},
	)
r, err := client.Service.Operation(auth, args)
```


## Documentation for Utility Methods

Due to the fact that model structure members are all pointers, this package contains
a number of utility functions to easily obtain pointers to values of basic types.
Each of these functions takes a value of the given basic type and returns a pointer to it:

* `PtrBool`
* `PtrInt`
* `PtrInt32`
* `PtrInt64`
* `PtrFloat`
* `PtrFloat32`
* `PtrFloat64`
* `PtrString`
* `PtrTime`

## Author

support@interserver.net

