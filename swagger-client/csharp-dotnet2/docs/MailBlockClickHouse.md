# IO.Swagger.Model.MailBlockClickHouse
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Date** | **DateTime?** | The date the block event was recorded. | 
**From** | **string** | The SMTP envelope sender (&#x60;MAIL FROM&#x60;) address of the blocked message. Pass this value as &#x60;email&#x60; to &#x60;POST /mail/blocks/delete&#x60; to delist it. | 
**MessageId** | **string** | The &#x60;Message-ID&#x60; header of the blocked message, or &#x60;null&#x60; if not present. | [optional] 
**Subject** | **string** | The &#x60;Subject&#x60; header of the blocked message. | 
**To** | **string** | The serialized list of recipients of the blocked message. | 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

