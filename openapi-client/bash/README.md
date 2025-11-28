# MailBaby Email Delivery and Management Service API Bash client

## Overview

This is a Bash client script for accessing MailBaby Email Delivery and Management Service API service.

The script uses cURL underneath for making all REST calls.

## Usage

```shell
# Make sure the script has executable rights
$ chmod u+x 

# Print the list of operations available on the service
$ ./ -h

# Print the service description
$ ./ --about

# Print detailed information about specific operation
$ ./ <operationId> -h

# Make GET request
./ --host http://<hostname>:<port> --accept xml <operationId> <queryParam1>=<value1> <header_key1>:<header_value2>

# Make GET request using arbitrary curl options (must be passed before <operationId>) to an SSL service using username:password
 -k -sS --tlsv1.2 --host https://<hostname> -u <user>:<password> --accept xml <operationId> <queryParam1>=<value1> <header_key1>:<header_value2>

# Make POST request
$ echo '<body_content>' |  --host <hostname> --content-type json <operationId> -

# Make POST request with simple JSON content, e.g.:
# {
#   "key1": "value1",
#   "key2": "value2",
#   "key3": 23
# }
$ echo '<body_content>' |  --host <hostname> --content-type json <operationId> key1==value1 key2=value2 key3:=23 -

# Make POST request with form data
$  --host <hostname> <operationId> key1:=value1 key2:=value2 key3:=23

# Preview the cURL command without actually executing it
$  --host http://<hostname>:<port> --dry-run <operationid>

```

## Docker image

You can easily create a Docker image containing a preconfigured environment
for using the REST Bash client including working autocompletion and short
welcome message with basic instructions, using the generated Dockerfile:

```shell
docker build -t my-rest-client .
docker run -it my-rest-client
```

By default you will be logged into a Zsh environment which has much more
advanced auto completion, but you can switch to Bash, where basic autocompletion
is also available.

## Shell completion

### Bash

The generated bash-completion script can be either directly loaded to the current Bash session using:

```shell
source .bash-completion
```

Alternatively, the script can be copied to the `/etc/bash-completion.d` (or on OSX with Homebrew to `/usr/local/etc/bash-completion.d`):

```shell
sudo cp .bash-completion /etc/bash-completion.d/
```

#### OS X

On OSX you might need to install bash-completion using Homebrew:

```shell
brew install bash-completion
```

and add the following to the `~/.bashrc`:

```shell
if [ -f $(brew --prefix)/etc/bash_completion ]; then
  . $(brew --prefix)/etc/bash_completion
fi
```

### Zsh

In Zsh, the generated `_` Zsh completion file must be copied to one of the folders under `$FPATH` variable.

## Documentation for API Endpoints

All URIs are relative to **

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*BlockingApi* | [**addRule**](docs/BlockingApi.md#addrule) | **POST** /mail/rules | Creates a new email deny rule.
*BlockingApi* | [**deleteRule**](docs/BlockingApi.md#deleterule) | **DELETE** /mail/rules/{ruleId} | Removes an deny mail rule.
*BlockingApi* | [**delistBlock**](docs/BlockingApi.md#delistblock) | **POST** /mail/blocks/delete | Removes an email address from the blocked list
*BlockingApi* | [**getMailBlocks**](docs/BlockingApi.md#getmailblocks) | **GET** /mail/blocks | displays a list of blocked email addresses
*BlockingApi* | [**getRules**](docs/BlockingApi.md#getrules) | **GET** /mail/rules | Displays a listing of deny email rules.
*HistoryApi* | [**getStats**](docs/HistoryApi.md#getstats) | **GET** /mail/stats | Account usage statistics.
*HistoryApi* | [**viewMailLog**](docs/HistoryApi.md#viewmaillog) | **GET** /mail/log | displays the mail log
*SendingApi* | [**rawMail**](docs/SendingApi.md#rawmail) | **POST** /mail/rawsend | Sends a raw email
*SendingApi* | [**sendAdvMail**](docs/SendingApi.md#sendadvmail) | **POST** /mail/advsend | Sends an Email with Advanced Options
*SendingApi* | [**sendMail**](docs/SendingApi.md#sendmail) | **POST** /mail/send | Sends an Email
*ServicesApi* | [**getMailOrders**](docs/ServicesApi.md#getmailorders) | **GET** /mail | displays a list of mail service orders
*StatusApi* | [**pingServer**](docs/StatusApi.md#pingserver) | **GET** /ping | Checks if the server is running


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
 - [SendMailRaw](docs/SendMailRaw.md)


## Documentation For Authorization


## apiKeyAuth


- **Type**: API key
- **API key parameter name**: X-API-KEY
- **Location**: HTTP header

