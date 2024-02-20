# MailLogEntry

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**_id** | **i32** | internal db id | 
**id** | **String** | mail id | 
**from** | **String** | from address | 
**to** | **String** | to address | 
**subject** | **String** | email subject | 
**message_id** | Option<**String**> | message id | [optional]
**created** | **String** | creation date | 
**time** | **i32** | creation timestamp | 
**user** | **String** | user account | 
**transtype** | **String** | transaction type | 
**origin** | **String** | origin ip | 
**interface** | **String** | interface name | 
**sending_zone** | **String** | sending zone | 
**body_size** | **i32** | email body size in bytes | 
**seq** | **i32** | index of email in the to adderess list | 
**recipient** | **String** | to address this email is being sent to | 
**domain** | **String** | to address domain | 
**locked** | **i32** | locked status | 
**lock_time** | **String** | lock timestamp | 
**assigned** | **String** | assigned server | 
**queued** | **String** | queued timestamp | 
**mx_hostname** | **String** | mx hostname | 
**response** | **String** | mail delivery response | 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


