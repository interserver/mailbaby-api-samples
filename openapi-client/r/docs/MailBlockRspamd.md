# openapi::MailBlockRspamd

A block pattern sourced from the rspamd database.  Represents a sender whose recent messages contained suspicious subject lines (e.g. containing relay/proxy strings) repeated more than 4 times in the last 3 days. The `from` address can be passed to `POST /mail/blocks/delete` to delist it.

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**from** | **character** | The sender email address.  Pass this value as &#x60;email&#x60; to &#x60;POST /mail/blocks/delete&#x60; to delist the sender. | 
**subject** | **character** | The suspicious subject pattern that triggered the block. | 


