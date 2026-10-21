# MailBabyCsharp.Model.MailBlockClickHouse
A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (`LOCAL_BL_RCPT` or `MBTRAP`). The `from` address can be passed to `POST /mail/blocks/delete` to delist it.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Date** | **DateOnly** | The date the block event was recorded. | 
**From** | **string** | The SMTP envelope sender (&#x60;MAIL FROM&#x60;) address of the blocked message. Pass this value as &#x60;email&#x60; to &#x60;POST /mail/blocks/delete&#x60; to delist it. | 
**Subject** | **string** | The &#x60;Subject&#x60; header of the blocked message. | 
**To** | **string** | The serialized list of recipients of the blocked message. | 
**MessageId** | **string** | The &#x60;Message-ID&#x60; header of the blocked message, or &#x60;null&#x60; if not present. | [optional] 

[[Back to Model list]](../../README.md#documentation-for-models) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to README]](../../README.md)

