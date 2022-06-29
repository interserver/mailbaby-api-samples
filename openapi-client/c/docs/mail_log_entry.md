# mail_log_entry_t

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**_id** | **int** | internal db id | 
**id** | **char \*** | mail id | 
**from** | **char \*** | from address | 
**to** | **char \*** | to address | 
**subject** | **char \*** | email subject | 
**message_id** | **char \*** | message id | 
**created** | **char \*** | creation date | 
**time** | **int** | creation timestamp | 
**user** | **char \*** | user account | 
**transtype** | **char \*** | transaction type | 
**transhost** | **char \*** | transaction host | 
**originhost** | **char \*** | origin host | 
**origin** | **char \*** | origin ip | 
**interface** | **char \*** | interface name | 
**date** | **char \*** | date processed | 
**sending_zone** | **char \*** | sending zone | 
**body_size** | **int** | email body size in bytes | 
**source_md5** | **char \*** | md5 sum of the email | 
**seq** | **int** | delivery sequency | 
**domain** | **char \*** | to address domain | 
**recipient** | **char \*** | email receiver address | 
**locked** | **int** | locked status | 
**lock_time** | **int** | lock timestamp | 
**assigned** | **char \*** | assigned server | 
**queued** | **char \*** | queued timestamp | 
**_lock** | **char \*** | lock id | 
**logger** | **char \*** | logger | 
**mx_port** | **int** | mx port number | 
**connection_key** | **char \*** | connection key | 
**mx_hostname** | **char \*** | mx hostname | 
**sent_body_hash** | **char \*** | body hash | 
**sent_body_size** | **int** | sent body size in bytes | 
**md5_match** | **int** | md5 checksum matching result | 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


