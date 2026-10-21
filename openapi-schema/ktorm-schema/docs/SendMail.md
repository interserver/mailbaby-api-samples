
# Table `SendMail`
(mapped from: SendMail)

## Properties
Name | Mapping | SQL Type | Default | Type | Description | Notes
---- | ------- | -------- | ------- | ---- | ----------- | -----
**to** | to | long NOT NULL |  | [**SendMailTo**](SendMailTo.md) |  |  [foreignkey]
**from** | from | text NOT NULL |  | **kotlin.String** | The sender address.  This is used as both the &#x60;From&#x60; header and the &#x60;Reply-To&#x60; header automatically.  Must be a valid email address authorized for your mail order. | 
**subject** | subject | text NOT NULL |  | **kotlin.String** | The subject line of the email. | 
**body** | body | text NOT NULL |  | **kotlin.String** | The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;. | 
**id** | id | long PRIMARY KEY AUTOINCREMENT |  | **kotlin.Long** | Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;. |  [optional]







