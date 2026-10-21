# MailBlockClickHouse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**date** | [***chrono::naive::NaiveDate**](date.md) | The date the block event was recorded. | 
**from** | **String** | The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it. | 
**subject** | **String** | The `Subject` header of the blocked message. | 
**to** | **String** | The serialized list of recipients of the blocked message. | 
**message_id** | **swagger::Nullable<String>** | The `Message-ID` header of the blocked message, or `null` if not present. | [optional] [default to None]

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


