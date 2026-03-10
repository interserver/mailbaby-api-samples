# MailBlockClickHouse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**date** | [**java.time.LocalDate**](java.time.LocalDate.md) | The date the block event was recorded. | 
**from** | [**kotlin.String**](.md) | The SMTP envelope sender (&#x60;MAIL FROM&#x60;) address of the blocked message. Pass this value as &#x60;email&#x60; to &#x60;POST /mail/blocks/delete&#x60; to delist it. | 
**messageId** | [**kotlin.String**](.md) | The &#x60;Message-ID&#x60; header of the blocked message, or &#x60;null&#x60; if not present. |  [optional]
**subject** | [**kotlin.String**](.md) | The &#x60;Subject&#x60; header of the blocked message. | 
**to** | [**kotlin.String**](.md) | The serialized list of recipients of the blocked message. | 
