# MailLogEntry

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**_id** | **Integer** | internal db id | 
**id** | **String** | mail id | 
**from** | **String** | from address | 
**to** | **String** | to address | 
**subject** | **String** | email subject | 
**messageId** | **String** | message id |  [optional]
**created** | **String** | creation date | 
**time** | **Integer** | creation timestamp | 
**user** | **String** | user account | 
**transtype** | **String** | transaction type | 
**origin** | **String** | origin ip | 
**_interface** | **String** | interface name | 
**sendingZone** | **String** | sending zone | 
**bodySize** | **Integer** | email body size in bytes | 
**seq** | **Integer** | index of email in the to adderess list | 
**recipient** | **String** | to address this email is being sent to | 
**domain** | **String** | to address domain | 
**locked** | **Integer** | locked status | 
**lockTime** | **String** | lock timestamp | 
**assigned** | **String** | assigned server | 
**queued** | **String** | queued timestamp | 
**mxHostname** | **String** | mx hostname | 
**response** | **String** | mail delivery response | 
