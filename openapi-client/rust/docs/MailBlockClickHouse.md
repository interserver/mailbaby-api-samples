# MailBlockClickHouse

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**date** | [**String**](String.md) | The date the block event was recorded. | 
**from** | **String** | The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it. | 
**message_id** | Option<**String**> | The `Message-ID` header of the blocked message, or `null` if not present. | [optional]
**subject** | **String** | The `Subject` header of the blocked message. | 
**to** | **String** | The serialized list of recipients of the blocked message. | 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


