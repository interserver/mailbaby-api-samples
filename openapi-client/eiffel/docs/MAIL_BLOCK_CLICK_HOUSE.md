# MAIL_BLOCK_CLICK_HOUSE

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**date** | [**DATE**](DATE.md) | The date the block event was recorded. | [default to null]
**var_from** | [**STRING_32**](STRING_32.md) | The SMTP envelope sender (&#x60;MAIL FROM&#x60;) address of the blocked message. Pass this value as &#x60;email&#x60; to &#x60;POST /mail/blocks/delete&#x60; to delist it. | [default to null]
**message_id** | [**STRING_32**](STRING_32.md) | The &#x60;Message-ID&#x60; header of the blocked message, or &#x60;null&#x60; if not present. | [optional] [default to null]
**subject** | [**STRING_32**](STRING_32.md) | The &#x60;Subject&#x60; header of the blocked message. | [default to null]
**to** | [**STRING_32**](STRING_32.md) | The serialized list of recipients of the blocked message. | [default to null]

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


