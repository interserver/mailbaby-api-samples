

# MailBlockRspamd

A block pattern sourced from the rspamd database.  Represents a sender whose recent messages contained suspicious subject lines (e.g. containing relay/proxy strings) repeated more than 4 times in the last 3 days. The `from` address can be passed to `POST /mail/blocks/delete` to delist it.

The class is defined in **[MailBlockRspamd.java](../../src/main/java/org/openapitools/model/MailBlockRspamd.java)**

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**from** | `String` | The sender email address.  Pass this value as &#x60;email&#x60; to &#x60;POST /mail/blocks/delete&#x60; to delist the sender. | 
**subject** | `String` | The suspicious subject pattern that triggered the block. | 




