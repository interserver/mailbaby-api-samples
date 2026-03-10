# MailBlockClickHouse
## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
| **date** | **date** | The date the block event was recorded. | [default to null] |
| **from** | **String** | The SMTP envelope sender (&#x60;MAIL FROM&#x60;) address of the blocked message. Pass this value as &#x60;email&#x60; to &#x60;POST /mail/blocks/delete&#x60; to delist it. | [default to null] |
| **subject** | **String** | The &#x60;Subject&#x60; header of the blocked message. | [default to null] |
| **to** | **String** | The serialized list of recipients of the blocked message. | [default to null] |
| **messageId** | **String** | The &#x60;Message-ID&#x60; header of the blocked message, or &#x60;null&#x60; if not present. | [optional] [default to null] |

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

