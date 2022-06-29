# MailLogEntry

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**_id** | **i32** | internal db id | 
**id** | **String** | mail id | 
**from** | **String** | from address | 
**to** | **String** | to address | 
**subject** | **String** | email subject | 
**message_id** | **String** | message id | 
**created** | **String** | creation date | 
**time** | **i32** | creation timestamp | 
**user** | **String** | user account | 
**transtype** | **String** | transaction type | 
**transhost** | **String** | transaction host | 
**originhost** | **String** | origin host | 
**origin** | **String** | origin ip | 
**interface** | **String** | interface name | 
**date** | **String** | date processed | 
**sending_zone** | **String** | sending zone | 
**body_size** | **i32** | email body size in bytes | 
**source_md5** | **String** | md5 sum of the email | 
**seq** | **i32** | delivery sequency | 
**domain** | **String** | to address domain | 
**recipient** | **String** | email receiver address | 
**locked** | **i32** | locked status | 
**lock_time** | **i32** | lock timestamp | 
**assigned** | **String** | assigned server | 
**queued** | **String** | queued timestamp | 
**_lock** | **String** | lock id | 
**logger** | **String** | logger | 
**mx_port** | **i32** | mx port number | 
**connection_key** | **String** | connection key | 
**mx_hostname** | **String** | mx hostname | 
**sent_body_hash** | **String** | body hash | 
**sent_body_size** | **i32** | sent body size in bytes | 
**md5_match** | **i32** | md5 checksum matching result | 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


