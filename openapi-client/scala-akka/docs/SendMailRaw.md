

# SendMailRaw

Request body for `POST /mail/rawsend`.  Accepts a complete RFC 822 message (all headers and body) as a verbatim string.  The relay injects it without modification, preserving any existing `DKIM-Signature` header intact.  The `From`, `To`, `Cc`, and `Bcc` addresses are extracted from the message headers automatically — you do not need to specify them separately.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**raw_email** | **String** | The complete RFC 822 email message including all headers and the body. Must include at minimum &#x60;From&#x60;, &#x60;To&#x60;, &#x60;Subject&#x60;, &#x60;Date&#x60;, and &#x60;MIME-Version&#x60; headers.  DKIM signatures in the &#x60;DKIM-Signature&#x60; header are transmitted verbatim and will pass verification at the destination. | 
**id** | **Long** | Optional numeric ID of the mail order to use for SMTP authentication. If omitted the first active order on your account is used.  Valid IDs are returned by &#x60;GET /mail&#x60;. |  [optional]



