# MailLogEntry

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **int** | internal db id | 
**id** | **str** | mail id | 
**_from** | **str** | from address | 
**to** | **str** | to address | 
**subject** | **str** | email subject | 
**message_id** | **str** | message id | 
**created** | **str** | creation date | 
**time** | **int** | creation timestamp | 
**user** | **str** | user account | 
**transtype** | **str** | transaction type | 
**transhost** | **str** | transaction host | 
**originhost** | **str** | origin host | 
**origin** | **str** | origin ip | 
**interface** | **str** | interface name | 
**_date** | **str** | date processed | 
**sending_zone** | **str** | sending zone | 
**body_size** | **int** | email body size in bytes | 
**source_md5** | **str** | md5 sum of the email | 
**seq** | **int** | delivery sequency | 
**domain** | **str** | to address domain | 
**recipient** | **str** | email receiver address | 
**locked** | **int** | locked status | 
**lock_time** | **int** | lock timestamp | 
**assigned** | **str** | assigned server | 
**queued** | **str** | queued timestamp | 
**lock** | **str** | lock id | 
**logger** | **str** | logger | 
**mx_port** | **int** | mx port number | 
**connection_key** | **str** | connection key | 
**mx_hostname** | **str** | mx hostname | 
**sent_body_hash** | **str** | body hash | 
**sent_body_size** | **int** | sent body size in bytes | 
**md5_match** | **int** | md5 checksum matching result | 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

