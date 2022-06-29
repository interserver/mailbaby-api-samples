# OpenAPIClient::Object::MailLogEntry

## Load the model package
```perl
use OpenAPIClient::Object::MailLogEntry;
```

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**_id** | **int** | internal db id | 
**id** | **string** | mail id | 
**from** | **string** | from address | 
**to** | **string** | to address | 
**subject** | **string** | email subject | 
**message_id** | **string** | message id | 
**created** | **string** | creation date | 
**time** | **int** | creation timestamp | 
**user** | **string** | user account | 
**transtype** | **string** | transaction type | 
**transhost** | **string** | transaction host | 
**originhost** | **string** | origin host | 
**origin** | **string** | origin ip | 
**interface** | **string** | interface name | 
**date** | **string** | date processed | 
**sending_zone** | **string** | sending zone | 
**body_size** | **int** | email body size in bytes | 
**source_md5** | **string** | md5 sum of the email | 
**seq** | **int** | delivery sequency | 
**domain** | **string** | to address domain | 
**recipient** | **string** | email receiver address | 
**locked** | **int** | locked status | 
**lock_time** | **int** | lock timestamp | 
**assigned** | **string** | assigned server | 
**queued** | **string** | queued timestamp | 
**_lock** | **string** | lock id | 
**logger** | **string** | logger | 
**mx_port** | **int** | mx port number | 
**connection_key** | **string** | connection key | 
**mx_hostname** | **string** | mx hostname | 
**sent_body_hash** | **string** | body hash | 
**sent_body_size** | **int** | sent body size in bytes | 
**md5_match** | **int** | md5 checksum matching result | 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


