
# Table `MailBlockClickHouse`
(mapped from: MailBlockClickHouse)

## Properties
Name | Mapping | SQL Type | Default | Type | Description | Notes
---- | ------- | -------- | ------- | ---- | ----------- | -----
**date** | date | date NOT NULL |  | [**java.time.LocalDate**](java.time.LocalDate.md) | The date the block event was recorded. | 
**from** | from | text NOT NULL |  | **kotlin.String** | The SMTP envelope sender (&#x60;MAIL FROM&#x60;) address of the blocked message. Pass this value as &#x60;email&#x60; to &#x60;POST /mail/blocks/delete&#x60; to delist it. | 
**subject** | subject | text NOT NULL |  | **kotlin.String** | The &#x60;Subject&#x60; header of the blocked message. | 
**to** | to | text NOT NULL |  | **kotlin.String** | The serialized list of recipients of the blocked message. | 
**messageId** | messageId | text |  | **kotlin.String** | The &#x60;Message-ID&#x60; header of the blocked message, or &#x60;null&#x60; if not present. |  [optional]







