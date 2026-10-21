
# Table `MailBlockRspamd`
(mapped from: MailBlockRspamd)

## Properties
Name | Mapping | SQL Type | Default | Type | Description | Notes
---- | ------- | -------- | ------- | ---- | ----------- | -----
**from** | from | text NOT NULL |  | **kotlin.String** | The sender email address.  Pass this value as &#x60;email&#x60; to &#x60;POST /mail/blocks/delete&#x60; to delist the sender. | 
**subject** | subject | text NOT NULL |  | **kotlin.String** | The suspicious subject pattern that triggered the block. | 




